package br.usjt.proj_int.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.proj_int.enums.TipoFeedback;
import br.usjt.proj_int.model.beans.Feedback;
import br.usjt.proj_int.model.beans.Usuario;
import br.usjt.proj_int.service.FeedbackService;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
	
	@Autowired private FeedbackService feedbackService;

	@PostMapping("/positivo")
	public String positivo(Feedback feedback) {
		feedback = feedbackService.getFeedbackByUsuarioAndConteudo(feedback);
		feedback.setFeedback(TipoFeedback.POSITIVO);
		feedbackService.save(feedback);
		return "timeline";
	}
	
	@PostMapping("/negativo")
	public String negativo(Feedback feedback) {
		feedback = feedbackService.getFeedbackByUsuarioAndConteudo(feedback);
		feedback.setFeedback(TipoFeedback.NEGATIVO);
		feedbackService.save(feedback);
		return "timeline";
	}

	@GetMapping("/positivo/usuario")
	public List<String> listaPositivosUsuario(Usuario usuario){
		return getIdByUsuarioAndFeedback(usuario, TipoFeedback.POSITIVO);
	}
	
	@GetMapping("/negativo/usuario")
	public List<String> listaNegativosUsuario(Usuario usuario){
		return getIdByUsuarioAndFeedback(usuario, TipoFeedback.NEGATIVO);
	}

	private List<String> getIdByUsuarioAndFeedback(Usuario usuario, TipoFeedback tipo) {
		List<String> ids = new ArrayList<>();
		for (Feedback feedback : feedbackService.findByUsuarioAndFeedback(usuario, tipo)) {
			ids.add(feedback.getConteudo().getId());
		};
		return ids;
	}
	
}
