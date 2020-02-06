package com.stock.mvc.controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stock.mvc.entites.Employeur;
import com.stock.mvc.services.IEmployeurService;


@Controller
@RequestMapping(value = "/employeur", method = RequestMethod.GET)
public class EmployeurController {
	
	@Autowired
	private IEmployeurService employeurservice; 
	
	@RequestMapping(value="")
	public String employeurs(Model model) {
		List<Employeur> employeurs = employeurservice.selectAll();
		if(employeurs==null) {
			employeurs=new ArrayList<Employeur>();
		}
		model.addAttribute("employeurs",employeurs);
		return "employeur/employeur";
	}
	
	@RequestMapping(value ="/nouveau", method = RequestMethod.GET)
	public String ajouterEmployeur(Model model) {
		Employeur employeur = new Employeur();		
		model.addAttribute("employeur",employeur);
		return "employeur/ajouterEmployeur";
	}
	
	
	  @RequestMapping(value ="/enregistrer", method = RequestMethod.POST) 
	  public String enregistrerEmployeur(Model model,Employeur employeur) {
		  if(employeur.getIdEmployeur() != null) {
			  employeurservice.update(employeur);
		  }else {
		  employeurservice.save(employeur);
		  }
	  return "redirect:/employeur"; 
	  }
	  
	  @RequestMapping(value ="/modifier/{id}") 
	  public String modifierEmployeur(Model model,@PathVariable Long id) {
		  if(id != null) {
			  Employeur employeur = employeurservice.getById(id);
			  if(employeur != null)
			  { model.addAttribute("employeur",employeur);
			  }
		  }
	  
	  return "employeurs/ajouterEmployeur"; 
	  }
	  
	  @RequestMapping(value ="/supprimer/{id}") 
	  public String supprimerEmployeur(Model model,@PathVariable Long id) {
		  if(id != null) {
			  Employeur employeur = employeurservice.getById(id);
			  if(employeur != null)
			  { 
				  employeurservice.remove(id);
			  }
		  }
	  
	  return "redirect:/employeur/"; 
	  }
	 
}
