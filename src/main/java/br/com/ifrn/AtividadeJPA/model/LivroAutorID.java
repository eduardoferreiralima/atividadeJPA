package br.com.ifrn.AtividadeJPA.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LivroAutorID implements Serializable {
    private int livroId;
    private int autorId;

    public int getLivroId() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    public int getAutorId() {
        return autorId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LivroAutorID that = (LivroAutorID) o;
        return livroId == that.livroId && autorId == that.autorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(livroId, autorId);
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }
}
