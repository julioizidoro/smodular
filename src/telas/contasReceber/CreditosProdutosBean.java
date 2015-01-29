/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.contasReceber;


import facade.ProdutoFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Creditoreceberprodutos;
import model.Produto;

/**
 *
 * @author Wolverine
 */
public class CreditosProdutosBean {
    
    Produto produto;
    Creditoreceberprodutos creditoProdutos;

    public CreditosProdutosBean(Creditoreceberprodutos creditoProdutos) {
        this.creditoProdutos = creditoProdutos;
        localizarProduto();
    }
    
    

    public Creditoreceberprodutos getCreditoProdutos() {
        return creditoProdutos;
    }

    public void setCreditoProdutos(Creditoreceberprodutos creditoProdutos) {
        this.creditoProdutos = creditoProdutos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void localizarProduto(){
        ProdutoFacade produtoController = new ProdutoFacade();
        try {
            setProduto(produtoController.getProduto(creditoProdutos.getProduto()));
        } catch (Exception ex) {
            Logger.getLogger(CreditosProdutosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
