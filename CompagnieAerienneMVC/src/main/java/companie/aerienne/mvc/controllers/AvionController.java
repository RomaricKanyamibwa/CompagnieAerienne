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
import companie.aerienne.mvc.entites.Avion;
import companie.aerienne.mvc.entites.Type;
import companie.aerienne.mvc.services.IAeroportService;
import companie.aerienne.mvc.services.IAvionService;
import companie.aerienne.mvc.services.ITypeService;

@Controller
@RequestMapping(value = "/avion", method = RequestMethod.GET)
public class AvionController {

	@Autowired
	private IAvionService avionService; 
	@Autowired
	private IAeroportService aeroportService;
	@Autowired
	private ITypeService typeService;
	private String className="Avion";
	private String title="Compagnie Aerienne - "+className;

	@RequestMapping(value="")
	public String avion(Model model) {
		List<Avion> avions = avionService.selectAll();
		if(avions==null) {
			avions=new ArrayList<Avion>();
		}
		model.addAttribute("avions",avions);
		model.addAttribute("title",title);
		model.addAttribute("modalName",className);
		return "avion/avion";
	}

	@RequestMapping(value ="/nouveau", method = RequestMethod.GET)
	public String ajouterAvion(Model model) {
		Avion avion = new Avion();		
		List<Aeroport> aeroports=aeroportService.selectAll();
		model.addAttribute("aeroports",aeroports);

		List<Type> typeAvions=typeService.selectAll();
		model.addAttribute("typeAvions",typeAvions);

		model.addAttribute("avion",avion);
		model.addAttribute("title",title);
		return "avion/ajouterAvion";
	}


	@RequestMapping(value ="/enregistrer", method = RequestMethod.POST) 
	public String enregistrerAvion(Model model,Avion avion) {
		if(avion.getNumAvion() != null) {
//			if(avion.getBaseAeroport().getIdAeroport()=="")
//				  avion.setBaseAeroport(null);
			avionService.update(avion);
		}else {
			avionService.save(avion);
		}
		return "redirect:/avion"; 
	}

	@RequestMapping(value ="/modifier/{id}") 
	public String modifierAvion(Model model,@PathVariable Long id) {
		if(id != null) {
			Avion avion = avionService.getById(id);
			if(avion != null)
			{ 
				List<Aeroport> aeroports=aeroportService.selectAll();
				model.addAttribute("aeroports",aeroports);

				List<Type> typeAvions=typeService.selectAll();
				model.addAttribute("typeAvions",typeAvions);

				model.addAttribute("selectedValue",avion.getBaseAeroport().getIdAeroport());
				model.addAttribute("selectedValue2",avion.getTypeAvion().getTypeAvion());

				model.addAttribute("avion",avion);
				model.addAttribute("title",title);
			}
		}

		return "avion/ajouterAvion"; 
	}

	@RequestMapping(value ="/supprimer/{id}") 
	public String supprimerAvion(Model model,@PathVariable Long id) {
		if(id != null) {
			Avion avion = avionService.getById(id);
			if(avion != null)
			{ 
				avionService.remove(id);
			}
		}

		return "redirect:/avion/"; 
	}

}
