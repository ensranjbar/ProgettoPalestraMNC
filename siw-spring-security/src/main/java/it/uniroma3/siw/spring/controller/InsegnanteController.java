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

import it.uniroma3.siw.spring.controller.validator.InsegnanteValidator;
import it.uniroma3.siw.spring.model.Insegnante;
import it.uniroma3.siw.spring.service.InsegnanteService;

@Controller
public class InsegnanteController {
	
	@Autowired
	private InsegnanteService insegnanteService;
	
    @Autowired
    private InsegnanteValidator insegnanteValidator;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    

    @RequestMapping(value="/addInsegnante", method = RequestMethod.GET)
    public String addInsegnante(Model model) {
    	logger.debug("addInsegnante");
    	model.addAttribute("insegnante", new Insegnante());
        return "insegnanteForm.html";
    }

    @RequestMapping(value = "/insegnante/{id}", method = RequestMethod.GET)
    public String getInsegnante(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("insegnante", this.insegnanteService.insegnantePerId(id));
    	return "insegnante.html";
    }

    @RequestMapping(value = "/insegnante", method = RequestMethod.GET)
    public String getinsegnanti(Model model) {
    		model.addAttribute("insegnanti", this.insegnanteService.tutti());
    		return "insegnanti.html";
    }
    
    @RequestMapping(value = "/insegnante", method = RequestMethod.POST)
    public String newInsegnante(@ModelAttribute("insegnante") Insegnante insegnante, 
    									Model model, BindingResult bindingResult) {
    	this.insegnanteValidator.validate(insegnante, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.insegnanteService.inserisci(insegnante);
            model.addAttribute("insegnanti", this.insegnanteService.tutti());
            return "insegnanti.html";
        }
        return "insegnanteForm.html";
    }
}