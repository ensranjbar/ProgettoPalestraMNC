package it.uniroma3.siw.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.CorsoValidator;

import it.uniroma3.siw.spring.model.Corso;
import it.uniroma3.siw.spring.service.CorsoService;

@Controller
public class CorsoController {

	@Autowired
	private CorsoService corsoService;

	@Autowired
	private CorsoValidator corsoValidator;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/addCorso", method = RequestMethod.GET)
	public String addCorso(Model model) {
		logger.debug("addCorso");
		model.addAttribute("corso", new Corso());
		return "corsoForm.html";
	}

	@RequestMapping(value = "/corso/{id}", method = RequestMethod.GET)
	public String getCorso(@PathVariable("id") Long id, Model model) {
		model.addAttribute("corso", this.corsoService.corsoPerId(id));
		return "corso.html";
	}

	@RequestMapping(value = "/corso", method = RequestMethod.GET)
	public String getcorsi(Model model) {
		model.addAttribute("corsi", this.corsoService.tutti());
		return "corsi.html";
	}

	@RequestMapping(value = "/corso", method = RequestMethod.POST)
	public String newCorso(@ModelAttribute("corso") Corso corso, Model model, BindingResult bindingResult) {
		this.corsoValidator.validate(corso, bindingResult);
		if (!bindingResult.hasErrors()) {
			this.corsoService.inserisci(corso);
			model.addAttribute("corsi", this.corsoService.tutti());
			return "corsi.html";
		}
		return "corsoForm.html";
	}
}
