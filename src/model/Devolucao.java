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
@Table(name = "devolucao")
public class Devolucao implements Serializable {
    @Column(name = "dataDevolucao")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;
    @Column(name = "horaDevolucao")
    @Temporal(TemporalType.TIME)
    private Date horaDevolucao;
    @Column(name = "condicaoDevolucao")
    private String condicaoDevolucao;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddevolucao")
    private Integer iddevolucao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorDevolucao")
    private Float valorDevolucao;
    @Column(name = "numeroItens")
    private Integer numeroItens;
    @Column(name = "fechacaixa_idfechacaixa")
    private int fechacaixa;
    @Column(name = "vendedor_idvendedor")
    private int vendedor;
    @Column(name = "empresa_idempresa")
    private int empresa;

    public Devolucao() {
    }

    public Devolucao(Integer iddevolucao) {
        this.iddevolucao = iddevolucao;
    }

    public Integer getIddevolucao() {
        return iddevolucao;
    }

    public void setIddevolucao(Integer iddevolucao) {
        this.iddevolucao = iddevolucao;
    }

    public Float getValorDevolucao() {
        return valorDevolucao;
    }

    public void setValorDevolucao(Float valorDevolucao) {
        this.valorDevolucao = valorDevolucao;
    }

    public Integer getNumeroItens() {
        return numeroItens;
    }

    public void setNumeroItens(Integer numeroItens) {
        this.numeroItens = numeroItens;
    }

    public int getFechacaixa() {
        return fechacaixa;
    }

    public void setFechacaixa(int fechacaixa) {
        this.fechacaixa = fechacaixa;
    }

    public int getVendedor() {
        return vendedor;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddevolucao != null ? iddevolucao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devolucao)) {
            return false;
        }
        Devolucao other = (Devolucao) object;
        if ((this.iddevolucao == null && other.iddevolucao != null) || (this.iddevolucao != null && !this.iddevolucao.equals(other.iddevolucao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Devolucao[ iddevolucao=" + iddevolucao + " ]";
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Date getHoraDevolucao() {
        return horaDevolucao;
    }

    public void setHoraDevolucao(Date horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }

    public String getCondicaoDevolucao() {
        return condicaoDevolucao;
    }

    public void setCondicaoDevolucao(String condicaoDevolucao) {
        this.condicaoDevolucao = condicaoDevolucao;
    }

    
}
