/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wolverine
 */
public class PortaParalela {
    
    private FileOutputStream fos;
    private PrintStream ps;

    public PortaParalela(String portaParalela) {
        try {
            this.fos = new FileOutputStream(portaParalela);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PortaParalela.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro porta " + portaParalela + "  " + ex);
        }
        try {
            ps = new PrintStream(fos);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro de Saída porta " + portaParalela + "  " + ex);
        }
        
    }
    
    
    public void imprimirPorta(StringBuilder texto){
        ps.print(texto);
        ps.close();
    }
    
    
}
