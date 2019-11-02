package cn.nfzy.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * MybatisUtils������
 * ������һ�����Ժͷ������Ǿ�̬�ģ�static��
 * ��̬�ķ�������ֱ����ʹ��ʱ������.�������ķ�������
 * @author Administrator
 *
 */
public class MybatisUtils {
	private static SqlSessionFactory sf;
	//�����Ǿ�̬����飬���ص����������ʱ��ִ����ִֻ��һ��
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
	//��дһ����ȡSqlSession�ķ���
	public static SqlSession getSession() {
		return sf.openSession();
	}

}
