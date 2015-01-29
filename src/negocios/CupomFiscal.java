/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import Regras.Formatacao;
import java.util.List;
import javax.swing.JOptionPane;
import model.Formapagamento;

/**
 *
 * @author Wolverine
 */
public class CupomFiscal {
    
    List<Formapagamento> listaFormaPagamento;
    ECFBematech ecf;
    
    
    public void fecharCupom(Vendas venda, ECFBematech ecf, float valorDesconto, List<Formapagamento> listaFormaPagamento, String mensagemCupom) {
        this.listaFormaPagamento = listaFormaPagamento;
        this.ecf = ecf;
        venda.getVenda().setNumeroECF(ecf.numeroCupom());
        ecf.iniciaFechamentoCupom("D", "$", Formatacao.formatarStringBematech(valorDesconto));
        efetuarFormaPagamento();
        ecf.terminaFechamentoCupom(mensagemCupom);
    }
    
    public void efetuarFormaPagamento(){
        for (int i=0;i<this.listaFormaPagamento.size();i++){
            if (listaFormaPagamento.get(i).getValor()>0){
                float valor = listaFormaPagamento.get(i).getValor();
                gerarMensagemECF(ecf.efetuaFormaPagamento(listaFormaPagamento.get(i).getDescricao(), Formatacao.formatarStringBematech(valor)));
            }
        }

    }
    
    public void gerarMensagemECF(String msg){
        if (msg!=null){
            JOptionPane.showMessageDialog(null, msg);
        }
    }
    
  
    
}
