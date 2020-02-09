package companie.aerienne.mvc.controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import companie.aerienne.mvc.entites.Aeroport;
import companie.aerienne.mvc.services.IAeroportService;

@Controller
@RequestMapping(value = "/aeroport", method = RequestMethod.GET)
public class AeroportController {
	
	@Autowired
	private IAeroportService aeroportService; 
	private String className="Aeroport";
	private String title="Compagnie Aerienne - "+className;
	
	
	@RequestMapping(value="")
	public String aeroport(Model model) {
		List<Aeroport> aeroports = aeroportService.selectAll();
		if(aeroports==null) {
			aeroports=new ArrayList<Aeroport>();
		}
		model.addAttribute("aeroports",aeroports);
		model.addAttribute("title",title);
		model.addAttribute("modalName",className);
		return "aeroport/aeroport";
	}
	
	@RequestMapping(value ="/nouveau", method = RequestMethod.GET)
	public String ajouterAeroport(Model model) {
		Aeroport aeroport = new Aeroport();		
		model.addAttribute("aeroport",aeroport);
		model.addAttribute("title",title);
		return "aeroport/ajouterAeroport";
	}
	
	
	  @RequestMapping(value ="/enregistrer", method = RequestMethod.POST) 
	  public String enregistrerAeroport(Model model,Aeroport aeroport) {
		  if(aeroport.getIdAeroport() != null) {
			  aeroportService.update(aeroport);
		  }else {
		  aeroportService.save(aeroport);
		  }
	  return "redirect:/aeroport"; 
	  }
	  
	  @RequestMapping(value ="/modifier/{id}") 
	  public String modifierAeroport(Model model,@PathVariable String id) {
		  if(id != null) {
			  Aeroport aeroport = aeroportService.getById(id);
			  if(aeroport != null)
			  { 
				  model.addAttribute("aeroport",aeroport);
				  model.addAttribute("title",title);
			  }
		  }
	  
	  return "aeroport/ajouterAeroport"; 
	  }
	  
	  @RequestMapping(value ="/supprimer/{id}") 
	  public String supprimerAeroport(Model model,@PathVariable String id) {
		  if(id != null) {
			  Aeroport aeroport = aeroportService.getById(id);
			  if(aeroport != null)
			  { 
				  aeroportService.remove(id);
			  }
		  }
	  
	  return "redirect:/aeroport/"; 
	  }
	 
}
