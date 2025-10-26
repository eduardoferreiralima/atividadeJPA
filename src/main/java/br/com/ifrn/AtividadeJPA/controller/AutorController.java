package br.com.ifrn.AtividadeJPA.controller;

import br.com.ifrn.AtividadeJPA.dto.LivroDTO;
import br.com.ifrn.AtividadeJPA.model.Autor;
import br.com.ifrn.AtividadeJPA.services.AutorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autor")
@Tag(name = "Autor", description = "Operações relacionadas a autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor){
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.save(autor));
    }

    @GetMapping("/livros_autor")
    public ResponseEntity<List<LivroDTO>> BuscarLivrosAutor(@RequestParam String nome) {
        return ResponseEntity.ok(autorService.findLivrosAutor(nome));
    }




}
