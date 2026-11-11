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
public class Paciente {
    private int id;
    private String nomePaciente;
    private String senhaPaciente;
    private int idadePaciente;
    private String sexoPaciente;
    private Receita dadosReceita;
    
    public Paciente(String nomePaciente, String senhaPaciente,int idadePaciente, String sexoPaciente) {
        this.nomePaciente = nomePaciente;
        this.senhaPaciente = senhaPaciente;
        this.idadePaciente = idadePaciente;
        this.sexoPaciente = sexoPaciente;
    }
    
    
    public int getIdPaciente() {
        return this.id;
    }
    public String getNomePaciente(){
        return this.nomePaciente;
    }
    public String getSenhaPaciente(){
        return this.senhaPaciente;
    }
    public int getIdadePaciente(){
        return this.idadePaciente; 
    }
    public String getSexoPaciente() {
        return this.sexoPaciente;
    }
    public Receita getReceita(){
       return this.dadosReceita;
    }
    
    public void showPaciente() {
        System.out.println("-Apresentação do paciente-");
        System.out.println("Nome: " + nomePaciente);
        System.out.println("Idade: " + idadePaciente);
        System.out.println("Sexo: " + sexoPaciente);
    }
}
