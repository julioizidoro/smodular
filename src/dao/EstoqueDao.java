/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import controler.ConexaoSingleton;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Estoque;

/**
 *
 * @author Woverine
 */
public class EstoqueDao {

    private EntityManager manager;

    public Estoque getEstoque(int idProduto, int idEmpresa) throws Exception{
        manager = ConexaoSingleton.getConexao();
        Estoque estoque = new Estoque();
        Query q = manager.createQuery("Select e from Estoque e where e.produto=" + idProduto +  " and e.empresa=" + idEmpresa);
        if (q.getResultList().size()>0){
            estoque = (Estoque) q.getSingleResult();
        }
        manager.close();
        return estoque;
    }

    public void baixarEstoque(Estoque estoque) throws  Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(estoque);
        //fechando uma transação
        manager.getTransaction().commit();
    }

    public void retornarEstoque(Estoque estoque) throws  Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(estoque);
        //fechando uma transação
        manager.getTransaction().commit();
    }
}
