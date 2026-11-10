/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package validamed;

import validamed.telausuario.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import io.github.cdimascio.dotenv.Dotenv;
/**
 *
 * @author aster
 */
public class ValidaMed {

    Dotenv dotenv = Dotenv.load();
    static String apiKey = System.getenv("DB_PASSWORD");
    static String dbHost = Optional.ofNullable(System.getenv("DB_URL"))
                        .orElse("localhost");
    static String dbUser = System.getenv("DB_USERNAME");
    
    private static final String URL = dbHost;
    private static final String USER = dbUser;
    private static final String PASSWORD = apiKey;
    
        public static Connection getConnection(){
            Connection conn = null;

            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexão com Database realizada com sucesso!");
            } catch(SQLException e) {
                    System.out.println("Conexão falhou: " + e.getMessage());
            }
            return conn;
        }
    
    public static void main(String[] args) {
        Connection conn = getConnection();
        
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e){
                System.out.println("Falha ao fechar a conexão: " + e.getMessage());
            }
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrontValidaMed tela = new FrontValidaMed();
                tela.setVisible(false);
                
                CadastroValidaMed telaCadastro = new CadastroValidaMed();
                telaCadastro.setVisible(false);
                
                LoginValidaMed telaLogin = new LoginValidaMed();
                telaLogin.setVisible(false);
            }
        });
    }
}
