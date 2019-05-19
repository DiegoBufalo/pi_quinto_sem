package br.usjt.proj_int.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.usjt.proj_int.model.beans.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {

	Tag findByNome(String nome);

}
