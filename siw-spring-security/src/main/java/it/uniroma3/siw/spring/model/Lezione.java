 package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@NonNull
public class Lezione {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String durata;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	
	@Column
	private LocalTime orario;
	
	@OneToOne
	private Corso corso;
	
	@OneToOne
	private Insegnante insegnante;
	
	@OneToOne
	private Prenotazione prenotazione;

	public LocalTime getOrario() {
		return this.orario;
	}

	public Insegnante getInsegnante() {
		return this.insegnante;
	}
}

