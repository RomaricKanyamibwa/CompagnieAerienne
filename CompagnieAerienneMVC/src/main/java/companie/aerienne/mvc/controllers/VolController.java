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
import companie.aerienne.mvc.entites.Vol;
import companie.aerienne.mvc.entites.Type;
import companie.aerienne.mvc.services.IAeroportService;
import companie.aerienne.mvc.services.IVolService;
import companie.aerienne.mvc.services.ITypeService;

@Controller
@RequestMapping(value = "/vol", method = RequestMethod.GET)
public class VolController {

	@Autowired
	private IVolService volService; 
	@Autowired
	private IAeroportService aeroportService;

	private String className="Vol";
	private String title="Compagnie Aerienne - "+className;

	@RequestMapping(value="")
	public String vol(Model model) {
		List<Vol> vols = volService.selectAll();
		if(vols==null) {
			vols=new ArrayList<Vol>();
		}
		model.addAttribute("vols",vols);
		model.addAttribute("title",title);
		model.addAttribute("modalName",className);
		return "vol/vol";
	}

	@RequestMapping(value ="/nouveau", method = RequestMethod.GET)
	public String ajouterVol(Model model) {
		Vol vol = new Vol();		
		List<Aeroport> aeroports=aeroportService.selectAll();
		model.addAttribute("aeroports",aeroports);

		model.addAttribute("vol",vol);
		model.addAttribute("title",title);
		return "vol/ajouterVol";
	}


	@RequestMapping(value ="/enregistrer", method = RequestMethod.POST) 
	public String enregistrerVol(Model model,Vol vol) {
		if(vol.getNumVol() != null) {
//			if(vol.getBaseAeroport().getIdAeroport()=="")
//				  vol.setBaseAeroport(null);
			volService.update(vol);
		}else {
			volService.save(vol);
		}
		return "redirect:/vol"; 
	}

	@RequestMapping(value ="/modifier/{id}") 
	public String modifierVol(Model model,@PathVariable String id) {
		if(id != null) {
			Vol vol = volService.getById(id);
			if(vol != null)
			{ 
				List<Aeroport> aeroports=aeroportService.selectAll();
				model.addAttribute("aeroports",aeroports);

				model.addAttribute("selectedValue",vol.getAeroportArr().getIdAeroport());
				model.addAttribute("selectedValue2",vol.getAeroportDept().getIdAeroport());

				model.addAttribute("vol",vol);
				model.addAttribute("title",title);
			}
		}

		return "vol/ajouterVol"; 
	}

	@RequestMapping(value ="/supprimer/{id}") 
	public String supprimerVol(Model model,@PathVariable String id) {
		if(id != null) {
			Vol vol = volService.getById(id);
			if(vol != null)
			{ 
				volService.remove(id);
			}
		}

		return "redirect:/vol/"; 
	}

}
