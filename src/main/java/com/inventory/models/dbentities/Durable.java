package com.inventory.models.dbentities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "durable")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Durable.findAll", query = "SELECT d FROM Durable d")
        , @NamedQuery(name = "Durable.findByIdDurable", query = "SELECT d FROM Durable d WHERE d.idDurable = :idDurable")
        , @NamedQuery(name = "Durable.findBySizeDurable", query = "SELECT d FROM Durable d WHERE d.sizeDurable = :sizeDurable")
        , @NamedQuery(name = "Durable.findByWeighDurable", query = "SELECT d FROM Durable d WHERE d.weighDurable = :weighDurable")})
public class Durable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_durable")
    private Integer idDurable;
    @Basic(optional = false)
    @Column(name = "size_durable")
    private int sizeDurable;
    @Basic(optional = false)
    @Column(name = "weigh_durable")
    private int weighDurable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDurable")
    private Collection<Product> productCollection;

    public Durable() {
    }

    public Durable(Integer idDurable) {
        this.idDurable = idDurable;
    }

    public Durable(Integer idDurable, int sizeDurable, int weighDurable) {
        this.idDurable = idDurable;
        this.sizeDurable = sizeDurable;
        this.weighDurable = weighDurable;
    }

    public Integer getIdDurable() {
        return idDurable;
    }

    public void setIdDurable(Integer idDurable) {
        this.idDurable = idDurable;
    }

    public int getSizeDurable() {
        return sizeDurable;
    }

    public void setSizeDurable(int sizeDurable) {
        this.sizeDurable = sizeDurable;
    }

    public int getWeighDurable() {
        return weighDurable;
    }

    public void setWeighDurable(int weighDurable) {
        this.weighDurable = weighDurable;
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
        return "dbmodels.Durable[ idDurable=" + idDurable + " ]";
    }

}
