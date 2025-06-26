package org.sis.dao;

import org.sis.model.GrupoCartao;
import org.sis.util.ConectaBDPostgres;
import java.sql.*;
import java.util.ArrayList;

public class Grupo_cartaoDAO {

    private String sql;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private boolean status;

    public ArrayList<GrupoCartao> getGrupoCartoes(){
        ConectaBDPostgres cdb = new ConectaBDPostgres();
        ArrayList<GrupoCartao> gpc = new ArrayList<>();
        try{
            Statement stmt = cdb.getConexao().createStatement();
            ResultSet rs =  stmt.executeQuery("SELECT * FROM grupo_cartao");

            while(rs.next()){
                GrupoCartao gc =
                        new GrupoCartao(
                        rs.getInt("id_grupo_cartao"),
                        rs.getString("nome_grupo"),
                        rs.getBoolean("gratuito"));
                gpc.add(gc);

            }
        }catch (SQLException e){
            System.out.println("Erro ao usar getGrupocartoes");
            e.printStackTrace();
        }
        return gpc;
    }
    public GrupoCartao getgrupocartao(int id){
        GrupoCartao gc = null;
        try(Connection conn = new ConectaBDPostgres().getConexao()){
            this.sql = "SELECT * FROM grupo_cartao where id_grupo_cartao = ?";
            this.preparedStatement =conn.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.executeQuery();
            while(this.resultSet.next()){
                gc =
                        new GrupoCartao(
                                this.resultSet.getInt("id_grupo_cartao"),
                                this.resultSet.getString("nome_grupo"),
                                this.resultSet.getBoolean("gratuito"));

            }
        }catch (SQLException e){
            System.out.println("Erro ao usar getGrupocartao com id");
            e.printStackTrace();
        }
        return gc;
    }

}
