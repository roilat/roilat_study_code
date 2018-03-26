/* 
 * OrgAcctLedger.java created on 2016-08-17 下午 16:17:43 by roilatD
 */ 
package com.hansy.dataservice.busi.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 查询机构充值台账
 * TODO javadoc for com.hansy.dataservice.orgAcctLedger.entity.OrgAcctLedger
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17 下午 16:17:43
 */
@SuppressWarnings({"serial"})
@Alias("OrgAcctLedger")
public class OrgAcctLedger extends CommonBean<OrgAcctLedger> {
	/**
	 * 流水号
	 */
	private String flowId;

	/**
	 * 机构ID
	 */
	private Long orgId;

	/**
	 * 机构名称
	 */
	private String orgName;

	/**
	 * 账号
	 */
	private String acctNo;

	/**
	 * 交易金额
	 */
	private  transAmt;

	/**
	 * 交易时间
	 */
	private Date transTime;

	/**
	 * 交易类型:300001-充值,3000002-消费,300003-冲销
	 */
	private String tansType;

	/**
	 * 账户余额
	 */
	private  acctBal;

	/**
	 * 登记人
	 */
	private String insertUser;

	/**
	 * 登记时间
	 */
	private Date insertTime;


	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public  getTransAmt() {
		return transAmt;
	}
	public void setTransAmt( transAmt) {
		this.transAmt = transAmt;
	}
	public Date getTransTime() {
		return transTime;
	}
	public void setTransTime(Date transTime) {
		this.transTime = transTime;
	}
	public String getTansType() {
		return tansType;
	}
	public void setTansType(String tansType) {
		this.tansType = tansType;
	}
	public  getAcctBal() {
		return acctBal;
	}
	public void setAcctBal( acctBal) {
		this.acctBal = acctBal;
	}
	public String getInsertUser() {
		return insertUser;
	}
	public void setInsertUser(String insertUser) {
		this.insertUser = insertUser;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flowId == null) ? 0 : flowId.hashCode());
		result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
		result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
		result = prime * result + ((acctNo == null) ? 0 : acctNo.hashCode());
		result = prime * result + ((transAmt == null) ? 0 : transAmt.hashCode());
		result = prime * result + ((transTime == null) ? 0 : transTime.hashCode());
		result = prime * result + ((tansType == null) ? 0 : tansType.hashCode());
		result = prime * result + ((acctBal == null) ? 0 : acctBal.hashCode());
		result = prime * result + ((insertUser == null) ? 0 : insertUser.hashCode());
		result = prime * result + ((insertTime == null) ? 0 : insertTime.hashCode());
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
		OrgAcctLedger other = (OrgAcctLedger) obj;
		if (flowId == null) {
			if (other.flowId != null)
				return false;
		} else if (!flowId.equals(other.flowId))
			return false;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		if (orgName == null) {
			if (other.orgName != null)
				return false;
		} else if (!orgName.equals(other.orgName))
			return false;
		if (acctNo == null) {
			if (other.acctNo != null)
				return false;
		} else if (!acctNo.equals(other.acctNo))
			return false;
		if (transAmt == null) {
			if (other.transAmt != null)
				return false;
		} else if (!transAmt.equals(other.transAmt))
			return false;
		if (transTime == null) {
			if (other.transTime != null)
				return false;
		} else if (!transTime.equals(other.transTime))
			return false;
		if (tansType == null) {
			if (other.tansType != null)
				return false;
		} else if (!tansType.equals(other.tansType))
			return false;
		if (acctBal == null) {
			if (other.acctBal != null)
				return false;
		} else if (!acctBal.equals(other.acctBal))
			return false;
		if (insertUser == null) {
			if (other.insertUser != null)
				return false;
		} else if (!insertUser.equals(other.insertUser))
			return false;
		if (insertTime == null) {
			if (other.insertTime != null)
				return false;
		} else if (!insertTime.equals(other.insertTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrgAcctLedger [ flowId=" + flowId + ", orgId=" + orgId + ", orgName=" + orgName + ", acctNo=" + acctNo + ", transAmt=" + transAmt + ", transTime=" + transTime + ", tansType=" + tansType + ", acctBal=" + acctBal + ", insertUser=" + insertUser + ", insertTime=" + insertTime + "]";
	}
}