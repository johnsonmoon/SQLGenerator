package xuyihao.sql.generator.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 查询条件
 * <p>
 * Created by xuyh at 2017/9/20 15:09.
 * <p>
 */
public class Criteria {
	private String where;

	public String getCriteria() {
		return where.trim();
	}

	private Criteria() {
		this.where = "WHERE ";
	}

	/**
	 * 普通条件
	 *
	 * @param condition 条件字段
	 * @return
	 */
	public static Criteria where(String condition) {
		Criteria criteria = new Criteria();
		criteria.where += (condition + " ");
		return criteria;
	}

	/**
	 * 复杂条件
	 *
	 * @param complex 查询条件对象
	 * @return
	 */
	public static Criteria where(Criteria complex) {
		Criteria criteria = new Criteria();
		String complexStr = complex.getCriteria();
		complexStr = complexStr.substring(6);
		criteria.where += ("( " + complexStr + " ) ");
		return criteria;
	}

	/**
	 * 并且 普通条件
	 *
	 * @param condition 条件字段
	 * @return
	 */
	public Criteria and(String condition) {
		this.where += ("AND " + condition + " ");
		return this;
	}

	/**
	 * 并且 复杂条件
	 *
	 * @param complex 查询条件对象
	 * @return
	 */
	public Criteria and(Criteria complex) {
		String complexStr = complex.getCriteria();
		complexStr = complexStr.substring(6);
		this.where += ("AND ( " + complexStr + " ) ");
		return this;
	}

	/**
	 * 或者 普通条件
	 *
	 * @param condition 条件字段
	 * @return
	 */
	public Criteria or(String condition) {
		this.where += ("OR " + condition + " ");
		return this;
	}

	/**
	 * 并且 复杂条件
	 *
	 * @param complex 查询条件对象
	 * @return
	 */
	public Criteria or(Criteria complex) {
		String complexStr = complex.getCriteria();
		complexStr = complexStr.substring(6);
		this.where += ("OR ( " + complexStr + " ) ");
		return this;
	}

	/**
	 * 相等
	 *
	 * @param value 值
	 * @return
	 */
	public Criteria is(Object value) {
		if (value instanceof String) {
			this.where += ("= '" + value + "' ");
		} else {
			this.where += ("= " + String.valueOf(value) + " ");
		}
		return this;
	}

	/**
	 * 与其他字段匹配
	 * <p>
	 * <pre>
	 *  field可以是直接的字段名或者 某个表的字段名 table.field
	 *
	 *  举例：
	 *  1. equalsField("field1");
	 *
	 *  2. equalsField("teacher.name");
	 *
	 * </pre>
	 *
	 * @param field 字段名
	 * @return
	 */
	public Criteria equalsField(String field) {
		this.where += ("= " + field + " ");
		return this;
	}

	/**
	 * 模式匹配
	 *
	 * @param pattern 匹配方式
	 * @return
	 */
	public Criteria like(String pattern) {
		this.where += ("LIKE '" + pattern + "' ");
		return this;
	}

	/**
	 * 非 模式匹配
	 *
	 * @param pattern 匹配方式
	 * @return
	 */
	public Criteria notLike(String pattern) {
		this.where += ("NOT LIKE '" + pattern + "' ");
		return this;
	}

	/**
	 * 在集合中
	 *
	 * @param objects 集合
	 * @return
	 */
	public Criteria in(Object... objects) {
		if (objects == null || objects.length == 0)
			return this;
		if (objects[0] instanceof String) {
			String condition = "";
			for (Object object : objects) {
				condition += ("'" + object + "', ");
			}
			condition = condition.substring(0, condition.length() - 2);
			this.where += ("IN (" + condition + ") ");
		} else {
			String condition = "";
			for (Object object : objects) {
				condition += (String.valueOf(object) + ", ");
			}
			condition = condition.substring(0, condition.length() - 2);
			this.where += ("IN (" + condition + ") ");
		}
		return this;
	}

	/**
	 * 在集合中,集合由复杂查询语句得到
	 *
	 * @param selectSentence 完整的查询语句(select * from table where...)
	 * @return
	 */
	public Criteria in(String selectSentence) {
		this.where += ("IN ( " + selectSentence + " ) ");
		return this;
	}

