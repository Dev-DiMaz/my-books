package br.com.dimaz.iwishbooks.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dimaz.iwishbooks.dtos.NovoLivroDTO;
import br.com.dimaz.iwishbooks.models.Livro;
import br.com.dimaz.iwishbooks.repositories.LivroRepository;

@Controller
@RequestMapping("livro")
public class LivroController {
	
	@Autowired
	private LivroRepository repository;
	
	@GetMapping("formulario")
	public String formulario(NovoLivroDTO livroDto) {
		return "livro/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid NovoLivroDTO livroDto, BindingResult result) {
		if(result.hasErrors()) 	{
			return "livro/formulario";
		}
		
		Livro livro = livroDto.toLivro();
		repository.save(livro);
		return "livro/formulario";
	} 
}
