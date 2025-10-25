package br.com.ifrn.AtividadeJPA.services;


import br.com.ifrn.AtividadeJPA.controller.LivroDTO;
import br.com.ifrn.AtividadeJPA.model.Categoria;
import br.com.ifrn.AtividadeJPA.model.Livro;
import br.com.ifrn.AtividadeJPA.repository.CategoriaRepository;
import br.com.ifrn.AtividadeJPA.repository.LivroRepository;
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

    public LivroDTO create(LivroDTO dto){

        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNomeCategoria());
        categoria.setDescricao(dto.getDescricaoCategoria());
        categoriaRepository.save(categoria);

        // Agora cria e associa o livro
        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setIsbn(dto.getIsbn());
        livro.setEditora(dto.getEditora());
        livro.setAnoPublicacao(dto.getAnoPublicacao());
        livro.setNumeroPaginas(dto.getNumeroPaginas());
        livro.setQuantidadeDisponivel(dto.getQuantidadeDisponivel());
        livro.setQuantidadeTotal(dto.getQuantidadeTotal());
        livro.setCategoria(categoria); //

        livroRepository.save(livro);

        return new LivroDTO(livro);
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


}
