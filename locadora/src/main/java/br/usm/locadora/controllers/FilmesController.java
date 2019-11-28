package br.usm.locadora.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.usm.locadora.model.Filmes;
import br.usm.locadora.model.Clientes;
import br.usm.locadora.repository.ClientesRepository;
import br.usm.locadora.repository.FilmesRepository;

@Controller
public class FilmesController {
	
	@Autowired
	private FilmesRepository fr;
	
	@Autowired
	private ClientesRepository cr;

	@RequestMapping(value = "/cadastrarFilme", method = RequestMethod.GET)
	public String form() {
		return "filmes/formFilmes";
	}

	@RequestMapping(value = "/cadastrarFilme", method = RequestMethod.POST)
	public String form(Filmes filme) {
		fr.save(filme);
		return "redirect:/cadastrarFilme";
	}
	
	@RequestMapping("/filmes")
	public ModelAndView listaFilmes() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Filmes> filmes = fr.findAll();
		mv.addObject("filmes", filmes);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesFilmes(@PathVariable("codigo") long codigo) {
		Filmes filmes = fr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("filmes/detalhesFilme");	
		mv.addObject("filmes", filmes);
		
		Iterable<Clientes> clientes = cr.findByFilmes(filmes);
		mv.addObject("Clientes", clientes);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesFilmesPost(@PathVariable("codigo") long codigo, Clientes clientes) {
		Filmes filmes = fr.findByCodigo(codigo);
		clientes.setFilmes(filmes);
		cr.save(clientes);	
		return "redirect:/{codigo}";
		
	}

}
