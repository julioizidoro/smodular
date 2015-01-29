/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Regras.Formatacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Formapagamento;

/**
 *
 * @author Woverine
 */
public class FormaPagamentoTableModel extends AbstractTableModel{

public List<Formapagamento> listaFormaPagamento;
    private String[] colunas = {"Código", "Descrição", "Valor R$"};

    public FormaPagamentoTableModel() {
        this.listaFormaPagamento = new ArrayList<Formapagamento>();
    }

    public FormaPagamentoTableModel(List<Formapagamento> listaFormaPagamento) {
        this.listaFormaPagamento = listaFormaPagamento;
    }

    public int getRowCount() {
        return listaFormaPagamento.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Formapagamento formaPagamento = listaFormaPagamento.get(rowIndex);
        if (columnIndex == 0) {
            return formaPagamento.getIdformaPagamento();
        } else if (columnIndex == 1) {
            return formaPagamento.getDescricao();
        } else {
            return Formatacao.foramtarFloatString(formaPagamento.getValor());
        }
    }

    public  void adicionar(Formapagamento formaPagamento){
        this.listaFormaPagamento.add(formaPagamento);
    }

    public void adicionar(List<Formapagamento> listaFormaPagamento){
        this.listaFormaPagamento = listaFormaPagamento;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
             return Integer.class;
         }else if (columnIndex==1){
             return String.class;
         }else {
             return String.class;
         }
    }

    public Formapagamento getFromaPagamento(int linha){
        return  listaFormaPagamento.get(linha);
    }

}

