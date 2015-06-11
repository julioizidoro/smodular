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
import model.Vendedor;

/**
 *
 * @author Wolverine
 */
public class VendedorDao {
    
    private EntityManager manager;
    
    public Vendedor salvar(Vendedor vendedor) throws Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        vendedor = manager.merge(vendedor);
        //fechando uma transação
        manager.getTransaction().commit();
        return vendedor;
    }
    
    public Vendedor consultarVendedorId(int idVendedor) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select v From Vendedor v where v.idvendedor=" + idVendedor);
        if(q.getResultList().size()>0){
            manager.getTransaction().commit();
            return (Vendedor) q.getSingleResult();
        }
        manager.getTransaction().commit();
        return null;
    }
    
     public List<Vendedor> consultarVendedor() throws Exception{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        List<Vendedor> listaVendedor = new ArrayList<Vendedor>();
        Query q = manager.createQuery("SELECT v FROM Vendedor v where situacao='ATIVO' order by v.nome");
        listaVendedor = q.getResultList();
        manager.getTransaction().commit();
        return listaVendedor;
    }
    
    public Vendedor consultarVendedor(int idVendedor) throws Exception{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Vendedor vendedor = new Vendedor();
        Query q = manager.createQuery("SELECT v FROM Vendedor v where v.situacao='ATIVO' and v.idvendedor=" + idVendedor);
        if (q.getResultList().size()>0){
            vendedor = (Vendedor) q.getResultList().get(0);
        }
        manager.getTransaction().commit();
        return vendedor;
    } 
}
