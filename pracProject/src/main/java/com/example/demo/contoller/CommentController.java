package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserService.CommentService;
import com.example.demo.UserService.UserInterface;
import com.example.demo.models.Comment;
import com.example.demo.models.User;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserInterface userServiec;
	
	@PostMapping("/api/comments/post/{postid}")
	public Comment createComment(@RequestBody Comment comment,@RequestHeader("Authorization") String jwt,@PathVariable("postid") Integer postid) throws Exception
	{
		User user = userServiec.findUserByJwt(jwt);
		
		Comment createComment = commentService.createComment(comment,postid,user.getId());
		
		return createComment;
		
	}
	@PutMapping("/api/comments/like/{commentid}")
	public Comment LikedComment(@RequestHeader("Authorization") String jwt, @PathVariable("commentid") Integer commentid) throws Exception
	{
		User user = userServiec.findUserByJwt(jwt);
		
		Comment likedComment = commentService.likeComment(commentid, user.getId());
		
		return likedComment;
		
	}
}

