package com.example.demo.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserInterface{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public User resisterUser(User user) {
		User newU = new User();
		newU.setId(user.getId());
		newU.setFirstName(user.getFirstName());
		newU.setLastName(user.getLastName());
		newU.setGmail(user.getGmail());
		newU.setPassword(user.getPassword());
		newU.setGender(user.getGender());
		
		User saved = userRepo.save(newU);
		
		return saved;
	}

	@Override
	public User findUserById(Integer id) throws Exception {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent())
		{
			return user.get();
		}
		
		throw new Exception("User not exit with id "+id ) ;
	}

	@Override
	public User findUserByEmailid(String email) {
		User user = userRepo.findByGmail(email);
		return user;
	}

	@Override
	public User followUser(Integer UserId1, Integer UserId2) throws Exception {
		
		User user1 = findUserById(UserId1);
		User user2 = findUserById(UserId2);
		
		user2.getFollowers().add(user1.getId());
		user1.getFollowing().add(user2.getId());
		
		userRepo.save(user1);
		userRepo.save(user2);
		
		return user1;
	}

	@Override
	public User updateUser(User user,Integer id) throws Exception {
		Optional<User> olduser = userRepo.findById(id);
		if(olduser.isEmpty())
		{
			throw new Exception("User not found");
		}
		
		User updateU = olduser.get();
		if(user.getFirstName() != null)
		{
			updateU.setFirstName(user.getFirstName());
		}
		if(user.getLastName() != null)
		{
			updateU.setLastName(user.getLastName());
		}
		if(user.getGmail() != null)
		{
			updateU.setGmail(user.getGmail());
		}
		if(user.getPassword() != null)
		{
			updateU.setPassword(user.getPassword());
		}
		if(user.getGender() != null)
		{
			updateU.setGender(user.getGender());
		}
		
		User updatedUser = userRepo.save(updateU);
		
		return updatedUser;
	}

	@Override
	public List<User> searchUser(String query) {
		
		return userRepo.searchUser(query);
	}

}
