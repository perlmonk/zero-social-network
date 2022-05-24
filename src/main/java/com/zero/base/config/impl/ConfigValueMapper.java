package com.zero.base.config.impl;

/**
 * @param <S> 原始格式
 */
public interface ConfigValueMapper<S> {
    /**
     * @param rawValue
     * @param type
     * @param <V>      目标格式
     * @return
     */
    <V> V map(S rawValue, Class<V> type);
}
