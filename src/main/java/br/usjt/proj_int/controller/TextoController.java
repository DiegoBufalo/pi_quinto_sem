package br.usjt.proj_int.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.proj_int.model.bean.Texto;
import br.usjt.proj_int.service.MaterialService;
import br.usjt.proj_int.service.TextoService;

@Controller
@RequestMapping("textos")
public class TextoController {
	
	@Autowired
	TextoService textoService;
	
	@Autowired
	MaterialService materialService;
	
	@GetMapping
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("textos");

		mv.addObject("textos", this.textoService.listar());

		return mv;
	}
	
	@PostMapping()
	public String adicionar(Texto texto) {

		if (texto.getResumo() != null && !texto.getResumo().isEmpty()) {

			this.materialService.salvar(texto);
		}
		
		return "redirect:/textos";
	}

}
