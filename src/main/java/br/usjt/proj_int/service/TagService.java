package br.usjt.proj_int.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.proj_int.model.bean.Material;
import br.usjt.proj_int.model.bean.Tag;
import br.usjt.proj_int.repository.TagRepository;

@Service
public class TagService {
	private final TagRepository repository;
	
	@Autowired
	public TagService(TagRepository tagRepository) {
		this.repository = tagRepository;
	}
	
	public List<Tag> listar(){
		return (ArrayList<Tag>) repository.findAll();
	}
	
	public void salvar(Tag tag) {

		tag.setDataRegistro((LocalDateTime.now()));		
		repository.save(tag);
	}
}
