package com.inventory;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author ccalvi
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
        , @NamedQuery(name = "Product.findByIdproduct", query = "SELECT p FROM Product p WHERE p.idproduct = :idproduct")
        , @NamedQuery(name = "Product.findByLocation", query = "SELECT p FROM Product p WHERE p.location = :location")
        , @NamedQuery(name = "Product.findByQuantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity")
        , @NamedQuery(name = "Product.findByTamano", query = "SELECT p FROM Product p WHERE p.tamano = :tamano")
        , @NamedQuery(name = "Product.findByPeso", query = "SELECT p FROM Product p WHERE p.peso = :peso")
        , @NamedQuery(name = "Product.findByExpiracion", query = "SELECT p FROM Product p WHERE p.expiracion = :expiracion")
        , @NamedQuery(name = "Product.findByTypeProduct", query = "SELECT p FROM Product p WHERE p.typeProduct = :typeProduct")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproduct")
    private Long idproduct;
    @Size(max = 255)
    @Column(name = "location")
    private String location;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "tamano")
    private Integer tamano;
    /*
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Double peso;
    @Column(name = "expiracion")
    @Temporal(TemporalType.DATE)
    private Date expiracion;
    */
    @Size(max = 2)
    @Column(name = "typeProduct")
    private String typeProduct;
    @JoinColumn(name = "idproduct", referencedColumnName = "idproduct", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Inventory inventory;

    public Product() {
    }

    public Product(Long idproduct) {
        this.idproduct = idproduct;
    }

    public Long getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Long idproduct) {
        this.idproduct = idproduct;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTamano() {
        return tamano;
    }

    public void setTamano(Integer tamano) {
        this.tamano = tamano;
    }
    /*
    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Date getExpiracion() {
        return expiracion;
    }

    public void setExpiracion(Date expiracion) {
        this.expiracion = expiracion;
    }
    */
    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduct != null ? idproduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.idproduct == null && other.idproduct != null) || (this.idproduct != null && !this.idproduct.equals(other.idproduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.repository.Product[ idproduct=" + idproduct + " ]";
    }

}