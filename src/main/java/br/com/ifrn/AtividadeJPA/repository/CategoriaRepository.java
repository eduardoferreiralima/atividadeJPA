package br.com.ifrn.AtividadeJPA.repository;

import br.com.ifrn.AtividadeJPA.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
