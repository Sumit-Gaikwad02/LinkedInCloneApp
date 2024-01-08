package com.clone.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.clone.model.Posts;
import com.clone.serviceImpl.PostsServiceImpl;

/** Author:Sumit *****/

@RestController
@RequestMapping("/posts")

public class PostsController {

	@Autowired
	private PostsServiceImpl postsService;

	@PostMapping("/create")
	public ResponseEntity<Posts> createPost(@RequestParam("title") String title,
			@RequestParam("content") String content, @RequestParam("media") MultipartFile media,
			Authentication authentication) throws IOException {
		byte[] Media = media.getBytes();
		String Email = authentication.getName();
		Posts post = new Posts();
		post.setTitle(title);
		post.setContent(content);
		Posts createdPost = postsService.createPost(post, Email, Media);
		return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
	}

	@GetMapping("/getPosts")
	public ResponseEntity<List<Posts>> getAllPosts(Authentication authentication) {

		System.out.println("get post************");
		String email = authentication.getName();
		List<Posts> posts = postsService.getAllPosts(email);
		System.out.println(posts);
		return ResponseEntity.ok().body(posts);
	}

}
