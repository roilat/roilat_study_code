/* 
 * LoanBlackList.java created on 2016-08-17 下午 16:21:05 by roilatD
 */ 
package com.hansy.dataservice.busi1.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 黑名单表
 * TODO javadoc for com.hansy.dataservice.loanBlackList.entity.LoanBlackList
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-08-17 下午 16:21:05
 */
@SuppressWarnings({"serial"})
@Alias("LoanBlackList")
public class LoanBlackList extends CommonBean<LoanBlackList> {
	/**
	 * null
	 */
	private String tableKey;

	/**
	 * null
	 */
	private String custName;

	/**
	 * null
	 */
	private String certType;

	/**
	 * null
	 */
	private String certNo;

	/**
	 * null
	 */
	private String listStatus;

	/**
	 * null
	 */
	private String listType;

	/**
	 * null
	 */
	private String remark;

	/**
	 * null
	 */
	private String createUser;

	/**
	 * null
	 */
	private Date createTime;

	/**
	 * null
	 */
	private String checkUser;

	/**
	 * null
	 */
	private Date checkTime;

	/**
	 * null
	 */
	private String cardNo;


	public String getTableKey() {
		return tableKey;
	}
	public void setTableKey(String tableKey) {
		this.tableKey = tableKey;
	}
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
	public String getListStatus() {
		return listStatus;
	}
	public void setListStatus(String listStatus) {
		this.listStatus = listStatus;
	}
	public String getListType() {
		return listType;
	}
	public void setListType(String listType) {
		this.listType = listType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCheckUser() {
		return checkUser;
	}
	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tableKey == null) ? 0 : tableKey.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((certType == null) ? 0 : certType.hashCode());
		result = prime * result + ((certNo == null) ? 0 : certNo.hashCode());
		result = prime * result + ((listStatus == null) ? 0 : listStatus.hashCode());
		result = prime * result + ((listType == null) ? 0 : listType.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((checkUser == null) ? 0 : checkUser.hashCode());
		result = prime * result + ((checkTime == null) ? 0 : checkTime.hashCode());
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
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
		LoanBlackList other = (LoanBlackList) obj;
		if (tableKey == null) {
			if (other.tableKey != null)
				return false;
		} else if (!tableKey.equals(other.tableKey))
			return false;
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
		if (listStatus == null) {
			if (other.listStatus != null)
				return false;
		} else if (!listStatus.equals(other.listStatus))
			return false;
		if (listType == null) {
			if (other.listType != null)
				return false;
		} else if (!listType.equals(other.listType))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (checkUser == null) {
			if (other.checkUser != null)
				return false;
		} else if (!checkUser.equals(other.checkUser))
			return false;
		if (checkTime == null) {
			if (other.checkTime != null)
				return false;
		} else if (!checkTime.equals(other.checkTime))
			return false;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoanBlackList [ tableKey=" + tableKey + ", custName=" + custName + ", certType=" + certType + ", certNo=" + certNo + ", listStatus=" + listStatus + ", listType=" + listType + ", remark=" + remark + ", createUser=" + createUser + ", createTime=" + createTime + ", checkUser=" + checkUser + ", checkTime=" + checkTime + ", cardNo=" + cardNo + "]";
	}
}