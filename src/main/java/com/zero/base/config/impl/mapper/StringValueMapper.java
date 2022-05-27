package com.zero.base.config.impl.mapper;

import com.zero.base.config.ValueCastException;
import com.zero.base.config.impl.ConfigValueMapper;

/**
 * 字符串转
 */
public class StringValueMapper implements ConfigValueMapper<String> {
    public <V> V map(String rawValue, Class<V> type) throws ValueCastException {
        throw new UnsupportedOperationException();
    }
}
