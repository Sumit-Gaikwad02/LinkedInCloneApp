package com.clone.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.clone.model.PostPhoto;
import com.clone.serviceImpl.PostPhotoServiceImpl;

/**** Author:Sumit *****/
/***** This controller used for sharePost and photo ****/
@RestController
@RequestMapping("/postPhoto")
public class PostPhotoController {

	@Autowired
	private PostPhotoServiceImpl postPhotoService;

	@PostMapping("/upload")
	public ResponseEntity<PostPhoto> savePhoto(@RequestParam("photo") MultipartFile photo,
			Authentication authentication) throws IOException {
		String email = authentication.getName();
		byte[] Photo = photo.getBytes();

		PostPhoto response = postPhotoService.savePostPhoto(Photo, email);
		return ResponseEntity.ok().body(response);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PostPhoto>> getList(Authentication authentication) {
		String email = authentication.getName();
		List<PostPhoto> list = postPhotoService.getAllPostedPhoto(email);
		return ResponseEntity.ok().body(list);

	}

}
