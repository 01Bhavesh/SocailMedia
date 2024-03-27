package com.example.demo.UserService;

import java.util.List;

import com.example.demo.models.Message;
import com.example.demo.models.User;

public interface MessageService {

	public Message craeteMessage(User user, Integer chatId, Message req) throws Exception;
	
	public List<Message> findChatsMessages(Integer chatId) throws Exception;
}
