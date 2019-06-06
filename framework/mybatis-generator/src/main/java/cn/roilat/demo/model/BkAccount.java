package cn.roilat.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`bk_account`")
public class BkAccount extends BkAccountKey implements Serializable {
    /**
     * 用户id
     */
    @Column(name = "`user_id`")
    private Integer userId;

    /**
     * 项目id
     */
    @Column(name = "`project_id`")
    private Integer projectId;

    /**
     * 项目名称
     */
    @Column(name = "`project_name`")
    private String projectName;

    /**
     * 来源（0项目，1工资，2绩效，3年终奖，4现金，5风险保证金，6奖励扣减）
     */
    @Column(name = "`category`")
    private Integer category;

    /**
     * 借款（欠）
     */
    @Column(name = "`borrow`")
    private BigDecimal borrow;

    /**
     * 贷款（还）
     */
    @Column(name = "`loan`")
    private BigDecimal loan;

    /**
     * 会计科目
     */
    @Column(name = "`account`")
    private String account;

    /**
     * 操作日期
     */
    @Column(name = "`option_date`")
    private Date optionDate;

    /**
     * 来源是否是项目（0不是1是）
     */
    @Column(name = "`is_project`")
    private Integer isProject;

    /**
     * 状态
     */
    @Column(name = "`status`")
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "`create_user`")
    private String createUser;

    /**
     * 修改时间
     */
    @Column(name = "`modify_time`")
    private Date modifyTime;

    /**
     * 修改人
     */
    @Column(name = "`modify_user`")
    private String modifyUser;

    /**
     * 预留字段1
     */
    @Column(name = "`remarks1`")
    private String remarks1;

    /**
     * 预留字段2
     */
    @Column(name = "`remarks2`")
    private String remarks2;

    /**
     * 流程审批状态(0:审批中；1：审批通过；-1审批驳回)
     */
    @Column(name = "`approval_status`")
    private Integer approvalStatus;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取项目id
     *
     * @return project_id - 项目id
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 设置项目id
     *
     * @param projectId 项目id
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取项目名称
     *
     * @return project_name - 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名称
     *
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * 获取来源（0项目，1工资，2绩效，3年终奖，4现金，5风险保证金，6奖励扣减）
     *
     * @return category - 来源（0项目，1工资，2绩效，3年终奖，4现金，5风险保证金，6奖励扣减）
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * 设置来源（0项目，1工资，2绩效，3年终奖，4现金，5风险保证金，6奖励扣减）
     *
     * @param category 来源（0项目，1工资，2绩效，3年终奖，4现金，5风险保证金，6奖励扣减）
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     * 获取借款（欠）
     *
     * @return borrow - 借款（欠）
     */
    public BigDecimal getBorrow() {
        return borrow;
    }

    /**
     * 设置借款（欠）
     *
     * @param borrow 借款（欠）
     */
    public void setBorrow(BigDecimal borrow) {
        this.borrow = borrow;
    }

    /**
     * 获取贷款（还）
     *
     * @return loan - 贷款（还）
     */
    public BigDecimal getLoan() {
        return loan;
    }

    /**
     * 设置贷款（还）
     *
     * @param loan 贷款（还）
     */
    public void setLoan(BigDecimal loan) {
        this.loan = loan;
    }

    /**
     * 获取会计科目
     *
     * @return account - 会计科目
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置会计科目
     *
     * @param account 会计科目
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 获取操作日期
     *
     * @return option_date - 操作日期
     */
    public Date getOptionDate() {
        return optionDate;
    }

    /**
     * 设置操作日期
     *
     * @param optionDate 操作日期
     */
    public void setOptionDate(Date optionDate) {
        this.optionDate = optionDate;
    }

    /**
     * 获取来源是否是项目（0不是1是）
     *
     * @return is_project - 来源是否是项目（0不是1是）
     */
    public Integer getIsProject() {
        return isProject;
    }

    /**
     * 设置来源是否是项目（0不是1是）
     *
     * @param isProject 来源是否是项目（0不是1是）
     */
    public void setIsProject(Integer isProject) {
        this.isProject = isProject;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人
     *
     * @return create_user - 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人
     *
     * @param createUser 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取修改人
     *
     * @return modify_user - 修改人
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * 设置修改人
     *
     * @param modifyUser 修改人
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    /**
     * 获取预留字段1
     *
     * @return remarks1 - 预留字段1
     */
    public String getRemarks1() {
        return remarks1;
    }

    /**
     * 设置预留字段1
     *
     * @param remarks1 预留字段1
     */
    public void setRemarks1(String remarks1) {
        this.remarks1 = remarks1 == null ? null : remarks1.trim();
    }

    /**
     * 获取预留字段2
     *
     * @return remarks2 - 预留字段2
     */
    public String getRemarks2() {
        return remarks2;
    }

    /**
     * 设置预留字段2
     *
     * @param remarks2 预留字段2
     */
    public void setRemarks2(String remarks2) {
        this.remarks2 = remarks2 == null ? null : remarks2.trim();
    }

    /**
     * 获取流程审批状态(0:审批中；1：审批通过；-1审批驳回)
     *
     * @return approval_status - 流程审批状态(0:审批中；1：审批通过；-1审批驳回)
     */
    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * 设置流程审批状态(0:审批中；1：审批通过；-1审批驳回)
     *
     * @param approvalStatus 流程审批状态(0:审批中；1：审批通过；-1审批驳回)
     */
    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}