package cn.roilat.biz.blog.model;

import javax.persistence.Table;

import cn.roilat.framework.common.BaseEntity;

/**
 * 博客文章
 * 
 * @author roilat-J
 * @version $Id: BlogArticle.java, v 0.1 2019年3月7日 下午4:40:56 roilat-J Exp $
 */
@Table(name = "t_blog_article")
public class BlogArticle extends BaseEntity {

    /**  */
    private static final long serialVersionUID = 1801207276942130934L;

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
        this.code = code == null ? "" : code.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? "" : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? "" : content.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? "" : cover.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? "" : source.trim();
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments == null ? "" : attachments.trim();
    }

    public String getIfPublish() {
        return ifPublish;
    }

    public void setIfPublish(String ifPublish) {
        this.ifPublish = ifPublish == null ? "" : ifPublish.trim();
    }

    public String getIfComment() {
        return ifComment;
    }

    public void setIfComment(String ifComment) {
        this.ifComment = ifComment == null ? "" : ifComment.trim();
    }

    @Override
    public String toString() {
        return "BlogArticle [code=" + code + ", content=" + content + ", title=" + title
               + ", cover=" + cover + ", source=" + source + ", attachments=" + attachments
               + ", ifPublish=" + ifPublish + ", ifComment=" + ifComment + ", id=" + id
               + ", createDt=" + createDt + ", updateDt=" + updateDt + ", creator=" + creator
               + ", updator=" + updator + ", state=" + state + "]";
    }

}