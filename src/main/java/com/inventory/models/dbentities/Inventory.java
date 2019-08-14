package com.inventory.models.dbentities;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ccalvi
 */
@Entity
@Table(name = "inventory")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i")
        , @NamedQuery(name = "Inventory.findByIdInventory", query = "SELECT i FROM Inventory i WHERE i.idInventory = :idInventory")
        , @NamedQuery(name = "Inventory.findByIniQuantity", query = "SELECT i FROM Inventory i WHERE i.iniQuantity = :iniQuantity")
        , @NamedQuery(name = "Inventory.findByAvailableQuatity", query = "SELECT i FROM Inventory i WHERE i.availableQuatity = :availableQuatity")
        , @NamedQuery(name = "Inventory.findByProducts", query = "SELECT i FROM Inventory i WHERE i.products = :products")})
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inventory")
    private Integer idInventory;
    @Basic(optional = false)
    @Column(name = "ini_quantity")
    private int iniQuantity;
    @Basic(optional = false)
    @Column(name = "available_quatity")
    private int availableQuatity;
    @Basic(optional = false)
    @Column(name = "products")
    private int products;
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    @ManyToOne(optional = false)
    private Product idProduct;

    public Inventory() {
    }

    public Inventory(Integer idInventory) {
        this.idInventory = idInventory;
    }

    public Inventory(Integer idInventory, int iniQuantity, int availableQuatity, int products) {
        this.idInventory = idInventory;
        this.iniQuantity = iniQuantity;
        this.availableQuatity = availableQuatity;
        this.products = products;
    }

    public Integer getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(Integer idInventory) {
        this.idInventory = idInventory;
    }

    public int getIniQuantity() {
        return iniQuantity;
    }

    public void setIniQuantity(int iniQuantity) {
        this.iniQuantity = iniQuantity;
    }

    public int getAvailableQuatity() {
        return availableQuatity;
    }

    public void setAvailableQuatity(int availableQuatity) {
        this.availableQuatity = availableQuatity;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventory != null ? idInventory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.idInventory == null && other.idInventory != null) || (this.idInventory != null && !this.idInventory.equals(other.idInventory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbmodels.Inventory[ idInventory=" + idInventory + " ]";
    }

    public String printInfo() {
        return "idInventory=" + idInventory + ", idProduct=" + idProduct + ", nameProduct=" + this.getIdProduct().getNameProduct() + ", price=" + this.getIdProduct().getPrice().doubleValue() +
                ", brand=" + this.getIdProduct().getIdBrand().getNameBrand();
    }

}
