/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ContasReceberDao;
import java.sql.SQLException;
import java.util.List;
import model.*;

/**
 *
 * @author Wolverine
 */
public class ContasReceberFacade {
    
    ContasReceberDao contasReceberDao;
    
    // operações Contas Receber
    
    public Contasreceber salvarContasReceber(Contasreceber contasReceber) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.salvarContasReceber(contasReceber);
    }
    
    public Contasreceberpagamento salvarContasReceberPagamento(Contasreceberpagamento contasReceberPagamento) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.salvarContasReceberPagamento(contasReceberPagamento);
    }
    
    public Contasreceberforma salvarContasReceberForma(Contasreceberforma contasReceberForma) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.salvarContasReceberForma(contasReceberForma);
    }
    
    public void excluirContasReceber(Contasreceber contasReceber) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        contasReceberDao.excluirContasReceber(contasReceber);
    }
    
    public List<Contasreceber> listarContas(String sql) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.listarContas(sql);
    }
    
    // operações Fatura
    
    public Faturasreceber salvarFatura(Faturasreceber faturaReceber) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.salvarFatura(faturaReceber);
    }
    
    public void excluirFatura(Faturasreceber faturaReceber) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        contasReceberDao.excluirFatura(faturaReceber);
    }
    
       
    public List<Faturasreceber> listarFaturas(String sql) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.listarFaturas(sql);
    }
    
    public Faturasreceber buscarFaturaReceber(int idFatura) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.buscarFaturaReceber(idFatura);
    }
    
    
    // operacoes Parcela Fatura
    
    public Faturasreceberparcelas salvarFaturaParcela(Faturasreceberparcelas faturasReceberParcelas) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.salvarFaturaParcela(faturasReceberParcelas);
    }
    
    public void excluirFaturaParcela(Faturasreceberparcelas faturasReceberParcelas) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        contasReceberDao.excluirFaturaParcela(faturasReceberParcelas);
    }
    
    public List<Faturasreceberparcelas> listarFaturasParcelas(String sql) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.listarFaturasParcelas(sql);
    }
    
    public List<Contasreceberpagamento> consultarContasReceberPagamento(int idFechaCaixa) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.consultarContasReceberPagamento(idFechaCaixa);
    }
    
    public List<Contasreceberforma> consultarFormaPagamento(int idContasReceberPagamento, String forma) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.consultarFormaPagamento(idContasReceberPagamento, forma);
    }
    
    public Float valorFormaPagamento(int idFormaPagamento, int idFechaCaixa) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.valorFormaPagamento(idFormaPagamento, idFechaCaixa);
    }
    
    public void excluirContasReceberProduto(Contasreceberprodutos produto) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        contasReceberDao.excluirContasReceberProduto(produto);
    }
    
    public List<Contasreceberprodutos> listaContasReceberProdutos(int idContasReceber) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.listaContasReceberProdutos(idContasReceber);
    }
    
    public Contasreceberprodutos salvarContasReceberProduto(Contasreceberprodutos contasReceberProduto) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.salvarContasReceberProduto(contasReceberProduto);
    }
    
    public Contasreceber getContasReceber(int idContasReceber) throws SQLException{
        contasReceberDao = new ContasReceberDao();
        return contasReceberDao.getContasReceber(idContasReceber);
    }
    
}
