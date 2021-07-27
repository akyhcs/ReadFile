package com.mindtree.org.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import util.ReadUtil;

@RestController
public class ReadController {
	@PostMapping("/sheet-excel")
	public ResponseEntity<?> read(@RequestParam("file") MultipartFile multipartFile)
	{
		return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.CREATED))
		.body(ReadUtil.getListofUserName(multipartFile));	
	}
}
