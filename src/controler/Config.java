/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;

import facade.EmpresaFacade;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Empresa;



/**
 *
 * @author Woverine
 */
public class Config {

    private String idProduto;
    private Empresa empresa;
    private String ini;

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
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
    
    public  void carregarConfiguracao() {
        File file = new File("c:\\jgdynamic.properties");
        Properties props = new Properties();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            //lê os dados que estão no arquivo
            props.load(fis);
            fis.close();
     //       setIdProduto(props.getProperty("idProduto"));
            String id = props.getProperty("empresa");
            setIni(props.getProperty("caminhoini"));
            carregarEmpresa(Integer.parseInt(id));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }


    }
    
    public void SalvarConfiguracao(){
        File file = new File("c:\\jgdynamic.properties");
        Properties props = new Properties();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            //lê os dados que estão no arquivo
            props.load(fis);
            fis.close();
            props.setProperty("idProduto", idProduto);
            FileOutputStream out = new FileOutputStream(file);
            props.store(out,"");
            out.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }


    }

    public int gerarIdProduto(){
        carregarConfiguracao();
        return Integer.parseInt(getIdProduto());
    }

    public  void gravarIdProduto(int idProduto){
        setIdProduto(String.valueOf(idProduto));
        SalvarConfiguracao();
    }
    
    public void carregarEmpresa(int idEmpresa){
        EmpresaFacade empresaFacade = new EmpresaFacade();
        try {
            this.empresa = empresaFacade.buscarEmpresa(idEmpresa);
        } catch (SQLException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}