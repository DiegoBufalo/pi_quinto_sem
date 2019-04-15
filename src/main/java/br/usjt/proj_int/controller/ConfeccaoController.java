package br.usjt.proj_int.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.usjt.proj_int.model.UserFileUpload;
import br.usjt.proj_int.repository.FileRepository;

@Controller
public class ConfeccaoController {

	@Autowired
	private FileRepository fileService;

	
}
