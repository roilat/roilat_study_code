/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package cn.roilat.study.libs.jaxb.demo2.model;

/**
 * ogm动作模型
 * 
 * @author qianyu
 * @version $Id: GscOgmAction.java, v 0.1 2018年9月4日 上午11:43:34 qianyu Exp $
 */
public class GscOgmAction extends GscBaseModel {

    /** serialVersionUID */
    private static final long serialVersionUID = 6959337591264636606L;

    /** 类型 */
    private String            type;

    /**
     * Getter method for property <tt>type</tt>.
     * 
     * @return property value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter method for property <tt>type</tt>.
     * 
     * @param type value to be assigned to property type
     */
    public void setType(String type) {
        this.type = type;
    }

}
