package com.clone.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clone.model.PostPhoto;
import com.clone.model.Users;
import com.clone.repository.PostPhotoRepository;
import com.clone.repository.UsersRepository;
import com.clone.service.PostPhotoService;

@Service
public class PostPhotoServiceImpl implements PostPhotoService {

	@Autowired
	private UsersRepository userRepo;

	@Autowired
	private PostPhotoRepository postPhotoRepo;

	@Override
	public PostPhoto savePostPhoto(byte[] photo, String email) {
		Users user = userRepo.findByEmail(email);
		if (user != null) {
			PostPhoto postPhoto = new PostPhoto();

			postPhoto.setPhoto(photo);
			postPhoto.setUser(user);
			return postPhotoRepo.save(postPhoto);

		} else {
			throw new UsernameNotFoundException("User id not found");
		}

	}

	@Override
	public List<PostPhoto> getAllPostedPhoto(String email) {
		Users user = userRepo.findByEmail(email);
		if (user != null) {
			List<PostPhoto> photos = postPhotoRepo.findByUser(user);
			return photos;
		} else {
			throw new UsernameNotFoundException("User not found");
		}

	}
}
