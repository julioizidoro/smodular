/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.FechaCaixaDao;
import java.sql.SQLException;
import model.Fechacaixa;

/**
 *
 * @author Wolverine
 */
public class FechaCaixaFacade {

    private FechaCaixaDao fechaCaixaDao;

    public Fechacaixa salvar(Fechacaixa fechaCaixa) throws  Exception{
        fechaCaixaDao = new FechaCaixaDao();
        return fechaCaixaDao.salvar(fechaCaixa);
    }
    
    public Fechacaixa getFechaCaixa(String caixa, int idUsuario) throws SQLException{
        fechaCaixaDao = new FechaCaixaDao();
        return fechaCaixaDao.getFechaCaixa(caixa, idUsuario);
    }

    public Fechacaixa getFechaCaixa(int idFechaCaixa) throws SQLException{
        fechaCaixaDao = new FechaCaixaDao();
        return fechaCaixaDao.getFechaCaixa(idFechaCaixa);
    }
    
  

}