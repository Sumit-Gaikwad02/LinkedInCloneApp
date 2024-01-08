package com.clone.service;

import java.util.List;
import com.clone.model.PostPhoto;

public interface PostPhotoService {

	public PostPhoto savePostPhoto(byte[] photo, String email);

	List<PostPhoto> getAllPostedPhoto(String email);

}
