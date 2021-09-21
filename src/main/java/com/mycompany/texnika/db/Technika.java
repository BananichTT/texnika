/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.texnika.db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author buldi
 */
@Entity
@Table(name = "technika")
@NamedQueries({
    @NamedQuery(name = "Technika.findAll", query = "SELECT t FROM Technika t"),
    @NamedQuery(name = "Technika.findByIdT", query = "SELECT t FROM Technika t WHERE t.idT = :idT"),
    @NamedQuery(name = "Technika.findByName", query = "SELECT t FROM Technika t WHERE t.name = :name"),
    @NamedQuery(name = "Technika.findByType", query = "SELECT t FROM Technika t WHERE t.type = :type"),
    @NamedQuery(name = "Technika.findByCost", query = "SELECT t FROM Technika t WHERE t.cost = :cost"),
    @NamedQuery(name = "Technika.findByOnSclad", query = "SELECT t FROM Technika t WHERE t.onSclad = :onSclad")})
public class Technika implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_t")
    private Integer idT;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "on_sclad")
    private Integer onSclad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "technikaIdT")
    private Collection<Order1> order1Collection;

    public Technika() {
    }

    public Technika(Integer idT) {
        this.idT = idT;
    }

    public Integer getIdT() {
        return idT;
    }

    public void setIdT(Integer idT) {
        this.idT = idT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getOnSclad() {
        return onSclad;
    }

    public void setOnSclad(Integer onSclad) {
        this.onSclad = onSclad;
    }

    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idT != null ? idT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Technika)) {
            return false;
        }
        Technika other = (Technika) object;
        if ((this.idT == null && other.idT != null) || (this.idT != null && !this.idT.equals(other.idT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.texnika.db.Technika[ idT=" + idT + " ]";
    }
    
}
