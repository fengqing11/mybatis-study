package top.tamlong.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import top.tamlong.po.Person;
import top.tamlong.utils.MybatisUtils;

// 测试类
public class MybatisAssociatdTest {

	/**
	 * 嵌套查询
	 */
	@Test
	public void findPersonByIdTest() {
		// 1.通过工具类生成Sqlsess对象
		SqlSession session = MybatisUtils.getSession();
		// 2.使用mybatis嵌套查询的方式查询id为1的人的信息
		Person person = session.selectOne("top.tamlong.mapper." + "PersonMapper.findPersonById", 1);
		// 3.输出查询信息
		System.out.println(person);
		// 4.关闭Sqlsession
		session.close();
	}
}
