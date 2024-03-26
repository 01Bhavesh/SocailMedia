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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserService.PostService;
import com.example.demo.UserService.UserInterface;
import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.response.ApiResponse;

@RestController
public class PostController {

	@Autowired
	PostService postservice;
	
	@Autowired
	UserInterface userService;
	
	@PostMapping("/api/posts")
	public ResponseEntity<Post> createPost(@RequestHeader("Authorization") String jwt, @RequestBody Post post) throws Exception
	{
		User reqUser = userService.findUserByJwt(jwt);
		Post createPost = postservice.createNewPost(post, reqUser.getId());
		
		return new ResponseEntity<>(createPost,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/api/posts/{postid}")
	public ResponseEntity<ApiResponse> deletePost(@RequestHeader("Authorization") String jwt,@PathVariable Integer postid) throws Exception
	{
		User reqUser = userService.findUserByJwt(jwt);
		String message = postservice.deletePost(postid, reqUser.getId());
		
		ApiResponse res = new ApiResponse(message,true);
		return new ResponseEntity<ApiResponse>(res,HttpStatus.OK);
	}
	
	@GetMapping("/api/post/{postid}")
	public ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postid) throws Exception
	{
		Post post = postservice.findPostById(postid);
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/api/post/user/{userid}")
	public ResponseEntity<List<Post>> findPostByUserid(@PathVariable Integer userid)
	{
		List<Post> posts = postservice.findPostByUserid(userid);
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/api/posts")
	public ResponseEntity<List<Post>> findAllPost()
	{
		List<Post> posts = postservice.findAllPost();
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	}
	
	@PutMapping("/api/post/save/{postid}")
	public ResponseEntity<Post> savedPostHandler(@RequestHeader("Authorization") String jwt,@PathVariable Integer postid) throws Exception
	{
		User reqUser = userService.findUserByJwt(jwt);
		Post post = postservice.savedPost(postid, reqUser.getId());
		
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/api/post/like/{postid}/user/{userid}")
	public ResponseEntity<Post> likePostHandler(@RequestHeader("Authorization") String jwt,@PathVariable Integer postid) throws Exception
	{
		User reqUser = userService.findUserByJwt(jwt);
		Post post = postservice.postLike(postid, reqUser.getId());
		
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
	}
}
