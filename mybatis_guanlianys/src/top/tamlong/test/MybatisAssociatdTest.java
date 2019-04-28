package top.tamlong.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import top.tamlong.po.Orders;
import top.tamlong.po.Person;
import top.tamlong.po.User;
import top.tamlong.utils.MybatisUtils;

// ������
public class MybatisAssociatdTest {

	/**
	 * Ƕ�ײ�ѯ
	 */
	@Test
	public void findPersonByIdTest() {
		// 1.ͨ������������Sqlsess����
		SqlSession session = MybatisUtils.getSession();
		// 2.ʹ��mybatisǶ�ײ�ѯ�ķ�ʽ��ѯidΪ1���˵���Ϣ
		Person person = session.selectOne("top.tamlong.mapper." + "PersonMapper.findPersonById", 1);
		// 3.�����ѯ��Ϣ
		System.out.println(person);
		// 4.�ر�Sqlsession
		session.close();
	}

	/**
	 * һ�Զ�
	 */
	@Test
	public void findUserTest() {
		// 1.ͨ������������Sqlsession����
		SqlSession session = MybatisUtils.getSession();
		// 2.��ѯidΪ1���û���Ϣ
		User user = session.selectOne("top.tamlong.mapper." + "UserMapper.findUserWithOrders", 1);
		// 3.�����ѯ��Ϣ
		System.out.println(user);
		// 4.�ر�sqlsession
		session.close();
	}

	/**
	 * ��Զ�
	 */
	@Test
	public void findOrdersTest() {
		// 1.ͨ������������Sqlsession����
		SqlSession session = MybatisUtils.getSession();
		// 2.��ѯidΪ1�Ķ����е���Ϣ
		Orders orders = session.selectOne("top.tamlong.mapper." + "OrdersMapper.findOrdersWithProduce", 1);
		// 3.�����ѯ��Ϣ
		System.out.println(orders);
		// 4.�ر�sessin
		session.close();
	}

}
