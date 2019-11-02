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
			System.out.println("操作成功，影响了"+in+"条记录");
		}else {
			System.out.println("操作失败");
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
		user.setUsername("小巴");
		user.setPassword("134");
		session.insert("insertUser", user);
		//提交事务，否则数据库添加不成功
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
		List<user> userList = session.selectList("selectUserListByName2", "李");
		for (user user : userList) {
			System.out.println(user);
		}
	}

	private static void test2() throws IOException {
		String config = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(config);
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sf.openSession();
		//查出的数据是一个集合
		List<user> userList = session.selectList("selectUserListByName", "%李%");
		//这是传统的方式遍历集合
		/*for (user user : userList) {
			System.out.println(user);
		}*/
		//用jdk1.8新特性遍历集合：lambda表达式
		userList.forEach(list->System.out.println(list));
	}

	private static void test1() throws IOException {
		//1.	读取核心mybatis配置文件(在内存中只是流的方式)
    	String config ="mybatis-config.xml";
    			InputStream  is = Resources.getResourceAsStream(config);

    	//2.	创建SqlSessionFactory对象，此对象可以完成对配置文件的读取

    	SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);

    	//3.	创建SqlSession对象,该对象的作用是调用mapper文件进行数据操作(一定要先引mapper)

    	SqlSession session = sf.openSession();

    	//4.	使用sql会话对象进行增删改查

    	user user=session.selectOne("test.selecctById", 1);
    	System.out.println("查到的数据："+user);
        
    	//5.	关闭sqlsession对象
    	session.close();
	}
}
