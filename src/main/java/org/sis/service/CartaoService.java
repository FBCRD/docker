package org.sis.service;

import org.sis.dao.CartaoDao;
import org.sis.model.Cartao;
import org.sis.model.GrupoCartao;

import java.sql.SQLException;

public class CartaoService {
    public boolean inserir(Cartao cartao){

        return new CartaoDao().cadastrar(cartao);
    }
    public boolean deletar(int id){
        return new CartaoDao().excluir(id);
    }
    public boolean recarregar(int id, float valor) throws SQLException {
        return new CartaoDao().recarregar(id, valor);
    }
    public boolean editar(Cartao cartao, String nome, GrupoCartao gc){
        return new CartaoDao().editarCartao(cartao, nome, gc);

    }


}
