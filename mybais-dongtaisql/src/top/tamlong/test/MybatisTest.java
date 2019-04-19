package top.tamlong.test;

import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.junit.Test;

import top.tamlong.po.Customer;
import top.tamlong.utils.MybatisUtils;

// ������
public class MybatisTest {

	/**
	 * ���ݿͻ���Ϣ��ְҵ��ϲ�ѯ�ͻ���Ϣ�б�
	 */
	@Test
	public void findCustomerByNameAndJobsTest() {
		// ͨ������������
		SqlSession session = MybatisUtils.getSession();
		// ����Custome���󣬷�װ��Ҫ��ϲ�ѯ������
		Customer customer = new Customer();
		customer.setUsername("jack");
		customer.setJobs("teacher");
		// ִ��SqlSession�Ĳ�ѯ���������ؽ����
		List<Customer> customers = session
				.selectList("top.tamlong.mapper" + ".CustomerMapper.findCustomerByNameAndJobs", customer);
		// �����ѯ���
		for (Customer customer2 : customers) {
			// ��ӡ������
			System.out.println(customer2);
		}
		// �ر�SqlSession
		session.close();
	}

	/**
	 * �����û�������ְҵ��ѯ�ͻ���Ϣ
	 */
	@Test
	public void findCustomerByNameOrJobsTest() {
		SqlSession session = MybatisUtils.getSession();
		Customer customer = new Customer();
		customer.setUsername("jack");
		customer.setJobs("teacher");
		List<Customer> customers = session.selectList("top.tamlong.mapper" + ".CustomerMapper.findCustomerByNameOrJobs",
				customer);
		for (Customer customer2 : customers) {
			System.out.println(customer2);
		}
		session.close();
	}

	/**
	 * ���¿ͻ���Ϣ
	 */
	@Test
	public void updateCustomerTest() {
		SqlSession session = MybatisUtils.getSession();
		Customer customer = new Customer();
		customer.setId(3);
		customer.setPhone("45345879658");
		int row = session.update("top.tamlong.mapper" + ".CustomerMapper.updateCustomer", customer);
		if (row > 0) {
			System.out.println("���ɹ��޸���" + row + "�����ݣ�");
		} else {
			System.out.println("ִ���޸Ĳ���ʧ�ܣ�");
		}
		session.commit();
		session.close();
	}

	/**
	 * ���ݿͻ����������ѯ�ͻ���Ϣ
	 */
	@Test
	public void findCustomerByIdsTest() {
		SqlSession session = MybatisUtils.getSession();
		// ����list���ϣ���װ��ѯid
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(3);
		ids.add(4);
		List<Customer> customers = session.selectList("top.tamlong.mapper" + ".CustomerMapper.findCustomerByIds", ids);
		for (Customer customer2 : customers) {
			System.out.println(customer2);
		}
		session.close();
	}

	/**
	 * <bind>Ԫ�ص�ʹ�ã����ݿͻ���ģ����ѯ�ͻ���Ϣ
	 */
	@Test
	public void findCustomerByName() {
		SqlSession session = MybatisUtils.getSession();
		Customer customer = new Customer();
		customer.setUsername("j");
		List<Customer> customers = session.selectList("top.tamlong.mapper" + ".CustomerMapper.findCustomerByName",
				customer);
		for (Customer customer2 : customers) {
			System.out.println(customer2);
		}
		session.close();
	}
}