/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import facade.EntregaFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Entrega;

/**
 *
 * @author Julio
 */
public class EntregaController {
    
    EntregaFacade entregaFacade;
    
    public Entrega salvar(int idEntrega, int numeroFechamento) {
        entregaFacade = new EntregaFacade();
        try {
            return entregaFacade.salvar(idEntrega, numeroFechamento);
        } catch (SQLException ex) {
            Logger.getLogger(EntregaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Entrega " + ex);
            return null;
        }
    }
    
}
