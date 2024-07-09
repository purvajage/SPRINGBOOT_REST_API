package com.Springboot_Crud_Rest_Api_Validation.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="employess")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@Nonnull
@Size(max=7,message="maximum 7 numbers required for this filed")
private int sallary;
private String position;
@Email
@NotBlank
private String workemailId;
@Email
@NotBlank
private String emailId;
@Nonnull
@Size(max=10,message="maximum 10 number in mobile number")
private String mobilenumber;
@Nonnull
@Size(min=2,message="first name should have atleast 5 character")
private String middlename;
@Nonnull
@Size(min=2,message="first name should have atleast 5 character")
private String lastname;
@Nonnull
@Size(min=2,message="first name should have atleast 5 character")
private String firstname;
public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public int getSallary() {
	return sallary;
}

public void setSallary(int sallary) {
	this.sallary = sallary;
}

public String getPosition() {
	return position;
}

public void setposition(String Position) {
	position = Position;
}

public String getWorkemailId() {
	return workemailId;
}

public void setWorkemailId(String workemailId) {
	this.workemailId = workemailId;
}

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public String getMobilenumber() {
	return mobilenumber;
}

public void setMobilenumber(String mobilenumber) {
	this.mobilenumber = mobilenumber;
}

public String getMiddlename() {
	return middlename;
}

public void setMiddlename(String middlename) {
	this.middlename = middlename;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public Employee(long id, @Size(max = 7, message = "maximum 7 numbers required for this filed") int sallary,
		@Size(max = 10, message = "only 1 position required") String position, @Email @NotBlank String workemailId,
		@Email @NotBlank String emailId,
		@Size(max = 10, message = "maximum 10 number in mobile number") String mobilenumber,
		@Size(min = 2, message = "first name should have atleast 5 character") String middlename,
		@Size(min = 2, message = "first name should have atleast 5 character") String lastname,
		@Size(min = 2, message = "first name should have atleast 5 character") String firstname) {
	super();
	this.id = id;
	this.sallary = sallary;
	this.position = position;
	this.workemailId = workemailId;
	this.emailId = emailId;
	this.mobilenumber = mobilenumber;
	this.middlename = middlename;
	this.lastname = lastname;
	this.firstname = firstname;
}

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

}
