/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import Controller.ConfiguracaoController;
import Controller.ContasReceberController;
import Controller.FormaPagamentoController;
import Controller.GrupoProdutoController;
import Controller.IbptController;
import Controller.ParcelaCartaoController;
import Regras.Config;
import Regras.Formatacao;
import Regras.ProdutoVenda;
import facade.EstoqueFacade;
import facade.FormaVendaFacade;
import facade.ProdutoFacade;
import facade.VendaFacade;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Configuracao;
import model.Contasreceber;
import model.Contasreceberprodutos;
import model.Estoque;
import model.Fechacaixa;
import model.Formapagamento;
import model.Formavenda;
import model.Ibpt;
import model.Parcelacartao;
import model.Produto;
import model.Saida;
import model.Subgrupoproduto;
import model.Venda;
import model.Vendedor;

/**
 *
 * @author Woverine
 */
public class Vendas {

    private List<ProdutoVenda> listaProdutoVenda = new ArrayList<ProdutoVenda>();
    private Venda venda = new Venda();
    private Formavenda formaVenda = new Formavenda();
    private List<Saida> listaSaida = new ArrayList<Saida>();
    private int numeroItem;
    Config config;
    private int teclaF4 = 0;
    private List<Double> listaColorante = new ArrayList<Double>();
    private float valorDesconto;
    private double valorTributoFederal;
    private double aliquotaImpostoFederal;
    private double valorTributoEstadual;
    private double aliquotaImpostoEstadual;
    private int idCliente=0;
    private int idContasReceber=0;
    private int idEntrega=0;
    
    
    public Vendas(Config config, Fechacaixa fechaCaixa, Vendedor vendedor, int teclaF4, int fechamento, int devolucao) {
        this.venda.setDataVenda(new Date());
        this.teclaF4 = teclaF4;
        fechamento = 1;
        devolucao =0;
        this.config = config;
        this.venda.setCondicaoPagamento("A VISTA");
        Time hora = new Time(new Date().getTime());
        this.venda.setHora(hora);
         this.venda.setValorAcrescimo(0.0f);
         this.venda.setValorDesconto(0.0f);
         this.venda.setValorCompra(0.0f);
         this.venda.setValorVenda(0.0f);
         this.venda.setEmpresa(config.getEmpresa().getIdempresa());;
         this.venda.setFechacaixa(fechaCaixa.getIdfechaCaixa());
         this.venda.setVendedor(vendedor.getIdvendedor());
         this.venda.setOperador(fechaCaixa.getOperador());
         this.venda.setCaixa(fechaCaixa.getCaixa());
         this.venda.setNumeroECF("0");
         this.valorDesconto=0;
    }

