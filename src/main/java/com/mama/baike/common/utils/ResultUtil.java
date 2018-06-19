package com.mama.baike.common.utils;


import com.mama.baike.common.ResultBody;

public class ResultUtil {

    /**
     * 请求成功，返回信息（带数据）
     *
     * @param object 返回的数据信息
     * @return
     */
    public static ResultBody success(Object object) {
        ResultBody result = new ResultBody();
        result.setCode(200);
        result.setMessage("成功");
        result.setData(object);

        return result;
    }

    /**
     * 请求成功，返回信息（不带数据）
     *
     * @return
     */
    public static ResultBody success() {
        return success(null);
    }

    /**
     * 请求失败，返回错误码及错误信息
     *
     * @param code 错误码
     * @param msg  错误信息
     * @return
     */
    public static ResultBody error(Integer code, String msg) {
        ResultBody result = new ResultBody();
        result.setCode(code);
        result.setMessage(msg);

        return result;
    }
}
