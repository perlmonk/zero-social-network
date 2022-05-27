package com.zero.base.config.impl;

import com.zero.base.config.ValueCastException;

/**
 * @param <S> 原始格式
 */
public interface ConfigValueMapper<S> {
    /**
     * @param rawValue
     * @param type
     * @param <V>      目标格式
     * @return
     * @throws ValueCastException 值转换出错
     */
    <V> V map(S rawValue, Class<V> type) throws ValueCastException;
}
