package br.usjt.proj_int.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("timeline")
public class TimeLineController {
	
	@GetMapping()
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("timeline");
		return mv;		
	}
}
