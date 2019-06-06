package cn.roilat.modules.system.entity.dto;

import java.io.Serializable;
import java.util.Date;

public class OrganizationDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String ids;
	private String abbreviation;
	private Date createTime;
	private String createUser;
	private String description;
	private Date modifyTime;
	private String modifyUser;
	private Integer orderNum;
	private String organizationName;
	private Integer parentId;
	private Integer status;
	private String all;

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String[] getIds() {
		if(null != ids){
			return ids.split(",");
		}
		return null;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyUser() {
		return this.modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
