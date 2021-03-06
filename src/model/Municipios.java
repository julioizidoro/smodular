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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author wolverine
 */
@Entity
@Table(name = "municipios")
public class Municipios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmunicipios")
    private Integer idmunicipios;
    @Column(name = "estado")
    private String estado;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "nomeMunicipio")
    private String nomeMunicipio;

    public Municipios() {
    }

    public Municipios(Integer idmunicipios) {
        this.idmunicipios = idmunicipios;
    }

    public Integer getIdmunicipios() {
        return idmunicipios;
    }

    public void setIdmunicipios(Integer idmunicipios) {
        this.idmunicipios = idmunicipios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmunicipios != null ? idmunicipios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.idmunicipios == null && other.idmunicipios != null) || (this.idmunicipios != null && !this.idmunicipios.equals(other.idmunicipios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Municipios[ idmunicipios=" + idmunicipios + " ]";
    }
    
}
