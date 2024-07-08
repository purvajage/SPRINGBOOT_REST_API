package com.example.springfileuploaddownload.exception;

public class FileStorageException extends RuntimeException {
	  private static final long serialVerionUID = 1L;

	    public FileStorageException(String message) {
	        super(message);
	    }

	    public FileStorageException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
