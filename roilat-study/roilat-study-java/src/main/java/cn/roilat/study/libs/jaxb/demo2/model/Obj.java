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
public class Obj extends GscBaseModel {

    /** serialVersionUID */
    private static final long serialVersionUID = -8682515778961215603L;

    /** json映射配置 */
    private String            script;

    /**
     * Getter method for property <tt>script</tt>.
     * 
     * @return property value of script
     */
    public String getScript() {
        return script;
    }

    /**
     * Setter method for property <tt>script</tt>.
     * 
     * @param script value to be assigned to property script
     */
    public void setScript(String script) {
        this.script = script;
    }

}
