package com.example.demo.UserService;

import com.example.demo.models.Comment;

public interface CommentService {
	
	public Comment createComment(Comment comment,Integer postid,Integer userid) throws Exception;
	
	public Comment findCommentById(Integer Commentid) throws Exception;
	
	public Comment likeComment(Integer commentid,Integer userid) throws Exception;
}
