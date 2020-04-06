package prviKolokvijum2020.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import prviKolokvijum2020.app.model.Sastojak;

@Repository
public interface SastojakRepository extends CrudRepository<Sastojak, Long> {

}
