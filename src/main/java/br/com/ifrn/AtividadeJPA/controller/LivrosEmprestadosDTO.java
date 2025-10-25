package br.com.ifrn.AtividadeJPA.controller;

import java.time.LocalDate;

public class LivrosEmprestadosDTO {
    private int id;
    private String usuarioNome;
    private String dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private String status;
    private LivroDTO livro;

    public LivrosEmprestadosDTO(int id, String dataEmprestimo, LocalDate dataDevolucaoPrevista, String status, String usuarioNome, LivroDTO livro) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.status = status;
        this.usuarioNome = usuarioNome;
        this.livro = livro;
    }

    public LivrosEmprestadosDTO() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public Object getLivro() {
        return livro;
    }

    public void setLivro(LivroDTO livro) {
        this.livro = livro;
    }
}
