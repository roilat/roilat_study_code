/* 
 * LoanCustBaseInfo.java created on 2016-08-17 下午 16:20:38 by roilatD
 */ 
package com.hansy.dataservice.busi1.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 贷款客户基本信息
 * TODO javadoc for com.hansy.dataservice.loanCustBaseInfo.entity.LoanCustBaseInfo
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17 下午 16:20:38
 */
@SuppressWarnings({"serial"})
@Alias("LoanCustBaseInfo")
public class LoanCustBaseInfo extends CommonBean<LoanCustBaseInfo> {
	/**
	 * 客户名称
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
	 * 贷款总额
	 */
	private  totalLoanAmt;

	/**
	 * 最近贷款日期
	 */
	private Date maxLoanDate;

	/**
	 * 信息来源公司
	 */
	private String sourceCorp;


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
	public  getTotalLoanAmt() {
		return totalLoanAmt;
	}
	public void setTotalLoanAmt( totalLoanAmt) {
		this.totalLoanAmt = totalLoanAmt;
	}
	public Date getMaxLoanDate() {
		return maxLoanDate;
	}
	public void setMaxLoanDate(Date maxLoanDate) {
		this.maxLoanDate = maxLoanDate;
	}
	public String getSourceCorp() {
		return sourceCorp;
	}
	public void setSourceCorp(String sourceCorp) {
		this.sourceCorp = sourceCorp;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((certType == null) ? 0 : certType.hashCode());
		result = prime * result + ((certNo == null) ? 0 : certNo.hashCode());
		result = prime * result + ((mobileTel == null) ? 0 : mobileTel.hashCode());
		result = prime * result + ((totalLoanAmt == null) ? 0 : totalLoanAmt.hashCode());
		result = prime * result + ((maxLoanDate == null) ? 0 : maxLoanDate.hashCode());
		result = prime * result + ((sourceCorp == null) ? 0 : sourceCorp.hashCode());
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
		LoanCustBaseInfo other = (LoanCustBaseInfo) obj;
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
		if (totalLoanAmt == null) {
			if (other.totalLoanAmt != null)
				return false;
		} else if (!totalLoanAmt.equals(other.totalLoanAmt))
			return false;
		if (maxLoanDate == null) {
			if (other.maxLoanDate != null)
				return false;
		} else if (!maxLoanDate.equals(other.maxLoanDate))
			return false;
		if (sourceCorp == null) {
			if (other.sourceCorp != null)
				return false;
		} else if (!sourceCorp.equals(other.sourceCorp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoanCustBaseInfo [ custName=" + custName + ", certType=" + certType + ", certNo=" + certNo + ", mobileTel=" + mobileTel + ", totalLoanAmt=" + totalLoanAmt + ", maxLoanDate=" + maxLoanDate + ", sourceCorp=" + sourceCorp + "]";
	}
}