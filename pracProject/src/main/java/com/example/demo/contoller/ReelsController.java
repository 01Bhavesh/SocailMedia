package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserService.ReelsService;
import com.example.demo.UserService.UserInterface;
import com.example.demo.models.Reels;
import com.example.demo.models.User;

@RestController
public class ReelsController {
	@Autowired
	private ReelsService reelsService;
	
	private UserInterface userServiec;
	
	@PostMapping("/api/Reels")
	public Reels createReels(@RequestBody Reels reel,@RequestHeader("Authorization") String jwt)
	{
		User reqUser = userServiec.findUserByJwt(jwt);
		Reels createdReel = reelsService.createReel(reel, reqUser);
		
		return createdReel;
	}
	
	@GetMapping("/api/Reels")
	public List<Reels> FindAllReels()
	{
		List<Reels> Reel = reelsService.findAllReels();
		
		return Reel;
	}
	

	@GetMapping("/api/Reels/user/{userid}")
	public List<Reels> FindUserReels(@PathVariable Integer userid) throws Exception
	{
		List<Reels> Reel = reelsService.findUsersReel(userid);
		
		return Reel;
	}
}
