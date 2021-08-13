package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import it.uniroma3.siw.spring.model.Prenotazione;
import it.uniroma3.siw.spring.repository.PrenotazioneRepository;

public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepository; 
	
	@Transactional
	public Prenotazione inserisci(Prenotazione prenotazione) {
		return prenotazioneRepository.save(prenotazione);
	}
	
	@Transactional
	public List<Prenotazione> tutti() {
		return (List<Prenotazione>) prenotazioneRepository.findAll();
	}
	
	@Transactional
	public Prenotazione prenotazionePerId(Long id) {
		Optional<Prenotazione> optional = prenotazioneRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	/* @Transactional
	public boolean alreadyExists(Persona persona) {
		List<Persona> studenti = this.personaRepository.findByNomeAndCognome(persona.getNome(), persona.getCognome());
		if (studenti.size() > 0)
			return true;
		else 
			return false;
	} */  // ????
}
