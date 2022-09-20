package br.com.dimaz.iwishbooks.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeLivro;
	private String isbn;
	private String anoPublicacao;
	private Integer numPaginas;
	private String editora;
	private String acabamento;
	private String autor;
	private String classificacao;
	private String saga;
	
	private String linkAmazon;
	private String linkSub;
	private String linkAmericanas;
	private String linkMagalu;
	private String imagemCapa;
	
}
