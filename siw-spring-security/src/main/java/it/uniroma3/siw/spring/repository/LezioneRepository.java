package it.uniroma3.siw.spring.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Insegnante;
import it.uniroma3.siw.spring.model.Lezione;

public interface LezioneRepository extends CrudRepository<Lezione, Long> {

	public List<Lezione> findByOrario(LocalTime orario);

	public List<Lezione> findByData(LocalTime data);
	
	public List<Lezione> findByDataOrOrario(LocalTime data, LocalTime orario);

	public List<Lezione> findByInsegnante(Insegnante insegnante);
}