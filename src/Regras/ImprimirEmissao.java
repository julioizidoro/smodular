/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;

import Controller.VendaController;
import facade.ProdutoFacade;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Produto;
import model.Saida;
import model.Venda;
import negocios.UltimoCupomFiscal;

/**
 *
 * @author wolverine
 */
public class ImprimirEmissao {
    
    private List<Saida> listaSaida;
    private Venda venda;
    private PortaParalela porta;
    private float valor;
    private StringBuilder texto;

    public ImprimirEmissao() {
    }
    
    

    public ImprimirEmissao(Venda venda, String porta) {
        this.venda = venda;
        valor =0;
        getListaSaida();
        if (this.listaSaida!=null){
            iniciarPortaParalela(porta);
        }else JOptionPane.showMessageDialog(null, "Sem produtos para Imprimir");
    }

    public List<Saida> getListaSaida() {
        VendaController vendaController = new VendaController();
        this.listaSaida = vendaController.listarSaidaVenda(venda.getIdvenda());
        return listaSaida;
    }

    public void setListaSaida(List<Saida> listaSaida) {
        this.listaSaida = listaSaida;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public PortaParalela getPorta() {
        return porta;
    }

    public void setPorta(PortaParalela porta) {
        this.porta = porta;
    }
    
    private void iniciarPortaParalela(String portaParalela){
        this.porta = new PortaParalela(portaParalela);
        imprimirTexto();
    }
    
    private void imprimirTexto(){
        texto = new StringBuilder();
        int nEspaco = 38;
        float valor=0;
        texto.append("                                      ".substring(38-"ORCAMENTO".length()));
        texto.append("ORÇAMENTO");
        texto.append("\r\n");
        texto.append("\r\n");
        texto.append("\r\n");
        nEspaco = 38 - texto.length();
        texto.append("Data : " + Formatacao.ConvercaoDataPadrao(new Date()));
        texto.append("\r\n");
        texto.append("\r\n");
        nEspaco = 38 - texto.length();
        texto.append("Codigo           Descricao");
        texto.append("\r\n");
        texto.append("Qtda   Und     Unitario     Valor");
        texto.append("\r\n");
        texto.append("________________________________________");
        texto.append("\r\n");
        imprimirProduto();
        porta.imprimirPorta(texto);
    }
    
    private void imprimirProduto() {
        String textolocal = "";
        String textoValor = "";
        Produto produto;
        int tamanho =0;
        for (int i = 0; i < listaSaida.size(); i++) {
            textolocal = "";
            textoValor = "";
            produto = new Produto();
            produto = buscarProduto(listaSaida.get(i).getProduto());
            if (produto != null) {
                valor = valor + listaSaida.get(i).getValorVenda();
                textolocal = textolocal + String.valueOf(produto.getReferencia());
                textolocal = textolocal + ("               ").substring(1, 7- textolocal.length());
                textolocal = textolocal + produto.getUnidade() + "  ";
                if (produto.getDescricao().length() > 23) {
                    textolocal = textolocal + produto.getDescricao().substring(1, 23);
                } else {
                    textolocal = textolocal + produto.getDescricao();
                }
                texto.append(textolocal);
                textolocal = "";
                texto.append("\r\n");
                textoValor = Formatacao.foramtarDoubleString(listaSaida.get(i).getQuantidade());
                textolocal = textolocal + "               ".substring(1,12 - textoValor.length());
                textolocal = textolocal + textoValor;
                textoValor = Formatacao.foramtarDoubleString(listaSaida.get(i).getValorVenda() / listaSaida.get(i).getQuantidade());
                tamanho = textoValor.length();
                textolocal = textolocal + "               ".substring(1,12 - tamanho);
                textolocal = textolocal + textoValor;
                textoValor = Formatacao.foramtarFloatString(listaSaida.get(i).getValorVenda());
                tamanho = textoValor.length();
                textolocal = textolocal + "               ".substring(1,12 - tamanho);
                textolocal = textolocal + textoValor;
                texto.append(textolocal);
                texto.append(" \r\n");
            }
        }
        texto.append("________________________________________");
        texto.append("\r\n");
        textoValor = Formatacao.foramtarFloatString(valor);
        texto.append("TOTAL    R$ : " + "                    ".substring(1,20 - textoValor.length()) + textoValor); 
        texto.append("\r\n");
        textoValor =  Formatacao.foramtarFloatString(venda.getValorDesconto());
        texto.append("DESCONTO R$ : " + "                    ".substring(1,20 - textoValor.length()) + textoValor); 
        texto.append("\r\n");
        textoValor = Formatacao.foramtarFloatString(venda.getValorVenda());
        texto.append("PAGAR    R$ : " + "                    ".substring(1,20 - textoValor.length()) + textoValor); 
        texto.append("\r\n");
        for (int l = 0; l < 10; l++) {
            texto.append("\r\n");
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
    
    
    
    
    
}
