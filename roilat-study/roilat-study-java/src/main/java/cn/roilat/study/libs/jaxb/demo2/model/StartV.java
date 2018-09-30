/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package cn.roilat.study.libs.jaxb.demo2.model;

/**
 * 属性映射模型
 * 
 * @author qianyu
 * @version $Id: Property.java, v 0.1 2018年9月4日 下午2:57:46 qianyu Exp $
 */
public class StartV extends GscBaseModel {

    /** serialVersionUID */
    private static final long serialVersionUID = -8682515778961215603L;

    /** 类型 */
    private String            label;

    /** 业务主键 */
    private String            primaryKey;

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

}
