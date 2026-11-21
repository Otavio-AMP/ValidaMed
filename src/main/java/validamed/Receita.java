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
    
    public int setIdReceita(int idReceita){
        return this.idReceita = idReceita;
    }
    
    public LocalDate getDataEmissao(){
        return this.dataEmissao;
    }
    
    public LocalDate setDataEmissao(LocalDate dataEmissao){
        return this.dataEmissao = dataEmissao;
    }
    
    public int getCRMDoMedico(){
       return this.crmDoMedico; 
    }
    
    public int setCRMDoMedico(int crmDoMedico){
        return this.crmDoMedico = crmDoMedico;
    }
    
    public boolean getCarimbo(){
        return this.carimbo;
    }
    
    public boolean setCarimbo(boolean carimbo){
        return this.carimbo = carimbo;
    }
    
}
