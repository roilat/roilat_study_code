/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package cn.roilat.study.libs.jaxb.demo2.model;

/**
 * 子查询动作模型
 * 
 * @author qianyu
 * @version $Id: SubQueryAction.java, v 0.1 2018年9月4日 上午11:43:34 qianyu Exp $
 */
public class SubQueryAction extends GscOgmAction {

    /** serialVersionUID */
    private static final long serialVersionUID = -1394445428521173743L;

    /** 别名 */
    private String            as;

    /** 查询脚本 */
    private String            script;

    /**
     * Getter method for property <tt>as</tt>.
     * 
     * @return property value of as
     */
    public String getAs() {
        return as;
    }

    /**
     * Setter method for property <tt>as</tt>.
     * 
     * @param as value to be assigned to property as
     */
    public void setAs(String as) {
        this.as = as;
    }

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
