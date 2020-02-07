package companie.aerienne.mvc.controllers;



import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import companie.aerienne.mvc.entites.Pilote;
import companie.aerienne.mvc.services.IPiloteService;

@Controller
@RequestMapping(value = "/pilote", method = RequestMethod.GET)
public class PiloteController {
	
	@Autowired
	private IPiloteService piloteService; 
	@RequestMapping(value="")
	public String pilote(Model model) {
		List<Pilote> pilotes = piloteService.selectAll();
		if(pilotes==null) {
			pilotes=new ArrayList<Pilote>();
		}
		model.addAttribute("pilotes",pilotes);
		model.addAttribute("title","Compagnie Aerienne - Pilote");
		return "pilote/pilote";
	}
	
	@RequestMapping(value ="/nouveau", method = RequestMethod.GET)
	public String ajouterPilote(Model model) {
		Pilote pilote = new Pilote();		
		model.addAttribute("pilote",pilote);
		model.addAttribute("title","Compagnie Aerienne - Pilote");
		return "pilote/ajouterPilote";
	}
	
	
	  @RequestMapping(value ="/enregistrer", method = RequestMethod.POST) 
	  public String enregistrerPilote(Model model,Pilote pilote) {
		  if(pilote.getIdPilote() != null) {
			  piloteService.update(pilote);
		  }else {
		  piloteService.save(pilote);
		  }
	  return "redirect:/pilote"; 
	  }
	  
	  @RequestMapping(value ="/modifier/{id}") 
	  public String modifierPilote(Model model,@PathVariable Long id) {
		  if(id != null) {
			  Pilote pilote = piloteService.getById(id);
			  if(pilote != null)
			  { 
				  model.addAttribute("pilote",pilote);
				  model.addAttribute("title","Compagnie Aerienne - Pilote");
			  }
		  }
	  
	  return "pilote/ajouterPilote"; 
	  }
	  
	  @RequestMapping(value ="/supprimer/{id}") 
	  public String supprimerPilote(Model model,@PathVariable Long id) {
		  if(id != null) {
			  Pilote pilote = piloteService.getById(id);
			  if(pilote != null)
			  { 
				  piloteService.remove(id);
			  }
		  }
	  
	  return "redirect:/pilote/"; 
	  }
	 
}
