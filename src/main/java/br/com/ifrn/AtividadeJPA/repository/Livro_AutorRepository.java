package br.com.ifrn.AtividadeJPA.repository;

import br.com.ifrn.AtividadeJPA.model.Livro_Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Livro_AutorRepository extends JpaRepository<Livro_Autor, Integer> {
}
