package com.clone.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.clone.exceptionHandler.EmailNotFoundException;
import com.clone.model.Connections;
import com.clone.model.Users;
import com.clone.repository.ConnectionsRepository;
import com.clone.repository.UsersRepository;
import com.clone.service.ConnectionsService;

@Service
public class ConnectionsServiceImpl implements ConnectionsService {

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	public ConnectionsRepository connectionsRepo;

	@Override
	public Connections sendConnectRequest(Users reciever, String email) {
		Users sender = userRepository.findByEmail(email);
		Long recieverId = reciever.getUserId();
		Users receiver = userRepository.findById(recieverId)
				.orElseThrow(() -> new EmailNotFoundException("reciever not found"));
		if (receiver != null) {
			Connections connection = new Connections();
			connection.setSender(sender);
			connection.setReciever(receiver);
			connection.setStatus("Pending");
			return connectionsRepo.save(connection);
		} else {
			throw new UsernameNotFoundException("Sender or receiver not found");
		}
	}

	@Override
	public List<Connections> getConnectRequestsForUser(String email) {
		Users user = userRepository.findByEmail(email);
		if (user != null) {
			String Status = "Pending";
			return connectionsRepo.findByRecieverAndStatus(user, Status);
		} else {
			throw new UsernameNotFoundException("email not found");
		}

	}

	@Override
	public Connections acceptRequest(Long connectionId) {
		Connections request = connectionsRepo.findById(connectionId)
				.orElseThrow(() -> new RuntimeException("Request not found"));
		request.setStatus("Accepted");
		return connectionsRepo.save(request);
	}

	@Override
	public Connections declineRequest(Long connectionId) {
		Connections request = connectionsRepo.findById(connectionId)
				.orElseThrow(() -> new RuntimeException("Request not found"));
		request.setStatus("Declined");
		return connectionsRepo.save(request);

	}

}
