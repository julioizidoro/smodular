/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Regras.Formatacao;
import facade.FormaPagamentoFacade;
import facade.VendedorFacade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Terminalcliente;

/**
 *
 * @author Woverine
 */
public class TerminalVendasTableModel extends AbstractTableModel{
        
    public List<Terminalcliente> listaCliente;
    private String[] colunas = {"Nome", "Forma Pagto", "Vendedor", "Valor Total", "Condição Pagto"};

    public TerminalVendasTableModel() {
        this.listaCliente = new ArrayList<Terminalcliente>();
    }

    public TerminalVendasTableModel(List<Terminalcliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public int getRowCount() {
        return listaCliente.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Terminalcliente terminalCliente = listaCliente.get(rowIndex);
        if (columnIndex == 0) {
            return terminalCliente.getNome();
        } else if (columnIndex == 1) {
            return buscarFormaPagamento(terminalCliente.getFormapagamento());
        } else if (columnIndex == 2) {
            return buscarVendedor(terminalCliente.getVendedor());
        } else if (columnIndex==3){
            return Formatacao.foramtarFloatString(terminalCliente.getValorCompra());
        }else return terminalCliente.getCondicaoPagamento();
    }

    public  void adicionar(Terminalcliente terminalCliente){
        this.listaCliente.add(terminalCliente);
    }

    public void adicionar(List<Terminalcliente> listaClientes){
        this.listaCliente = listaClientes;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
             return String.class;
         }else if (columnIndex==1){
             return String.class;
         }else if (columnIndex==2){
             return String.class;
         }else if (columnIndex==3){
             return String.class;
         }else return String.class;
    }

    public Terminalcliente getProdutoVenda(int linha){
        return  listaCliente.get(linha);
    }
    
    public String buscarVendedor(int idVendedor){
        VendedorFacade vendedorFacade = new VendedorFacade();
        try {
            String nome = vendedorFacade.consultarVendedor(idVendedor).getNome();
            return nome;
        } catch (Exception ex) {
            Logger.getLogger(TerminalVendasTableModel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar Vendedor");
            return null;
        }
        
    }
    
    public String buscarFormaPagamento(int idFormaPagamento){
        FormaPagamentoFacade formaPagamentoFacade = new FormaPagamentoFacade();
        String descricao;
        try {
            descricao = formaPagamentoFacade.getFormapagamento(idFormaPagamento).getDescricao();
            return descricao;
        } catch (SQLException ex) {
            Logger.getLogger(TerminalVendasTableModel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar Forma de Pagamento");
            return null;
        }
        
    }

}
