package cn.roilat.biz.blog.po;

import cn.roilat.framework.common.BasePO;

/**
 * 博客文章-参数对象
 * 
 * @author roilat-J
 * @version $Id: BlogArticlePO.java, v 0.1 2019年3月7日 下午4:41:20 roilat-J Exp $
 */
public class BlogArticlePO extends BasePO {

    /**
     *类目编码
     */
    private String code;

    /**
     *博客内容
     */
    private String content;
    /**
     *博客标题
     */
    private String title;

    /**
     *文章封面（一个url）
     */
    private String cover;

    /**
     *内容来源(字典待定)
     */
    private String source;

    /**
     *附件列表(将ID逗号分开)
     */
    private String attachments;

    /**
     *是否公开(1可以,0不可以)
     */
    private String ifPublish;

    /**
     *是否评论(1可以,0不可以)
     */
    private String ifComment;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public String getIfPublish() {
        return ifPublish;
    }

    public void setIfPublish(String ifPublish) {
        this.ifPublish = ifPublish;
    }

    public String getIfComment() {
        return ifComment;
    }

    public void setIfComment(String ifComment) {
        this.ifComment = ifComment;
    }

    @Override
    public String toString() {
        return "BlogArticlePO [code=" + code + ", content=" + content + ", title=" + title
               + ", cover=" + cover + ", source=" + source + ", attachments=" + attachments
               + ", ifPublish=" + ifPublish + ", ifComment=" + ifComment + ", orderByClause="
               + orderByClause + ", currentPage=" + currentPage + ", pageSize=" + pageSize
               + ", params=" + params + ", id=" + id + ", createDtStart=" + createDtStart
               + ", createDtEnd=" + createDtEnd + ", updateDtStart=" + updateDtStart
               + ", updateDtEnd=" + updateDtEnd + ", creator=" + creator + ", updator=" + updator
               + ", state=" + state + "]";
    }

}