package br.com.ifrn.AtividadeJPA.repository;

import br.com.ifrn.AtividadeJPA.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByNomeContainingIgnoreCase(String nome);
}
