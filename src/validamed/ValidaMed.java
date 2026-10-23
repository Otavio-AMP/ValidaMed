/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package validamed;
import java.util.*;

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
        
        while (textoData.length() != 10 || textoData.charAt(2) != '/' || textoData.charAt(5) != '/') {
        System.out.println("Data inválida, use o formato dd/mm/yyyy | Exemplo: 23/10/2026");
        textoData = inputDados.nextLine();
        }

        System.out.println("CRM do Medico: ");
        int crmDoMedico = inputDados.nextInt();
        
        System.out.println("A receita está Assinada e/ou Carimbada? (sim/não)");
        String respostaCarimbo = inputDados.next();
        boolean carimbo = respostaCarimbo.equalsIgnoreCase("sim");
        
        System.out.println("Quantos medicamentos existem na receita ?");
        int qtdMedicamentos = inputDados.nextInt();
        
        // Consome a quebra de linha pendente
        inputDados.nextLine();
        
        System.out.println("Quais os medicamentos da receita: ");
        Medicamento[] medicamentos = new Medicamento[qtdMedicamentos];
        for(int i = 0; i < qtdMedicamentos; i++){
           System.out.print("Nome do medicamento: ");
           String nomeMedicamento = inputDados.next();
           System.out.println("Dosagem: (use valor em mg)");
           int concentracaoMedicamento = inputDados.nextInt();
           System.out.println("Comprimidos ao dia:");
           int qtdComprimidos = inputDados.nextInt();
           System.out.println("Qual o intervalos entra cada dose ? (use horas)");
           int intervalosDia = inputDados.nextInt();
           System.out.println("Quantos dias o tratamento ?");
           int diasDeDosagem = inputDados.nextInt();
           medicamentos[i] = new Medicamento(nomeMedicamento, concentracaoMedicamento, qtdComprimidos, intervalosDia, diasDeDosagem);
        }
        
        // Consome a quebra de linha pendente
        inputDados.nextLine();
        
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
        Paciente dadosPaciente = new Paciente(nomePaciente, idadePaciente, sexoPaciente, dadosDaReceita);
        
        dadosPaciente.getPaciente();
        dadosDaReceita.getDadosDaReceita();
    }
    
}
