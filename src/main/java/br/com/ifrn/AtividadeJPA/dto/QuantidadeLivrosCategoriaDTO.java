package br.com.ifrn.AtividadeJPA.dto;

public class QuantidadeLivrosCategoriaDTO {
    private String categoriaNome;
    private Long quantidade;

    public QuantidadeLivrosCategoriaDTO(String categoriaNome, Long quantidade) {
        this.categoriaNome = categoriaNome;
        this.quantidade = quantidade;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
