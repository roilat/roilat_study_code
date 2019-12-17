package cn.roilat.framework.common.exception;

import cn.roilat.framework.util.StringUtils;

/**
 * 系统异常
 * 
 * @author roilat-J
 * @version $Id: LinjiezhijiaException.java, v 0.1 2019年3月11日 下午6:16:56 roilat-J Exp $
 */
public class SevenBoException extends RuntimeException {

    /**  */
    private static final long          serialVersionUID = 2194384822886925259L;

    private SevenBoErrorCodeEnums exceptionCodeEnums;

    public SevenBoException(SevenBoErrorCodeEnums exceptionCodeEnums) {
        super(exceptionCodeEnums != null ? exceptionCodeEnums.getDesc() : "unknown error");
        this.exceptionCodeEnums = exceptionCodeEnums;
    }

    public SevenBoException(SevenBoErrorCodeEnums exceptionCodeEnums, String msg) {
        super(StringUtils.isNotEmpty(msg) ? msg
            : exceptionCodeEnums != null ? exceptionCodeEnums.getDesc() : "unknown error");
        this.exceptionCodeEnums = exceptionCodeEnums;
    }

    public SevenBoErrorCodeEnums getExceptionCodeEnums() {
        return exceptionCodeEnums;
    }

    public void setExceptionCodeEnums(SevenBoErrorCodeEnums exceptionCodeEnums) {
        this.exceptionCodeEnums = exceptionCodeEnums;
    }

}
