package cn.nfzy.service;


import java.util.List;

import cn.nfzy.domain.user;

/**
 * UserService�ӿ�
 * �ʣ�java�ӿ����ܲ����з�����ķ�����
 * ���У���jdk1.8�󣬽ӿ�����֧���з�����ķ��������÷�������default����
 * @author Administrator
 *
 */
public interface UserService {
	//ͨ���û���ѯ����
	int findByName(user user);//���󷽷�
	
	int insertUser(user user);
	
	List<user> SelectUser();

}
