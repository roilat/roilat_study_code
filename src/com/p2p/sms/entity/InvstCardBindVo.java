/* 
 * InvstCardBindVo.java created on 2016-05-27 下午 19:50:11 by roilatD
 */ 
package com.p2p.sms.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 投资人银行卡绑定
 * TODO javadoc for com.p2p.invstCardBindVo.entity.InvstCardBindVo
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-05-27 下午 19:50:11
 */
@SuppressWarnings({"serial"})
@Alias("InvstCardBindVo")
public class InvstCardBindVo extends CommonBean<InvstCardBindVo> {
	/**
	 * 
	 */
	private String cardNo;

	/**
	 * 
	 */
	private String custName;

	/**
	 * 
	 */
	private String custNo;

	/**
	 * 
	 */
	private String acctNo;

	/**
	 * 
	 */
	private String provCod;

	/**
	 * 
	 */
	private String bankProv;

	/**
	 * 
	 */
	private String cityCod;

	/**
	 * 
	 */
	private String bankCity;

	/**
	 * 
	 */
	private String bankName;

	/**
	 * 
	 */
	private String bankNo;

	/**
	 * 
	 */
	private Date instDate;

	/**
	 * 
	 */
	private Date updtDate;

	/**
	 * 
	 */
	private String recordStat;


	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public String getProvCod() {
		return provCod;
	}
	public void setProvCod(String provCod) {
		this.provCod = provCod;
	}
	public String getBankProv() {
		return bankProv;
	}
	public void setBankProv(String bankProv) {
		this.bankProv = bankProv;
	}
	public String getCityCod() {
		return cityCod;
	}
	public void setCityCod(String cityCod) {
		this.cityCod = cityCod;
	}
	public String getBankCity() {
		return bankCity;
	}
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public Date getInstDate() {
		return instDate;
	}
	public void setInstDate(Date instDate) {
		this.instDate = instDate;
	}
	public Date getUpdtDate() {
		return updtDate;
	}
	public void setUpdtDate(Date updtDate) {
		this.updtDate = updtDate;
	}
	public String getRecordStat() {
		return recordStat;
	}
	public void setRecordStat(String recordStat) {
		this.recordStat = recordStat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((custNo == null) ? 0 : custNo.hashCode());
		result = prime * result + ((acctNo == null) ? 0 : acctNo.hashCode());
		result = prime * result + ((provCod == null) ? 0 : provCod.hashCode());
		result = prime * result + ((bankProv == null) ? 0 : bankProv.hashCode());
		result = prime * result + ((cityCod == null) ? 0 : cityCod.hashCode());
		result = prime * result + ((bankCity == null) ? 0 : bankCity.hashCode());
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((bankNo == null) ? 0 : bankNo.hashCode());
		result = prime * result + ((instDate == null) ? 0 : instDate.hashCode());
		result = prime * result + ((updtDate == null) ? 0 : updtDate.hashCode());
		result = prime * result + ((recordStat == null) ? 0 : recordStat.hashCode());
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
		InvstCardBindVo other = (InvstCardBindVo) obj;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (custNo == null) {
			if (other.custNo != null)
				return false;
		} else if (!custNo.equals(other.custNo))
			return false;
		if (acctNo == null) {
			if (other.acctNo != null)
				return false;
		} else if (!acctNo.equals(other.acctNo))
			return false;
		if (provCod == null) {
			if (other.provCod != null)
				return false;
		} else if (!provCod.equals(other.provCod))
			return false;
		if (bankProv == null) {
			if (other.bankProv != null)
				return false;
		} else if (!bankProv.equals(other.bankProv))
			return false;
		if (cityCod == null) {
			if (other.cityCod != null)
				return false;
		} else if (!cityCod.equals(other.cityCod))
			return false;
		if (bankCity == null) {
			if (other.bankCity != null)
				return false;
		} else if (!bankCity.equals(other.bankCity))
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (bankNo == null) {
			if (other.bankNo != null)
				return false;
		} else if (!bankNo.equals(other.bankNo))
			return false;
		if (instDate == null) {
			if (other.instDate != null)
				return false;
		} else if (!instDate.equals(other.instDate))
			return false;
		if (updtDate == null) {
			if (other.updtDate != null)
				return false;
		} else if (!updtDate.equals(other.updtDate))
			return false;
		if (recordStat == null) {
			if (other.recordStat != null)
				return false;
		} else if (!recordStat.equals(other.recordStat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InvstCardBindVo [ cardNo=" + cardNo + ", custName=" + custName + ", custNo=" + custNo + ", acctNo=" + acctNo + ", provCod=" + provCod + ", bankProv=" + bankProv + ", cityCod=" + cityCod + ", bankCity=" + bankCity + ", bankName=" + bankName + ", bankNo=" + bankNo + ", instDate=" + instDate + ", updtDate=" + updtDate + ", recordStat=" + recordStat + "]";
	}
}