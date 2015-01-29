/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package negocios;

import Regras.Config;
import Regras.Formatacao;
import Regras.ProdutoVenda;
import bemajava.BemaString;
import bemajava.Bematech;

import facade.AliquotaFacade;
import facade.EmissorEcfFacade;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Aliquota;
import model.Emissorecf;

/**
 *
 * @author Wolverine
 */
public class ECFBematech {
    

    int iRetorno;
    private BemaString chavePrivada;
    private BemaString chavePublica;



    public String verificarRetornoECF(){
        if (iRetorno==0){
            return "Erro de Comunicação";
        }else if (iRetorno==-2){
            return "Parâmetro Inválido na Função";
        }else if (iRetorno==-4){
            return "Arquivo BemaFI32 não encontrado";
        }else if (iRetorno==-5){
            return "Erro abrir porta de Comunicação";
        }else if (iRetorno==-6){
            return "Impressora desligada ou cabo de comunicação desconectado.";
        }else if (iRetorno==-3){
            return "Aliquota de ICMS não programada";
        }else return null;
    }

    public String abreCupomFiscal(){
        iRetorno = Bematech.AbreCupom("");
        return verificarRetornoECF();
    }

    public String usaUnidadeMedida(String unidade){
        iRetorno = Bematech.UsaUnidadeMedida(unidade);
        return verificarRetornoECF();
    }

    public String converterAliquoICMS(String aliquota){
        String naliquota = aliquota;
        if (naliquota.equalsIgnoreCase("17,00%")){
            return "1700";
        }else if (naliquota.equalsIgnoreCase("12,00%")){
            return "1200";
        }else if (naliquota.equalsIgnoreCase("7,00")){
            return "700";
        }else if (naliquota.equalsIgnoreCase("25,00")){
            return "2500";
        }else if (naliquota.equalsIgnoreCase("ISENTO")){
            return "II";
        }else return "FF";
    }

    public String vendeItem(ProdutoVenda produtoVenda){
        String cCodigo = null;
        if (produtoVenda.getProduto().getCodigoNovo()==0){
            cCodigo = String.valueOf(produtoVenda.getProduto().getReferencia());
        }else cCodigo = String.valueOf(produtoVenda.getProduto().getCodigoNovo());
        String cDescricao = null;
        if (produtoVenda.getProduto().getDescricao().length()>29){
            cDescricao     = produtoVenda.getProduto().getDescricao().substring(0, 28);
        }else cDescricao = produtoVenda.getProduto().getDescricao();
        String cAliquota = converterAliquoICMS(buscarAliquota(produtoVenda.getProduto().getAliquota()).getDescricao());
        String cTipoQtde = "F";
        String cQtde  = Formatacao.formatarStringBematech(produtoVenda.getQuantidade());
        int iCasasDecimais = 2;
        String cValor = Formatacao.formatarStringBematech(produtoVenda.getValorUnitario());
        String cTipoDesconto  = "%";
        String cValorDesc     = "0000";

        iRetorno = Bematech.VendeItem(cCodigo, cDescricao, cAliquota, cTipoQtde, cQtde, iCasasDecimais,
                cValor, cTipoDesconto, cValorDesc);
        return verificarRetornoECF();
    }

    public String cancelaItemAterior(){
        iRetorno = Bematech.CancelaItemAnterior();
        return verificarRetornoECF();
    }

    public String cancelaItemGenerico(String item){
        iRetorno = Bematech.CancelaItemGenerico(item);
        return verificarRetornoECF();
    }

    public String iniciaFechamentoCupom(String cAcreDesc, String cTipoAcreDesc, String cValorAcreDesc){
        iRetorno = Bematech.IniciaFechamentoCupom(cAcreDesc, cTipoAcreDesc, cValorAcreDesc);
        return verificarRetornoECF();
    }

    public String efetuaFormaPagamento(String cFormaPgto, String cValorPago){
        iRetorno = Bematech.EfetuaFormaPagamento(cFormaPgto, cValorPago);
        return verificarRetornoECF();
    }

