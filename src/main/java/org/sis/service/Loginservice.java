package org.sis.service;

import org.sis.dao.UsuarioDao;
import org.sis.model.Usuario;

public class Loginservice{

    public Usuario logar(String email, String senha){
        return new UsuarioDao().autenticar(email, senha);
    }
}
