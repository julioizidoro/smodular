/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controler.ConexaoSingleton;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Contasreceber;
import model.Contasreceberforma;
import model.Contasreceberpagamento;
import model.Contasreceberprodutos;
import model.Faturasreceber;
import model.Faturasreceberparcelas;

/**
 *
 * @author Wolverine
 */
public class ContasReceberDao {
    
    private EntityManager manager;
    
    // operações Contas Receber
    
    public Contasreceber salvarContasReceber(Contasreceber contasReceber) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        contasReceber = manager.merge(contasReceber);
        manager.getTransaction().commit();
        manager.close();
        return contasReceber;
    }
    
    public Contasreceber getContasReceber(int idContasReceber) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Contasreceber contasReceber = manager.find(Contasreceber.class, idContasReceber);
        //fechando uma transação
        manager.getTransaction().commit();
        return contasReceber;
    }
    
    public Contasreceberpagamento salvarContasReceberPagamento(Contasreceberpagamento contasReceberPagamento) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        contasReceberPagamento = manager.merge(contasReceberPagamento);
        //fechando uma transação
        manager.getTransaction().commit();
        return contasReceberPagamento;
    }
    
    public Contasreceberforma salvarContasReceberForma(Contasreceberforma contasReceberForma) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        contasReceberForma = manager.merge(contasReceberForma);
        //fechando uma transação
        manager.getTransaction().commit();
        return contasReceberForma;
    }
    
    public void excluirContasReceber(Contasreceber contasReceber) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        contasReceber = manager.find(Contasreceber.class, contasReceber.getIdcontasReceber());
        manager.remove(contasReceber);
        //fechando uma transação
        manager.getTransaction().commit();
    }
    
    // operações Fatura
    
    public Faturasreceber salvarFatura(Faturasreceber faturaReceber) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        faturaReceber = manager.merge(faturaReceber);
        //fechando uma transação
        manager.getTransaction().commit();
        return faturaReceber;
    }
    
    public void excluirFatura(Faturasreceber faturaReceber) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        faturaReceber = manager.find(Faturasreceber.class, faturaReceber.getIdFaturasReceber());
        manager.remove(faturaReceber);
        //fechando uma transação
        manager.getTransaction().commit();
    }
    
    public List<Contasreceber> listarContas(String sql) throws SQLException{
        List<Contasreceber> listaContasReceber = new ArrayList<Contasreceber>();
        manager = ConexaoSingleton.getConexao();
        System.out.println(sql);
        Query q = manager.createQuery(sql);
        listaContasReceber = q.getResultList();
        return listaContasReceber;
    }
    
    public List<Faturasreceber> listarFaturas(String sql) throws SQLException{
        List<Faturasreceber> listaFaturasReceber = new ArrayList<Faturasreceber>();
        manager = ConexaoSingleton.getConexao();
        System.out.println(sql);
        Query q = manager.createQuery(sql);
        listaFaturasReceber = q.getResultList();
        return listaFaturasReceber;
    }
    
    public Faturasreceber buscarFaturaReceber(int idFatura) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Faturasreceber fatura = manager.find(Faturasreceber.class, idFatura);
        //fechando uma transação
        manager.getTransaction().commit();
        return fatura;
        
    }
    
    
    // operacoes Parcela Fatura
    
    public Faturasreceberparcelas salvarFaturaParcela(Faturasreceberparcelas faturasReceberParcelas) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        faturasReceberParcelas = manager.merge(faturasReceberParcelas);
        //fechando uma transação
        manager.getTransaction().commit();
        return faturasReceberParcelas;
    }
    
    public void excluirFaturaParcela(Faturasreceberparcelas faturasReceberParcelas) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        faturasReceberParcelas = manager.find(Faturasreceberparcelas.class, faturasReceberParcelas.getIdFaturasReceberParcelas());
        manager.remove(faturasReceberParcelas);
        //fechando uma transação
        manager.getTransaction().commit();
    }
    
    public List<Faturasreceberparcelas> listarFaturasParcelas(String sql) throws SQLException{
        List<Faturasreceberparcelas> listaFaturasReceberParcela = new ArrayList<Faturasreceberparcelas>();
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery(sql);
        if (q.getResultList().size()>0){
            return q.getResultList();
        }
        return null;
    }
    
    public List<Contasreceberpagamento> consultarContasReceberPagamento(int idFechaCaixa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select c from Contasreceberpagamento c where c.fechaCaixa=" + idFechaCaixa);
        if (q.getResultList().size()>0){
            return q.getResultList();
        }
        return null;
    }
    
    public List<Contasreceberforma> consultarFormaPagamento(int idContasReceberPagamento, String forma) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select c from Contasreceberforma c where c.contasreceberpagamento=" + idContasReceberPagamento + " and c.formaRecebimento='" +
                forma + "'");
        if (q.getResultList().size()>0){
            return q.getResultList();
        }
        return null;
    }
    
    public Float valorFormaPagamento(int idFormaPagamento, int idFechaCaixa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        String sql = "SELECT distinct sum(contasreceberforma.valorPago) as valorPago "
        + " FROM  Contasreceberforma join contasreceberpagamento "
        + " on contasreceberforma.contasreceberpagamento_idcontasreceberpagamento = contasreceberpagamento.idcontasreceberpagamento" +
        " where  formapagamento_idformapagamento=" + idFormaPagamento + " and contasreceberpagamento.fechacaixa_idfechacaixa=" + idFechaCaixa;
        Query q = manager.createNativeQuery(sql);
        Double valor = 0.0;
        valor = (Double) q.getSingleResult();
        if (valor==null){
            valor =0.0;
        }
        return valor.floatValue();
    }
    
    public void excluirContasReceberProduto(Contasreceberprodutos produto) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        produto = manager.find(Contasreceberprodutos.class, produto.getIdcontasReceberProdutos());
        manager.remove(produto);
        //fechando uma transação
        manager.getTransaction().commit();
        manager.close();
    }
        
    public List<Contasreceberprodutos> listaContasReceberProdutos(int idContasReceber) throws SQLException{
        List<Contasreceberprodutos> listaContasReceberProdutos = new ArrayList<Contasreceberprodutos>();
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select c from Contasreceberprodutos c where c.contasreceber=" + idContasReceber);
        if (q.getResultList().size()>0){
            return q.getResultList();
        }
        return null;
    }
    
    public Contasreceberprodutos salvarContasReceberProduto(Contasreceberprodutos contasReceberProduto) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        contasReceberProduto = manager.merge(contasReceberProduto);
        //fechando uma transação
        manager.getTransaction().commit();
        return contasReceberProduto;
    }   
    
    
    
}
