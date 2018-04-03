package com.github.johnsonmoon.sql.Utils.generator.core;

import org.junit.Test;
import com.github.johnsonmoon.sql.generator.core.Criteria;
import com.github.johnsonmoon.sql.generator.core.Update;

/**
 * Created by xuyh at 2017/9/22 18:20.
 */
public class UpdateTest {
	@Test
	public void test() {
		Update update = Update.update("student").set("name", "Johnson").set("phoneNumber", "123456887").set("level", 13)
				.addWhere(
						Criteria.where("score").between(60, 100));
		System.out.println(update.getSql());
	}
}
