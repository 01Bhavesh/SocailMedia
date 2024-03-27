package com.example.demo.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Chat;
import com.example.demo.models.User;
import com.example.demo.repository.ChatRepository;

@Service
public class ChatServiceImplementation implements ChatService{

	@Autowired
	private ChatRepository chatRepo;
	
	
	@Override
	public Chat createChat(User user2,User reqUser) {
		Chat isExist = chatRepo.findChatByUserId(user2, reqUser);
		if(isExist!=null)
		{
			return isExist;
		}
		
		Chat newChat = new Chat();
		newChat.getUsers().add(user2);
		newChat.getUsers().add(reqUser);
		newChat.setTimeStamp(LocalDateTime.now());
		
		return chatRepo.save(newChat);
	}

	@Override
	public Chat findChatById(Integer chatid) throws Exception {
		Optional<Chat> opt = chatRepo.findById(chatid);
		
		if(opt.isEmpty())
		{
			throw new Exception("Chat not found with Id "+chatid);
		}
		
		return opt.get();
	}

	@Override
	public List<Chat> findUsersChar(Integer userid) {
		// TODO Auto-generated method stub
		return chatRepo.findByUsersId(userid);
	}

}
