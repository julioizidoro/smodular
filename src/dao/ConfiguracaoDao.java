/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import controler.ConexaoSingleton;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Configuracao;

/**
 *
 * @author wolverine
 */
public class ConfiguracaoDao {
    
    private EntityManager manager;
    
    public Configuracao salvarConfiguracao(Configuracao configuracao) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        configuracao = manager.merge(configuracao);
        //fechando uma transação
        manager.getTransaction().commit();
        return configuracao;
    }
    
    public Configuracao getConfiguracao(int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("Select c from Configuracao c where c.empresa=" + idEmpresa);
        if (q.getResultList().size()>0){
            manager.getTransaction().commit();
            return (Configuracao) q.getResultList().get(0);
        }
        manager.getTransaction().commit();
        return null;
    }
    
}
