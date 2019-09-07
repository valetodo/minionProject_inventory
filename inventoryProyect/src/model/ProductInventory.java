/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yerel-estalin
 */
@Entity
@Table(name = "product_inventory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductInventory.findAll", query = "SELECT p FROM ProductInventory p"),
    @NamedQuery(name = "ProductInventory.findByIdProduct", query = "SELECT p FROM ProductInventory p WHERE p.productInventoryPK.idProduct = :idProduct"),
    @NamedQuery(name = "ProductInventory.findByIdInventory", query = "SELECT p FROM ProductInventory p WHERE p.productInventoryPK.idInventory = :idInventory")})
public class ProductInventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductInventoryPK productInventoryPK;

    public ProductInventory() {
    }

    public ProductInventory(ProductInventoryPK productInventoryPK) {
        this.productInventoryPK = productInventoryPK;
    }

    public ProductInventory(int idProduct, int idInventory) {
        this.productInventoryPK = new ProductInventoryPK(idProduct, idInventory);
    }

    public ProductInventoryPK getProductInventoryPK() {
        return productInventoryPK;
    }

    public void setProductInventoryPK(ProductInventoryPK productInventoryPK) {
        this.productInventoryPK = productInventoryPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productInventoryPK != null ? productInventoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductInventory)) {
            return false;
        }
        ProductInventory other = (ProductInventory) object;
        if ((this.productInventoryPK == null && other.productInventoryPK != null) || (this.productInventoryPK != null && !this.productInventoryPK.equals(other.productInventoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventory.ProductInventory[ productInventoryPK=" + productInventoryPK + " ]";
    }
    
}
