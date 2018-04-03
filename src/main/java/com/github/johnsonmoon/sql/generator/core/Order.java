package com.github.johnsonmoon.sql.generator.core;

/**
 * 排序
 * <p>
 * Created by xuyh at 2017/9/22 15:11.
 */
public class Order {
	private final String DIRECTION_ASC = "ASC";
	private final String DIRECTION_DESC = "DESC";

	private String orderby;

	private Order() {
		this.orderby = "ORDER BY ";
	}

	/**
	 * 获取排序条件
	 *
	 * @return
	 */
	public String getOrder() {
		return orderby.trim();
	}

	/**
	 * 创建排序条件
	 *
	 * @param fields
	 * @return
	 */
	public static Order orderBy(String... fields) {
		if (fields == null || fields.length == 0)
			return new Order();
		Order order = new Order();
		String fieldsStr = "";
		for (String field : fields) {
			fieldsStr += (field + ", ");
		}
		fieldsStr = fieldsStr.substring(0, fieldsStr.length() - 2);
		order.orderby += (fieldsStr + " ");
		return order;
	}

	/**
	 * 升序排序
	 *
	 * @return
	 */
	public Order direction_ASC() {
		this.orderby += (DIRECTION_ASC + " ");
		return this;
	}

	/**
	 * 降序排序
	 *
	 * @return
	 */
	public Order direction_DESC() {
		this.orderby += (DIRECTION_DESC + " ");
		return this;
	}

	@Override
	public String toString() {
		return "Order [orderby=" + orderby + "]";
	}
}
