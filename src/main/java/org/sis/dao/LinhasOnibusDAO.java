package org.sis.dao;

import org.sis.model.Linhas;
import org.sis.model.Usuario;
import org.sis.util.ConectaBDPostgres;

import java.sql.*;
import java.util.ArrayList;

public class LinhasOnibusDAO {
    private String sql;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String status;

    public ArrayList<Linhas> getLinhas(){

        ConectaBDPostgres cdb = new ConectaBDPostgres();
        ArrayList<Linhas> linhas =new ArrayList<>();
        try{
            this.sql = "select * from usuarioLinha, usuario, linha where usuario.id_usuario=usuariolinha.id_usuario and " +
                    "linha.idLinha=usuariolinha.idLinha";
            this.statement=cdb.getConexao().createStatement();
            this.resultSet = this.statement.executeQuery(this.sql);
            while(this.resultSet.next()){
                Linhas linhas1 = new Linhas(
                        this.resultSet.getInt("idLinha"),
                        this.resultSet.getString("nomeLinha")
                );
                linhas.add(linhas1);
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao usar getLinhas");
        }
        return linhas;
    }
    public ArrayList<Linhas> getLinhas2(int id){

        ConectaBDPostgres cdb = new ConectaBDPostgres();
        ArrayList<Linhas> linhas =new ArrayList<>();
        try(Connection conn = new ConectaBDPostgres().getConexao()){
            this.sql = "select * from usuarioLinha, usuario, linha where usuario.id_usuario=? and usuariolinha.id_usuario=? and " +
                    "linha.idLinha=usuariolinha.idLinha";
            this.preparedStatement = conn.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.setInt(2, id);
            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.executeQuery();
            while(this.resultSet.next()){
                Linhas linhas1 = new Linhas(
                        this.resultSet.getInt("idLinha"),
                        this.resultSet.getString("nomeLinha")
                );
                linhas.add(linhas1);
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao usar getLinhas");
        }
        return linhas;
    }
    public boolean cadastrar(Linhas linhas, Usuario usuario) {

        try (Connection conn = new ConectaBDPostgres().getConexao()) {
            this.sql = "Insert into usuariolinha(idLinha, id_usuario)values(?, ?)";
            this.preparedStatement = conn.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, linhas.getIdLinha());
            this.preparedStatement.setInt(2, usuario.getId_usuario());
            this.preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao cadastrar");
            return false;
        }
        return true;

    }
    public boolean excluir(int id){
        System.out.println("Entrou em excluir");
        this.sql = "Delete from usuariolinha where idlinha= ?";
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





}
