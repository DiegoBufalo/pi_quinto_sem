package br.usjt.proj_int.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.proj_int.model.beans.Sugestao;
import br.usjt.proj_int.repository.SugestaoRepository;

@Service
public class SugestaoService {

	@Autowired private SugestaoRepository sugestaoRepository;
	
	public Sugestao save(Sugestao sugestao) {
		return sugestaoRepository.save(sugestao);
	}

	public List<Sugestao> findByFeedbackIsNull() {
		return sugestaoRepository.findByFeedbackIsNull();
	}

	public Sugestao findById(String id) {
		return sugestaoRepository.findById(id).get();
	}
}
