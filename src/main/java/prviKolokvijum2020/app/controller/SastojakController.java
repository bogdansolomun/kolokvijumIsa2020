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

import prviKolokvijum2020.app.dto.SastojakDTO;
import prviKolokvijum2020.app.model.Sastojak;
import prviKolokvijum2020.app.service.SastojakService;

@Controller
@CrossOrigin
@RequestMapping(path = "/sastojak")
public class SastojakController {
	
	@Autowired
	SastojakService service;
	ArrayList<SastojakDTO> lista;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<SastojakDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		lista = new ArrayList<SastojakDTO>();
		for(Sastojak x:service.dobaviSve()) {
			lista.add(mm.map(x, SastojakDTO.class));
		}
		
		return new ResponseEntity<ArrayList<SastojakDTO>>(lista, HttpStatus.OK);
	}
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<SastojakDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		Sastojak postojeci = service.dobaviPoId(id);
		
		if(postojeci == null) {
			return new ResponseEntity<SastojakDTO>(HttpStatus.NOT_FOUND);
		}
		SastojakDTO obj = mm.map(postojeci, SastojakDTO.class);
		return new ResponseEntity<SastojakDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Sastojak> dodajNovi(@RequestBody Sastojak obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<Sastojak>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<Sastojak>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<Sastojak> izmeni(@RequestBody Sastojak obj) {
        Sastojak postojeci = service.dobaviPoId(obj.getId());
        
        if (postojeci == null) {
            return new ResponseEntity<Sastojak>(HttpStatus.NOT_FOUND);
        }
        
        
        postojeci.setNaziv(obj.getNaziv());
        
        
        service.save(postojeci);
        return new ResponseEntity<Sastojak>(HttpStatus.OK);
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

}
