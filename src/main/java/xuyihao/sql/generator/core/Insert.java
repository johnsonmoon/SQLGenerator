package xuyihao.sql.generator.core;

/**
 * 插入数据
 * <p>
 * Created by xuyh at 2017/9/22 16:40.
 */
public class Insert {
	private String sql;

	private Insert() {
		this.sql = "INSERT INTO ";
	}

	/**
	 * 获取最终的sql语句
	 *
	 * @return
	 */
	public String getSql() {
		return sql.trim();
	}

	/**
	 * 插入数据的表格
	 *
	 * @param table 表格名称
	 * @return
	 */
	public static Insert insertInto(String table) {
		Insert insert = new Insert();
		insert.sql += (table + " ");
		return insert;
	}

	/**
	 * 指定插入数据的字段
	 *
	 * @param fields 字段
	 * @return
	 */
	public Insert fields(String... fields) {
		if (fields == null || fields.length == 0)
			return this;
		String fieldStr = "";
		for (String field : fields) {
			fieldStr += (field + ", ");
		}
		fieldStr = fieldStr.substring(0, fieldStr.length() - 2);
		this.sql += (" ( " + fieldStr + " ) ");
		return this;
	}

	/**
	 * 插入的数据
	 *
	 * @param values 数据
	 * @return
	 */
	public Insert values(Object... values) {
		if (values == null || values.length == 0)
			return this;
		String valueStr = "";
		for (Object value : values) {
			if (value instanceof String) {
				valueStr += ("'" + value + "', ");
			} else {
				valueStr += (String.valueOf(value) + ", ");
			}
		}
		valueStr = valueStr.substring(0, valueStr.length() - 2);
		this.sql += ("VALUES (" + valueStr + ") ");
		return this;
	}

	@Override
	public String toString() {
		return "Insert [sql=" + sql + "]";
	}
}
