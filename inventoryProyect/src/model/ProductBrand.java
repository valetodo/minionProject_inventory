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
@Table(name = "product_brand")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductBrand.findAll", query = "SELECT p FROM ProductBrand p"),
    @NamedQuery(name = "ProductBrand.findByIdBrand", query = "SELECT p FROM ProductBrand p WHERE p.idBrand = :idBrand"),
    @NamedQuery(name = "ProductBrand.findByIdProduct", query = "SELECT p FROM ProductBrand p WHERE p.idProduct = :idProduct"),
    @NamedQuery(name = "ProductBrand.findByNameBrand", query = "SELECT p FROM ProductBrand p WHERE p.nameBrand = :nameBrand"),
    @NamedQuery(name = "ProductBrand.findByOriginBrand", query = "SELECT p FROM ProductBrand p WHERE p.originBrand = :originBrand")})
public class ProductBrand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_BRAND")
    private Integer idBrand;
    @Column(name = "ID_PRODUCT")
    private Integer idProduct;
    @Column(name = "NAME_BRAND")
    private String nameBrand;
    @Column(name = "ORIGIN_BRAND")
    private String originBrand;

    public ProductBrand() {
    }

    public ProductBrand(Integer idBrand) {
        this.idBrand = idBrand;
    }

    public Integer getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Integer idBrand) {
        this.idBrand = idBrand;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBrand != null ? idBrand.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductBrand)) {
            return false;
        }
        ProductBrand other = (ProductBrand) object;
        if ((this.idBrand == null && other.idBrand != null) || (this.idBrand != null && !this.idBrand.equals(other.idBrand))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventory.ProductBrand[ idBrand=" + idBrand + " ]";
    }
    
}
