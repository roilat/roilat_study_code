package cn.roilat.modules.system.entity.dto;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
public class UserInfoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	@JSONField (format="yyyy-MM-dd HH:mm:ss") 
	private Date createTime;
	private String createUser;
	private String detailAddress;
	private String email;
	private String mobile;
	private Date modifyTime;
	private String modifyUser;
	private String nickName;
	private String passWord;
	private String qq;
	private Integer status;
	private String trueName;
	private String userName;
	private String wechat;
	private String roles;
	private String all;
	private String groupids;
	private String roleids;
	private Integer isAdmin;
	private String userIds;
	private String newPassword;
	private int modifyPwdType;
	private int modifyUserInfoType;
	private int skin;
	private int notRoleId;
	private int notOrganizationId;
	private String approveUser;
	private float startMoney;
	private float endMoney;
	private String moneySection;
	public String getApproveUser() {
		return approveUser;
	}
	public void setApproveUser(String approveUser) {
		this.approveUser = approveUser;
	}
	public float getStartMoney() {
		return startMoney;
	}
	public void setStartMoney(float startMoney) {
		this.startMoney = startMoney;
	}
	public float getEndMoney() {
		return endMoney;
	}
	public void setEndMoney(float endMoney) {
		this.endMoney = endMoney;
	}
	public String getMoneySection() {
		return moneySection;
	}
	public void setMoneySection(String moneySection) {
		this.moneySection = moneySection;
	}
	public int getNotOrganizationId() {
		return notOrganizationId;
	}
	public void setNotOrganizationId(int notOrganizationId) {
		this.notOrganizationId = notOrganizationId;
	}
	public int getNotRoleId() {
		return notRoleId;
	}
	public void setNotRoleId(int notRoleId) {
		this.notRoleId = notRoleId;
	}
	public int getModifyUserInfoType() {
		return modifyUserInfoType;
	}
	public void setModifyUserInfoType(int modifyUserInfoType) {
		this.modifyUserInfoType = modifyUserInfoType;
	}
	public int getModifyPwdType() {
		return modifyPwdType;
	}
	public void setModifyPwdType(int modifyPwdType) {
		this.modifyPwdType = modifyPwdType;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getUserIds() {
		return userIds;
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
	public Integer getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getGroupids() {
		return groupids;
	}
	public void setGroupids(String groupids) {
		this.groupids = groupids;
	}
	public String getRoleids() {
		return roleids;
	}
	public void setRoleids(String roleids) {
		this.roleids = roleids;
	}
	public String getAll() {
		return all;
	}
	public void setAll(String all) {
		this.all = all;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public int getSkin() {
		return skin;
	}
	public void setSkin(int skin) {
		this.skin = skin;
	}
	
	
}
