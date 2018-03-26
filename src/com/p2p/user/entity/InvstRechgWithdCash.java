/* 
 * InvstRechgWithdCash.java created on 2016-05-31 下午 22:14:24 by roilatD
 */ 
package com.p2p.user.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 充值提现记录
 * TODO javadoc for com.p2p.invstRechgWithdCash.entity.InvstRechgWithdCash
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-05-31 下午 22:14:24
 */
@SuppressWarnings({"serial"})
@Alias("InvstRechgWithdCash")
public class InvstRechgWithdCash extends CommonBean<InvstRechgWithdCash> {
	/**
	 * 
	 */
	private String rechgWithdNo;

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
	private Date txDate;

	/**
	 * 
	 */
	private String acctNo;

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
	private String bankNo;

	/**
	 * 
	 */
	private String bankName;

	/**
	 * 
	 */
	private String cardNo;

	/**
	 * 
	 */
	private Decimal txFee;

	/**
	 * 
	 */
	private String feeAcctNo;

	/**
	 * 
	 */
	private String feeAcctName;

	/**
	 * 
	 */
	private String txCod;

	/**
	 * 
	 */
	private String txStat;

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


	public String getRechgWithdNo() {
		return rechgWithdNo;
	}
	public void setRechgWithdNo(String rechgWithdNo) {
		this.rechgWithdNo = rechgWithdNo;
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
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Decimal getTxFee() {
		return txFee;
	}
	public void setTxFee(Decimal txFee) {
		this.txFee = txFee;
	}
	public String getFeeAcctNo() {
		return feeAcctNo;
	}
	public void setFeeAcctNo(String feeAcctNo) {
		this.feeAcctNo = feeAcctNo;
	}
	public String getFeeAcctName() {
		return feeAcctName;
	}
	public void setFeeAcctName(String feeAcctName) {
		this.feeAcctName = feeAcctName;
	}
	public String getTxCod() {
		return txCod;
	}
	public void setTxCod(String txCod) {
		this.txCod = txCod;
	}
	public String getTxStat() {
		return txStat;
	}
	public void setTxStat(String txStat) {
		this.txStat = txStat;
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
		result = prime * result + ((rechgWithdNo == null) ? 0 : rechgWithdNo.hashCode());
		result = prime * result + ((custNo == null) ? 0 : custNo.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((txDate == null) ? 0 : txDate.hashCode());
		result = prime * result + ((acctNo == null) ? 0 : acctNo.hashCode());
		result = prime * result + ((txAmt == null) ? 0 : txAmt.hashCode());
		result = prime * result + ((BAL == null) ? 0 : BAL.hashCode());
		result = prime * result + ((bankNo == null) ? 0 : bankNo.hashCode());
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
		result = prime * result + ((txFee == null) ? 0 : txFee.hashCode());
		result = prime * result + ((feeAcctNo == null) ? 0 : feeAcctNo.hashCode());
		result = prime * result + ((feeAcctName == null) ? 0 : feeAcctName.hashCode());
		result = prime * result + ((txCod == null) ? 0 : txCod.hashCode());
		result = prime * result + ((txStat == null) ? 0 : txStat.hashCode());
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
		InvstRechgWithdCash other = (InvstRechgWithdCash) obj;
		if (rechgWithdNo == null) {
			if (other.rechgWithdNo != null)
				return false;
		} else if (!rechgWithdNo.equals(other.rechgWithdNo))
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
		if (bankNo == null) {
			if (other.bankNo != null)
				return false;
		} else if (!bankNo.equals(other.bankNo))
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		if (txFee == null) {
			if (other.txFee != null)
				return false;
		} else if (!txFee.equals(other.txFee))
			return false;
		if (feeAcctNo == null) {
			if (other.feeAcctNo != null)
				return false;
		} else if (!feeAcctNo.equals(other.feeAcctNo))
			return false;
		if (feeAcctName == null) {
			if (other.feeAcctName != null)
				return false;
		} else if (!feeAcctName.equals(other.feeAcctName))
			return false;
		if (txCod == null) {
			if (other.txCod != null)
				return false;
		} else if (!txCod.equals(other.txCod))
			return false;
		if (txStat == null) {
			if (other.txStat != null)
				return false;
		} else if (!txStat.equals(other.txStat))
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
		return "InvstRechgWithdCash [ rechgWithdNo=" + rechgWithdNo + ", custNo=" + custNo + ", custName=" + custName + ", txDate=" + txDate + ", acctNo=" + acctNo + ", txAmt=" + txAmt + ", BAL=" + BAL + ", bankNo=" + bankNo + ", bankName=" + bankName + ", cardNo=" + cardNo + ", txFee=" + txFee + ", feeAcctNo=" + feeAcctNo + ", feeAcctName=" + feeAcctName + ", txCod=" + txCod + ", txStat=" + txStat + ", txDesc=" + txDesc + ", instDate=" + instDate + ", updtDate=" + updtDate + ", recordStat=" + recordStat + "]";
	}
}