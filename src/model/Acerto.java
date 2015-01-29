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
@Table(name = "acerto")
public class Acerto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacerto")
    private Integer idacerto;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidadeAcerto")
    private Double quantidadeAcerto;
    @Column(name = "quantidadeEstoque")
    private Double quantidadeEstoque;
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "produto_idProduto")
    private int produto;

    public Acerto() {
    }

    public Acerto(Integer idacerto) {
        this.idacerto = idacerto;
    }

    public Integer getIdacerto() {
        return idacerto;
    }

    public void setIdacerto(Integer idacerto) {
        this.idacerto = idacerto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getQuantidadeAcerto() {
        return quantidadeAcerto;
    }

    public void setQuantidadeAcerto(Double quantidadeAcerto) {
        this.quantidadeAcerto = quantidadeAcerto;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idacerto != null ? idacerto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acerto)) {
            return false;
        }
        Acerto other = (Acerto) object;
        if ((this.idacerto == null && other.idacerto != null) || (this.idacerto != null && !this.idacerto.equals(other.idacerto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Acerto[ idacerto=" + idacerto + " ]";
    }
    
}
