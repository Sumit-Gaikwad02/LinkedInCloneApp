package com.clone.service;

import java.util.List;

import com.clone.model.Followers;
import com.clone.model.Users;

public interface FollowersService {
	
	public Followers followUser(Users user, String email);
	
	public List<Followers> getFollowers(String email);
	
	public List<Followers> getFollowing(String email);
	
	public String unfollow(long followId);

}
