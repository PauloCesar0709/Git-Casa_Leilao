
package main;

import cadastro.CadastroVIEW;
import javax.swing.SwingUtilities;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->  {
        CadastroVIEW tela = new CadastroVIEW();
        tela.setVisible(true);
        });
    }
}
