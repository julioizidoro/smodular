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
import model.Contasreceberprodutos;
import model.Creditoreceberprodutos;
import model.Creditosreceber;

/**
 *
 * @author Wolverine
 */
public class CreditoReceberDao {
    
    private EntityManager manager;
    
    public Creditosreceber salvar(Creditosreceber creditoReceber) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        creditoReceber = manager.merge(creditoReceber);
        //fechando uma transação
        manager.getTransaction().commit();
        return creditoReceber;
    }
    
    public void excluir(Creditosreceber creditoReceber) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        creditoReceber = manager.find(Creditosreceber.class, creditoReceber.getIdcreditosReceber());
        manager.remove(creditoReceber);
        //fechando uma transação
        manager.getTransaction().commit();
    }
    
    public void excluirCreditoProduto(Creditoreceberprodutos creditoReceberProduto) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        creditoReceberProduto = manager.find(Creditoreceberprodutos.class, creditoReceberProduto.getIdcreditoReceberProdutos());
        manager.remove(creditoReceberProduto);
        //fechando uma transação
        manager.getTransaction().commit();
    }
    
    public List<Creditosreceber> listarCreditos(String sql) throws SQLException{
        List<Creditosreceber> listaCreditosReceber = new ArrayList<Creditosreceber>();
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery(sql);
        listaCreditosReceber = q.getResultList();
        return listaCreditosReceber;
    }
    
    public List<Creditoreceberprodutos> listaCreditoProdutos(int idCredito) throws SQLException{
        List<Creditoreceberprodutos> listaCreditosReceberProdutos = new ArrayList<Creditoreceberprodutos>();
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select c from Creditoreceberprodutos c where c.creditosreceber=" + idCredito);
        if (q.getResultList().size()>0){
            return q.getResultList();
        }
        return null;
    }
    
    
}
