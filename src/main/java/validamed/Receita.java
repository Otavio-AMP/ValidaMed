/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validamed;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author aster
 */
public class Receita {
    private int idReceita;
    private String textoData;
    private LocalDate dataEmissao;
    private int crmDoMedico;
    private boolean carimbo;
    private Medicamento[] medicamentos;
    
    DateTimeFormatter formatoDataReceita = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Receita(int idReceita, String textoData ,int crmDoMedico, boolean carimbo, Medicamento[] medicamentos) {
        this.idReceita = idReceita;
        this.textoData = textoData;
        this.dataEmissao = LocalDate.parse(textoData, formatoDataReceita);
        this.crmDoMedico = crmDoMedico;
        this.carimbo = carimbo;
        this.medicamentos = medicamentos;
    }
    
    public Receita(){
        
    }
    
    public int getIdReceita(){
        return this.idReceita;
    }
    
    public LocalDate getDataEmissao(){
        return this.dataEmissao;
    }
    
    public int getCRMDoMedico(){
       return this.crmDoMedico; 
    }
    
    public boolean getCarimbo(){
        return this.carimbo;
    }
    
    public void showDadosDaReceita(){
        System.out.println("-Dados da Receita-");
        System.out.println("Data da Receita: " + dataEmissao);
        System.out.println("CRM do Medico: " + crmDoMedico);
        System.out.println("Lista de Medicamentos {");
        for(int i = 0; i < medicamentos.length; i++){
            medicamentos[i].getNome();
            medicamentos[i].getConcentracao();
            medicamentos[i].getDias();
            medicamentos[i].getComprimidos();
        }
        System.out.println("}");
        if(carimbo){
            System.out.println("Receita carimbada");
        }else{
            System.out.println("Receita sem carimbo, não valida");
        }
    }
}
