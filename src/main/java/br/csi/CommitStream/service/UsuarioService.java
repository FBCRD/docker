package br.csi.CommitStream.service;

import br.csi.CommitStream.model.Usuario.Usuario;
import br.csi.CommitStream.model.Usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }
    public void salvar(Usuario usuario){
        this.repository.save(usuario);
    }
    public List<Usuario> listar(){
        return this.repository.findAll();
    }
    public Usuario getUsuario(Long id){
        return this.repository.findById(id).get();
    }
    public void excluir(Long id){this.repository.deleteById(id);}
    public void atualizar(Usuario usuario){
        Usuario u = this.repository.getReferenceById(usuario.getIdUsuario());
        u.setNome(usuario.getNome());
        u.setEmail(usuario.getEmail());
        u.setSenha(usuario.getSenha());
    }

    public void atualizarUUID(Usuario usuario){
        Usuario usuario1 = this.repository.findUsuarioByUuid(usuario.getUuid());
        usuario1.setNome(usuario.getNome());
        usuario1.setEmail(usuario.getEmail());
        usuario1.setSenha(usuario.getSenha());
        this.repository.save(usuario1);
    }

    public Usuario getUsuarioUUID(String uuid){
        UUID uuidformatado = UUID.fromString(uuid);
        return this.repository.findUsuarioByUuid(uuidformatado);
    }
    public void deletarUUID(String uuid){this.repository.deleteUsuarioByUuid(UUID.fromString(uuid));}


}
