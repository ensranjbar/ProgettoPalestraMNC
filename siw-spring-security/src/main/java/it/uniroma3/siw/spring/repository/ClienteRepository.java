package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	public List<Cliente> findByNome(String nome);

	public List<Cliente> findByNomeAndCognome(String nome, String cognome);

	public List<Cliente> findByNomeOrCognome(String nome, String cognome);
	
}