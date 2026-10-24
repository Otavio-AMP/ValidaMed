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
    
    public void getNome(){
        System.out.print("Nome: " + nome);
    }
    public void getConcentracao(){
        if(concentracao >= 1000){
            System.out.println("1g");
        }else{
            System.out.println(concentracao + "mg");
        } 
    }
    public void getComprimidos(){
        System.out.println("Quantidade de Comprimidos: " + comprimidos * dias);
    }
    public void getDias(){
        System.out.println("Previsão de dias: " + dias);
    }
}
