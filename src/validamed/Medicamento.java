/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validamed;

/**
 *
 * @author aster
 */
public class Medicamento {
    private String nome;
    private int concentracao;
    private int comprimidos;
    private int intervalos;
    private int dias;
    
    public Medicamento(String nome, int concentracao, int comprimidos, int intervalos, int dias){
        this.nome = nome;
        this.concentracao = concentracao;
        this.comprimidos = comprimidos;
        this.intervalos = intervalos;
        this.dias = dias;
    }
    
    public String getNome(){
        return this.nome;
    }
    public int getConcentracao(){
        if(concentracao >= 1000){
            return this.concentracao/100;
        }else{
            return this.concentracao;
        } 
    }
    public int getIntervalos() {
        return this.intervalos;
    }
    public int getComprimidos(){
       return this.comprimidos * this.dias;
    }
    public int getDias(){
        return this.dias;
    }
}
