/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package cn.roilat.study.libs.jaxb.demo2.model;

/**
 * 结果映射模型
 * 
 * @author qianyu
 * @version $Id: ResultMap.java, v 0.1 2018年9月4日 下午3:26:30 qianyu Exp $
 */
public class ResultMap extends GscBaseModel {

    /** serialVersionUID */
    private static final long serialVersionUID = 4249867147773406251L;

    /** 返回结果类型，支持fobject和Object */
    private String            resultType;

    /** 是否多条数据 */
    private String            multiple;

    /** fobject返回配置 */
    private Fo                fo;

    /**
     * Getter method for property <tt>resultType</tt>.
     * 
     * @return property value of resultType
     */
    public String getResultType() {
        return resultType;
    }

    /**
     * Setter method for property <tt>resultType</tt>.
     * 
     * @param resultType value to be assigned to property resultType
     */
    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    /**
     * Getter method for property <tt>multiple</tt>.
     * 
     * @return property value of multiple
     */
    public String getMultiple() {
        return multiple;
    }

    /**
     * Setter method for property <tt>multiple</tt>.
     * 
     * @param multiple value to be assigned to property multiple
     */
    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

    /**
     * Getter method for property <tt>fo</tt>.
     * 
     * @return property value of fo
     */
    public Fo getFo() {
        return fo;
    }

    /**
     * Setter method for property <tt>fo</tt>.
     * 
     * @param fo value to be assigned to property fo
     */
    public void setFo(Fo fo) {
        this.fo = fo;
    }

}
