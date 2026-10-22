/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package validamed;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author aster
 */
public class ValidaMed {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inputDados = new Scanner(System.in);

        System.out.println("Insira os dados da receita");
        System.out.println("Data de Emissão: dd/MM/yyyy");
        String textoData = inputDados.nextLine();

        System.out.println("CRM do Medico: ");
        int crmDoMedico = inputDados.nextInt();
        
        System.out.println("A receita está Assinada e/ou Carimbada ? true or false");
        boolean carimbo = inputDados.nextBoolean();
        
        // Consome a quebra de linha pendente
        inputDados.nextLine();
        
        System.out.println("Quais os medicamentos da receita: ");
        String medicamentos = inputDados.nextLine();
        
        System.out.println("Nome do Paciente: ");
        String nomePaciente = inputDados.nextLine();

        System.out.println("Idade do Paciente: ");
        int idadePaciente = inputDados.nextInt();
        
        // Consome a quebra de linha pendente
        inputDados.nextLine();

        System.out.println("Sexo do Paciente: M/F");
        String sexoPaciente = inputDados.nextLine();
        
        inputDados.close();
        
        Receita dadosDaReceita = new Receita(textoData, crmDoMedico, carimbo, medicamentos);
        Paciente dadosPaciente = new Paciente(nomePaciente, idadePaciente, sexoPaciente);
        dadosPaciente.getPaciente();
        dadosDaReceita.getDadosDaReceita();
    }
    
}
