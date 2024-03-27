package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserService.StoryService;
import com.example.demo.UserService.UserInterface;
import com.example.demo.models.Story;
import com.example.demo.models.User;

@RestController
public class StoryController {

	@Autowired
	private StoryService storyService;
	
	@Autowired
	private UserInterface userService;
	
	@PostMapping("/api/story")
	public Story createStory(@RequestBody Story story,@RequestHeader("Authorization") String jwt)
	{
		
		User reqUser =  userService.findUserByJwt(jwt);

		Story createStory = storyService.createStory(story, reqUser);
		
		return createStory;
	}
	
	@GetMapping("/api/story/user/{userId}")
	public List<Story> findUserStory(@PathVariable("userId") Integer userId,@RequestHeader("Authorization") String jwt) throws Exception
	{
		
		User reqUser =  userService.findUserByJwt(jwt);

		List<Story> userStory = storyService.findStoryByUserId(userId);
		
		return userStory;
	}
}
