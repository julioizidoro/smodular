/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ControleChequeDao;
import java.sql.SQLException;
import java.util.List;
import model.Chequefechacaixa;
import model.Chequemovbanco;
import model.Chequemovcaixa;
import model.Contolechequefornecedor;
import model.Controlecheques;

/**
 *
 * @author Wolverine
 */
public class ControleChequeFacade {
    
    ControleChequeDao controleChequeDao;
    
    public Controlecheques salvarCehque(Controlecheques cheque) throws Exception {
       controleChequeDao = new ControleChequeDao();
       return controleChequeDao.salvarCehque(cheque);
    }
    
    public List<Controlecheques> listarCheques(String sql) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.listarCheques(sql);
    }
    
    public List<Contolechequefornecedor> consultarFornecedor(int idForneceodr) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.consultarFornecedor(idForneceodr);
    }
    
    public void salvarFornecedor(Contolechequefornecedor fornecedor) throws Exception {
        controleChequeDao = new  ControleChequeDao();
        controleChequeDao.salvarFornecedor(fornecedor);
    }
    
    public Controlecheques consultarCheque(int idControleCheques) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.consultarCheque(idControleCheques);
    }
    
    public Contolechequefornecedor consultarFornecedorCheque(int idControleCheques) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.consultarFornecedorCheque(idControleCheques);
    }
    
    public Chequefechacaixa salvarCehqueFechaCaixa(Chequefechacaixa chequeFechaCaixa) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.salvarCehqueFechaCaixa(chequeFechaCaixa);
    }
    
    public Chequemovbanco salvarChequeMovBanco(Chequemovbanco chequeMovBanco) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.salvarChequeMovBanco(chequeMovBanco);
    }
    
    public Chequemovcaixa salvarChequeMovCaixa(Chequemovcaixa chequeMovCaixa) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.salvarChequeMovCaixa(chequeMovCaixa);
    }
    
    public List<Chequefechacaixa>  ListaChequesCaixa(int idFechaCaixa) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.ListaChequesCaixa(idFechaCaixa);
    }
    
    public Controlecheques listarChequesid(int idFechaCaixa) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.listarChequesid(idFechaCaixa);
    }
    
    public void excluirControleCheque(Controlecheques controlecheques) throws Exception {
        controleChequeDao = new ControleChequeDao();
        controleChequeDao.excluirControleCheque(controlecheques);
    }
    
    public void excluirControleChequeFechaCaixa(Chequefechacaixa chequefechacaixa) throws Exception {
        controleChequeDao = new ControleChequeDao();
        controleChequeDao.excluirControleChequeFechaCaixa(chequefechacaixa);
    }
    
    public Chequefechacaixa  ListaChequesCaixaid(int idControleCheque) throws SQLException{
        controleChequeDao = new ControleChequeDao();
        return controleChequeDao.ListaChequesCaixaid(idControleCheque);
    }
}
