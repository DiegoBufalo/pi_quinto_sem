package br.usjt.proj_int.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.proj_int.enums.TipoFeedback;
import br.usjt.proj_int.model.beans.Feedback;
import br.usjt.proj_int.model.beans.Usuario;
import br.usjt.proj_int.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired private FeedbackRepository feedbackRepository;
	
	public void save(Feedback feedback) {
		feedbackRepository.save(feedback);
	}
	
	public Feedback getFeedbackByUsuarioAndConteudo(Feedback feedback) {
		return Optional.ofNullable(
				feedbackRepository.findByUsuarioAndConteudo(
						feedback.getUsuario(), feedback.getConteudo()
						)
				).orElse(feedback);
	}

	public List<Feedback> findByUsuarioAndFeedback(Usuario usuario, TipoFeedback feedback) {
		return feedbackRepository.findByUsuarioAndFeedback(usuario, feedback);
	}
}
