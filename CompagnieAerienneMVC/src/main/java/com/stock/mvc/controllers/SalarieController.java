package com.stock.mvc.controllers;



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

import com.stock.mvc.LoginController;
import com.stock.mvc.entites.Salarie;
import com.stock.mvc.services.ISalarieService;

@Controller
@RequestMapping(value = "/salarie", method = RequestMethod.GET)
public class SalarieController {
	
	@Autowired
	private ISalarieService salarieservice; 
	@RequestMapping(value="")
	public String salarie(Model model) {
		List<Salarie> salaries = salarieservice.selectAll();
		if(salaries==null) {
			salaries=new ArrayList<Salarie>();
		}
		model.addAttribute("salaries",salaries);
		return "salarie/salarie";
	}
	
	@RequestMapping(value ="/nouveau", method = RequestMethod.GET)
	public String ajouterSalarie(Model model) {
		Salarie salarie = new Salarie();		
		model.addAttribute("salarie",salarie);
		return "salarie/ajouterSalarie";
	}
	
	
	  @RequestMapping(value ="/enregistrer", method = RequestMethod.POST) 
	  public String enregistrerSalarie(Model model,Salarie salarie) {
		  if(salarie.getId() != null) {
			  salarieservice.update(salarie);
		  }else {
		  salarieservice.save(salarie);
		  }
	  return "redirect:/salarie"; 
	  }
	  
	  @RequestMapping(value ="/modifier/{id}") 
	  public String modifierSalarie(Model model,@PathVariable Long id) {
		  if(id != null) {
			  Salarie salarie = salarieservice.getById(id);
			  if(salarie != null)
			  { model.addAttribute("salarie",salarie);
			  }
		  }
	  
	  return "salarie/ajouterSalarie"; 
	  }
	  
	  @RequestMapping(value ="/supprimer/{id}") 
	  public String supprimerSalarie(Model model,@PathVariable Long id) {
		  if(id != null) {
			  Salarie salarie = salarieservice.getById(id);
			  if(salarie != null)
			  { 
				  salarieservice.remove(id);
			  }
		  }
	  
	  return "redirect:/salarie/"; 
	  }
	 
}
