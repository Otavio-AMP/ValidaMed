package validamed.Metodos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import validamed.Paciente;
import validamed.connect.ConnectFactory;

/**
 *
 * @author aster
 */
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
            
            JOptionPane.showMessageDialog(null, "Novo paciente cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o Paciente");
        } 
    }
    
    public void loginPaciente(Paciente novoPaciente) {
        
        String sql = "select paciente where" + "values(?,?,?,?)";
        
        try {
            
        } catch (Exception e) {
        }
    }
}
