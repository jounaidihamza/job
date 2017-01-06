package app.model;

import org.springframework.data.annotation.Id;

public class Entreprise {
	
	@Id
	private String id;
	private String name;
	private String adress;
	private String domain;
	private String entrepriseLogin;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getEntrepriseLogin() {
		return entrepriseLogin;
	}

	public void setEntrepriseLogin(String entrepriseLogin) {
		this.entrepriseLogin = entrepriseLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
