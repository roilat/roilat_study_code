package cn.roilat.biz.blog.po;

import cn.roilat.framework.common.BasePO;

/**
 * 博客类目-参数对象
 * 
 * @author roilat-J
 * @version $Id: BlogCategoryPO.java, v 0.1 2019年3月7日 下午4:42:00 roilat-J Exp $
 */
public class BlogCategoryPO extends BasePO{
    /**
     *类目类型(L:link,A:article)
     */
    private String  type;

    /**
     *类目编码(Cxxxx<4位数字>)
     */
    private String  code;

    /**
     *类目编码路径
     */
    private String  path;

    /**
     *类目层级
     */
    private Integer   level;

    /**
     *类目排序
     */
    private Integer   orderNum;

    /**
     *文章数量
     */
    private Integer counts;

    /**
     *类目描述
     */
    private String  description;

    /**
     *父类目编码
     */
    private String  pCode;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    @Override
    public String toString() {
        return "BlogCategoryPO [type=" + type + ", code=" + code + ", path=" + path + ", level="
               + level + ", orderNum=" + orderNum + ", counts=" + counts + ", description="
               + description + ", pCode=" + pCode + ", orderByClause=" + orderByClause
               + ", currentPage=" + currentPage + ", pageSize=" + pageSize + ", params=" + params
               + ", id=" + id + ", createDtStart=" + createDtStart + ", createDtEnd=" + createDtEnd
               + ", updateDtStart=" + updateDtStart + ", updateDtEnd=" + updateDtEnd + ", creator="
               + creator + ", updator=" + updator + ", state=" + state + "]";
    }

}