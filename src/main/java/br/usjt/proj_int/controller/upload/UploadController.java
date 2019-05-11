package br.usjt.proj_int.controller.upload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.usjt.proj_int.model.bean.Figura;
import br.usjt.proj_int.service.FiguraService;

@Controller
@RequestMapping("uploads")
public class UploadController {
	
	@Autowired
	 FiguraService imagemService;
		
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Figura imagem) {

		if (file.isEmpty()) {
			
			return "redirect:/figuras";
		}

		try {

			String fileName = file.getOriginalFilename();
						
			String extension = "";

			int i = fileName.lastIndexOf('.');
			
			if (i >= 0) {
				
			    extension = fileName.substring(i+1);
			}
			
			String nome = UUID.randomUUID().toString() + "." + extension;			
			
			byte[] bytes = file.getBytes(); 					
								
			imagem.setNome(nome);
			
			if(bytes != null) {
				imagem.setImagem(bytes);
				imagemService.salvar(imagem);
			}			
			
			return "redirect:/materiais/adicionar/" + nome;

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/imagens";

		
	}


}
