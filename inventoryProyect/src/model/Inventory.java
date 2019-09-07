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

@Entity
@Table(name = "inventory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i"),
    @NamedQuery(name = "Inventory.findByIdInventory", query = "SELECT i FROM Inventory i WHERE i.idInventory = :idInventory"),
    @NamedQuery(name = "Inventory.findByNameInventory", query = "SELECT i FROM Inventory i WHERE i.nameInventory = :nameInventory"),
    @NamedQuery(name = "Inventory.findByDateInvetory", query = "SELECT i FROM Inventory i WHERE i.dateInvetory = :dateInvetory")})
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INVENTORY")
    private Integer idInventory;
    @Column(name = "NAME_INVENTORY")
    private String nameInventory;
    @Column(name = "DATE_INVETORY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInvetory;

    public Inventory() {
    }

    public Inventory(Integer idInventory) {
        this.idInventory = idInventory;
    }

    public Integer getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(Integer idInventory) {
        this.idInventory = idInventory;
    }

    public String getNameInventory() {
        return nameInventory;
    }

    public void setNameInventory(String nameInventory) {
        this.nameInventory = nameInventory;
    }

    public Date getDateInvetory() {
        return dateInvetory;
    }

    public void setDateInvetory(Date dateInvetory) {
        this.dateInvetory = dateInvetory;
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
        return "inventory.Inventory[ idInventory=" + idInventory + " ]";
    }
    
}
