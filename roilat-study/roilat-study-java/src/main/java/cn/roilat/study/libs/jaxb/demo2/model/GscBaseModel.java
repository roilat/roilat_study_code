/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package cn.roilat.study.libs.jaxb.demo2.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sun.xml.txw2.annotation.XmlElement;

/**
 * 基础模型
 * 
 * @author qianyu
 * @version $Id: GscBaseModel.java, v 0.1 2018年9月4日 上午11:32:26 qianyu Exp $
 */
@XmlElement("configs")
public class GscBaseModel implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 4566833045263979136L;

    /**
     * 重写toString
     * @return      当前对象string
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
