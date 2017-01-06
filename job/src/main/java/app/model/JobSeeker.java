package app.model;

import org.springframework.data.annotation.Id;

public class JobSeeker {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String profileDescription;
	private String email;
	private String password;
	//private String cvUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

//	public String getCvUrl() {
//		return cvUrl;
//	}
//
//	public void setCvUrl(String cvUrl) {
//		this.cvUrl = cvUrl;
//	}
	
}
