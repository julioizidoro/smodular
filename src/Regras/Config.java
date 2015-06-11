/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Regras;

import facade.EmissorEcfFacade;
import facade.EmpresaFacade;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Emissorecf;
import model.Empresa;



/**
 *
 * @author Woverine
 */
public class Config {

    private String idCaixa;
    private String versaoSitema;
    private Empresa empresa;
    private String ini;
    private Emissorecf emissorECF;
    private String dataReducaoZ;
    private String portaParalela;
    private String portaSerial;
    private int vendedor;

    public String getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(String idCaixa) {
        this.idCaixa = idCaixa;
    }

    public String getPortaSerial() {
        return portaSerial;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public void setPortaSerial(String portaSerial) {
        this.portaSerial = portaSerial;
    }

    public String getVersaoSitema() {
        return versaoSitema;
    }

    public void setVersaoSitema(String versaoSitema) {
        this.versaoSitema = versaoSitema;
    }

    

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getIni() {
        return ini;
    }

    public void setIni(String ini) {
        this.ini = ini;
    }

    public Emissorecf getEmissorECF() {
        return emissorECF;
    }

    public void setEmissorECF(Emissorecf emissorECF) {
        this.emissorECF = emissorECF;
    }

    public String getDataReducaoZ() {
        return dataReducaoZ;
    }

    public void setDataReducaoZ(String dataReducaoZ) {
        this.dataReducaoZ = dataReducaoZ;
    }

    public void carregarConfiguracao() {
       String localIni = System.getProperty("user.dir");
        localIni = Formatacao.configurarCaminhoArquivos(localIni);
        File file = new File(localIni + "/smodular.properties");
        Properties props = new Properties();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            //lê os dados que estão no arquivo
            props.load(fis);
            fis.close();
            setIdCaixa(props.getProperty("idCaixa"));
            setVersaoSitema(props.getProperty("sistema"));
            String id = props.getProperty("empresa");
            setIni(props.getProperty("caminhoini"));
            carregarEmpresa(Integer.parseInt(id));
            id = props.getProperty("emissorECF");
            setDataReducaoZ(props.getProperty("dataReducaoZ"));
            carregarEmissorECF(Integer.parseInt(id));
            setPortaParalela(props.getProperty("portaParalela"));
            setPortaSerial(props.getProperty("portaSerial"));
            setVendedor(Integer.parseInt(props.getProperty("vendedor")));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }


    }
    
    public void carregarEmpresa(int idEmpresa){
        EmpresaFacade empresaFacade = new EmpresaFacade();
        try {
            this.empresa = empresaFacade.buscarEmpresa(idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void carregarEmissorECF(int idEmissorEcf){
        EmissorEcfFacade emissorEcfFacade = new EmissorEcfFacade();
        try {
            this.emissorECF = emissorEcfFacade.getEmissorEcf(idEmissorEcf);
        } catch (Exception ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getPortaParalela() {
        return portaParalela;
    }

    public void setPortaParalela(String portaParalela) {
        this.portaParalela = portaParalela;
    }
    
    
}