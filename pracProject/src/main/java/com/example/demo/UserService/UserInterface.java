package com.example.demo.UserService;

import java.util.List;

import com.example.demo.models.User;

public interface UserInterface {

	public User resisterUser(User user);
	
	public User findUserById(Integer id) throws Exception;
	
	public User findUserByEmailid(String email);
	
	public User followUser(Integer UserId1,Integer UserId2) throws Exception;
	
	public User updateUser(User user,Integer id) throws Exception;
	
	public List<User> searchUser(String query);
	
	public User findUserByJwt(String jwt);
}
