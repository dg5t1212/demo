package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UploadFileRepository;
import com.example.demo.entity.UploadFile;

@Service
public class UploadFileService {
	
	@Autowired
	private UploadFileRepository uploadFileRepository;
	
	public UploadFile createUploadFile(String fileName) {
		UploadFile uploadFile = new UploadFile();
		uploadFile.setName(fileName);
		return this.uploadFileRepository.save(uploadFile);
	}
}
