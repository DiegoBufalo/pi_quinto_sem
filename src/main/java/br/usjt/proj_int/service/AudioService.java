package br.usjt.proj_int.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.proj_int.model.bean.Audio;
import br.usjt.proj_int.repository.AudioRepository;

@Service
public class AudioService {
	
	private final AudioRepository repository;

	@Autowired
	public AudioService(AudioRepository audioRepository) {
		
		this.repository = audioRepository;
	}
	
	public List<Audio> listar() {

		return (ArrayList<Audio>) repository.findAll();

	}

}
