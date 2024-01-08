package com.clone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.model.PostPhoto;
import com.clone.model.Posts;
import com.clone.model.Users;

@Repository
public interface PostPhotoRepository extends JpaRepository<PostPhoto, Long> {
	
	List<PostPhoto> findByUser(Users user);

}
