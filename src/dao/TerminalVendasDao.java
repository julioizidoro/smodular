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
import model.Terminalcliente;
import model.Terminalproduto;

/**
 *
 * @author Wolverine
 */
public class TerminalVendasDao {
    private EntityManager manager;

    public Terminalcliente salvarCliente(Terminalcliente terminal) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        terminal = manager.merge(terminal);
        //fechando uma transação
        manager.getTransaction().commit();
        return terminal;
    }

    public void salvarProduto(Terminalproduto produto) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(produto);
        //fechando uma transação
        manager.getTransaction().commit();
    }

    public List<Terminalcliente> consultaTerminalCliente() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Terminalcliente> listaTerminalCliente = new ArrayList<Terminalcliente>();
        Query q = manager.createQuery("select t from Terminalcliente t order by t.nome");
        listaTerminalCliente = q.getResultList();
        manager.close();
        return listaTerminalCliente;
    }
    
    public List<Terminalproduto> consultaTerminalProduto(Terminalcliente terminalCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Terminalproduto> listaTerminalProduto = new ArrayList<Terminalproduto>();
        Query q = manager.createQuery("select t from  Terminalproduto t where t.terminalcliente=" +  terminalCliente.getIdterminalCliente() + " Order by t.idterminalProduto");
        listaTerminalProduto = q.getResultList();
        manager.close();
        return listaTerminalProduto;
    }

    public void excluirTerminalCliente(Terminalcliente terminalCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        terminalCliente = manager.find(Terminalcliente.class, terminalCliente.getIdterminalCliente());
        manager.remove(terminalCliente);
        //fechando uma transação
        manager.getTransaction().commit();
    }

    public void excluirTerminalProduto(Terminalproduto terminalProduto) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        terminalProduto = manager.find(Terminalproduto.class, terminalProduto.getIdterminalProduto());
        manager.remove(terminalProduto);
        //fechando uma transação
        manager.getTransaction().commit();
    }
    
    public int ultimoTerminalClienteGravada() throws Exception {
        manager = ConexaoSingleton.getConexao();
        //verificar last insert id
        Query q = manager.createNativeQuery("Select MAX(idterminalCliente) From TerminalCliente");
        int id = (Integer)q.getSingleResult();
        manager.close();
        return id;
    }
    
    public Terminalcliente getTerminalCliente(int id) throws Exception{
         manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Terminalcliente terminalCliente = manager.find(Terminalcliente.class, id);
        //fechando uma transação
        manager.getTransaction().commit();
        return terminalCliente;
    }
    
    public Terminalcliente getTerminalCliente(String nome) throws Exception{
        manager = ConexaoSingleton.getConexao();
        Terminalcliente terminal = null;
        Query q = manager.createQuery("select t from Terminalcliente t where t.nome='" + nome + "'  order by t.nome");
        if (q.getResultList().size()>0){
            terminal = (Terminalcliente) q.getResultList().get(0);
        }
        manager.close();
        return terminal;
    }
    
}
