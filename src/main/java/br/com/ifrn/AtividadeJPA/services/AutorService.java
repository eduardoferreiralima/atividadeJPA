package br.com.ifrn.AtividadeJPA.services;

import br.com.ifrn.AtividadeJPA.dto.LivroDTO;
import br.com.ifrn.AtividadeJPA.model.Autor;
import br.com.ifrn.AtividadeJPA.model.Livro;
import br.com.ifrn.AtividadeJPA.repository.AutorRepository;
import br.com.ifrn.AtividadeJPA.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;

    public List<Autor> findAll(){
        return autorRepository.findAll();
    }
    public Autor findById(int id){
        return autorRepository.findById(id).get();
    }
    public Autor save(Autor autor){
        return autorRepository.save(autor);
    }

    public void delete(Autor autor){
        autorRepository.delete(autor);
    }

    public List<LivroDTO> findLivrosAutor(String nomeAutor){
        List<Livro> livros = livroRepository.findLivrosByAutor(nomeAutor);
        List<LivroDTO> livrosDTO = new ArrayList<>();
        for (Livro livro : livros) {
            LivroDTO livroDTO = new LivroDTO();
            livroDTO.setTitulo(livro.getTitulo());
            livroDTO.setEditora(livro.getEditora());
            livroDTO.setIsbn(livro.getIsbn());
            livroDTO.setId(livro.getId());
            livroDTO.setAnoPublicacao(livro.getAnoPublicacao());
            livroDTO.setNumeroPaginas(livro.getNumeroPaginas());
            livroDTO.setQuantidadeDisponivel(livro.getQuantidadeDisponivel());
            livroDTO.setQuantidadeTotal(livro.getQuantidadeTotal());
            livroDTO.setDescricaoCategoria(livro.getCategoria().getDescricao());
            livroDTO.setNomeCategoria(livro.getCategoria().getNome());
            livrosDTO.add(livroDTO);
        }
        return livrosDTO;
    }

}
