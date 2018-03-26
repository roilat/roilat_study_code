/* 
 * BlklistQueryLog.java created on 2016-08-17 下午 16:18:44 by roilatD
 */ 
package com.hansy.dataservice.busi.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 黑名单查询日志
 * TODO javadoc for com.hansy.dataservice.blklistQueryLog.entity.BlklistQueryLog
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17 下午 16:18:44
 */
@SuppressWarnings({"serial"})
@Alias("BlklistQueryLog")
public class BlklistQueryLog extends CommonBean<BlklistQueryLog> {
	/**
	 * 查询机构ID
	 */
	private Long orgId;

	/**
	 * 查询时间
	 */
	private Date queryTime;

	/**
	 * 客户姓名
	 */
	private String custName;

	/**
	 * 客户证件类型
	 */
	private String custCertType;

	/**
	 * 客户证件号
	 */
	private String custCertNo;

	/**
	 * 手机号
	 */
	private String mobileNo;

	/**
	 * 是否命中
	 */
	private Long isTarget;

	/**
	 * 备注
	 */
	private String remark;


	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Date getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(Date queryTime) {
		this.queryTime = queryTime;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustCertType() {
		return custCertType;
	}
	public void setCustCertType(String custCertType) {
		this.custCertType = custCertType;
	}
	public String getCustCertNo() {
		return custCertNo;
	}
	public void setCustCertNo(String custCertNo) {
		this.custCertNo = custCertNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Long getIsTarget() {
		return isTarget;
	}
	public void setIsTarget(Long isTarget) {
		this.isTarget = isTarget;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
		result = prime * result + ((queryTime == null) ? 0 : queryTime.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((custCertType == null) ? 0 : custCertType.hashCode());
		result = prime * result + ((custCertNo == null) ? 0 : custCertNo.hashCode());
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		result = prime * result + ((isTarget == null) ? 0 : isTarget.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
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
		BlklistQueryLog other = (BlklistQueryLog) obj;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		if (queryTime == null) {
			if (other.queryTime != null)
				return false;
		} else if (!queryTime.equals(other.queryTime))
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (custCertType == null) {
			if (other.custCertType != null)
				return false;
		} else if (!custCertType.equals(other.custCertType))
			return false;
		if (custCertNo == null) {
			if (other.custCertNo != null)
				return false;
		} else if (!custCertNo.equals(other.custCertNo))
			return false;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		if (isTarget == null) {
			if (other.isTarget != null)
				return false;
		} else if (!isTarget.equals(other.isTarget))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BlklistQueryLog [ orgId=" + orgId + ", queryTime=" + queryTime + ", custName=" + custName + ", custCertType=" + custCertType + ", custCertNo=" + custCertNo + ", mobileNo=" + mobileNo + ", isTarget=" + isTarget + ", remark=" + remark + "]";
	}
}