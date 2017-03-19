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
import model.Produto;

/**
 *
 * @author Woverine
 */
public class ProdutoDao {
    
    private EntityManager manager;

    public List<Produto> getProduto() throws Exception{
        manager = ConexaoSingleton.getConexao();
        List<Produto> listaProdutos = new ArrayList<Produto>();
        Query q = manager.createQuery("select p from Produto p order by p.descricao");
        listaProdutos = q.getResultList();
        return listaProdutos;
    }

    public Produto getProduto(int idProduto) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Produto produto = new Produto();
        Query q = manager.createQuery("select p from Produto p where p.idProduto=" + idProduto);
        if (q.getResultList().size()>0){
            produto = (Produto) q.getSingleResult();
        }
        return produto;
    }
    
    public Produto getCodigoNovo(int codigoNovo) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Produto produto = new Produto();
        Query q = manager.createQuery("select p from Produto p where p.codigoNovo=" + codigoNovo);
        if (q.getResultList().size()>0){
            produto = (Produto) q.getSingleResult();
            return produto;
        }
        return null;
    }

    public List<Produto> getProduto(String descricao) throws Exception {
        manager = ConexaoSingleton.getConexao();
        List<Produto> listaProdutos = new ArrayList<Produto>();
        Query q = manager.createQuery("select p from Produtos p where descricao like '%" + descricao + "%' order by p.descricao");
        listaProdutos = q.getResultList();
        return listaProdutos;
    }
    
    public Produto getProdutoReferencia(int referencia) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Produto produto = new Produto();
        Query q = manager.createQuery("select p from Produto p where p.referencia=" + referencia);
        if (q.getResultList().size()>0){
            produto = (Produto) q.getResultList().get(0);
        }
        return produto;        
    }     
}
