package com.zero.base.config;

/**
 * 封装配置的统一访问
 * 建议一个"业务"维度一个字典
 *
 * @see <a href="https://gx5okw1m9s.feishu.cn/docs/doccnUPIAnFGWCsXbYd9WmpD5ch">https://gx5okw1m9s.feishu.cn/docs/doccnUPIAnFGWCsXbYd9WmpD5ch</a>
 */
public interface ConfigDict {
    /**
     * 获取指定配置的值
     *
     * @param key 配置名称
     * @param <T> 返回值类型
     * @return 返回值，如果没有找到配置，返回默认值(ConfigKey提供)
     */
    <T> T get(ConfigKey<T> key);
}
