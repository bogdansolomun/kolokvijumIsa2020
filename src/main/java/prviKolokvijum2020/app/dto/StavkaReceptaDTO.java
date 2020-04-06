package prviKolokvijum2020.app.dto;

public class StavkaReceptaDTO {
	
	Long id;
	Double kolicina;
	SastojakDTO sastojak;
	MernaJedinicaDTO mernaJedinica;
	
	
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
	public SastojakDTO getSastojak() {
		return sastojak;
	}
	public void setSastojak(SastojakDTO sastojak) {
		this.sastojak = sastojak;
	}
	public MernaJedinicaDTO getMernaJedinica() {
		return mernaJedinica;
	}
	public void setMernaJedinica(MernaJedinicaDTO mernaJedinica) {
		this.mernaJedinica = mernaJedinica;
	}
	
	
	
	

}
