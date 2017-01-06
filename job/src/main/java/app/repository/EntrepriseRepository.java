package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.Entreprise;

public interface EntrepriseRepository extends MongoRepository<Entreprise, String>{

	Entreprise findByEntrepriseLoginAndPassword(String entrepriseLogin, String password);

}
