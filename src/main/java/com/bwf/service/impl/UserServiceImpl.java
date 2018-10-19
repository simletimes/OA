package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwf.dao.UserMapper;
import com.bwf.entity.User;
import com.bwf.service.IUserService;
import com.bwf.utils.StringUtils;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserMapper userMapper;

	// 在 service 中 ，单个方法中 执行多条 sql 语句， 我们通过作为一个 事务 来进行处理
	// 在 方法上 添加注解 @Transactional 
	@Transactional
	@Override
	public User login(User user) {		
		// 获取 user 的基本信息
		User u = userMapper.getUserByUsernameAndPassword( user );
		if( u != null ) {
			u = userMapper.getMenusAndOperatesByUserId(u.getUserId());
		}
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userMapper.getAllUser();
	}

	@Override
	public Integer getAllUserCount() {
		// TODO Auto-generated method stub
		return userMapper.getAllUserCount();
	}

	@Override
	public List<User> getAllUsersByPage(Integer page , Integer pageSize) {
		// TODO Auto-generated method stub
		return userMapper.getAllUsersByPage( (page-1)*pageSize  ,pageSize);
	}

	@Override
	public void delete(Integer id) {
		userMapper.delete(id);
	}

	@Override
	public void deleteMulti(Integer[] idArr) {
		userMapper.deleteMulti(idArr);
	}

	@Override
	public void add(User user) {
		// 进行密码 md5 加密
		user.setPassword(  StringUtils.md5( user.getPassword() ) );
		
		userMapper.add(user);
	}

	@Override
	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	@Override
	public void update(User user, boolean resetPassword) {
		if ( resetPassword ) {
			// 重置密码的修改
			userMapper.updateWithPassword(user);
		} else {
			// 不重置密码的修改
			userMapper.updateWithoutPassword(user);
		}
	}

//	@Override
//	public User getMenusByUserId(int userId) {
//		// TODO Auto-generated method stub
//		return userMapper.getMenusByUserId(userId);
//	}

}
