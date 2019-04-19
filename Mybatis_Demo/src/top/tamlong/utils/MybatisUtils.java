package top.tamlong.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * 工具类
 * 
 * @author Administrator
 *
 */
public class MybatisUtils {
	private static SqlSessionFactory sqlSessionFactory = null;
	// 初始化SqlSessionFactory对象
	static {
		try {
			// 使用Mybatis提供的Resource类加载Mybatis配置文件
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			// 构建SqlSessionFactory工厂
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//获取SqlSession对象
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}
