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
@Table(name = "cliente")
public class Cliente implements Serializable {
    @Column(name = "operacao")
    private Integer operacao;
    @Column(name =     "dataCadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name =     "dataAtualizacao")
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;
    @Column(name =     "dataConsultacpf")
    @Temporal(TemporalType.DATE)
    private Date dataConsultacpf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Contasreceber> contasreceberList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Integer idcliente;
    @Column(name = "nome")
    private String nome;
    @Column(name = "docFederal")
    private String docFederal;
    @Column(name = "docEstadual")
    private String docEstadual;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "situacao")
    private String situacao;
    @Column(name = "foneFixo")
    private String foneFixo;
    @Column(name = "foneCelular")
    private String foneCelular;
    @Column(name = "email")
    private String email;
    @Lob
    @Column(name = "observacoes")
    private String observacoes;
    
    
    public Cliente() {
    }

    public Cliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocFederal() {
        return docFederal;
    }

    public void setDocFederal(String docFederal) {
        this.docFederal = docFederal;
    }

    public String getDocEstadual() {
        return docEstadual;
    }

    public void setDocEstadual(String docEstadual) {
        this.docEstadual = docEstadual;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getFoneFixo() {
        return foneFixo;
    }

    public void setFoneFixo(String foneFixo) {
        this.foneFixo = foneFixo;
    }

    public String getFoneCelular() {
        return foneCelular;
    }

    public void setFoneCelular(String foneCelular) {
        this.foneCelular = foneCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cliente[ idcliente=" + idcliente + " ]";
    }


    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Date getDataConsultacpf() {
        return dataConsultacpf;
    }

    public void setDataConsultacpf(Date dataConsultacpf) {
        this.dataConsultacpf = dataConsultacpf;
    }

    public List<Contasreceber> getContasreceberList() {
        return contasreceberList;
    }

    public void setContasreceberList(List<Contasreceber> contasreceberList) {
        this.contasreceberList = contasreceberList;
    }

    public Integer getOperacao() {
        return operacao;
    }

    public void setOperacao(Integer operacao) {
        this.operacao = operacao;
    }

}
