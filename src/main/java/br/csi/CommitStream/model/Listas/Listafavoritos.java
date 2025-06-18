package br.csi.CommitStream.model.Listas;

import br.csi.CommitStream.model.Filme.Filme;
import br.csi.CommitStream.model.Usuario.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "listafavoritos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Schema(description = "Entidade que representa um aluno no sistema")
public class Listafavoritos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id da lista de favoritos", example = "1")
    private Long idlistafav;
    @NonNull
    private String nomelista;
    @Schema(description = "Muitas listas de favoritos para um Usuario")
    @NonNull
    @ManyToOne
    private Usuario usuario;
    @Schema(description = "Muitos filmes para uma lista")
    @NonNull
    @OneToMany
    private List<Filme> filme;

    public Long getIdlistafav() {
        return idlistafav;
    }

    public void setIdlistafav(Long idlistafav) {
        this.idlistafav = idlistafav;
    }

    public @NonNull String getNomelista() {
        return nomelista;
    }

    public void setNomelista(@NonNull String nomelista) {
        this.nomelista = nomelista;
    }

    public @NonNull Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(@NonNull Usuario usuario) {
        this.usuario = usuario;
    }

    public @NonNull List<Filme> getFilme() {
        return filme;
    }

    public void setFilme(@NonNull List<Filme> filme) {
        this.filme = filme;
    }
}
