/* 
 * CustomerRepayPlans.java created on 2016-05-23 下午 15:46:18 by roilatD
 */ 
package org.eking.HNTravel.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 手机信息历史
 * TODO javadoc for org.eking.customerRepayPlans.entity.CustomerRepayPlans
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-05-23 下午 15:46:18
 */
@SuppressWarnings({"serial"})
@Alias("CustomerRepayPlans")
public class CustomerRepayPlans extends CommonBean<CustomerRepayPlans> {
	/**
	 * 借款人付款计划id
	 */
	private Integer id;

	/**
	 * 用户id
	 */
	private Integer custNo;

	/**
	 * 投资项目id
	 */
	private Integer prodNo;

	/**
	 * 投资项目名称
	 */
	private String prodName;

	/**
	 * 融资金额
	 */
	private Decimal loanAmt;

	/**
	 * 年化收益
	 */
	private Decimal prftRat;

	/**
	 * 还款日期
	 */
	private Date mthRepayDay;

	/**
	 * 还款方式:0-等额本息;1-等额本金;2-按天计息，按月付息，到期还本;3-到期还本还息
	 */
	private String repayTyp;

	/**
	 * 还款期数
	 */
	private Integer prodPerd;

	/**
	 * 计划付款日期
	 */
	private Date payPlanDt;

	/**
	 * 付款天数
	 */
	private Integer payDays;

	/**
	 * 计划付款金额
	 */
	private Decimal payPlanAmt;

	/**
	 * 利息金额
	 */
	private Decimal payPlanIntAmt;

	/**
	 * 本金金额
	 */
	private Decimal payPlanPpleAmt;

	/**
	 * 实际付款日期
	 */
	private Date payActualDt;

	/**
	 * 实际付款金额
	 */
	private Decimal payActualAmt;

	/**
	 * 实际利息金额
	 */
	private Decimal payActualIntAmt;

	/**
	 * 实际本金金额
	 */
	private Decimal payActualPpleAmt;

	/**
	 * 状态：0-未还款；1-已还款
	 */
	private String stat;

	/**
	 * 创建时间
	 */
	private Date created;

