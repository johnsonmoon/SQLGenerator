package com.github.johnsonmoon.sql.Utils.generator.core;

import org.junit.Test;
import com.github.johnsonmoon.sql.generator.core.Order;

/**
 * Created by xuyh at 2017/9/22 15:34.
 */
public class OrderByTest {
	@Test
	public void test() {
		System.out.println(Order.orderBy("name", "phoneNumber").direction_DESC().getOrder());
	}
}
