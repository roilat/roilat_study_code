/* 
 * CustInfo.java created on 2016-06-17 上午 10:49:03 by roilatD
 */ 
package com.p2p.user.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 用户信息
 * TODO javadoc for com.p2p.custInfo.entity.CustInfo
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-06-17 上午 10:49:03
 */
@SuppressWarnings({"serial"})
@Alias("CustInfo")
public class CustInfo extends CommonBean<CustInfo> {
	/**
	 * 
	 */
	private String custNo;

	/**
	 * 
	 */
	private String userName;

	/**
	 * 
	 */
	private String moblNo;

	/**
	 * 
	 */
	private String loginPwd;

	/**
	 * 
	 */
	private String acctPwd;

	/**
	 * 
	 */
	private String mesgPwd;

	/**
	 * 
	 */
	private String SEX;

	/**
	 * 
	 */
	private String custName;

	/**
	 * 
	 */
	private String certTyp;

	/**
	 * 
	 */
	private String certNo;

	/**
	 * 
	 */
	private String certValidPerd;

	/**
	 * 
	 */
	private Date birthDate;

	/**
	 * 
	 */
	private Integer POINT;

	/**
	 * 
	 */
	private String loginStat;

	/**
	 * 
	 */
	private String EMAIL;

	/**
	 * 
	 */
	private String acctStat;

	/**
	 * 
	 */
	private String vipFlag;

	/**
	 * 
	 */
	private String authFlag;

	/**
	 * 
	 */
	private Date regDate;

	/**
	 * 
	 */
	private String loanPsnFlag;

	/**
	 * 
	 */
	private String openId;

	/**
	 * 
	 */
	private String loginFlag;

	/**
	 * 
	 */
	private Date lastLoginDate;

	/**
	 * 
	 */
	private String custTyp;

	/**
	 * 
	 */
	private Date instDate;

