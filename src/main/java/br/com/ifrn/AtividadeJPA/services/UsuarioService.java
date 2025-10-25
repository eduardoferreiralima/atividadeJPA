package br.com.ifrn.AtividadeJPA.services;

import br.com.ifrn.AtividadeJPA.model.Usuario;
import br.com.ifrn.AtividadeJPA.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findByNome(String nome) {
        return usuarioRepository.findByNomeContainingIgnoreCase(nome);
    }

}
