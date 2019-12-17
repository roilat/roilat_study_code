package cn.roilat.biz.blog.dbo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.roilat.biz.blog.po.BlogArticlePO;
import cn.roilat.framework.common.query.BaseDO;
import cn.roilat.framework.common.query.Criteria;
import cn.roilat.framework.common.query.Criterion;
import cn.roilat.framework.util.StringUtils;

/**
 * 博客文章-数据访问对象
 * 
 * @author roilat-J
 * @version $Id: BlogArticleDO.java, v 0.1 2019年3月7日 下午4:42:52 roilat-J Exp $
 */
public class BlogArticleDO extends BaseDO<BlogArticlePO> {
    public Criteria buildCriteria(BlogArticlePO blogArticlePO) {
        GeneratedCriteria criteria = new GeneratedCriteria();
        this.criterias.add(criteria);
        if(blogArticlePO == null) {
            return criteria;
        }
        this.orderByClause = blogArticlePO.getOrderByClause();
        if(StringUtils.isNotEmpty(blogArticlePO.getTitle())) {
            criteria.andTitleLike("%" + blogArticlePO.getTitle() + "%");
        }
        if(StringUtils.isNotEmpty(blogArticlePO.getCode())) {
            criteria.andCodeEqualTo(blogArticlePO.getCode());
        }
        if(StringUtils.isNotEmpty(blogArticlePO.getCreator())) {
            criteria.andCreatorEqualTo(blogArticlePO.getCreator());
        }
        if(StringUtils.isNotEmpty(blogArticlePO.getSource())) {
            criteria.andSourceEqualTo(blogArticlePO.getSource());
        }
        if(blogArticlePO.getCreateDtStart() != null && blogArticlePO.getCreateDtEnd() != null) {
            criteria.andCreateDtBetween(blogArticlePO.getCreateDtStart(), blogArticlePO.getCreateDtEnd());
        }
        if(blogArticlePO.getUpdateDtStart() != null && blogArticlePO.getUpdateDtEnd() != null) {
            criteria.andUpdateDtBetween(blogArticlePO.getUpdateDtStart(), blogArticlePO.getUpdateDtEnd());
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new GeneratedCriteria();
        return criteria;
    }

    @Override
    public String toString() {
        return "BlogArticleDO [orderByClause=" + orderByClause + ", distinct=" + distinct
               + ", criterias=" + criterias + "]";
    }


    public static class GeneratedCriteria extends Criteria {
        public List<Criterion> criteria;

        @Override
        public String toString() {
            return "GeneratedCriteria [criteria=" + criteria + "]";
        }

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        public Criteria addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
            return this;
        }

        public Criteria addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
            return this;
        }

