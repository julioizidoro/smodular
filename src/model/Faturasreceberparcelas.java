/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "faturasreceberparcelas")
@NamedQueries({
    @NamedQuery(name = "Faturasreceberparcelas.findAll", query = "SELECT f FROM Faturasreceberparcelas f")})
public class Faturasreceberparcelas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFaturasReceberParcelas")
    private Integer idFaturasReceberParcelas;
    @Column(name = "numeroDocumento")
    private String numeroDocumento;
    @Column(name = "numeroParcela")
    private Integer numeroParcela;
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
    @Column(name = "valorParcela")
    private Double valorParcela;
    @Column(name = "FaturasReceber_idFaturasReceber")
    private int faturasreceber;
    @Column(name = "contasReceberPagamento_idcontasReceberPagamento")
    private int contasreceberpagamento;
    @Column(name = "cliente_idCliente")
    private int cliente;
    @Column(name = "empresa_idempresa")
    private int empresa;

    public Faturasreceberparcelas() {
    }

    public Faturasreceberparcelas(Integer idFaturasReceberParcelas) {
        this.idFaturasReceberParcelas = idFaturasReceberParcelas;
    }

    public Integer getIdFaturasReceberParcelas() {
        return idFaturasReceberParcelas;
    }

    public void setIdFaturasReceberParcelas(Integer idFaturasReceberParcelas) {
        this.idFaturasReceberParcelas = idFaturasReceberParcelas;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Integer getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
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

    public Double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public int getFaturasreceber() {
        return faturasreceber;
    }

    public void setFaturasreceber(int faturasreceber) {
        this.faturasreceber = faturasreceber;
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


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFaturasReceberParcelas != null ? idFaturasReceberParcelas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faturasreceberparcelas)) {
            return false;
        }
        Faturasreceberparcelas other = (Faturasreceberparcelas) object;
        if ((this.idFaturasReceberParcelas == null && other.idFaturasReceberParcelas != null) || (this.idFaturasReceberParcelas != null && !this.idFaturasReceberParcelas.equals(other.idFaturasReceberParcelas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Faturasreceberparcelas[ idFaturasReceberParcelas=" + idFaturasReceberParcelas + " ]";
    }
    
}
