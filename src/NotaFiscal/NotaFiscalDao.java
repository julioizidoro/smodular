/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NotaFiscal;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Wolverine
 */
public class NotaFiscalDao {
    
    private EntityManager manager;
    
    public List<Clienteproduto> listaClienteProduto() throws SQLException{
        manager = ConexaoSingletonNotaFiscal.getConexao();
        Query q = manager.createQuery("Select c from Clienteproduto c order by c.nome");
        if (q.getResultList().size()>0){
            return q.getResultList();
        }
        return null;
    }
    
    public Clienteproduto pesquisarClienteProduto(String nome) throws SQLException{
        manager = ConexaoSingletonNotaFiscal.getConexao();
        Query q = manager.createQuery("Select c from Clienteproduto c where c.nome='" + nome + "'");
        if (q.getResultList().size()>0){
            return (Clienteproduto) q.getSingleResult();
        }
        return null;
    }
    
    public Clienteproduto salvarClienteProduto(Clienteproduto clienteProduto) throws SQLException{
        manager = ConexaoSingletonNotaFiscal.getConexao();
        manager.getTransaction().begin();
        clienteProduto = manager.merge(clienteProduto);
        manager.getTransaction().commit();
        return clienteProduto;
    }
    
    public void salvarProdutoTemp(Produtotemp produtoTemp) throws SQLException{
        manager = ConexaoSingletonNotaFiscal.getConexao();
        manager.getTransaction().begin();
        manager.merge(produtoTemp);
        manager.getTransaction().commit();
    }
    
    
    
}
