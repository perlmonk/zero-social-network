package com.zero.base.config;

/**
 * 约束key和值类型为一对
 *
 * @param <V> 返回值类型
 */
public interface ConfigKey<V> {

    /**
     * key名称
     */
    String getName();

    Class<V> getValueType();

    V getDefaultValue();
}
