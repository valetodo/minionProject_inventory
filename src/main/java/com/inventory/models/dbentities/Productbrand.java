package com.inventory.models.dbentities;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Productbrand")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Productbrand.findAll", query = "SELECT p FROM Productbrand p"),
        @NamedQuery(name = "Productbrand.findByIdBrand", query = "SELECT p FROM Productbrand p WHERE p.id_brand =:idBrand")
})
@NamedNativeQuery(name = "Test", query = "SELECT * FROM Productbrand p WHERE p.id_brand =:id_brand", resultClass = Productbrand.class)
public class Productbrand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_brand")
    private Integer idBrand;
    @Basic(optional = false)
    @Lob
    @Column(name = "name_brand", columnDefinition = "TEXT")
    private String nameBrand;
    @Basic(optional = false)
    @Lob
    @Column(name = "origin_brand", columnDefinition = "TEXT")
    private String originBrand;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBrand")
    private Collection<Product> productCollection;

    public Productbrand() {
    }

    public Productbrand(Integer idBrand) {
        this.idBrand = idBrand;
    }

    public Productbrand(Integer idBrand, String nameBrand, String originBrand) {
        this.idBrand = idBrand;
        this.nameBrand = nameBrand;
        this.originBrand = originBrand;
    }

    public Integer getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Integer idBrand) {
        this.idBrand = idBrand;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getOriginBrand() {
        return originBrand;
    }

    public void setOriginBrand(String originBrand) {
        this.originBrand = originBrand;
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
        hash += (idBrand != null ? idBrand.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productbrand)) {
            return false;
        }
        Productbrand other = (Productbrand) object;
        if ((this.idBrand == null && other.idBrand != null) || (this.idBrand != null && !this.idBrand.equals(other.idBrand))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbmodels.Productbrand[ idBrand=" + idBrand + " ]";
    }


    public String printInfo() {
        return "idBrand=" + idBrand + ", nameBrand=" + nameBrand + ", originBrand=" + originBrand;
    }

}
