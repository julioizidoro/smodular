/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.contasReceber;

import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wolverine
 */
public class ConsultaCreditosTableModel extends AbstractTableModel{
    
    private List<CreditoBean> listaCredito;
    private String[] colunas ={"Data Lançamento", "Valor Credito", "Nome Vendedor", "Marcado"};

    public ConsultaCreditosTableModel(List<CreditoBean> listaCredito) {
        this.listaCredito = listaCredito;
    }

    public int getRowCount() {
        return this.listaCredito.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
           return listaCredito.get(rowIndex).getCredito().getDataLancamento();
        }else if (columnIndex==1){
            return Formatacao.foramtarDoubleString(listaCredito.get(rowIndex).getCredito().getValorCredito());
        }else if (columnIndex==2){
            return listaCredito.get(rowIndex).getNomeVendedor();
        }else return listaCredito.get(rowIndex).getUtilizar();
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
             return  Date.class;
         }else if (columnIndex==1){
             return String.class;
         }else if (columnIndex==2){
             return String.class;
         }else return String.class;
    }
    
}
