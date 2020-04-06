package prviKolokvijum2020.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Recept {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(nullable = false)
	String naziv;
	
	@Column(nullable = false)
	String postupak;
	
	
	
	@OneToMany(mappedBy = "recept",fetch = FetchType.LAZY)
	List<StavkaRecepta> listaStavki;
	
	
	
	public Recept() {
		
	}
	

	public Recept(Long id, String naziv, String postupak) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.postupak = postupak;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPostupak() {
		return postupak;
	}

	public void setPostupak(String postupak) {
		this.postupak = postupak;
	}


	public List<StavkaRecepta> getListaStavki() {
		return listaStavki;
	}


	public void setListaStavki(List<StavkaRecepta> listaStavki) {
		this.listaStavki = listaStavki;
	}
	
	
	
	
	

}
