/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.BandeiraCartaoDao;
import java.sql.SQLException;
import java.util.List;
import model.Bandeirascartao;

/**
 *
 * @author wolverine
 */
public class BandeiraCartaoFacade {
    
    BandeiraCartaoDao bandeiraCartaoDao;
    
    public List<Bandeirascartao> listarBandeirasCartao() throws SQLException{
        bandeiraCartaoDao = new BandeiraCartaoDao();
        return bandeiraCartaoDao.listarBandeirasCartao();
    }
    
}
