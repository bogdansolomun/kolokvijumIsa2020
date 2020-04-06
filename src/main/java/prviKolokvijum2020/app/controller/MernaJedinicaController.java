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

import prviKolokvijum2020.app.dto.MernaJedinicaDTO;
import prviKolokvijum2020.app.model.MernaJedinica;
import prviKolokvijum2020.app.service.MernaJedinicaService;

@Controller
@CrossOrigin
@RequestMapping(path = "/mernaJedinica")
public class MernaJedinicaController {
	@Autowired
	MernaJedinicaService service;
	ArrayList<MernaJedinicaDTO> lista;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<MernaJedinicaDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		lista = new ArrayList<MernaJedinicaDTO>();
		for(MernaJedinica x:service.dobaviSve()) {
			lista.add(mm.map(x, MernaJedinicaDTO.class));
		}
		
		return new ResponseEntity<ArrayList<MernaJedinicaDTO>>(lista, HttpStatus.OK);
	}
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MernaJedinicaDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		MernaJedinica postojeci = service.dobaviPoId(id);
		
		if(postojeci == null) {
			return new ResponseEntity<MernaJedinicaDTO>(HttpStatus.NOT_FOUND);
		}
		MernaJedinicaDTO obj = mm.map(postojeci, MernaJedinicaDTO.class);
		return new ResponseEntity<MernaJedinicaDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<MernaJedinica> dodajNovi(@RequestBody MernaJedinica obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<MernaJedinica>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<MernaJedinica>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<MernaJedinica> izmeni(@RequestBody MernaJedinica obj) {
        MernaJedinica postojeci = service.dobaviPoId(obj.getId());
        
        if (postojeci == null) {
            return new ResponseEntity<MernaJedinica>(HttpStatus.NOT_FOUND);
        }
        
        
        postojeci.setNaziv(obj.getNaziv());
        postojeci.setSkracenica(obj.getSkracenica());
        
        
        service.save(postojeci);
        return new ResponseEntity<MernaJedinica>(HttpStatus.OK);
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
