package cn.nfzy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.nfzy.domain.user;
import cn.nfzy.util.MybatisUtils;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
    	


    }

	private static void test7() {
		SqlSession session=MybatisUtils.getSession();
		int in=session.delete("test.deleteUser", 11);
		if(in!=0) {
			System.out.println("�����ɹ���Ӱ����"+in+"����¼");
		}else {
			System.out.println("����ʧ��");
		}
		session.commit();
		session.close();
	}

	private static void test6() throws IOException {
		String config = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(config);
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sf.openSession(true);
		
	    user  user = new user();	
	    user.setPassword("888888");
	    user.setId(4);
		session.update("updateUser",user);
		
		session.close();
	}

	private static void test5() throws IOException {
		
		SqlSession session = MybatisUtils.getSession();
		user user = new user();
		user.setUsername("С��");
		user.setPassword("134");
		session.insert("insertUser", user);
		//�ύ���񣬷������ݿ���Ӳ��ɹ�
		session.commit();
		session.close();
	}

	private static void test4() throws IOException {
		String config = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(config);
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sf.openSession();
		List<user> userList = session.selectList("selectUser");
		for (user user : userList) {
			System.out.println(user);
		}
	}

	private static void test3() throws IOException {
		String config = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(config);
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sf.openSession();
		List<user> userList = session.selectList("selectUserListByName2", "��");
		for (user user : userList) {
			System.out.println(user);
		}
	}

	private static void test2() throws IOException {
		String config = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(config);
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sf.openSession();
		//�����������һ������
		List<user> userList = session.selectList("selectUserListByName", "%��%");
		//���Ǵ�ͳ�ķ�ʽ��������
		/*for (user user : userList) {
			System.out.println(user);
		}*/
		//��jdk1.8�����Ա������ϣ�lambda���ʽ
		userList.forEach(list->System.out.println(list));
	}

	private static void test1() throws IOException {
		//1.	��ȡ����mybatis�����ļ�(���ڴ���ֻ�����ķ�ʽ)
    	String config ="mybatis-config.xml";
    			InputStream  is = Resources.getResourceAsStream(config);

    	//2.	����SqlSessionFactory���󣬴˶��������ɶ������ļ��Ķ�ȡ

    	SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);

    	//3.	����SqlSession����,�ö���������ǵ���mapper�ļ��������ݲ���(һ��Ҫ����mapper)

    	SqlSession session = sf.openSession();

    	//4.	ʹ��sql�Ự���������ɾ�Ĳ�

    	user user=session.selectOne("test.selecctById", 1);
    	System.out.println("�鵽�����ݣ�"+user);
        
    	//5.	�ر�sqlsession����
    	session.close();
	}
}
