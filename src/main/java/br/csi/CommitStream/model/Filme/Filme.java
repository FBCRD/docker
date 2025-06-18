package br.csi.CommitStream.model.Filme;

import br.csi.CommitStream.model.Avaliacao.Avaliacao;
import br.csi.CommitStream.model.Genero.Genero;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "filme")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Schema (description = "Entidade que representa um filme no sistema")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do filme")
    private Long idfilme;
    @Schema(description = "Titulo do filme", example = "One day")
    @NonNull
    @NotBlank
    private String titulo;
    @Schema(description = "Descricao do filme", example = "Filme de romance, que conta a historia de...")
    @NonNull
    @NotBlank
    private String descricao;
    @Schema(description = "Data de lançamento", example ="2013")
    @NonNull
    @NotBlank
    private String datalancamento;
    @Schema(description = "Duração (em minutos)", example = "120")
    @NonNull
    private int duracao;
    @Schema (description = "Lista de generos do filme")
    @NonNull
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name="filme_genero",
            joinColumns = @JoinColumn(name = "filme_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private Set<Genero> generos= new HashSet<>();
    @Schema(description = "Lista de avaliações do filme")
    @OneToMany(mappedBy = "filme")
    private Set<Avaliacao> avaliacoes;

    public Filme(@NonNull String titulo, @NonNull String descricao, @NonNull String datalancamento, @NonNull int duracao, @NonNull Set<Genero> generos) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.datalancamento = datalancamento;
        this.duracao = duracao;
        this.generos = generos;
    }

    public @NonNull Set<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(@NonNull Set<Genero> generos) {
        this.generos = generos;
    }

    public Set<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(Set<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public long getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(Long idfilme) {
        this.idfilme = idfilme;
    }

    public @NonNull String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NonNull String titulo) {
        this.titulo = titulo;
    }

    public @NonNull String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NonNull String descricao) {
        this.descricao = descricao;
    }

    public @NonNull String getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(@NonNull String datalancamento) {
        this.datalancamento = datalancamento;
    }

    @NonNull
    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(@NonNull int duracao) {
        this.duracao = duracao;
    }

}
