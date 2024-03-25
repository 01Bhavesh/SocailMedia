package com.example.demo.UserService;

import java.util.List;

import com.example.demo.models.Post;

public interface PostService {
	
Post createNewPost(Post post,Integer userid) throws Exception;

String deletePost(Integer postid,Integer userid) throws Exception;

List<Post> findPostByUserid(Integer userid);

Post findPostById(Integer postId) throws Exception;

List<Post> findAllPost();

Post savedPost(Integer postid,Integer userid) throws Exception;

Post postLike(Integer postid,Integer userid) throws Exception;

}
