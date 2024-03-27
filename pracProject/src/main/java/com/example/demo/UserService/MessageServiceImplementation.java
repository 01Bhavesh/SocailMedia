package com.example.demo.UserService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Chat;
import com.example.demo.models.Message;
import com.example.demo.models.User;
import com.example.demo.repository.ChatRepository;
import com.example.demo.repository.MessagesRepository;

@Service
public class MessageServiceImplementation implements MessageService{

	@Autowired
	private MessagesRepository messageRepo;
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private ChatRepository chatRepo;
	
	@Override
	public Message craeteMessage(User user, Integer chatId, Message req) throws Exception {
		
		Chat chat = chatService.findChatById(chatId);
		Message message = new Message();
		
		message.setChat(chat);
		message.setContent(req.getContent());
		message.setImage(req.getImage());
		message.setTimeStamp(LocalDateTime.now());
		message.setUser(user);
		Message savedMessage = messageRepo.save(message);
		
		chat.getMessages().add(savedMessage);
		chatRepo.save(chat);
		
		return savedMessage;
	}

	@Override
	public List<Message> findChatsMessages(Integer chatId) throws Exception  {
		Chat chat = chatService.findChatById(chatId);
		return messageRepo.findByChatId(chatId);
	}

}
