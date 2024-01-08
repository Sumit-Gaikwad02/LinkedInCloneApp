package com.clone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.model.Followers;
import com.clone.model.Users;

@Repository
public interface FollowerRepository extends JpaRepository<Followers, Long> {

	List<Followers> findByfollower(Users follower);

	List<Followers> findByfollowingUser(Users user);
	
	
}
