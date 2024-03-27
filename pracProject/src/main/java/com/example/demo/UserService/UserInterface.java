package com.example.demo.UserService;

import java.util.List;

import com.example.demo.exception.UserException;
import com.example.demo.models.User;

public interface UserInterface {

	public User resisterUser(User user);
	
	public User findUserById(Integer id) throws UserException;
	
	public User findUserByEmailid(String email);
	
	public User followUser(Integer UserId1,Integer UserId2) throws UserException;
	
	public User updateUser(User user,Integer id) throws UserException;
	
	public List<User> searchUser(String query);
	
	public User findUserByJwt(String jwt);
}
