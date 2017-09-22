package xuyihao.sql.Utils.generator.core;

import org.junit.Test;
import xuyihao.sql.generator.core.Criteria;
import xuyihao.sql.generator.core.Delete;

/**
 * Created by xuyh at 2017/9/22 18:33.
 */
public class DeleteTest {
	@Test
	public void test() {
		System.out.println(Delete.deleteFrom("student").getSql());
		System.out.println(Delete.deleteFrom("student").addWhere(Criteria.where("name").is("Johnson")).getSql());
	}
}
