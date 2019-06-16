package br.usjt.proj_int.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.proj_int.enums.TipoAcesso;
import br.usjt.proj_int.model.beans.Conteudo;
import br.usjt.proj_int.model.beans.Usuario;
import br.usjt.proj_int.service.ConteudoService;
import br.usjt.proj_int.service.MaterialService;
import br.usjt.proj_int.service.UsuarioService;

@Controller
@RequestMapping("/conteudos")
public class ConteudoController {

	@Autowired
	ConteudoService conteudoService;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	MaterialService materialService;

	@GetMapping("/confeccao")
	@Secured("ROLE_ESTAGIARIO")
	public ModelAndView confeccao() {
		ModelAndView mav = new ModelAndView("confeccao");
		mav.addObject("imagens", materialService.findByTipo("image"));
		mav.addObject("videos", materialService.findByTipo("video"));
		mav.addObject("audios", materialService.findByTipo("audio"));
		mav.addObject("textos", materialService.findByTipo("text"));
		mav.addObject("tipos", TipoAcesso.values());
		return mav;
	}

	@PostMapping("/confeccao")
	@Secured("ROLE_ESTAGIARIO")
	public String confeccao(Conteudo conteudo) {

		System.out.println(Calendar.getInstance());

		conteudoService.save(conteudo.setData(Calendar.getInstance()));

		return "redirect:/conteudos/confeccao";
	}

	@GetMapping("/timeline")
	public ModelAndView home(@Nullable Principal principal) {
		final int numeroConteudos = 15;

		ModelAndView mav = new ModelAndView("timeline");
					
		List<Conteudo> conteudos;

		if (principal != null) {
			mav.addObject("usuario", usuarioService.findByUsuario(new Usuario().setUsuario(principal.getName())));
			conteudos = conteudoService.findAll();
		} else {
			conteudos = conteudoService.findByTipo(TipoAcesso.PUBLICO);
		}

		mav.addObject("maisLidas",
				conteudoService.maisLidas(new ArrayList<Conteudo>(conteudos)).subList(0, numeroConteudos));
		mav.addObject("maisRecentes",
				conteudoService.maisRecentes(new ArrayList<Conteudo>(conteudos)).subList(0, numeroConteudos));
		System.out.println(mav.getModel().containsKey("maisVisualizadas"));

		return mav;
	}

	@GetMapping("/timeline/categoria")
	public ModelAndView buscaCategoria(@Nullable Principal principal,
			@RequestParam(value = "categoria", required = true) String categoria) {
		int numeroConteudos = 15;

		ModelAndView mav = new ModelAndView("timeline");

		List<Conteudo> conteudos;
		List<Conteudo> conteudosPorDescricao = new ArrayList<Conteudo>();

		if (principal != null) {
			mav.addObject("usuario", usuarioService.findByUsuario(new Usuario().setUsuario(principal.getName())));
			conteudos = conteudoService.findAll();
		} else {
			conteudos = conteudoService.findByTipo(TipoAcesso.PUBLICO);
			conteudos.forEach(n -> {
				n.getCategorias().forEach(m -> {
					if (m.getNome().contains(categoria)) {
						conteudosPorDescricao.add(n);
					}
					;
				});
			});
		}
		
		numeroConteudos = conteudosPorDescricao.size() > numeroConteudos ? numeroConteudos
				: conteudosPorDescricao.size();
		
		mav.addObject("filtroCategoria", categoria);
		mav.addObject("maisLidas",
				conteudoService.maisLidas(new ArrayList<Conteudo>(conteudosPorDescricao)).subList(0, numeroConteudos));
		mav.addObject("maisRecentes", conteudoService.maisRecentes(new ArrayList<Conteudo>(conteudosPorDescricao))
				.subList(0, numeroConteudos));
		System.out.println(mav.getModel().containsKey("maisVisualizadas"));

		return mav;
	}

	@GetMapping("/timeline/descricao")
	public List<Conteudo> buscaDescricao(@Nullable Principal principal,
			@RequestParam(value = "descricao", required = true) String descricao) {
		int numeroConteudos = 15;

		ModelAndView mav = new ModelAndView("timeline");

		List<Conteudo> conteudos;
		List<Conteudo> conteudosPorDescricao = new ArrayList<Conteudo>();

		if (principal != null) {
			mav.addObject("usuario", usuarioService.findByUsuario(new Usuario().setUsuario(principal.getName())));
			conteudos = conteudoService.findAll();
		} else {
			conteudos = conteudoService.findByTipo(TipoAcesso.PUBLICO);
			conteudos.forEach(n -> {
				if (n.getDescricao().contains(descricao)) {
					conteudosPorDescricao.add(n);
				}
			});
		}

		numeroConteudos = conteudosPorDescricao.size() > numeroConteudos ? numeroConteudos
				: conteudosPorDescricao.size();

		mav.addObject("filtroDescricao", descricao);

		mav.addObject("maisLidas",
				conteudoService.maisLidas(new ArrayList<Conteudo>(conteudosPorDescricao)).subList(0, numeroConteudos));
		mav.addObject("maisRecentes", conteudoService.maisRecentes(new ArrayList<Conteudo>(conteudosPorDescricao))
				.subList(0, numeroConteudos));
		System.out.println(mav.getModel().containsKey("maisVisualizadas"));

		return conteudosPorDescricao;
	}

	@PostMapping("/timeline/descricao")
	public ModelAndView searchByDescricao(@Nullable Principal principal,
			@RequestParam(value = "descricao", required = true) String descricao) {
		int numeroConteudos = 15;

		ModelAndView mav = new ModelAndView("timeline");

		List<Conteudo> conteudos;
		List<Conteudo> conteudosPorDescricao = new ArrayList<Conteudo>();

		if (principal != null) {
			mav.addObject("usuario", usuarioService.findByUsuario(new Usuario().setUsuario(principal.getName())));
			conteudos = conteudoService.findAll();
		} else {
			conteudos = conteudoService.findByTipo(TipoAcesso.PUBLICO);
			conteudos.forEach(n -> {
				if (n.getDescricao().contains(descricao)) {
					conteudosPorDescricao.add(n);
				}
			});
		}

		numeroConteudos = conteudosPorDescricao.size() > numeroConteudos ? numeroConteudos
				: conteudosPorDescricao.size();

		mav.addObject("filtroDescricao", descricao);

		mav.addObject("maisLidas",
				conteudoService.maisLidas(new ArrayList<Conteudo>(conteudosPorDescricao)).subList(0, numeroConteudos));
		mav.addObject("maisRecentes", conteudoService.maisRecentes(new ArrayList<Conteudo>(conteudosPorDescricao))
				.subList(0, numeroConteudos));
		System.out.println(mav.getModel().containsKey("maisVisualizadas"));

		return mav;
	}

	@GetMapping("/live")
	public ModelAndView live() {
		ModelAndView mav = new ModelAndView();

		return mav;
	}
}
