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
import companie.aerienne.mvc.entites.Affectation;
import companie.aerienne.mvc.entites.Avion;
import companie.aerienne.mvc.entites.PK_KeyAffectation;
import companie.aerienne.mvc.entites.Pilote;
import companie.aerienne.mvc.entites.Type;
import companie.aerienne.mvc.entites.Vol;
import companie.aerienne.mvc.services.IAeroportService;
import companie.aerienne.mvc.services.IAffectationService;
import companie.aerienne.mvc.services.IAvionService;
import companie.aerienne.mvc.services.IPiloteService;
import companie.aerienne.mvc.services.ITypeService;
import companie.aerienne.mvc.services.IVolService;

@Controller
@RequestMapping(value = "/affectation", method = RequestMethod.GET)
public class AffectationController {

	@Autowired
	private IAffectationService affectationService; 
	@Autowired
	private IVolService volService;
	@Autowired
	private IAvionService avionService;
	@Autowired
	private IPiloteService piloteService;

	private String className="Affectation";
	private String title="Compagnie Aerienne - "+className;

	@RequestMapping(value="")
	public String affectation(Model model) {
		List<Affectation> affectations = affectationService.selectAll();
		if(affectations==null) {
			affectations=new ArrayList<Affectation>();
		}
		model.addAttribute("affectations",affectations);
		model.addAttribute("title",title);
		model.addAttribute("modalName",className);
		return "affectation/affectation";
	}

	@RequestMapping(value ="/nouveau", method = RequestMethod.GET)
	public String ajouterAffectation(Model model) {
		Affectation affectation = new Affectation();		
		List<Vol> vols=volService.selectAll();
		model.addAttribute("vols",vols);

		List<Avion> avions=avionService.selectAll();
		model.addAttribute("avions",avions);
		
		List<Pilote> pilotes=piloteService.selectAll();
		model.addAttribute("pilotes",pilotes);
		
		model.addAttribute("affectation",affectation);
		model.addAttribute("title",title);
		return "affectation/ajouterAffectation";
	}


	@RequestMapping(value ="/enregistrer", method = RequestMethod.POST) 
	public String enregistrerAffectation(Model model,Affectation affectation) {
		System.err.println("=====================================================");
		System.out.println(affectation);
		System.err.println("=====================================================");
		if(affectation.getPkAffectation() != null) {
//			if(affectation.getBaseAeroport().getIdAeroport()=="")
//				  affectation.setBaseAeroport(null);
			affectation.setVol(new Vol(affectation.getPkAffectation().getNumVol()));
			affectationService.update(affectation);
		}else {
			affectationService.save(affectation);
		}
		return "redirect:/affectation"; 
	}

	@RequestMapping(value ="/modifier/{numVol}/{dateVol}/") 
	public String modifierAffectation(Model model
			,@PathVariable String numVol,@PathVariable String dateVol) {
		if(numVol != null && dateVol!=null) {
			PK_KeyAffectation pk=new PK_KeyAffectation(numVol,dateVol);
			Affectation affectation = affectationService.getById(pk);
			if(affectation != null)
			{ 
				List<Vol> vols=volService.selectAll();
				model.addAttribute("vols",vols);

				List<Avion> avions=avionService.selectAll();
				model.addAttribute("avions",avions);
				
				List<Pilote> pilotes=piloteService.selectAll();
				model.addAttribute("pilotes",pilotes);

				model.addAttribute("selectedValue",affectation.getVol().getNumVol());
				model.addAttribute("selectedValue2",affectation.getAvion().getNumAvion());
				model.addAttribute("selectedValue3",affectation.getPilote().getIdPilote());

				model.addAttribute("affectation",affectation);
				model.addAttribute("title",title);
			}
		}

		return "affectation/ajouterAffectation"; 
	}

	@RequestMapping(value ="/supprimer/{numVol}/{dateVol}/") 
	public String supprimerAffectation(Model model
			,@PathVariable String numVol,@PathVariable String dateVol) {
		if(numVol != null && dateVol!=null) {
			PK_KeyAffectation pk=new PK_KeyAffectation(numVol,dateVol);
			Affectation affectation = affectationService.getById(pk);
			if(affectation != null)
			{ 
				affectationService.remove(pk);
			}
		}

		return "redirect:/affectation/"; 
	}

}