    public String terminaFechamentoCupom(String mensagem){
        if (mensagem==null){
            mensagem = "MD5: 1c44fb0475ad0123e72ba33a93e3fb2e\r\n";
            mensagem = "VOLTE SEMPRE!!!!!";
        }else {
            String novaMesagem = mensagem;
            mensagem = "MD5: 1c44fb0475ad0123e72ba33a93e3fb2e\r\n" + novaMesagem;
        }
        iRetorno = Bematech.TerminaFechamentoCupom(mensagem);
        return verificarRetornoECF();
    }

    public String cancelaCupomFiscal(){
        iRetorno = Bematech.CancelaCupom();
        return verificarRetornoECF();
    }
    
    
    //Relatorio PAF
    
    public String leituraX(){
        iRetorno = Bematech.LeituraX();
        return verificarRetornoECF();
    }
    
    public String LeituraMemoriaFiscalDataImpressora(String dataInicial, String dataFinal, String tipo){
        iRetorno = Bematech.LeituraMemoriaFiscalDataMFD(dataInicial, dataFinal, tipo);
        return verificarRetornoECF();
    }
    
    public String leituraMemoriaFiscalDataArquivo(String dataInicial, String dataFinal, String tipo){
        gerarChavesAssinatura();
        iRetorno = Bematech.LeituraMemoriaFiscalSerialDataPAFECF(dataInicial, dataFinal, tipo, chavePublica.toString(), chavePrivada.toString());
        gravarRegistroEADArquivo("c:\\RETORNO.TXT");
        return verificarRetornoECF();
    }
    
    public String LeituraMemoriaFiscalReducaoImpressora(String reducaoInicial, String reducaoFinal, String tipo){
        iRetorno = Bematech.LeituraMemoriaFiscalReducaoMFD(reducaoInicial, reducaoFinal, tipo);
        return verificarRetornoECF();
    }
    
    public String leituraMemoriaFiscalReducaoArquivo(String reducaoInicial, String reducaoFinal, String tipo){
        gerarChavesAssinatura();
        iRetorno = Bematech.LeituraMemoriaFiscalSerialReducaoPAFECF(reducaoInicial, reducaoFinal, tipo, chavePublica.toString(), chavePrivada.toString());
        gravarRegistroEADArquivo("c:\\RETORNO.TXT");
        return verificarRetornoECF();
    }
    
    public String espelhoMDF(String nomeArquivo, String dadoInicial, String dadoFinal, String tipo, String usuario){
        gerarChavesAssinatura();
        iRetorno = Bematech.EspelhoMFD(nomeArquivo, dadoInicial, dadoFinal, tipo, usuario, chavePublica.toString(), chavePrivada.toString());
        gravarRegistroEADArquivo(nomeArquivo);
        return verificarRetornoECF();
    }
    
    
    public String arquivoMDF(String dadoInicial, String dadoFinal, String tipo, String usuario, int tipoGeracao){
        gerarChavesAssinatura();
        iRetorno = Bematech.ArquivoMFD("", dadoInicial, dadoFinal, tipo, usuario, tipoGeracao,  chavePublica.toString(),chavePrivada.toString(), 1);
        gravarRegistroEADArquivo("");
        return verificarRetornoECF();
        
    }
    
