package com.zero.base.config;

/**
 * 约束key类型
 *
 * @param <T>
 */
public interface ConfigKey<T> {

    T getType();

    T getDefaultValue();
}
