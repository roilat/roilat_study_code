/* 
 * BusiCode.java created on 2016-08-17 下午 16:19:14 by roilatD
 */ 
package com.hansy.dataservice.busi.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 业务参数设置
 * TODO javadoc for com.hansy.dataservice.busiCode.entity.BusiCode
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17 下午 16:19:14
 */
@SuppressWarnings({"serial"})
@Alias("BusiCode")
public class BusiCode extends CommonBean<BusiCode> {
	/**
	 * 参数类型
	 */
	private String bizTypeCode;

	/**
	 * 参数值
	 */
	private String bizCodeValue;

	/**
	 * 参数名
	 */
	private String bizCodeName;

	/**
	 * 主键
	 */
	private String id;


	public String getBizTypeCode() {
		return bizTypeCode;
	}
	public void setBizTypeCode(String bizTypeCode) {
		this.bizTypeCode = bizTypeCode;
	}
	public String getBizCodeValue() {
		return bizCodeValue;
	}
	public void setBizCodeValue(String bizCodeValue) {
		this.bizCodeValue = bizCodeValue;
	}
	public String getBizCodeName() {
		return bizCodeName;
	}
	public void setBizCodeName(String bizCodeName) {
		this.bizCodeName = bizCodeName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bizTypeCode == null) ? 0 : bizTypeCode.hashCode());
		result = prime * result + ((bizCodeValue == null) ? 0 : bizCodeValue.hashCode());
		result = prime * result + ((bizCodeName == null) ? 0 : bizCodeName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusiCode other = (BusiCode) obj;
		if (bizTypeCode == null) {
			if (other.bizTypeCode != null)
				return false;
		} else if (!bizTypeCode.equals(other.bizTypeCode))
			return false;
		if (bizCodeValue == null) {
			if (other.bizCodeValue != null)
				return false;
		} else if (!bizCodeValue.equals(other.bizCodeValue))
			return false;
		if (bizCodeName == null) {
			if (other.bizCodeName != null)
				return false;
		} else if (!bizCodeName.equals(other.bizCodeName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BusiCode [ bizTypeCode=" + bizTypeCode + ", bizCodeValue=" + bizCodeValue + ", bizCodeName=" + bizCodeName + ", id=" + id + "]";
	}
}