/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.contasReceber;

import java.util.Date;
import model.Contasreceber;
import model.Faturasreceberparcelas;

/**
 *
 * @author Wolverine
 */
public class ContasReceberBean {
    
    private Contasreceber contaReceber;
    private Faturasreceberparcelas faturaParcela;
    private String numeroDocumento;
    private Date dataLancamento;
    private Date dataVencimento;
    private double valorConta;
    private String pagamento;
    private String Tipo;
    private double valorReceber;
    private boolean pagtoParcial;
    private boolean terminal=false;

    public ContasReceberBean(Contasreceber contaReceber) {
        setContaReceber(contaReceber);
    }

    public ContasReceberBean(Faturasreceberparcelas faturaParcela) {
        setFaturaParcela(faturaParcela);
    }

    
    
    public Contasreceber getContaReceber() {
        return contaReceber;
    }

    public void setContaReceber(Contasreceber contaReceber) {
        this.contaReceber = contaReceber;
        registarDadosContasReceber(contaReceber);
        
    }

    public boolean isTerminal() {
        return terminal;
    }

    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }

    public Faturasreceberparcelas getFaturaParcela() {
        return faturaParcela;
    }

    public void setFaturaParcela(Faturasreceberparcelas faturaParcela) {
        this.faturaParcela = faturaParcela;
         registarDadosParcelaFatura(faturaParcela);
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public boolean isPagtoParcial() {
        return pagtoParcial;
    }

    public void setPagtoParcial(boolean pagtoParcial) {
        this.pagtoParcial = pagtoParcial;
    }

   
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public double getValorConta() {
        return valorConta;
    }

    public void setValorConta(double valorConta) {
        this.valorConta = valorConta;
    }

   

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValorReceber() {
        return valorReceber;
    }

    public void setValorReceber(double valorReceber) {
        this.valorReceber = valorReceber;
    }
    
   
    
    private void registarDadosParcelaFatura(Faturasreceberparcelas faturaParcela){
        if (faturaParcela.getDataLancamento()!=null){
            setDataLancamento(faturaParcela.getDataLancamento());
        }
        if (faturaParcela.getDataVencimento()!=null){
            setDataVencimento(faturaParcela.getDataVencimento());
        }
        setNumeroDocumento(faturaParcela.getNumeroDocumento());
        setTipo("Fatura");
        setValorConta(faturaParcela.getValorParcela());
        setPagamento("NAO");
        setValorReceber(0);
    }
    
    private void registarDadosContasReceber(Contasreceber contasReceber){
        if (contasReceber.getDataLancamento()!=null){
            setDataLancamento(contasReceber.getDataLancamento());
        }
        if (contasReceber.getDataVencimento()!=null){
            setDataVencimento(contasReceber.getDataVencimento());
        }
        setNumeroDocumento(contasReceber.getNumeroDocumento());
        setTipo("Conta");
        setValorConta(contasReceber.getValorConta());
        setPagamento("NAO");
        setValorReceber(0);
    }
 
}
