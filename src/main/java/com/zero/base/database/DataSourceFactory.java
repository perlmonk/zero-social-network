package com.zero.base.database;

import com.zaxxer.hikari.HikariDataSource;
import com.zero.base.config.ConfigDict;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据源管理
 */
public class DataSourceFactory {

    private final ConfigDict configDict;
    private final Map<DatabaseUrlKey, DataSource> dataSourceMap;

    public DataSourceFactory(ConfigDict configDict) {
        this.configDict = configDict;
        this.dataSourceMap = new ConcurrentHashMap<>();
    }

    public DataSource get(DatabaseUrlKey key) {
        DataSource ds = dataSourceMap.get(key);
        if (ds == null) {
            synchronized (key.name().intern()) {
                ds = dataSourceMap.get(key);
                if (ds == null) {
                    ds = new InnerDataSource(() -> configDict.get(key));
                    dataSourceMap.put(key, ds);
                }
            }
        }
        return ds;
    }
}
