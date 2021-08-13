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
import it.uniroma3.siw.spring.controller.validator.ProdottoValidator;
import it.uniroma3.siw.spring.model.Lezione;
import it.uniroma3.siw.spring.repository.LezioneRepository;
import it.uniroma3.siw.spring.service.LezioneService;

public class LezioneController {

	@Autowired
	private LezioneService lezioneService;
	
    @Autowired
    private LezioneRepository lezioniRepository;
        
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	  @RequestMapping(value="/admin/lezione", method = RequestMethod.GET)
	    public String addLezione(Model model) {
	    	logger.debug("/admin/lezione");
	    	model.addAttribute("lezione", new Lezione());
	        return "lezioneForm";
	    }

	  
	   @RequestMapping(value = "/lezione/{id}", method = RequestMethod.GET)
	    public String getCuratore(@PathVariable("id") Long id, Model model) {
	    	model.addAttribute("lezione", this.lezioneService.lezionePerId(id));
	    	return "lezione";
	    }
	

	    @RequestMapping(value = "/lezione", method = RequestMethod.GET)
	    public String getLezioni(Model model) {
	    		model.addAttribute("lezioni", this.lezioneService.tutti());
	    		return "lezioni";
	    }
	    

	    @RequestMapping(value = "/admin/lezione", method = RequestMethod.POST)
	    public String newLezione(@ModelAttribute("lezione") Lezione lezione, 
	    									Model model, BindingResult bindingResult) {
	    	logger.debug("/admin/lezione");
	    	this.lezioneValidator.validate(lezione, bindingResult);
	        if (!bindingResult.hasErrors()) {
	        	this.lezioneService.inserisci(lezione);
	            model.addAttribute("lezioni", this.lezioneService.tutti());
	            return "lezioni";
	        }
	        return "lezioneForm";
	    }
	    
	    @RequestMapping(value = "/deleteCuratore/{id}", method = RequestMethod.POST)
	    public String deleteCuratore(@PathVariable("id") Long id) {
	    	this.curatoreService.deleteCuratoreById(id);
	    	return "curatori";
	    }
}
