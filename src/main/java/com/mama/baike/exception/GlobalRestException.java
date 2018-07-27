package com.mama.baike.exception;

/**
 * 自定义异常rest
 * 
 * @author chenyingyi
 */
public class GlobalRestException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String message;
    private int code = 500;
    
    public GlobalRestException(String message) {
		super(message);
		this.message = message;
	}
	
	public GlobalRestException(String message, Throwable e) {
		super(message, e);
		this.message = message;
	}
	
	public GlobalRestException(String message, int code) {
		super(message);
		this.message = message;
		this.code = code;
	}
	
	public GlobalRestException(String message, int code, Throwable e) {
		super(message, e);
		this.message = message;
		this.code = code;
	}

	public String getmessage() {
		return message;
	}

	public void setmessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
