package com.clone.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	//find user by Email*****
	Users findByEmail(String email);
	
	//find user by OTP*****
	Users findByOtp(String otp);
	
	//List of Users by FirstName or LastName*****
	List<Users> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName,String lastName);
	
	List<Users> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(String firstName, String lastName);
}
