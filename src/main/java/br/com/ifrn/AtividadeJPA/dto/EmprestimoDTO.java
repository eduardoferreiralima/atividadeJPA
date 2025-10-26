package br.com.ifrn.AtividadeJPA.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class EmprestimoDTO {
    @NotNull(message = "O ID do usuário é obrigatório.")
    private int usuarioId;
    private int livroId;
    private LocalDate dataDevoluçãoEmprestimo;

    public int getLivroId() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDate getDataDevoluçãoEmprestimo() {
        return dataDevoluçãoEmprestimo;
    }

    public void setDataDevoluçãoEmprestimo(LocalDate dataDevoluçãoEmprestimo) {
        this.dataDevoluçãoEmprestimo = dataDevoluçãoEmprestimo;
    }
}
