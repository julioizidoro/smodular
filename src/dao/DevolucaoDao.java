/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Regras.Formatacao;
import controler.ConexaoSingleton;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Devolucao;
import model.Devolucaoproduto;
import model.Fechacaixa;

/**
 *
 * @author Woverine
 */
public class DevolucaoDao {

    private EntityManager manager;

    public void gravarDevolucao(Devolucao devolucao) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(devolucao);
        //fechando uma transação
        manager.getTransaction().commit();
    }

    public void gravarDevolucaoProduto(Devolucaoproduto devolucaoproduto) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(devolucaoproduto);
        //fechando uma transação
        manager.getTransaction().commit();
    }

    public int ultimaDevolucaoGravada() throws Exception {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        //verificar last insert id
        Query q = manager.createNativeQuery("Select MAX(idDevolucao) From Devolucao");
        int idDevolucao = (Integer)q.getSingleResult();
        manager.getTransaction().commit();
        return idDevolucao;
    }

    public Devolucao getDevolucao(int idDevolucao) throws Exception{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select d FROM Devolucao d where d.iddevolucao=" + idDevolucao);
        Devolucao devoluvao = (Devolucao) q.getSingleResult();
        manager.getTransaction().commit();
        return devoluvao;
    }
    
    public List<Devolucao> getDevolucao(Fechacaixa fechaCaixa) throws Exception{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        String data = Formatacao.ConvercaoDataSql(new Date());
        Query q = manager.createQuery("Select d FROM Devolucao d where d.fechacaixa=" + fechaCaixa.getIdfechaCaixa() );
        List<Devolucao> listaDevoluvao =  q.getResultList();
        manager.getTransaction().commit();
        return listaDevoluvao;
    }

}
