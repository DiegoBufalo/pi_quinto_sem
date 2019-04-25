package br.usjt.proj_int.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.proj_int.model.bean.Figura;
import br.usjt.proj_int.repository.FiguraRepository;

@Service
public class FiguraService {
	
private final FiguraRepository repository;
	
	@Autowired
	public FiguraService(FiguraRepository figuraRepository) {
		
		this.repository = figuraRepository;
	}
	
	public List<Figura> listar() {

		return (ArrayList<Figura>) repository.findAll();

	}

}
