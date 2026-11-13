package validamed.metodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import validamed.Paciente;
import validamed.connect.ConnectFactory;

public class MetodosPaciente {
    
    private Connection conn;
    
    public MetodosPaciente() {
        this.conn = new ConnectFactory().getConnection();
    }
    
    public void cadastrarPaciente(Paciente novoPaciente) {
        
        String sql = "insert into paciente(nome, senha, idade, sexo)" + "values(?,?,?,?)";
        
        try (PreparedStatement rq = conn.prepareStatement(sql)){
            rq.setString(1, novoPaciente.getNomePaciente());
            rq.setString(2, novoPaciente.getSenhaPaciente());
            rq.setInt(3, novoPaciente.getIdadePaciente());
            rq.setString(4, novoPaciente.getSexoPaciente());
            
            rq.execute();
            rq.close();
            
            System.out.println("Novo paciente cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o Paciente" + e.getMessage());
        } 
    }
    
    public boolean loginPaciente(Paciente loginPaciente) {
        
        String sql = "select * from paciente where nome = ? and senha = ?";
        
        try (PreparedStatement rq = conn.prepareStatement(sql)){
            rq.setString(1, loginPaciente.getNomePaciente());
            rq.setString(2, loginPaciente.getSenhaPaciente());
            
         try (ResultSet rs = rq.executeQuery()) {
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login com Sucesso!");
                return true;   // achou o usuário: login válido
                 
            } else {
                JOptionPane.showMessageDialog(null, "Nome ou senha incorretos.");
                return false;  // não achou
            }
            }
            
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao realizar login" + e.getMessage());
          return false;
        }
    }
}
