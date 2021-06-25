package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Lezione;
import it.uniroma3.siw.spring.model.Prenotazione;

public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long> {

	public List<Prenotazione> findByLezione(Lezione lezione);
	
	
	// ?????????

//	public List<Prenotazione> findByNomeAndCognome(String nome, String cognome);

//	public List<Prenotazione> findByNomeOrCognome(String nome, String cognome);
}