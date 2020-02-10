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
import companie.aerienne.mvc.entites.Type;
import companie.aerienne.mvc.services.IConstructeurService;
import companie.aerienne.mvc.services.ITypeService;
import companie.aerienne.mvc.services.impl.ConstructeurServiceImpl;

@Controller
@RequestMapping(value = "/type", method = RequestMethod.GET)
public class TypeController {
	
	@Autowired
	private ITypeService typeService; 
	@Autowired
	private IConstructeurService constructorService;//
	private String className="Type";
	private String title="Compagnie Aerienne - "+className;
	
	
	@RequestMapping(value="")
	public String type(Model model) {
		List<Type> types = typeService.selectAll();
		if(types==null) {
			types=new ArrayList<Type>();
		}
		model.addAttribute("types",types);
		model.addAttribute("title",title);
		model.addAttribute("modalName",className);
		return "type/type";
	}
	
	@RequestMapping(value ="/nouveau", method = RequestMethod.GET)
	public String ajouterType(Model model) {
		Type type = new Type();		
		List<Constructeur> constructeurs=this.constructorService.selectAll();
		model.addAttribute("constructeurs", constructeurs);
		model.addAttribute("type",type);
		model.addAttribute("title",title);
		return "type/ajouterType";
	}
	
	
	  @RequestMapping(value ="/enregistrer", method = RequestMethod.POST) 
	  public String enregistrerType(Model model,Type type) {
		  if(type.getTypeAvion() != null) {
			  if(type.getConstructeur().getIdConstructeur()==0)
				  type.setConstructeur(null);
			  typeService.update(type);
		  }else {
		  typeService.save(type);
		  }
	  return "redirect:/type"; 
	  }
	  
	  @RequestMapping(value ="/modifier/{id}") 
	  public String modifierType(Model model,@PathVariable String id) {
		  if(id != null) {
			  Type type = typeService.getById(id);
			  if(type != null)
			  { 
				  if(type.getConstructeur()==null)
					  type.setConstructeur(new Constructeur());
				  List<Constructeur> constructeurs=this.constructorService.selectAll();
				  model.addAttribute("constructeurs", constructeurs);
				  model.addAttribute("type",type);
				  model.addAttribute("selectedConstructeur",type.getConstructeur().getIdConstructeur());
				  model.addAttribute("title",title);
			  }
		  }
	  
	  return "type/ajouterType"; 
	  }
	  
	  @RequestMapping(value ="/supprimer/{id}") 
	  public String supprimerType(Model model,@PathVariable String id) {
		  if(id != null) {
			  Type type = typeService.getById(id);
			  if(type != null)
			  { 
				  typeService.remove(id);
			  }
		  }
	  
	  return "redirect:/type/"; 
	  }
	 
}
