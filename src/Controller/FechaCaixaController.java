/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.FechaCaixaDao;
import facade.FechaCaixaFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Fechacaixa;

/**
 *
 * @author wolverine
 */
public class FechaCaixaController {
    private FechaCaixaFacade fechaCaixaFacade;

    public Fechacaixa salvar(Fechacaixa fechaCaixa) {
        fechaCaixaFacade = new FechaCaixaFacade();
        try {
            return fechaCaixaFacade.salvar(fechaCaixa);
        } catch (Exception ex) {
            Logger.getLogger(FechaCaixaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Fechamento Caixa " + ex);
            return null;
        }
    }
    
    public Fechacaixa getFechaCaixa(String caixa, int idUsuario) {
        fechaCaixaFacade = new FechaCaixaFacade();
        try {
            return fechaCaixaFacade.getFechaCaixa(caixa, idUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(FechaCaixaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Pesquisar Fechamento do Caixa "  +ex);
            return null;
        }
    }

    public Fechacaixa getFechaCaixa(int idFechaCaixa) {
        fechaCaixaFacade = new FechaCaixaFacade();
        try {
            return fechaCaixaFacade.getFechaCaixa(idFechaCaixa);
        } catch (SQLException ex) {
            Logger.getLogger(FechaCaixaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Pesquisar Fechamento Caixa "  + ex);
            return null;
        }
    }
}
