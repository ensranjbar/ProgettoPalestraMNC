package it.uniroma3.siw.spring.model;

import java.util.List;

import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data // toString getter setter equals hashCode
@NonNull
public class Cliente {

	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	
	@OneToMany(mappedBy="cliente")
	private List<Prenotazione> prenotazioni;
	
	
}