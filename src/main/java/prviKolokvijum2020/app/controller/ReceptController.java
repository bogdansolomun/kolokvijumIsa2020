package prviKolokvijum2020.app.controller;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import prviKolokvijum2020.app.dto.ReceptDTO;
import prviKolokvijum2020.app.model.Recept;
import prviKolokvijum2020.app.service.ReceptService;

@Controller
@CrossOrigin
@RequestMapping(path = "/recept")
public class ReceptController {
	
	@Autowired
	ReceptService service;
	ArrayList<ReceptDTO> lista;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<ReceptDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		lista = new ArrayList<ReceptDTO>();
		for(Recept x:service.dobaviSve()) {
			lista.add(mm.map(x, ReceptDTO.class));
		}
		
		return new ResponseEntity<ArrayList<ReceptDTO>>(lista, HttpStatus.OK);
	}
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ReceptDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		Recept postojeci = service.dobaviPoId(id);
		
		if(postojeci == null) {
			return new ResponseEntity<ReceptDTO>(HttpStatus.NOT_FOUND);
		}
		ReceptDTO obj = mm.map(postojeci, ReceptDTO.class);
		return new ResponseEntity<ReceptDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Recept> dodajNovi(@RequestBody Recept obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<Recept>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<Recept>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<Recept> izmeni(@RequestBody Recept obj) {
        Recept postojeci = service.dobaviPoId(obj.getId());
        
        if (postojeci == null) {
            return new ResponseEntity<Recept>(HttpStatus.NOT_FOUND);
        }
        
        
        postojeci.setNaziv(obj.getNaziv());
        postojeci.setPostupak(obj.getPostupak());
        
        
        service.save(postojeci);
        return new ResponseEntity<Recept>(HttpStatus.OK);
    }

    //Brisanje
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> brisanje(@PathVariable("id") Long id) {
    	
        if (service.dobaviPoId(id) == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        
        service.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
    
    @RequestMapping(path = "/nadjiRecepte/{id}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<ReceptDTO>> nadjiRecepte(@PathVariable("id") Long id){
    	
		ModelMapper mm = new ModelMapper();
		
		ArrayList<ReceptDTO> listaR = new ArrayList<ReceptDTO>();
		
		for(Recept x : service.nadjiRecepte(id)) {
			listaR.add(mm.map(x, ReceptDTO.class));
		}
		
		return new ResponseEntity<ArrayList<ReceptDTO>>(listaR, HttpStatus.OK);
	}
    
    
    

}
