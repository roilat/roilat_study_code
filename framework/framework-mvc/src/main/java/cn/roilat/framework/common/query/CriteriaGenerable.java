package cn.roilat.framework.common.query;

public interface CriteriaGenerable<T> {
    public Criteria buildCriteria(T t);
}
