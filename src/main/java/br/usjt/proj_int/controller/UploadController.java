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
public class UploadController {
	
	@Autowired
	private FileRepository fileService;
	
	@GetMapping(value = "/opcoes")
	public ModelAndView opcoes() {
		ModelAndView mv = new ModelAndView("opcoes");
		return mv;
	}
	
	@GetMapping(value="/upload")
	public ModelAndView homeConfeccao() {		
		ModelAndView mv = new ModelAndView("upload");	
		mv.addObject(new UserFileUpload());
		return mv;
	}
	
	@GetMapping(value = "/confeccao")
	public ModelAndView confeccao() {
		ModelAndView mv = new ModelAndView("confeccao");
		mv.addObject(new UserFileUpload());
		return mv;
	}

	@PostMapping("/uploadArquivo")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes, UserFileUpload fileUploaded) throws IOException {
		
		fileUploaded.setArquivoTexto(file.getBytes());        
               
        fileService.save(fileUploaded);
        
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }
	
	@PostMapping("/uploadConfec")
    public String handleConfecUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes, UserFileUpload fileUploaded) throws IOException {
		
		fileUploaded.setArquivoTexto(file.getBytes());        
               
        fileService.save(fileUploaded);
        
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }
	
	
	
}
