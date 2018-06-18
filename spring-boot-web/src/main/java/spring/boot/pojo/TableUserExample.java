package spring.boot.pojo;

import java.util.ArrayList;
import java.util.List;

public class TableUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TableUserExample() {
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

        public Criteria andBhIsNull() {
            addCriterion("BH is null");
            return (Criteria) this;
        }

        public Criteria andBhIsNotNull() {
            addCriterion("BH is not null");
            return (Criteria) this;
        }

        public Criteria andBhEqualTo(String value) {
            addCriterion("BH =", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotEqualTo(String value) {
            addCriterion("BH <>", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhGreaterThan(String value) {
            addCriterion("BH >", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhGreaterThanOrEqualTo(String value) {
            addCriterion("BH >=", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhLessThan(String value) {
            addCriterion("BH <", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhLessThanOrEqualTo(String value) {
            addCriterion("BH <=", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhLike(String value) {
            addCriterion("BH like", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotLike(String value) {
            addCriterion("BH not like", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhIn(List<String> values) {
            addCriterion("BH in", values, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotIn(List<String> values) {
            addCriterion("BH not in", values, "bh");
            return (Criteria) this;
        }

        public Criteria andBhBetween(String value1, String value2) {
            addCriterion("BH between", value1, value2, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotBetween(String value1, String value2) {
            addCriterion("BH not between", value1, value2, "bh");
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

        public Criteria andSfzIsNull() {
            addCriterion("SFZ is null");
            return (Criteria) this;
        }

        public Criteria andSfzIsNotNull() {
            addCriterion("SFZ is not null");
            return (Criteria) this;
        }

        public Criteria andSfzEqualTo(String value) {
            addCriterion("SFZ =", value, "sfz");
            return (Criteria) this;
        }

        public Criteria andSfzNotEqualTo(String value) {
            addCriterion("SFZ <>", value, "sfz");
            return (Criteria) this;
        }

        public Criteria andSfzGreaterThan(String value) {
            addCriterion("SFZ >", value, "sfz");
            return (Criteria) this;
        }

        public Criteria andSfzGreaterThanOrEqualTo(String value) {
            addCriterion("SFZ >=", value, "sfz");
            return (Criteria) this;
        }

        public Criteria andSfzLessThan(String value) {
            addCriterion("SFZ <", value, "sfz");
            return (Criteria) this;
        }

        public Criteria andSfzLessThanOrEqualTo(String value) {
            addCriterion("SFZ <=", value, "sfz");
            return (Criteria) this;
        }

        public Criteria andSfzLike(String value) {
            addCriterion("SFZ like", value, "sfz");
            return (Criteria) this;
        }

        public Criteria andSfzNotLike(String value) {
            addCriterion("SFZ not like", value, "sfz");
            return (Criteria) this;
        }

        public Criteria andSfzIn(List<String> values) {
            addCriterion("SFZ in", values, "sfz");
            return (Criteria) this;
        }

        public Criteria andSfzNotIn(List<String> values) {
            addCriterion("SFZ not in", values, "sfz");
            return (Criteria) this;
        }

        public Criteria andSfzBetween(String value1, String value2) {
            addCriterion("SFZ between", value1, value2, "sfz");
            return (Criteria) this;
        }

        public Criteria andSfzNotBetween(String value1, String value2) {
            addCriterion("SFZ not between", value1, value2, "sfz");
            return (Criteria) this;
        }

        public Criteria andNlIsNull() {
            addCriterion("NL is null");
            return (Criteria) this;
        }

        public Criteria andNlIsNotNull() {
            addCriterion("NL is not null");
            return (Criteria) this;
        }

        public Criteria andNlEqualTo(String value) {
            addCriterion("NL =", value, "nl");
            return (Criteria) this;
        }

        public Criteria andNlNotEqualTo(String value) {
            addCriterion("NL <>", value, "nl");
            return (Criteria) this;
        }

        public Criteria andNlGreaterThan(String value) {
            addCriterion("NL >", value, "nl");
            return (Criteria) this;
        }

        public Criteria andNlGreaterThanOrEqualTo(String value) {
            addCriterion("NL >=", value, "nl");
            return (Criteria) this;
        }

        public Criteria andNlLessThan(String value) {
            addCriterion("NL <", value, "nl");
            return (Criteria) this;
        }

        public Criteria andNlLessThanOrEqualTo(String value) {
            addCriterion("NL <=", value, "nl");
            return (Criteria) this;
        }

        public Criteria andNlLike(String value) {
            addCriterion("NL like", value, "nl");
            return (Criteria) this;
        }

        public Criteria andNlNotLike(String value) {
            addCriterion("NL not like", value, "nl");
            return (Criteria) this;
        }

        public Criteria andNlIn(List<String> values) {
            addCriterion("NL in", values, "nl");
            return (Criteria) this;
        }

        public Criteria andNlNotIn(List<String> values) {
            addCriterion("NL not in", values, "nl");
            return (Criteria) this;
        }

        public Criteria andNlBetween(String value1, String value2) {
            addCriterion("NL between", value1, value2, "nl");
            return (Criteria) this;
        }

        public Criteria andNlNotBetween(String value1, String value2) {
            addCriterion("NL not between", value1, value2, "nl");
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

        public Criteria andSjhIsNull() {
            addCriterion("SJH is null");
            return (Criteria) this;
        }

        public Criteria andSjhIsNotNull() {
            addCriterion("SJH is not null");
            return (Criteria) this;
        }

        public Criteria andSjhEqualTo(String value) {
            addCriterion("SJH =", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhNotEqualTo(String value) {
            addCriterion("SJH <>", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhGreaterThan(String value) {
            addCriterion("SJH >", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhGreaterThanOrEqualTo(String value) {
            addCriterion("SJH >=", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhLessThan(String value) {
            addCriterion("SJH <", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhLessThanOrEqualTo(String value) {
            addCriterion("SJH <=", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhLike(String value) {
            addCriterion("SJH like", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhNotLike(String value) {
            addCriterion("SJH not like", value, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhIn(List<String> values) {
            addCriterion("SJH in", values, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhNotIn(List<String> values) {
            addCriterion("SJH not in", values, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhBetween(String value1, String value2) {
            addCriterion("SJH between", value1, value2, "sjh");
            return (Criteria) this;
        }

        public Criteria andSjhNotBetween(String value1, String value2) {
            addCriterion("SJH not between", value1, value2, "sjh");
            return (Criteria) this;
        }

        public Criteria andJtzzIsNull() {
            addCriterion("JTZZ is null");
            return (Criteria) this;
        }

        public Criteria andJtzzIsNotNull() {
            addCriterion("JTZZ is not null");
            return (Criteria) this;
        }

        public Criteria andJtzzEqualTo(String value) {
            addCriterion("JTZZ =", value, "jtzz");
            return (Criteria) this;
        }

        public Criteria andJtzzNotEqualTo(String value) {
            addCriterion("JTZZ <>", value, "jtzz");
            return (Criteria) this;
        }

        public Criteria andJtzzGreaterThan(String value) {
            addCriterion("JTZZ >", value, "jtzz");
            return (Criteria) this;
        }

        public Criteria andJtzzGreaterThanOrEqualTo(String value) {
            addCriterion("JTZZ >=", value, "jtzz");
            return (Criteria) this;
        }

        public Criteria andJtzzLessThan(String value) {
            addCriterion("JTZZ <", value, "jtzz");
            return (Criteria) this;
        }

        public Criteria andJtzzLessThanOrEqualTo(String value) {
            addCriterion("JTZZ <=", value, "jtzz");
            return (Criteria) this;
        }

        public Criteria andJtzzLike(String value) {
            addCriterion("JTZZ like", value, "jtzz");
            return (Criteria) this;
        }

        public Criteria andJtzzNotLike(String value) {
            addCriterion("JTZZ not like", value, "jtzz");
            return (Criteria) this;
        }

        public Criteria andJtzzIn(List<String> values) {
            addCriterion("JTZZ in", values, "jtzz");
            return (Criteria) this;
        }

        public Criteria andJtzzNotIn(List<String> values) {
            addCriterion("JTZZ not in", values, "jtzz");
            return (Criteria) this;
        }

        public Criteria andJtzzBetween(String value1, String value2) {
            addCriterion("JTZZ between", value1, value2, "jtzz");
            return (Criteria) this;
        }

        public Criteria andJtzzNotBetween(String value1, String value2) {
            addCriterion("JTZZ not between", value1, value2, "jtzz");
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