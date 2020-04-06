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

import prviKolokvijum2020.app.dto.StavkaReceptaDTO;
import prviKolokvijum2020.app.model.StavkaRecepta;
import prviKolokvijum2020.app.service.StavkaReceptaService;

@Controller
@CrossOrigin
@RequestMapping(path = "/stavkaRecepta")
public class StavkaReceptaController {
	
	@Autowired
	StavkaReceptaService service;
	ArrayList<StavkaReceptaDTO> lista;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<StavkaReceptaDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		lista = new ArrayList<StavkaReceptaDTO>();
		for(StavkaRecepta x:service.dobaviSve()) {
			lista.add(mm.map(x, StavkaReceptaDTO.class));
		}
		
		return new ResponseEntity<ArrayList<StavkaReceptaDTO>>(lista, HttpStatus.OK);
	}
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<StavkaReceptaDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		StavkaRecepta postojeci = service.dobaviPoId(id);
		
		if(postojeci == null) {
			return new ResponseEntity<StavkaReceptaDTO>(HttpStatus.NOT_FOUND);
		}
		StavkaReceptaDTO obj = mm.map(postojeci, StavkaReceptaDTO.class);
		return new ResponseEntity<StavkaReceptaDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<StavkaRecepta> dodajNovi(@RequestBody StavkaRecepta obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<StavkaRecepta>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<StavkaRecepta>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<StavkaRecepta> izmeni(@RequestBody StavkaRecepta obj) {
        StavkaRecepta postojeci = service.dobaviPoId(obj.getId());
        
        if (postojeci == null) {
            return new ResponseEntity<StavkaRecepta>(HttpStatus.NOT_FOUND);
        }
        
        
        postojeci.setKolicina(obj.getKolicina());
        
        
        service.save(postojeci);
        return new ResponseEntity<StavkaRecepta>(HttpStatus.OK);
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
