/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import facade.ParcelaCartaoFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Parcelacartao;

/**
 *
 * @author wolverine
 */
public class ParcelaCartaoController {
    
    ParcelaCartaoFacade parcelaCartaoFacade;
    
    public void salvar(Parcelacartao parcelaCartao) {
        parcelaCartaoFacade = new ParcelaCartaoFacade();
        try {
            parcelaCartaoFacade.salvar(parcelaCartao);
        } catch (SQLException ex) {
            Logger.getLogger(ParcelaCartaoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Parcela Cartão " + ex);
        }
    }
    
}
