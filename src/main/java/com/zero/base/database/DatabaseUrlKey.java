package com.zero.base.database;

import com.zero.base.config.ConfigKey;

/**
 * 数据库Url配置
 */
public enum DatabaseUrlKey implements ConfigKey<String> {
    Auth("auth"),
    User("user"),
    ;

    private final String name;

    DatabaseUrlKey(String name) {
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
