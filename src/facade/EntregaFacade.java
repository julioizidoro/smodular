/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.EntregaDao;
import java.sql.SQLException;
import model.Entrega;

/**
 *
 * @author Julio
 */
public class EntregaFacade {
    
    EntregaDao entregaDao;
    
    public Entrega salvar(int idEntrega, int numeroFechamento) throws SQLException{
        entregaDao = new EntregaDao();
        return entregaDao.salvar(idEntrega, numeroFechamento);
    }
    
}
