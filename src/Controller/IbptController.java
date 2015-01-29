/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import facade.IbptFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Ibpt;

/**
 *
 * @author Wolverine
 */
public class IbptController {
    
    IbptFacade ibptFacade;
    
    public Ibpt cunsultarIbpt(String ncm) {
        ibptFacade = new IbptFacade();
        try {
            return ibptFacade.cunsultarIbpt(ncm);
        } catch (SQLException ex) {
            Logger.getLogger(IbptController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar NCM " + ex);
            return null;
        }
    }
    
}
