package spring.boot.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysRoleExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andKydIsNull() {
            addCriterion("KYD is null");
            return (Criteria) this;
        }

        public Criteria andKydIsNotNull() {
            addCriterion("KYD is not null");
            return (Criteria) this;
        }

        public Criteria andKydEqualTo(String value) {
            addCriterion("KYD =", value, "kyd");
            return (Criteria) this;
        }

        public Criteria andKydNotEqualTo(String value) {
            addCriterion("KYD <>", value, "kyd");
            return (Criteria) this;
        }

        public Criteria andKydGreaterThan(String value) {
            addCriterion("KYD >", value, "kyd");
            return (Criteria) this;
        }

        public Criteria andKydGreaterThanOrEqualTo(String value) {
            addCriterion("KYD >=", value, "kyd");
            return (Criteria) this;
        }

        public Criteria andKydLessThan(String value) {
            addCriterion("KYD <", value, "kyd");
            return (Criteria) this;
        }

        public Criteria andKydLessThanOrEqualTo(String value) {
            addCriterion("KYD <=", value, "kyd");
            return (Criteria) this;
        }

        public Criteria andKydLike(String value) {
            addCriterion("KYD like", value, "kyd");
            return (Criteria) this;
        }

        public Criteria andKydNotLike(String value) {
            addCriterion("KYD not like", value, "kyd");
            return (Criteria) this;
        }

        public Criteria andKydIn(List<String> values) {
            addCriterion("KYD in", values, "kyd");
            return (Criteria) this;
        }

        public Criteria andKydNotIn(List<String> values) {
            addCriterion("KYD not in", values, "kyd");
            return (Criteria) this;
        }

        public Criteria andKydBetween(String value1, String value2) {
            addCriterion("KYD between", value1, value2, "kyd");
            return (Criteria) this;
        }

        public Criteria andKydNotBetween(String value1, String value2) {
            addCriterion("KYD not between", value1, value2, "kyd");
            return (Criteria) this;
        }

        public Criteria andMsIsNull() {
            addCriterion("MS is null");
            return (Criteria) this;
        }

        public Criteria andMsIsNotNull() {
            addCriterion("MS is not null");
            return (Criteria) this;
        }

        public Criteria andMsEqualTo(String value) {
            addCriterion("MS =", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsNotEqualTo(String value) {
            addCriterion("MS <>", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsGreaterThan(String value) {
            addCriterion("MS >", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsGreaterThanOrEqualTo(String value) {
            addCriterion("MS >=", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsLessThan(String value) {
            addCriterion("MS <", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsLessThanOrEqualTo(String value) {
            addCriterion("MS <=", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsLike(String value) {
            addCriterion("MS like", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsNotLike(String value) {
            addCriterion("MS not like", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsIn(List<String> values) {
            addCriterion("MS in", values, "ms");
            return (Criteria) this;
        }

        public Criteria andMsNotIn(List<String> values) {
            addCriterion("MS not in", values, "ms");
            return (Criteria) this;
        }

        public Criteria andMsBetween(String value1, String value2) {
            addCriterion("MS between", value1, value2, "ms");
            return (Criteria) this;
        }

        public Criteria andMsNotBetween(String value1, String value2) {
            addCriterion("MS not between", value1, value2, "ms");
            return (Criteria) this;
        }

        public Criteria andJsIsNull() {
            addCriterion("JS is null");
            return (Criteria) this;
        }

        public Criteria andJsIsNotNull() {
            addCriterion("JS is not null");
            return (Criteria) this;
        }

        public Criteria andJsEqualTo(String value) {
            addCriterion("JS =", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsNotEqualTo(String value) {
            addCriterion("JS <>", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsGreaterThan(String value) {
            addCriterion("JS >", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsGreaterThanOrEqualTo(String value) {
            addCriterion("JS >=", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsLessThan(String value) {
            addCriterion("JS <", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsLessThanOrEqualTo(String value) {
            addCriterion("JS <=", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsLike(String value) {
            addCriterion("JS like", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsNotLike(String value) {
            addCriterion("JS not like", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsIn(List<String> values) {
            addCriterion("JS in", values, "js");
            return (Criteria) this;
        }

        public Criteria andJsNotIn(List<String> values) {
            addCriterion("JS not in", values, "js");
            return (Criteria) this;
        }

        public Criteria andJsBetween(String value1, String value2) {
            addCriterion("JS between", value1, value2, "js");
            return (Criteria) this;
        }

        public Criteria andJsNotBetween(String value1, String value2) {
            addCriterion("JS not between", value1, value2, "js");
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