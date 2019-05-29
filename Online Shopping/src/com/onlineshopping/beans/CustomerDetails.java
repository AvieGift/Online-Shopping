package com.onlineshopping.beans;

public class CustomerDetails {
	
	public static final String GENDER_MALE="M";
	public static final String GENDER_FEMALE="F";

	
	private String FirstName;
	private String LastName;
	private String Gender;
	private String DateOfBirth;
	private String Email;
	private String PhysicalAddress;
	private String PostalAddress;
	private String Password;
	
	public CustomerDetails() {
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhysicalAddress() {
		return PhysicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		PhysicalAddress = physicalAddress;
	}

	public String getPostalAddress() {
		return PostalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		PostalAddress = postalAddress;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
}
