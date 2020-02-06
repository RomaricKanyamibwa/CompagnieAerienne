package companie.aerienne.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/home",method = RequestMethod.GET)
public class HomeController {
	@RequestMapping(value="")
	public String home() {
		return "home/home";
	}
	
	@RequestMapping(value="/blank",method = RequestMethod.GET)
	public String blankHome() {
		return "blank/blank";
	}

}
