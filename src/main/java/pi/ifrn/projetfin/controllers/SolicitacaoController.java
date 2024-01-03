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
	
	@GetMapping("/recycle")
	public String home() {
		return "home";
	}
	
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
	
	@GetMapping ("/solic/listsol/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView md = new ModelAndView();
		Optional<solic> opt = sr.findById(id);
		if(opt.isEmpty()) {
			md.setViewName("redirect:/solic/listsol");
		}
		
		md.setViewName("solic/detalhes");
		solic solic = opt.get();
		
		md.addObject("solic", solic);
		return md;
		
	}
	 
	 @PostMapping("/solic/listsol/{id}")
	 public ModelAndView responderSolic(@PathVariable Long id) {
	     ModelAndView modelAndView = new ModelAndView();
	     Optional<solic> optionalSolic = sr.findById(id);
	     
	     if (optionalSolic.isPresent()) {
	         solic solic = optionalSolic.get();

	         solic.setRespondida(true);
	         sr.save(solic);
	         
	         // Redirecione de volta para a lista de solicitações após responder
	         modelAndView.setViewName("redirect:/solic/listsol");
	     } else {
	         // Se a solicitação não for encontrada, redirecione de volta para a lista de solicitações
	         modelAndView.setViewName("redirect:/solic/listsol");
	     }
	     
	     return modelAndView;
	 }
	 
	//Empresa
	 @Autowired
	private EmpreRepository er;
	
	@GetMapping("/cadasempre/logempresa") 
	public String logempresa() {
		
		System.out.println();
		return "cadasempre/logempresa";
	}
	
	@PostMapping("/cadasempre/logempresa")
	public String adicionarEmpre(logempresa logempresa) {
		
		System.out.println();
		er.save(logempresa);
		return"cadasempre/login-enviado";
	}
	
	@GetMapping("/cadasempre/listEmpre")
	public ModelAndView listarEmpre() {
		
		List<logempresa> logempresas = er.findAll();
		ModelAndView mv = new ModelAndView("cadasempre/listEmpre");
		mv.addObject("listEmpre", logempresas);
		return mv;
	}
	
	@GetMapping ("/cadasempre/listEmpre/{id}")
	public ModelAndView detalharEmpre(@PathVariable Long id) {
		ModelAndView md = new ModelAndView();
		Optional<logempresa> opt = er.findById(id);
		if(opt.isEmpty()) {
			md.setViewName("redirect:/cadasempre/listEmpre");
		}
		
		md.setViewName("cadasempre/detalhesEmpre");
		logempresa logempresa = opt.get();
		
		md.addObject("cadasempre", logempresa);
		return md;
		
	}
	
	//Usuario
	@Autowired
	private UsuarioRepository ur;
	
	@GetMapping("/cadastrousu/logusua")
	public String logusu() {
		
		System.out.println();
		return "cadastrousu/logusua";
	}
	
	@PostMapping("/cadastrousu/logusua")
	public String adicionarUsu(logusu logusu) {
		
		System.out.println();
		ur.save(logusu);
		return "cadastrousu/login-efetuado";
	}
}
