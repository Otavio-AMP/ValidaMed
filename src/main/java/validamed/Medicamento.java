/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validamed;

import java.time.LocalDate;

/**
 *
 * @author aster
 */
public class Medicamento {
    private String nome;
    private LocalDate dataEmissao;
    private int comprimidos;
    private int intervalos;
    private int dias;
    
    public Medicamento(String nome, LocalDate dataEmissao, int comprimidos, int intervalos, int dias){
        this.nome = nome;
        this.dataEmissao = dataEmissao;
        this.comprimidos = comprimidos;
        this.intervalos = intervalos;
        this.dias = dias;
    }
    
    public Medicamento(){
        
    }
    
    public String getNome(){
        return this.nome;
    }
    public String setNome(String medicamento){
       return this.nome = medicamento;
    }
    public int setComprimidos(int comprimidos){
        return this.comprimidos = comprimidos;
    }
    public int setDias(int dias){
        return this.dias = dias;
    }
    public int getIntervalos() {
        return this.intervalos;
    }
    public int getComprimidos(){
       return this.comprimidos;
    }
    public int getTotalComprimidos(){
        return this.comprimidos * this.dias;
    }
    public int getDias(){
        return this.dias;
    }
}
