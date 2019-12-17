package cn.roilat.framework.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

/**
 * 实体类 - 基类
 * @author roilat-J
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 5482608688105241003L;

    @Id
    protected Integer           id;
    /**
     *创建日期
     */
    protected Date              createDt;

    /**
     *更新日期
     */
    protected Date              updateDt;

    /**
     *创建人
     */
    protected String            creator;

    /**
     *更新人
     */
    protected String            updator;
    /**
     * 记录状态
     */
    protected String            state;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? "" : creator.trim();
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator == null ? "" : updator.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? "" : state.trim();
    }
}