	/**
	 * 修改时间
	 */
	private Date modified;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustNo() {
		return custNo;
	}
	public void setCustNo(Integer custNo) {
		this.custNo = custNo;
	}
	public Integer getProdNo() {
		return prodNo;
	}
	public void setProdNo(Integer prodNo) {
		this.prodNo = prodNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public Decimal getLoanAmt() {
		return loanAmt;
	}
	public void setLoanAmt(Decimal loanAmt) {
		this.loanAmt = loanAmt;
	}
	public Decimal getPrftRat() {
		return prftRat;
	}
	public void setPrftRat(Decimal prftRat) {
		this.prftRat = prftRat;
	}
	public Date getMthRepayDay() {
		return mthRepayDay;
	}
	public void setMthRepayDay(Date mthRepayDay) {
		this.mthRepayDay = mthRepayDay;
	}
	public String getRepayTyp() {
		return repayTyp;
	}
	public void setRepayTyp(String repayTyp) {
		this.repayTyp = repayTyp;
	}
	public Integer getProdPerd() {
		return prodPerd;
	}
	public void setProdPerd(Integer prodPerd) {
		this.prodPerd = prodPerd;
	}
	public Date getPayPlanDt() {
		return payPlanDt;
	}
	public void setPayPlanDt(Date payPlanDt) {
		this.payPlanDt = payPlanDt;
	}
	public Integer getPayDays() {
		return payDays;
	}
	public void setPayDays(Integer payDays) {
		this.payDays = payDays;
	}
	public Decimal getPayPlanAmt() {
		return payPlanAmt;
	}
	public void setPayPlanAmt(Decimal payPlanAmt) {
		this.payPlanAmt = payPlanAmt;
	}
	public Decimal getPayPlanIntAmt() {
		return payPlanIntAmt;
	}
	public void setPayPlanIntAmt(Decimal payPlanIntAmt) {
		this.payPlanIntAmt = payPlanIntAmt;
	}
	public Decimal getPayPlanPpleAmt() {
		return payPlanPpleAmt;
	}
	public void setPayPlanPpleAmt(Decimal payPlanPpleAmt) {
		this.payPlanPpleAmt = payPlanPpleAmt;
	}
	public Date getPayActualDt() {
		return payActualDt;
	}
	public void setPayActualDt(Date payActualDt) {
		this.payActualDt = payActualDt;
	}
	public Decimal getPayActualAmt() {
		return payActualAmt;
	}
	public void setPayActualAmt(Decimal payActualAmt) {
		this.payActualAmt = payActualAmt;
	}
	public Decimal getPayActualIntAmt() {
		return payActualIntAmt;
	}
	public void setPayActualIntAmt(Decimal payActualIntAmt) {
		this.payActualIntAmt = payActualIntAmt;
	}
	public Decimal getPayActualPpleAmt() {
		return payActualPpleAmt;
	}
	public void setPayActualPpleAmt(Decimal payActualPpleAmt) {
		this.payActualPpleAmt = payActualPpleAmt;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((custNo == null) ? 0 : custNo.hashCode());
		result = prime * result + ((prodNo == null) ? 0 : prodNo.hashCode());
		result = prime * result + ((prodName == null) ? 0 : prodName.hashCode());
		result = prime * result + ((loanAmt == null) ? 0 : loanAmt.hashCode());
		result = prime * result + ((prftRat == null) ? 0 : prftRat.hashCode());
		result = prime * result + ((mthRepayDay == null) ? 0 : mthRepayDay.hashCode());
		result = prime * result + ((repayTyp == null) ? 0 : repayTyp.hashCode());
		result = prime * result + ((prodPerd == null) ? 0 : prodPerd.hashCode());
		result = prime * result + ((payPlanDt == null) ? 0 : payPlanDt.hashCode());
		result = prime * result + ((payDays == null) ? 0 : payDays.hashCode());
		result = prime * result + ((payPlanAmt == null) ? 0 : payPlanAmt.hashCode());
		result = prime * result + ((payPlanIntAmt == null) ? 0 : payPlanIntAmt.hashCode());
		result = prime * result + ((payPlanPpleAmt == null) ? 0 : payPlanPpleAmt.hashCode());
		result = prime * result + ((payActualDt == null) ? 0 : payActualDt.hashCode());
		result = prime * result + ((payActualAmt == null) ? 0 : payActualAmt.hashCode());
		result = prime * result + ((payActualIntAmt == null) ? 0 : payActualIntAmt.hashCode());
		result = prime * result + ((payActualPpleAmt == null) ? 0 : payActualPpleAmt.hashCode());
		result = prime * result + ((stat == null) ? 0 : stat.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((modified == null) ? 0 : modified.hashCode());
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
		CustomerRepayPlans other = (CustomerRepayPlans) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (custNo == null) {
			if (other.custNo != null)
				return false;
		} else if (!custNo.equals(other.custNo))
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
		if (loanAmt == null) {
			if (other.loanAmt != null)
				return false;
		} else if (!loanAmt.equals(other.loanAmt))
			return false;
		if (prftRat == null) {
			if (other.prftRat != null)
				return false;
		} else if (!prftRat.equals(other.prftRat))
			return false;
		if (mthRepayDay == null) {
			if (other.mthRepayDay != null)
				return false;
		} else if (!mthRepayDay.equals(other.mthRepayDay))
			return false;
		if (repayTyp == null) {
			if (other.repayTyp != null)
				return false;
		} else if (!repayTyp.equals(other.repayTyp))
			return false;
		if (prodPerd == null) {
			if (other.prodPerd != null)
				return false;
		} else if (!prodPerd.equals(other.prodPerd))
			return false;
		if (payPlanDt == null) {
			if (other.payPlanDt != null)
				return false;
		} else if (!payPlanDt.equals(other.payPlanDt))
			return false;
		if (payDays == null) {
			if (other.payDays != null)
				return false;
		} else if (!payDays.equals(other.payDays))
			return false;
		if (payPlanAmt == null) {
			if (other.payPlanAmt != null)
				return false;
		} else if (!payPlanAmt.equals(other.payPlanAmt))
			return false;
		if (payPlanIntAmt == null) {
			if (other.payPlanIntAmt != null)
				return false;
		} else if (!payPlanIntAmt.equals(other.payPlanIntAmt))
			return false;
		if (payPlanPpleAmt == null) {
			if (other.payPlanPpleAmt != null)
				return false;
		} else if (!payPlanPpleAmt.equals(other.payPlanPpleAmt))
			return false;
		if (payActualDt == null) {
			if (other.payActualDt != null)
				return false;
		} else if (!payActualDt.equals(other.payActualDt))
			return false;
		if (payActualAmt == null) {
			if (other.payActualAmt != null)
				return false;
		} else if (!payActualAmt.equals(other.payActualAmt))
			return false;
		if (payActualIntAmt == null) {
			if (other.payActualIntAmt != null)
				return false;
		} else if (!payActualIntAmt.equals(other.payActualIntAmt))
			return false;
		if (payActualPpleAmt == null) {
			if (other.payActualPpleAmt != null)
				return false;
		} else if (!payActualPpleAmt.equals(other.payActualPpleAmt))
			return false;
		if (stat == null) {
			if (other.stat != null)
				return false;
		} else if (!stat.equals(other.stat))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerRepayPlans [ id=" + id + ", custNo=" + custNo + ", prodNo=" + prodNo + ", prodName=" + prodName + ", loanAmt=" + loanAmt + ", prftRat=" + prftRat + ", mthRepayDay=" + mthRepayDay + ", repayTyp=" + repayTyp + ", prodPerd=" + prodPerd + ", payPlanDt=" + payPlanDt + ", payDays=" + payDays + ", payPlanAmt=" + payPlanAmt + ", payPlanIntAmt=" + payPlanIntAmt + ", payPlanPpleAmt=" + payPlanPpleAmt + ", payActualDt=" + payActualDt + ", payActualAmt=" + payActualAmt + ", payActualIntAmt=" + payActualIntAmt + ", payActualPpleAmt=" + payActualPpleAmt + ", stat=" + stat + ", created=" + created + ", modified=" + modified + "]";
	}
}