/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.FormaPagamentoDao;
import java.sql.SQLException;
import java.util.List;
import model.Formapagamento;

/**
 *
 * @author Wolverine
 */
public class FormaPagamentoFacade {
    
    private FormaPagamentoDao formaPagamentoDao;

    public List<Formapagamento> getFormaPagamento() throws SQLException{
        formaPagamentoDao = new FormaPagamentoDao();
        return formaPagamentoDao.getFormaPagamento();
    }
    
    public Formapagamento getFormapagamento(int idFormaPagamento) throws SQLException{
        formaPagamentoDao = new FormaPagamentoDao();
        return formaPagamentoDao.getFormapagamento(idFormaPagamento);
    }
    
    public List<Formapagamento> getFormaPagamentoBandeiraCartao(int idBandeiraCartao) throws SQLException{
        formaPagamentoDao = new FormaPagamentoDao();
        return formaPagamentoDao.getFormaPagamentoBandeiraCartao(idBandeiraCartao);
    }
    
    public Formapagamento salvarFormapagamento(Formapagamento formaPagamento) throws SQLException{
        formaPagamentoDao = new FormaPagamentoDao();
        return formaPagamentoDao.salvarFormapagamento(formaPagamento);
    }
    
    public List<Formapagamento> listarFormaPagamentoValor() throws SQLException{
        formaPagamentoDao = new FormaPagamentoDao();
        return formaPagamentoDao.listarFormaPagamentoValor();
    }

}