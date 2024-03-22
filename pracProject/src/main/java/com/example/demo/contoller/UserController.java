package com.example.demo.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;


@RestController
public class UserController{

	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/user/data")
	private User postUser(@RequestBody User user)
	{
		User newU = new User();
		newU.setId(user.getId());
		newU.setFirstName(user.getFirstName());
		newU.setLastName(user.getLastName());
		newU.setGmail(user.getGmail());
		newU.setPassword(user.getPassword());
		
		User saved = userRepo.save(newU);
		
		return saved;
	}
	
	
	@GetMapping("/users")
	private List<User> getUsers()
	{
//		List<User> lst = new ArrayList<>();
//		User u1 = new User(1,"Bhavesh","Gharat","gharatbhavesh@gmail.com","Bhavesh@20");
//		User u2 = new User(2,"Deepak","Vaydande","deepakVaydande@gmail.com","deepak@28");
//		User u3 = new User(3,"Mayur","Patil","mayurpatil@gmail.com","mayur@05");
//		lst.add(u1);
//		lst.add(u2);
//		lst.add(u3);
		
		List<User> lst = userRepo.findAll();
		
		return lst;
	}
	
	@GetMapping("/user/{userId}")
	private User getUserById(@PathVariable("userId") Integer id) throws Exception
	{
//		List<User> lst = new ArrayList<>();
//		User u1 = new User(1,"Bhavesh","Gharat","gharatbhavesh@gmail.com","Bhavesh@20");
//		u1.setId(id);
		
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent())
		{
			return user.get();
		}
		
		throw new Exception("User not exit with id "+id ) ;
	}
	
	
	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User user,@PathVariable Integer id) throws Exception {
		
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
		
		User updatedUser = userRepo.save(updateU);
		
		return updatedUser;
	}
	@DeleteMapping("/user/{UserId}")
	private String deleteUserById(@PathVariable Integer UserId) throws Exception
	{
		Optional<User> user = userRepo.findById(UserId);
		if(user.isEmpty())
		{
			throw new Exception ("User dose not exit with id "+UserId);
		}
		User delUser = user.get();
		userRepo.delete(delUser);
		
		return "deteted successfully user "+UserId;
	}
	
}
