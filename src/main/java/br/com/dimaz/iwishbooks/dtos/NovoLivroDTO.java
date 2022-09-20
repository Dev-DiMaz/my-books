package br.com.dimaz.iwishbooks.dtos;

import javax.validation.constraints.NotBlank;

import br.com.dimaz.iwishbooks.models.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NovoLivroDTO {
	
	@NotBlank
	private String nomeLivro;
	@NotBlank
	private String numPaginas;
	@NotBlank
	private String editora;
	@NotBlank
	private String autor;
	
	private String isbn;
	private String anoPublicacao;
	private String acabamento;
	private String classificacao;
	private String saga;
	
	private String imagemCapa;

	public Livro toLivro() {
		Livro livro = new Livro();
		livro.setNomeLivro(nomeLivro);
		livro.setIsbn(isbn);
		livro.setAnoPublicacao(anoPublicacao);
		livro.setEditora(editora);
		livro.setAcabamento(acabamento);
		livro.setAutor(autor);
		livro.setClassificacao(classificacao);
		livro.setSaga(saga);
		livro.setImagemCapa(imagemCapa);

		try {livro.setNumPaginas(Integer.valueOf(numPaginas));} 
		catch (Exception e) {livro.setNumPaginas(0);}
		
		livro.setLinkAmazon(makeLinkAmazon(nomeLivro));
		livro.setLinkSub(makeLinkSub(nomeLivro));
		livro.setLinkAmericanas(makeLinkAmericanas(nomeLivro));
		livro.setLinkMagalu(makeLinkMagalu(nomeLivro));
		
		return livro;
	}


	private String makeLinkAmazon(String nome) {
		return String.format("https://www.amazon.com.br/s?k=%s", nome.replace(" ", "+"));
	}
	private String makeLinkSub(String nome) {
		return String.format("https://www.submarino.com.br/busca/%s", nome.replace(" ", "-").toLowerCase());
	}
	
	private String makeLinkAmericanas(String nome) {
		return String.format("https://www.americanas.com.br/busca/%s", nome.replace(" ", "-").toLowerCase());
	}
	private String makeLinkMagalu(String nome) {
		return String.format("https://www.magazinevoce.com.br/magazineferiadofertas/busca/%s", nome.replace(" ", "+").toLowerCase());
	}
	
}
