package cn.nfzy.daoimpl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.nfzy.dao.UserDao;
import cn.nfzy.domain.user;
import cn.nfzy.util.MybatisUtils;

public class UserDaoImpl implements UserDao {

	//用mybatis操作数据库
	@Override
	public user findByName(user user) {
		SqlSession session =null;
		try {
			
		//1.	读取核心mybatis配置文件(在内存中只是流的方式)
    	String config ="mybatis-config.xml";
    			InputStream  is = Resources.getResourceAsStream(config);

    	//2.	创建SqlSessionFactory对象，此对象可以完成对配置文件的读取

    	SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);

    	//3.	创建SqlSession对象,该对象的作用是调用mapper文件进行数据操作(一定要先引mapper)

    	 session = sf.openSession();

    	//4.	使用sql会话对象进行增删改查

    	user rsuser=session.selectOne("test.selecctByName", user.getUsername());
    	System.out.println("user的数据："+rsuser);
        
    	
    	return rsuser;
        }catch(Exception e) {
        	return null;
		}finally {
			//5.	关闭sqlsession对象
			if(session!=null) {
				session.close();
			}
	    	
		}
	}

	@Override
	public int insertUser(user user) {
		SqlSession session=MybatisUtils.getSession();
		int in=session.insert("test.insertUser",user);
		session.commit();
		
		return in;
	}

	@Override
	public List<user> SelectUser() {
		SqlSession session=MybatisUtils.getSession();
		List<user> list = session.selectList("test.selectUser");

		return list;
	}
		

}
