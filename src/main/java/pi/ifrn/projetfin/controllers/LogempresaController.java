package pi.ifrn.projetfin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogempresaController {
	
	@RequestMapping("/recycle/logempresa")
	public String Logempresa() {
		return "logempresa";
	}
}
