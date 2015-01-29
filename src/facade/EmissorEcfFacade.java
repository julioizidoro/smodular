/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.EmissorEcfDAO;
import java.util.List;
import model.Emissorecf;

/**
 *
 * @author Wolverine
 */
public class EmissorEcfFacade {
    
    EmissorEcfDAO emissorEcfDAO;
    
    public void excluirEmissorEcf(Emissorecf emissorEcf) throws  Exception{
       emissorEcfDAO = new EmissorEcfDAO();
       emissorEcfDAO.excluirEmissorEcf(emissorEcf);
    }
    
    public void salvarEmissorEcf(Emissorecf emissorEcf) throws  Exception{
        emissorEcfDAO = new EmissorEcfDAO();
        emissorEcfDAO.salvarEmissorEcf(emissorEcf);
    }
    
    public Emissorecf getEmissorEcf(int idEmissorecf) throws Exception{
        emissorEcfDAO = new EmissorEcfDAO();
        return emissorEcfDAO.getEmissorEcf(idEmissorecf);
    }
    
    public List<Emissorecf> listarEmissorEcf(int idEmpresa) throws Exception{
        emissorEcfDAO = new EmissorEcfDAO();
        return emissorEcfDAO.listarEmissorEcf(idEmpresa);
    }
    
}
