/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NotaFiscal;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "clienteproduto")
public class Clienteproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclienteProduto")
    private Integer idclienteProduto;
    @Column(name = "nome")
    private String nome;

    public Clienteproduto() {
    }

    public Clienteproduto(Integer idclienteProduto) {
        this.idclienteProduto = idclienteProduto;
    }

    public Integer getIdclienteProduto() {
        return idclienteProduto;
    }

    public void setIdclienteProduto(Integer idclienteProduto) {
        this.idclienteProduto = idclienteProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclienteProduto != null ? idclienteProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienteproduto)) {
            return false;
        }
        Clienteproduto other = (Clienteproduto) object;
        if ((this.idclienteProduto == null && other.idclienteProduto != null) || (this.idclienteProduto != null && !this.idclienteProduto.equals(other.idclienteProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NotaFiscal.Clienteproduto[ idclienteProduto=" + idclienteProduto + " ]";
    }
    
}
