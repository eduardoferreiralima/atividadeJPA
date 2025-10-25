package br.com.ifrn.AtividadeJPA.repository;

import br.com.ifrn.AtividadeJPA.model.Emprestimo;
import br.com.ifrn.AtividadeJPA.model.StatusEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
    @Query("SELECT e FROM Emprestimo e WHERE e.usuario.id = :usuarioId AND e.status = :status")
    List<Emprestimo> findByUsuarioAndStatus(@Param("usuarioId") int usuarioId, @Param("status") StatusEmprestimo status);

    @Query("SELECT e FROM Emprestimo e WHERE e.status = :status AND e.dataDevolucaoPrevista < :dataAtual")
    List<Emprestimo> findByStatus(@Param("status") StatusEmprestimo status,  @Param("dataAtual") LocalDate dataAtual);

}
