package br.csi.CommitStream.model.Usuario;

import br.csi.CommitStream.model.Avaliacao.Avaliacao;
import br.csi.CommitStream.model.Listas.Listafavoritos;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Schema(description = "Entidade que representa um aluno no sistema")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do usuario", example = "1")
    private Long idusuario;
    @UuidGenerator
    private UUID uuid;
    @Schema(description = "Nome de usuario", example="Fbcrd")
    @NonNull
    @NotBlank
    private String nome;
    @Schema(description = "Email do usuario", example = "fabrodrigues237@gmail.com")
    @NonNull
    @Email(message = "Email invalido")
    private String email;
    @Schema(description = "Senha de usuario")
    @NonNull
    @Size(min = 8, message = "Senha pequena")
    private String senha;
    @Schema(description = "Lista de avaliacoes do usuario")
    @NonNull
    @OneToMany(mappedBy = "usuario")
    private List<Avaliacao> avaliacaos;

    @Schema(description = "Listas de filmes do usuario")
    @NonNull
    @OneToMany(mappedBy = "usuario")
    private List<Listafavoritos> listafavoritos;

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public @NonNull List<Avaliacao> getAvaliacaos() {
        return avaliacaos;
    }

    public void setAvaliacaos(@NonNull List<Avaliacao> avaliacaos) {
        this.avaliacaos = avaliacaos;
    }

    public @NonNull List<Listafavoritos> getListafavoritos() {
        return listafavoritos;
    }

    public void setListafavoritos(@NonNull List<Listafavoritos> listafavoritos) {
        this.listafavoritos = listafavoritos;
    }

    public Long getIdUsuario() {
        return idusuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idusuario = idUsuario;
    }

    public @NonNull String getSenha() {
        return senha;
    }

    public void setSenha(@NonNull String senha) {
        this.senha = senha;
    }

    public @NonNull String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public @NonNull String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
