package cn.roilat.framework.result;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 公用返回数据；
 * code为标志：true为成功，false为失败。
 * Desc为描述：返回描述。
 * DATA为数据：当为成功时，返回成功的数据。
 * @author xianlin.yao
 *
 */
public class ResponseResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private String statusCode;
	
	private String msg;
	
	private Object data;
	
	private String token;
	
	private String expires;
	
	
	private ResponseResult() {
	}
	private ResponseResult(String statusCode) {
		this.statusCode = statusCode;
	}
	private ResponseResult(String code, String msg) {
		this(code);
		this.msg = msg;
	}
	
	private ResponseResult(String code, String desc, Object data) {
		this(code,desc);
		this.data = data;
	}
	
	private ResponseResult(String code, String desc, Object data,String token,String expires) {
		this(code,desc,data);
		this.token = token;
		this.expires = expires;
	}
	
	public static ResponseResult fail(){
		return new ResponseResult(ResultCodeEnum.SERVER_INTERNAL_ERROR.getCode(), ResultCodeEnum.SERVER_INTERNAL_ERROR.getMessage());
	}
	
	public static ResponseResult fail(String desc){
		return new ResponseResult(ResultCodeEnum.SERVER_INTERNAL_ERROR.getCode(), desc);
	}
	
	public static ResponseResult fail(ResultCodeEnum con){
		return new ResponseResult(con.getCode(), con.getMessage());
	}
	
	public static ResponseResult fail(String code, String desc){
		return new ResponseResult(code, desc);
	}
	
	public static ResponseResult succ(){
		return new ResponseResult(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage());
	}
	
	public static ResponseResult succ(Object data){
		return new ResponseResult(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), data);
	}
	
	public static ResponseResult succ(String msg, Object data){
		return new ResponseResult(ResultCodeEnum.SUCCESS.getCode(), msg, data);
	}
	
	public static ResponseResult succ(Object data,String token,String expires){
		return new ResponseResult(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), data, token, expires);
	}
	
	public String getStatusCode() {
		return statusCode;
	}

	public void setcode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getExpires() {
		return expires;
	}
	public void setExpires(String expires) {
		this.expires = expires;
	}
	@Override
	public String toString(){
		return JSON.toJSONString(this);
	}
}
