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

/**
 *
 * @author yerel-estalin
 */
@Entity
@Table(name = "history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "History.findAll", query = "SELECT h FROM History h"),
    @NamedQuery(name = "History.findByIdHistory", query = "SELECT h FROM History h WHERE h.idHistory = :idHistory"),
    @NamedQuery(name = "History.findByIdProduct", query = "SELECT h FROM History h WHERE h.idProduct = :idProduct"),
    @NamedQuery(name = "History.findByDateHistory", query = "SELECT h FROM History h WHERE h.dateHistory = :dateHistory"),
    @NamedQuery(name = "History.findBetweenDatesHistory", query = "SELECT h FROM History h WHERE h.dateHistory BETWEEN :startDate AND :endDate order by h.dateHistory"),
    @NamedQuery(name = "History.findByQuantityIni", query = "SELECT h FROM History h WHERE h.quantityIni = :quantityIni"),
    @NamedQuery(name = "History.findByQuantityFinal", query = "SELECT h FROM History h WHERE h.quantityFinal = :quantityFinal")})
public class History implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_HISTORY")
    private Integer idHistory;
    @Column(name = "ID_PRODUCT")
    private Integer idProduct;
    @Column(name = "DATE_HISTORY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHistory;
    @Column(name = "QUANTITY_INI")
    private Integer quantityIni;
    @Column(name = "QUANTITY_FINAL")
    private Integer quantityFinal;

    public History() {
    }

    public History(Integer idHistory) {
        this.idHistory = idHistory;
    }

    public Integer getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(Integer idHistory) {
        this.idHistory = idHistory;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Date getDateHistory() {
        return dateHistory;
    }

    public void setDateHistory(Date dateHistory) {
        this.dateHistory = dateHistory;
    }

    public Integer getQuantityIni() {
        return quantityIni;
    }

    public void setQuantityIni(Integer quantityIni) {
        this.quantityIni = quantityIni;
    }

    public Integer getQuantityFinal() {
        return quantityFinal;
    }

    public void setQuantityFinal(Integer quantityFinal) {
        this.quantityFinal = quantityFinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistory != null ? idHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof History)) {
            return false;
        }
        History other = (History) object;
        if ((this.idHistory == null && other.idHistory != null) || (this.idHistory != null && !this.idHistory.equals(other.idHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventory.History[ idHistory=" + idHistory + " ]";
    }
    
}
