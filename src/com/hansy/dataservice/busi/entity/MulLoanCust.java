/* 
 * MulLoanCust.java created on 2016-08-17 下午 16:14:13 by roilatD
 */ 
package com.hansy.dataservice.busi.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 多头借贷客户
 * TODO javadoc for com.hansy.dataservice.mulLoanCust.entity.MulLoanCust
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17 下午 16:14:13
 */
@SuppressWarnings({"serial"})
@Alias("MulLoanCust")
public class MulLoanCust extends CommonBean<MulLoanCust> {
	/**
	 * 客户姓名
	 */
	private String custName;

	/**
	 * 证件类型
	 */
	private String certType;

	/**
	 * 证件号
	 */
	private String certNo;

	/**
	 * 手机号
	 */
	private String mobileTel;

	/**
	 * 借贷公司
	 */
	private String loanCorp;

	/**
	 * 插入时间
	 */
	private Date insertTime;

	/**
	 * 更新日期
	 */
	private Date updateTime;


	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getMobileTel() {
		return mobileTel;
	}
	public void setMobileTel(String mobileTel) {
		this.mobileTel = mobileTel;
	}
	public String getLoanCorp() {
		return loanCorp;
	}
	public void setLoanCorp(String loanCorp) {
		this.loanCorp = loanCorp;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((certType == null) ? 0 : certType.hashCode());
		result = prime * result + ((certNo == null) ? 0 : certNo.hashCode());
		result = prime * result + ((mobileTel == null) ? 0 : mobileTel.hashCode());
		result = prime * result + ((loanCorp == null) ? 0 : loanCorp.hashCode());
		result = prime * result + ((insertTime == null) ? 0 : insertTime.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
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
		MulLoanCust other = (MulLoanCust) obj;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (certType == null) {
			if (other.certType != null)
				return false;
		} else if (!certType.equals(other.certType))
			return false;
		if (certNo == null) {
			if (other.certNo != null)
				return false;
		} else if (!certNo.equals(other.certNo))
			return false;
		if (mobileTel == null) {
			if (other.mobileTel != null)
				return false;
		} else if (!mobileTel.equals(other.mobileTel))
			return false;
		if (loanCorp == null) {
			if (other.loanCorp != null)
				return false;
		} else if (!loanCorp.equals(other.loanCorp))
			return false;
		if (insertTime == null) {
			if (other.insertTime != null)
				return false;
		} else if (!insertTime.equals(other.insertTime))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MulLoanCust [ custName=" + custName + ", certType=" + certType + ", certNo=" + certNo + ", mobileTel=" + mobileTel + ", loanCorp=" + loanCorp + ", insertTime=" + insertTime + ", updateTime=" + updateTime + "]";
	}
}