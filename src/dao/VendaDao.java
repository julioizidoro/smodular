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
import model.Saida;
import model.Venda;

/**
 *
 * @author Woverine
 */
public class VendaDao {

    private EntityManager manager;

    public Venda gravarVendas(Venda venda) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        venda = manager.merge(venda);
        //fechando uma transação
        manager.getTransaction().commit();
        return venda;
    }

    public void gravarSaida(Saida saida) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(saida);
        //fechando uma transação
        manager.getTransaction().commit();
    }

    public int ultimaVendaGravada() throws Exception {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        //verificar last insert id
        Query q = manager.createNativeQuery("Select MAX(idVenda) From Venda where CondicaoPagamento='A VISTA'");
        int idVenda = (Integer)q.getSingleResult();
        manager.getTransaction().commit();
        return idVenda;
    }

    public Venda getVenda(int idVenda) throws Exception{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select v From Venda v where v.idvenda=" + idVenda);
        Venda venda = (Venda) q.getSingleResult();
        manager.getTransaction().commit();
        return venda;
    }
    
    public List<Saida> listarSaidaVenda(int idVenda)throws Exception{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select s From Saida s where s.venda=" + idVenda);
        List<Saida> listaSaida = new ArrayList<Saida>();
        listaSaida = q.getResultList();
        manager.getTransaction().commit();
        return listaSaida;
    }
    
    public Float valorFormaPagamento(int idFormaPagamento, int idFechaCaixa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        String sql = "SELECT distinct sum(formavenda.valorrecebido) as valor FROM venda, formavenda " + 
                "where venda.idvenda = formavenda.venda_idvenda and venda.fechaCaixa_idFechaCaixa=" + idFechaCaixa +
                " and formavenda.formapagamento_idformapagamento=" + idFormaPagamento + " and venda.valorVenda>0";     
        Query q = manager.createNativeQuery(sql);
        Double valor = 0.0;
        valor = (Double) q.getSingleResult();
        if (valor==null){
            valor =0.0;
        }
        manager.getTransaction().commit();
        return valor.floatValue();
    }
    
    public List<Venda> ListarVenda(int idFechaCaixa) throws Exception{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select v From Venda v where v.fechacaixa=" + idFechaCaixa  + " and v.CondicaoPagamento='A VISTA'");
        List<Venda> listavenda = new ArrayList<Venda>();
        listavenda = q.getResultList();
        manager.getTransaction().commit();
        return listavenda;
    }
    
    public void excluirVendas(Venda venda) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        venda = manager.find(Venda.class, venda.getIdvenda());
        manager.remove(venda);
        //fechando uma transação
        manager.getTransaction().commit();
    }
}
