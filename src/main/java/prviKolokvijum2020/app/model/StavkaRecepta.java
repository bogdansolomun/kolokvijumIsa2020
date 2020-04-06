package prviKolokvijum2020.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class StavkaRecepta {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(nullable = false)
	Double kolicina;
	
	@ManyToOne()
	@JoinColumn(name = "merna_jedinica_id")
	MernaJedinica mernaJedinica;
	
	@OneToOne
	@JoinColumn(name = "sastojak_id")
	Sastojak sastojak;
	
	@ManyToOne
	@JoinColumn(name = "recept_id")
	Recept recept;
	
	
	public StavkaRecepta() {
		
	}
	

	public StavkaRecepta(Long id, Double kolicina) {
		super();
		this.id = id;
		this.kolicina = kolicina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getKolicina() {
		return kolicina;
	}

	public void setKolicina(Double kolicina) {
		this.kolicina = kolicina;
	}


	public MernaJedinica getMernaJedinica() {
		return mernaJedinica;
	}


	public void setMernaJedinica(MernaJedinica mernaJedinica) {
		this.mernaJedinica = mernaJedinica;
	}


	public Sastojak getSastojak() {
		return sastojak;
	}


	public void setSastojak(Sastojak sastojak) {
		this.sastojak = sastojak;
	}


	public Recept getRecept() {
		return recept;
	}


	public void setRecept(Recept recept) {
		this.recept = recept;
	}
	
	
	
	
	
	
	

}
