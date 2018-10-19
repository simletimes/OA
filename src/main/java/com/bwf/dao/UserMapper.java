package com.bwf.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.User;


public interface UserMapper {
	
	User getUserById(int id);	
	
	void add ( User user );
	
	void delete ( int id );
	
	void update ( User user );

	User getUserByUsernameAndPassword(User user);

	User getMenusAndOperatesByUserId(int userId);

	List<User> getAllUser();

	Integer getAllUserCount();

	List<User> getAllUsersByPage(@Param("p") Integer p,@Param("pageSize") Integer pageSize);

	void deleteMulti(@Param("idArr") Integer[] idArr);

	void updateWithPassword(User user);

	void updateWithoutPassword(User user);

	User getUserWithLeader(User currentUser);
	
	
}
