package cn.roilat.framework.result;

public enum ResultCodeEnum {
	SUCCESS("200", "操作成功"), 
	TOKEN_EXPIRED("401", "token已过期"), 
	TOKEN_COVER("402", "账号已在其他地方登录"),
	TOKEN_ILLEGAL("403", "token非法"), 
	RESOURCE_NOTFOUND("404", "访问的资源不存在"), 
	TOKEN_EMPTY("405", "token为空"), 
	PERMISSION_ERROR("406", "权限不够"),
	URL_ERROR("407", "URI错误"),
	UUID_EMPTY("408", "UUID为空"),
	SERVER_INTERNAL_ERROR("500", "网络连接错误，请稍后重试"),
	SIGN_ILLEGAL("601", "sign非法"), 
	SIGN_EMPTY("602", "sign为空"), 
	PARAMETER_EMPTY("700","参数为空"),
	PARAMETER_INVALID("701","参数格式错误"),
	INTERFACE_INVALID("800","接口调用失败"),
	OBTAIN_USERINFO_FAIL("801","获取用户信息失败"),
	DATA_INVALID("702","参数值无效"),
	COMMON_EXCEPTION("999","当前排队人数较多，请稍后重试");
	private String code;
	private String message;
	private ResultCodeEnum( String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
