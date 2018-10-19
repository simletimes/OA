package com.bwf.service;

import java.util.List;

import javax.validation.Valid;

import com.bwf.entity.User;

public interface IUserService {

	
	User login( User user );

	List<User> getAllUsers();

	Integer getAllUserCount();

	List<User> getAllUsersByPage(Integer page, Integer pageSize);

	void delete(Integer id);

	void deleteMulti(Integer[] idArr);

	void add(User user);

	User getUserById(Integer id);

	void update(User user, boolean resetPassword );

//	User getMenusByUserId(int userId);
}
