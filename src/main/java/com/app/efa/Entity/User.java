package com.app.efa.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Embeddable
public  class User {
	// user's first name
	@Column(nullable = false, unique = false, length = 30)
	private String firstName;
	// user's last name
	@Column(nullable = false, unique = false, length = 30)
	private String lastName;
	// user's date of birth for age calculation
	@Column(nullable = false, unique = false, length = 30)
	private Date dateOfBirth;
	// user's gender
	@Column(nullable = false, unique = false, length = 3)
	private char gender;
	@Column(nullable = false, unique = true, length = 30)
	private String email;
	// user's phone number
	@Column(nullable = false, unique = true, length = 20)
	private String phoneNumber;
	// user registration date
	@Column(nullable=false,unique = false , length = 40)
	private String password;
	@Column(nullable = true, unique = false, length = 30)
	private Date registrationDate;
	// user profile picture
	@Column(nullable = true, unique = false, length = 40)
	private String profilePicture;
	@Embedded
	private Address userAddress;

	public User(){
		registrationDate = new Date();
	}

}
