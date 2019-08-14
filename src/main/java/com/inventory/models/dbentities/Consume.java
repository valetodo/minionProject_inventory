package com.inventory.models.dbentities;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ccalvi
 */
@Entity
@Table(name = "consume")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Consume.findAll", query = "SELECT c FROM Consume c")
        , @NamedQuery(name = "Consume.findByIdConsume", query = "SELECT c FROM Consume c WHERE c.idConsume = :idConsume")})
public class Consume implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consume")
    private Integer idConsume;
    @Basic(optional = false)
    @Column(name = "expiration", columnDefinition = "TIMESTAMP")
    private Date expiration;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsume")
    private Collection<Product> productCollection;

    public Consume() {
    }

    public Consume(Integer idConsume) {
        this.idConsume = idConsume;
    }

    public Consume(Integer idConsume, Date expiration) {
        this.idConsume = idConsume;
        this.expiration = expiration;
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

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
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
        return "dbmodels.Consume[ idConsume=" + idConsume + " ]";
    }

}
