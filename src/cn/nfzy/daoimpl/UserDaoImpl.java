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

	//��mybatis�������ݿ�
	@Override
	public user findByName(user user) {
		SqlSession session =null;
		try {
			
		//1.	��ȡ����mybatis�����ļ�(���ڴ���ֻ�����ķ�ʽ)
    	String config ="mybatis-config.xml";
    			InputStream  is = Resources.getResourceAsStream(config);

    	//2.	����SqlSessionFactory���󣬴˶��������ɶ������ļ��Ķ�ȡ

    	SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);

    	//3.	����SqlSession����,�ö���������ǵ���mapper�ļ��������ݲ���(һ��Ҫ����mapper)

    	 session = sf.openSession();

    	//4.	ʹ��sql�Ự���������ɾ�Ĳ�

    	user rsuser=session.selectOne("test.selecctByName", user.getUsername());
    	System.out.println("user�����ݣ�"+rsuser);
        
    	
    	return rsuser;
        }catch(Exception e) {
        	return null;
		}finally {
			//5.	�ر�sqlsession����
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
