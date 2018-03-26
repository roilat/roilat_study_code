/* 
 * PubProdSellVo.java created on 2016-06-04 下午 15:00:16 by roilatD
 */ 
package com.p2p.invst.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 产品销售表
 * TODO javadoc for com.p2p.pubProdSellVo.entity.PubProdSellVo
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-04 下午 15:00:16
 */
@SuppressWarnings({"serial"})
@Alias("PubProdSellVo")
public class PubProdSellVo extends CommonBean<PubProdSellVo> {
	/**
	 * 产品编号
	 */
	private String prodNo;

	/**
	 * 上架时间
	 */
	private Date onlineDate;

	/**
	 * 已还金额
	 */
	private Decimal voteAmt;

	/**
	 * 已投金额
	 */
	private Decimal frozenAmt;

	/**
	 * 
	 */
	private String custNo;

	/**
	 * 开售时间
	 */
	private Date bgnSellDate;

	/**
	 * 结束时间
	 */
	private Date dueBidDate;

	/**
	 * 创建日期
	 */
	private Date instDate;

	/**
	 * 修改日期
	 */
	private Date updtDate;


	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public Date getOnlineDate() {
		return onlineDate;
	}
	public void setOnlineDate(Date onlineDate) {
		this.onlineDate = onlineDate;
	}
	public Decimal getVoteAmt() {
		return voteAmt;
	}
	public void setVoteAmt(Decimal voteAmt) {
		this.voteAmt = voteAmt;
	}
	public Decimal getFrozenAmt() {
		return frozenAmt;
	}
	public void setFrozenAmt(Decimal frozenAmt) {
		this.frozenAmt = frozenAmt;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public Date getBgnSellDate() {
		return bgnSellDate;
	}
	public void setBgnSellDate(Date bgnSellDate) {
		this.bgnSellDate = bgnSellDate;
	}
	public Date getDueBidDate() {
		return dueBidDate;
	}
	public void setDueBidDate(Date dueBidDate) {
		this.dueBidDate = dueBidDate;
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
		result = prime * result + ((prodNo == null) ? 0 : prodNo.hashCode());
		result = prime * result + ((onlineDate == null) ? 0 : onlineDate.hashCode());
		result = prime * result + ((voteAmt == null) ? 0 : voteAmt.hashCode());
		result = prime * result + ((frozenAmt == null) ? 0 : frozenAmt.hashCode());
		result = prime * result + ((custNo == null) ? 0 : custNo.hashCode());
		result = prime * result + ((bgnSellDate == null) ? 0 : bgnSellDate.hashCode());
		result = prime * result + ((dueBidDate == null) ? 0 : dueBidDate.hashCode());
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
		PubProdSellVo other = (PubProdSellVo) obj;
		if (prodNo == null) {
			if (other.prodNo != null)
				return false;
		} else if (!prodNo.equals(other.prodNo))
			return false;
		if (onlineDate == null) {
			if (other.onlineDate != null)
				return false;
		} else if (!onlineDate.equals(other.onlineDate))
			return false;
		if (voteAmt == null) {
			if (other.voteAmt != null)
				return false;
		} else if (!voteAmt.equals(other.voteAmt))
			return false;
		if (frozenAmt == null) {
			if (other.frozenAmt != null)
				return false;
		} else if (!frozenAmt.equals(other.frozenAmt))
			return false;
		if (custNo == null) {
			if (other.custNo != null)
				return false;
		} else if (!custNo.equals(other.custNo))
			return false;
		if (bgnSellDate == null) {
			if (other.bgnSellDate != null)
				return false;
		} else if (!bgnSellDate.equals(other.bgnSellDate))
			return false;
		if (dueBidDate == null) {
			if (other.dueBidDate != null)
				return false;
		} else if (!dueBidDate.equals(other.dueBidDate))
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
		return "PubProdSellVo [ prodNo=" + prodNo + ", onlineDate=" + onlineDate + ", voteAmt=" + voteAmt + ", frozenAmt=" + frozenAmt + ", custNo=" + custNo + ", bgnSellDate=" + bgnSellDate + ", dueBidDate=" + dueBidDate + ", instDate=" + instDate + ", updtDate=" + updtDate + "]";
	}
}