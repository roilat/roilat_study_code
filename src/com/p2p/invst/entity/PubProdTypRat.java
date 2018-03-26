/* 
 * PubProdTypRat.java created on 2016-06-14 下午 16:48:48 by roilatD
 */ 
package com.p2p.invst.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * pub_prod_typ_rat
 * TODO javadoc for com.p2p.pubProdTypRat.entity.PubProdTypRat
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-14 下午 16:48:48
 */
@SuppressWarnings({"serial"})
@Alias("PubProdTypRat")
public class PubProdTypRat extends CommonBean<PubProdTypRat> {
	/**
	 * 
	 */
	private String prodTyp;

	/**
	 * 
	 */
	private String subjNo;

	/**
	 * 
	 */
	private Decimal minPrftRat;

	/**
	 * 
	 */
	private Decimal feeRat;

	/**
	 * 
	 */
	private Decimal reservRat;

	/**
	 * 
	 */
	private Decimal marginRat;

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
	private Decimal fundRat;


	public String getProdTyp() {
		return prodTyp;
	}
	public void setProdTyp(String prodTyp) {
		this.prodTyp = prodTyp;
	}
	public String getSubjNo() {
		return subjNo;
	}
	public void setSubjNo(String subjNo) {
		this.subjNo = subjNo;
	}
	public Decimal getMinPrftRat() {
		return minPrftRat;
	}
	public void setMinPrftRat(Decimal minPrftRat) {
		this.minPrftRat = minPrftRat;
	}
	public Decimal getFeeRat() {
		return feeRat;
	}
	public void setFeeRat(Decimal feeRat) {
		this.feeRat = feeRat;
	}
	public Decimal getReservRat() {
		return reservRat;
	}
	public void setReservRat(Decimal reservRat) {
		this.reservRat = reservRat;
	}
	public Decimal getMarginRat() {
		return marginRat;
	}
	public void setMarginRat(Decimal marginRat) {
		this.marginRat = marginRat;
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
	public Decimal getFundRat() {
		return fundRat;
	}
	public void setFundRat(Decimal fundRat) {
		this.fundRat = fundRat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prodTyp == null) ? 0 : prodTyp.hashCode());
		result = prime * result + ((subjNo == null) ? 0 : subjNo.hashCode());
		result = prime * result + ((minPrftRat == null) ? 0 : minPrftRat.hashCode());
		result = prime * result + ((feeRat == null) ? 0 : feeRat.hashCode());
		result = prime * result + ((reservRat == null) ? 0 : reservRat.hashCode());
		result = prime * result + ((marginRat == null) ? 0 : marginRat.hashCode());
		result = prime * result + ((instDate == null) ? 0 : instDate.hashCode());
		result = prime * result + ((updtDate == null) ? 0 : updtDate.hashCode());
		result = prime * result + ((fundRat == null) ? 0 : fundRat.hashCode());
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
		PubProdTypRat other = (PubProdTypRat) obj;
		if (prodTyp == null) {
			if (other.prodTyp != null)
				return false;
		} else if (!prodTyp.equals(other.prodTyp))
			return false;
		if (subjNo == null) {
			if (other.subjNo != null)
				return false;
		} else if (!subjNo.equals(other.subjNo))
			return false;
		if (minPrftRat == null) {
			if (other.minPrftRat != null)
				return false;
		} else if (!minPrftRat.equals(other.minPrftRat))
			return false;
		if (feeRat == null) {
			if (other.feeRat != null)
				return false;
		} else if (!feeRat.equals(other.feeRat))
			return false;
		if (reservRat == null) {
			if (other.reservRat != null)
				return false;
		} else if (!reservRat.equals(other.reservRat))
			return false;
		if (marginRat == null) {
			if (other.marginRat != null)
				return false;
		} else if (!marginRat.equals(other.marginRat))
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
		if (fundRat == null) {
			if (other.fundRat != null)
				return false;
		} else if (!fundRat.equals(other.fundRat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PubProdTypRat [ prodTyp=" + prodTyp + ", subjNo=" + subjNo + ", minPrftRat=" + minPrftRat + ", feeRat=" + feeRat + ", reservRat=" + reservRat + ", marginRat=" + marginRat + ", instDate=" + instDate + ", updtDate=" + updtDate + ", fundRat=" + fundRat + "]";
	}
}