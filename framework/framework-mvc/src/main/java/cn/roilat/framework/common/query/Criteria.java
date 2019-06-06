package cn.roilat.framework.common.query;

public abstract class Criteria {

    public abstract Criteria addCriterion(String condition);
    public abstract Criteria addCriterion(String condition, Object value, String property);
    public abstract Criteria addCriterion(String condition, Object value1, Object value2, String property);

}
