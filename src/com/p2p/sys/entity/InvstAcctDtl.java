/* 
 * InvstAcctDtl.java created on 2016-07-02 下午 15:46:41 by roilatD
 */ 
package com.p2p.sys.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 投资交易明细
 * TODO javadoc for com.p2p.invstAcctDtl.entity.InvstAcctDtl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-07-02 下午 15:46:41
 */
@SuppressWarnings({"serial"})
@Alias("InvstAcctDtl")
public class InvstAcctDtl extends CommonBean<InvstAcctDtl> {
	/**
	 * 
	 */
	private String txSeqNo;

	/**
	 * 
	 */
	private Integer serlNo;

	/**
	 * 
	 */
	private String invstNo;

	/**
	 * 
	 */
	private Date txDate;

	/**
	 * 
	 */
	private String acctNo;

	/**
	 * 
	 */
	private String custNo;

	/**
	 * 
	 */
	private String custName;

	/**
	 * 
	 */
	private String prodNo;

	/**
	 * 
	 */
	private String prodName;

	/**
	 * 
	 */
	private String subjNo;

	/**
	 * 
	 */
	private String drCrFlag;

	/**
	 * 
	 */
	private Decimal txAmt;

	/**
	 * 
	 */
	private Decimal BAL;

	/**
	 * 
	 */
	private String txStat;

	/**
	 * 
	 */
	private String txCod;

	/**
	 * 
	 */
	private String txDesc;

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


	public String getTxSeqNo() {
		return txSeqNo;
	}
	public void setTxSeqNo(String txSeqNo) {
		this.txSeqNo = txSeqNo;
	}
	public Integer getSerlNo() {
		return serlNo;
	}
	public void setSerlNo(Integer serlNo) {
		this.serlNo = serlNo;
	}
	public String getInvstNo() {
		return invstNo;
	}
	public void setInvstNo(String invstNo) {
		this.invstNo = invstNo;
	}
	public Date getTxDate() {
		return txDate;
	}
	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getSubjNo() {
		return subjNo;
	}
	public void setSubjNo(String subjNo) {
		this.subjNo = subjNo;
	}
	public String getDrCrFlag() {
		return drCrFlag;
	}
	public void setDrCrFlag(String drCrFlag) {
		this.drCrFlag = drCrFlag;
	}
	public Decimal getTxAmt() {
		return txAmt;
	}
	public void setTxAmt(Decimal txAmt) {
		this.txAmt = txAmt;
	}
	public Decimal getBAL() {
		return BAL;
	}
	public void setBAL(Decimal BAL) {
		this.BAL = BAL;
	}
	public String getTxStat() {
		return txStat;
	}
	public void setTxStat(String txStat) {
		this.txStat = txStat;
	}
	public String getTxCod() {
		return txCod;
	}
	public void setTxCod(String txCod) {
		this.txCod = txCod;
	}
	public String getTxDesc() {
		return txDesc;
	}
	public void setTxDesc(String txDesc) {
		this.txDesc = txDesc;
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
		result = prime * result + ((txSeqNo == null) ? 0 : txSeqNo.hashCode());
		result = prime * result + ((serlNo == null) ? 0 : serlNo.hashCode());
		result = prime * result + ((invstNo == null) ? 0 : invstNo.hashCode());
		result = prime * result + ((txDate == null) ? 0 : txDate.hashCode());
		result = prime * result + ((acctNo == null) ? 0 : acctNo.hashCode());
		result = prime * result + ((custNo == null) ? 0 : custNo.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((prodNo == null) ? 0 : prodNo.hashCode());
		result = prime * result + ((prodName == null) ? 0 : prodName.hashCode());
		result = prime * result + ((subjNo == null) ? 0 : subjNo.hashCode());
		result = prime * result + ((drCrFlag == null) ? 0 : drCrFlag.hashCode());
		result = prime * result + ((txAmt == null) ? 0 : txAmt.hashCode());
		result = prime * result + ((BAL == null) ? 0 : BAL.hashCode());
		result = prime * result + ((txStat == null) ? 0 : txStat.hashCode());
		result = prime * result + ((txCod == null) ? 0 : txCod.hashCode());
		result = prime * result + ((txDesc == null) ? 0 : txDesc.hashCode());
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
		InvstAcctDtl other = (InvstAcctDtl) obj;
		if (txSeqNo == null) {
			if (other.txSeqNo != null)
				return false;
		} else if (!txSeqNo.equals(other.txSeqNo))
			return false;
		if (serlNo == null) {
			if (other.serlNo != null)
				return false;
		} else if (!serlNo.equals(other.serlNo))
			return false;
		if (invstNo == null) {
			if (other.invstNo != null)
				return false;
		} else if (!invstNo.equals(other.invstNo))
			return false;
		if (txDate == null) {
			if (other.txDate != null)
				return false;
		} else if (!txDate.equals(other.txDate))
			return false;
		if (acctNo == null) {
			if (other.acctNo != null)
				return false;
		} else if (!acctNo.equals(other.acctNo))
			return false;
		if (custNo == null) {
			if (other.custNo != null)
				return false;
		} else if (!custNo.equals(other.custNo))
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (prodNo == null) {
			if (other.prodNo != null)
				return false;
		} else if (!prodNo.equals(other.prodNo))
			return false;
		if (prodName == null) {
			if (other.prodName != null)
				return false;
		} else if (!prodName.equals(other.prodName))
			return false;
		if (subjNo == null) {
			if (other.subjNo != null)
				return false;
		} else if (!subjNo.equals(other.subjNo))
			return false;
		if (drCrFlag == null) {
			if (other.drCrFlag != null)
				return false;
		} else if (!drCrFlag.equals(other.drCrFlag))
			return false;
		if (txAmt == null) {
			if (other.txAmt != null)
				return false;
		} else if (!txAmt.equals(other.txAmt))
			return false;
		if (BAL == null) {
			if (other.BAL != null)
				return false;
		} else if (!BAL.equals(other.BAL))
			return false;
		if (txStat == null) {
			if (other.txStat != null)
				return false;
		} else if (!txStat.equals(other.txStat))
			return false;
		if (txCod == null) {
			if (other.txCod != null)
				return false;
		} else if (!txCod.equals(other.txCod))
			return false;
		if (txDesc == null) {
			if (other.txDesc != null)
				return false;
		} else if (!txDesc.equals(other.txDesc))
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
		return "InvstAcctDtl [ txSeqNo=" + txSeqNo + ", serlNo=" + serlNo + ", invstNo=" + invstNo + ", txDate=" + txDate + ", acctNo=" + acctNo + ", custNo=" + custNo + ", custName=" + custName + ", prodNo=" + prodNo + ", prodName=" + prodName + ", subjNo=" + subjNo + ", drCrFlag=" + drCrFlag + ", txAmt=" + txAmt + ", BAL=" + BAL + ", txStat=" + txStat + ", txCod=" + txCod + ", txDesc=" + txDesc + ", instDate=" + instDate + ", updtDate=" + updtDate + ", recordStat=" + recordStat + "]";
	}
}