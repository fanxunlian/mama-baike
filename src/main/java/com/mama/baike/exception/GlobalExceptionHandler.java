package com.mama.baike.exception;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import com.mama.baike.common.ResultBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 异常处理器
 * 
 * @author chenzhenyi
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 自定义异常
	 */
	@ExceptionHandler(GlobalException.class)
	public ModelAndView handleGlobalException(GlobalException e){
		
		ModelAndView mav = new ModelAndView("error/500");
		mav.addObject("errors", e.getMessage());    
		return mav; 
	}
	
	@ExceptionHandler(GlobalRestException.class)
	@ResponseBody
	public ResultBody  handleGlobalRestException(GlobalRestException e){
		ResultBody apiResponse = new ResultBody();
		apiResponse.setCode(e.getCode());
		apiResponse.setMessage(e.getMessage());
		return apiResponse;
	}
	
	@ExceptionHandler(IncorrectCredentialsException.class)
	@ResponseBody
	public ResultBody handleGlobalRestIncorrectCredentialsException(IncorrectCredentialsException e){
		ResultBody apiResponse = new ResultBody();
		apiResponse.setCode(ResultBody.ERROR_NOT_AUTH);
		apiResponse.setMessage(e.getMessage());
		return apiResponse;
	}
	
	@ExceptionHandler(LockedAccountException.class)
	@ResponseBody
	public ResultBody handleGlobalRestLockedAccountException(LockedAccountException e){
		ResultBody apiResponse = new ResultBody();
		apiResponse.setCode(ResultBody.ERROR_NOT_AUTH);
		apiResponse.setMessage(e.getMessage());
		return apiResponse;
	}
	
	
	@ExceptionHandler(AuthenticationException.class)
	@ResponseBody
	public ResultBody handleGlobalRestAuthenticationException(AuthenticationException e){
		ResultBody apiResponse = new ResultBody();
		apiResponse.setCode(ResultBody.ERROR_NOT_AUTH);
		apiResponse.setMessage(e.getMessage());
		return apiResponse;
	}
	
	
	@ExceptionHandler(DuplicateKeyException.class)
	@ResponseBody
	public ResultBody handleDuplicateKeyException(DuplicateKeyException e){

		ResultBody apiResponse = new ResultBody();
		apiResponse.setCode(ResultBody.ERROR_NOT_FOUND);
		apiResponse.setMessage(e.getMessage());
		return apiResponse;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseBody
	public ResultBody handleNotFoundException(NoHandlerFoundException e)   {

		ResultBody apiResponse = new ResultBody();
		apiResponse.setCode(ResultBody.ERROR_NOT_FOUND);
		apiResponse.setMessage(e.getMessage());
		return apiResponse;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResultBody handleException(Exception e){
		logger.error(e.getMessage(), e);
		
		ResultBody apiResponse = new ResultBody();
		apiResponse.setCode(ResultBody.ERROR_EXCEPTION);
		apiResponse.setMessage(e.getMessage());
		return apiResponse;
	}
	
	
}
