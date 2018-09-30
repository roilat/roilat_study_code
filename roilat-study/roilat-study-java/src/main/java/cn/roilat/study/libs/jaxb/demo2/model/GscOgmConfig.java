/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package cn.roilat.study.libs.jaxb.demo2.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * ogm配置模型
 * 
 * @author qianyu
 * @version $Id: GscOgmConfig.java, v 0.1 2018年9月4日 上午11:31:20 qianyu Exp $
 */
@XmlSeeAlso(value = { InsertConfig.class, SelectConfig.class })
@XmlAccessorType(XmlAccessType.NONE)
public abstract class GscOgmConfig extends GscBaseModel {

    /** serialVersionUID */
    private static final long  serialVersionUID = -5669032939006959574L;

    /** 配置ID */
    @XmlAttribute
    private String             id;

    /** db类型 */
    @XmlAttribute
    private String             dbType;

    /** 动作集 */
    private List<GscOgmAction> actions;

    /**
     * 验证配置
     */
    public void validate() {

    }

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>type</tt>.
     * 
     * @return property value of type
     */
    public abstract String getType();


    /**
     * Getter method for property <tt>actions</tt>.
     * 
     * @return property value of actions
     */
    public List<GscOgmAction> getActions() {
        return actions;
    }

    /**
     * Setter method for property <tt>actions</tt>.
     * 
     * @param actions value to be assigned to property actions
     */
    public void setActions(List<GscOgmAction> actions) {
        this.actions = actions;
    }

    /**
     * Getter method for property <tt>dbType</tt>.
     * 
     * @return property value of dbType
     */
    public String getDbType() {
        return dbType;
    }

    /**
     * Setter method for property <tt>dbType</tt>.
     * 
     * @param dbType value to be assigned to property dbType
     */
    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

}
