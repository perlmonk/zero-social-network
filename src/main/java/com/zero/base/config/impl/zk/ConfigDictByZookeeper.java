package com.zero.base.config.impl.zk;

import com.zero.base.config.impl.AbstractConfigDict;
import com.zero.base.config.impl.ConfigValueMapper;
import com.zero.base.config.impl.mapper.StringValueMapper;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 基于Zookeeper的配置实现
 */
public class ConfigDictByZookeeper extends AbstractConfigDict<String> {

    private static final Logger logger = LoggerFactory.getLogger(ConfigDictByZookeeper.class);

    private final ZooKeeper zk;
    private final String rootPath;

    private final ConfigValueMapper<String> configValueMapper;

    private Map<String, String> configMap;

    private boolean init = false;

    private CountDownLatch latch;

    /**
     * 连接到给定的zk路径，读取配置
     *
     * @param connectionString
     * @param sessionTimeOutMillis
     * @param rootPath
     * @throws IOException
     * @throws IllegalStateException 其它读取失败
     */
    public ConfigDictByZookeeper(String connectionString, long sessionTimeOutMillis, String rootPath) throws IOException {
        this.rootPath = rootPath;
        this.configValueMapper = new StringValueMapper();
        logger.info("开始连接zk: {}, 配置: {}", connectionString, rootPath);
        this.zk = new ZooKeeper(connectionString, (int) sessionTimeOutMillis, event -> {
            // TODO 连接成功；节点变更触发 init
        });
        logger.info("连接zk完成，配置: {}，等待初始化……", rootPath);
        try {
            // zk数据读取是异步的，需要加入等待机制
            latch = new CountDownLatch(1);
            latch.await(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new IllegalStateException("配置读取失败: " + rootPath, e);
        }
    }

    private void init() {
        try {
            logger.info("开始读取新配置: {}", rootPath);
            List<String> children = zk.getChildren(rootPath, true);
            Map<String, String> newConfigData = new HashMap<>();

            for (String child : children) {
                logger.debug("child of {}: {}", rootPath, child);
                Stat stat = new Stat();
                byte[] data = zk.getData(rootPath + "/" + child, true, stat);
                if (data != null) {
                    newConfigData.put(child, new String(data));
                }
            }
            configMap = Collections.unmodifiableMap(newConfigData);
            latch.countDown();
            logger.info("读取新配置完成: {}", rootPath);
        } catch (KeeperException | InterruptedException ex) {
            throw new IllegalStateException("读取配置失败", ex);
        }
    }

    @Override
    protected String getRawValue(String keyName) {
        if (!init) {
            throw new IllegalStateException("配置未初始化完成");
        }
        return configMap.get(keyName);
    }

    @Override
    protected ConfigValueMapper<String> getValueMapper() {
        return configValueMapper;
    }
}
