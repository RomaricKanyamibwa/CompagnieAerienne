package companie.aerienne.mvc.controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import companie.aerienne.mvc.entites.Constructeur;
import companie.aerienne.mvc.services.IConstructeurService;

@Controller
@RequestMapping(value = "/constructeur", method = RequestMethod.GET)
public class ConstructeurController {
	
	@Autowired
	private IConstructeurService constructeurService; 
	private String className="Constructeur";
	private String title="Compagnie Aerienne - "+className;
	
	@RequestMapping(value="")
	public String constructeur(Model model) {
		List<Constructeur> constructeurs = constructeurService.selectAll();
		if(constructeurs==null) {
			constructeurs=new ArrayList<Constructeur>();
		}
		model.addAttribute("constructeurs",constructeurs);
		model.addAttribute("title",title);
		model.addAttribute("modalName",className);
		return "constructeur/constructeur";
	}
	
	@RequestMapping(value ="/nouveau", method = RequestMethod.GET)
	public String ajouterConstructeur(Model model) {
		Constructeur constructeur = new Constructeur();		
		model.addAttribute("constructeur",constructeur);
		model.addAttribute("title",title);
		return "constructeur/ajouterConstructeur";
	}
	
	
	  @RequestMapping(value ="/enregistrer", method = RequestMethod.POST) 
	  public String enregistrerConstructeur(Model model,Constructeur constructeur) {
		  if(constructeur.getIdConstructeur() != null) {
			  constructeurService.update(constructeur);
		  }else {
		  constructeurService.save(constructeur);
		  }
	  return "redirect:/constructeur"; 
	  }
	  
	  @RequestMapping(value ="/modifier/{id}") 
	  public String modifierConstructeur(Model model,@PathVariable Long id) {
		  if(id != null) {
			  Constructeur constructeur = constructeurService.getById(id);
			  if(constructeur != null)
			  { 
				  model.addAttribute("constructeur",constructeur);
				  model.addAttribute("title",title);
			  }
		  }
	  
	  return "constructeur/ajouterConstructeur"; 
	  }
	  
	  @RequestMapping(value ="/supprimer/{id}") 
	  public String supprimerConstructeur(Model model,@PathVariable Long id) {
		  if(id != null) {
			  Constructeur constructeur = constructeurService.getById(id);
			  if(constructeur != null)
			  { 
				  constructeurService.remove(id);
			  }
		  }
	  
	  return "redirect:/constructeur/"; 
	  }
	 
}
