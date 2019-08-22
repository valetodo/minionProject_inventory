package com.inventory.models.dbentities;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "history")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "History.findAll", query = "SELECT i FROM Product i")
        , @NamedQuery(name = "History.findByIdHistory", query = "SELECT i FROM History i WHERE p.idHistory = :idHistory")
        , @NamedQuery(name = "Inventory.findByQuatity", query = "SELECT i FROM History i WHERE i.quatity = :quatity")
        , @NamedQuery(name = "Inventory.findByProductId", query = "SELECT i FROM History i WHERE i.productId = :productId")})
public class History implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_history")
    private Integer idHistory;
    @Basic(optional = false)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @Column(name = "quatity")
    private int quatity;
    @Basic(optional = false)
    @Column(name = "product_id")
    private int productId;

    public History (Integer idHistory, String date, Integer quatity, Integer productId) {
        this.idHistory = idHistory;
        this.date = date;
        this.quatity = quatity;
        this.productId = productId;
    }

    public History() {

    }

    public Integer getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(Integer idHistory) {
        this.idHistory = idHistory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

}
