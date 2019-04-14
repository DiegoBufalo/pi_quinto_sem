package br.usjt.proj_int.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.proj_int.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findOneByLoginAndSenha(String login, String senha);
}