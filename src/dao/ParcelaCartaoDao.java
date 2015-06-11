/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controler.ConexaoSingleton;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import model.Parcelacartao;

/**
 *
 * @author wolverine
 */
public class ParcelaCartaoDao {
    
    private EntityManager manager;
    
    public void salvar(Parcelacartao parcelaCartao) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(parcelaCartao);
        //fechando uma transação
        manager.getTransaction().commit();
    }
    
}
