package prviKolokvijum2020.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class MernaJedinica {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(nullable = false)
	String naziv;
	
	@Column(nullable = false)
	String skracenica;
	
	@OneToMany(mappedBy = "mernaJedinica" ,fetch = FetchType.LAZY)
	List<StavkaRecepta> stavkeRecepta;
	
	
	
	public MernaJedinica() {
		
	}
	
	

	public MernaJedinica(Long id, String naziv, String skracenica) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.skracenica = skracenica;
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

	public String getSkracenica() {
		return skracenica;
	}

	public void setSkracenica(String skracenica) {
		this.skracenica = skracenica;
	}



	public List<StavkaRecepta> getStavkeRecepta() {
		return stavkeRecepta;
	}



	public void setStavkeRecepta(List<StavkaRecepta> stavkeRecepta) {
		this.stavkeRecepta = stavkeRecepta;
	}



	
	
	
	

}
