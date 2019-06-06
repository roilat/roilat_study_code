package cn.roilat.biz.blog.po;

import cn.roilat.framework.common.BasePO;

/**
 * 博客链接-参数对象
 * 
 * @author roilat-J
 * @version $Id: BlogLinkPO.java, v 0.1 2019年3月7日 下午4:42:28 roilat-J Exp $
 */
public class BlogLinkPO extends BasePO {

    /**
     *链接来源(字典待定)
     */
    private String source;

    /**
     *链接地址
     */
    private String address;

    /**
     *内容快照
     */
    private String snapshoot;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSnapshoot() {
        return snapshoot;
    }

    public void setSnapshoot(String snapshoot) {
        this.snapshoot = snapshoot;
    }

    @Override
    public String toString() {
        return "BlogLinkPO [source=" + source + ", address=" + address + ", snapshoot=" + snapshoot
               + ", orderByClause=" + orderByClause + ", currentPage=" + currentPage + ", pageSize="
               + pageSize + ", params=" + params + ", id=" + id + ", createDtStart=" + createDtStart
               + ", createDtEnd=" + createDtEnd + ", updateDtStart=" + updateDtStart
               + ", updateDtEnd=" + updateDtEnd + ", creator=" + creator + ", updator=" + updator
               + ", state=" + state + "]";
    }

}