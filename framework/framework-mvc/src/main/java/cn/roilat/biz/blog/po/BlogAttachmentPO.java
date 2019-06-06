package cn.roilat.biz.blog.po;

import cn.roilat.framework.common.BasePO;

/**
 * 博客附件-参数对象
 * 
 * @author roilat-J
 * @version $Id: BlogAttachmentPO.java, v 0.1 2019年3月7日 下午4:41:43 roilat-J Exp $
 */
public class BlogAttachmentPO extends BasePO {
    /**
     *博客ID
     */
    private Integer           blogId;

    /**
     *附件全限定名（包括路径和名称）
     */
    private String            savePath;

    /**
     *附件名称
     */
    private String            name;

    /**
     *附件类型(暂未定义)
     */
    private String  type;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BlogAttachmentPO [blogId=" + blogId + ", savePath=" + savePath + ", name=" + name
               + ", type=" + type + ", orderByClause=" + orderByClause + ", currentPage="
               + currentPage + ", pageSize=" + pageSize + ", params=" + params + ", id=" + id
               + ", createDtStart=" + createDtStart + ", createDtEnd=" + createDtEnd
               + ", updateDtStart=" + updateDtStart + ", updateDtEnd=" + updateDtEnd + ", creator="
               + creator + ", updator=" + updator + ", state=" + state + "]";
    }

}