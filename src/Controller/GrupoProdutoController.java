/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import facade.GrupoProdutoFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Grupoproduto;
import model.Subgrupoproduto;

/**
 *
 * @author Wolverine
 */
public class GrupoProdutoController {
    
    public Subgrupoproduto consultarSubGrupoProduto(int idSubGrupo) {
        GrupoProdutoFacade grupoProdutoFacade = new GrupoProdutoFacade();
        try {
            return grupoProdutoFacade.consultarSubGrupoProduto(idSubGrupo);
        } catch (SQLException ex) {
            Logger.getLogger(GrupoProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar Subgrupo de Produto " + ex);
            return null;
        }
    }
    
    public Grupoproduto consultarGrupoProduto(int idGrupo) {
        GrupoProdutoFacade grupoProdutoFacade = new GrupoProdutoFacade();
        try {
            return grupoProdutoFacade.consultarGrupoProduto(idGrupo);
        } catch (SQLException ex) {
            Logger.getLogger(GrupoProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Consultar Subgrupo Produto " + ex);
            return null;
        }
    }
    
}
