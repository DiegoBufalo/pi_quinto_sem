package br.usjt.proj_int.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.proj_int.model.bean.Audio;
import br.usjt.proj_int.service.AudioService;
import br.usjt.proj_int.service.MaterialService;

@Controller
@RequestMapping("audios")
public class AudioController {
	
	@Autowired
	AudioService audioService;
	
	@Autowired
	MaterialService materialService;
	
	@GetMapping
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("upload_audio");

		mv.addObject("audios", this.audioService.listar());

		return mv;
	}
	
	@PostMapping()
	public String adicionar(Audio audio) {

		if (audio.getNome() != null && !audio.getNome().isEmpty()) {

			this.materialService.salvar(audio);
		}
		
		return "redirect:/audios";
	}

}
