/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import Regras.Config;
import Regras.Formatacao;
import Regras.ProdutoVenda;
import facade.EstoqueFacade;
import facade.ProdutoFacade;
import facade.VendaFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Estoque;
import model.Produto;
import model.Saida;
import model.Venda;

/**
 *
 * @author Wolverine
 */
public class UltimoCupomFiscal {
    
    private Venda venda;
    private ECFBematech ecf;
    private List<Saida> listaSaida = new ArrayList<Saida>();
    private String mensagem;
    private Config config;

    public UltimoCupomFiscal(String mensagem, Config config) {
        this.config =config;
        this.mensagem = mensagem;
        VendaFacade vendaFacade = new VendaFacade();
        try {
            this.venda = vendaFacade.ultimaVendaGravada();
            String msg = this.mensagem;
            this.mensagem =  "Valor Aprox. Tributo R$ " + Formatacao.foramtarDoubleString(venda.getValorImposto()) + " (" + 
                        Formatacao.foramtarDoubleString(venda.getAliquotaImposto()) + "%)" + " Fonte IBPT\r\n" +
                    msg;
        } catch (Exception ex) {
            Logger.getLogger(UltimoCupomFiscal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            listaSaida = vendaFacade.listarSaidaVenda(venda.getIdvenda());
        } catch (Exception ex) {
            Logger.getLogger(UltimoCupomFiscal.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.ecf = new ECFBematech();
        if (listaSaida.size()>0){
            imprimirProdutos();
            finalizarCupom();
            salvarVenda();
            salvarSaida();
        }else {
            JOptionPane.showMessageDialog(null, "Erro ao imprimir Cupom Fiscal");
        }
    }
    
    
    private void imprimirProdutos(){
        ecf.abreCupomFiscal();
        for(int i=0;i<listaSaida.size();i++){
            Produto produto = buscarProduto(listaSaida.get(i).getProduto());
            if (produto != null) {
                ProdutoVenda produtoVenda = new ProdutoVenda();
                produtoVenda.setNumeroItem(i + 1);
                produtoVenda.setProduto(produto);
                produtoVenda.setQuantidade(listaSaida.get(i).getQuantidade());
                Float valorUnitario =0.0f;
                if (listaSaida.get(i).getValorDesconto()>0){
                    valorUnitario = buscarValorVendaUnitario(produto.getIdProduto());
                }else valorUnitario = (listaSaida.get(i).getValorVenda() / listaSaida.get(i).getQuantidade().floatValue());
                produtoVenda.setValorUnitario(valorUnitario);
                produtoVenda.setValorTotal(valorUnitario * listaSaida.get(i).getQuantidade().floatValue());
                gerarMensagemECF(ecf.vendeItem(produtoVenda));
            }
        }
    }
    
    private void finalizarCupom(){
        venda.setNumeroECF(ecf.numeroCupom());
        float valorDesconto = venda.getValorDesconto();
        gerarMensagemECF(ecf.iniciaFechamentoCupom("D", "$", Formatacao.formatarStringBematech(valorDesconto)));
        Float total = venda.getValorVenda() - venda.getValorDesconto();
        gerarMensagemECF(ecf.efetuaFormaPagamento("Dinheiro", Formatacao.formatarStringBematech(total)));
        gerarMensagemECF(ecf.terminaFechamentoCupom(this.mensagem));
    }
    
    public void gerarMensagemECF(String msg){
        if (msg!=null){
            JOptionPane.showMessageDialog(null, msg);
        }
    }
    
    public Produto buscarProduto(int idProduto){
        ProdutoFacade produtoFacade = new ProdutoFacade();
        try {
            return produtoFacade.getProduto(idProduto);
        } catch (Exception ex) {
            Logger.getLogger(UltimoCupomFiscal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar Produto");
            return null;
        }
    }
    
    public float buscarValorVendaUnitario(int idProduto){
        EstoqueFacade estoqueFacade = new EstoqueFacade();
        Estoque estoque;
        try {
            estoque = estoqueFacade.getEstoque(idProduto, this.config.getEmpresa().getIdempresa());
            return estoque.getValorVenda();
        } catch (Exception ex) {
            Logger.getLogger(UltimoCupomFiscal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro consultar estoque");
            return 0.0f;
        }        
    }
    
    public void salvarVenda(){
        VendaFacade vendaFacade = new VendaFacade();
        venda.setValorVenda2(venda.getValorVenda());
        try {
            vendaFacade.gravarVendas(venda);
        } catch (Exception ex) {
            Logger.getLogger(UltimoCupomFiscal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvarSaida(){
        VendaFacade vendaFacade = new VendaFacade();
        for (int i=0;i<listaSaida.size();i++){
            Saida saida = listaSaida.get(i);
            saida.setValorVenda2(saida.getValorVenda());
            try {
                vendaFacade.gravarSaida(saida);
            } catch (Exception ex) {
                Logger.getLogger(UltimoCupomFiscal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
