/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ConsultaProdutoDao;
import java.sql.SQLException;
import java.util.List;
import view.Viewconsultaprodutoestoque;


/**
 *
 * @author Wolverine
 */
public class ConsultaProdutoFacade {

    private ConsultaProdutoDao consutlaProdutoDao;

    public List<Viewconsultaprodutoestoque> consultaEstoque(int idEmpresa) throws SQLException{
        consutlaProdutoDao = new ConsultaProdutoDao();
        return consutlaProdutoDao.consultaEstoque(idEmpresa);
    }

    public List<Viewconsultaprodutoestoque> consultaEstoque(String descricao, int idEmpresa) throws SQLException{
        consutlaProdutoDao = new ConsultaProdutoDao();
        return consutlaProdutoDao.consultaEstoque(descricao, idEmpresa);
    }

    public List<Viewconsultaprodutoestoque> consultaEstoque(int idProduto, int idEmpresa) throws SQLException{
        consutlaProdutoDao = new ConsultaProdutoDao();
        return consutlaProdutoDao.consultaEstoque(idProduto, idEmpresa);
    }
}
