/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import Controller.ConfiguracaoController;
import Controller.ContasReceberController;
import Controller.CreditoReceberController;
import Controller.FormaPagamentoController;
import Controller.ParcelaCartaoController;
import Regras.Formatacao;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import negocios.Vendas;
import telas.contasReceber.ContasReceberBean;
import telas.contasReceber.CreditoBean;

/**
 *
 * @author Wolverine
 */
public class RecebimentoBean {
    
    private Cliente clienteRecebimento;
    List<ContasReceberBean> listaContasReceber;
    List<CreditoBean> listaCreditosReceber;
    private double valorCredito;
    private double valorContas;
    private Fechacaixa fechaCaixa;
    private int idPagamento=0;

    public RecebimentoBean(Cliente clienteRecebimento, List<ContasReceberBean> listaContasReceber, List<CreditoBean> listaCreditosReceber, Fechacaixa fechaCaixa) {
        this.clienteRecebimento = clienteRecebimento;
        this.fechaCaixa = fechaCaixa;
        this.listaContasReceber = listaContasReceber;
        this.listaCreditosReceber = listaCreditosReceber;
        calcularValorCreditos();
        calcularValorTotalContasReceber();
  
    }
    
    

    public Cliente getClienteRecebimento() {
        return clienteRecebimento;
    }

    public void setClienteRecebimento(Cliente clienteRecebimento) {
        this.clienteRecebimento = clienteRecebimento;
    }

    public List<ContasReceberBean> getListaContasReceber() {
        return listaContasReceber;
    }

    public void setListaContasReceber(List<ContasReceberBean> listaContasReceber) {
        this.listaContasReceber = listaContasReceber;
    }

    public List<CreditoBean> getListaCreditosReceber() {
        return listaCreditosReceber;
    }

    public void setListaCreditosReceber(List<CreditoBean> listaCreditosReceber) {
        this.listaCreditosReceber = listaCreditosReceber;
    }

    public double getValorContas() {
        return valorContas;
    }

    public void setValorContas(double valorContas) {
        this.valorContas = valorContas;
    }

