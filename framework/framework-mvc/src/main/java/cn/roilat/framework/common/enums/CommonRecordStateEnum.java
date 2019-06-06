package cn.roilat.framework.common.enums;

/**
 * 通用记录状态
 * 
 * @author roilat-J
 * @version $Id: CommonRecordStateEnum.java, v 0.1 2019年3月11日 下午5:13:34 roilat-J Exp $
 */
public enum CommonRecordStateEnum {
    NORMAL("1","正常记录"),
    DELETE("0","已删除记录");
    String code;
    String desc;
    private CommonRecordStateEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public String getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }
    public String toString() {
        return code;
    }
}
