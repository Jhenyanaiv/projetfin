package pi.ifrn.projetfin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pi.ifrn.projetfin.models.logusu;
import pi.ifrn.projetfin.repositories.UsuarioRepository;

@Controller
public class LogusuController {

	private UsuarioRepository ur;
	
	@RequestMapping("/recycle/logusu")
	public String logusu() {
		return "logusua";
	}
	
	@PostMapping("/logusu")
	public String adicionarusu(logusu logusu) {
		
		System.out.println(logusu);
		ur.save(logusu);
		return "cadastrousu/test3";
	}
}
