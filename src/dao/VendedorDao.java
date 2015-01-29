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
        Query q = manager.createQuery("Select v From Vendedor v where v.idvendedor=" + idVendedor);
        if(q.getResultList().size()>0){
            return (Vendedor) q.getSingleResult();
        }
        return null;
    }
    
     public List<Vendedor> consultarVendedor() throws Exception{
        manager = ConexaoSingleton.getConexao();
        List<Vendedor> listaVendedor = new ArrayList<Vendedor>();
        Query q = manager.createQuery("SELECT v FROM Vendedor v where situacao='ATIVO' order by v.nome");
        listaVendedor = q.getResultList();
        manager.close();
        return listaVendedor;
    }
    
    public Vendedor consultarVendedor(int idVendedor) throws Exception{
        manager = ConexaoSingleton.getConexao();
        Vendedor vendedor = new Vendedor();
        Query q = manager.createQuery("SELECT v FROM Vendedor v where v.situacao='ATIVO' and v.idvendedor=" + idVendedor);
        if (q.getResultList().size()>0){
            vendedor = (Vendedor) q.getResultList().get(0);
        }
        manager.close();
        return vendedor;
    }
    
    
    
}
