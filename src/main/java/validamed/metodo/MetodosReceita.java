package validamed.metodo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import javax.swing.JOptionPane;
import validamed.*;
import validamed.connect.ConnectFactory;


public class MetodosReceita {
    
    private Connection conn;
    
    public MetodosReceita(){
        this.conn = new ConnectFactory().getConnection();
    }
    
    public void cadastrarReceita(Paciente loginPaciente, Receita novaReceita, Medicamento[] novoMedicamento){
        String sql = "insert into receita(id_paciente, data_emissao, crm_medico, carimbo)" + "values(?,?,?,?)";
        String sql2 = "insert into medicamento(id_receita, nome, comprimidos, dias)" + "values(?,?,?,?)";
        
        try (PreparedStatement rq = conn.prepareCall(sql)){
            rq.setInt(1, loginPaciente.getIdPaciente());
            rq.setDate(2, Date.valueOf(novaReceita.getDataEmissao()));//AJUSTAR TIPO DATA NA CLASSE RECEITA
            rq.setInt(3, novaReceita.getCRMDoMedico());
            rq.setBoolean(4, novaReceita.getCarimbo());
            
            rq.execute();
            rq.close();
            for(int i = 0; i < novoMedicamento.length; i++){
                try (PreparedStatement rq2 = conn.prepareCall(sql2)){
                rq2.setInt(1, novaReceita.getIdReceita());
                rq2.setString(2, novoMedicamento[i].getNome());
                rq2.setInt(3, novoMedicamento[i].getComprimidos());
                rq2.setInt(4, novoMedicamento[i].getDias());
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar os medicamentos no Banco de Dados " + e.getMessage());
                } 
            }  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar a receita no Banco de dados " + e.getMessage());
        }
    }
    
    public Receita[] exibirReceita(Paciente loginPaciente){
        
        String sql = "select * from receita where id_paciente = ?";
        
        try(PreparedStatement rq = conn.prepareCall(sql)){
            rq.setInt(1, loginPaciente.getIdPaciente());
            
            try (ResultSet rs =  rq.executeQuery()){
                int qtdReceitas = rs.getRow();
                rs.getArray(sql);
                Receita[] todasReceitas = new Receita[qtdReceitas];
                return todasReceitas;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro na resposta da Query" + e.getMessage());
                Receita[] naNReceita = new Receita[0];
                return naNReceita; //Não há Receita a retornar
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao puxar dados " + e.getMessage());
            Receita[] naNReceita = new Receita[0];
            return naNReceita; //Não há Receita a retornar
        }
        
    }
}
