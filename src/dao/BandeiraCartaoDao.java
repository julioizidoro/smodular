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
import model.Bandeirascartao;

/**
 *
 * @author wolverine
 */
public class BandeiraCartaoDao {
    private EntityManager manager;
    
    public List<Bandeirascartao> listarBandeirasCartao() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select b from Bandeirascartao b where b.nome<>'Nenhuma'  order by b.idbandeirasCartao");
        manager.getTransaction().commit();
        return q.getResultList();
    }
}
