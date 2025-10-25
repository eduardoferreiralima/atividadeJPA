package br.com.ifrn.AtividadeJPA.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import br.com.ifrn.AtividadeJPA.model.ItemEmprestimoID;

import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Item_Emprestimo {
    @EmbeddedId
    private ItemEmprestimoID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("emprestimoID")
    @JoinColumn(name = "emprestimo_id")
    private Emprestimo emprestimo;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("livroID")
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public ItemEmprestimoID getId() {
        return id;
    }

    public void setId(ItemEmprestimoID id) {
        this.id = id;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item_Emprestimo that = (Item_Emprestimo) o;
        return Objects.equals(id, that.id) && Objects.equals(emprestimo, that.emprestimo) && Objects.equals(livro, that.livro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emprestimo, livro);
    }
}
