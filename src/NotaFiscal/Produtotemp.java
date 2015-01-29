/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NotaFiscal;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "produtotemp")
public class Produtotemp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnotaProdutos")
    private Integer idnotaProdutos;
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "cst")
    private String cst;
    @Column(name = "unidade")
    private String unidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "valorUnitario")
    private Double valorUnitario;
    @Column(name = "valorTotal")
    private Double valorTotal;
    @Column(name = "aliquotaIcms")
    private String aliquotaIcms;
    @Column(name = "valorCompra")
    private Double valorCompra;
    @Column(name = "clienteProduto_idclienteProduto")
    private int clienteproduto;

    public Produtotemp() {
    }

    public Produtotemp(Integer idnotaProdutos) {
        this.idnotaProdutos = idnotaProdutos;
    }

    public Integer getIdnotaProdutos() {
        return idnotaProdutos;
    }

    public void setIdnotaProdutos(Integer idnotaProdutos) {
        this.idnotaProdutos = idnotaProdutos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getAliquotaIcms() {
        return aliquotaIcms;
    }

    public void setAliquotaIcms(String aliquotaIcms) {
        this.aliquotaIcms = aliquotaIcms;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getClienteproduto() {
        return clienteproduto;
    }

    public void setClienteproduto(int clienteproduto) {
        this.clienteproduto = clienteproduto;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnotaProdutos != null ? idnotaProdutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtotemp)) {
            return false;
        }
        Produtotemp other = (Produtotemp) object;
        if ((this.idnotaProdutos == null && other.idnotaProdutos != null) || (this.idnotaProdutos != null && !this.idnotaProdutos.equals(other.idnotaProdutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NotaFiscal.Produtotemp[ idnotaProdutos=" + idnotaProdutos + " ]";
    }
    
}
