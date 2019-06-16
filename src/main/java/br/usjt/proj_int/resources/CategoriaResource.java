package br.usjt.proj_int.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.proj_int.model.beans.Categoria;
import br.usjt.proj_int.service.CategoriaService;

@RestController
public class CategoriaResource {
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping("/allCategorias")
	public List<Categoria> getCategorias(){
		
		List<Categoria> categorias = new ArrayList<Categoria>();	
		categorias = categoriaService.findAll();		
		return categorias;		
	}
	
}
