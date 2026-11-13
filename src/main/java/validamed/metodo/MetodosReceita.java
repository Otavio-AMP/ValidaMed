package validamed.metodo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import validamed.Paciente;
import validamed.connect.ConnectFactory;


public class MetodosReceita {
    
    private Connection conn;
    
    public MetodosReceita(){
        this.conn = new ConnectFactory().getConnection();
    }
    
    public void cadastrarReceita(){
        
    }
}
