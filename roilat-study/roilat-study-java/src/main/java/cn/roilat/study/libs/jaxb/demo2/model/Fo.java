/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package cn.roilat.study.libs.jaxb.demo2.model;

import java.util.List;

/**
 * 属性映射模型
 * 
 * @author qianyu
 * @version $Id: Property.java, v 0.1 2018年9月4日 下午2:57:46 qianyu Exp $
 */
public class Fo extends GscBaseModel {

    /** serialVersionUID */
    private static final long serialVersionUID = -8682515778961215603L;

    /** 属性映射集合 */
    private List<Prop>        props;

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
