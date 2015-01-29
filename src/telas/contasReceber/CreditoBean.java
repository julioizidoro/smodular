/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.contasReceber;


import Controller.ClienteController;
import Controller.VendedorController;
import model.Cliente;
import model.Creditosreceber;
import model.Vendedor;

/**
 *
 * @author Wolverine
 */
public class CreditoBean {
    
    private Creditosreceber  credito;
    private String nomeVendedor;
    private String utilizar;
    

    public CreditoBean(Creditosreceber credito) {
        this.credito = credito;
        localizarVendedor();
        setUtilizar("NAO");
    }

    public Creditosreceber getCredito() {
        return credito;
    }

    public void setCredito(Creditosreceber credito) {
        this.credito = credito;
    }


    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public String getUtilizar() {
        return utilizar;
    }

    public void setUtilizar(String utilizar) {
        this.utilizar = utilizar;
    }
    
    public void localizarVendedor(){
        VendedorController vendedorController = new VendedorController();
        Vendedor vendedor = new Vendedor();
        vendedor = vendedorController.consultarVendedorId(credito.getVendedor());
        if (vendedor !=null){
            setNomeVendedor(vendedor.getNome());
        }
    }
    
    
    
}
