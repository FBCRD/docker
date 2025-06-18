package br.csi.CommitStream.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    public Usuario findUsuarioByUuid(UUID uuid);
    public void deleteUsuarioByUuid(UUID uuid);
}
