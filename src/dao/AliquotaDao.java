/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controler.ConexaoSingleton;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import model.Aliquota;

/**
 *
 * @author Wolverine
 */
public class AliquotaDao {
    private EntityManager manager;
    
    public Aliquota getAliquota(int idAliquota) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Aliquota aliquota = new Aliquota();
        aliquota = manager.find(Aliquota.class, idAliquota);
        //fechando uma transação
        manager.getTransaction().commit();
        return aliquota;
    }
    
}
