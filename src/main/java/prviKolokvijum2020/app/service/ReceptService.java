package prviKolokvijum2020.app.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prviKolokvijum2020.app.model.Recept;
import prviKolokvijum2020.app.repository.ReceptRepository;


@Service
public class ReceptService {
	
	@Autowired
	ReceptRepository repository;
	
	public Iterable<Recept> dobaviSve(){
		return repository.findAll();
	}
	
	public Recept dobaviPoId(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void save(Recept obj) {
		repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public List<Recept> nadjiRecepte(Long id){
		return repository.nadjiRecepte(id);
	}
	
	

}
