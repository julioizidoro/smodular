/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.EstoqueDao;
import model.Estoque;

/**
 *
 * @author Wolverine
 */
public class EstoqueFacade {

    private EstoqueDao estoqueDao;

    public Estoque getEstoque(int idProduto, int idEmpresa) throws Exception{
        estoqueDao = new EstoqueDao();
        return estoqueDao.getEstoque(idProduto, idEmpresa);
    }

    public void baixarEstoque(Estoque estoque) throws  Exception{
        estoqueDao = new EstoqueDao();
        estoqueDao.baixarEstoque(estoque);
    }

    public void retornarEstoque(Estoque estoque) throws  Exception{
        estoqueDao = new EstoqueDao();
        estoqueDao.retornarEstoque(estoque);
    }
}
