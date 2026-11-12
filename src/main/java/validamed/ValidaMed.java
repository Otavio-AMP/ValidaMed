/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package validamed;

import validamed.telausuario.*;

/**
 *
 * @author aster
 */
public class ValidaMed {

    
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrontValidaMed tela = new FrontValidaMed();
                tela.setVisible(false);
                
                CadastroValidaMed telaCadastro = new CadastroValidaMed();
                telaCadastro.setVisible(true);
                
                LoginValidaMed telaLogin = new LoginValidaMed();
                telaLogin.setVisible(false);
            }
        });
    }
}
