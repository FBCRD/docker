package br.csi.CommitStream.model.Genero;

import br.csi.CommitStream.model.Filme.Filme;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "genero")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Schema(description = "Entidade que representa um genero no sistema")
public class Genero {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Entidade que representa um genero no sistema")
    private Long idGenero;
    @Schema(description = "Nome do genero", example = "Romance")
    @NonNull
    @NotBlank
    private String nomegenero;

    @Schema(description = "filmes do genero")
    @ManyToMany(mappedBy = "generos")
    private Set<Filme> filmes = new HashSet<>();

    public Set<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(Set<Filme> filmes) {
        this.filmes = filmes;
    }

    public @NonNull String getNomeGenero() {
        return nomegenero;
    }

    public void setNomeGenero(@NonNull String nomeGenero) {
        this.nomegenero = nomeGenero;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }
}
