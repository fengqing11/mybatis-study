package top.tamlong.test;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import top.tamlong.po.Customer;

// 测试类
public class MybatisTest {

	/**
	 * 
	 * 根据客户编号查询客户信息
	 * 
	 * @throws Exception
	 */
	@Test
	public void findCustomerByIdTest() throws Exception {
		// 1.读取配置文件
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 2.根据配置文件构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.通过SqlSessionFactory创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 4.SqlSession执行映射文件中定义的sql，并返回执行结果
		Customer customer = sqlSession.selectOne("top.tamlong.mapper" + ".CustomerMapper.findCustomerById", 1);
		// 打印输出结果
		System.out.println(customer.toString());
		// 5.关闭sqlSession
		sqlSession.close();
	}

	/**
	 * 添加客户
	 * 
	 * @throws Exception
	 */
	@Test
	public void addCustomerTest() throws Exception {
		// 1.读取配置文件
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 2.根据配置文件构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.通过SqlSessionFactory创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 4.SqlSession执行添加操作
		// 4.1创建Customer对象，并向对象中添加数据
		Customer customer = new Customer();
		customer.setUsername("rose");
		customer.setJobs("student");
		customer.setPhone("1196857485");
		// 4.2执行SqlSession的插入方法，返回的是受影响的行数
		int row = sqlSession.insert("tom.tamlong.mapper" + ".CustomerMapper.addCustomer", customer);
		// 4.3通过返回结果行数判断是否执行成功
		if (row > 0) {
			System.out.println("您成功插入了" + row + "条数据！");
		} else {
			System.out.println("执行插入操作失败！");
		}
		// 4.4提交事务
		sqlSession.commit();
		// 5.关闭SqlSession
		sqlSession.close();
	}

	/*
	 * 更新客户信息
	 */
	@Test
	public void updateCustomerTest() throws Exception {
		// 1.读取配置文件信息
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 2.根据配置文件构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.通过SqlSessionFactory构建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 4.SqlSession执行更新操作
		// 4.1创建Customer对象，对对象中的数据进行更新
		Customer customer = new Customer();
		customer.setId(4);
		customer.setUsername("rose");
		customer.setJobs("programmer");
		customer.setPhone("12345678996");
		// 4.2执行SqlSession的更新方法。返回受影响的行数
		int row = sqlSession.update("top.tamlong.mapper" + ".CustomerMapper.updateCustomer", customer);
		// 4.3通过返回的行数判断是否更新数据
		if (row > 0) {
			System.out.println("您成功修改了" + row + "条数据！");
		} else {
			System.out.println("执行修改操作失败！");
		}
		// 4.4提交事务
		sqlSession.commit();
		// 5.关闭连接
		sqlSession.close();
	}

	/**
	 * 删除客户信息
	 */
	@Test
	public void deleteCustomerTest() throws Exception {
		// 1.读取配置文件信息
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 2.根据配置文件构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.通过SqlSessionFactory构建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 4.SqlSession执行更新操作
		// 4.1执行SqlSession的更新方法。返回受影响的行数
		int row = sqlSession.delete("top.tamlong.mapper" + ".CustomerMapper.deleteCustomer", 1);
		// 4.2通过返回的行数判断是否更新数据
		if (row > 0) {
			System.out.println("您成功删除了" + row + "条数据！");
		} else {
			System.out.println("执行删除操作失败！");
		}
		// 4.3提交事务
		sqlSession.commit();
		// 5.关闭连接
		sqlSession.close();
	}

}
