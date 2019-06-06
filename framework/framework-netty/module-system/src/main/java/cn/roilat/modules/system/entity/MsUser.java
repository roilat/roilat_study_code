package cn.roilat.modules.system.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * The persistent class for the ms_user database table.
 * 
 */
@Entity
@Table(name="ms_user")
public class MsUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="JDBC")
	private Integer id;
	@JSONField(format="yyyy-MM-dd HH:mm:ss") 
	@Column(name="create_time")
	private Date createTime;

	@Column(name="create_user")
	private String createUser;

	@Column(name="detail_address")
	private String detailAddress;

	@Column(name="email")
	private String email;

	@Column(name="mobile")
	private String mobile;
	@JSONField(format="yyyy-MM-dd HH:mm:ss") 
	@Column(name="modify_time")
	private Date modifyTime;

	@Column(name="modify_user")
	private String modifyUser;

	@Column(name="nick_name")
	private String nickName;

	@Column(name="password")
	private String passWord;

	@Column(name="qq")
	private String qq;

	@Column(name="status")
	private Integer status;
	
	@Column(name="skin")
	private Integer skin;

	@Column(name="true_name")
	private String trueName;

	@Column(name="user_name")
	private String userName;

	@Column(name="wechat")
	private String wechat;
	
	@Column(name="code")
	private String code;  //工号
	@Column(name="duty")
	private String duty;  //职务
	
	private String flag;
	@Column(name="id_card")
	private String idCard; //身份证
	
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public MsUser() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDetailAddress() {
		return this.detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTrueName() {
		return this.trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getWechat() {
		return this.wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public Integer getSkin() {
		return skin;
	}

	public void setSkin(Integer skin) {
		this.skin = skin;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}