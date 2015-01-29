/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ProdutoDao;
import java.sql.SQLException;
import java.util.List;
import model.Produto;

/**
 *
 * @author Wolverine
 */
public class ProdutoFacade {
    
    private ProdutoDao produtoDao;

    public List<Produto> getProduto() throws Exception{
        produtoDao = new ProdutoDao();
        return produtoDao.getProduto();
    }

    public Produto getProduto(int idProduto) throws Exception {
        produtoDao = new ProdutoDao();
        return produtoDao.getProduto(idProduto);
    }

    public List<Produto> getProduto(String descricao) throws Exception {
        produtoDao = new ProdutoDao();
        return produtoDao.getProduto(descricao);
    }
    
    public Produto getProdutoReferencia(int referencia) throws Exception {
        produtoDao = new ProdutoDao();
        return produtoDao.getProdutoReferencia(referencia);
    }
    
    public Produto getCodigoNovo(int codigoNovo) throws SQLException{
        produtoDao = new ProdutoDao();
        return produtoDao.getCodigoNovo(codigoNovo);
    }

}

