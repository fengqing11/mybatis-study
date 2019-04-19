package top.tamlong.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * ������
 * 
 * @author Administrator
 *
 */
public class MybatisUtils {
	private static SqlSessionFactory sqlSessionFactory = null;
	// ��ʼ��SqlSessionFactory����
	static {
		try {
			// ʹ��Mybatis�ṩ��Resource�����Mybatis�����ļ�
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			// ����SqlSessionFactory����
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//��ȡSqlSession����
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}