package com.zero.base.config.impl.zk;

import com.zero.base.config.ConfigDict;
import com.zero.base.config.ConfigKey;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 *
 */
enum DatabaseUrlKeys implements ConfigKey<String> {
    User("user"),
    ;

    private final String name;

    DatabaseUrlKeys(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<String> getValueType() {
        return String.class;
    }

    @Override
    public String getDefaultValue() {
        return null;
    }
}

public class ConfigDictByZookeeperTest extends TestCase {

    private ConfigDict configDict;

    public void setUp() throws Exception {
        String connectionString = "127.0.0.1:2181";
        long timeOut = TimeUnit.MINUTES.toMillis(1);
        String rootPath = "/database";
        configDict = new ConfigDictByZookeeper(connectionString, timeOut, rootPath);
    }


    @Test
    public void test() {
        String userUrl = configDict.get(DatabaseUrlKeys.User);
    }
}