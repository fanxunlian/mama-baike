package com.mama.baike.common;

public class ResultBody {

    /**
     * 公共编码
     */
    //成功
    public static final int SUCCESS  = 200;
    //未知异常
    public static final int ERROR_EXCEPTION  = 500;
    //接口不存在
    public static final int ERROR_NOT_FOUND  = 404;
    //无权限访问
    public static final int ERROR_NOT_AUTH  = 403;
    //无权限访问
    public static final int ERROR_TOKEN  = 101;
    //签名错误
    public static final int ERROR_SIGN  = 102;
    //解密错误
    public static final int ERROR_DECRYPT  = 103;
    //更新失败
    public static final int ERROR_UPDATE  = 104;
    //删除失败
    public static final int ERROR_DELETE  = 105;
    //审核失败
    public static final int ERROR_VERIFY  = 106;
    //存管返回错误
    public static final int ERROR_XAC_BANK  = 600;
    //存管操作异常
    public static final int ERROR_XAC_BANK_EXCEPTION = 601;
    //查询企业认证
    public static final int COMPANY_IS_NOT_AUTH = 701;


    private Integer code;
    private String message;
    private Object data;
    private Boolean isSuccess;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        if(this.code == 200)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public ResultBody()
    {
        setCode(200);
        setMessage("success");
    }
}
