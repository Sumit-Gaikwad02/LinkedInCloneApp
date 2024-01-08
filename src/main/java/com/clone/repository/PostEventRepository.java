package com.clone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.model.PostEvent;
import com.clone.model.Users;

@Repository
public interface PostEventRepository extends JpaRepository<PostEvent, Long> {
	//fetch event by user id
	List<PostEvent> findByUser(Users user);
}
