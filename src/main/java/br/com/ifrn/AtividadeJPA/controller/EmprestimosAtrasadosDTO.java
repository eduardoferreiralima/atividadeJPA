package br.com.ifrn.AtividadeJPA.controller;

import br.com.ifrn.AtividadeJPA.model.Emprestimo;
import br.com.ifrn.AtividadeJPA.model.Livro;
import br.com.ifrn.AtividadeJPA.model.Usuario;

import java.time.LocalDate;

public class EmprestimosAtrasadosDTO {
    private String NomeUsuario;
    private LocalDate DataEmprestimo;
}
