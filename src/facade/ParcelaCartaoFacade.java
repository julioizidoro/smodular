/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ParcelaCartaoDao;
import java.sql.SQLException;
import model.Parcelacartao;

/**
 *
 * @author wolverine
 */
public class ParcelaCartaoFacade {
    
    ParcelaCartaoDao parcelaCartaoDao;
    
    public void salvar(Parcelacartao parcelaCartao) throws SQLException{
        parcelaCartaoDao = new ParcelaCartaoDao();
        parcelaCartaoDao.salvar(parcelaCartao);
    }
    
}
