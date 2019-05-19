package br.usjt.proj_int.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.usjt.proj_int.enums.TipoFeedback;
import br.usjt.proj_int.model.beans.Conteudo;
import br.usjt.proj_int.model.beans.Feedback;
import br.usjt.proj_int.model.beans.Usuario;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, String> {

	Feedback findByUsuarioAndConteudo(Usuario usuario, Conteudo conteudo);

	List<Feedback> findByUsuarioAndFeedback(Usuario usuario, TipoFeedback feedback);

}
