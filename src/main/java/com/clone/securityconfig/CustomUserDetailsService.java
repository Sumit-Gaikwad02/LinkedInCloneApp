package com.clone.securityconfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clone.exceptionHandler.EmailNotFoundException;
import com.clone.exceptionHandler.EmptyInputException;
import com.clone.model.Users;
import com.clone.repository.UsersRepository;

/** Author:Sumit *****/

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    if(email == null) {
	        throw new EmptyInputException("Email cannot be null");
	    }
	    System.out.println("null.............." + email);
	    
	    Users user = userRepository.findByEmail(email);
	    
	    if (user == null) {
	        throw new UsernameNotFoundException("User not found with email: " + email);
	    }

	    return new CustomUserDetails(user);
	}
}
