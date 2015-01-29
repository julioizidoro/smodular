/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NotaFiscal;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wolverine
 */
public class ConsultaClienteProdutoTableModel extends AbstractTableModel{
    
    public List<Clienteproduto> listaClienteProduto;
    private String[] colunas = {"Nome do Cliente"};

    public ConsultaClienteProdutoTableModel(List<Clienteproduto> listaClienteProduto) {
        this.listaClienteProduto = listaClienteProduto;
    }
    
    public int getRowCount() {
        return listaClienteProduto.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return listaClienteProduto.get(rowIndex).getNome();
        }else return " ";
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return String.class;
        } else{
            return String.class;
        }
    }
    
}
