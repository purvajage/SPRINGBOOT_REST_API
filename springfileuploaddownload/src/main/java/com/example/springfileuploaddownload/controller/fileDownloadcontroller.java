package com.example.springfileuploaddownload.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springfileuploaddownload.exception.FileNotFoundException;


import org.springframework.core.io.Resource;  // Correct import for Resource
import org.springframework.core.io.UrlResource;




import org.springframework.http.HttpStatus;



import java.nio.file.Files;

import java.nio.file.Paths;

@RestController
public class fileDownloadcontroller {
	  private final String uploadDir = "your/file/storage/path/"; // Change to your upload directory

	    @GetMapping("/downloadFile/{filename:.+}")
	    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
	        Path filePath = Paths.get(uploadDir).resolve(filename).normalize();
	        Resource resource;
	        try {
	            resource = new UrlResource(filePath.toUri());
	            if (!resource.exists()) {
	                throw new FileNotFoundException("File not found " + filename);
	            }
	        } catch (MalformedURLException | FileNotFoundException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }

	        String contentType;
	        try {
	            contentType = Files.probeContentType(filePath);
	        } catch (IOException e) {
	            contentType = "application/octet-stream";
	        }

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(contentType))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	                .body(resource);
	    }
}
