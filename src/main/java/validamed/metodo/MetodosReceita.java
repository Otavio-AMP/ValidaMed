package validamed.metodo;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import validamed.*;
import validamed.connect.ConnectFactory;


public class MetodosReceita {
    
    private Connection conn;
    
    public MetodosReceita(){
        this.conn = new ConnectFactory().getConnection();
    }
    
    
    
    public boolean cadastrarReceita(Paciente loginPaciente, Receita novaReceita, Medicamento[] novoMedicamento){
        String sql = "insert into receita(id_paciente, data_emissao, crm_medico, carimbo)" + "values(?,?,?,?)";
        String sql2 = "insert into medicamento(id_receita, nome, comprimidos, dias)" + "values(?,?,?,?)";
        
        try {
            conn.setAutoCommit(false);

            int idReceita;
            try (PreparedStatement rq = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                rq.setInt(1, loginPaciente.getIdPaciente());
                rq.setDate(2, Date.valueOf(novaReceita.getDataEmissao()));
                rq.setInt(3, novaReceita.getCRMDoMedico());
                rq.setBoolean(4, novaReceita.getCarimbo());
                rq.executeUpdate();

                try (ResultSet rs = rq.getGeneratedKeys()) {
                    rs.next();
                    idReceita = rs.getInt(1);
                }
            }
            try (PreparedStatement rq2 = conn.prepareStatement(sql2)) {
                for (Medicamento m : novoMedicamento) {
                    rq2.setInt(1, idReceita);
                    rq2.setString(2, m.getNome());
                    rq2.setInt(3, m.getComprimidos());
                    rq2.setInt(4, m.getDias());
                    rq2.addBatch();
                }
                rq2.executeBatch();
            }
            conn.commit();
            return true;
        } catch (Exception e) {
           try { conn.rollback(); } catch (SQLException ignored) { }
            JOptionPane.showMessageDialog(null,
                    "Erro ao cadastrar a receita no Banco de dados " + e.getMessage());
            return false;
        }finally {
            try { conn.setAutoCommit(true); } catch (SQLException ignored) { }
        }  
    }
    
    public Receita[] exibirReceita(Paciente loginPaciente){
        
        String sql = "SELECT id, data_emissao, crm_medico, carimbo "
               + "FROM receita WHERE id_paciente = ? "
               + "ORDER BY data_emissao DESC, id DESC";

        List<Receita> lista = new ArrayList<>();

        try (PreparedStatement rq = conn.prepareStatement(sql)) {
            rq.setInt(1, loginPaciente.getIdPaciente());

            try (ResultSet rs = rq.executeQuery()) {
                while (rs.next()) {
                    Receita r = new Receita();
                    r.setIdReceita(rs.getInt("id"));
                    r.setDataEmissao(rs.getDate("data_emissao").toLocalDate());
                    r.setCRMDoMedico(rs.getInt("crm_medico"));
                    r.setCarimbo(rs.getBoolean("carimbo"));
                    lista.add(r);
                }
            }
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao puxar dados " + e.getMessage());
    }

    return lista.toArray(new Receita[0]);
        
    }
    public Medicamento[] exibirMedicamentos(int idReceita) {

        String sql = "SELECT nome, comprimidos, dias FROM medicamento WHERE id_receita = ?";

        List<Medicamento> lista = new ArrayList<>();

        try (PreparedStatement rq = conn.prepareStatement(sql)) {
            rq.setInt(1, idReceita);

            try (ResultSet rs = rq.executeQuery()) {
                while (rs.next()) {
                    Medicamento m = new Medicamento();
                    m.setNome(rs.getString("nome"));
                    m.setComprimidos(rs.getInt("comprimidos"));
                    m.setDias(rs.getInt("dias"));
                    lista.add(m);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao puxar medicamentos " + e.getMessage());
        }
        return lista.toArray(new Medicamento[0]);
    }
}