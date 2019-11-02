package cn.nfzy.dao;

import java.util.List;

import cn.nfzy.domain.user;

/**
 * userdao½Ó¿Ú
 * @author Administrator
 *
 */
public interface UserDao {
	user findByName(user user);
	
	int insertUser(user user);
	
	List<user> SelectUser();

}
