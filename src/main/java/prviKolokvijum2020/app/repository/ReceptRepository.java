package prviKolokvijum2020.app.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import prviKolokvijum2020.app.model.Recept;

@Repository
public interface ReceptRepository extends CrudRepository<Recept, Long> {
	
	//(SELECT sastojak FROM r.listaStavki WHERE sastojak.id != :sid)
	
	@Query("SELECT DISTINCT r FROM Recept r "
			+ "JOIN r.listaStavki t "
			+ "WHERE t.sastojak.id <> :sid ")
	public List<Recept> nadjiRecepte(@Param("sid") Long id);
	

}
