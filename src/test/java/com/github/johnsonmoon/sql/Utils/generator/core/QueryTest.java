package com.github.johnsonmoon.sql.Utils.generator.core;

import org.junit.Test;
import com.github.johnsonmoon.sql.generator.core.Criteria;
import com.github.johnsonmoon.sql.generator.core.Order;
import com.github.johnsonmoon.sql.generator.core.Query;

/**
 * Created by xuyh at 2017/9/22 11:42.
 */
public class QueryTest {
	@Test
	public void test() {
		Query query = Query.selectAll().from("table1");
		String sql = query.getSql();
		System.out.println(sql);

		Query query1 = Query.selectDistinct("name as A", "address as B", "phoneNumber as C", "email as B")
				.from("student as s").innerJoin("teacher as t").addWhere(Criteria.where("name").is("johnson"));
		String sql1 = query1.getSql();
		System.out.println(sql1);

		Query query2 = Query.selectAll().from("student").leftJoin("teacher")
				.addWhere(Criteria.where("student.teacherId").equalsField("teacher.id"))
				.addOrderBy(Order.orderBy("student.name").direction_ASC());
		String sql2 = query2.getSql();
		System.out.println(sql2);

		Query query3 = Query.select("name", "id", "phoneNumber").from("student")
				.addWhere(Criteria.where("age").notBetween(10, 12))
				.addOrderBy(Order.orderBy("name").direction_DESC());
		System.out.println(query3.getSql());

		Query query5 = Query.select("name").from("temp_student").addWhere(Criteria.where("score").gte(80));
		Query query4 = Query.selectAll().from("student").addWhere(Criteria.where("name")
				.in(query5));
		System.out.println(query4.getSql());

		System.out.println(
				Query.select("COUNT(DISTINCT name)").from("student").getSql());

		System.out.println(
				Query.select("stu_id", "SUM(score) AS sum_score").from("student_score").addGorupBy("stu_id").getSql());
	}

}
