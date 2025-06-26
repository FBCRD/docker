package org.sis.service;

import org.sis.dao.CartaoDao;
import org.sis.dao.UsuarioDao;
import org.sis.model.Usuario;

public class UsuarioService {
    public int inserir(Usuario usuario){

        return new UsuarioDao().cadastrar(usuario);
    }
}
