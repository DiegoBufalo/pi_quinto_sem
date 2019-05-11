package br.usjt.proj_int.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.proj_int.model.bean.Video;
import br.usjt.proj_int.service.MaterialService;
import br.usjt.proj_int.service.VideoService;

@Controller
@RequestMapping("videos")
public class VideoController {
	
	@Autowired
	VideoService videoService;
	
	@Autowired
	MaterialService materialService;
	
	@GetMapping
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("upload_video");

		mv.addObject("videos", this.videoService.listar());

		return mv;
	}
	
	@PostMapping()
	public String adicionar(Video video) {

		if (video.getNome() != null && !video.getNome().isEmpty()) {

			this.materialService.salvar(video);
		}
		
		return "redirect:/upload_video";
	}

}
