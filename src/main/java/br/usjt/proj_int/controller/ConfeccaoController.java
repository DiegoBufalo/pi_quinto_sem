package br.usjt.proj_int.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.proj_int.model.Usuario;
import br.usjt.proj_int.repository.FileRepository;

@Controller
public class ConfeccaoController {
	
	@Autowired
	private FileRepository fileService;
	
	@GetMapping(value="/opcoes")
	public ModelAndView opcoes() {
		ModelAndView mv = new ModelAndView("opcoes");		
		return mv;
	}
	
	@GetMapping(value="/confeccao")
	public ModelAndView confeccao() {
		ModelAndView mv = new ModelAndView("confeccao");		
		return mv;
	}
	
}
