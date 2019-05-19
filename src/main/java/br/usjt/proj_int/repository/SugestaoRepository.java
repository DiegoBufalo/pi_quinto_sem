package br.usjt.proj_int.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.usjt.proj_int.model.beans.Sugestao;

@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, String> {

	List<Sugestao> findByFeedbackIsNull();

}
