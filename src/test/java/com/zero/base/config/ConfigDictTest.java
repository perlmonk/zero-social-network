package com.zero.base.config;

import org.junit.jupiter.api.Test;

import java.util.List;

final class TestKeys {
    static ConfigKey<Long> LONG_KEY;
    static ConfigKey<String> STRING_KEY;
    static ConfigKey<List<Long>> LONG_LIST_KEY;
    // TODO 某种途径实例化

    protected TestKeys() {
    }
}
class ConfigDictTest {

    @Test
    void get() {
        ConfigDict configDict = null; // TODO 某种途径实例化
        Long longValue = configDict.get(TestKeys.LONG_KEY);
        String stringValue=  configDict.get(TestKeys.STRING_KEY);
        List<Long> longValues = configDict.get(TestKeys.LONG_LIST_KEY);
    }
}