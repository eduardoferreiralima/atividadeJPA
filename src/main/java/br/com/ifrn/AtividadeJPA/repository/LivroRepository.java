package br.com.ifrn.AtividadeJPA.repository;

import br.com.ifrn.AtividadeJPA.dto.QuantidadeLivrosCategoriaDTO;
import br.com.ifrn.AtividadeJPA.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
    List<Livro> findByQuantidadeDisponivelGreaterThanOrderByTituloAsc(int quantidade);
    List<Livro> findByCategoriaNome(String nomeCategoria);

    @Query("SELECT new br.com.ifrn.AtividadeJPA.dto.QuantidadeLivrosCategoriaDTO(c.nome, COUNT(l)) " +
            "FROM Livro l JOIN l.categoria c " +
            "GROUP BY c.nome " +
            "ORDER BY COUNT(l) DESC")
    List<QuantidadeLivrosCategoriaDTO> contarLivrosPorCategoria();

    @Query("""
    SELECT l
    FROM Livro l
    JOIN l.autores la
    JOIN la.autor a
    WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :nomeAutor, '%'))
    ORDER BY l.anoPublicacao
""")
    List<Livro> findLivrosByAutor(@Param("nomeAutor") String nomeAutor);
}
