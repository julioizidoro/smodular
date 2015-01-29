/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controler.ConexaoSingleton;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import model.Entrega;

/**
 *
 * @author Julio
 */
public class EntregaDao {
    
    private EntityManager manager;
    
    public Entrega salvar(int idEntrega, int numeroFechamento) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Entrega entrega = manager.find(Entrega.class, idEntrega);
        if (entrega!=null){
            entrega.setPaga("SIM");
            entrega.setNumeroFechamento(numeroFechamento);
            manager.merge(entrega);
        }
        //fechando uma transação
        manager.getTransaction().commit();
        return entrega;
    }
    
}
