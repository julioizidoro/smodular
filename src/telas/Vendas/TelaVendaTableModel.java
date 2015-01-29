/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package telas.Vendas;

import Regras.Formatacao;
import Regras.ProdutoVenda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Woverine
 */
public class TelaVendaTableModel extends AbstractTableModel{

    public List<ProdutoVenda> listaProdutoVenda;
    private String[] colunas = {"Nº Item", "Código", "Cód Novo", "Descrição", "Unidade", "Quantidade", "Vlr. Unitário", "Vlr. Total"};

    public TelaVendaTableModel() {
        this.listaProdutoVenda = new ArrayList<ProdutoVenda>();
    }

    public TelaVendaTableModel(List<ProdutoVenda> listaProdutoVenda) {
        this.listaProdutoVenda = listaProdutoVenda;
    }

    public int getRowCount() {
        return listaProdutoVenda.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        ProdutoVenda produtoVenda = listaProdutoVenda.get(rowIndex);
        if (columnIndex == 0) {
            return produtoVenda.getNumeroItem();
        } else if (columnIndex == 1) {
            return produtoVenda.getProduto().getReferencia();
        }else if (columnIndex==2){
            return produtoVenda.getProduto().getCodigoNovo();
        } else if (columnIndex == 3) {
            return produtoVenda.getProduto().getDescricao();
        } else if (columnIndex == 4) {
            return produtoVenda.getProduto().getUnidade();
        } else if (columnIndex == 5) {
            return Formatacao.foramtarQuantidade(produtoVenda.getQuantidade());
        } else if (columnIndex == 6) {
            return Formatacao.foramtarFloatString(produtoVenda.getValorUnitario());
        } else {
            return Formatacao.foramtarFloatString(produtoVenda.getValorTotal());
        }
    }

    public  void adicionar(ProdutoVenda produtoVenda){
        this.listaProdutoVenda.add(produtoVenda);
    }

    public void adicionar(List<ProdutoVenda> listaProdutoVenda){
        this.listaProdutoVenda = listaProdutoVenda;
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
             return Integer.class;
         }else if (columnIndex==2){
             return Integer.class;
         }else if (columnIndex==3){
             return String.class;
         }else if (columnIndex==4){
             return String.class;
         }else if (columnIndex==5){
             return String.class;
         }else if (columnIndex==6){
             return String.class;
         }else return String.class;
    }

    public ProdutoVenda getProdutoVenda(int linha){
        return  listaProdutoVenda.get(linha);
    }

}
