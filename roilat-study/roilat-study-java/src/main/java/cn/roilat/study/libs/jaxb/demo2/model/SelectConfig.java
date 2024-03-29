/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package cn.roilat.study.libs.jaxb.demo2.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * ogm插入配置模型
 * 
 * @author qianyu
 * @version $Id: GscOgmConfig.java, v 0.1 2018年9月4日 上午11:31:20 qianyu Exp $
 */
public class SelectConfig extends GscOgmConfig {

    /** serialVersionUID */
    private static final long serialVersionUID = -5669032939006959574L;

    /** 结果映射 */
    private ResultMap         resultMap;

    /**
     * 验证配置
     */
    public void validate() {

    }

    /**
     * Getter method for property <tt>resultMap</tt>.
     * 
     * @return property value of resultMap
     */
    public ResultMap getResultMap() {
        return resultMap;
    }

    /**
     * Setter method for property <tt>resultMap</tt>.
     * 
     * @param resultMap value to be assigned to property resultMap
     */
    public void setResultMap(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public String getType() {
        return "select";
    }

}
