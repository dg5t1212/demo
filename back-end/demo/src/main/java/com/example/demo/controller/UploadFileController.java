package com.example.demo.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.UploadFile;
import com.example.demo.service.UploadFileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "檔案上傳")
@RestController
public class UploadFileController {

	@Autowired
	private UploadFileService uploadFileService;
	
	
	@ApiOperation(value = "上傳圖片")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功", response = UploadFile.class),
			@ApiResponse(code = 403, message = "權限不足"),
			@ApiResponse(code = 500, message = "系統錯誤")})
	@RequestMapping(path = "/upload/file", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UploadFile> createUploadFile(
			@RequestPart(value="uploadFile") MultipartFile uploadFile) {
		try {
			String fileName = uploadFile.getOriginalFilename();
			String path = "/Users/wangdaniel/Downloads/" + fileName;
			File file = new File(path);
			FileCopyUtils.copy(uploadFile.getBytes(), file);
			UploadFile newUploadFile = this.uploadFileService.createUploadFile(fileName);
			return new ResponseEntity<>(null, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
