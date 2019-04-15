package br.usjt.proj_int.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import br.usjt.proj_int.model.UserFileUpload;

public interface FileRepository extends JpaRepository<UserFileUpload, Long>{
	
}
