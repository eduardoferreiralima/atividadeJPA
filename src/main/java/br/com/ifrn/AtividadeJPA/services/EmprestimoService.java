package br.com.ifrn.AtividadeJPA.services;


import br.com.ifrn.AtividadeJPA.dto.EmprestimoDTO;
import br.com.ifrn.AtividadeJPA.dto.EmprestimosAtrasadosDTO;
import br.com.ifrn.AtividadeJPA.dto.LivroDTO;
import br.com.ifrn.AtividadeJPA.dto.LivrosEmprestadosDTO;
import br.com.ifrn.AtividadeJPA.model.*;
import br.com.ifrn.AtividadeJPA.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    Item_emprestimoRepository item_emprestimo;

    @Autowired
    CategoriaRepository categoriaRepository;

    public EmprestimoDTO salvar(EmprestimoDTO emprestimoDTO) {
        // Busca usuário e livro
        Usuario usuario = usuarioRepository.findById(emprestimoDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Livro livro = livroRepository.findById(emprestimoDTO.getLivroId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        // Cria empréstimo
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setStatus(StatusEmprestimo.ATIVO);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucaoPrevista(emprestimoDTO.getDataDevoluçãoEmprestimo());
        emprestimo.setDataDevolucaoEfetiva(emprestimoDTO.getDataDevoluçãoEmprestimo());
        emprestimo.setValorMulta(0.0f);

        Emprestimo salvo = emprestimoRepository.save(emprestimo);

        // Cria item_emprestimo com ID composto
        Item_Emprestimo item = new Item_Emprestimo();
        ItemEmprestimoID id = new ItemEmprestimoID();
        id.setEmprestimoID(salvo.getId());
        id.setLivroID(livro.getId());
        item.setId(id);
        item.setEmprestimo(salvo);
        item.setLivro(livro);

        item_emprestimo.save(item);

        // Monta DTO de resposta
        EmprestimoDTO resposta = new EmprestimoDTO();
        resposta.setUsuarioId(salvo.getUsuario().getId());
        resposta.setLivroId(livro.getId());
        resposta.setDataDevoluçãoEmprestimo(salvo.getDataDevolucaoPrevista());

        return resposta;
    }


    public List<LivrosEmprestadosDTO> listarEmprestimosAtivosPorUsuario(int usuarioId) {
        List<LivrosEmprestadosDTO> livrosEmprestados = new ArrayList<>();

        // Busca os empréstimos ativos do usuário
        List<Emprestimo> emprestimos = emprestimoRepository.findByUsuarioAndStatus(usuarioId, StatusEmprestimo.ATIVO);

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        for (Emprestimo emprestimo : emprestimos) {
            // Para cada empréstimo, iterar sobre todos os itens associados
            Set<Item_Emprestimo> itens = emprestimo.getItensEmprestimo();

            if (itens != null && !itens.isEmpty()) {
                for (Item_Emprestimo item : itens) {
                    if (item != null && item.getLivro() != null) {
                        Livro livro = item.getLivro();

                        LivroDTO livroDTO = new LivroDTO();
                        livroDTO.setAnoPublicacao(livro.getAnoPublicacao());
                        livroDTO.setEditora(livro.getEditora());
                        livroDTO.setTitulo(livro.getTitulo());
                        livroDTO.setIsbn(livro.getIsbn());
                        livroDTO.setNumeroPaginas(livro.getNumeroPaginas());
                        livroDTO.setQuantidadeDisponivel(livro.getQuantidadeDisponivel());
                        livroDTO.setNomeCategoria(livro.getCategoria().getNome());
                        livroDTO.setId(livro.getId());
                        livroDTO.setQuantidadeTotal(livro.getQuantidadeTotal());
                        livroDTO.setDescricaoCategoria(livro.getCategoria().getDescricao());

                        LivrosEmprestadosDTO livrosEmprestadosDTO = new LivrosEmprestadosDTO();
                        livrosEmprestadosDTO.setLivro(livroDTO);
                        livrosEmprestadosDTO.setUsuarioNome(usuario.getNome());
                        livrosEmprestadosDTO.setStatus(String.valueOf(emprestimo.getStatus()));
                        livrosEmprestadosDTO.setId(emprestimo.getId());
                        livrosEmprestadosDTO.setDataDevolucaoPrevista(emprestimo.getDataDevolucaoPrevista());

                        livrosEmprestados.add(livrosEmprestadosDTO);
                    }
                }
            }
        }

        return livrosEmprestados;
    }



    public List<Emprestimo> findAll() {
        return emprestimoRepository.findAll();
    }

    public List<EmprestimosAtrasadosDTO> listarEmprestimosAtrasados() {
        List<EmprestimosAtrasadosDTO> atrasados = new ArrayList<>();
        LocalDate hoje = LocalDate.now();

        List<Emprestimo> emprestimos = emprestimoRepository.findEmprestimosAtrasados(StatusEmprestimo.ATIVO, hoje);

        for (Emprestimo e : emprestimos) {
            for (Item_Emprestimo item : e.getItensEmprestimo()) {
                EmprestimosAtrasadosDTO dto = new EmprestimosAtrasadosDTO();
                dto.setEmprestimoId(e.getId());
                dto.setUsuarioNome(e.getUsuario().getNome());
                dto.setLivroTitulo(item.getLivro().getTitulo());
                dto.setDataDevolucaoPrevista(e.getDataDevolucaoPrevista());
                dto.setDataEmprestimo(e.getDataEmprestimo());
                atrasados.add(dto);
            }
        }

        return atrasados;
    }


}
