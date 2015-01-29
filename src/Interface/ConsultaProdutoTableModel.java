/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Regras.Formatacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import view.Viewconsultaprodutoestoque;


/**
 *
 * @author Woverine
 */
public class ConsultaProdutoTableModel extends AbstractTableModel{

    public List<Viewconsultaprodutoestoque> listaProduto;
    private String[] colunas = {"Código", "Cód Novo" , "Descrição", "Unidade", "Quantidade", "Valor Venda"};

    public ConsultaProdutoTableModel() {
        this.listaProduto = new ArrayList<Viewconsultaprodutoestoque>();
    }

    public ConsultaProdutoTableModel(List<Viewconsultaprodutoestoque> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public int getRowCount() {
        return listaProduto.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Viewconsultaprodutoestoque produtoEstoque = listaProduto.get(rowIndex);
        if (columnIndex == 0) {
            return produtoEstoque.getReferencia();
        } else if (columnIndex == 1) {
            return produtoEstoque.getCodigonovo();
        }else if (columnIndex==2){
            return produtoEstoque.getDescricao();
        } else if (columnIndex == 3) {
            return produtoEstoque.getUnidade();
        } else if (columnIndex == 4) {
            return Formatacao.foramtarQuantidade(produtoEstoque.getQuantidadeEstoque());
        } else {
            return Formatacao.foramtarFloatString(produtoEstoque.getValorVenda());
        }
    }

    public  void adicionar(Viewconsultaprodutoestoque produtoEstoque){
        this.listaProduto.add(produtoEstoque);
    }

    public void adicionar(List<Viewconsultaprodutoestoque> listaProdutoEstoqyue){
        this.listaProduto = listaProdutoEstoqyue;
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
             return Integer.class;
         }else if (columnIndex==2){
             return String.class;
         }else if (columnIndex==3){
             return String.class;
         }else if (columnIndex==4){
             return String.class;
         }else return String.class;
    }

    public Viewconsultaprodutoestoque getProdutoVenda(int linha){
        return  listaProduto.get(linha);
    }

}
