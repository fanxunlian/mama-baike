package com.mama.baike.common;

public class ResultBody {
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
