package prviKolokvijum2020.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prviKolokvijum2020.app.model.Sastojak;
import prviKolokvijum2020.app.repository.SastojakRepository;


@Service
public class SastojakService {
	
	@Autowired
	SastojakRepository repository;
	
	public Iterable<Sastojak> dobaviSve(){
		return repository.findAll();
	}
	
	public Sastojak dobaviPoId(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void save(Sastojak obj) {
		repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	

}
