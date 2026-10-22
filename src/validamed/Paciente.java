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
    private String nomePaciente;
    private int idadePaciente;
    private String sexoPaciente;
    private Receita dadosReceita;
    
    public Paciente(String nomePaciente,int idadePaciente, String sexoPaciente) {
        this.nomePaciente = nomePaciente;
        this.idadePaciente = idadePaciente;
        this.sexoPaciente = sexoPaciente;
    }
    
    public void getPaciente() {
        System.out.println("-Apresentação do paciente-");
        System.out.println("Nome: " + nomePaciente);
        System.out.println("Idade: " + idadePaciente);
        System.out.println("Sexo: " + sexoPaciente);
    }
}
