package br.usjt.proj_int.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	@Autowired
	private FileRepository fileService;
	
	@GetMapping(value="/upload")
	public ModelAndView homeConfeccao() {
		ModelAndView mv = new ModelAndView("upload");	
		mv.addObject(new FileUpload());
		return mv;
	}
}
