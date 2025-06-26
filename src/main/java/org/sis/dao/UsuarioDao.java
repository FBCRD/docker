package org.sis.dao;

import org.sis.model.Usuario;
import org.sis.util.ConectaBDPostgres;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao{

    private String sql;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String status;
    public ArrayList<Usuario> getUsuario(){

        ConectaBDPostgres cdb = new ConectaBDPostgres();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try{
            this.statement=cdb.getConexao().createStatement();
            this.resultSet= this.statement.executeQuery("SELECT * from USUARIO");



            while(this.resultSet.next()){
                Usuario u =
                        new Usuario(
                                this.resultSet.getInt("id_usuario"),
                                this.resultSet.getString("nome_usuario"),
                                this.resultSet.getString("email"),
                                this.resultSet.getString("senha"),
                                this.resultSet.getString("data_nasc"),
                                this.resultSet.getString("endereco"),
                                this.resultSet.getString("telefone"),
                                this.resultSet.getString("cpf"));
                usuarios.add(u);
            }

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao usar getUsuarios");
        }
        return usuarios;
    }

    public Usuario getusuario(int id){
        Usuario u = new Usuario();
        try (Connection conn = new ConectaBDPostgres().getConexao()){
            this.sql = "select * from usuario where usuario.id_usuario = ?";

            this.preparedStatement = conn.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.resultSet = this.preparedStatement.executeQuery();

            while (this.resultSet.next()) {

                u.setId_usuario(this.resultSet.getInt("id_usuario"));
                u.setCpf(this.resultSet.getString("cpf"));
                u.setEmail(this.resultSet.getString("email"));
                u.setEndereco(this.resultSet.getString("endereco"));
                u.setNome_usuario(this.resultSet.getString("nome_usuario"));
                u.setSenha(this.resultSet.getString("senha"));
                u.setData_nasc(this.resultSet.getString("data_nasc"));
                u.setTelefone(this.resultSet.getString("telefone"));

            }
            System.out.println("Usuario:" +u.getId_usuario());
        } catch (SQLException e) {
            System.out.println("Erro ao usar getUsuario com parametro");
            e.printStackTrace();
        }
        return u;
    }

    public Usuario autenticar(String email, String senha) {
        try {
            this.sql = "SELECT * from usuario where email= ? and senha = ?";

            Connection con = new ConectaBDPostgres().getConexao();
            this.preparedStatement = con.prepareStatement(this.sql);
            this.preparedStatement.setString(1, email);
            this.preparedStatement.setString(2, senha);
            this.resultSet = this.preparedStatement.executeQuery();
            while (this.resultSet.next()) {
                        return new Usuario(
                                this.resultSet.getInt("id_usuario"),
                                this.resultSet.getString("nome_usuario"),
                                this.resultSet.getString("email"),
                                this.resultSet.getString("senha"),
                                this.resultSet.getString("data_nasc"),
                                this.resultSet.getString("endereco"),
                                this.resultSet.getString("telefone"),
                                this.resultSet.getString("cpf"));
            }
            return null;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao autenticar");
            return null;
        }
    }
    public int cadastrar(Usuario usuario){
        int idUsuario = 0;
        try(Connection conn = new ConectaBDPostgres().getConexao()){
            
            this.sql= "INSERT INTO usuario(nome_usuario, email, senha, data_nasc, endereco, telefone, cpf) values (?, ?, ?, ?, ?, ?, ?)";
            this.preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1, usuario.getNome_usuario());
            this.preparedStatement.setString(2, usuario.getEmail());
            this.preparedStatement.setString(3, usuario.getSenha());
            this.preparedStatement.setString(4, usuario.getData_nasc());
            this.preparedStatement.setString(5, usuario.getEndereco());
            this.preparedStatement.setString(6, usuario.getTelefone());
            this.preparedStatement.setString(7, usuario.getCpf());
            this.preparedStatement.execute();
            ResultSet rs = this.preparedStatement.getGeneratedKeys();
            rs.next();
            if (rs.getInt(1) > 0) {
                usuario.setId_usuario(rs.getInt(1));
                this.status = "ok";
            }
        }catch(SQLException e){
            System.out.println("Erro ao cadastrar usuario");
            e.printStackTrace();
        }
        return idUsuario;
    }
    public boolean excluir(int id){
            this.sql = "Delete from usuario where id_usuario= "+id;
        try{
            Connection conn = new ConectaBDPostgres().getConexao();
            this.statement= conn.createStatement();
            this.statement.execute(this.sql);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao excluir usuario");
            return false;
        }
    }
}