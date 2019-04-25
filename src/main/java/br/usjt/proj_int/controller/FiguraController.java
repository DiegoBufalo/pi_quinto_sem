package br.usjt.proj_int.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.proj_int.model.bean.Figura;
import br.usjt.proj_int.service.FiguraService;
import br.usjt.proj_int.service.MaterialService;

@Controller
@RequestMapping("figuras")
public class FiguraController {
	
	@Autowired
	FiguraService figuraService;
	
	@Autowired
	MaterialService materialService;
	
	@GetMapping
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("figuras");

		mv.addObject("figuras", this.figuraService.listar());

		return mv;
	}
	
	@PostMapping()
	public String adicionar(Figura figura) {

		if (figura.getNome() != null && !figura.getNome().isEmpty()) {

			this.materialService.salvar(figura);
		}
		
		return "redirect:/figuras";
	}

}
