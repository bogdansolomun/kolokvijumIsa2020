package prviKolokvijum2020.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prviKolokvijum2020.app.model.MernaJedinica;
import prviKolokvijum2020.app.repository.MernaJedinicaRepository;

@Service
public class MernaJedinicaService {
	
	@Autowired
	MernaJedinicaRepository repository;
	
	public Iterable<MernaJedinica> dobaviSve(){
		return repository.findAll();
	}
	
	public MernaJedinica dobaviPoId(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void save(MernaJedinica obj) {
		repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	

}
