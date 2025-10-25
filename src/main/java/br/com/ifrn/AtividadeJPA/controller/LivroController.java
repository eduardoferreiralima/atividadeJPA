package br.com.ifrn.AtividadeJPA.controller;

import br.com.ifrn.AtividadeJPA.model.Livro;
import br.com.ifrn.AtividadeJPA.repository.LivroRepository;
import br.com.ifrn.AtividadeJPA.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livro")
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





}
