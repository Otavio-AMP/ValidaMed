/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validamed;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author aster
 */
public class Receita {
    private String textoData;
    private LocalDate dataEmissao;
    private int crmDoMedico;
    private boolean carimbo;
    private Medicamento[] medicamentos;
    
    DateTimeFormatter formatoDataReceita = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Receita(String textoData, int crmDoMedico, boolean carimbo,Medicamento[] medicamentos) {
        this.textoData = textoData;
        this.dataEmissao = LocalDate.parse(textoData, formatoDataReceita);
        this.crmDoMedico = crmDoMedico;
        this.carimbo = carimbo;
        this.medicamentos = medicamentos;
    }
    
    public void getDadosDaReceita(){
        System.out.println("-Dados da Receita-");
        System.out.println("Data da Receita: " + dataEmissao);
        System.out.println("CRM do Medico: " + crmDoMedico);
        for(int i = 0; i < medicamentos.length; i++){
            System.out.print("{Nome:"+ medicamentos[i].nome);
            System.out.print(medicamentos[i].concentracao + "mg ");
            System.out.println("Total de comprimidos:" + medicamentos[i].comprimidos * medicamentos[i].dias + "}");  
        }
        if(carimbo){
            System.out.println("Receita carimbada");
        }else{
            System.out.println("Receita sem carimbo, não valida");
        }
    }
}
