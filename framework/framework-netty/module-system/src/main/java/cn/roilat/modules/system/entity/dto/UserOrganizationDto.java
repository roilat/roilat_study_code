package cn.roilat.modules.system.entity.dto;

import java.io.Serializable;
public class UserOrganizationDto implements Serializable{

	private static final long serialVersionUID = 1L;
	//用户信息
	private Integer userId;
	private String detailAddress;
	private String appEmail;
	private String mobile;
	private String nickName;
	private String qq;
	private Integer skin;
	private String trueName;
	private String userName;
	private String wechat;
	private String code;  //工号
	private String duty;  //职务
	private String idCard; //身份证
	
	//组织信息
	private Integer organizationId;
	private String organizationCode;
	private String abbreviation;
	private String description;
	private Integer orderNum;
	private String organizationName;
	private Integer parentId;
	private String treeId;
	private String organizationType;
	
	private String applyName;
	private Integer applyUnit;
	private String componyName;
	private Integer applyDept;
	private String deptName;
	
	public String getAppEmail() {
		return appEmail;
	}
	public void setAppEmail(String appEmail) {
		this.appEmail = appEmail;
	}
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public Integer getApplyUnit() {
		return applyUnit;
	}
	public void setApplyUnit(Integer applyUnit) {
		this.applyUnit = applyUnit;
	}
	public String getComponyName() {
		return componyName;
	}
	public void setComponyName(String componyName) {
		this.componyName = componyName;
	}
	public Integer getApplyDept() {
		return applyDept;
	}
	public void setApplyDept(Integer applyDept) {
		this.applyDept = applyDept;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Integer getSkin() {
		return skin;
	}
	public void setSkin(Integer skin) {
		this.skin = skin;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Integer getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
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
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getTreeId() {
		return treeId;
	}
	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}
	public String getOrganizationType() {
		return organizationType;
	}
	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}
}	
