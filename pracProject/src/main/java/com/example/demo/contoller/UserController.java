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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserService.UserInterface;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;


@RestController
public class UserController{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserInterface userService;
	
	
	
	
	@GetMapping("/api/users")
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
	
	@GetMapping("/api/user/{id}")
	private User getUserById(@PathVariable Integer id) throws Exception
	{		
		User user = userService.findUserById(id);
		return user;
	}
	
	@GetMapping("/api/user/gmail/{userEmail}")
	private User getUserByGmail(@PathVariable("userEmail") String email) throws Exception
	{		
		User user = userService.findUserByEmailid(email);
		return user;
	}
	
	@PutMapping("/api/user")
	public User updateUser(@RequestHeader("Authorization") String jwt,@RequestBody User user) throws Exception {
		
		User reqUser = userService.findUserByJwt(jwt);
		User updatedUser = userService.updateUser(user, reqUser.getId());
		return updatedUser;
	}
	
	@PutMapping("/api/user/follow/{userid2}")
	public User followUserHandler(@RequestHeader("Authorization") String jwt,@PathVariable Integer userid2) throws Exception
	{
		User reqUser = userService.findUserByJwt(jwt);
		User user = userService.followUser(reqUser.getId(), userid2);
		return user;
	}
	
	@GetMapping("/api/users/search")
	public List<User> searchUser(@RequestParam("query") String query)
	{
		List<User> lst = userService.searchUser(query);
		return lst;
	}
	
//	@DeleteMapping("/user/{UserId}")
//	private String deleteUserById(@PathVariable Integer UserId) throws Exception
//	{
//		Optional<User> user = userRepo.findById(UserId);
//		if(user.isEmpty())
//		{
//			throw new Exception ("User dose not exit with id "+UserId);
//		}
//		User delUser = user.get();
//		userRepo.delete(delUser);
//		
//		return "deteted successfully user "+UserId;
//	}
	@GetMapping("/api/users/profile")
	public User getUserFromToken(@RequestHeader("Authorization") String jwt)
	{
		User user = userService.findUserByJwt(jwt);
		user.setPassword(null);
		return user;
	}
}
