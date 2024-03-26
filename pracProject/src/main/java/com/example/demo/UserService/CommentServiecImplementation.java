package com.example.demo.UserService;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Comment;
import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;

@Service
public class CommentServiecImplementation implements CommentService{

	@Autowired
	private PostService postServiec;
	
	@Autowired
	private UserInterface userServiec;
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public Comment createComment(Comment comment, Integer postid, Integer userid) throws Exception {
		// TODO Auto-generated method stub
		
		User user = userServiec.findUserById(userid);
		
		Post post = postServiec.findPostById(postid);
		
		comment.setUser(user);
		comment.setContent(comment.getContent());
		comment.setCreateAt(LocalDateTime.now());
		
		Comment savedComment = commentRepo.save(comment);
		
		post.getComments().add(savedComment);
		
		postRepo.save(post);
		return savedComment;
	}

	@Override
	public Comment findCommentById(Integer Commentid) throws Exception {
		
		Optional<Comment> opt = commentRepo.findById(Commentid);
		
		if(opt.isEmpty())
		{
			throw new Exception("Comment not exists");
		}
		
		return opt.get();
	}

	@Override
	public Comment likeComment(Integer commentid, Integer userid) throws Exception {
		Comment comment = findCommentById(commentid);
		User  user = userServiec.findUserById(userid);
		
		if(!comment.getLiked().contains(user))
		{
			comment.getLiked().add(user);
		}
		else
		{
			comment.getLiked().remove(user);
		}
		
		return commentRepo.save(comment);
	}

}
