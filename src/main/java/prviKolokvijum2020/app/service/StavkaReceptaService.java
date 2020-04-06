package prviKolokvijum2020.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prviKolokvijum2020.app.model.StavkaRecepta;
import prviKolokvijum2020.app.repository.StavkaReceptaRepository;

@Service
public class StavkaReceptaService {
	
	@Autowired
	StavkaReceptaRepository repository;
	
	public Iterable<StavkaRecepta> dobaviSve(){
		return repository.findAll();
	}
	
	public StavkaRecepta dobaviPoId(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void save(StavkaRecepta obj) {
		repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	

}
