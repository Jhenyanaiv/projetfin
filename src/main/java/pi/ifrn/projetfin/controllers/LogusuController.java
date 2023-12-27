package pi.ifrn.projetfin.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogusuController {

	@RequestMapping("/recycle/logusu")
	public String Logusu() {
		return "logusua";
	}
	
	
}
