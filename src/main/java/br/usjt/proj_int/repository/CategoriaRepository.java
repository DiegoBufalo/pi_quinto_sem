package br.usjt.proj_int.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.usjt.proj_int.model.beans.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String> {

	Categoria findByNome(String nome);

}
