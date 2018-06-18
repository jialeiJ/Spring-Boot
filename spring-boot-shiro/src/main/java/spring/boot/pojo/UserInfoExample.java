package spring.boot.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

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

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUidIsNull() {
            addCriterion("UID is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("UID is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("UID =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("UID <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("UID >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("UID >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("UID <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("UID <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("UID like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("UID not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("UID in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("UID not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("UID between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("UID not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andXmIsNull() {
            addCriterion("XM is null");
            return (Criteria) this;
        }

        public Criteria andXmIsNotNull() {
            addCriterion("XM is not null");
            return (Criteria) this;
        }

        public Criteria andXmEqualTo(String value) {
            addCriterion("XM =", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotEqualTo(String value) {
            addCriterion("XM <>", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThan(String value) {
            addCriterion("XM >", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThanOrEqualTo(String value) {
            addCriterion("XM >=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThan(String value) {
            addCriterion("XM <", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThanOrEqualTo(String value) {
            addCriterion("XM <=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLike(String value) {
            addCriterion("XM like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotLike(String value) {
            addCriterion("XM not like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmIn(List<String> values) {
            addCriterion("XM in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotIn(List<String> values) {
            addCriterion("XM not in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmBetween(String value1, String value2) {
            addCriterion("XM between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotBetween(String value1, String value2) {
            addCriterion("XM not between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andZhIsNull() {
            addCriterion("ZH is null");
            return (Criteria) this;
        }

        public Criteria andZhIsNotNull() {
            addCriterion("ZH is not null");
            return (Criteria) this;
        }

        public Criteria andZhEqualTo(String value) {
            addCriterion("ZH =", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhNotEqualTo(String value) {
            addCriterion("ZH <>", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhGreaterThan(String value) {
            addCriterion("ZH >", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhGreaterThanOrEqualTo(String value) {
            addCriterion("ZH >=", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhLessThan(String value) {
            addCriterion("ZH <", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhLessThanOrEqualTo(String value) {
            addCriterion("ZH <=", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhLike(String value) {
            addCriterion("ZH like", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhNotLike(String value) {
            addCriterion("ZH not like", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhIn(List<String> values) {
            addCriterion("ZH in", values, "zh");
            return (Criteria) this;
        }

        public Criteria andZhNotIn(List<String> values) {
            addCriterion("ZH not in", values, "zh");
            return (Criteria) this;
        }

        public Criteria andZhBetween(String value1, String value2) {
            addCriterion("ZH between", value1, value2, "zh");
            return (Criteria) this;
        }

        public Criteria andZhNotBetween(String value1, String value2) {
            addCriterion("ZH not between", value1, value2, "zh");
            return (Criteria) this;
        }

        public Criteria andYhmIsNull() {
            addCriterion("YHM is null");
            return (Criteria) this;
        }

        public Criteria andYhmIsNotNull() {
            addCriterion("YHM is not null");
            return (Criteria) this;
        }

        public Criteria andYhmEqualTo(String value) {
            addCriterion("YHM =", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmNotEqualTo(String value) {
            addCriterion("YHM <>", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmGreaterThan(String value) {
            addCriterion("YHM >", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmGreaterThanOrEqualTo(String value) {
            addCriterion("YHM >=", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmLessThan(String value) {
            addCriterion("YHM <", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmLessThanOrEqualTo(String value) {
            addCriterion("YHM <=", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmLike(String value) {
            addCriterion("YHM like", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmNotLike(String value) {
            addCriterion("YHM not like", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmIn(List<String> values) {
            addCriterion("YHM in", values, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmNotIn(List<String> values) {
            addCriterion("YHM not in", values, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmBetween(String value1, String value2) {
            addCriterion("YHM between", value1, value2, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmNotBetween(String value1, String value2) {
            addCriterion("YHM not between", value1, value2, "yhm");
            return (Criteria) this;
        }

        public Criteria andMmIsNull() {
            addCriterion("MM is null");
            return (Criteria) this;
        }

        public Criteria andMmIsNotNull() {
            addCriterion("MM is not null");
            return (Criteria) this;
        }

        public Criteria andMmEqualTo(String value) {
            addCriterion("MM =", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmNotEqualTo(String value) {
            addCriterion("MM <>", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmGreaterThan(String value) {
            addCriterion("MM >", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmGreaterThanOrEqualTo(String value) {
            addCriterion("MM >=", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmLessThan(String value) {
            addCriterion("MM <", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmLessThanOrEqualTo(String value) {
            addCriterion("MM <=", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmLike(String value) {
            addCriterion("MM like", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmNotLike(String value) {
            addCriterion("MM not like", value, "mm");
            return (Criteria) this;
        }

        public Criteria andMmIn(List<String> values) {
            addCriterion("MM in", values, "mm");
            return (Criteria) this;
        }

        public Criteria andMmNotIn(List<String> values) {
            addCriterion("MM not in", values, "mm");
            return (Criteria) this;
        }

        public Criteria andMmBetween(String value1, String value2) {
            addCriterion("MM between", value1, value2, "mm");
            return (Criteria) this;
        }

        public Criteria andMmNotBetween(String value1, String value2) {
            addCriterion("MM not between", value1, value2, "mm");
            return (Criteria) this;
        }

        public Criteria andYzIsNull() {
            addCriterion("YZ is null");
            return (Criteria) this;
        }

        public Criteria andYzIsNotNull() {
            addCriterion("YZ is not null");
            return (Criteria) this;
        }

        public Criteria andYzEqualTo(String value) {
            addCriterion("YZ =", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzNotEqualTo(String value) {
            addCriterion("YZ <>", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzGreaterThan(String value) {
            addCriterion("YZ >", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzGreaterThanOrEqualTo(String value) {
            addCriterion("YZ >=", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzLessThan(String value) {
            addCriterion("YZ <", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzLessThanOrEqualTo(String value) {
            addCriterion("YZ <=", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzLike(String value) {
            addCriterion("YZ like", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzNotLike(String value) {
            addCriterion("YZ not like", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzIn(List<String> values) {
            addCriterion("YZ in", values, "yz");
            return (Criteria) this;
        }

        public Criteria andYzNotIn(List<String> values) {
            addCriterion("YZ not in", values, "yz");
            return (Criteria) this;
        }

        public Criteria andYzBetween(String value1, String value2) {
            addCriterion("YZ between", value1, value2, "yz");
            return (Criteria) this;
        }

        public Criteria andYzNotBetween(String value1, String value2) {
            addCriterion("YZ not between", value1, value2, "yz");
            return (Criteria) this;
        }

        public Criteria andZtIsNull() {
            addCriterion("ZT is null");
            return (Criteria) this;
        }

        public Criteria andZtIsNotNull() {
            addCriterion("ZT is not null");
            return (Criteria) this;
        }

        public Criteria andZtEqualTo(String value) {
            addCriterion("ZT =", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotEqualTo(String value) {
            addCriterion("ZT <>", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThan(String value) {
            addCriterion("ZT >", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThanOrEqualTo(String value) {
            addCriterion("ZT >=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThan(String value) {
            addCriterion("ZT <", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThanOrEqualTo(String value) {
            addCriterion("ZT <=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLike(String value) {
            addCriterion("ZT like", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotLike(String value) {
            addCriterion("ZT not like", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtIn(List<String> values) {
            addCriterion("ZT in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotIn(List<String> values) {
            addCriterion("ZT not in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtBetween(String value1, String value2) {
            addCriterion("ZT between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotBetween(String value1, String value2) {
            addCriterion("ZT not between", value1, value2, "zt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}