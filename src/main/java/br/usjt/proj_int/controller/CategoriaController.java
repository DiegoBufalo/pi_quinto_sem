package br.usjt.proj_int.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.proj_int.model.bean.Categoria;
import br.usjt.proj_int.service.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@GetMapping
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("categorias");

		mv.addObject("categorias", this.categoriaService.listar());

		mv.addObject(new Categoria());

		return mv;
	}

	@PostMapping
	public String adicionar(Categoria categoria) {

		if (categoria.getNome() != null && !categoria.getNome().isEmpty()) {

			this.categoriaService.salvar(categoria);
		}
		
		return "redirect:/categorias";
	}

	@PostMapping("/atualizar")
	public String atualizar(@RequestParam("id") Long id, @RequestParam("nome") String nome) {
		
		if (nome != null && !nome.isEmpty()) {

			Categoria categoria = this.categoriaService.get(id);

			categoria.setNome(nome);

			this.categoriaService.salvar(categoria);
		}

		return "redirect:/categorias";
	}
	
	
	
	

//	@GetMapping(path = "editar/{id}")
//	public String atualizar(@PathVariable("id") int id) {
//
//		System.out.println("----->> " + id);
//
//		return "redirect:/categorias";
//	}
//

}
