package app.model;

import org.springframework.data.annotation.Id;

public class Messages {
	
	@Id
	private String id;
	private String idJobSeeker;
	private String idEntreprise;
	private String message;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdJobSeeker() {
		return idJobSeeker;
	}

	public void setIdJobSeeker(String idJobSeeker) {
		this.idJobSeeker = idJobSeeker;
	}

	public String getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(String idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
