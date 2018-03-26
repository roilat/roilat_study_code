/* 
 * BizType.java created on 2016-08-17 下午 16:19:37 by roilatD
 */ 
package com.hansy.dataservice.busi.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 业务参数类型设置
 * TODO javadoc for com.hansy.dataservice.bizType.entity.BizType
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17 下午 16:19:37
 */
@SuppressWarnings({"serial"})
@Alias("BizType")
public class BizType extends CommonBean<BizType> {
	/**
	 * 参数类型值
	 */
	private String typeCode;

	/**
	 * 参数类型名
	 */
	private String typeName;

	/**
	 * 主键
	 */
	private String id;


	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
		result = prime * result + ((typeCode == null) ? 0 : typeCode.hashCode());
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
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
		BizType other = (BizType) obj;
		if (typeCode == null) {
			if (other.typeCode != null)
				return false;
		} else if (!typeCode.equals(other.typeCode))
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
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
		return "BizType [ typeCode=" + typeCode + ", typeName=" + typeName + ", id=" + id + "]";
	}
}