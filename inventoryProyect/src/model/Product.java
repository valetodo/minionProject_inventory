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
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByIdProduct", query = "SELECT p FROM Product p WHERE p.idProduct = :idProduct"),
    @NamedQuery(name = "Product.findByIdDurable", query = "SELECT p FROM Product p WHERE p.idDurable = :idDurable"),
    @NamedQuery(name = "Product.findByIdConsume", query = "SELECT p FROM Product p WHERE p.idConsume = :idConsume"),
    @NamedQuery(name = "Product.findByIdCategory", query = "SELECT p FROM Product p WHERE p.idCategory = :idCategory"),
    @NamedQuery(name = "Product.findByNameProduct", query = "SELECT p FROM Product p WHERE p.nameProduct = :nameProduct"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByStatus", query = "SELECT p FROM Product p WHERE p.status = :status"),
    @NamedQuery(name = "Product.findByLocation", query = "SELECT p FROM Product p WHERE p.location = :location"),
    @NamedQuery(name = "Product.findByQuantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Product.findByStock", query = "SELECT p FROM Product p WHERE p.stock = :stock")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRODUCT")
    private Integer idProduct;
    @Column(name = "ID_DURABLE")
    private Integer idDurable;
    @Column(name = "ID_CONSUME")
    private Integer idConsume;
    @Column(name = "ID_CATEGORY")
    private Integer idCategory;
    @Column(name = "NAME_PRODUCT_")
    private String nameProduct;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "STOCK")
    private Integer stock;

    public Product() {
    }

    public Product(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdDurable() {
        return idDurable;
    }

    public void setIdDurable(Integer idDurable) {
        this.idDurable = idDurable;
    }

    public Integer getIdConsume() {
        return idConsume;
    }

    public void setIdConsume(Integer idConsume) {
        this.idConsume = idConsume;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventory.Product[ idProduct=" + idProduct + " ]";
    }
    
    public void increaseQuantity(Integer quantity) {
        this.quantity += quantity;
    }
    
    public void decreaseQuantity(Integer quantity){
        this.quantity -= quantity;
    }
}
