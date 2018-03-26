/* 
 * SysDealRecords.java created on 2016-06-14 下午 19:55:16 by roilatD
 */ 
package com.p2p.invst.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 系统交易记录
 * TODO javadoc for com.p2p.sysDealRecords.entity.SysDealRecords
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-14 下午 19:55:16
 */
@SuppressWarnings({"serial"})
@Alias("SysDealRecords")
public class SysDealRecords extends CommonBean<SysDealRecords> {
	/**
	 * 交易流水号
	 */
	private String txSeqNo;

	/**
	 * 账号
	 */
	private String acctNo;

	/**
	 * 收款账号
	 */
	private String toAcctNo;

	/**
	 * 支付状态信息
	 */
	private String payResult;

	/**
	 * 平台处理结果
	 */
	private String dealResult;

	/**
	 * 交易日期
	 */
	private Date txDate;

	/**
	 * 交易金额
	 */
	private Decimal txAmt;

	/**
	 * 交易状态
	 */
	private String txStat;

	/**
	 * 交易类型
	 */
	private String txCod;

	/**
	 * 
	 */
	private String txDesc;

	/**
	 * 创建日期
	 */
	private Date instDate;

	/**
	 * 修改日期
	 */
	private Date updtDate;


	public String getTxSeqNo() {
		return txSeqNo;
	}
	public void setTxSeqNo(String txSeqNo) {
		this.txSeqNo = txSeqNo;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public String getToAcctNo() {
		return toAcctNo;
	}
	public void setToAcctNo(String toAcctNo) {
		this.toAcctNo = toAcctNo;
	}
	public String getPayResult() {
		return payResult;
	}
	public void setPayResult(String payResult) {
		this.payResult = payResult;
	}
	public String getDealResult() {
		return dealResult;
	}
	public void setDealResult(String dealResult) {
		this.dealResult = dealResult;
	}
	public Date getTxDate() {
		return txDate;
	}
	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}
	public Decimal getTxAmt() {
		return txAmt;
	}
	public void setTxAmt(Decimal txAmt) {
		this.txAmt = txAmt;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((txSeqNo == null) ? 0 : txSeqNo.hashCode());
		result = prime * result + ((acctNo == null) ? 0 : acctNo.hashCode());
		result = prime * result + ((toAcctNo == null) ? 0 : toAcctNo.hashCode());
		result = prime * result + ((payResult == null) ? 0 : payResult.hashCode());
		result = prime * result + ((dealResult == null) ? 0 : dealResult.hashCode());
		result = prime * result + ((txDate == null) ? 0 : txDate.hashCode());
		result = prime * result + ((txAmt == null) ? 0 : txAmt.hashCode());
		result = prime * result + ((txStat == null) ? 0 : txStat.hashCode());
		result = prime * result + ((txCod == null) ? 0 : txCod.hashCode());
		result = prime * result + ((txDesc == null) ? 0 : txDesc.hashCode());
		result = prime * result + ((instDate == null) ? 0 : instDate.hashCode());
		result = prime * result + ((updtDate == null) ? 0 : updtDate.hashCode());
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
		SysDealRecords other = (SysDealRecords) obj;
		if (txSeqNo == null) {
			if (other.txSeqNo != null)
				return false;
		} else if (!txSeqNo.equals(other.txSeqNo))
			return false;
		if (acctNo == null) {
			if (other.acctNo != null)
				return false;
		} else if (!acctNo.equals(other.acctNo))
			return false;
		if (toAcctNo == null) {
			if (other.toAcctNo != null)
				return false;
		} else if (!toAcctNo.equals(other.toAcctNo))
			return false;
		if (payResult == null) {
			if (other.payResult != null)
				return false;
		} else if (!payResult.equals(other.payResult))
			return false;
		if (dealResult == null) {
			if (other.dealResult != null)
				return false;
		} else if (!dealResult.equals(other.dealResult))
			return false;
		if (txDate == null) {
			if (other.txDate != null)
				return false;
		} else if (!txDate.equals(other.txDate))
			return false;
		if (txAmt == null) {
			if (other.txAmt != null)
				return false;
		} else if (!txAmt.equals(other.txAmt))
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
		return true;
	}

	@Override
	public String toString() {
		return "SysDealRecords [ txSeqNo=" + txSeqNo + ", acctNo=" + acctNo + ", toAcctNo=" + toAcctNo + ", payResult=" + payResult + ", dealResult=" + dealResult + ", txDate=" + txDate + ", txAmt=" + txAmt + ", txStat=" + txStat + ", txCod=" + txCod + ", txDesc=" + txDesc + ", instDate=" + instDate + ", updtDate=" + updtDate + "]";
	}
}