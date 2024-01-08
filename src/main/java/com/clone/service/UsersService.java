package com.clone.service;

import com.clone.model.Users;

public interface UsersService {

	void registerUser(Users user);

	boolean verifyOtp(String Email, String otp);
}
