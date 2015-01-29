/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.FormaVendaDao;
import java.sql.SQLException;
import java.util.List;
import model.Formavenda;

/**
 *
 * @author Wolverine
 */
public class FormaVendaFacade {
    
    private FormaVendaDao formaVendaDao;

    public Formavenda gravarFormaVenda(Formavenda formaVenda) throws Exception{
        formaVendaDao = new FormaVendaDao();
        return formaVendaDao.gravarFormaVenda(formaVenda);
    }
    
    public List<Formavenda> consultarFormaVenda(int idVenda) throws SQLException{
        formaVendaDao = new FormaVendaDao();
        return formaVendaDao.consultarFormaVenda(idVenda);
    }

}
