package pi.ifrn.projetfin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String Index() {
		System.out.println("chamou o metodo index");
		return "redirect:/recycle";
	}
	
}
