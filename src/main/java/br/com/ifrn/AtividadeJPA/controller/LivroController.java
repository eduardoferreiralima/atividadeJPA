package br.com.ifrn.AtividadeJPA.controller;

import br.com.ifrn.AtividadeJPA.dto.LivroDTO;
import br.com.ifrn.AtividadeJPA.dto.QuantidadeLivrosCategoriaDTO;
import br.com.ifrn.AtividadeJPA.services.LivroService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livro")
@Tag(name = "Livro", description = "Operações relacionadas a livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroDTO> create(@RequestBody LivroDTO dto) {
        LivroDTO created = livroService.create(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAllLivros() {
        return  ResponseEntity.ok(livroService.findAllLivros());
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<LivroDTO>> findByCategoriaNome(@RequestParam String nomeCategoria) {
        return ResponseEntity.ok(livroService.findLivrosByCategoria(nomeCategoria));
    }

    @GetMapping("/livros_categoria")
    public ResponseEntity<List<QuantidadeLivrosCategoriaDTO>> findAllLivrosCategoria() {
        return ResponseEntity.ok(livroService.QuantidadeLivrosCategoria());
    }

}
