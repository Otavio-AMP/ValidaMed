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
        DateTimeFormatter formatoDataReceita = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("Insira os dados da receita");
        System.out.println("Data de Emissão: dd/MMM/yyyy");
        String textoData = inputDados.nextLine();
        LocalDate dataEmissao = LocalDate.parse(textoData, formatoDataReceita);
        
        System.out.println("Nome do Paciente: ");
        String nomePaciente = inputDados.nextLine();
        
        System.out.println("Idade do Paciente: ");
        int idadePaciente = inputDados.nextInt();
        
        System.out.println("Sexo do Paciente: M/F");
        String sexoPaciente = inputDados.nextLine();
        
        System.out.println("CRM do Medico: ");
        int crmDoMedico = inputDados.nextInt();
        
        System.out.println("Quais os medicamentos da receita: ");
        String medicamentos = inputDados.nextLine();
        
        System.out.println("A receita está Assinada e/ou Carimbada ?");
        boolean carimbo = inputDados.nextBoolean();
        
    }
    
}
