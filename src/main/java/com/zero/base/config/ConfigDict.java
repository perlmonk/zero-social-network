package com.zero.base.config;

/**
 * 封装配置的统一访问
 * 建议一个"业务"维度一个字典
 * 字典本身无强类型限制，具体类型限制加在每个key上
 * 子类需要确保：
 * 实例化后，配置可以正常读取
 *
 * @see <a href="https://gx5okw1m9s.feishu.cn/docs/doccnUPIAnFGWCsXbYd9WmpD5ch">https://gx5okw1m9s.feishu.cn/docs/doccnUPIAnFGWCsXbYd9WmpD5ch</a>
 */
public interface ConfigDict {

    /**
     * 获取指定配置的值
     *
     * @param key 配置名称
     * @param <V> 返回值类型
     * @return 返回值，如果没有找到配置，返回默认值(ConfigKey提供)
     */
    <V> V get(ConfigKey<V> key);
}
