/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.AliquotaDao;
import java.sql.SQLException;
import model.Aliquota;

/**
 *
 * @author Wolverine
 */
public class AliquotaFacade {
    
    AliquotaDao aliquotaDao;
    
    public Aliquota getAliquota(int idAliquota) throws SQLException{
        aliquotaDao = new AliquotaDao();
        return aliquotaDao.getAliquota(idAliquota);
    }
    
}
