package cn.roilat.framework.common;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.roilat.framework.common.exception.SevenBoErrorCodeEnums;
import cn.roilat.framework.common.exception.SevenBoException;
import cn.roilat.framework.util.DateUtils;
import cn.roilat.framework.util.StringUtils;

/**
 * 查询参数对象基类
 * 
 * @author roilat-J
 * @version $Id: BasePO.java, v 0.1 2019年2月28日 下午4:09:20 roilat-J Exp $
 */
public class BasePO {

    private static final String   DATE_FORMAT = "yyyyMMdd HH:mm:ss";
    protected String              orderByClause;
    protected Integer             currentPage = 1;
    protected Integer             pageSize    = 10;
    protected Map<String, Object> params      = new HashMap<String, Object>();

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    protected Integer id;
    protected Date    createDtStart;
    protected Date    createDtEnd;
    protected Date    updateDtStart;
    protected Date    updateDtEnd;
    protected String  creator;
    protected String  updator;
    protected String  state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCreateDt(String createDt) {
        if (StringUtils.isNotEmpty(createDt)) {
            String[] ss = createDt.split(",");
            try {
                createDtStart = DateUtils.parseDate(ss[0], DATE_FORMAT);
                createDtEnd = ss.length == 2 ? DateUtils.parseDate(ss[1], DATE_FORMAT) : null;
            } catch (ParseException e) {
                throw new SevenBoException(SevenBoErrorCodeEnums.PARAM_FORMAT_ERROR, "请求参数格式错误！【期望的格式：yyyyMMdd HH:mm:ss】");
            }
        }
    }

    public Date getCreateDtStart() {
        return createDtStart;
    }

    public Date getCreateDtEnd() {
        return createDtEnd;
    }

    public void setUpdateDt(String updateDt) {
        if (StringUtils.isNotEmpty(updateDt)) {
            String[] ss = updateDt.split(",");
            try {
                updateDtStart = DateUtils.parseDate(ss[0], DATE_FORMAT);
                updateDtEnd = ss.length == 2 ? DateUtils.parseDate(ss[1], DATE_FORMAT) : null;
            } catch (ParseException e) {
                throw new SevenBoException(SevenBoErrorCodeEnums.PARAM_FORMAT_ERROR, "请求参数格式错误！【期望的格式：yyyyMMdd HH:mm:ss】");
            }
        }
    }

    public Date getUpdateDtStart() {
        return updateDtStart;
    }

    public Date getUpdateDtEnd() {
        return updateDtEnd;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
