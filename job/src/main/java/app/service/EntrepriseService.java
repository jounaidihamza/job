package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Entreprise;
import app.repository.EntrepriseRepository;

@Service
public class EntrepriseService {
	
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	public void setEntrepriseRepository(EntrepriseRepository entrepriseRepository) {
		this.entrepriseRepository = entrepriseRepository;
	}

	public Entreprise loginEntreprise(String entrepriseLogin,String password){
		
		return entrepriseRepository.findByEntrepriseLoginAndPassword(entrepriseLogin, password);
		
	}
}
