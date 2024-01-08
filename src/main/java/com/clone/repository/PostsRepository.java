package com.clone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.model.Posts;
import com.clone.model.Users;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
	//fetch post by user id
	List<Posts> findByUser(Users user);
}
