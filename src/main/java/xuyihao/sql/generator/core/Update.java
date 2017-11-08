package xuyihao.sql.generator.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 更新
 * <p>
 * Created by xuyh at 2017/9/20 15:12.
 */
public class Update {
	private String sql;
	private Map<String, Object> set;
	private Criteria criteria;

	private Update() {
		this.sql = "UPDATE ";
		this.set = new HashMap<>();
	}

	/**
	 * 获取最终的sql语句
	 *
	 * @return
	 */
	public String getSql() {
		String result = sql;
		if (!set.isEmpty()) {
			String setStr = "SET ";
			for (String key : set.keySet()) {
				Object value = set.get(key);
				if (value instanceof String) {
					setStr += (key + " = '" + value + "', ");
				} else {
					setStr += (key + " = " + value + ", ");
				}
			}
			setStr = setStr.substring(0, setStr.length() - 2);
			result += (setStr + " ");
		}
		if (criteria != null)
			result += (criteria.getCriteria() + " ");
		return result.trim();
	}

	/**
	 * 更新
	 *
	 * @param table
	 * @return
	 */
	public static Update update(String table) {
		Update update = new Update();
		update.sql += (table + " ");
		return update;
	}

	/**
	 * 设置值
	 *
	 * @param field
	 * @param value
	 * @return
	 */
	public Update set(String field, Object value) {
		this.set.put(field, value);
		return this;
	}

	/**
	 * 添加查询条件
	 *
	 * @param criteria 查询条件
	 * @return
	 */
	public Update addWhere(Criteria criteria) {
		this.criteria = criteria;
		return this;
	}

	@Override
	public String toString() {
		return "Update [sql=" + sql + ", set=" + set + ", criteria=" + criteria + "]";
	}
}
