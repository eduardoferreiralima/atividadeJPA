package br.com.ifrn.AtividadeJPA.services;

import br.com.ifrn.AtividadeJPA.model.Categoria;
import br.com.ifrn.AtividadeJPA.repository.CategoriaRepository;
import br.com.ifrn.AtividadeJPA.repository.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;


    public Categoria create(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
}
