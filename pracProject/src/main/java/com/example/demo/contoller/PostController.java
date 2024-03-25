package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserService.PostService;
import com.example.demo.models.Post;
import com.example.demo.response.ApiResponse;

@RestController
public class PostController {

	@Autowired
	PostService postservice;
	
	
	@PostMapping("/posts/user/{userid}")
	public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable Integer userid) throws Exception
	{
		Post createPost = postservice.createNewPost(post, userid);
		
		return new ResponseEntity<>(createPost,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/posts/{postid}/user/{userid}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postid,@PathVariable Integer userid) throws Exception
	{
		String message = postservice.deletePost(postid, userid);
		
		ApiResponse res = new ApiResponse(message,true);
		return new ResponseEntity<ApiResponse>(res,HttpStatus.OK);
	}
	
	@GetMapping("/post/{postid}")
	public ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postid) throws Exception
	{
		Post post = postservice.findPostById(postid);
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/post/user/{userid}")
	public ResponseEntity<List<Post>> findPostByUserid(@PathVariable Integer userid)
	{
		List<Post> posts = postservice.findPostByUserid(userid);
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<Post>> findAllPost()
	{
		List<Post> posts = postservice.findAllPost();
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	}
	
	@PutMapping("/post/save/{postid}/user/{userid}")
	public ResponseEntity<Post> savedPostHandler(@PathVariable Integer postid,@PathVariable Integer userid) throws Exception
	{
		Post post = postservice.savedPost(postid, userid);
		
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/post/like/{postid}/user/{userid}")
	public ResponseEntity<Post> likePostHandler(@PathVariable Integer postid,@PathVariable Integer userid) throws Exception
	{
		Post post = postservice.postLike(postid, userid);
		
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
	}
}
