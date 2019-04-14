package br.usjt.proj_int.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.proj_int.model.Usuario;
import br.usjt.proj_int.repository.UsuarioRepository;

@Service
public class LoginService {
	@Autowired
	UsuarioRepository usuarioRepo;

	public boolean logar(Usuario usuario) {
		return usuarioRepo.findOneByLoginAndSenha(usuario.getLogin(), usuario.getSenha()) != null;
	}
}
