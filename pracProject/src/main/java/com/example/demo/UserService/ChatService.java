package com.example.demo.UserService;

import java.util.List;

import com.example.demo.models.Chat;
import com.example.demo.models.User;

public interface ChatService {

	public Chat createChat(User reqUser, User user2);
	
	public Chat findChatById(Integer chatid) throws Exception;
	
	public List<Chat> findUsersChar(Integer userid);
}
