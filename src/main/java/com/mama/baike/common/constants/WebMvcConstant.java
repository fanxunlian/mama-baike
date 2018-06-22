package com.mama.baike.common.constants;

/**
 * MVC web常量
 * 
 * @author chenyingyi
 */
public class WebMvcConstant {



    private WebMvcConstant() {
	} // Prevents instantiation

	// session 用户id键
	public static final String LOGIN_USER_SESSION_KEY = "loginUserId";
	// session 用户名称
	public static final String LOGIN_USERNAME_SESSION = "loginUserName";
	// session
	public static final String APP_LOGIN_USER_TOKEN_KEY = "appLoginUserId";
	// session 用户名称
	public static final String LOGIN_USERTYPE_SESSION = "loginUserType";
	// session 用户手机号
	public static final String LOGIN_MOBILE_SESSION = "loginUserMobile";
	// session 用户名称
	public static final String LOGIN_NAME_SESSION = "loginName";
	// redis 用户id键
	public static final String LOGIN_USER_TOKEN_KEY = "loginUserId";
	// redis 验证码键
	public static final String VERIFY_CODE_KEY = "verifyCode";
	// redis 图形验证码键
	public static final String CAPTCHA_SESSION_KEY = "captchaText";
	// redis 图形验证码计数键
	public static final String CAPTCHA_COUNT_KEY = "captchaCount";
	// redis 短信验证码输入错误计数键
	public static final String VERIFY_CODE_ERROR_COUNT_KEY = "verifyCodeErrorCount";
	// redis 数据字典键
	public static final String DICTIONARY_KEY = "dictionary";
	// redis 钱包数据字典按状态分类键
	public static final String WALLET_RECORD_TYPE_STATUS = "wallet-record-type-status";
	// redis 一账通登录标识
	public static final String LOGIN_USER_ONE_ACCOUNT_TOKEN_KEY = "login-user-one-account-token-key";
	// session 忘记密码用户类型
	public static final String FORGET_PASSWORD_USERTYP = "forget-password-usertype";
	// session 忘记密码手机或者邮箱类型
	public static final String FORGET_PASSWORD_USERNAMETYPE = "forget-password-usernametype";
	// session 忘记密码手机或者用户
	public static final String FORGET_PASSWORD_USERNAME = "forget-password-username";
	// session 忘记密码 企业名称
	public static final String FORGET_PASSWORD_COMPANYNAME = "forget-password-companyname";
	// session 一账通用户登录标识
	public static final String ONE_ACCOUNT_PASS = "one-account-pass";
}