	/**
	 * 在集合中,集合由查询条件对象获取
	 *
	 * @param query
	 * @return
	 */
	public Criteria in(Query query) {
		this.where += ("IN ( " + query.getSql() + " ) ");
		return this;
	}

	/**
	 * 非 在集合中
	 *
	 * @param objects 集合
	 * @return
	 */
	public Criteria notIn(Object... objects) {
		if (objects == null || objects.length == 0)
			return this;
		if (objects[0] instanceof String) {
			String condition = "";
			for (Object object : objects) {
				condition += ("'" + object + "', ");
			}
			condition = condition.substring(0, condition.length() - 2);
			this.where += ("NOT IN (" + condition + ") ");
		} else {
			String condition = "";
			for (Object object : objects) {
				condition += (String.valueOf(object) + ", ");
			}
			condition = condition.substring(0, condition.length() - 2);
			this.where += ("NOT IN (" + condition + ") ");
		}
		return this;
	}

	/**
	 * 非 在集合中,集合由复杂查询语句得到
	 *
	 * @param selectSentence 完整的查询语句(select * from table where...)
	 * @return
	 */
	public Criteria notIn(String selectSentence) {
		this.where += ("NOT IN ( " + selectSentence + " ) ");
		return this;
	}

	/**
	 * 非 在集合中,集合由查询条件对象获取
	 *
	 * @param query
	 * @return
	 */
	public Criteria notIn(Query query) {
		this.where += ("NOT IN ( " + query.getSql() + " ) ");
		return this;
	}

	/**
	 * 在范围之间
	 *
	 * @param a 范围开始
	 * @param b 范围结束
	 * @return
	 */
	public Criteria between(Object a, Object b) {
		if (a instanceof String) {
			this.where += ("BETWEEN '" + a + "' AND '" + b + "' ");
		} else {
			this.where += ("BETWEEN " + String.valueOf(a) + " AND " + String.valueOf(b) + " ");
		}
		return this;
	}

	/**
	 * 非 在范围之间
	 *
	 * @param a 范围开始
	 * @param b 范围结束
	 * @return
	 */
	public Criteria notBetween(Object a, Object b) {
		if (a instanceof String) {
			this.where += ("NOT BETWEEN '" + a + "' AND '" + b + "' ");
		} else {
			this.where += ("NOT BETWEEN " + String.valueOf(a) + " AND " + String.valueOf(b) + " ");
		}
		return this;
	}

	/**
	 * 在集合中
	 *
	 * @param collection 集合
	 * @return
	 */
	public Criteria in(Collection<?> collection) {
		if (collection == null || collection.size() == 0)
			return this;
		List<?> list = new ArrayList<>(collection);
		return in(list.toArray());
	}

	/**
	 * 非 在集合中
	 *
	 * @param collection 集合
	 * @return
	 */
	public Criteria notIn(Collection<?> collection) {
		if (collection == null || collection.size() == 0)
			return this;
		List<?> list = new ArrayList<>(collection);
		return notIn(list.toArray());
	}

	/**
	 * 大于
	 *
	 * @param value 值
	 * @return
	 */
	public Criteria gt(Object value) {
		if (value instanceof String) {
			this.where += ("> '" + value + "' ");
		} else {
			this.where += ("> " + String.valueOf(value) + " ");
		}
		return this;
	}

	/**
	 * 小于
	 *
	 * @param value 值
	 * @return
	 */
	public Criteria lt(Object value) {
		if (value instanceof String) {
			this.where += ("< '" + value + "' ");
		} else {
			this.where += ("< " + String.valueOf(value) + " ");
		}
		return this;
	}

	/**
	 * 大于等于
	 *
	 * @param value 值
	 * @return
	 */
	public Criteria gte(Object value) {
		if (value instanceof String) {
			this.where += (">= '" + value + "' ");
		} else {
			this.where += (">= " + String.valueOf(value) + " ");
		}
		return this;
	}

	/**
	 * 小于等于
	 *
	 * @param value 值
	 * @return
	 */
	public Criteria lte(Object value) {
		if (value instanceof String) {
			this.where += ("<= '" + value + "' ");
		} else {
			this.where += ("<= " + String.valueOf(value) + " ");
		}
		return this;
	}

	@Override
	public String toString() {
		return "Criteria [where=" + where + "]";
	}
}
