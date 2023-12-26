package pi.ifrn.projetfin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SolicitacaoController {

	@RequestMapping("/recycle/solic")
	public String solic() {
		return "formsolic";
	}
}
