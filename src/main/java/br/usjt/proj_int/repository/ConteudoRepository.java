package br.usjt.proj_int.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.usjt.proj_int.enums.TipoAcesso;
import br.usjt.proj_int.model.beans.Conteudo;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, String> {

	List<Conteudo> findByTipo(TipoAcesso tipo);
//	List<Conteudo> findByTipoOrderByVisualizacoesDesc(TipoAcesso tipo);	
//	List<Conteudo> findOrderByVisualizacoesDesc();	

}
