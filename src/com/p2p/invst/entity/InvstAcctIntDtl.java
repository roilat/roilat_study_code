/* 
 * InvstAcctIntDtl.java created on 2016-06-12 上午 09:38:15 by roilatD
 */ 
package com.p2p.invst.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 投资预期收益表
 * TODO javadoc for com.p2p.invstAcctIntDtl.entity.InvstAcctIntDtl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-12 上午 09:38:15
 */
@SuppressWarnings({"serial"})
@Alias("InvstAcctIntDtl")
public class InvstAcctIntDtl extends CommonBean<InvstAcctIntDtl> {
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
	private String prftTyp;

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
	private Date estIncomeDt;

	/**
	 * 
	 */
	private Decimal estIncomeAmt;

	/**
	 * 
	 */
	private Date actualIncomeDt;

	/**
	 * 
	 */
	private Decimal actualIncomeAmt;

	/**
	 * 
	 */
	private Decimal paymentPpleAmt;

	/**
	 * 
	 */
	private Decimal actualPpleAmt;

	/**
	 * 
	 */
	private Decimal paymentIntAmt;

	/**
	 * 
	 */
	private Decimal actualIntAmt;

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
	public String getPrftTyp() {
		return prftTyp;
	}
	public void setPrftTyp(String prftTyp) {
		this.prftTyp = prftTyp;
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
	public Date getEstIncomeDt() {
		return estIncomeDt;
	}
	public void setEstIncomeDt(Date estIncomeDt) {
		this.estIncomeDt = estIncomeDt;
	}
	public Decimal getEstIncomeAmt() {
		return estIncomeAmt;
	}
	public void setEstIncomeAmt(Decimal estIncomeAmt) {
		this.estIncomeAmt = estIncomeAmt;
	}
	public Date getActualIncomeDt() {
		return actualIncomeDt;
	}
	public void setActualIncomeDt(Date actualIncomeDt) {
		this.actualIncomeDt = actualIncomeDt;
	}
	public Decimal getActualIncomeAmt() {
		return actualIncomeAmt;
	}
	public void setActualIncomeAmt(Decimal actualIncomeAmt) {
		this.actualIncomeAmt = actualIncomeAmt;
	}
	public Decimal getPaymentPpleAmt() {
		return paymentPpleAmt;
	}
	public void setPaymentPpleAmt(Decimal paymentPpleAmt) {
		this.paymentPpleAmt = paymentPpleAmt;
	}
	public Decimal getActualPpleAmt() {
		return actualPpleAmt;
	}
	public void setActualPpleAmt(Decimal actualPpleAmt) {
		this.actualPpleAmt = actualPpleAmt;
	}
	public Decimal getPaymentIntAmt() {
		return paymentIntAmt;
	}
	public void setPaymentIntAmt(Decimal paymentIntAmt) {
		this.paymentIntAmt = paymentIntAmt;
	}
	public Decimal getActualIntAmt() {
		return actualIntAmt;
	}
	public void setActualIntAmt(Decimal actualIntAmt) {
		this.actualIntAmt = actualIntAmt;
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
		result = prime * result + ((prftTyp == null) ? 0 : prftTyp.hashCode());
		result = prime * result + ((txDate == null) ? 0 : txDate.hashCode());
		result = prime * result + ((acctNo == null) ? 0 : acctNo.hashCode());
		result = prime * result + ((custNo == null) ? 0 : custNo.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((prodNo == null) ? 0 : prodNo.hashCode());
		result = prime * result + ((prodName == null) ? 0 : prodName.hashCode());
		result = prime * result + ((subjNo == null) ? 0 : subjNo.hashCode());
		result = prime * result + ((drCrFlag == null) ? 0 : drCrFlag.hashCode());
		result = prime * result + ((estIncomeDt == null) ? 0 : estIncomeDt.hashCode());
		result = prime * result + ((estIncomeAmt == null) ? 0 : estIncomeAmt.hashCode());
		result = prime * result + ((actualIncomeDt == null) ? 0 : actualIncomeDt.hashCode());
		result = prime * result + ((actualIncomeAmt == null) ? 0 : actualIncomeAmt.hashCode());
		result = prime * result + ((paymentPpleAmt == null) ? 0 : paymentPpleAmt.hashCode());
		result = prime * result + ((actualPpleAmt == null) ? 0 : actualPpleAmt.hashCode());
		result = prime * result + ((paymentIntAmt == null) ? 0 : paymentIntAmt.hashCode());
		result = prime * result + ((actualIntAmt == null) ? 0 : actualIntAmt.hashCode());
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
		InvstAcctIntDtl other = (InvstAcctIntDtl) obj;
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
		if (prftTyp == null) {
			if (other.prftTyp != null)
				return false;
		} else if (!prftTyp.equals(other.prftTyp))
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
		if (estIncomeDt == null) {
			if (other.estIncomeDt != null)
				return false;
		} else if (!estIncomeDt.equals(other.estIncomeDt))
			return false;
		if (estIncomeAmt == null) {
			if (other.estIncomeAmt != null)
				return false;
		} else if (!estIncomeAmt.equals(other.estIncomeAmt))
			return false;
		if (actualIncomeDt == null) {
			if (other.actualIncomeDt != null)
				return false;
		} else if (!actualIncomeDt.equals(other.actualIncomeDt))
			return false;
		if (actualIncomeAmt == null) {
			if (other.actualIncomeAmt != null)
				return false;
		} else if (!actualIncomeAmt.equals(other.actualIncomeAmt))
			return false;
		if (paymentPpleAmt == null) {
			if (other.paymentPpleAmt != null)
				return false;
		} else if (!paymentPpleAmt.equals(other.paymentPpleAmt))
			return false;
		if (actualPpleAmt == null) {
			if (other.actualPpleAmt != null)
				return false;
		} else if (!actualPpleAmt.equals(other.actualPpleAmt))
			return false;
		if (paymentIntAmt == null) {
			if (other.paymentIntAmt != null)
				return false;
		} else if (!paymentIntAmt.equals(other.paymentIntAmt))
			return false;
		if (actualIntAmt == null) {
			if (other.actualIntAmt != null)
				return false;
		} else if (!actualIntAmt.equals(other.actualIntAmt))
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
		return "InvstAcctIntDtl [ txSeqNo=" + txSeqNo + ", serlNo=" + serlNo + ", invstNo=" + invstNo + ", prftTyp=" + prftTyp + ", txDate=" + txDate + ", acctNo=" + acctNo + ", custNo=" + custNo + ", custName=" + custName + ", prodNo=" + prodNo + ", prodName=" + prodName + ", subjNo=" + subjNo + ", drCrFlag=" + drCrFlag + ", estIncomeDt=" + estIncomeDt + ", estIncomeAmt=" + estIncomeAmt + ", actualIncomeDt=" + actualIncomeDt + ", actualIncomeAmt=" + actualIncomeAmt + ", paymentPpleAmt=" + paymentPpleAmt + ", actualPpleAmt=" + actualPpleAmt + ", paymentIntAmt=" + paymentIntAmt + ", actualIntAmt=" + actualIntAmt + ", txStat=" + txStat + ", txCod=" + txCod + ", txDesc=" + txDesc + ", instDate=" + instDate + ", updtDate=" + updtDate + ", recordStat=" + recordStat + "]";
	}
}