/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import facade.BandeiraCartaoFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Bandeirascartao;

/**
 *
 * @author wolverine
 */
public class BandeiraCartaoController {
    
    BandeiraCartaoFacade bandeiraCartaoFacade;
    
    public List<Bandeirascartao> listarBandeirasCartao() {
        bandeiraCartaoFacade = new BandeiraCartaoFacade();
        try {
            return bandeiraCartaoFacade.listarBandeirasCartao();
        } catch (SQLException ex) {
            Logger.getLogger(BandeiraCartaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Bandeiras Cartão " + ex);
            return null;
        }
    }
}
