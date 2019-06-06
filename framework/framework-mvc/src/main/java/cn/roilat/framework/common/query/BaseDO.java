package cn.roilat.framework.common.query;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseDO<T> implements CriteriaGenerable<T>{
    /**
     * 排序条件
     */
    protected String                 orderByClause;

    /**
     * 是否进行distinct
     */
    protected boolean                distinct;

    /**
     * 查询条件
     */
    protected List<Criteria> criterias;

    public BaseDO() {
        criterias = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getCriterias() {
        return criterias;
    }

    public void or(Criteria criteria) {
        criterias.add(criteria);
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (criterias.size() == 0) {
            criterias.add(criteria);
        }
        return criteria;
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        criterias.add(criteria);
        return criteria;
    }

    protected abstract Criteria createCriteriaInternal();

    public void clear() {
        criterias.clear();
        orderByClause = null;
        distinct = false;
    }
}
