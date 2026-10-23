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
    public String nome;
    public int concentracao;
    public int comprimidos;
    public int intervalos;
    public int dias;
    
    public Medicamento(String nome, int concentracao, int comprimidos, int intervalos, int dias){
        this.nome = nome;
        this.concentracao = concentracao;
        this.comprimidos = comprimidos;
        this.intervalos = intervalos;
        this.dias = dias;
    }
}
