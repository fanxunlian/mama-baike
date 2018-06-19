package com.mama.baike.common.utils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    /**日期格式yyyy-MM-dd*/
    private static String REGEX_DATE = "^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}$";//
    public static JSONObject formatError(List<FieldError> errors) throws JSONException {
        JSONObject wrap = new JSONObject();
        JSONObject jsonObject= new JSONObject();
        for(FieldError fieldError:errors)
            jsonObject.put(fieldError.getField(),fieldError.getDefaultMessage());
        wrap.put("errors", jsonObject);
        return wrap;
    }

    /**
     * 校验输入日期格式是否正确
     * @param date 要验证的日期
     * @return
     */
    public static boolean isDate(String date){
        Pattern p = Pattern.compile(REGEX_DATE);
        Matcher m = p.matcher(date);
        return m.find();
    }

    public static void main(String[] args ){
        System.out.println(ValidationUtil.isDate("2018-03-27"));
    }
}
