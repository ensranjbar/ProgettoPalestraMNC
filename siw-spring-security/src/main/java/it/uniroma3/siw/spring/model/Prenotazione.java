package it.uniroma3.siw.spring.model;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@NonNull
public class Prenotazione {
	private Long id;
	@OneToOne
	private Lezione lezione;
	@ManyToOne
	private Cliente cliente ;
}
