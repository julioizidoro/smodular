/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controler.ConexaoSingleton;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Ibpt;

/**
 *
 * @author Wolverine
 */
public class IbptDao {
    
    private EntityManager manager;
    
    public List<Ibpt> listarIbpt() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("select i from Ibpt i order by i.descricao" );
        if (q.getResultList().size()>0){
            return q.getResultList();
        }else {            
            return null;
        }
    }
    
    public List<Ibpt> listarIbpt(String descricao) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("select i from Ibpt i where i.descricao like '%" + descricao + "%' order by i.descricao" );
        if (q.getResultList().size()>0){
            return q.getResultList();
        }else {            
            return null;
        }
    }
    
    public Ibpt cunsultarIbpt(String ncm) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("select i from Ibpt i where i.ncm = '" + ncm + "' order by i.descricao" );
        if (q.getResultList().size()>0){
            return (Ibpt) q.getResultList().get(0);
        }else {            
            return null;
        }
    }
}
