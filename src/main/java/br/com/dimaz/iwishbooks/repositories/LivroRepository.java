package br.com.dimaz.iwishbooks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dimaz.iwishbooks.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
	
}
