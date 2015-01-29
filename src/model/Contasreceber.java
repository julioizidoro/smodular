/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "contasreceber")
public class Contasreceber implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontasReceber")
    private Integer idcontasReceber;
    @Column(name = "numeroDocumento")
    private String numeroDocumento;
    @Column(name = "dataLancamento")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    @Column(name = "dataVencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Column(name = "dataRecebimento")
    @Temporal(TemporalType.DATE)
    private Date dataRecebimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorConta")
    private Double valorConta;
    @Column(name = "numeroFaturaGerada")
    private String numeroFaturaGerada;
    @Column(name = "mes")
    private String mes;
    @Column(name = "vendedor_idvendedor")
    private int vendedor;
    @Column(name = "empresa_idempresa")
    private int empresa;
    @Column(name = "contasReceberPagamento_idcontasReceberPagamento")
    private int contasreceberpagamento;
    @Column(name = "cliente_idCliente")
    private int cliente;
    
    public Contasreceber() {
    }

    public Contasreceber(Integer idcontasReceber) {
        this.idcontasReceber = idcontasReceber;
    }

    public Integer getIdcontasReceber() {
        return idcontasReceber;
    }

    public void setIdcontasReceber(Integer idcontasReceber) {
        this.idcontasReceber = idcontasReceber;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Double getValorConta() {
        return valorConta;
    }

    public void setValorConta(Double valorConta) {
        this.valorConta = valorConta;
    }

    public String getNumeroFaturaGerada() {
        return numeroFaturaGerada;
    }

    public void setNumeroFaturaGerada(String numeroFaturaGerada) {
        this.numeroFaturaGerada = numeroFaturaGerada;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getContasreceberpagamento() {
        return contasreceberpagamento;
    }

    public void setContasreceberpagamento(int contasreceberpagamento) {
        this.contasreceberpagamento = contasreceberpagamento;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontasReceber != null ? idcontasReceber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contasreceber)) {
            return false;
        }
        Contasreceber other = (Contasreceber) object;
        if ((this.idcontasReceber == null && other.idcontasReceber != null) || (this.idcontasReceber != null && !this.idcontasReceber.equals(other.idcontasReceber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contasreceber[ idcontasReceber=" + idcontasReceber + " ]";
    }
    
}
