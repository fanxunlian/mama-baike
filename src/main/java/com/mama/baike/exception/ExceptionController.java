package com.mama.baike.exception;


import com.mama.baike.common.ResultBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * 重写ErrorController,主要负责系统的异常页面的处理以及错误信息的显示
 * GlobalException除外无法捕捉的异常处理 
 * @author chenyingyi
 */
@Controller
@RequestMapping(value = "error")
@EnableConfigurationProperties({ServerProperties.class})
public class ExceptionController implements ErrorController {

  private ErrorAttributes errorAttributes;

  @Autowired
  private ServerProperties serverProperties;


  /**
   * 初始化ExceptionController
   */
  @Autowired
  public ExceptionController(ErrorAttributes errorAttributes) {
    Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
    this.errorAttributes = errorAttributes;
  }

 
  /**
   * 定义400的错误JSON信息
   * @param request
   * @return
   */
  @RequestMapping(value = "400")
  @ResponseBody
  public ResultBody error400(HttpServletRequest request) {
      Map<String, Object> body = getErrorAttributes(request,
              isIncludeStackTrace(request, MediaType.TEXT_HTML));
      HttpStatus status = getStatus(request);

     Map<String, Object> errors = getErrorAttributes(request,
        isIncludeStackTrace(request, MediaType.TEXT_HTML));
      ResultBody res = new ResultBody();
      res.setCode((int)errors.get("status"));
      res.setMessage((String) errors.get("message"));
      res.setData(null);
      return res;
  }
  
  
  /**
   * 定义500的错误JSON信息
   * @param request
   * @return
   */
  @RequestMapping(value = "500")
  @ResponseBody
  public ResultBody error500(HttpServletRequest request) {

     Map<String, Object> errors = getErrorAttributes(request,
        isIncludeStackTrace(request, MediaType.TEXT_HTML));
    ResultBody res = new ResultBody();
      res.setCode((int)errors.get("status"));
      res.setData(null);
      res.setMessage((String) errors.get("message"));
      return res;
  }


  /**
   * Determine if the stacktrace attribute should be included.
   * @param request the source request
   * @param produces the media type produced (or {@code MediaType.ALL})
   * @return if the stacktrace attribute should be included
   */
  protected boolean isIncludeStackTrace(HttpServletRequest request,
                     MediaType produces) {
    ErrorProperties.IncludeStacktrace include = this.serverProperties.getError().getIncludeStacktrace();
    if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
      return true;
    }
    if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
      return getTraceParameter(request);
    }
    return false;
  }


  /**
   * 获取错误的信息
   */
  private Map<String, Object> getErrorAttributes(HttpServletRequest request,
                          boolean includeStackTrace) {
    RequestAttributes requestAttributes = new ServletRequestAttributes(request);
    return this.errorAttributes.getErrorAttributes(requestAttributes,
        includeStackTrace);
  }

  /**
   * 是否包含trace
   * @param request
   * @return
   */
  private boolean getTraceParameter(HttpServletRequest request) {
    String parameter = request.getParameter("trace");
    if (parameter == null) {
      return false;
    }
    return !"false".equals(parameter.toLowerCase());
  }

  /**
   * 获取错误编码
   * @param request
   * @return
   */
  private HttpStatus getStatus(HttpServletRequest request) {
    Integer statusCode = (Integer) request
        .getAttribute("javax.servlet.error.status_code");
    if (statusCode == null) {
      return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    try {
      return HttpStatus.valueOf(statusCode);
    }
    catch (Exception ex) {
      return HttpStatus.INTERNAL_SERVER_ERROR;
    }
  }

  /**
   * 实现错误路径,暂时无用
   * @see ExceptionMvcAutoConfiguration#containerCustomizer()
   * @return
   */
  @Override
  public String getErrorPath() {
    return "";
  }

}