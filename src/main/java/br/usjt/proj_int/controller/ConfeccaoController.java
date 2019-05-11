package br.usjt.proj_int.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.proj_int.model.bean.Categoria;
import br.usjt.proj_int.model.bean.Figura;
import br.usjt.proj_int.model.bean.Tag;
import br.usjt.proj_int.model.bean.Texto;
import br.usjt.proj_int.model.bean.Video;
import br.usjt.proj_int.service.AudioService;
import br.usjt.proj_int.service.CategoriaService;
import br.usjt.proj_int.service.FiguraService;
import br.usjt.proj_int.service.MaterialService;
import br.usjt.proj_int.service.TextoService;
import br.usjt.proj_int.service.VideoService;

@Controller
@RequestMapping("confeccao")
public class ConfeccaoController {

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	TextoService textoService;

	@Autowired
	FiguraService figuraService;

	@Autowired
	AudioService audioService;

	@Autowired
	VideoService videoService;

	@Autowired
	MaterialService materialService;

	@GetMapping()
	public ModelAndView homeUpload() {

		ModelAndView mv = new ModelAndView("confeccao");

		mv.addObject("figuras", this.figuraService.listar());

		mv.addObject("textos", this.textoService.listar());

		mv.addObject("videos", this.videoService.listar());

		mv.addObject("categorias", this.audioService.listar());

		mv.addObject(new Categoria());

		mv.addObject(new Tag());

		return mv;
	}

	// /texto
	@PostMapping("/texto")
	public String adicionar(Texto texto) {

		if (texto.getResumo() != null && !texto.getResumo().isEmpty()) {

			this.materialService.salvar(texto);
		}

		return "redirect:/uploads";
	}

	// /Figura
	@PostMapping("/figura")
	public String adicionar(Figura figura) {

		if (figura.getNome() != null && !figura.getNome().isEmpty()) {

			this.materialService.salvar(figura);
		}

		return "redirect:/upload";
	}

	// /video
	@PostMapping("/video")
	public String adicionar(Video video) {

		if (video.getNome() != null && !video.getNome().isEmpty()) {

			this.materialService.salvar(video);
		}

		return "redirect:/confeccao";
	}
}
