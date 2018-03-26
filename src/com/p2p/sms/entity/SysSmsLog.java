/* 
 * SysSmsLog.java created on 2016-05-23 下午 18:14:53 by roilatD
 */ 
package com.p2p.sms.entity;
import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.eking.framework.entity.CommonBean;
/**
 * 短信日志表
 * TODO javadoc for com.p2p.sysSmsLog.entity.SysSmsLog
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: roilatD
 * @since: 2016-05-23 下午 18:14:53
 */
@SuppressWarnings({"serial"})
@Alias("SysSmsLog")
public class SysSmsLog extends CommonBean<SysSmsLog> {
	/**
	 * 
	 */
	private Integer Id;

	/**
	 * 用户编号
	 */
	private String custNo;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 时间
	 */
	private Date regDate;


	public Integer getId() {
		return Id;
	}
	public void setId(Integer Id) {
		this.Id = Id;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((custNo == null) ? 0 : custNo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
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
		SysSmsLog other = (SysSmsLog) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (custNo == null) {
			if (other.custNo != null)
				return false;
		} else if (!custNo.equals(other.custNo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SysSmsLog [ Id=" + Id + ", custNo=" + custNo + ", status=" + status + ", regDate=" + regDate + "]";
	}
}