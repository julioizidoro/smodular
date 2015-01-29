/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import dao.ContasReceberDao;
import facade.ContasReceberFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author Wolverine
 */
public class ContasReceberController {
    
    ContasReceberFacade contasReceberFacade;
    
     // operações Contas Receber
    
    public Contasreceber salvarContasReceber(Contasreceber contasReceber) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.salvarContasReceber(contasReceber);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Salvar Contas a Receber " + ex);
            return null;
        }
    }
    
    public Contasreceberpagamento salvarContasReceberPagamento(Contasreceberpagamento contasReceberPagamento) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.salvarContasReceberPagamento(contasReceberPagamento);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Contas Receber Pagamento " + ex);
            return null;
        }
    }
    
    public Contasreceberforma salvarContasReceberForma(Contasreceberforma contasReceberForma) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.salvarContasReceberForma(contasReceberForma);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro salvar Forma Contas Receber " + ex);
            return null;
        }
    }
    
    public void excluirContasReceber(Contasreceber contasReceber) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            contasReceberFacade.excluirContasReceber(contasReceber);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Excluir Contas a Receber " + ex);
        }
    }
    
    public List<Contasreceber> listarContas(String sql) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.listarContas(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Consultar Contas Receber " + ex);
            return null;
        }
    }
    
    // operações Fatura
    
    public Faturasreceber salvarFatura(Faturasreceber faturaReceber) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.salvarFatura(faturaReceber);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Salvar Fatura " + ex);
            return null;
        }
    }
    
    public void excluirFatura(Faturasreceber faturaReceber) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            contasReceberFacade.excluirFatura(faturaReceber);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Excluir Fatura " + ex);
        }
    }
    
       
    public List<Faturasreceber> listarFaturas(String sql) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.listarFaturas(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Consultar Fatura " + ex);
            return null;
        }
    }
    
    public Faturasreceber buscarFaturaReceber(int idFatura) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.buscarFaturaReceber(idFatura);
        } catch (SQLException ex) {
             Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Consultar Fatura " + ex);
            return null;
        }
    }
    
    
    // operacoes Parcela Fatura
    
    public Faturasreceberparcelas salvarFaturaParcela(Faturasreceberparcelas faturasReceberParcelas) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.salvarFaturaParcela(faturasReceberParcelas);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Salvar Parcela Fatura " + ex);
            return null;
        }
    }
    
    public void excluirFaturaParcela(Faturasreceberparcelas faturasReceberParcelas) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            contasReceberFacade.excluirFaturaParcela(faturasReceberParcelas);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Excluir Parcela Fatura " + ex);
        }
    }
    
    public List<Faturasreceberparcelas> listarFaturasParcelas(String sql) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.listarFaturasParcelas(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Consultar Parcela Fatura " + ex);
            return null;
        }
    }
    
    public List<Contasreceberpagamento> consultarContasReceberPagamento(int idFechaCaixa) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.consultarContasReceberPagamento(idFechaCaixa);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, "Erro Consultar Pagamento Contas a Receber " + ex);
            return null;
        }
    }
    
    public List<Contasreceberforma> consultarFormaPagamento(int idContasReceberPagamento, String forma) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.consultarFormaPagamento(idContasReceberPagamento, forma);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consulta Forma de Pagamento " + ex);
            return null;
        }
    }
    
    public Float valorFormaPagamento(int idFormaPagamento, int idFechaCaixa) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.valorFormaPagamento(idFormaPagamento, idFechaCaixa);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Contas Recebre Forma Pagamento " +ex);
            return 0.0f;
        }
    }
    
    public void excluirContasReceberProduto(Contasreceberprodutos produto) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            contasReceberFacade.excluirContasReceberProduto(produto);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir Produto " + ex);
        }
    }
    
    public List<Contasreceberprodutos> listaContasReceberProdutos(int idContasReceber) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.listaContasReceberProdutos(idContasReceber);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Produtos " + ex);
            return null;
        }
    }
    
    public Contasreceberprodutos salvarContasReceberProduto(Contasreceberprodutos contasReceberProduto) {
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.salvarContasReceberProduto(contasReceberProduto);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro salvar Contas Receber Produto " + ex);
            return null;
        }
    }
    
    public Contasreceber getContasReceber(int idContasReceber){
        contasReceberFacade = new ContasReceberFacade();
        try {
            return contasReceberFacade.getContasReceber(idContasReceber);
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro Consultar Contas a Receber " + ex);
            return null;
        }
    }
}
