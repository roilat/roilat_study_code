/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package cn.roilat.study.libs.jaxb.demo2.model;

import java.util.List;

/**
 * 插入边动作模型
 * 
 * @author qianyu
 * @version $Id: InsertEdgeAction.java, v 0.1 2018年9月4日 上午11:43:34 qianyu Exp $
 */
public class InsertEdgeAction extends GscOgmAction {

    /** serialVersionUID */
    private static final long serialVersionUID = -3059019772104426094L;

    /** 类型 */
    private String            label;

    /** 属性映射集合 */
    private List<Prop>        props;

    /** 起始顶点 */
    private StartV            startV;

    /** 结尾顶点 */
    private EndV              endV;

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

    /**
     * Getter method for property <tt>startV</tt>.
     * 
     * @return property value of startV
     */
    public StartV getStartV() {
        return startV;
    }

    /**
     * Setter method for property <tt>startV</tt>.
     * 
     * @param startV value to be assigned to property startV
     */
    public void setStartV(StartV startV) {
        this.startV = startV;
    }

    /**
     * Getter method for property <tt>endV</tt>.
     * 
     * @return property value of endV
     */
    public EndV getEndV() {
        return endV;
    }

    /**
     * Setter method for property <tt>endV</tt>.
     * 
     * @param endV value to be assigned to property endV
     */
    public void setEndV(EndV endV) {
        this.endV = endV;
    }

}
