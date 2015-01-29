/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NotaFiscal;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Wolverine
 */
public class NotaFiscalFacade {
    
    NotaFiscalDao notaFiscalDao;
    
    public List<Clienteproduto> listaClienteProduto() throws SQLException{
        notaFiscalDao = new NotaFiscalDao();
        return notaFiscalDao.listaClienteProduto();
    }
    
    public Clienteproduto pesquisarClienteProduto(String nome) throws SQLException{
        notaFiscalDao = new NotaFiscalDao();
        return notaFiscalDao.pesquisarClienteProduto(nome);
    }
    
    public Clienteproduto salvarClienteProduto(Clienteproduto clienteProduto) throws SQLException{
        notaFiscalDao = new NotaFiscalDao();
        return notaFiscalDao.salvarClienteProduto(clienteProduto);
    }
    
    public void salvarProdutoTemp(Produtotemp produtoTemp) throws SQLException{
        notaFiscalDao = new NotaFiscalDao();
        notaFiscalDao.salvarProdutoTemp(produtoTemp);
    }
    
}
