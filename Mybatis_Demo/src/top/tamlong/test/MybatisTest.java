package top.tamlong.test;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import top.tamlong.po.Customer;

// ������
public class MybatisTest {

	/**
	 * 
	 * ���ݿͻ���Ų�ѯ�ͻ���Ϣ
	 * 
	 * @throws Exception
	 */
	@Test
	public void findCustomerByIdTest() throws Exception {
		// 1.��ȡ�����ļ�
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 2.���������ļ�����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.ͨ��SqlSessionFactory����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 4.SqlSessionִ��ӳ���ļ��ж����sql��������ִ�н��
		Customer customer = sqlSession.selectOne("top.tamlong.mapper" + ".CustomerMapper.findCustomerById", 1);
		// ��ӡ������
		System.out.println(customer.toString());
		// 5.�ر�sqlSession
		sqlSession.close();
	}

	/**
	 * ��ӿͻ�
	 * 
	 * @throws Exception
	 */
	@Test
	public void addCustomerTest() throws Exception {
		// 1.��ȡ�����ļ�
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 2.���������ļ�����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.ͨ��SqlSessionFactory����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 4.SqlSessionִ����Ӳ���
		// 4.1����Customer���󣬲���������������
		Customer customer = new Customer();
		customer.setUsername("rose");
		customer.setJobs("student");
		customer.setPhone("1196857485");
		// 4.2ִ��SqlSession�Ĳ��뷽�������ص�����Ӱ�������
		int row = sqlSession.insert("tom.tamlong.mapper" + ".CustomerMapper.addCustomer", customer);
		// 4.3ͨ�����ؽ�������ж��Ƿ�ִ�гɹ�
		if (row > 0) {
			System.out.println("���ɹ�������" + row + "�����ݣ�");
		} else {
			System.out.println("ִ�в������ʧ�ܣ�");
		}
		// 4.4�ύ����
		sqlSession.commit();
		// 5.�ر�SqlSession
		sqlSession.close();
	}

	/*
	 * ���¿ͻ���Ϣ
	 */
	@Test
	public void updateCustomerTest() throws Exception {
		// 1.��ȡ�����ļ���Ϣ
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 2.���������ļ�����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.ͨ��SqlSessionFactory����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 4.SqlSessionִ�и��²���
		// 4.1����Customer���󣬶Զ����е����ݽ��и���
		Customer customer = new Customer();
		customer.setId(4);
		customer.setUsername("rose");
		customer.setJobs("programmer");
		customer.setPhone("12345678996");
		// 4.2ִ��SqlSession�ĸ��·�����������Ӱ�������
		int row = sqlSession.update("top.tamlong.mapper" + ".CustomerMapper.updateCustomer", customer);
		// 4.3ͨ�����ص������ж��Ƿ��������
		if (row > 0) {
			System.out.println("���ɹ��޸���" + row + "�����ݣ�");
		} else {
			System.out.println("ִ���޸Ĳ���ʧ�ܣ�");
		}
		// 4.4�ύ����
		sqlSession.commit();
		// 5.�ر�����
		sqlSession.close();
	}

	/**
	 * ɾ���ͻ���Ϣ
	 */
	@Test
	public void deleteCustomerTest() throws Exception {
		// 1.��ȡ�����ļ���Ϣ
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 2.���������ļ�����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.ͨ��SqlSessionFactory����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 4.SqlSessionִ�и��²���
		// 4.1ִ��SqlSession�ĸ��·�����������Ӱ�������
		int row = sqlSession.delete("top.tamlong.mapper" + ".CustomerMapper.deleteCustomer", 1);
		// 4.2ͨ�����ص������ж��Ƿ��������
		if (row > 0) {
			System.out.println("���ɹ�ɾ����" + row + "�����ݣ�");
		} else {
			System.out.println("ִ��ɾ������ʧ�ܣ�");
		}
		// 4.3�ύ����
		sqlSession.commit();
		// 5.�ر�����
		sqlSession.close();
	}

}
