
package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import java.time.LocalTime;

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
public class Lezione {
	
	private Long id;
	private String durata;
	private LocalDate data;
	private LocalTime orario;
	@ManyToOne
	private Corso corso;
	@ManyToOne
	private Insegnante insegnante;
	@OneToOne
	private Prenotazione prenotazione;
}

