/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controler.ConexaoSingleton;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Emissorecf;

/**
 *
 * @author Angela
 */
public class EmissorEcfDAO {
    
    private EntityManager manager;
    
    public void excluirEmissorEcf(Emissorecf emissorEcf) throws  Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.remove(emissorEcf);
        //fechando uma transação
        manager.getTransaction().commit();
    }
    
    public void salvarEmissorEcf(Emissorecf emissorEcf) throws  Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(emissorEcf);
        //fechando uma transação
        manager.getTransaction().commit();
    }
    
    public Emissorecf getEmissorEcf(int idEmissorecf) throws Exception{
        manager = ConexaoSingleton.getConexao();
        Emissorecf emissorEcf = new Emissorecf();
        Query q = manager.createQuery("select e from Emissorecf e where e.idEmissorECF=" + idEmissorecf);
        if (q.getResultList().size()>0){
            emissorEcf = (Emissorecf) q.getResultList().get(0);
        }
        return emissorEcf;
    }
    
    public List<Emissorecf> listarEmissorEcf(int idEmpresa) throws Exception{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("select e from Emissorecf e where e.empresa=" + idEmpresa);
        if (q.getResultList().size()>0){
            return  q.getResultList();
        }
        return null;
    }
    
    
    
}
