package com.inventory.models.dbentities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ccalvi
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
        , @NamedQuery(name = "Product.findByIdProduct", query = "SELECT p FROM Product p WHERE p.idProduct = :idProduct")
        , @NamedQuery(name = "Product.findByQuantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product")
    private Integer idProduct;
    @Basic(optional = false)
    @Lob
    @Column(name = "name_product", columnDefinition = "TEXT")
    private String nameProduct;
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @Lob
    @Column(name = "status", columnDefinition = "TEXT")
    private String status;
    @Basic(optional = false)
    @Lob
    @Column(name = "location", columnDefinition = "TEXT")
    private String location;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "id_durable", referencedColumnName = "id_durable")
    @ManyToOne(optional = false)
    private Durable idDurable;
    @JoinColumn(name = "id_consume", referencedColumnName = "id_consume")
    @ManyToOne(optional = false)
    private Consume idConsume;
    @JoinColumn(name = "id_brand", referencedColumnName = "id_brand")
    @ManyToOne(optional = false)
    private Productbrand idBrand;
    @JoinColumn(name = "id_stock", referencedColumnName = "id_stock")
    @ManyToOne(optional = false)
    private Stock idStock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduct")
    private Collection<Category> categoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduct")
    private Collection<Inventory> inventoryCollection;

    public Product() {
        this.price = BigDecimal.valueOf(0);
    }

    public Product(Integer idProduct) {
        this.idProduct = idProduct;
        this.price = BigDecimal.valueOf(0);
    }

    public Product(Integer idProduct, String nameProduct, BigDecimal price, String status, String location, int quantity) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.status = status;
        this.location = location;
        this.quantity = quantity;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Durable getIdDurable() {
        return idDurable;
    }

    public void setIdDurable(Durable idDurable) {
        this.idDurable = idDurable;
    }

    public Consume getIdConsume() {
        return idConsume;
    }

    public void setIdConsume(Consume idConsume) {
        this.idConsume = idConsume;
    }

    public Productbrand getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Productbrand idBrand) {
        this.idBrand = idBrand;
    }

    public Stock getIdStock() {
        return idStock;
    }

    public void setIdStock(Stock idStock) {
        this.idStock = idStock;
    }

    @XmlTransient
    public Collection<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    @XmlTransient
    public Collection<Inventory> getInventoryCollection() {
        return inventoryCollection;
    }

    public void setInventoryCollection(Collection<Inventory> inventoryCollection) {
        this.inventoryCollection = inventoryCollection;
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
        return "dbmodels.Product[ idProduct=" + idProduct + " ]";
    }

    public String printInfo() {
        return "idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", price=" + price.doubleValue() + ", brand=" + idBrand.getNameBrand();
    }

}
