/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.VendaDao;
import java.sql.SQLException;
import java.util.List;
import model.Saida;
import model.Venda;

/**
 *
 * @author Wolverine
 */
public class VendaFacade {

    VendaDao vendaDao;

    public Venda gravarVendas(Venda venda) throws Exception{
        vendaDao = new VendaDao();
        return vendaDao.gravarVendas(venda);
    }

    public void gravarSaida(Saida saida) throws Exception{
        vendaDao = new VendaDao();
        vendaDao.gravarSaida(saida);
    }

    public Venda ultimaVendaGravada() throws Exception {
        vendaDao = new VendaDao();
        int idVenda = vendaDao.ultimaVendaGravada();
        return vendaDao.getVenda(idVenda);
    }
    
    public List<Saida> listarSaidaVenda(int idVenda)throws Exception{
        vendaDao = new VendaDao();
        return vendaDao.listarSaidaVenda(idVenda);
    }
    
    public Float valorFormaPagamento(int idFormaPagamento, int idFechaCaixa) throws SQLException{
        vendaDao = new VendaDao();
        return  vendaDao.valorFormaPagamento(idFormaPagamento, idFechaCaixa);
    }
    
    public List<Venda> ListarVenda(int idFechaCaixa) throws Exception{
        vendaDao = new VendaDao();
        return vendaDao.ListarVenda(idFechaCaixa);
    }


}