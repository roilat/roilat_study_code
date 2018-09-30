/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package cn.roilat.study.libs.jaxb.demo2.model;

import java.util.List;

/**
 * 插入顶点动作模型
 * 
 * @author qianyu
 * @version $Id: GscOgmAction.java, v 0.1 2018年9月4日 上午11:43:34 qianyu Exp $
 */
public class InsertVertexAction extends GscOgmAction {

    /** serialVersionUID */
    private static final long serialVersionUID = -1394445428521173743L;

    /** 类型 */
    private String            label;

    /** 业务主键 */
    private String            primaryKey;

    /** 属性映射集合 */
    private List<Prop>        props;

    /**
     * Getter method for property <tt>label</tt>.
     * 
     * @return property value of label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter method for property <tt>label</tt>.
     * 
     * @param label value to be assigned to property label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Getter method for property <tt>primaryKey</tt>.
     * 
     * @return property value of primaryKey
     */
    public String getPrimaryKey() {
        return primaryKey;
    }

    /**
     * Setter method for property <tt>primaryKey</tt>.
     * 
     * @param primaryKey value to be assigned to property primaryKey
     */
    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    /**
     * Getter method for property <tt>props</tt>.
     * 
     * @return property value of props
     */
    public List<Prop> getProps() {
        return props;
    }

    /**
     * Setter method for property <tt>props</tt>.
     * 
     * @param props value to be assigned to property props
     */
    public void setProps(List<Prop> props) {
        this.props = props;
    }

}
