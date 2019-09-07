/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author yerel-estalin
 */
@Embeddable
public class ProductInventoryPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_PRODUCT")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "ID_INVENTORY")
    private int idInventory;

    public ProductInventoryPK() {
    }

    public ProductInventoryPK(int idProduct, int idInventory) {
        this.idProduct = idProduct;
        this.idInventory = idInventory;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(int idInventory) {
        this.idInventory = idInventory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduct;
        hash += (int) idInventory;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductInventoryPK)) {
            return false;
        }
        ProductInventoryPK other = (ProductInventoryPK) object;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idInventory != other.idInventory) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventory.ProductInventoryPK[ idProduct=" + idProduct + ", idInventory=" + idInventory + " ]";
    }
    
}
