/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ClienteDao;
import java.sql.SQLException;
import model.Cliente;
import model.Clienteendereco;
import java.util.*;
import model.*;

/**
 *
 * @author Wolverine
 */
public class ClienteFacade {
     
    ClienteDao clienteDao;
    
     public Cliente salvarCliente(Cliente cliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.salvarCliente(cliente);
    }
    
    public Cliente consultarDocFederal(String docFederal) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.consultarDocFederal(docFederal);
    }
    
    public Cliente consultarClienteId(int idCliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.consultarClienteId(idCliente);
    }
    
    public List<Cliente> consultarCliente() throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.consultarCliente();
    }
    
    public List<Cliente> consultarClienteNome(String nome) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.consultarClienteNome(nome);
    }
    
    
    public Clienteendereco salvarEndereco(Clienteendereco endereco) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.salvarEndereco(endereco);
    }
    
    public Clienteendereco consultarClienteEndereco(int idCliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.consultarClienteEndereco(idCliente);
    }
    
    
    public List<Clientehistorico> listarClienteHistorico(int idCliente) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.listarClienteHistorico(idCliente);
    }
    
    public void excluirClienteHistorico(Clientehistorico clienteHistorico) throws SQLException{
        clienteDao = new ClienteDao();
        clienteDao.excluirClienteHistorico(clienteHistorico);
    }
    
    public Clientehistorico salvarClienteHistorico(Clientehistorico clienteHistorico) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.salvarClienteHistorico(clienteHistorico);
    }
    
    public Clientefechamento salvarFechamento(Clientefechamento clientefechamento) throws SQLException{
        clienteDao = new ClienteDao();
        return clienteDao.salvarFechamento(clientefechamento);
    }
}
