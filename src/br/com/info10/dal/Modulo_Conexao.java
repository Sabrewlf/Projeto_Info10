
package br.com.info10.dal;

import java.sql.*;

/**
 *
 * @author marco
 */
public class Modulo_Conexao 
{
    //Método para estabelecer a conexão com o banco de dados
    public static Connection conector()
    {
        java.sql.Connection conexao = null;
        //Chamando o driver da biblioteca
        String driver = "com.mysql.jdbc.Driver";
        
        //Armazenando informacoes referentes ao banco de dados
        String url = "jdbc:mysql://localhost:3306/info_10";
        String user = "root";
        String password = "3098431234";
        
        //Estabelecendo a conexão com o banco de dados
        try 
        {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } 
        catch (Exception e) 
        {
            return null;
        }
    }
    
}
