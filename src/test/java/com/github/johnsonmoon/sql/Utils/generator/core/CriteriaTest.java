package com.github.johnsonmoon.sql.Utils.generator.core;

import org.junit.Assert;
import org.junit.Test;
import com.github.johnsonmoon.sql.generator.core.Criteria;

/**
 * Created by xuyh at 2017/9/20 15:35.
 */
public class CriteriaTest {
	@Test
	public void testCriteriaGenerate() {
		Criteria criteria = Criteria.where("field1").in("select * from table").and("field2").notIn("select * from table");
		System.out.println(criteria.getCriteria());
		Assert.assertNotNull(criteria.getCriteria());
	}
}
