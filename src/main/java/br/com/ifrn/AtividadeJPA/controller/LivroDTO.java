package br.com.ifrn.AtividadeJPA.controller;

import br.com.ifrn.AtividadeJPA.model.Livro;

import java.time.LocalDate;

public class LivroDTO {
    private int id;
    private String isbn;
    private String titulo;
    private String editora;
    private LocalDate anoPublicacao;
    private int numeroPaginas;
    private int quantidadeTotal;
    private int quantidadeDisponivel;
    private String nomeCategoria;
    private String descricaoCategoria;

    public LivroDTO() {}

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.isbn = livro.getIsbn();
        this.editora = livro.getEditora();
        this.anoPublicacao = livro.getAnoPublicacao();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.quantidadeDisponivel = livro.getQuantidadeDisponivel();
        this.quantidadeTotal = livro.getQuantidadeTotal();
        this.nomeCategoria = livro.getCategoria().getNome();
        this.descricaoCategoria = livro.getCategoria().getDescricao();

        // Evita acessar o proxy direto: pega apenas os campos necessários
        if (livro.getCategoria() != null) {
            this.nomeCategoria = livro.getCategoria().getNome();
            this.descricaoCategoria = livro.getCategoria().getDescricao();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public LocalDate getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(LocalDate anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }
}
