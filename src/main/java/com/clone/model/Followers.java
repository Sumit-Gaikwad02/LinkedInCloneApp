package com.clone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Followers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long followId;

	@ManyToOne
	@JoinColumn(name = "follower_id")
	private Users follower;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users followingUser;

	public long getFollowId() {
		return followId;
	}

	public void setFollowId(long followId) {
		this.followId = followId;
	}

	public Users getFollower() {
		return follower;
	}

	public void setFollower(Users follower) {
		this.follower = follower;
	}

	public Users getFollowingUser() {
		return followingUser;
	}

	public void setFollowingUser(Users followingUser) {
		this.followingUser = followingUser;
	}

	

}
