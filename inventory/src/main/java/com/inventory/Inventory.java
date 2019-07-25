package com.inventory;

import com.sun.istack.internal.NotNull;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "inventory")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i")
        , @NamedQuery(name = "Inventory.findByIdproduct", query = "SELECT i FROM Inventory i WHERE i.idproduct = :idproduct")
        , @NamedQuery(name = "Inventory.findByNameProduct", query = "SELECT i FROM Inventory i WHERE i.nameProduct = :nameProduct")
        , @NamedQuery(name = "Inventory.findByPrice", query = "SELECT i FROM Inventory i WHERE i.price = :price")
        , @NamedQuery(name = "Inventory.findByStatus", query = "SELECT i FROM Inventory i WHERE i.status = :status")
        , @NamedQuery(name = "Inventory.findByCantidadInicial", query = "SELECT i FROM Inventory i WHERE i.cantidadInicial = :cantidadInicial")
        , @NamedQuery(name = "Inventory.findByCantidadDisponible", query = "SELECT i FROM Inventory i WHERE i.cantidadDisponible = :cantidadDisponible")
        , @NamedQuery(name = "Inventory.findByTypeProduct", query = "SELECT i FROM Inventory i WHERE i.typeProduct = :typeProduct")})
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproduct")
    private Long idproduct;
    @Size(max = 255)
    @Column(name = "nameProduct")
    private String nameProduct;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Size(max = 2)
    @Column(name = "status")
    private String status;
    @Column(name = "cantidadInicial")
    private Integer cantidadInicial;
    @Column(name = "cantidadDisponible")
    private Integer cantidadDisponible;
    @Size(max = 2)
    @Column(name = "typeProduct")
    private String typeProduct;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "inventory")
    private Product product;

    public Inventory() {
    }

    public Inventory(Long idproduct) {
        this.idproduct = idproduct;
    }

    public Long getIdProduct() {
        return idproduct;
    }

    public void setIdProduct(Long idproduct) {
        this.idproduct = idproduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCantidadInicial() {
        return cantidadInicial;
    }


    public boolean isStatus() {
        return status.equals("T");
    }

    public void setCantidadInicial(Integer cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.idproduct == null && other.idproduct != null) || (this.idproduct != null && !this.idproduct.equals(other.idproduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.repository.Inventory[ idproduct=" + idproduct + " ]";
    }

}
