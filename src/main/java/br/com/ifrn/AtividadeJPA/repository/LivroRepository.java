package br.com.ifrn.AtividadeJPA.repository;

import br.com.ifrn.AtividadeJPA.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
    List<Livro> findByQuantidadeDisponivelGreaterThanOrderByTituloAsc(int quantidade);
    List<Livro> findByCategoriaNome(String nomeCategoria);
}
