package cn.roilat.framework.core.dto;

import java.io.Serializable;

public class UuidDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
