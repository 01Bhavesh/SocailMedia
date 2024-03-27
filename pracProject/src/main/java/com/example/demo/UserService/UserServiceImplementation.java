package com.example.demo.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.config.jwtProvider;
import com.example.demo.exception.UserException;
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
	public User findUserById(Integer id) throws UserException {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent())
		{
			return user.get();
		}
		
		throw new UserException("User not exit with id "+id ) ;
	}

	@Override
	public User findUserByEmailid(String email) {
		User user = userRepo.findByGmail(email);
		return user;
	}

	@Override
	public User followUser(Integer reqUserId, Integer UserId2) throws UserException {
		
		User reqUser = findUserById(reqUserId);
		User user2 = findUserById(UserId2);
		
		user2.getFollowers().add(reqUser.getId());
		reqUser.getFollowing().add(user2.getId());
		
		userRepo.save(reqUser);
		userRepo.save(user2);
		
		return reqUser;
	}

	@Override
	public User updateUser(User user,Integer id) throws UserException {
		Optional<User> olduser = userRepo.findById(id);
		if(olduser.isEmpty())
		{
			throw new UserException("User not found");
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

	@Override
	public User findUserByJwt(String jwt) {
		String gmail = jwtProvider.getEmailFromJwtToken(jwt);
		User user = userRepo.findByGmail(gmail);
		return user;
	}

}
