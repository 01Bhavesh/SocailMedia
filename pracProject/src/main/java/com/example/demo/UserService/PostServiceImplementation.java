package com.example.demo.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

@Service
public class PostServiceImplementation implements PostService{
	
	@Autowired
	PostRepository postrepo;
	
	@Autowired
	UserInterface userrepo;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Post createNewPost(Post post, Integer userid) throws Exception {
		
		User user = userrepo.findUserById(userid);
		
		Post newPost = new Post();
		
		newPost.setCaption(post.getCaption());
		newPost.setImage(post.getImage());
		newPost.setCreatedAt(LocalDateTime.now());
		newPost.setVideo(post.getVideo());
		newPost.setUser(user);
		
		return postrepo.save(newPost);
	}

	@Override
	public String deletePost(Integer postid, Integer userid) throws Exception {
		Post post = findPostById(postid);
		User user = userrepo.findUserById(userid);
		
		if(post.getUser().getId() != user.getId())
		{
			throw new Exception("Your are trying to delete others post");
		}
		postrepo.delete(post);
		return "Post deleted successfully";
	}

	@Override
	public List<Post> findPostByUserid(Integer userid) {
		// TODO Auto-generated method stub
		return postrepo.findPostByUserid(userid);
	}

	@Override
	public Post findPostById(Integer postid) throws Exception {
		Optional<Post> opt = postrepo.findById(postid);
		if(opt.isEmpty())
		{
			throw new Exception("Post not found with id"+postid);
		}
		return opt.get();
	}

	@Override
	public List<Post> findAllPost() {
		// TODO Auto-generated method stub
		return postrepo.findAll();
	}

	@Override
	public Post savedPost(Integer postid, Integer userid) throws Exception {
		// TODO Auto-generated method stub
		Post post = findPostById(postid);
		User user = userrepo.findUserById(userid);
		
		if(user.getSavedPost().contains(post)) {
			user.getSavedPost().remove(post);
		}
		else
		{
			user.getSavedPost().add(post);
		}
		userRepository.save(user);
		return post;
	}

	@Override
	public Post postLike(Integer postid, Integer userid) throws Exception {
		Post post = findPostById(postid);
		User user = userrepo.findUserById(userid);
		
		if(post.getLiked().contains(user))
		{
			post.getLiked().remove(user);
		}
		else
		{
		post.getLiked().add(user);
		}
		return postrepo.save(post);
	}

}
