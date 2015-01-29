/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import facade.VendaFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Saida;
import model.Venda;

/**
 *
 * @author wolverine
 */
public class VendaController {
    
    VendaFacade vendaFacade;
    
    
    //Vendas
    public Venda ultimaVendaGravada() {
        vendaFacade = new VendaFacade();
        try {
            return vendaFacade.ultimaVendaGravada();
        } catch (Exception ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Ultima Venda " + ex);
            return null;
        }
    }
    
    
    
    
    
    //Saida
    public List<Saida> listarSaidaVenda(int idVenda){
        vendaFacade = new VendaFacade();
        try {
            return vendaFacade.listarSaidaVenda(idVenda);
        } catch (Exception ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar saída venda " + ex);
            return null;
        }
    }
}
