package br.usjt.proj_int.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.usjt.proj_int.model.beans.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, String> {

	List<Material> findByTipo(String tipo);

}
