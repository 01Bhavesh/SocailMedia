package com.example.demo.UserService;

import java.util.List;

import com.example.demo.models.Reels;
import com.example.demo.models.User;

public interface ReelsService {

	public Reels createReel(Reels reel, User user);
	
	public List<Reels> findAllReels();
	
	public List<Reels> findUsersReel(Integer userid) throws Exception;
}
