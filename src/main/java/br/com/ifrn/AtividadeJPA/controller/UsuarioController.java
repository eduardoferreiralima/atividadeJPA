package br.com.ifrn.AtividadeJPA.controller;

import br.com.ifrn.AtividadeJPA.model.Usuario;
import br.com.ifrn.AtividadeJPA.repository.UsuarioRepository;
import br.com.ifrn.AtividadeJPA.services.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@Tag(name = "Usuario", description = "Operações relacionadas a usuários")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    @GetMapping
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/FindByName")
    public ResponseEntity<List<Usuario>> findByNome(@RequestParam String nome) {
        return ResponseEntity.ok(usuarioService.findByNome(nome));
    }

}
