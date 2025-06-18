package br.csi.CommitStream.model.Avaliacao;

import br.csi.CommitStream.model.Filme.Filme;
import br.csi.CommitStream.model.Usuario.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "avaliacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Schema(description = "Entidade que representa uma Avaliação no sistema")
public class Avaliacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id avaliação")
    private Long idAvaliacao;
    @Schema(description = "Nota de avaliação de 0 a 10")
    @NonNull
    @NotBlank
    private float nota;
    @Schema(description = "Comentario sobre o filme")
    @NonNull
    @NotBlank
    private String comentario;
    @Schema(description = "Data da avaliação")
    @NonNull
    @NotBlank
    private Date data;
    @Schema(description = "Usuario que fez a avaliação")
    @NonNull
    @ManyToOne
    private Usuario usuario;
    @Schema(description = "Filme que esta sendo avaliado")
    @NonNull
    @ManyToOne
    private Filme filme;

    public @NonNull Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(@NonNull Usuario usuario) {
        this.usuario = usuario;
    }

    public @NonNull Filme getFilme() {
        return filme;
    }

    public void setFilme(@NonNull Filme filme) {
        this.filme = filme;
    }

    public long getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    @NonNull
    public float getNota() {
        return nota;
    }

    public void setNota(@NonNull float nota) {
        this.nota = nota;
    }

    public @NonNull String getComentario() {
        return comentario;
    }

    public void setComentario(@NonNull String comentario) {
        this.comentario = comentario;
    }

    public @NonNull Date getData() {
        return data;
    }

    public void setData(@NonNull Date data) {
        this.data = data;
    }
}
