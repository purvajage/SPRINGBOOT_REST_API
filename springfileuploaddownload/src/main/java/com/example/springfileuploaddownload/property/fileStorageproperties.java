package com.example.springfileuploaddownload.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="file")
public class fileStorageproperties {
	  private String uploadDir;

	    public String getUploadDir(){
	        return uploadDir;
	    }

	    public void setUploadDir(String uploadDir){
	        this.uploadDir = uploadDir;
	    }
}
