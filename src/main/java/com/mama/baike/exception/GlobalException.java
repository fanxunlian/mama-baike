package com.mama.baike.exception;

/**
 * 自定义异常
 * 
 * @author chenzhenyi
 */
public class GlobalException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    
    public GlobalException(String message) {
		super(message);
	}
	
	public GlobalException(String message, Throwable e) {
		super(message, e);
	}
	
		
}
