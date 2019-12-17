package cn.roilat.framework.util;

import cn.roilat.framework.common.result.CommonResult;

public class RestApiUtils {
    public static CommonResult<?> build404Response(){
        return new CommonResult<>("", false, null);
    }
}
