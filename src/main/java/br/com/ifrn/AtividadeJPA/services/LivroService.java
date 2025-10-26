package br.com.ifrn.AtividadeJPA.services;


import br.com.ifrn.AtividadeJPA.dto.LivroDTO;
import br.com.ifrn.AtividadeJPA.dto.QuantidadeLivrosCategoriaDTO;
import br.com.ifrn.AtividadeJPA.model.*;
import br.com.ifrn.AtividadeJPA.repository.AutorRepository;
import br.com.ifrn.AtividadeJPA.repository.CategoriaRepository;
import br.com.ifrn.AtividadeJPA.repository.LivroRepository;
import br.com.ifrn.AtividadeJPA.repository.Livro_AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private Livro_AutorRepository livroAutorRepository;

    public LivroDTO create(LivroDTO dto) {
        // Cria e salva categoria
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNomeCategoria());
        categoria.setDescricao(dto.getDescricaoCategoria());
        categoriaRepository.save(categoria);

        // Cria e salva livro
        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setIsbn(dto.getIsbn());
        livro.setEditora(dto.getEditora());
        livro.setAnoPublicacao(dto.getAnoPublicacao());
        livro.setNumeroPaginas(dto.getNumeroPaginas());
        livro.setQuantidadeDisponivel(dto.getQuantidadeDisponivel());
        livro.setQuantidadeTotal(dto.getQuantidadeTotal());
        livro.setCategoria(categoria);

        Livro livroSalvo = livroRepository.save(livro);

        // Associa autores corretamente
        for (Integer autorId : dto.getAutoresIds()) {
            Autor autor = autorRepository.findById(autorId)
                    .orElseThrow(() -> new RuntimeException("Autor não encontrado: " + autorId));

            Livro_Autor livroAutor = new Livro_Autor();

            // Cria e seta a chave composta
            LivroAutorID id = new LivroAutorID();
            id.setLivroId(livroSalvo.getId());
            id.setAutorId(autor.getId());
            livroAutor.setId(id);

            livroAutor.setLivro(livroSalvo);
            livroAutor.setAutor(autor);

            livroAutorRepository.save(livroAutor);
        }

        dto.setId(livroSalvo.getId());
        return dto;
    }


    public List<LivroDTO> findAllLivros(){
        List<Livro> livros = livroRepository.findByQuantidadeDisponivelGreaterThanOrderByTituloAsc(0);

        return livros.stream()
                .map(LivroDTO::new)
                .collect(Collectors.toList());
    }

    public List<LivroDTO> findLivrosByCategoria(String nomeCategoria){
        List<Livro> livros = livroRepository.findByCategoriaNome(nomeCategoria);

        return livros.stream()
                .map(LivroDTO::new)
                .collect(Collectors.toList());
    }

    public List<QuantidadeLivrosCategoriaDTO> QuantidadeLivrosCategoria(){
        return livroRepository.contarLivrosPorCategoria();
    }


}
