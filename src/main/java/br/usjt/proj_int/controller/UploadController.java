package br.usjt.proj_int.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.proj_int.model.UserFileUpload;
import br.usjt.proj_int.repository.FileRepository;

@Controller
public class UploadController {
	
	@Autowired
	private FileRepository fileService;
	
	@GetMapping(value="/upload")
	public ModelAndView homeConfeccao() {		
		ModelAndView mv = new ModelAndView("upload");	
		mv.addObject(new UserFileUpload());
		return mv;
	}
	
	
	
}