    public String identificacaoPAFECF(int idEmpresa){
        iRetorno = Bematech.NomeiaRelatorioIdentificacaoPAFECF();
        String indiceRelatorio;
        if (iRetorno<10){
            indiceRelatorio = '0'  + String.valueOf(iRetorno);
        }else {
            indiceRelatorio = String.valueOf(iRetorno);
        }
        String numeroImpressoras = "";
        EmissorEcfFacade emissorEcfFacade = new EmissorEcfFacade();
        List<Emissorecf> listaEmissorecf = null;
        try {
            listaEmissorecf = emissorEcfFacade.listarEmissorEcf(idEmpresa);
        } catch (Exception ex) {
            Logger.getLogger(ECFBematech.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (listaEmissorecf!=null){
            for(int i=0;i<listaEmissorecf.size();i++){
                numeroImpressoras  = numeroImpressoras + listaEmissorecf.get(i).getNumeroSerie() + " ";
            }
        }
        iRetorno = Bematech.IdentificacaoPAFECF(indiceRelatorio, "laudo", "00445335/0001-13", "Compufour Software Ltda", "Travessa Nazareno Brusco, 80 - Centro - Concordia SC - CEP 89700000",
                                       "(49)3442-0122", "Wagner Muller", "CompuFour Software", "2013", "c:\\Arquivo Programas\\CompFour\\Aplicativos Comerciais\\fiscal1.exe",
                                       "1c44fb0475ad0123e72ba33a93e3fb2e", " ", " ", numeroImpressoras);
        return verificarRetornoECF();
   }

    public String reducaoZ(Date data, Config config){
        //iRetorno = Bematech.ReducaoZ("", "");
        if (verificarDataReducaoZ(data)){
            iRetorno = Bematech.ReducaoZImpAntiga(); 
            if (iRetorno==1){
                gravarDataReducaoZ(config);
            }
            return verificarRetornoECF();
        }else { 
            JOptionPane.showMessageDialog(null, "Redução Z já emitida nesta data");
            return null;
        }  
    } 

    public String acionaGaveta(){
        iRetorno = Bematech.AcionaGaveta();
        return verificarRetornoECF();
    }

    public String verificaImpressoraLigada(){
        iRetorno = Bematech.VerificaImpressoraLigada();
        return verificarRetornoECF();
    }
    
    public String abreProtaSerial(int numPorta){
         iRetorno = Bematech.AbrePortaSerial();
       return verificarRetornoECF();
    }
    
    public BemaString   retornoAliquotas(){
        BemaString bs = null;
        iRetorno = Bematech.RetornoAliquotas(bs);
        return bs;
    }
    
    public String numeroCupom(){
        BemaString numerocupom;
        numerocupom = new BemaString();
        iRetorno = Bematech.NumeroCupom( numerocupom );
        String numero = numerocupom.getBuffer();
        return numero;
    }
    
    public boolean verificarSerieECF(String numeroSerie){
        String numeroECF = new String();
        for (int i=0;i<21;i++){
            numeroECF = numeroECF + "";
        }
        BemaString numero = new BemaString();
        iRetorno = Bematech.NumeroSerieMFD(numero);
        numeroECF = numero.getBuffer().toString();
        if (numero.getBuffer().equalsIgnoreCase(numeroSerie)){
            return true;   
        }
        return false;
    }
    
    public boolean verificarDataReducaoZ(Date data){
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");   
        Date dataReducao = null;   
        String sData = sd.format(data);
        try {
              dataReducao = sd.parse(sData);
              if(dataReducao.after(new Date())) {   
              return false;
        } else return true;
        } catch (ParseException ex) {
            Logger.getLogger(ECFBematech.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void gravarDataReducaoZ(Config config){
        config.getEmissorECF().setDataReducaoZ(new Date());
        EmissorEcfFacade facade = new EmissorEcfFacade();
        try {
            facade.salvarEmissorEcf(config.getEmissorECF());
        } catch (Exception ex) {
            Logger.getLogger(ECFBematech.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Aliquota buscarAliquota(int idAliquota){
      AliquotaFacade aliquotaFacade = new AliquotaFacade();
        try {
            return aliquotaFacade.getAliquota(idAliquota);
        } catch (SQLException ex) {
            Logger.getLogger(ECFBematech.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,  "Erro consultar Aliquota");
            return null;
        }
    }
    
    public void gravarFormaPagamento(String forma, String tef){
        iRetorno = Bematech.ProgramaFormaPagamentoMFD(forma, tef);
    }
    
    public void emitirComprovanteCreditoDevolucao(String nome, double valor){
        iRetorno = Bematech.AbreComprovanteNaoFiscalVinculado(nome, " ", " ");
    }
    
    public String gerarChavesAssinatura(){
        iRetorno = Bematech.genkkey(chavePublica, chavePrivada);
        return verificarRetornoECF();
    }
    
    public String gravarRegistroEADArquivo(String arquivo){
        BemaString registroEAD = new BemaString();
        iRetorno = Bematech.generateEAD(arquivo, chavePublica.toString(), chavePrivada.toString(), registroEAD, 1);
        return verificarRetornoECF();
    }
    
    public String abreRelatorioGerencial(String texto){
        iRetorno = Bematech.RelatorioGerencial(texto);
        return verificarRetornoECF();
    }
    
    public String fechaRelatorioGererncial(){
        iRetorno = Bematech.FechaRelatorioGerencial();
        return verificarRetornoECF();
    }
}
