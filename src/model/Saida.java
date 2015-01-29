/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "saida")
public class Saida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsaida")
    private Integer idsaida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorVenda")
    private Float valorVenda;
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "valorCompra")
    private Float valorCompra;
    @Column(name = "valorVenda2")
    private Float valorVenda2;
    @Column(name = "valorDesconto")
    private Float valorDesconto;
    @Column(name = "percentualDesconto")
    private Float percentualDesconto;
    @Column(name = "venda_idvenda")
    private int venda;
    @Column(name = "produto_idproduto")
    private int produto;
    @Column(name = "valorImposto")
    private double valorImposto;
    @Column(name = "aliquotaImposto")
    private double aliquotaImposto;
    @Column(name = "valorComissao")
    private double valorComissao;
    @Column(name = "vendedor_idvendedor")
    private int vendedor;

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public Saida() {
        setValorVenda2(0.0f);
        setValorCompra(0.0f);
        setValorVenda(0.0f);
        setQuantidade(0.0);
        setValorDesconto(0.0f);
        setPercentualDesconto(0.0f);
        setValorImposto(0.0);
        setAliquotaImposto(0.0);
    }

    public Saida(Integer idsaida) {
        this.idsaida = idsaida;
    }

    public Integer getIdsaida() {
        return idsaida;
    }

    public void setIdsaida(Integer idsaida) {
        this.idsaida = idsaida;
    }

    public double getValorComissao() {
        return valorComissao;
    }

    public void setValorComissao(double valorComissao) {
        this.valorComissao = valorComissao;
    }

    public Float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    public Float getValorVenda2() {
        return valorVenda2;
    }

    public void setValorVenda2(Float valorVenda2) {
        this.valorVenda2 = valorVenda2;
    }

    public Float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Float getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(Float percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public double getValorImposto() {
        return valorImposto;
    }

    public void setValorImposto(double valorImposto) {
        this.valorImposto = valorImposto;
    }

    public double getAliquotaImposto() {
        return aliquotaImposto;
    }

    public void setAliquotaImposto(double aliquotaImposto) {
        this.aliquotaImposto = aliquotaImposto;
    }



   


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsaida != null ? idsaida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saida)) {
            return false;
        }
        Saida other = (Saida) object;
        if ((this.idsaida == null && other.idsaida != null) || (this.idsaida != null && !this.idsaida.equals(other.idsaida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Saida[ idsaida=" + idsaida + " ]";
    }

   
}
