package com.zero.base.config.impl.zk;

import com.zero.base.config.impl.AbstractConfigDict;
import com.zero.base.config.impl.ConfigValueMapper;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.Map;

/**
 * 基于Zookeeper的配置实现
 */
public class ConfigDictByZookeeper extends AbstractConfigDict<String> {

    private final ZooKeeper zk;
    private final String rootNode;

    private final ConfigValueMapper<String> configValueMapper;

    private Map<String, String> configMap;

    public ConfigDictByZookeeper(String connectionString, int sessionTimeOut, String rootNode) {
        this.rootNode = rootNode;
        this.zk = new ZooKeeper(connectionString, sessionTimeOut, new Watcher() {
            public void process(WatchedEvent event) {
                // TODO reload
            }
        });
    }

    @Override
    protected String getRawValue(String keyName) {
        return configMap.get(keyName);
    }

    @Override
    protected ConfigValueMapper<String> getValueMapper() {
        return configValueMapper;
    }
}
