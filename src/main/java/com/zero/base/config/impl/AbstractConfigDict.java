package com.zero.base.config.impl;

import com.zero.base.config.ConfigDict;
import com.zero.base.config.ConfigKey;

/**
 * @param <S> 底层实现的实际类型
 */
public abstract class AbstractConfigDict<S> implements ConfigDict {

    /**
     * 返回底层保存的原始值
     * @return 有值原样返回；无值返回null(例如：对于String不要返回空字符串)
     */
    protected abstract S getRawValue(String keyName);

    /**
     * 返回值映射工具
     * @return 单例
     */
    protected abstract ConfigValueMapper<S> getValueMapper();

    public <V> V get(ConfigKey<V> key) {
        S rawValue = getRawValue(key.getName());
        if (rawValue == null) {
            return key.getDefaultValue();
        }
        return getValueMapper().map(rawValue, key.getValueType());
    }
}
