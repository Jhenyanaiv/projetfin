package pi.ifrn.projetfin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pi.ifrn.projetfin.models.solic;
import pi.ifrn.projetfin.repositories.SolicRepository;

@Controller
@RequestMapping("/recycle")
public class SolicitacaoController {

	@Autowired
	private SolicRepository sr;
	
	@RequestMapping("/solicitacao")
	public String solic() {
		return "solic/formSolic";
	}
	
	@PostMapping("/adicionar")
	public String adicionarSolic(solic solic) {
		try {
		System.out.println(solic);
		sr.save(solic);
		return "solic/test1"; 
	} catch (Exception e) {
        e.printStackTrace(); 
        return "errorPage";
	}}
	
	@GetMapping
	public ModelAndView listar() {
		
		List<solic> recycle = sr.findAll();
		ModelAndView mv = new ModelAndView("solic/listsol");
		mv.addObject("listsol", recycle);
		return mv;
		
	}
}
