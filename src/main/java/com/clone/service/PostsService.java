package com.clone.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.clone.model.Posts;

public interface PostsService {

	Posts createPost(Posts post,String email,byte[] media);

	List<Posts> getAllPosts(String email);
}
