/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.List;
import model.Cliente;
import model.Formapagamento;
import model.Terminalcliente;
import telas.contasReceber.ContasReceberBean;
import telas.contasReceber.CreditoBean;

/**
 *
 * @author Angela
 */
public interface ItelaVenda {
    
    public void finalizarCadastroTeminalCliente();
    public void finalizarBuscaTerminalCliente(Terminalcliente terminalCliente);
    public void mensagemCupomFiscal(String msg1, String msg2, String msg3);
    public void consultarClienteRecebimneto(Cliente clinte);
    public void consultarListarContasReceber (List<ContasReceberBean> listaContasReceber, List<CreditoBean> listaCreditosRecber, Cliente cliente);
    public void cancelarOperacaoContasReeber();
    public void gerarFormaPagamentoCartao();
}
