package prviKolokvijum2020.app.dto;


import java.util.List;

public class ReceptDTO {
	
	Long id;
	String naziv;
	String postupak;
	List<StavkaReceptaDTO> listaStavki;
	
	
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
	public List<StavkaReceptaDTO> getListaStavki() {
		return listaStavki;
	}
	public void setListaStavki(List<StavkaReceptaDTO> listaStavki) {
		this.listaStavki = listaStavki;
	}
	
	

}
