/* 
 * SysAcctJnl.java created on 2016-07-02 下午 15:44:41 by roilatD
 */ 
package com.p2p.sys.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 会计分录流水
 * TODO javadoc for com.p2p.sysAcctJnl.entity.SysAcctJnl
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-07-02 下午 15:44:41
 */
@SuppressWarnings({"serial"})
@Alias("SysAcctJnl")
public class SysAcctJnl extends CommonBean<SysAcctJnl> {
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
	private String subjNo;

	/**
	 * 
	 */
	private String drCrFlag;

	/**
	 * 
	 */
	private String prodNo;

	/**
	 * 
	 */
	private String txCod;

	/**
	 * 
	 */
	private String txAbbr;

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
	private String cntAcctNo;

	/**
	 * 
	 */
	private String cntAcctName;

	/**
	 * 
	 */
	private String bookFlag;

	/**
	 * 
	 */
	private String strkFlag;

	/**
	 * 
	 */
	private Date strkDate;

	/**
	 * 
	 */
	private Date instDate;

	/**
	 * 
	 */
	private Date updtDate;


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
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public String getTxCod() {
		return txCod;
	}
	public void setTxCod(String txCod) {
		this.txCod = txCod;
	}
	public String getTxAbbr() {
		return txAbbr;
	}
	public void setTxAbbr(String txAbbr) {
		this.txAbbr = txAbbr;
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
	public String getCntAcctNo() {
		return cntAcctNo;
	}
	public void setCntAcctNo(String cntAcctNo) {
		this.cntAcctNo = cntAcctNo;
	}
	public String getCntAcctName() {
		return cntAcctName;
	}
	public void setCntAcctName(String cntAcctName) {
		this.cntAcctName = cntAcctName;
	}
	public String getBookFlag() {
		return bookFlag;
	}
	public void setBookFlag(String bookFlag) {
		this.bookFlag = bookFlag;
	}
	public String getStrkFlag() {
		return strkFlag;
	}
	public void setStrkFlag(String strkFlag) {
		this.strkFlag = strkFlag;
	}
	public Date getStrkDate() {
		return strkDate;
	}
	public void setStrkDate(Date strkDate) {
		this.strkDate = strkDate;
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
		result = prime * result + ((serlNo == null) ? 0 : serlNo.hashCode());
		result = prime * result + ((txDate == null) ? 0 : txDate.hashCode());
		result = prime * result + ((acctNo == null) ? 0 : acctNo.hashCode());
		result = prime * result + ((custNo == null) ? 0 : custNo.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((subjNo == null) ? 0 : subjNo.hashCode());
		result = prime * result + ((drCrFlag == null) ? 0 : drCrFlag.hashCode());
		result = prime * result + ((prodNo == null) ? 0 : prodNo.hashCode());
		result = prime * result + ((txCod == null) ? 0 : txCod.hashCode());
		result = prime * result + ((txAbbr == null) ? 0 : txAbbr.hashCode());
		result = prime * result + ((txAmt == null) ? 0 : txAmt.hashCode());
		result = prime * result + ((BAL == null) ? 0 : BAL.hashCode());
		result = prime * result + ((cntAcctNo == null) ? 0 : cntAcctNo.hashCode());
		result = prime * result + ((cntAcctName == null) ? 0 : cntAcctName.hashCode());
		result = prime * result + ((bookFlag == null) ? 0 : bookFlag.hashCode());
		result = prime * result + ((strkFlag == null) ? 0 : strkFlag.hashCode());
		result = prime * result + ((strkDate == null) ? 0 : strkDate.hashCode());
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
		SysAcctJnl other = (SysAcctJnl) obj;
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
		if (prodNo == null) {
			if (other.prodNo != null)
				return false;
		} else if (!prodNo.equals(other.prodNo))
			return false;
		if (txCod == null) {
			if (other.txCod != null)
				return false;
		} else if (!txCod.equals(other.txCod))
			return false;
		if (txAbbr == null) {
			if (other.txAbbr != null)
				return false;
		} else if (!txAbbr.equals(other.txAbbr))
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
		if (cntAcctNo == null) {
			if (other.cntAcctNo != null)
				return false;
		} else if (!cntAcctNo.equals(other.cntAcctNo))
			return false;
		if (cntAcctName == null) {
			if (other.cntAcctName != null)
				return false;
		} else if (!cntAcctName.equals(other.cntAcctName))
			return false;
		if (bookFlag == null) {
			if (other.bookFlag != null)
				return false;
		} else if (!bookFlag.equals(other.bookFlag))
			return false;
		if (strkFlag == null) {
			if (other.strkFlag != null)
				return false;
		} else if (!strkFlag.equals(other.strkFlag))
			return false;
		if (strkDate == null) {
			if (other.strkDate != null)
				return false;
		} else if (!strkDate.equals(other.strkDate))
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
		return "SysAcctJnl [ txSeqNo=" + txSeqNo + ", serlNo=" + serlNo + ", txDate=" + txDate + ", acctNo=" + acctNo + ", custNo=" + custNo + ", custName=" + custName + ", subjNo=" + subjNo + ", drCrFlag=" + drCrFlag + ", prodNo=" + prodNo + ", txCod=" + txCod + ", txAbbr=" + txAbbr + ", txAmt=" + txAmt + ", BAL=" + BAL + ", cntAcctNo=" + cntAcctNo + ", cntAcctName=" + cntAcctName + ", bookFlag=" + bookFlag + ", strkFlag=" + strkFlag + ", strkDate=" + strkDate + ", instDate=" + instDate + ", updtDate=" + updtDate + "]";
	}
}