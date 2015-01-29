/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import controler.ConexaoSingleton;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import view.Viewconsultaprodutoestoque;


/**
 *
 * @author Woverine
 */
public class ConsultaProdutoDao {

    private EntityManager manager;

    public List<Viewconsultaprodutoestoque> consultaEstoque(int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Viewconsultaprodutoestoque> listaProdutos = new ArrayList<Viewconsultaprodutoestoque>();
        Query q = manager.createQuery("SELECT c FROM Viewconsultaprodutoestoque c where c.empresa=" + idEmpresa);
        listaProdutos = q.getResultList();
        manager.close();
        return listaProdutos;
    }

    public List<Viewconsultaprodutoestoque> consultaEstoque(String descricao, int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Viewconsultaprodutoestoque> listaProdutos = new ArrayList<Viewconsultaprodutoestoque>();
        Query q = manager.createQuery("SELECT c FROM Viewconsultaprodutoestoque c WHERE c.descricao like '" +  descricao + "%' and c.empresa="  + idEmpresa + " order by c.descricao");
        listaProdutos = q.getResultList();
        manager.close();
        return listaProdutos;
    }

     public List<Viewconsultaprodutoestoque> consultaEstoque(int idProduto, int idEmpresa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Viewconsultaprodutoestoque> listaProdutos = new ArrayList<Viewconsultaprodutoestoque>();
        Query q = manager.createQuery("SELECT c FROM Viewconsultaprodutoestoque c WHERE c.idProduto =" +  idProduto + "  and c.empresa=" + idEmpresa);
        listaProdutos = q.getResultList();
        manager.close();
        return listaProdutos;
    }

}
