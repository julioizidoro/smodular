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
public class ConsultaContasReceberTableModel extends AbstractTableModel{
    
    public List<ContasReceberBean> listaContasReceber;
    private String[] colunas = {"Nº Documento", "Data Lançamento", "Valor Conta" , "Data Vencimento", "Pagto"};

    public ConsultaContasReceberTableModel(List<ContasReceberBean> listaContasReceber) {
        this.listaContasReceber = listaContasReceber;
    }

    public int getRowCount() {
        return listaContasReceber.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return listaContasReceber.get(rowIndex).getNumeroDocumento();
        }else if (columnIndex==1){
            return listaContasReceber.get(rowIndex).getDataLancamento();
        }else if (columnIndex==2){
            if (listaContasReceber.get(rowIndex).getValorReceber()>0){
                return Formatacao.foramtarDoubleString(listaContasReceber.get(rowIndex).getValorReceber());
            }else return Formatacao.foramtarDoubleString(listaContasReceber.get(rowIndex).getValorConta());
        }else if (columnIndex==3){
            return listaContasReceber.get(rowIndex).getDataVencimento();
        }else return listaContasReceber.get(rowIndex).getPagamento();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return String.class;
        } else if (columnIndex==1){
            return Date.class;
        }else if (columnIndex==2){
            return String.class;
        }else if (columnIndex==3){
            return Date.class;
        }else return String.class;
    }
    
}
