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
import model.Cliente;
import model.Clienteendereco;
import model.Clientefechamento;
import model.Clientehistorico;

/**
 *
 * @author Wolverine
 */
public class ClienteDao {
    
    private EntityManager manager;
    
    
    //Classe Cliente
    public Cliente salvarCliente(Cliente cliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        cliente = manager.merge(cliente);
        //fechando uma transação
        manager.getTransaction().commit();
        return cliente;
    }
    
    public Cliente consultarDocFederal(String docFederal) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Cliente cliente = new Cliente();
        Query q = manager.createQuery("select c from Cliente c where c.docFederal='" + docFederal + "'");
        if (q.getResultList().size()>0){
            cliente =  (Cliente) q.getResultList().get(0);
            manager.getTransaction().commit();
            return cliente;
        }else {            
            manager.getTransaction().commit();
            return null;
        }
    }
    
    public Cliente consultarClienteId(int idCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Cliente cliente = new Cliente();
        Query q = manager.createQuery("select c from Cliente c where c.idcliente=" + idCliente);
        if (q.getResultList().size()>0){
            cliente =  (Cliente) q.getResultList().get(0);
            manager.getTransaction().commit();
            return cliente;
        }else {            
            manager.getTransaction().commit();
            return null;
        }
    }
    
    public List<Cliente> consultarCliente() throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        Query q = manager.createQuery("select c from Cliente c order by c.nome" );
        if (q.getResultList().size()>0){
            listaCliente =   q.getResultList();
            manager.getTransaction().commit();
            return listaCliente;
        }else {            
            manager.getTransaction().commit();
            return null;
        }
    }
    
    public List<Cliente> consultarClienteNome(String nome) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        Query q = manager.createQuery("select c from Cliente c where c.nome like '" + nome + "%' order by c.nome" );
        if (q.getResultList().size()>0){
            listaCliente =   q.getResultList();
            manager.getTransaction().commit();
            return listaCliente;
        }else {            
            manager.getTransaction().commit();
            return null;
        }
    }
    
    
    
    
    
    
    
    
    //Classe Cliente Endereco
    
    public Clienteendereco salvarEndereco(Clienteendereco endereco) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        endereco = manager.merge(endereco);
        //fechando uma transação
        manager.getTransaction().commit();
        return endereco;
    }
    
    public Clienteendereco consultarClienteEndereco(int idCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Clienteendereco endereco = new Clienteendereco();
        Query q = manager.createQuery("select e from Clienteendereco e where e.clienteIdcliente=" + idCliente);
        if (q.getResultList().size()>0){
            endereco= (Clienteendereco) q.getResultList().get(0);
            manager.getTransaction().commit();
            return endereco;
        }else {            
            manager.getTransaction().commit();
            return null;
        }
    }
    
    
    
    public List<Clientehistorico> listarClienteHistorico(int idCliente) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        List<Clientehistorico> listaClienteHistoricos = new ArrayList<Clientehistorico>();
        Query q = manager.createQuery("select c from Clientehistorico c where c.cliente = " + idCliente + " order by c.data desc" );
        if (q.getResultList().size()>0){
            listaClienteHistoricos =   q.getResultList();
            manager.getTransaction().commit();
            return listaClienteHistoricos;
        }else {            
            manager.getTransaction().commit();
            return null;
        }
    }
    
    public void excluirClienteHistorico(Clientehistorico clienteHistorico) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        clienteHistorico = manager.find(Clientehistorico.class, clienteHistorico.getIdclienteHistorico());
        //fechando uma transação
        manager.remove(clienteHistorico);
        manager.getTransaction().commit();
    }
 
    public Clientehistorico salvarClienteHistorico(Clientehistorico clienteHistorico) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        clienteHistorico = manager.merge(clienteHistorico);
        //fechando uma transação
        manager.getTransaction().commit();
        return clienteHistorico;
    }
    
    public Clientefechamento salvarFechamento(Clientefechamento clientefechamento) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transaÃ§Ã£o
        manager.getTransaction().begin();
        clientefechamento = manager.merge(clientefechamento);
        //fechando uma transaÃ§Ã£o
        manager.getTransaction().commit();
        return clientefechamento;
    }

  
    
}
