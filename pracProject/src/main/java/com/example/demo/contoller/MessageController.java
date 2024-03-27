package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserService.MessageService;
import com.example.demo.UserService.UserInterface;
import com.example.demo.models.Message;
import com.example.demo.models.User;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	@Autowired
	private UserInterface userService;
	
	@PostMapping("/api/message/chat/{chatid}")
	public Message createMessage(@RequestHeader("Authorization") String jwt,@PathVariable("chatid") Integer chatid,@RequestBody Message req) throws Exception
	{
		User reqUser = userService.findUserByJwt(jwt);
		
		Message message = messageService.craeteMessage(reqUser, chatid, req);
		
		return message;
	}
	
	@GetMapping("/api/message/chat/{chatid}")
	public List<Message> findChatMessage(@RequestHeader("Authorization") String jwt,@PathVariable("chatid") Integer chatid) throws Exception
	{
		User reqUser = userService.findUserByJwt(jwt);
		
		List<Message> messages = messageService.findChatsMessages(chatid);
		
		return messages;
	}
}
