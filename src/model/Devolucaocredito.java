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
@Table(name = "devolucaocredito")
@NamedQueries({
    @NamedQuery(name = "Devolucaocredito.findAll", query = "SELECT d FROM Devolucaocredito d")})
public class Devolucaocredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddevolucaoCredito")
    private Integer iddevolucaoCredito;
    @Column(name = "nomeCliente")
    private String nomeCliente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorTotal")
    private Double valorTotal;
    @JoinColumn(name = "devolucao_iddevolucao", referencedColumnName = "iddevolucao")
    @ManyToOne(optional = false)
    private Devolucao devolucao;

    public Devolucaocredito() {
    }

    public Devolucaocredito(Integer iddevolucaoCredito) {
        this.iddevolucaoCredito = iddevolucaoCredito;
    }

    public Integer getIddevolucaoCredito() {
        return iddevolucaoCredito;
    }

    public void setIddevolucaoCredito(Integer iddevolucaoCredito) {
        this.iddevolucaoCredito = iddevolucaoCredito;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Devolucao getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddevolucaoCredito != null ? iddevolucaoCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devolucaocredito)) {
            return false;
        }
        Devolucaocredito other = (Devolucaocredito) object;
        if ((this.iddevolucaoCredito == null && other.iddevolucaoCredito != null) || (this.iddevolucaoCredito != null && !this.iddevolucaoCredito.equals(other.iddevolucaoCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Devolucaocredito[ iddevolucaoCredito=" + iddevolucaoCredito + " ]";
    }
    
}
