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
 * @author wolverine
 */
@Entity
@Table(name = "chequefechacaixa")
public class Chequefechacaixa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchequefechacaixa")
    private Integer idchequefechacaixa;
    @Column(name = "fechacaixa_idfechaCaixa")
    private int fechacaixa;
    @Column(name = "controleCheques_idControleCheques")
    private int controlecheques;

    public Chequefechacaixa() {
    }

    public Chequefechacaixa(Integer idchequefechacaixa) {
        this.idchequefechacaixa = idchequefechacaixa;
    }

    public Integer getIdchequefechacaixa() {
        return idchequefechacaixa;
    }

    public void setIdchequefechacaixa(Integer idchequefechacaixa) {
        this.idchequefechacaixa = idchequefechacaixa;
    }

    public int getFechacaixa() {
        return fechacaixa;
    }

    public void setFechacaixa(int fechacaixa) {
        this.fechacaixa = fechacaixa;
    }

    public int getControlecheques() {
        return controlecheques;
    }

    public void setControlecheques(int controlecheques) {
        this.controlecheques = controlecheques;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idchequefechacaixa != null ? idchequefechacaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chequefechacaixa)) {
            return false;
        }
        Chequefechacaixa other = (Chequefechacaixa) object;
        if ((this.idchequefechacaixa == null && other.idchequefechacaixa != null) || (this.idchequefechacaixa != null && !this.idchequefechacaixa.equals(other.idchequefechacaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Chequefechacaixa[ idchequefechacaixa=" + idchequefechacaixa + " ]";
    }
    
}
