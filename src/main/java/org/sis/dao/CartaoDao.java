package org.sis.dao;
import org.sis.model.Cartao;
import org.sis.model.GrupoCartao;
import org.sis.model.Usuario;
import org.sis.util.ConectaBDPostgres;

import java.sql.*;
import java.util.ArrayList;

public class CartaoDao {

    private String sql;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private boolean status;

    public ArrayList<Cartao> getCartoes() {
        ArrayList<Cartao> cartoes2 = new ArrayList<>();
        try (Connection conn = new ConectaBDPostgres().getConexao()){
            this.sql = "select * from cartao, usuario, grupo_cartao where cartao.id_usuario=usuario.id_usuario and grupo_cartao.id_grupo_cartao=cartao.id_grupo_cartao";
            this.statement = conn.createStatement();
            this.resultSet = this.statement.executeQuery(sql);
            while (this.resultSet.next()) {

                Cartao c = new Cartao();
                c.setId_cartao(this.resultSet.getInt("id_cartao"));
                c.setNome_cartao(this.resultSet.getString("nome_cartao"));
                c.setSaldo(this.resultSet.getFloat("saldo"));

                Usuario u = new Usuario();
                u.setId_usuario(this.resultSet.getInt("id_usuario"));
                u.setCpf(this.resultSet.getString("cpf"));
                u.setEmail(this.resultSet.getString("email"));
                u.setEndereco(this.resultSet.getString("endereco"));
                u.setNome_usuario(this.resultSet.getString("nome_usuario"));
                u.setSenha(this.resultSet.getString("senha"));
                u.setData_nasc(this.resultSet.getString("data_nasc"));
                u.setTelefone(this.resultSet.getString("telefone"));
                c.setUsuario(u);
                GrupoCartao gc = new GrupoCartao();
                gc.setId_grupo_cartao(this.resultSet.getInt("id_grupo_cartao"));
                gc.setNome_grupo(this.resultSet.getString("nome_grupo"));
                gc.setGratuito(this.resultSet.getBoolean("gratuito"));
                c.setGrupoCartao(gc);
                cartoes2.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao usar getCartoes");
            e.printStackTrace();
        }
        return cartoes2;
    }
    public ArrayList<Cartao> getCartoes2(int id) {

        ArrayList<Cartao> cartoes2 = new ArrayList<>();
        try (Connection conn = new ConectaBDPostgres().getConexao()){
            this.sql = "select * from cartao, usuario, grupo_cartao where cartao.id_usuario=? and usuario.id_usuario=? and grupo_cartao.id_grupo_cartao=cartao.id_grupo_cartao";
            this.preparedStatement = conn.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.setInt(2, id);
            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.executeQuery();

            while (this.resultSet.next()) {

                Cartao c = new Cartao();
                c.setId_cartao(this.resultSet.getInt("id_cartao"));
                c.setNome_cartao(this.resultSet.getString("nome_cartao"));
                c.setSaldo(this.resultSet.getFloat("saldo"));

                Usuario u = new Usuario();
                u.setId_usuario(this.resultSet.getInt("id_usuario"));
                u.setCpf(this.resultSet.getString("cpf"));
                u.setEmail(this.resultSet.getString("email"));
                u.setEndereco(this.resultSet.getString("endereco"));
                u.setNome_usuario(this.resultSet.getString("nome_usuario"));
                u.setSenha(this.resultSet.getString("senha"));
                u.setData_nasc(this.resultSet.getString("data_nasc"));
                u.setTelefone(this.resultSet.getString("telefone"));
                c.setUsuario(u);
                GrupoCartao gc = new GrupoCartao();
                gc.setId_grupo_cartao(this.resultSet.getInt("id_grupo_cartao"));
                gc.setNome_grupo(this.resultSet.getString("nome_grupo"));
                gc.setGratuito(this.resultSet.getBoolean("gratuito"));
                c.setGrupoCartao(gc);
                cartoes2.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao usar getCartoes com parametro");
            e.printStackTrace();
        }
        return cartoes2;
    }



    public boolean cadastrar(Cartao cartao) {

        try (Connection conn = new ConectaBDPostgres().getConexao()) {
        if (verificaCartao(cartao.getUsuario().getId_usuario(), cartao.getGrupoCartao().getId_grupo_cartao())){
            System.out.println("Usuario ja possui um cartao do mesmo tipo");
            return false;
        }
            this.sql = "INSERT INTO cartao(nome_cartao, saldo, id_grupo_cartao, id_usuario) values(?, ?, ?, ?) ";
        this.preparedStatement = conn.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
        this.preparedStatement.setString(1, cartao.getNome_cartao());
        this.preparedStatement.setFloat(2, cartao.getSaldo());
        this.preparedStatement.setInt(3, cartao.getGrupoCartao().getId_grupo_cartao());
        this.preparedStatement.setInt(4, cartao.getUsuario().getId_usuario());
        this.preparedStatement.execute();

        this.resultSet=this.preparedStatement.getGeneratedKeys();
        this.resultSet.next();
        if(this.resultSet.getInt(1)>0){
           cartao.setId_cartao(this.resultSet.getInt(1));
           this.status=true;
           System.out.println("Dentro do if de insert usuario");
        }

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao usar cadastro de cartoes");
            this.status=false;
    }
        return this.status;
    }
    public boolean excluir(int id){
        System.out.println("Entrou em excluir");
        this.sql = "Delete from cartao where id_cartao = ?";
        try{
            Connection conn = new ConectaBDPostgres().getConexao();
            this.preparedStatement= conn.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao excluir");
            return false;
        }
    }
    public boolean recarregar(int id, float valor) throws SQLException {
        System.out.println("Entrou em recarregar, id: "+id);

        this.sql = "update cartao set saldo = saldo + ? where id_cartao = ?";
        try{
            Connection conn = new ConectaBDPostgres().getConexao();
            this.preparedStatement= conn.prepareStatement(this.sql);
            this.preparedStatement.setFloat(1, valor);
            this.preparedStatement.setInt(2, id);
            this.preparedStatement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao recarregar");
            return false;
        }

    }
public boolean verificaCartao(int idUsuario, int idGrupoCartao){
        boolean existe = false;
        try(Connection conn = new ConectaBDPostgres().getConexao()){
            this.sql= "SELECT COUNT(*) AS total From cartao where id_usuario = ? and id_grupo_cartao = ?";
            this.preparedStatement = conn.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, idUsuario);
            this.preparedStatement.setInt(2, idGrupoCartao);
            this.resultSet = this.preparedStatement.executeQuery();
            if (this.resultSet.next()){
                existe = this.resultSet.getInt("total")>0;
            }
            System.out.println("print"+existe);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao verificar existencia de cartao de mesmo tipo");
        }
        return existe;
}
public boolean editarCartao(Cartao cartao, String nomecartao, GrupoCartao gc){
    if (verificaCartao(cartao.getUsuario().getId_usuario(), gc.getId_grupo_cartao())){
        System.out.println("Usuario ja possui um cartao do mesmo tipo");
        return false;
    }
        try(Connection conn = new ConectaBDPostgres().getConexao()){
            this.sql = "UPDATE cartao SET nome_cartao = ?, id_grupo_cartao = ? WHERE id_cartao = ?";
            this.preparedStatement = conn.prepareStatement(this.sql);
            this.preparedStatement.setString(1, nomecartao);
            this.preparedStatement.setInt(2, gc.getId_grupo_cartao());
            this.preparedStatement.setInt(3, cartao.getId_cartao());

            this.preparedStatement.execute();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao editar");
            return false;
        }
}public Cartao getcartao(int id){
        Cartao c = null;
        try (Connection conn = new ConectaBDPostgres().getConexao()){
            this.sql = "select * from cartao where id_cartao = ?";
            this.preparedStatement = conn.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.executeQuery();
            while (this.resultSet.next()) {
                int id_usuario = this.resultSet.getInt("id_usuario");
                int id_grupo_cartao= this.resultSet.getInt("id_grupo_cartao");
                c = new Cartao();
                c.setSaldo(this.resultSet.getFloat("saldo"));
                c.setNome_cartao(this.resultSet.getString("nome_cartao"));
                c.setId_cartao(this.resultSet.getInt("id_cartao"));
                c.setUsuario(new UsuarioDao().getusuario(id_usuario));
                c.setGrupoCartao(new Grupo_cartaoDAO().getgrupocartao(id_grupo_cartao));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao usar getCartoes com parametro");
            e.printStackTrace();
        }
        return c;
    }


}





































































































































































































































































