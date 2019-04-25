package br.usjt.proj_int.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.proj_int.model.bean.Audio;
import br.usjt.proj_int.model.bean.Categoria;
import br.usjt.proj_int.model.bean.Figura;
import br.usjt.proj_int.model.bean.Texto;
import br.usjt.proj_int.service.AudioService;
import br.usjt.proj_int.service.CategoriaService;
import br.usjt.proj_int.service.FiguraService;
import br.usjt.proj_int.service.MaterialService;
import br.usjt.proj_int.service.TextoService;
import br.usjt.proj_int.service.VideoService;

@Controller
@RequestMapping("upload")
public class UploadController {

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	TextoService textoService;

	@Autowired
	MaterialService materialService;

	@Autowired
	FiguraService figuraService;

	@Autowired
	AudioService audioService;

	@Autowired
	VideoService videoService;

	@GetMapping()
	public ModelAndView homeUpload() {

		ModelAndView mv = new ModelAndView("upload");

		mv.addObject("figuras", this.figuraService.listar());

		mv.addObject("textos", this.textoService.listar());

		mv.addObject("categorias", this.categoriaService.listar());
		

		return mv;
	}

	// /categoria
	@PostMapping("/categoria")
	public String adicionar(Categoria categoria) {

		if (categoria.getNome() != null && !categoria.getNome().isEmpty()) {

			this.categoriaService.salvar(categoria);
		}

		return "redirect:/categorias";
	}

	// /categoria/atualizar
	@PostMapping("/categoria/atualizar")
	public String atualizar(@RequestParam("id") Long id, @RequestParam("nome") String nome) {

		if (nome != null && !nome.isEmpty()) {

			Categoria categoria = this.categoriaService.get(id);

			categoria.setNome(nome);

			this.categoriaService.salvar(categoria);
		}

		return "redirect:/categorias";
	}

	// /texto
	@PostMapping("/texto")
	public String adicionar(Texto texto) {

		if (texto.getResumo() != null && !texto.getResumo().isEmpty()) {

			this.materialService.salvar(texto);
		}

		return "redirect:/uploads";
	}

}
