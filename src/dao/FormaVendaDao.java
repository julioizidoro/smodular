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
import model.Formavenda;

/**
 *
 * @author Woverine
 */
public class FormaVendaDao {
    
    private EntityManager manager;

    public Formavenda gravarFormaVenda(Formavenda formaVenda) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        formaVenda = manager.merge(formaVenda);
        //fechando uma transação
        manager.getTransaction().commit();
        manager.close();
        return formaVenda;
    }
    
    public List<Formavenda> consultarFormaVenda(int idVenda) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select v From Formavenda v where v.venda=" + idVenda);
        List<Formavenda> listaFormaVenda = new ArrayList<Formavenda>();
        listaFormaVenda = q.getResultList();
        manager.close();
        return listaFormaVenda;
    }
}
