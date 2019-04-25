package br.usjt.proj_int.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.proj_int.model.bean.Video;
import br.usjt.proj_int.repository.VideoRepository;

@Service
public class VideoService {

	private final VideoRepository repository;

	@Autowired
	public VideoService(VideoRepository videoRepository) {
		
		this.repository = videoRepository;
	}
	
	public List<Video> listar() {

		return (ArrayList<Video>) repository.findAll();

	}

}
