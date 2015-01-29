/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import Regras.ProdutoVenda;
import facade.DevolucaoFacade;
import facade.EstoqueFacade;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Devolucaoproduto;
import model.Estoque;
import model.Devolucao;
import model.Fechacaixa;

/**
 *
 * @author Woverine
 */
public class Devolucoes {

    private List<ProdutoVenda> listaProdutoDevolucao = new ArrayList<ProdutoVenda>();
    private Devolucao devolucao = new Devolucao();
    private List<Devolucaoproduto> listaDevolucao = new ArrayList<Devolucaoproduto>();

    public Devolucoes(int fechamento, int devolucao, int idEmpresa) {
        fechamento =0;
        devolucao =1;
        this.devolucao.setDataDevolucao(new Date());
        this.devolucao.setVendedor(1);
        this.devolucao.setEmpresa(idEmpresa);
        Time hora = new Time(new Date().getTime());
        this.devolucao.setHoraDevolucao(hora);
    }


    public void gerarDevolucaoProduto() throws Exception {
        DevolucaoFacade DevolucaoFacade = new DevolucaoFacade();
        Devolucao DevolucaoEfetuada = DevolucaoFacade.ultimaDevolucaoGravada();
        for (int i = 0; i < listaProdutoDevolucao.size(); i++) {
            Devolucaoproduto devolucaoProduto = new Devolucaoproduto();
            devolucaoProduto.setProduto(listaProdutoDevolucao.get(i).getProduto().getIdProduto());
            devolucaoProduto.setQuantidadeDevolucao((listaProdutoDevolucao.get(i).getQuantidade()));
            devolucaoProduto.setValorUnitario(listaProdutoDevolucao.get(i).getValorUnitario());
            devolucaoProduto.setValorTotal(listaProdutoDevolucao.get(i).getValorTotal());
            devolucaoProduto.setDevolucao(DevolucaoEfetuada.getIddevolucao());
            listaDevolucao.add(devolucaoProduto);
            devolverEstoque(devolucaoProduto);
        }

    }


    public void gravarDevolucao() throws Exception{
        DevolucaoFacade DevolucaoFacade = new DevolucaoFacade();
        for (int i=0;i<listaDevolucao.size();i++){
            Devolucaoproduto devolucaoProduto = new Devolucaoproduto();
            devolucaoProduto = listaDevolucao.get(i);
            DevolucaoFacade.gravarDevolucaoProduto(devolucaoProduto);
        }
    }

    
    public void devolverEstoque(Devolucaoproduto devolucaoProduto) throws Exception {
        Estoque estoque = new Estoque();
        EstoqueFacade estoqueFacade = new EstoqueFacade();
        estoque = estoqueFacade.getEstoque(devolucaoProduto.getProduto(), 1);
        estoque.setQuantidadeEstoque((estoque.getQuantidadeEstoque().doubleValue() + devolucaoProduto.getQuantidadeDevolucao().doubleValue()));
        estoqueFacade.retornarEstoque(estoque);

    }
    
    public void FinalizarDevolucao(Fechacaixa fechaCaixa)  {
        this.devolucao.setNumeroItens(listaProdutoDevolucao.size());
        this.devolucao.setValorDevolucao((TotalDevolucao()));
        this.devolucao.setFechacaixa(fechaCaixa.getIdfechaCaixa());
        DevolucaoFacade DevolucaoFacade = new DevolucaoFacade();
        try {
            DevolucaoFacade.gravarDevolucao(this.devolucao);
        } catch (Exception ex) {
            Logger.getLogger(Devolucoes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gravar Devolucao Facade " + ex);
        }
        try {
            gerarDevolucaoProduto();
        } catch (Exception ex) {
            Logger.getLogger(Devolucoes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gerar Devolução de produtos " + ex);
        }
        try {
            gravarDevolucao();
        } catch (Exception ex) {
            Logger.getLogger(Devolucoes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro gravar Devolução " + ex);
        }

    }

    public Float TotalDevolucao() {
        Float valor = 0.0f;
        for (int i = 0; i < this.listaProdutoDevolucao.size(); i++) {
            valor = valor + listaProdutoDevolucao.get(i).getValorTotal();
        }
        return valor;
    }
    
    public void excluirItemDevolucao(int item){
        this.listaProdutoDevolucao.remove(item);
    }

    public Devolucao getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
    }

    public List<Devolucaoproduto> getListaDevolucao() {
        return listaDevolucao;
    }

    public void setListaDevolucao(List<Devolucaoproduto> listaDevolucao) {
        this.listaDevolucao = listaDevolucao;
    }

    public List<ProdutoVenda> getListaProdutoDevolucao() {
        return listaProdutoDevolucao;
    }

    public void setListaProdutoDevolucao(List<ProdutoVenda> listaProdutoDevolucao) {
        this.listaProdutoDevolucao = listaProdutoDevolucao;
    }


}
