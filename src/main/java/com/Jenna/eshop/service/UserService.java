package com.Jenna.eshop.service;

import java.util.List;

import com.Jenna.eshop.domain.User;


/**
 * 用户管理模块的service组件接口
 * @author Jenna C He
 * @date 2023/1/6 13:57
 */
public interface UserService {

	/**
	 * 查询所有用户
	 * @return 用户信息
	 */
	List<User> listUsers();
	
	/**
	 * 根据ID查询用户
	 * @param id 用户ID
	 * @return 用户信息
	 */
	User getUserById(Long id);
	
	/**
	 * 新增用户
	 * @param user 用户信息
	 */
	void saveUser(User user);
	
	/**
	 * 更新用户
	 * @param user 用户信息
	 */
	void updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id 用户ID
	 */
	void removeUser(Long id);
	
}
