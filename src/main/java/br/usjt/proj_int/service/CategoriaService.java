package br.usjt.proj_int.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.proj_int.model.bean.Categoria;
import br.usjt.proj_int.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	private final CategoriaRepository repository;
	
	@Autowired
	public CategoriaService(CategoriaRepository categoriaRepository) {
		
		this.repository = categoriaRepository;
	}
	
	public List<Categoria> listar(){
		
		return (ArrayList<Categoria>) repository.findAll();
				
	}
	
	public void salvar(Categoria categoria) {
						
		categoria.setDataRegistro(LocalDateTime.now());
		
		repository.save(categoria);
	}
	
	public Categoria get(Long id) {
		
		return repository.findById(id).get();
	}
	


}
