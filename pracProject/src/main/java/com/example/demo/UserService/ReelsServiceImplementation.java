package com.example.demo.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Reels;
import com.example.demo.models.User;
import com.example.demo.repository.ReelsRepository;

@Service
public class ReelsServiceImplementation implements ReelsService{

	@Autowired
	private ReelsRepository reelsRepo;
	
	@Autowired
	private UserInterface userServiec;
	
	@Override
	public Reels createReel(Reels reel, User user) {
		Reels createReel = new Reels();
		
		createReel.setTitle(reel.getTitle());
		createReel.setUser(user);
		createReel.setVideo(reel.getVideo());
		return reelsRepo.save(createReel);
	}

	@Override
	public List<Reels> findAllReels() {
		// TODO Auto-generated method stub
		return reelsRepo.findAll();
	}

	@Override
	public List<Reels> findUsersReel(Integer userid) throws Exception {
		userServiec.findUserById(userid);
		return reelsRepo.findByUserId(userid);
	}

}
