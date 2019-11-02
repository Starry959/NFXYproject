package cn.nfzy.serviceimpl;


import java.util.List;

import cn.nfzy.dao.UserDao;
import cn.nfzy.daoimpl.UserDaoImpl;
import cn.nfzy.domain.user;
import cn.nfzy.service.UserService;
/**
 * Service的实现类-->dao层
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService {
private UserDao userdao=new UserDaoImpl();
	@Override
	public int findByName(user user) {
		user rsuser=userdao.findByName(user);
		
		
		if(rsuser==null) {
			return 0;
		}else {
			if(user.getPassword().equals(rsuser.getPassword())) {
				return 1;
			}else {
				return 2;
			}
		}
	}
	@Override
	public int insertUser(user user) {
		
		return userdao.insertUser(user);
	}
	@Override
	public List<user> SelectUser() {
		
		return userdao.SelectUser();
	}
}
