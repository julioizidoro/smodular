/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import facade.ControleChequeFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Chequefechacaixa;
import model.Chequemovbanco;
import model.Chequemovcaixa;
import model.Contolechequefornecedor;
import model.Controlecheques;

/**
 *
 * @author wolverine
 */
public class ControleChequeController {
    
    ControleChequeFacade controleChequeFacade;
    
    public Controlecheques salvarCehque(Controlecheques cheque)  {
        controleChequeFacade = new ControleChequeFacade();
        try {
            return controleChequeFacade.salvarCehque(cheque);
        } catch (Exception ex) {
            Logger.getLogger(ControleChequeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Cheque " + ex);
            return null;
        }
    }
    
    public List<Controlecheques> listarCheques(String sql) {
        controleChequeFacade = new ControleChequeFacade();
        try {
            return controleChequeFacade.listarCheques(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ControleChequeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Lstar Cheques " + ex);
            return null;
        }
    }
    
    public List<Contolechequefornecedor> consultarFornecedor(int idForneceodr) {
        controleChequeFacade = new ControleChequeFacade();
        try {
            return controleChequeFacade.consultarFornecedor(idForneceodr);
        } catch (SQLException ex) {
            Logger.getLogger(ControleChequeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Cheque Fornecedor " + ex);
            return null;
        }
    }
    
    public void salvarFornecedor(Contolechequefornecedor fornecedor)  {
        controleChequeFacade = new ControleChequeFacade();
        try {
            controleChequeFacade.salvarFornecedor(fornecedor);
        } catch (Exception ex) {
            Logger.getLogger(ControleChequeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Cheque Fornecedor "  + ex);
        }
    }
    
    public Controlecheques consultarCheque(int idControleCheques) {
        controleChequeFacade = new ControleChequeFacade();
        try {
            return controleChequeFacade.consultarCheque(idControleCheques);
        } catch (SQLException ex) {
            Logger.getLogger(ControleChequeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Cheque " + ex);
            return null;
        }
    }
    
    public Contolechequefornecedor consultarFornecedorCheque(int idControleCheques) {
        controleChequeFacade = new ControleChequeFacade();
        try {
            return controleChequeFacade.consultarFornecedorCheque(idControleCheques);
        } catch (SQLException ex) {
            Logger.getLogger(ControleChequeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Cheuqe Fornecedor " + ex);
            return null;
        }
    }
    
    public Chequefechacaixa salvarCehqueFechaCaixa(Chequefechacaixa chequeFechaCaixa) {
        controleChequeFacade = new ControleChequeFacade();
        try {
            return controleChequeFacade.salvarCehqueFechaCaixa(chequeFechaCaixa);
        } catch (SQLException ex) {
            Logger.getLogger(ControleChequeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Cheque no Fechamento Caixa " + ex);
            return null;
        }
    }
    
    public Chequemovbanco salvarChequeMovBanco(Chequemovbanco chequeMovBanco) {
        controleChequeFacade = new ControleChequeFacade();
        try {
            return controleChequeFacade.salvarChequeMovBanco(chequeMovBanco);
       } catch (SQLException ex) {
            Logger.getLogger(ControleChequeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Cheque no Movimento de Banco " + ex);
            return null;
        }
    }
    
    public Chequemovcaixa salvarChequeMovCaixa(Chequemovcaixa chequeMovCaixa) {
        controleChequeFacade = new ControleChequeFacade();
        try {
            return controleChequeFacade.salvarChequeMovCaixa(chequeMovCaixa);
        } catch (SQLException ex) {
            Logger.getLogger(ControleChequeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Cheque no Moviemnto de Caixa " + ex);
            return null;
        }
    }
    
    public List<Chequefechacaixa>  ListaChequesCaixa(int idFechaCaixa) {
        controleChequeFacade = new ControleChequeFacade();
        try {
            return controleChequeFacade.ListaChequesCaixa(idFechaCaixa);
        } catch (SQLException ex) {
            Logger.getLogger(ControleChequeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar cheques do Caixa " + ex);
            return null;
        }
    }
    
    public Controlecheques listarChequesid(int idFechaCaixa) {
        controleChequeFacade = new  ControleChequeFacade();
        try {
            return controleChequeFacade.listarChequesid(idFechaCaixa);
        } catch (SQLException ex) {
            Logger.getLogger(ControleChequeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Cheques " + ex);
            return null;
        }
    }
    
    public void excluirControleCheque(Controlecheques controlecheques){
        controleChequeFacade = new ControleChequeFacade();
        try {
            controleChequeFacade.excluirControleCheque(controlecheques);
        } catch (Exception ex) {
            Logger.getLogger(ControleChequeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir Controle de Cehque " + ex);
        }
    }
    
    public void excluirControleChequeFechaCaixa(Chequefechacaixa chequefechacaixa) {
        controleChequeFacade = new ControleChequeFacade();
        try {
            controleChequeFacade.excluirControleChequeFechaCaixa(chequefechacaixa);
        } catch (Exception ex) {
            Logger.getLogger(ControleChequeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir Cehque do Caixa " + ex);
        }
    }
    
    public Chequefechacaixa  ListaChequesCaixaid(int idControleCheque) {
        controleChequeFacade = new ControleChequeFacade();
        try {
            return controleChequeFacade.ListaChequesCaixaid(idControleCheque);
        } catch (Exception ex) {
            Logger.getLogger(ControleChequeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Cheque Caixa " + ex);
            return null;
        }
    }

}
