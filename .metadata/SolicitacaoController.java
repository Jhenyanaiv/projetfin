package pi.ifrn.projetfin.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import pi.ifrn.projetfin.models.logempresa;
import pi.ifrn.projetfin.models.logusu;
import pi.ifrn.projetfin.models.solic;
import pi.ifrn.projetfin.repositories.EmpreRepository;
import pi.ifrn.projetfin.repositories.SolicRepository;
import pi.ifrn.projetfin.repositories.UsuarioRepository;

@Controller
public class SolicitacaoController {

	//Solicitacao
	@Autowired
	private SolicRepository sr;
	
	@GetMapping("/solic/formSolic")
	public String solic() {
		return "solic/formSolic";
	}
	
	@PostMapping("/solic/formSolic")
	public String adicionarSolic(solic solic) {

		System.out.println(solic);
		sr.save(solic);
		return "solic/solic-enviada"; 
	}
	
	@GetMapping("/solic/listsol")
	public ModelAndView listar() {
		
		List<solic> recycle = sr.findAll();
		ModelAndView mv = new ModelAndView("solic/listsol");
		mv.addObject("listsol", recycle);
		return mv;
		
	}
	//Empresa
	private EmpreRepository er;
	
	@GetMapping("/cadasempre/logempresa") 
	public String logempre() {
		
		System.out.println();
		return "cadasempre/logempresa";
	}
	
	@PostMapping("/cadasempre/logempresa")
	public String adicionarEmpre(logempresa logempresa) {
		
		System.out.println();
		er.save(logempresa);
		return"cadasempre/login-enviado";
	}
	//Usuario
	private UsuarioRepository ur;
	
	@GetMapping("/cadastrousu/logusu")
	public String logusu() {
		
		System.out.println();
		return "cadastrousu/logusu";
	}
	
	@PostMapping("/cadastrousu/logusu")
	public String adicionarUsu(logusu logusu) {
		
		System.out.println();
		ur.save(logusu);
		return "cadastrousu/login-efetuado";
	}
	
	@GetMapping ("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView md = new ModelAndView();
		Optional<logempresa> opt = er.findById(id);
		
		if(opt.isEmpty()) {
			md.setViewName("redrect:/solic/listsol");
			return md;
		}
			 md.setViewName( "/solic/listsol/detalhes");
			logempresa logempresa = opt.get();
			
			md.addObject("/solic/listsol", logempresa);
			
			return md;  
	}
}
