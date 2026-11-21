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
    
    public Paciente(String nomePaciente, String senhaPaciente){
        this.nomePaciente = nomePaciente;
        this.senhaPaciente = senhaPaciente;
    }
    
    public Paciente(){
        
    }
    
    public int getIdPaciente() {
        return this.id;
    }
    public int setIdPaciente(int idPaciente){
        return this.id = idPaciente;
    }
    public String getNomePaciente(){
        return this.nomePaciente;
    }
    public String setNomePaciente(String nomePaciente){
        return this.nomePaciente = nomePaciente;
    }
    public String getSenhaPaciente(){
        return this.senhaPaciente;
    }
    public String setSenhaPaciente(String senhaPaciente){
        return this.senhaPaciente = senhaPaciente;
    }
    public int getIdadePaciente(){
        return this.idadePaciente; 
    }
    public int setIdadePaciente(int idadePaciente){
        return this.idadePaciente = idadePaciente;
    }
    public String getSexoPaciente() {
        return this.sexoPaciente;
    }
    public String setSexoPaciente(String sexoPaciente){
        return this.sexoPaciente = sexoPaciente;
    }
    public Receita getReceita(){
       return this.dadosReceita;
    }
}
