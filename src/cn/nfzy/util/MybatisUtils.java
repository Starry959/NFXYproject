package cn.nfzy.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * MybatisUtils工具类
 * 工具类一般属性和方法都是静态的（static）
 * 静态的方法可以直接在使用时用类名.方法名的方法访问
 * @author Administrator
 *
 */
public class MybatisUtils {
	private static SqlSessionFactory sf;
	//以下是静态代码块，其特点是在类加载时候执行且只执行一次
	static {
		String config = "mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(config);
			sf = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//编写一个获取SqlSession的方法
	public static SqlSession getSession() {
		return sf.openSession();
	}

}
