package top.tamlong.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import top.tamlong.po.Person;
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
}