	/**
	 * 
	 */
	private Date updtDate;


	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMoblNo() {
		return moblNo;
	}
	public void setMoblNo(String moblNo) {
		this.moblNo = moblNo;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getAcctPwd() {
		return acctPwd;
	}
	public void setAcctPwd(String acctPwd) {
		this.acctPwd = acctPwd;
	}
	public String getMesgPwd() {
		return mesgPwd;
	}
	public void setMesgPwd(String mesgPwd) {
		this.mesgPwd = mesgPwd;
	}
	public String getSEX() {
		return SEX;
	}
	public void setSEX(String SEX) {
		this.SEX = SEX;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCertTyp() {
		return certTyp;
	}
	public void setCertTyp(String certTyp) {
		this.certTyp = certTyp;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getCertValidPerd() {
		return certValidPerd;
	}
	public void setCertValidPerd(String certValidPerd) {
		this.certValidPerd = certValidPerd;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Integer getPOINT() {
		return POINT;
	}
	public void setPOINT(Integer POINT) {
		this.POINT = POINT;
	}
	public String getLoginStat() {
		return loginStat;
	}
	public void setLoginStat(String loginStat) {
		this.loginStat = loginStat;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String EMAIL) {
		this.EMAIL = EMAIL;
	}
	public String getAcctStat() {
		return acctStat;
	}
	public void setAcctStat(String acctStat) {
		this.acctStat = acctStat;
	}
	public String getVipFlag() {
		return vipFlag;
	}
	public void setVipFlag(String vipFlag) {
		this.vipFlag = vipFlag;
	}
	public String getAuthFlag() {
		return authFlag;
	}
	public void setAuthFlag(String authFlag) {
		this.authFlag = authFlag;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getLoanPsnFlag() {
		return loanPsnFlag;
	}
	public void setLoanPsnFlag(String loanPsnFlag) {
		this.loanPsnFlag = loanPsnFlag;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getCustTyp() {
		return custTyp;
	}
	public void setCustTyp(String custTyp) {
		this.custTyp = custTyp;
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
		result = prime * result + ((custNo == null) ? 0 : custNo.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((moblNo == null) ? 0 : moblNo.hashCode());
		result = prime * result + ((loginPwd == null) ? 0 : loginPwd.hashCode());
		result = prime * result + ((acctPwd == null) ? 0 : acctPwd.hashCode());
		result = prime * result + ((mesgPwd == null) ? 0 : mesgPwd.hashCode());
		result = prime * result + ((SEX == null) ? 0 : SEX.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((certTyp == null) ? 0 : certTyp.hashCode());
		result = prime * result + ((certNo == null) ? 0 : certNo.hashCode());
		result = prime * result + ((certValidPerd == null) ? 0 : certValidPerd.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((POINT == null) ? 0 : POINT.hashCode());
		result = prime * result + ((loginStat == null) ? 0 : loginStat.hashCode());
		result = prime * result + ((EMAIL == null) ? 0 : EMAIL.hashCode());
		result = prime * result + ((acctStat == null) ? 0 : acctStat.hashCode());
		result = prime * result + ((vipFlag == null) ? 0 : vipFlag.hashCode());
		result = prime * result + ((authFlag == null) ? 0 : authFlag.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result + ((loanPsnFlag == null) ? 0 : loanPsnFlag.hashCode());
		result = prime * result + ((openId == null) ? 0 : openId.hashCode());
		result = prime * result + ((loginFlag == null) ? 0 : loginFlag.hashCode());
		result = prime * result + ((lastLoginDate == null) ? 0 : lastLoginDate.hashCode());
		result = prime * result + ((custTyp == null) ? 0 : custTyp.hashCode());
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
		CustInfo other = (CustInfo) obj;
		if (custNo == null) {
			if (other.custNo != null)
				return false;
		} else if (!custNo.equals(other.custNo))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (moblNo == null) {
			if (other.moblNo != null)
				return false;
		} else if (!moblNo.equals(other.moblNo))
			return false;
		if (loginPwd == null) {
			if (other.loginPwd != null)
				return false;
		} else if (!loginPwd.equals(other.loginPwd))
			return false;
		if (acctPwd == null) {
			if (other.acctPwd != null)
				return false;
		} else if (!acctPwd.equals(other.acctPwd))
			return false;
		if (mesgPwd == null) {
			if (other.mesgPwd != null)
				return false;
		} else if (!mesgPwd.equals(other.mesgPwd))
			return false;
		if (SEX == null) {
			if (other.SEX != null)
				return false;
		} else if (!SEX.equals(other.SEX))
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (certTyp == null) {
			if (other.certTyp != null)
				return false;
		} else if (!certTyp.equals(other.certTyp))
			return false;
		if (certNo == null) {
			if (other.certNo != null)
				return false;
		} else if (!certNo.equals(other.certNo))
			return false;
		if (certValidPerd == null) {
			if (other.certValidPerd != null)
				return false;
		} else if (!certValidPerd.equals(other.certValidPerd))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (POINT == null) {
			if (other.POINT != null)
				return false;
		} else if (!POINT.equals(other.POINT))
			return false;
		if (loginStat == null) {
			if (other.loginStat != null)
				return false;
		} else if (!loginStat.equals(other.loginStat))
			return false;
		if (EMAIL == null) {
			if (other.EMAIL != null)
				return false;
		} else if (!EMAIL.equals(other.EMAIL))
			return false;
		if (acctStat == null) {
			if (other.acctStat != null)
				return false;
		} else if (!acctStat.equals(other.acctStat))
			return false;
		if (vipFlag == null) {
			if (other.vipFlag != null)
				return false;
		} else if (!vipFlag.equals(other.vipFlag))
			return false;
		if (authFlag == null) {
			if (other.authFlag != null)
				return false;
		} else if (!authFlag.equals(other.authFlag))
			return false;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		if (loanPsnFlag == null) {
			if (other.loanPsnFlag != null)
				return false;
		} else if (!loanPsnFlag.equals(other.loanPsnFlag))
			return false;
		if (openId == null) {
			if (other.openId != null)
				return false;
		} else if (!openId.equals(other.openId))
			return false;
		if (loginFlag == null) {
			if (other.loginFlag != null)
				return false;
		} else if (!loginFlag.equals(other.loginFlag))
			return false;
		if (lastLoginDate == null) {
			if (other.lastLoginDate != null)
				return false;
		} else if (!lastLoginDate.equals(other.lastLoginDate))
			return false;
		if (custTyp == null) {
			if (other.custTyp != null)
				return false;
		} else if (!custTyp.equals(other.custTyp))
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
		return "CustInfo [ custNo=" + custNo + ", userName=" + userName + ", moblNo=" + moblNo + ", loginPwd=" + loginPwd + ", acctPwd=" + acctPwd + ", mesgPwd=" + mesgPwd + ", SEX=" + SEX + ", custName=" + custName + ", certTyp=" + certTyp + ", certNo=" + certNo + ", certValidPerd=" + certValidPerd + ", birthDate=" + birthDate + ", POINT=" + POINT + ", loginStat=" + loginStat + ", EMAIL=" + EMAIL + ", acctStat=" + acctStat + ", vipFlag=" + vipFlag + ", authFlag=" + authFlag + ", regDate=" + regDate + ", loanPsnFlag=" + loanPsnFlag + ", openId=" + openId + ", loginFlag=" + loginFlag + ", lastLoginDate=" + lastLoginDate + ", custTyp=" + custTyp + ", instDate=" + instDate + ", updtDate=" + updtDate + "]";
	}
}