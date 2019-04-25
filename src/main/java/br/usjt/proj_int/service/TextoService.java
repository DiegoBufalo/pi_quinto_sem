package br.usjt.proj_int.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.proj_int.model.bean.Texto;
import br.usjt.proj_int.repository.TextoRepository;

@Service
public class TextoService {
	
	private final TextoRepository repository;
	
	@Autowired
	public TextoService(TextoRepository textoRepository) {
		
		this.repository = textoRepository;
	}
	
	public List<Texto> listar() {

		return (ArrayList<Texto>) repository.findAll();

	}

}
