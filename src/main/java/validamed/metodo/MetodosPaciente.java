package validamed.metodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    public void loginPaciente(Paciente loginPaciente) {
        
        String sql = "select * from paciente where (nome,senha)" + "values(?,?)";
        
        try (PreparedStatement rq = conn.prepareStatement(sql)){
            rq.setString(1, loginPaciente.getNomePaciente());
            rq.setString(2, loginPaciente.getSenhaPaciente());
            
            rq.execute();
            rq.close();
            
            JOptionPane.showMessageDialog(null, "Login com Sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao realizar login" + e.getMessage());
        }
    }
}
