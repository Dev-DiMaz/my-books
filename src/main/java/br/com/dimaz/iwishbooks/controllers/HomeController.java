package br.com.dimaz.iwishbooks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.dimaz.iwishbooks.models.Livro;
import br.com.dimaz.iwishbooks.repositories.LivroRepository;

@Controller
public class HomeController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping("home")
	public String home(Model model) {
		
		List<Livro> livros = livroRepository.findAll();
		model.addAttribute("livros", livros);
		return "home";
	}
}
