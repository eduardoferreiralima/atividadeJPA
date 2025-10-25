package br.com.ifrn.AtividadeJPA.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemEmprestimoID implements Serializable {
    private Integer emprestimoID;
    private Integer livroID;

    public int getEmprestimoID() {
        return emprestimoID;
    }

    public void setEmprestimoID(Integer emprestimoID) {
        this.emprestimoID = emprestimoID;
    }

    public void setLivroID(Integer livroID) {
        this.livroID = livroID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemEmprestimoID that = (ItemEmprestimoID) o;
        return emprestimoID == that.emprestimoID && livroID == that.livroID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(emprestimoID, livroID);
    }

    public void setEmprestimoID(int emprestimoID) {
        this.emprestimoID = emprestimoID;
    }

    public int getLivroID() {
        return livroID;
    }

    public void setLivroID(int livroID) {
        this.livroID = livroID;
    }
}
