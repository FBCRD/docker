package org.sis.service;

import org.sis.dao.CartaoDao;
import org.sis.dao.LinhasOnibusDAO;
import org.sis.model.Cartao;
import org.sis.model.Linhas;
import org.sis.model.Usuario;

public class LinhasService {
    public boolean inserir(Usuario usuario, Linhas linhas){
        return new LinhasOnibusDAO().cadastrar(linhas, usuario);
    }
    public boolean excluir(int id){
        return new LinhasOnibusDAO().excluir(id);
    }

}
