package com.go.after.common.utils;

/**
 * Create on 2018/12/27 on Dong
 *
 * @author Dong
 * @describe 用于处理CUD 是否成功
 */
public class SqlHelper {

    /**
     * 判断该操作是否成功!
     * cudBool:为增删改
     * CreateBool
     * UpdateBool
     * DeleteBool
     *
     * @param result
     * @return
     */
    public static boolean cudBool(Integer result) {
        return null != result && result > 0;
    }

}
