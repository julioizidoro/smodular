/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "contasreceberforma")
public class Contasreceberforma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontasReceberForma")
    private Integer idcontasReceberForma;
    @Column(name = "formaRecebimento")
    private String formaRecebimento;
    @Column(name = "idBanco")
    private Integer idBanco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorPago")
    private Double valorPago;
    @Column(name = "contasReceberPagamento_idcontasReceberPagamento")
    private int contasreceberpagamento;
    @Column(name = "formapagamento_idformapagamento")
    private int formaPagamento;
    @Column(name = "empresa_idempresa")
    private int empresa;

    public Contasreceberforma() {
    }

    public Contasreceberforma(Integer idcontasReceberForma) {
        this.idcontasReceberForma = idcontasReceberForma;
    }

    public Integer getIdcontasReceberForma() {
        return idcontasReceberForma;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public void setIdcontasReceberForma(Integer idcontasReceberForma) {
        this.idcontasReceberForma = idcontasReceberForma;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getFormaRecebimento() {
        return formaRecebimento;
    }

    public void setFormaRecebimento(String formaRecebimento) {
        this.formaRecebimento = formaRecebimento;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
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
        hash += (idcontasReceberForma != null ? idcontasReceberForma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contasreceberforma)) {
            return false;
        }
        Contasreceberforma other = (Contasreceberforma) object;
        if ((this.idcontasReceberForma == null && other.idcontasReceberForma != null) || (this.idcontasReceberForma != null && !this.idcontasReceberForma.equals(other.idcontasReceberForma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contasreceberforma[ idcontasReceberForma=" + idcontasReceberForma + " ]";
    }
    
}
