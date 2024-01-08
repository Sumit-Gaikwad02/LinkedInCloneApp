package com.clone.service;

import java.util.List;

import com.clone.model.Connections;
import com.clone.model.Users;

public interface ConnectionsService {

	public Connections sendConnectRequest(Users reciever, String email);

	public List<Connections> getConnectRequestsForUser(String email);

	public Connections acceptRequest(Long connectionId);

	public Connections declineRequest(Long ConnectionId);
}
