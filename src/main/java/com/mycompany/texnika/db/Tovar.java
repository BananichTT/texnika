/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.texnika.db;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author buldi
 */
@Entity
@Table(name = "tovar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tovar.findAll", query = "SELECT t FROM Tovar t"),
    @NamedQuery(name = "Tovar.findByIdTovar", query = "SELECT t FROM Tovar t WHERE t.idTovar = :idTovar"),
    @NamedQuery(name = "Tovar.findByName", query = "SELECT t FROM Tovar t WHERE t.name = :name"),
    @NamedQuery(name = "Tovar.findByType", query = "SELECT t FROM Tovar t WHERE t.type = :type"),
    @NamedQuery(name = "Tovar.findByCost", query = "SELECT t FROM Tovar t WHERE t.cost = :cost")})
public class Tovar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTovar")
    private Integer idTovar;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private BigDecimal cost;

    public Tovar() {
    }

    public Tovar(Integer idTovar) {
        this.idTovar = idTovar;
    }

    public Integer getIdTovar() {
        return idTovar;
    }

    public void setIdTovar(Integer idTovar) {
        this.idTovar = idTovar;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTovar != null ? idTovar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tovar)) {
            return false;
        }
        Tovar other = (Tovar) object;
        if ((this.idTovar == null && other.idTovar != null) || (this.idTovar != null && !this.idTovar.equals(other.idTovar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.texnika.db.Tovar[ idTovar=" + idTovar + " ]";
    }
    
}
