package xuyihao.sql.generator.core;

/**
 * 查询
 * <p>
 * Created by xuyh at 2017/9/20 15:09.
 */
public class Query {
	private String sql;
	private Criteria criteria;
	private Order order;
	private String groupByField;

	private Query() {
		sql = "SELECT ";
	}

	/**
	 * 获取最终的sql语句
	 *
	 * @return
	 */
	public String getSql() {
		String result = sql;
		if (criteria != null)
			result += (criteria.getCriteria() + " ");
		if (order != null)
			result += (order.getOrder() + " ");
		if (groupByField != null)
			result += ("GROUP BY " + groupByField + " ");
		return result.trim();
	}

	/**
	 * 查询所有字段
	 *
	 * @return
	 */
	public static Query selectAll() {
		Query query = new Query();
		query.sql += "* ";
		return query;
	}

	/**
	 * 查询部分字段
	 * <pre>
	 *  参数fields可以是"field"格式,也可以是"field as alias格式"
	 *
	 *  举例
	 *  1. select("name", ""email);
	 *
	 *  2. select("name as A", "email as B");
	 *
	 * </pre>
	 *
	 * @param fields 需要查询的字段
	 * @return
	 */
	public static Query select(String... fields) {
		if (fields == null || fields.length == 0)
			return new Query();
		//这里的fields可以是单独fields,也可以是fields as alias
		Query query = new Query();
		String filedsStr = "";
		for (String field : fields) {
			filedsStr += (field + ", ");
		}
		filedsStr = filedsStr.substring(0, filedsStr.length() - 2);
		query.sql += (filedsStr + " ");
		return query;
	}

	/**
	 * 查询唯一不同的值
	 * <p>
	 * <pre>
	 *  参数fields可以是"field"格式,也可以是"field as alias格式"
	 *
	 *  举例
	 *  1. select("name", ""email);
	 *
	 *  2. select("name as A", "email as B");
	 *
	 * </pre>
	 *
	 * @param fields 需要查询的字段
	 * @return
	 */
	public static Query selectDistinct(String... fields) {
		if (fields == null || fields.length == 0)
			return new Query();
		Query query = new Query();
		String filedsStr = "";
		for (String field : fields) {
			filedsStr += (field + ", ");
		}
		filedsStr = filedsStr.substring(0, filedsStr.length() - 2);
		query.sql += ("DISTINCT " + filedsStr + " ");
		return query;
	}

	/**
	 * 从表中查询
	 * <pre>
	 *  参数tables可以是"table"格式,也可以是"table as alias格式"
	 *
	 *  举例：
	 *  1. from("table1", ""table2);
	 *
	 *  2. from("table1 as t1", "table2 as t2");
	 *
	 * </pre>
	 *
	 * @param tables 需要查询的表
	 * @return
	 */
	public Query from(String... tables) {
		if (tables == null || tables.length == 0)
			return this;
		String tableStr = "";
		for (String table : tables) {
			tableStr += (table + ", ");
		}
		tableStr = tableStr.substring(0, tableStr.length() - 2);
		this.sql += ("FROM " + tableStr + " ");
		return this;
	}

	/**
	 * 从表中查询
	 * <pre>
	 *  参数table可以是"table"格式,也可以是"table as alias格式"
	 *
	 *  举例：
	 *  1. from("table");
	 *
	 *  2. from("table as t");
	 * </pre>
	 *
	 * @param table
	 * @return
	 */
	public Query from(String table) {
		if (table == null || table.isEmpty())
			return this;
		this.sql += ("FROM " + table + " ");
		return this;
	}

	/**
	 * INNER JOIN另外一张表
	 * <p>
	 * <pre>
	 *  参数table可以是"table"格式,也可以是"table as alias格式"
	 *
	 *  举例：
	 *  1. innerJoin("table");
	 *
	 *  2. innerJoin("table as t");
	 * </pre>
	 *
	 * @param table
	 * @return
	 */
	public Query innerJoin(String table) {
		if (table == null || table.isEmpty())
			return this;
		this.sql += ("INNER JOIN " + table + " ");
		return this;
	}

	/**
	 * LEFT JOIN另外一张表
	 * <p>
	 * <pre>
	 *  参数table可以是"table"格式,也可以是"table as alias格式"
	 *
	 *  举例：
	 *  1. leftJoin("table");
	 *
	 *  2. leftJoin("table as t");
	 * </pre>
	 *
	 * @param table
	 * @return
	 */
	public Query leftJoin(String table) {
		if (table == null || table.isEmpty())
			return this;
		this.sql += ("LEFT JOIN " + table + " ");
		return this;
	}

	/**
	 * RIGHT JOIN另外一张表
	 * <p>
	 * <pre>
	 *  参数table可以是"table"格式,也可以是"table as alias格式"
	 *
	 *  举例：
	 *  1. rightJoin("table");
	 *
	 *  2. rightJoin("table as t");
	 * </pre>
	 *
	 * @param table
	 * @return
	 */
	public Query rightJoin(String table) {
		if (table == null || table.isEmpty())
			return this;
		this.sql += ("RIGHT JOIN " + table + " ");
		return this;
	}

	/**
	 * FULL JOIN另外一张表
	 * <p>
	 * <pre>
	 *  参数table可以是"table"格式,也可以是"table as alias格式"
	 *
	 *  举例：
	 *  1. fullOuterJoin("table");
	 *
	 *  2. fullOuterJoin("table as t");
	 * </pre>
	 *
	 * @param table
	 * @return
	 */
	public Query fullOuterJoin(String table) {
		if (table == null || table.isEmpty())
			return this;
		this.sql += ("FULL OUTER JOIN " + table + " ");
		return this;
	}

	/**
	 * 添加查询条件
	 *
	 * @param criteria 查询条件
	 * @return
	 */
	public Query addWhere(Criteria criteria) {
		this.criteria = criteria;
		return this;
	}

	/**
	 * 添加结果集排序
	 *
	 * @param order
	 * @return
	 */
	public Query addOrderBy(Order order) {
		this.order = order;
		return this;
	}

	/**
	 * 添加分组字段
	 *
	 * @param field
	 * @return
	 */
	public Query addGorupBy(String field) {
		this.groupByField = field;
		return this;
	}

	@Override
	public String toString() {
		return "Query [sql=" + sql + ", criteria=" + criteria + ", order=" + order + ", groupByField=" + groupByField + "]";
	}
}
