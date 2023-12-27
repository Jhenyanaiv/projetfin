package pi.ifrn.projetfin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SolicitacaoController {

	@RequestMapping("/recycle/solic")
	public String solic() {
		return "formsolic";
	}
	
	@PostMapping("/recycle")
	public String adicionarsolic(Solic solic) {
		
		System.out.println("o nome:" + nome);
		return "test1"; 
	}
}
