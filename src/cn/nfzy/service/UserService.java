package cn.nfzy.service;


import java.util.List;

import cn.nfzy.domain.user;

/**
 * UserService接口
 * 问：java接口中能不能有方法体的方法？
 * 答：有，在jdk1.8后，接口中是支持有方法体的方法，但该方法有用default修饰
 * @author Administrator
 *
 */
public interface UserService {
	//通过用户查询数据
	int findByName(user user);//抽象方法
	
	int insertUser(user user);
	
	List<user> SelectUser();

}
