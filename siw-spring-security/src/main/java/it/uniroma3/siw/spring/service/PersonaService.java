package it.uniroma3.siw.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.spring.model.Persona;
import it.uniroma3.siw.spring.repository.PersonaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The UserService handles logic for Users.
 */
@Service
public class PersonaService {

    @Autowired
    protected PersonaRepository personaRepository;

    /**
     * This method retrieves a User from the DB based on its ID.
     * @param id the id of the User to retrieve from the DB
     * @return the retrieved User, or null if no User with the passed ID could be found in the DB
     */
    @Transactional
    public Persona personaPerId(Long id) {
        Optional<Persona> result = this.personaRepository.findById(id);
        return result.orElse(null);
    }

    /**
     * This method saves a User in the DB.
     * @param user the User to save into the DB
     * @return the saved User
     * @throws DataIntegrityViolationException if a User with the same username
     *                              as the passed User already exists in the DB
     */
    @Transactional
    public Persona inserisci(Persona user) {
        return this.personaRepository.save(user);
    }

    /**
     * This method retrieves all Users from the DB.
     * @return a List with all the retrieved Users
     */
    @Transactional
    public List<Persona> getAllUsers() {
        List<Persona> result = new ArrayList<>();
        Iterable<Persona> iterable = this.personaRepository.findAll();
        for(Persona user : iterable)
            result.add(user);
        return result;
    }
}
