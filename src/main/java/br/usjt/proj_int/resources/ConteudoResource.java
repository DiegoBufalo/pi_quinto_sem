package br.usjt.proj_int.resources;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.proj_int.enums.TipoAcesso;
import br.usjt.proj_int.model.beans.Conteudo;
import br.usjt.proj_int.model.beans.Usuario;
import br.usjt.proj_int.service.ConteudoService;
import br.usjt.proj_int.service.MaterialService;
import br.usjt.proj_int.service.UsuarioService;

@RestController
@RequestMapping("")
public class ConteudoResource {
	
	@Autowired
	ConteudoService conteudoService;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	MaterialService materialService;
	
	@GetMapping("/searchByDescricao")
	public List<Conteudo> searchByDescricao(@Nullable Principal principal,
			@RequestParam(value = "descricao", required = true) String descricao) {
				

		List<Conteudo> conteudos;
		List<Conteudo> conteudosPorDescricao = new ArrayList<Conteudo>();

		if (principal != null) {									
			conteudos = conteudoService.findAll();
			conteudos.forEach(n -> {
				if (n.getDescricao().contains(descricao)) {
					conteudosPorDescricao.add(n);
				}
			});
		} else {
			conteudos = conteudoService.findByTipo(TipoAcesso.PUBLICO);
			conteudos.forEach(n -> {
				if (n.getDescricao().contains(descricao)) {
					conteudosPorDescricao.add(n);
				}
			});
		}

		return conteudosPorDescricao;
	}
	
	@GetMapping("/searchByCategoria")
	public List<Conteudo> searchByCategoria(@Nullable Principal principal,
			@RequestParam(value = "descricao", required = true) String descricao) {
				
		List<Conteudo> conteudos;
		List<Conteudo> conteudosPorDescricao = new ArrayList<Conteudo>();

		if (principal != null) {									
			conteudos = conteudoService.findAll();
			conteudos.forEach(n -> {
				n.getTags().forEach( c -> {
					if (c.getNome().contains(descricao)) {
						conteudosPorDescricao.add(n);
					}					
				});
			});
		} else {
			conteudos = conteudoService.findByTipo(TipoAcesso.PUBLICO);
			conteudos.forEach(n -> {
				n.getTags().forEach( c -> {
					if (c.getNome().contains(descricao)) {
						conteudosPorDescricao.add(n);
					}					
				});
			});
		}

		return conteudosPorDescricao;
	}

}
