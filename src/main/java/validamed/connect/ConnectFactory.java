/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validamed.connect;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.Optional;
/**
 *
 * @author aster
 */
public class ConnectFactory {
    
    static Dotenv dotenv = Dotenv.load();
    static String dbHost = Optional.ofNullable(dotenv.get("DB_URL"))
                        .orElse("localhost");
    static String dbUser = dotenv.get("DB_USERNAME");
    static String dbPass = dotenv.get("DB_PASSWORD");
    
    private static String URL = dbHost;
    private static String USER = dbUser;
    private static String PASSWORD = dbPass;
        
        public Connection getConnection(){


            try {
                System.out.println("Conexão com Database realizada com sucesso!");
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch(SQLException e) {
                System.out.println("Conexão falhou: " + e.getMessage());
                return  null;
            }
        }
}
