/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yerel-estalin
 */
@Entity
@Table(name = "consume")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consume.findAll", query = "SELECT c FROM Consume c"),
    @NamedQuery(name = "Consume.findByIdConsume", query = "SELECT c FROM Consume c WHERE c.idConsume = :idConsume"),
    @NamedQuery(name = "Consume.findByExpiration", query = "SELECT c FROM Consume c WHERE c.expiration = :expiration")})
public class Consume implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CONSUME")
    private Integer idConsume;
    @Column(name = "EXPIRATION")
    @Temporal(TemporalType.DATE)
    private Date expiration;

    public Consume() {
    }

    public Consume(Integer idConsume) {
        this.idConsume = idConsume;
    }

    public Integer getIdConsume() {
        return idConsume;
    }

    public void setIdConsume(Integer idConsume) {
        this.idConsume = idConsume;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsume != null ? idConsume.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consume)) {
            return false;
        }
        Consume other = (Consume) object;
        if ((this.idConsume == null && other.idConsume != null) || (this.idConsume != null && !this.idConsume.equals(other.idConsume))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventory.Consume[ idConsume=" + idConsume + " ]";
    }
    
}