    public double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }
    
    
    public void calcularValorTotalContasReceber(){
        double valor =0;
        for (int i=0;i<listaContasReceber.size();i++){
            valor = valor + listaContasReceber.get(i).getValorReceber();
        }
        setValorContas(valor);
    }
    
    public void calcularValorCreditos() {
        double valor = 0;
        if (listaCreditosReceber != null) {
            for (int i = 0; i < listaCreditosReceber.size(); i++) {
                valor = valor + listaCreditosReceber.get(i).getCredito().getValorCredito();
            }
        }
        setValorCredito(valor);
    }
    
    public double calcularValorRecebidoFormaPagamento(List<Formapagamento> listaFormaPagamento, float valorTroco){
       double valor = 0;
       for (int i=0;i<listaFormaPagamento.size();i++){
           valor = valor + listaFormaPagamento.get(i).getValor();
       }
       valor = (valor + valorCredito);
       return valor;
    }
    
    public void concluirRecebimentoContasReceber(List<Formapagamento> listaFormaPagamento, double valorDesconto, float valorTroco, int idEmpresa){
        
        ContasReceberController contasReceberController = new ContasReceberController();
        Contasreceberpagamento contasreceberpagamento = new Contasreceberpagamento();
        contasreceberpagamento.setDataPagamento(new Date());
        contasreceberpagamento.setDesconto(valorDesconto);
        contasreceberpagamento.setJuros(0.0);
        contasreceberpagamento.setEmpresa(idEmpresa);
        contasreceberpagamento.setCliente(clienteRecebimento.getIdcliente());
        
        contasreceberpagamento.setValorRecebido(calcularValorRecebidoFormaPagamento(listaFormaPagamento, valorTroco));
        contasreceberpagamento.setFechaCaixa(this.fechaCaixa.getIdfechaCaixa());
        contasreceberpagamento = contasReceberController.salvarContasReceberPagamento(contasreceberpagamento);
        setIdPagamento(contasreceberpagamento.getIdcontasReceberPagamento());
        salvarContas(contasreceberpagamento);
        salvarContasReceberForma(contasreceberpagamento, listaFormaPagamento, valorTroco, idEmpresa);
        salvarCreditos(contasreceberpagamento);
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }
    
     public void salvarContas(Contasreceberpagamento contasreceberpagamento){
        ContasReceberController contasReceberController = new ContasReceberController();
        for (int i=0;i<listaContasReceber.size();i++){
            if (listaContasReceber.get(i).getTipo().equalsIgnoreCase("Conta")){
                salvarContasReceber(contasreceberpagamento, listaContasReceber.get(i).getContaReceber(), listaContasReceber.get(i).getValorReceber(), listaContasReceber.get(i).isPagtoParcial());
            }else salvarFaturaReceber(contasreceberpagamento, listaContasReceber.get(i).getFaturaParcela(), listaContasReceber.get(i).getValorReceber(), listaContasReceber.get(i).isPagtoParcial());
        }
    }
     
     public void salvarContasReceber(Contasreceberpagamento contasreceberpagamento, Contasreceber contasreceber, double valorRecebedibo, boolean pagotParcial) {
        ContasReceberController contasReceberController = new ContasReceberController();
        contasreceber.setContasreceberpagamento(contasreceberpagamento.getIdcontasReceberPagamento());
        contasreceber.setDataRecebimento(new Date());
        contasreceber = contasReceberController.salvarContasReceber(contasreceber);
        if (pagotParcial) {
            Contasreceber parcial =new Contasreceber();
            parcial.setDataLancamento(contasreceber.getDataLancamento());
            parcial.setDataVencimento(contasreceber.getDataVencimento());
            parcial.setEmpresa(contasreceber.getEmpresa());
            parcial.setMes(contasreceber.getMes());
            parcial.setNumeroDocumento(contasreceber.getNumeroDocumento());
            parcial.setNumeroFaturaGerada(contasreceber.getNumeroFaturaGerada());
            parcial.setValorConta(contasreceber.getValorConta() - valorRecebedibo);
            parcial.setVendedor(contasreceber.getVendedor());
            parcial.setCliente(contasreceber.getCliente());
            parcial.setContasreceberpagamento(1);
            contasReceberController.salvarContasReceber(parcial);
        }
    }
     
    public void salvarFaturaReceber(Contasreceberpagamento contasreceberpagamento, Faturasreceberparcelas Faturareceber, double valorRecebedibo, boolean pagtoParcial) {
        ContasReceberController contasReceberController = new ContasReceberController();
        Faturareceber.setContasreceberpagamento(contasreceberpagamento.getIdcontasReceberPagamento());
        Faturareceber.setDataRecebimento(new Date());
        Faturareceber = contasReceberController.salvarFaturaParcela(Faturareceber);
        if (!pagtoParcial){
            verificarUltimarParcelaFatura(Faturareceber.getFaturasreceber(), contasreceberpagamento.getIdcontasReceberPagamento());
        }else {
            Faturareceber.setValorParcela(Faturareceber.getValorParcela() - valorRecebedibo);
            Faturareceber.setIdFaturasReceberParcelas(null);
            Faturareceber.setContasreceberpagamento(1);
            Faturareceber.setDataVencimento(Faturareceber.getDataVencimento());
            Faturareceber.setDataLancamento(new Date());
            contasReceberController.salvarFaturaParcela(Faturareceber);
        }
        Faturasreceber fatura = contasReceberController.buscarFaturaReceber(Faturareceber.getFaturasreceber());
        if (fatura!=null){
            int numeroParcela = Faturareceber.getNumeroParcela();
            int numeroFatura = fatura.getNumeroParcelas();
            if (numeroFatura==numeroParcela){
                salvarContasReceberFatura(contasreceberpagamento, fatura);
            }
        }
    }
    
    public void salvarContasReceberFatura(Contasreceberpagamento contasreceberpagamento, Faturasreceber fatura){
        ContasReceberController contasReceberController = new ContasReceberController();
        if (fatura!=null){
            String sql = "Select c from Contasreceber c where c.numeroFaturaGerada='" + fatura.getNumeroFatura() + "'";
            List<Contasreceber> listaContasrecebers = contasReceberController.listarContas(sql);
            if (listaContasrecebers!=null){
                for(int i=0;i<listaContasrecebers.size();i++){
                    Contasreceber contasFatura = listaContasrecebers.get(i);
                    contasFatura.setContasreceberpagamento(contasreceberpagamento.getIdcontasReceberPagamento());
                    contasFatura.setDataRecebimento(contasreceberpagamento.getDataPagamento());
                    contasReceberController.salvarContasReceber(contasFatura);
                }
            }
        }
        
    }
    
    public void verificarUltimarParcelaFatura(int idFatura, int idContasReceberPagamento){
        ContasReceberController contasReceberController = new ContasReceberController();
        String sql = "Select r From Faturasreceberparcelas r where r.contasreceberpagamento=1 and r.faturasreceber=" + idFatura;
        List<Faturasreceberparcelas> listaParcelas = contasReceberController.listarFaturasParcelas(sql);
        if (listaParcelas==null){
            sql = "select f From Faturasreceber f where f.contasreceberpagamento=1 and f.idFaturasReceber="+ idFatura;
            List<Faturasreceber> fatura = contasReceberController.listarFaturas(sql);
            if ((fatura!=null) && (fatura.size()> 0)){
                Faturasreceber fat = fatura.get(0);
                if (fat!=null){
                    fat.setContasreceberpagamento(idContasReceberPagamento);
                    contasReceberController.salvarFatura(fat);
                }
            }
        }
    }
     

    
    public void salvarContasReceberForma(Contasreceberpagamento contasreceberpagamento, List<Formapagamento> listaFormaPagamento, float valorTroco, int idEmpresa) {
        ContasReceberController contasReceberController = new ContasReceberController();
        FormaPagamentoController formaPagamentoController = new FormaPagamentoController();
        listaFormaPagamento = formaPagamentoController.listarFormaPagamentoValor();
        ConfiguracaoController configuracaoController = new ConfiguracaoController();
        Configuracao configuracao = new Configuracao();
        configuracao = configuracaoController.getConfiguracao(this.fechaCaixa.getEmpresa());
        for (int i = 0; i < listaFormaPagamento.size(); i++) {
            if (listaFormaPagamento.get(i).getIdformaPagamento() != configuracao.getFormaPagamento()) {
                if (listaFormaPagamento.get(i).getValor() > 0) {
                    Contasreceberforma forma = new Contasreceberforma();
                    forma.setContasreceberpagamento(contasreceberpagamento.getIdcontasReceberPagamento());
                    forma.setFormaRecebimento(listaFormaPagamento.get(i).getDescricao());
                    forma.setIdBanco(0);
                    forma.setFormaPagamento(listaFormaPagamento.get(i).getIdformaPagamento());
                    forma.setEmpresa(idEmpresa);
                    if (listaFormaPagamento.get(i).getIdformaPagamento()==1){
                        if(valorTroco>0){
                            if (listaFormaPagamento.get(i).getValor()>valorTroco){
                                forma.setValorPago(listaFormaPagamento.get(i).getValor().doubleValue()-valorTroco);
                            }else {
                                forma.setValorPago(listaFormaPagamento.get(i).getValor().doubleValue());
                            }
                        }else {
                            forma.setValorPago(listaFormaPagamento.get(i).getValor().doubleValue());
                        }     
                    }else {
                        forma.setValorPago(listaFormaPagamento.get(i).getValor().doubleValue());
                    }
                    forma = contasReceberController.salvarContasReceberForma(forma);
                    if (listaFormaPagamento.get(i).getLocalRegistro().equalsIgnoreCase("Banco")) {
                        registarParcelaCartao(listaFormaPagamento.get(i), forma);
                    }
                }
            }
        }
        if (valorCredito>0){
            Contasreceberforma forma = new Contasreceberforma();
            forma.setContasreceberpagamento(contasreceberpagamento.getIdcontasReceberPagamento());
            forma.setFormaRecebimento("Credito Cliente");
            forma.setIdBanco(0);
            forma.setValorPago(valorCredito);
            forma.setEmpresa(idEmpresa);
            forma.setFormaPagamento(17);
            contasReceberController.salvarContasReceberForma(forma);
            
        }
    }
    
    public void salvarCreditos(Contasreceberpagamento contasReceberPagamento){
        if (this.listaCreditosReceber.size()>0){
            CreditoReceberController creditoReceberController = new CreditoReceberController();
            for(int i=0;i<listaCreditosReceber.size();i++){
                Creditosreceber credito = listaCreditosReceber.get(i).getCredito();
                credito.setContasreceberpagamento(contasReceberPagamento.getIdcontasReceberPagamento());
                credito.setUtilizado("SIM");
                creditoReceberController.salvar(credito);
            }
        }
    }
    
    public void registarParcelaCartao(Formapagamento formaPagamento, Contasreceberforma forma){
        float valorJuros = 0;
        float valorComissao = 0;
        float valorParcela =0;
        if (formaPagamento.getNumeroParcelas()==1){
            valorJuros = (float) (1+ (formaPagamento.getComissaoVista()/100));
            valorComissao = (float) (formaPagamento.getValor() * valorJuros);
        }else if (formaPagamento.getNumeroParcelas()>0){
            for(int i=0;i<formaPagamento.getNumeroParcelas();i++){
                if (valorJuros==0){
                    valorJuros = (float) (1+ (formaPagamento.getComissaoParcelado()/100));
                }else {
                    valorJuros = (float) (valorJuros * (1+ (formaPagamento.getComissaoParcelado()/100))); 
                }
            }
        }
        valorJuros = valorJuros - 1;
        valorComissao = (float) (formaPagamento.getValor() * (valorJuros));
        valorParcela = formaPagamento.getValor() - valorComissao;
        valorParcela = valorParcela / formaPagamento.getNumeroParcelas();
        valorComissao = valorComissao / formaPagamento.getNumeroParcelas();
        ParcelaCartaoController parcelaCartaoController = new ParcelaCartaoController();
        valorJuros=0;
        for(int i=0;i<formaPagamento.getNumeroParcelas();i++){
            if (valorJuros==0){
                    valorJuros = (float) (1+ (formaPagamento.getComissaoVista()/100));
            }else {
                    valorJuros = (float) (valorJuros * (1+ (formaPagamento.getComissaoParcelado()/100))); 
            }
            Parcelacartao parcelaCartao = new Parcelacartao();
            String data = null;
            try {
                data = Formatacao.SomarDatas(new Date(), ((i+1) * formaPagamento.getPrazo()), "dd/MM/yyyy");
            } catch (Exception ex) {
                Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
            }
            parcelaCartao.setDataRecebimento(Formatacao.ConvercaoStringData(data));
            parcelaCartao.setFormaVenda(0);
            parcelaCartao.setFormaContasReceber(forma.getIdcontasReceberForma());
            parcelaCartao.setNumeroParcela(i+1);
            Float perComissao = (valorJuros - 1)*100;
            parcelaCartao.setPercentualcomissao(perComissao);
            parcelaCartao.setValorCobrado(formaPagamento.getValor()/formaPagamento.getNumeroParcelas());
            parcelaCartao.setValorComissao(valorComissao);
            parcelaCartao.setValorReceber(valorParcela);
            parcelaCartao.setBanco(formaPagamento.getBanco());
            parcelaCartao.setEmpresa(formaPagamento.getEmpresa());
            parcelaCartaoController.salvar(parcelaCartao);
        }
    }    
    
}
