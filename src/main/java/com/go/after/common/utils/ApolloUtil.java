package com.go.after.common.utils;

import com.ctrip.framework.apollo.Config;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: dong
 * @description:Apollo分布式配置中心读取配置文件,从而获取key-Value
 * @date: Create in 13:03 2019/1/4
 */
@Slf4j
public class ApolloUtil {


    /**
     * 通过Config对象,key 获得值
     *
     * @param config
     * @param key
     * @return
     */
    public static String getKeyToValue(Config config, String key) {
        if (null == config) {
            return "Config为Null,请输入正确的NameSpace!";
        }
        final String property = config.getProperty(key, null);
        //如果没找到则打印日志提醒未通过该Key找到Value
        if (null == property) {
            log.info("未找到:{}", key);
        }
        return property;
    }

}
