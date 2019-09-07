/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yerel-estalin
 */
@Entity
@Table(name = "durable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Durable.findAll", query = "SELECT d FROM Durable d"),
    @NamedQuery(name = "Durable.findByIdDurable", query = "SELECT d FROM Durable d WHERE d.idDurable = :idDurable"),
    @NamedQuery(name = "Durable.findBySizeDurable", query = "SELECT d FROM Durable d WHERE d.sizeDurable = :sizeDurable"),
    @NamedQuery(name = "Durable.findByWeighDurable", query = "SELECT d FROM Durable d WHERE d.weighDurable = :weighDurable")})
public class Durable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DURABLE")
    private Integer idDurable;
    @Column(name = "SIZE_DURABLE")
    private Integer sizeDurable;
    @Column(name = "WEIGH_DURABLE")
    private Integer weighDurable;

    public Durable() {
    }

    public Durable(Integer idDurable) {
        this.idDurable = idDurable;
    }

    public Integer getIdDurable() {
        return idDurable;
    }

    public void setIdDurable(Integer idDurable) {
        this.idDurable = idDurable;
    }

    public Integer getSizeDurable() {
        return sizeDurable;
    }

    public void setSizeDurable(Integer sizeDurable) {
        this.sizeDurable = sizeDurable;
    }

    public Integer getWeighDurable() {
        return weighDurable;
    }

    public void setWeighDurable(Integer weighDurable) {
        this.weighDurable = weighDurable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDurable != null ? idDurable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Durable)) {
            return false;
        }
        Durable other = (Durable) object;
        if ((this.idDurable == null && other.idDurable != null) || (this.idDurable != null && !this.idDurable.equals(other.idDurable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventory.Durable[ idDurable=" + idDurable + " ]";
    }
    
}
