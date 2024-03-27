package com.example.demo.UserService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Story;
import com.example.demo.models.User;
import com.example.demo.repository.StoryRepository;

@Service
public class StroryServiceImplementation implements StoryService{

	@Autowired
	private StoryRepository storyRepo;
	
	@Autowired
	private UserInterface userService;
	
	@Override
	public Story createStory(Story story, User user) {
		Story createStory = new Story();
		
		createStory.setCaption(story.getCaption());
		createStory.setImage(story.getImage());
		createStory.setUser(user);
		createStory.setTimeStamp(LocalDateTime.now()); 
		
		return storyRepo.save(createStory);
	}

	@Override
	public List<Story> findStoryByUserId(Integer userid) throws Exception {
		
		User user = userService.findUserById(userid);
		
		return storyRepo.findByUserId(userid);
	}

}
