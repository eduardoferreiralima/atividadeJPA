package br.com.ifrn.AtividadeJPA.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import br.com.ifrn.AtividadeJPA.model.LivroAutorID;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Livro_Autor {
    @EmbeddedId
    private LivroAutorID id;

    @ManyToOne
    @MapsId("livroId")
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @ManyToOne
    @MapsId("autorId")
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public LivroAutorID getId() {
        return id;
    }

    public void setId(LivroAutorID id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
