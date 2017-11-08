package xuyihao.sql.generator.core;

/**
 * Created by xuyh at 2017/9/22 18:28.
 */
public class Delete {
	private String sql;
	private Criteria criteria;

	private Delete() {
		this.sql = "DELETE FROM ";
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
		return result.trim();
	}

	/**
	 * 删除
	 *
	 * @param table 表名
	 * @return
	 */
	public static Delete deleteFrom(String table) {
		Delete delete = new Delete();
		delete.sql += (table + " ");
		return delete;
	}

	/**
	 * 添加查询条件
	 *
	 * @param criteria 查询条件
	 * @return
	 */
	public Delete addWhere(Criteria criteria) {
		this.criteria = criteria;
		return this;
	}

	@Override
	public String toString() {
		return "Delete [sql=" + sql + ", criteria=" + criteria + "]";
	}
}
