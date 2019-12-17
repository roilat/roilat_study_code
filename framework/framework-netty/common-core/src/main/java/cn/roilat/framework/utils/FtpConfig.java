package cn.roilat.framework.utils;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public final class FtpConfig implements Serializable{

	private static final long serialVersionUID = 1L;
	private String address;
	private int port;
	private String username;
	private String password;
	private String ftpDir;   //ftp服务器目录
	private String localDir; //本地目录
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFtpDir() {
		return ftpDir;
	}

	public void setFtpDir(String ftpDir) {
		this.ftpDir = ftpDir;
	}

	public String getLocalDir() {
		return localDir;
	}

	public void setLocalDir(String localDir) {
		this.localDir = localDir;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this);
	}
}
