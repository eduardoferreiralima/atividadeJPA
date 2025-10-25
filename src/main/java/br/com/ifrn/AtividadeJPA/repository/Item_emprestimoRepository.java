package br.com.ifrn.AtividadeJPA.repository;

import br.com.ifrn.AtividadeJPA.model.Item_Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Item_emprestimoRepository extends JpaRepository<Item_Emprestimo, Integer> {
    @Query("SELECT i FROM Item_Emprestimo i WHERE i.emprestimo.id = :id")
    Item_Emprestimo findByEmprestimoId(@Param("id") Integer id);
}
