package com.clone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.model.Connections;
import com.clone.model.Users;

@Repository
public interface ConnectionsRepository extends JpaRepository<Connections, Long> {
	
 List<Connections> findByRecieverAndStatus(Users reciever,String status);
}
