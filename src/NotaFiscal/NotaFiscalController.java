/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NotaFiscal;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Wolverine
 */
public class NotaFiscalController {
    
    NotaFiscalFacade notaFiscalFacade;
    
    public List<Clienteproduto> listaClienteProduto() {
        notaFiscalFacade = new NotaFiscalFacade();
        try {
            return notaFiscalFacade.listaClienteProduto();
        } catch (SQLException ex) {
            Logger.getLogger(NotaFiscalController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Clientes " + ex);
            return null;
        }
    }
    
    public Clienteproduto pesquisarClienteProduto(String nome) {
        notaFiscalFacade = new NotaFiscalFacade();
        try {
            return notaFiscalFacade.pesquisarClienteProduto(nome);
        } catch (SQLException ex) {
            Logger.getLogger(NotaFiscalController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar cliente "  + ex);
            return null;
        }
    }
    
    public Clienteproduto salvarClienteProduto(Clienteproduto clienteProduto) {
        notaFiscalFacade = new NotaFiscalFacade();
        try {
            return notaFiscalFacade.salvarClienteProduto(clienteProduto);
        } catch (SQLException ex) {
            Logger.getLogger(NotaFiscalController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Cliente "+ ex);
            return null;
        }
    }
    
    public void salvarProdutoTemp(Produtotemp produtoTemp) {
        notaFiscalFacade = new NotaFiscalFacade();
        try {
            notaFiscalFacade.salvarProdutoTemp(produtoTemp);
        } catch (SQLException ex) {
            Logger.getLogger(NotaFiscalController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Produto do Cliente " + ex);
        }
    }
    
}
