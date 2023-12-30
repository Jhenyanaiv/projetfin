package pi.ifrn.projetfin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pi.ifrn.projetfin.models.solic;
import pi.ifrn.projetfin.repositories.SolicRepository;

@Controller
public class SolicitacaoController {

	@Autowired
	private SolicRepository sr;
	
	@RequestMapping("/recycle/solicitacao")
	public String solic() {
		return "solic/formSolic";
	}
	
	@PostMapping("/recycle")
	public String adicionarsolic(solic solic) {
		
		System.out.println(solic);
		sr.save(solic);
		return "solic/test1"; 
	}
}
