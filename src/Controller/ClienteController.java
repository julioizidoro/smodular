/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import facade.ClienteFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author Wolverine
 */
public class ClienteController {
    
    private ClienteFacade clienteFacade;
    
    public Cliente salvarCliente(Cliente cliente){
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.salvarCliente(cliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Clienten " +ex);
            return null;
        }
    }
    
    public Cliente consultarDocFederal(String docFederal) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.consultarDocFederal(docFederal);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Documento Federal " + ex);
            return null;
        }
    }
    
    public Cliente consultarClienteId(int idCliente) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.consultarClienteId(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Cliente pelo Id " + ex);
            return null;
        }
    }
    
    public List<Cliente> consultarCliente() {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.consultarCliente();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Listar Clientes " + ex);
            return null;
        }
    }
    
    public List<Cliente> consultarClienteNome(String nome) {
    clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.consultarClienteNome(nome);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Listar Clientes por Nome " + ex);
            return null;
        }
    }
    
    
    public Clienteendereco consultarClienteEndereco(int idCliente)  {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.consultarClienteEndereco(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar Endereço " + ex);
            return null;
        }
    }
    
    
    public Clienteendereco salvarEndereco(Clienteendereco endereco) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.salvarEndereco(endereco);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, "Erro Salvar Endereço " + ex);
            return null;
        }
    }
    
    
    public List<Clientehistorico> listarClienteHistorico(int idCliente) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.listarClienteHistorico(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Histórico " + ex);
            return null;
        }
    }
    
    public void excluirClienteHistorico(Clientehistorico clienteHistorico) {
        clienteFacade = new ClienteFacade();
        try {
            clienteFacade.excluirClienteHistorico(clienteHistorico);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Excluir Histórico " + ex);
        }
    }
    
    public Clientehistorico salvarClienteHistorico(Clientehistorico clienteHistorico) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.salvarClienteHistorico(clienteHistorico);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Histórico "  + ex);
            return null;
        }
    }
    
    public Clientefechamento salvarFechamento(Clientefechamento clientefechamento) {
        clienteFacade = new ClienteFacade();
        try {
            return clienteFacade.salvarFechamento(clientefechamento);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Fechamento "  + ex);
            return null;
        }
    }
}
