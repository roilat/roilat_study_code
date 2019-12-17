package cn.roilat.modules.system.entity.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import cn.roilat.modules.system.entity.MsPermission;
public class LoginUserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	@JSONField (format="yyyy-MM-dd HH:mm:ss") 
	private Date createTime;

	private String createUser;

	private String detailAddress;

	private String email;

	private String mobile;
	@JSONField (format="yyyy-MM-dd HH:mm:ss") 
	private Date modifyTime;

	private String modifyUser;

	private String nickName;

	private String passWord;

	private String qq;

	private Integer status;

	private String trueName;

	private String userName;

	private String wechat;
	
	private Integer skin;
	
	private List<PermissionDTO>  permissions;
	
	private List<PermissionDTO> menus;
	
	private List<MsPermission> msPermissions;
	

	public List<MsPermission> getMsPermissions() {
		return msPermissions;
	}

	public void setMsPermissions(List<MsPermission> msPermissions) {
		this.msPermissions = msPermissions;
	}

	public List<PermissionDTO> getMenus() {
		return menus;
	}

	public void setMenus(List<PermissionDTO> menus) {
		this.menus = menus;
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

	public List<PermissionDTO> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionDTO> permissions) {
		this.permissions = permissions;
	}

	public Integer getSkin() {
		return skin;
	}

	public void setSkin(Integer skin) {
		this.skin = skin;
	}
	
	
}
