package pi.ifrn.projetfin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pi.ifrn.projetfin.models.solic;

@Controller
public class SolicitacaoController {

	@RequestMapping("/recycle/solic")
	public String solic() {
		return "formsolic";
	}
	
	@PostMapping("/recycle")
	public String adicionarsolic(solic solic) {
		
		System.out.println(solic);
		return "test1"; 
	}
}
