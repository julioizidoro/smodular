/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import facade.FormaPagamentoFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Formapagamento;

/**
 *
 * @author wolverine
 */
public class FormaPagamentoController {
    
    FormaPagamentoFacade formaPagamentoFacade;
    
    public List<Formapagamento> getFormaPagamento() {
        formaPagamentoFacade = new FormaPagamentoFacade();
        try {
            return formaPagamentoFacade.getFormaPagamento();
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Forma de Pagamento " + ex);
            return null;
        }
    }
    
    public Formapagamento getFormapagamento(int idFormaPagamento) {
        formaPagamentoFacade = new FormaPagamentoFacade();
        try {
            return formaPagamentoFacade.getFormapagamento(idFormaPagamento);
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Forma de Pagamento " + ex);
            return null;
        }
    }
    
    public List<Formapagamento> getFormaPagamentoBandeiraCartao(int idBandeiraCartao) {
        formaPagamentoFacade = new FormaPagamentoFacade();
        try {
            return formaPagamentoFacade.getFormaPagamentoBandeiraCartao(idBandeiraCartao);
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Forma Pagamento Bandeira Cartão "+ ex);
            return null;
        }
    }
    
    public Formapagamento salvarFormapagamento(Formapagamento formaPagamento) {
        formaPagamentoFacade = new FormaPagamentoFacade();
        try {
            return formaPagamentoFacade.salvarFormapagamento(formaPagamento);
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Forma Pagamento " + ex);
            return null;
        }
    }
    
    public List<Formapagamento> listarFormaPagamentoValor() {
        formaPagamentoFacade = new FormaPagamentoFacade();
        try {
            return formaPagamentoFacade.listarFormaPagamentoValor();
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Eror Listar Forma Pagamento Valor " + ex);
            return null;
        }
    }
    
}
