package com.github.johnsonmoon.sql.Utils.generator.core;

import org.junit.Test;
import com.github.johnsonmoon.sql.generator.core.Insert;

/**
 * Created by xuyh at 2017/9/22 17:14.
 */
public class InsertTest {
	@Test
	public void test() {
		Insert insert = Insert.insertInto("student").values("Johnson", "12345678", "123456789", "123456@qq.com", 12);
		System.out.println(insert.getSql());

		Insert insert1 = Insert.insertInto("student").fields("name", "email", "level").values("Johnson", "123456@qq.com",
				12);
		System.out.println(insert1.getSql());
	}
}