    public boolean vendeItem(int referencia, double quantidade, int idEmpresa, float novoValor, float valorColorante, float percentualDesconto, int idVendedor) throws Exception {
        ProdutoVenda produtoVenda = new ProdutoVenda();
        ProdutoFacade produtoFacade = new ProdutoFacade();
        Produto produto = new Produto();
        produto = produtoFacade.getCodigoNovo(referencia);
        if (produto==null){
            produto = produtoFacade.getProdutoReferencia(referencia);
            if (produto == null) {
                return false;
            }
        }
        produtoVenda.setProduto(produto);
        produtoVenda.setQuantidade(quantidade);
        produtoVenda.setValorColorante(valorColorante);
        Estoque estoque = new Estoque();
        estoque = new EstoqueFacade().getEstoque(produto.getIdProduto(), idEmpresa);
        if (estoque == null) {
            return false;
        }
        Float valorVenda =0f;
        if (novoValor>0){
            produtoVenda.setValorUnitario(novoValor + valorColorante);
            valorVenda = novoValor + valorColorante;
        }else {
            produtoVenda.setValorUnitario(estoque.getValorVenda() + valorColorante);
            valorVenda = estoque.getValorVenda() + valorColorante;
        }
//        if (produto.getPreciFixo()==2){
//            String valor = JOptionPane.showInputDialog("Valor de Venda");
//            produtoVenda.setValorUnitario(Formatacao.formatarStringfloat(valor));
//            valorVenda = produtoVenda.getValorUnitario();
//        }
        valorVenda = valorVenda * (float) quantidade;
        Double valorCompra = estoque.getValorCusto() * quantidade;
        produtoVenda.setValorCompra(valorCompra.floatValue());
        produtoVenda.setVendedor(idVendedor);
        produtoVenda.setValorTotal(valorVenda);
        if (percentualDesconto>0){
            valorDesconto += produtoVenda.getValorTotal() * (percentualDesconto/100);
        }
        setNumeroItem();
        produtoVenda.setNumeroItem(getNumeroItem());
        Ibpt ibpt = consultarIbpt(produto.getNcm());
        if (ibpt!=null){
            produtoVenda.setAliquotoImpostoFederal(ibpt.getNacionalfederal());
            produtoVenda.setAliquotoImpostoEstadual(ibpt.getEstadual());
            produtoVenda.setValorTributoFederal(produtoVenda.getValorTotal() * (ibpt.getNacionalfederal()/100));
            if (ibpt.getEstadual()>0){
                produtoVenda.setValorTributoEstadual(produtoVenda.getValorTotal() * (ibpt.getEstadual()/100));
            }else produtoVenda.setValorTributoEstadual(0.0);
        }else {
            produtoVenda.setAliquotoImpostoFederal(26.75);
            produtoVenda.setValorTributoFederal(produtoVenda.getValorTotal() * (25.75/100));
            produtoVenda.setAliquotoImpostoEstadual(17.0);
            produtoVenda.setValorTributoEstadual(produtoVenda.getValorTotal() * (17/100));
        }
        listaProdutoVenda.add(produtoVenda);
        return true;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdContasReceber() {
        return idContasReceber;
    }

    public void setIdContasReceber(int idContasReceber) {
        this.idContasReceber = idContasReceber;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    

    public void gerarSaida(float percentualDesconto, int idEmpresa) throws Exception {
        for (int i = 0; i < listaProdutoVenda.size(); i++) {
            Saida saida = new Saida();
            saida.setProduto(listaProdutoVenda.get(i).getProduto().getIdProduto());
            saida.setQuantidade(listaProdutoVenda.get(i).getQuantidade());
            if (listaProdutoVenda.get(i).getValorColorante()>0){
                float valorColorante = (float) listaProdutoVenda.get(i).getValorColorante();
                saida.setValorVenda(listaProdutoVenda.get(i).getValorTotal() - valorColorante);
                listaColorante.add(listaProdutoVenda.get(i).getValorColorante());
            }else {
                saida.setValorVenda(listaProdutoVenda.get(i).getValorTotal());
            }
            if (percentualDesconto>0){
                saida.setValorDesconto(saida.getValorVenda() * (percentualDesconto/100));
                saida.setPercentualDesconto(percentualDesconto);
                saida.setValorVenda(saida.getValorVenda() - saida.getValorDesconto());
            }
            saida.setValorImpostofederal(listaProdutoVenda.get(i).getValorTributoFederal());
            saida.setAliquotaImpostofederal(listaProdutoVenda.get(i).getAliquotoImpostoFederal());
            saida.setValorimpostoestadual(listaProdutoVenda.get(i).getValorTributoEstadual());
            saida.setAliquotaimpostoestadual(listaProdutoVenda.get(i).getAliquotoImpostoEstadual());
            saida.setVenda(this.venda.getIdvenda());
            double valorComissao=0;
            saida.setVendedor(listaProdutoVenda.get(i).getVendedor());
            if (listaProdutoVenda.get(i).getProduto().getPercentualComissao()>0){
                valorComissao = saida.getValorVenda() * (listaProdutoVenda.get(i).getProduto().getPercentualComissao()/100);
            }else {
                GrupoProdutoController grupoProdutoController = new GrupoProdutoController();
                Subgrupoproduto subgrupoproduto = grupoProdutoController.consultarSubGrupoProduto(listaProdutoVenda.get(i).getProduto().getSubgrupoproduto());
                if (subgrupoproduto!=null){
                    if (subgrupoproduto.getPercentualComissao()>0){
                        valorComissao = saida.getValorVenda() * (subgrupoproduto.getPercentualComissao()/100);
                    }
                }
            }
            saida.setValorComissao(valorComissao);
            Float valorCompra = listaProdutoVenda.get(i).getValorCompra();
            saida.setValorCompra(valorCompra);
            if (this.venda.getValorVenda2()>0){
                saida.setValorVenda2(saida.getValorVenda());
            }
            listaSaida.add(saida);
            baixarEstoque(saida, idEmpresa);           
        }

    }
    
    public void gerarSaidaSomenteCupom() throws Exception {
        for (int i = 0; i < listaProdutoVenda.size(); i++) {
            Saida saida = new Saida();
            saida.setProduto(listaProdutoVenda.get(i).getProduto().getIdProduto());
            saida.setQuantidade(listaProdutoVenda.get(i).getQuantidade());
            if (listaProdutoVenda.get(i).getValorColorante()>0){
                float valorColorante = (float) listaProdutoVenda.get(i).getValorColorante();
                saida.setValorVenda2(listaProdutoVenda.get(i).getValorTotal() - valorColorante);
                listaColorante.add(listaProdutoVenda.get(i).getValorColorante());
            }else {
                saida.setValorVenda2(listaProdutoVenda.get(i).getValorTotal());
            }
            saida.setValorImpostofederal(listaProdutoVenda.get(i).getValorTributoFederal());
            saida.setAliquotaImpostofederal(listaProdutoVenda.get(i).getAliquotoImpostoFederal());
            saida.setValorimpostoestadual(listaProdutoVenda.get(i).getValorTributoEstadual());
            saida.setAliquotaimpostoestadual(listaProdutoVenda.get(i).getAliquotoImpostoEstadual());
            saida.setVenda(this.venda.getIdvenda());
            Double valorCompra = calcularValorCusto(saida.getProduto());
            valorCompra = valorCompra * saida.getQuantidade();
            saida.setValorCompra(valorCompra.floatValue());
            saida.setValorVenda(0.0f);
            listaSaida.add(saida);
            baixarEstoqueSomenteCupom(saida);           
        }

    }


    public void gravarSaida() throws Exception{
        VendaFacade vendaFacade = new VendaFacade();
        for (int i=0;i<listaSaida.size();i++){
            Saida saida = new Saida();
            saida = listaSaida.get(i);
            vendaFacade.gravarSaida(saida);
        }
    }

    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }
    
    
    
    public void gravarColorante(){
        VendaFacade vendaFacade = new VendaFacade();
        Venda vendaEfetuada = null;
        try {
            vendaEfetuada = vendaFacade.ultimaVendaGravada();
        } catch (Exception ex) {
            Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProdutoFacade produtoFacade = new ProdutoFacade();
        Produto produto = null;
        try {
            produto = produtoFacade.getProdutoReferencia(16113);
        } catch (Exception ex) {
            Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i=0;i<listaColorante.size();i++){
            Saida saida = new Saida();
            saida.setProduto(produto.getIdProduto());
            saida.setQuantidade(1.0);
            saida.setValorVenda(listaColorante.get(i).floatValue());
            saida.setVenda(vendaEfetuada.getIdvenda());
            saida.setValorCompra(0.01f);
            saida.setVendedor(venda.getVendedor());
            try {
                vendaFacade.gravarSaida(saida);
            } catch (Exception ex) {
                Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro Salvar Colorante");
            }
        }
    }
    
    public void baixarEstoque(Saida saida, int idEmpresa) throws Exception {
        Estoque estoque = new Estoque();
        EstoqueFacade estoqueFacade = new EstoqueFacade();
        estoque = estoqueFacade.getEstoque(saida.getProduto(), idEmpresa);
        estoque.setQuantidadeEstoque((estoque.getQuantidadeEstoque().doubleValue() - saida.getQuantidade().doubleValue()));
        if (this.venda.getValorVenda2()>0){
            estoque.setQuantidadaMaxima(estoque.getQuantidadaMaxima() - saida.getQuantidade());
        }
        estoque.setDataVenda(new Date());
        estoqueFacade.baixarEstoque(estoque);

    }
    
    public void baixarEstoqueSomenteCupom(Saida saida) throws Exception {
        Estoque estoque = new Estoque();
        EstoqueFacade estoqueFacade = new EstoqueFacade();
        estoque = estoqueFacade.getEstoque(saida.getProduto(), 1);
        estoque.setQuantidadaMaxima(estoque.getQuantidadaMaxima() - saida.getQuantidade());
        estoqueFacade.baixarEstoque(estoque);

    }

    public void FinalizarVenda(double valorDesconto, double valorAcrescimo, List<Formapagamento> listaFormaPagamento, boolean situacao, double percentualDesconto, int idEmpresa) throws Exception {
        this.venda.setNumeroItem(listaProdutoVenda.size());
        this.venda.setValorVenda(TotalVenda());
        this.venda.setValorCompra(TotalCompra());
        this.venda.setValorAcrescimo((float) valorAcrescimo);
        this.venda.setValorDesconto((float) valorDesconto);
        this.venda.setPercentualDesconto((float) percentualDesconto);
        if (situacao==true){
            this.venda.setValorVenda2(this.venda.getValorVenda());
        }
        this.venda.setAliquotaImpostofederal(getAliquotaImpostoFederal());
        this.venda.setValorImpostofederal(getValorTributoFederal());
        this.venda.setAliquotaimpostoestadual(getAliquotaImpostoEstadual());
        this.venda.setValorimpostoestadual(getValorTributoEstadual());
        if (idContasReceber>0){
            this.venda.setCondicaoPagamento("A PRAZO");
        }
        VendaFacade vendaFacade = new VendaFacade();
        this.venda = vendaFacade.gravarVendas(this.venda);
        registrarFormasPagamento(listaFormaPagamento);
        gerarSaida(this.venda.getPercentualDesconto(), idEmpresa);
        gravarSaida();
        gravarColorante();
        gravarCupomContaReceber();
    }
    
    public void FinalizarVendaSomenteCupom(double valorDesconto, double valorAcrescimo, List<Formapagamento> listaFormaPagamento) throws Exception {
        this.venda.setNumeroItem(listaProdutoVenda.size());
        this.venda.setValorVenda2(TotalVenda());
        this.venda.setValorVenda(0.0f);
        this.venda.setValorCompra(TotalCompra());
        this.venda.setValorAcrescimo((float) valorAcrescimo);
        this.venda.setValorDesconto((float) valorDesconto);
        VendaFacade vendaFacade = new VendaFacade();
        this.venda = vendaFacade.gravarVendas(this.venda);
        registrarFormasPagamento(listaFormaPagamento);
        gerarSaidaSomenteCupom();
        gravarSaida();
    }

    public Float TotalVenda() {
        Float valor = 0.0f;
        for (int i = 0; i < this.listaProdutoVenda.size(); i++) {
            valor = valor + listaProdutoVenda.get(i).getValorTotal();
        }
        return  valor;
    }

    public Float TotalPagar(){
        float valorTotal = TotalVenda();
        float valorPagar = (valorTotal + this.venda.getValorAcrescimo()) - this.venda.getValorDesconto();
        return valorPagar;
    }

     public Float TotalCompra() {
        Float valor = 0.0f;
        for (int i = 0; i < this.listaProdutoVenda.size(); i++) {
            valor = valor + listaProdutoVenda.get(i).getValorCompra();
        }
        return  valor;
    }

     public Float CalcularDiferenca(List<Formapagamento> listaFormaPagamento){
        float valorRecebido =0.0f;
         for(int i=0;i<listaFormaPagamento.size();i++){
             valorRecebido = valorRecebido + listaFormaPagamento.get(i).getValor();
        }
        return TotalPagar() - valorRecebido;
     }

     public Float calculcarTroco(List<Formapagamento> listaFormaPagamento){
         float valorRecebido =0.0f;
         for(int i=0;i<listaFormaPagamento.size();i++){
            valorRecebido = valorRecebido + listaFormaPagamento.get(i).getValor();
        }
        return valorRecebido - TotalPagar();
     }
     
     public Float calculcarTrocoFechamento(List<Formapagamento> listaFormaPagamento){
         float valorRecebido =0.0f;
         for(int i=0;i<listaFormaPagamento.size();i++){
            if (listaFormaPagamento.get(i).getIdformaPagamento()!=10){
                valorRecebido = valorRecebido + listaFormaPagamento.get(i).getValor();
            }
        }
        return valorRecebido - TotalPagar();
     }

    public void calcularDesconto(float valorDesconto){
        this.venda.setValorDesconto(valorDesconto);
    }
    

    public void calcularAcrescimo(float valorAcrescimo){
        this.venda.setValorAcrescimo(valorAcrescimo);
    }

    public Formavenda getFormaVenda() {
        return formaVenda;
    }

    public void setFormaVenda(Formavenda formaVenda) {
        this.formaVenda = formaVenda;
    }

    public List<ProdutoVenda> getListaProdutoVenda() {
        return listaProdutoVenda;
    }

    public void setListaProdutoVenda(List<ProdutoVenda> listaProdutoVenda) {
        this.listaProdutoVenda = listaProdutoVenda;
    }

    public List<Saida> getListaSaida() {
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

    public ProdutoVenda retornaUltimaItemVendido(){
        int i = listaProdutoVenda.size()-1;
        return listaProdutoVenda.get(i);
    }



    public List<Formavenda> registrarFormasPagamento(List<Formapagamento> listaFormaPagamento) throws Exception{
        FormaPagamentoController formaPagamentoController = new FormaPagamentoController();
        listaFormaPagamento = formaPagamentoController.listarFormaPagamentoValor();
        List<Formavenda> listaFormaVenda = new ArrayList<Formavenda>();
        FormaVendaFacade formaVendaFacade = new FormaVendaFacade();
        ConfiguracaoController configuracaoController = new ConfiguracaoController();
        Configuracao configuracao = new Configuracao();
        configuracao = configuracaoController.getConfiguracao(this.config.getEmpresa().getIdempresa());
        float troco = calculcarTrocoFechamento(listaFormaPagamento);
        for (int i = 0; i < listaFormaPagamento.size(); i++) {
            if (listaFormaPagamento.get(i).getIdformaPagamento() != configuracao.getFormaPagamento()) {
                Formavenda registrarFormaVenda = new Formavenda();
                if (listaFormaPagamento.get(i).getValor() > 0) {
                    if (listaFormaPagamento.get(i).getIdformaPagamento()==1){
                        if (troco>0){
                            registrarFormaVenda.setValorRecebido(listaFormaPagamento.get(i).getValor()-troco);
                            troco=0;
                        }else {
                            registrarFormaVenda.setValorRecebido(listaFormaPagamento.get(i).getValor());
                        }
                    }else {
                        if (listaFormaPagamento.get(i).getIdformaPagamento()==17){
                            if (troco>0){
                                registrarFormaVenda.setValorRecebido(listaFormaPagamento.get(i).getValor());
                                registarTrocoDevolucao(troco);
                                troco=0;
                            }else {
                                registrarFormaVenda.setValorRecebido(listaFormaPagamento.get(i).getValor());
                            }
                        }else {
                            registrarFormaVenda.setValorRecebido(listaFormaPagamento.get(i).getValor());
                        }                        
                    }                 
                    registrarFormaVenda.setVenda(this.venda.getIdvenda());
                    registrarFormaVenda.setFormapagamento(listaFormaPagamento.get(i).getIdformaPagamento());
                    registrarFormaVenda = formaVendaFacade.gravarFormaVenda(registrarFormaVenda);
                    if (listaFormaPagamento.get(i).getLocalRegistro().equalsIgnoreCase("Banco")){
                       registarParcelaCartao(listaFormaPagamento.get(i), registrarFormaVenda);
                    }
                    listaFormaVenda.add(registrarFormaVenda);
                }
            }
        }
        return listaFormaVenda;
    }
    
    public double calcularComissaoCartao(Formapagamento formaPagamento){
        double valorComissao = 0;
        double percentual = 0;
        if (formaPagamento.getNumeroParcelas()>1){
            if (formaPagamento.getComissaoParcelado()>0){
                percentual = formaPagamento.getComissaoParcelado();
            }else if (formaPagamento.getNumeroParcelas()<=3){
//                      percentual = formaPagamento.getComissaoParcelado01();
            }else if (formaPagamento.getNumeroParcelas()<=6){
     ///               percentual = formaPagamento.getComissaoParcelado02();
            }//else percentual = formaPagamento.getComissaoParcelado03();
            percentual = percentual * formaPagamento.getNumeroParcelas();
        }else {
            percentual = formaPagamento.getComissaoVista();
        }
        valorComissao = formaPagamento.getValor() * (percentual/100);
        return valorComissao;
        
    }

    public void excluirItemVenda(int item){
        this.listaProdutoVenda.remove(item);
    }

    public int getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem() {
        this.numeroItem = this.numeroItem + 1;
    }  
    
    public Double calcularValorCusto(int idProduto) {
        EstoqueFacade estoqueFacade = new EstoqueFacade();
        Estoque estoque;
        try {
            estoque = estoqueFacade.getEstoque(idProduto, this.config.getEmpresa().getIdempresa());
             if (estoque!=null){
            return estoque.getValorCusto();
        }else return 0.0;
        } catch (Exception ex) {
            Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
            return 0.0;
        }
       
    }
    
    public void registarParcelaCartao(Formapagamento formaPagamento, Formavenda formaVenda){
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
            parcelaCartao.setFormaVenda(formaVenda.getIdformaVenda());
            parcelaCartao.setFormaContasReceber(0);
            parcelaCartao.setNumeroParcela(i+1);
            parcelaCartao.setEmpresa(config.getEmpresa().getIdempresa());
            Float perComissao = (valorJuros - 1)*100;
            parcelaCartao.setPercentualcomissao(perComissao);
            parcelaCartao.setValorCobrado(formaPagamento.getValor()/formaPagamento.getNumeroParcelas());
            parcelaCartao.setValorComissao(valorComissao);
            parcelaCartao.setValorReceber(valorParcela);
            parcelaCartao.setBanco(formaPagamento.getBanco());
            parcelaCartaoController.salvar(parcelaCartao);
        }
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }
    
    public void registarTrocoDevolucao(Float valorTroco){
        FormaVendaFacade formaVendaFacade = new FormaVendaFacade();
        Formavenda fv = new Formavenda();
        fv.setFormapagamento(1);
        float novoTroco = 2*valorTroco;
        fv.setValorRecebido(valorTroco-novoTroco);
        fv.setVenda(this.venda.getIdvenda());
        try {
            formaVendaFacade.gravarFormaVenda(fv);
        } catch (Exception ex) {
            Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Ibpt consultarIbpt(String ncm){
        IbptController ibptController = new IbptController();
        Ibpt ibpt = ibptController.cunsultarIbpt(ncm);
        return ibpt;
    }
    
    public void calcularValorTributos(){
        double valorFederal = 0;
        double percentualFederal=0;
        double valorEstadual = 0;
        double percentualEstadual=0;
        for (int i=0;i<listaProdutoVenda.size();i++){
            valorFederal = valorFederal + listaProdutoVenda.get(i).getValorTributoFederal();
            percentualFederal = percentualFederal + listaProdutoVenda.get(i).getAliquotoImpostoFederal();
            valorEstadual = valorEstadual + listaProdutoVenda.get(i).getValorTributoEstadual();
            percentualEstadual = percentualEstadual + listaProdutoVenda.get(i).getAliquotoImpostoEstadual();
        }
        setAliquotaImpostoFederal(percentualFederal/listaProdutoVenda.size());
        setValorTributoFederal(valorFederal);
        setAliquotaImpostoEstadual(percentualEstadual/listaProdutoVenda.size());
        setValorTributoEstadual(valorEstadual);
    }

    public double getValorTributoFederal() {
        return valorTributoFederal;
    }

    public void setValorTributoFederal(double valorTributoFederal) {
        this.valorTributoFederal = valorTributoFederal;
    }

    public double getAliquotaImpostoFederal() {
        return aliquotaImpostoFederal;
    }

    public void setAliquotaImpostoFederal(double aliquotaImpostoFederal) {
        this.aliquotaImpostoFederal = aliquotaImpostoFederal;
    }

    public double getValorTributoEstadual() {
        return valorTributoEstadual;
    }

    public void setValorTributoEstadual(double valorTributoEstadual) {
        this.valorTributoEstadual = valorTributoEstadual;
    }

    public double getAliquotaImpostoEstadual() {
        return aliquotaImpostoEstadual;
    }

    public void setAliquotaImpostoEstadual(double aliquotaImpostoEstadual) {
        this.aliquotaImpostoEstadual = aliquotaImpostoEstadual;
    }

    
    
    public void gravarCupomContaReceber(){
        ContasReceberController contasReceberController = new ContasReceberController();
        Contasreceber contasReceber = contasReceberController.getContasReceber(getIdContasReceber());
        if (contasReceber!=null){
            contasReceber.setNumeroDocumento(getVenda().getNumeroECF());
            contasReceberController.salvarContasReceber(contasReceber);
        }
    }
    
 
 
 
 
 
 
 
    
    
}