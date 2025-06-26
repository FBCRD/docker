package org.sis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class ConectaBDPostgres {
    //declara as variaveis com informações para entrar no banco de dados
    private static final String Driver = "org.postgresql.Driver";
    private static final String Url = "jdbc:postgresql://localhost:5432/sistema";
    private static final String Name = "postgres";
    private static final String Senha = "1228";

    //Metodo responsavel por obter uma conexão com o banco de dados PostgreSQl
    public Connection getConexao(){
        try {
            //carrega a classe do driver
            Class.forName(this.Driver);

            //estabelece conexão com o banco de dados
            Connection conn = DriverManager.getConnection(this.Url, this.Name, this.Senha);
            return conn;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