        public Criteria addCriterion(String condition, Object value1, Object value2,
                                    String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
            return this;
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCoverIsNull() {
            addCriterion("COVER is null");
            return (Criteria) this;
        }

        public Criteria andCoverIsNotNull() {
            addCriterion("COVER is not null");
            return (Criteria) this;
        }

        public Criteria andCoverEqualTo(String value) {
            addCriterion("COVER =", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotEqualTo(String value) {
            addCriterion("COVER <>", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThan(String value) {
            addCriterion("COVER >", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThanOrEqualTo(String value) {
            addCriterion("COVER >=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThan(String value) {
            addCriterion("COVER <", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThanOrEqualTo(String value) {
            addCriterion("COVER <=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLike(String value) {
            addCriterion("COVER like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotLike(String value) {
            addCriterion("COVER not like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverIn(List<String> values) {
            addCriterion("COVER in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotIn(List<String> values) {
            addCriterion("COVER not in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverBetween(String value1, String value2) {
            addCriterion("COVER between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotBetween(String value1, String value2) {
            addCriterion("COVER not between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("SOURCE =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("SOURCE <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("SOURCE >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCE >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("SOURCE <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("SOURCE <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("SOURCE like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("SOURCE not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("SOURCE in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("SOURCE not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("SOURCE between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("SOURCE not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andAttachmentsIsNull() {
            addCriterion("ATTACHMENTS is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentsIsNotNull() {
            addCriterion("ATTACHMENTS is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentsEqualTo(String value) {
            addCriterion("ATTACHMENTS =", value, "attachments");
            return (Criteria) this;
        }

        public Criteria andAttachmentsNotEqualTo(String value) {
            addCriterion("ATTACHMENTS <>", value, "attachments");
            return (Criteria) this;
        }

        public Criteria andAttachmentsGreaterThan(String value) {
            addCriterion("ATTACHMENTS >", value, "attachments");
            return (Criteria) this;
        }

        public Criteria andAttachmentsGreaterThanOrEqualTo(String value) {
            addCriterion("ATTACHMENTS >=", value, "attachments");
            return (Criteria) this;
        }

        public Criteria andAttachmentsLessThan(String value) {
            addCriterion("ATTACHMENTS <", value, "attachments");
            return (Criteria) this;
        }

        public Criteria andAttachmentsLessThanOrEqualTo(String value) {
            addCriterion("ATTACHMENTS <=", value, "attachments");
            return (Criteria) this;
        }

        public Criteria andAttachmentsLike(String value) {
            addCriterion("ATTACHMENTS like", value, "attachments");
            return (Criteria) this;
        }

        public Criteria andAttachmentsNotLike(String value) {
            addCriterion("ATTACHMENTS not like", value, "attachments");
            return (Criteria) this;
        }

        public Criteria andAttachmentsIn(List<String> values) {
            addCriterion("ATTACHMENTS in", values, "attachments");
            return (Criteria) this;
        }

        public Criteria andAttachmentsNotIn(List<String> values) {
            addCriterion("ATTACHMENTS not in", values, "attachments");
            return (Criteria) this;
        }

        public Criteria andAttachmentsBetween(String value1, String value2) {
            addCriterion("ATTACHMENTS between", value1, value2, "attachments");
            return (Criteria) this;
        }

        public Criteria andAttachmentsNotBetween(String value1, String value2) {
            addCriterion("ATTACHMENTS not between", value1, value2, "attachments");
            return (Criteria) this;
        }

        public Criteria andIfPublishIsNull() {
            addCriterion("IF_PUBLISH is null");
            return (Criteria) this;
        }

        public Criteria andIfPublishIsNotNull() {
            addCriterion("IF_PUBLISH is not null");
            return (Criteria) this;
        }

        public Criteria andIfPublishEqualTo(String value) {
            addCriterion("IF_PUBLISH =", value, "ifPublish");
            return (Criteria) this;
        }

        public Criteria andIfPublishNotEqualTo(String value) {
            addCriterion("IF_PUBLISH <>", value, "ifPublish");
            return (Criteria) this;
        }

        public Criteria andIfPublishGreaterThan(String value) {
            addCriterion("IF_PUBLISH >", value, "ifPublish");
            return (Criteria) this;
        }

        public Criteria andIfPublishGreaterThanOrEqualTo(String value) {
            addCriterion("IF_PUBLISH >=", value, "ifPublish");
            return (Criteria) this;
        }

        public Criteria andIfPublishLessThan(String value) {
            addCriterion("IF_PUBLISH <", value, "ifPublish");
            return (Criteria) this;
        }

        public Criteria andIfPublishLessThanOrEqualTo(String value) {
            addCriterion("IF_PUBLISH <=", value, "ifPublish");
            return (Criteria) this;
        }

        public Criteria andIfPublishLike(String value) {
            addCriterion("IF_PUBLISH like", value, "ifPublish");
            return (Criteria) this;
        }

        public Criteria andIfPublishNotLike(String value) {
            addCriterion("IF_PUBLISH not like", value, "ifPublish");
            return (Criteria) this;
        }

        public Criteria andIfPublishIn(List<String> values) {
            addCriterion("IF_PUBLISH in", values, "ifPublish");
            return (Criteria) this;
        }

        public Criteria andIfPublishNotIn(List<String> values) {
            addCriterion("IF_PUBLISH not in", values, "ifPublish");
            return (Criteria) this;
        }

        public Criteria andIfPublishBetween(String value1, String value2) {
            addCriterion("IF_PUBLISH between", value1, value2, "ifPublish");
            return (Criteria) this;
        }

        public Criteria andIfPublishNotBetween(String value1, String value2) {
            addCriterion("IF_PUBLISH not between", value1, value2, "ifPublish");
            return (Criteria) this;
        }

        public Criteria andIfCommentIsNull() {
            addCriterion("IF_COMMENT is null");
            return (Criteria) this;
        }

        public Criteria andIfCommentIsNotNull() {
            addCriterion("IF_COMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andIfCommentEqualTo(String value) {
            addCriterion("IF_COMMENT =", value, "ifComment");
            return (Criteria) this;
        }

        public Criteria andIfCommentNotEqualTo(String value) {
            addCriterion("IF_COMMENT <>", value, "ifComment");
            return (Criteria) this;
        }

        public Criteria andIfCommentGreaterThan(String value) {
            addCriterion("IF_COMMENT >", value, "ifComment");
            return (Criteria) this;
        }

        public Criteria andIfCommentGreaterThanOrEqualTo(String value) {
            addCriterion("IF_COMMENT >=", value, "ifComment");
            return (Criteria) this;
        }

        public Criteria andIfCommentLessThan(String value) {
            addCriterion("IF_COMMENT <", value, "ifComment");
            return (Criteria) this;
        }

        public Criteria andIfCommentLessThanOrEqualTo(String value) {
            addCriterion("IF_COMMENT <=", value, "ifComment");
            return (Criteria) this;
        }

        public Criteria andIfCommentLike(String value) {
            addCriterion("IF_COMMENT like", value, "ifComment");
            return (Criteria) this;
        }

        public Criteria andIfCommentNotLike(String value) {
            addCriterion("IF_COMMENT not like", value, "ifComment");
            return (Criteria) this;
        }

        public Criteria andIfCommentIn(List<String> values) {
            addCriterion("IF_COMMENT in", values, "ifComment");
            return (Criteria) this;
        }

        public Criteria andIfCommentNotIn(List<String> values) {
            addCriterion("IF_COMMENT not in", values, "ifComment");
            return (Criteria) this;
        }

        public Criteria andIfCommentBetween(String value1, String value2) {
            addCriterion("IF_COMMENT between", value1, value2, "ifComment");
            return (Criteria) this;
        }

        public Criteria andIfCommentNotBetween(String value1, String value2) {
            addCriterion("IF_COMMENT not between", value1, value2, "ifComment");
            return (Criteria) this;
        }

        public Criteria andCreateDtIsNull() {
            addCriterion("CREATE_DT is null");
            return (Criteria) this;
        }

        public Criteria andCreateDtIsNotNull() {
            addCriterion("CREATE_DT is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDtEqualTo(Date value) {
            addCriterion("CREATE_DT =", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtNotEqualTo(Date value) {
            addCriterion("CREATE_DT <>", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtGreaterThan(Date value) {
            addCriterion("CREATE_DT >", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DT >=", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtLessThan(Date value) {
            addCriterion("CREATE_DT <", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DT <=", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtIn(List<Date> values) {
            addCriterion("CREATE_DT in", values, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtNotIn(List<Date> values) {
            addCriterion("CREATE_DT not in", values, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtBetween(Date value1, Date value2) {
            addCriterion("CREATE_DT between", value1, value2, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DT not between", value1, value2, "createDt");
            return (Criteria) this;
        }

        public Criteria andUpdateDtIsNull() {
            addCriterion("UPDATE_DT is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDtIsNotNull() {
            addCriterion("UPDATE_DT is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDtEqualTo(Date value) {
            addCriterion("UPDATE_DT =", value, "updateDt");
            return (Criteria) this;
        }

        public Criteria andUpdateDtNotEqualTo(Date value) {
            addCriterion("UPDATE_DT <>", value, "updateDt");
            return (Criteria) this;
        }

        public Criteria andUpdateDtGreaterThan(Date value) {
            addCriterion("UPDATE_DT >", value, "updateDt");
            return (Criteria) this;
        }

        public Criteria andUpdateDtGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DT >=", value, "updateDt");
            return (Criteria) this;
        }

        public Criteria andUpdateDtLessThan(Date value) {
            addCriterion("UPDATE_DT <", value, "updateDt");
            return (Criteria) this;
        }

        public Criteria andUpdateDtLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DT <=", value, "updateDt");
            return (Criteria) this;
        }

        public Criteria andUpdateDtIn(List<Date> values) {
            addCriterion("UPDATE_DT in", values, "updateDt");
            return (Criteria) this;
        }

        public Criteria andUpdateDtNotIn(List<Date> values) {
            addCriterion("UPDATE_DT not in", values, "updateDt");
            return (Criteria) this;
        }

        public Criteria andUpdateDtBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DT between", value1, value2, "updateDt");
            return (Criteria) this;
        }

        public Criteria andUpdateDtNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DT not between", value1, value2, "updateDt");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("CREATOR is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("CREATOR is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("CREATOR =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("CREATOR <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("CREATOR >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("CREATOR >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("CREATOR <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("CREATOR <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("CREATOR like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("CREATOR not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("CREATOR in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("CREATOR not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("CREATOR between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("CREATOR not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNull() {
            addCriterion("UPDATOR is null");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNotNull() {
            addCriterion("UPDATOR is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatorEqualTo(String value) {
            addCriterion("UPDATOR =", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotEqualTo(String value) {
            addCriterion("UPDATOR <>", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThan(String value) {
            addCriterion("UPDATOR >", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATOR >=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThan(String value) {
            addCriterion("UPDATOR <", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThanOrEqualTo(String value) {
            addCriterion("UPDATOR <=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLike(String value) {
            addCriterion("UPDATOR like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotLike(String value) {
            addCriterion("UPDATOR not like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorIn(List<String> values) {
            addCriterion("UPDATOR in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotIn(List<String> values) {
            addCriterion("UPDATOR not in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorBetween(String value1, String value2) {
            addCriterion("UPDATOR between", value1, value2, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotBetween(String value1, String value2) {
            addCriterion("UPDATOR not between", value1, value2, "updator");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

}