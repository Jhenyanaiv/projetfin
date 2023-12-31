package pi.ifrn.projetfin.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pi.ifrn.projetfin.models.logempresa;
import pi.ifrn.projetfin.repositories.EmpreRepository;

@Controller
public class LogempresaController {
	
	private EmpreRepository er;
	
	@RequestMapping("/recycle/cadastroe")
	public String loginempresa() {
		return "cadasempre/logempresa";
	}
	
	@PostMapping("/cadastroe")
	public String adicionarempre(logempresa logempresa) {
		
		System.out.println(logempresa);
		er.save(logempresa);
		return "cadasempre/test2";			
}

}
