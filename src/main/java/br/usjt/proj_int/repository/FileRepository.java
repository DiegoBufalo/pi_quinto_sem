package br.usjt.proj_int.repository;

import br.usjt.proj_int.model.UserFileUpload;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<UserFileUpload, Long>{

}
