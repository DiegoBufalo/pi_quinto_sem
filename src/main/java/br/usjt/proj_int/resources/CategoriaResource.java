package br.usjt.proj_int.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.proj_int.model.beans.Tag;
import br.usjt.proj_int.service.TagService;

@RestController
public class CategoriaResource {
	
	@Autowired
	TagService categoriaService;
	
	@GetMapping("/allCategorias")
	public List<Tag> getCategorias(){		
		List<Tag> categorias = new ArrayList<Tag>();	
		categorias = categoriaService.findAll();		
		return categorias;		
	}
	
}
