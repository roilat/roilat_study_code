package cn.roilat.framework.common.result;

public class WebErrorResult extends BaseResult {

    /**  */
    private static final long serialVersionUID = 1L;

    
    public WebErrorResult() {
        this.success = false;
    }

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "WebErrorResult [code=" + code + ", msg=" + msg + ", success=" + success + "]";
    }
    
}
