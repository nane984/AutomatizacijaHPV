/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

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
 * @author branko.scekic
 */
@Entity
@Table(name = "merenjeprotoka")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Merenjeprotoka.findAll", query = "SELECT m FROM Merenjeprotoka m")
    , @NamedQuery(name = "Merenjeprotoka.findById", query = "SELECT m FROM Merenjeprotoka m WHERE m.id = :id")
    , @NamedQuery(name = "Merenjeprotoka.findByDate", query = "SELECT m FROM Merenjeprotoka m WHERE m.date = :date")
    , @NamedQuery(name = "Merenjeprotoka.findByUlazdl1", query = "SELECT m FROM Merenjeprotoka m WHERE m.ulazdl1 = :ulazdl1")
    , @NamedQuery(name = "Merenjeprotoka.findByUlazdl2", query = "SELECT m FROM Merenjeprotoka m WHERE m.ulazdl2 = :ulazdl2")
    , @NamedQuery(name = "Merenjeprotoka.findByUlazdl3", query = "SELECT m FROM Merenjeprotoka m WHERE m.ulazdl3 = :ulazdl3")
    , @NamedQuery(name = "Merenjeprotoka.findByIzlazdl1", query = "SELECT m FROM Merenjeprotoka m WHERE m.izlazdl1 = :izlazdl1")
    , @NamedQuery(name = "Merenjeprotoka.findByIzlazdl2", query = "SELECT m FROM Merenjeprotoka m WHERE m.izlazdl2 = :izlazdl2")
    , @NamedQuery(name = "Merenjeprotoka.findByIzlazdl3", query = "SELECT m FROM Merenjeprotoka m WHERE m.izlazdl3 = :izlazdl3")
    , @NamedQuery(name = "Merenjeprotoka.findByHclpotispretovarnihpumi", query = "SELECT m FROM Merenjeprotoka m WHERE m.hclpotispretovarnihpumi = :hclpotispretovarnihpumi")
    , @NamedQuery(name = "Merenjeprotoka.findByLuzinapotispretovarnihpumi", query = "SELECT m FROM Merenjeprotoka m WHERE m.luzinapotispretovarnihpumi = :luzinapotispretovarnihpumi")
    , @NamedQuery(name = "Merenjeprotoka.findByHclpotisdozirpumpi", query = "SELECT m FROM Merenjeprotoka m WHERE m.hclpotisdozirpumpi = :hclpotisdozirpumpi")
    , @NamedQuery(name = "Merenjeprotoka.findBySirovavodaureaktor1", query = "SELECT m FROM Merenjeprotoka m WHERE m.sirovavodaureaktor1 = :sirovavodaureaktor1")
    , @NamedQuery(name = "Merenjeprotoka.findBySirovavodaureaktor2", query = "SELECT m FROM Merenjeprotoka m WHERE m.sirovavodaureaktor2 = :sirovavodaureaktor2")
    , @NamedQuery(name = "Merenjeprotoka.findByPf1", query = "SELECT m FROM Merenjeprotoka m WHERE m.pf1 = :pf1")
    , @NamedQuery(name = "Merenjeprotoka.findByPf2", query = "SELECT m FROM Merenjeprotoka m WHERE m.pf2 = :pf2")
    , @NamedQuery(name = "Merenjeprotoka.findByPf3", query = "SELECT m FROM Merenjeprotoka m WHERE m.pf3 = :pf3")
    , @NamedQuery(name = "Merenjeprotoka.findByPf4", query = "SELECT m FROM Merenjeprotoka m WHERE m.pf4 = :pf4")
    , @NamedQuery(name = "Merenjeprotoka.findByPf5", query = "SELECT m FROM Merenjeprotoka m WHERE m.pf5 = :pf5")
    , @NamedQuery(name = "Merenjeprotoka.findByPf6", query = "SELECT m FROM Merenjeprotoka m WHERE m.pf6 = :pf6")
    , @NamedQuery(name = "Merenjeprotoka.findByNi1", query = "SELECT m FROM Merenjeprotoka m WHERE m.ni1 = :ni1")
    , @NamedQuery(name = "Merenjeprotoka.findByNi2", query = "SELECT m FROM Merenjeprotoka m WHERE m.ni2 = :ni2")
    , @NamedQuery(name = "Merenjeprotoka.findByNi3", query = "SELECT m FROM Merenjeprotoka m WHERE m.ni3 = :ni3")
    , @NamedQuery(name = "Merenjeprotoka.findByKompenzacionirezervoar", query = "SELECT m FROM Merenjeprotoka m WHERE m.kompenzacionirezervoar = :kompenzacionirezervoar")})
public class Merenjeprotoka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "ulazdl1")
    private double ulazdl1;
    @Basic(optional = false)
    @Column(name = "ulazdl2")
    private double ulazdl2;
    @Basic(optional = false)
    @Column(name = "ulazdl3")
    private double ulazdl3;
    @Basic(optional = false)
    @Column(name = "izlazdl1")
    private double izlazdl1;
    @Basic(optional = false)
    @Column(name = "izlazdl2")
    private double izlazdl2;
    @Basic(optional = false)
    @Column(name = "izlazdl3")
    private double izlazdl3;
    @Basic(optional = false)
    @Column(name = "hclpotispretovarnihpumi")
    private double hclpotispretovarnihpumi;
    @Basic(optional = false)
    @Column(name = "luzinapotispretovarnihpumi")
    private double luzinapotispretovarnihpumi;
    @Basic(optional = false)
    @Column(name = "hclpotisdozirpumpi")
    private double hclpotisdozirpumpi;
    @Basic(optional = false)
    @Column(name = "sirovavodaureaktor1")
    private double sirovavodaureaktor1;
    @Basic(optional = false)
    @Column(name = "sirovavodaureaktor2")
    private double sirovavodaureaktor2;
    @Basic(optional = false)
    @Column(name = "pf1")
    private double pf1;
    @Basic(optional = false)
    @Column(name = "pf2")
    private double pf2;
    @Basic(optional = false)
    @Column(name = "pf3")
    private double pf3;
    @Basic(optional = false)
    @Column(name = "pf4")
    private double pf4;
    @Basic(optional = false)
    @Column(name = "pf5")
    private double pf5;
    @Basic(optional = false)
    @Column(name = "pf6")
    private double pf6;
    @Basic(optional = false)
    @Column(name = "ni1")
    private double ni1;
    @Basic(optional = false)
    @Column(name = "ni2")
    private double ni2;
    @Basic(optional = false)
    @Column(name = "ni3")
    private double ni3;
    @Basic(optional = false)
    @Column(name = "kompenzacionirezervoar")
    private double kompenzacionirezervoar;

    public Merenjeprotoka() {
    }

    public Merenjeprotoka(Long id) {
        this.id = id;
    }

    public Merenjeprotoka(Long id, Date date, double ulazdl1, double ulazdl2, double ulazdl3, double izlazdl1, double izlazdl2, double izlazdl3, double hclpotispretovarnihpumi, double luzinapotispretovarnihpumi, double hclpotisdozirpumpi, double sirovavodaureaktor1, double sirovavodaureaktor2, double pf1, double pf2, double pf3, double pf4, double pf5, double pf6, double ni1, double ni2, double ni3, double kompenzacionirezervoar) {
        this.id = id;
        this.date = date;
        this.ulazdl1 = ulazdl1;
        this.ulazdl2 = ulazdl2;
        this.ulazdl3 = ulazdl3;
        this.izlazdl1 = izlazdl1;
        this.izlazdl2 = izlazdl2;
        this.izlazdl3 = izlazdl3;
        this.hclpotispretovarnihpumi = hclpotispretovarnihpumi;
        this.luzinapotispretovarnihpumi = luzinapotispretovarnihpumi;
        this.hclpotisdozirpumpi = hclpotisdozirpumpi;
        this.sirovavodaureaktor1 = sirovavodaureaktor1;
        this.sirovavodaureaktor2 = sirovavodaureaktor2;
        this.pf1 = pf1;
        this.pf2 = pf2;
        this.pf3 = pf3;
        this.pf4 = pf4;
        this.pf5 = pf5;
        this.pf6 = pf6;
        this.ni1 = ni1;
        this.ni2 = ni2;
        this.ni3 = ni3;
        this.kompenzacionirezervoar = kompenzacionirezervoar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getUlazdl1() {
        return ulazdl1;
    }

    public void setUlazdl1(double ulazdl1) {
        this.ulazdl1 = ulazdl1;
    }

    public double getUlazdl2() {
        return ulazdl2;
    }

    public void setUlazdl2(double ulazdl2) {
        this.ulazdl2 = ulazdl2;
    }

    public double getUlazdl3() {
        return ulazdl3;
    }

    public void setUlazdl3(double ulazdl3) {
        this.ulazdl3 = ulazdl3;
    }

    public double getIzlazdl1() {
        return izlazdl1;
    }

    public void setIzlazdl1(double izlazdl1) {
        this.izlazdl1 = izlazdl1;
    }

    public double getIzlazdl2() {
        return izlazdl2;
    }

    public void setIzlazdl2(double izlazdl2) {
        this.izlazdl2 = izlazdl2;
    }

    public double getIzlazdl3() {
        return izlazdl3;
    }

    public void setIzlazdl3(double izlazdl3) {
        this.izlazdl3 = izlazdl3;
    }

    public double getHclpotispretovarnihpumi() {
        return hclpotispretovarnihpumi;
    }

    public void setHclpotispretovarnihpumi(double hclpotispretovarnihpumi) {
        this.hclpotispretovarnihpumi = hclpotispretovarnihpumi;
    }

    public double getLuzinapotispretovarnihpumi() {
        return luzinapotispretovarnihpumi;
    }

    public void setLuzinapotispretovarnihpumi(double luzinapotispretovarnihpumi) {
        this.luzinapotispretovarnihpumi = luzinapotispretovarnihpumi;
    }

    public double getHclpotisdozirpumpi() {
        return hclpotisdozirpumpi;
    }

    public void setHclpotisdozirpumpi(double hclpotisdozirpumpi) {
        this.hclpotisdozirpumpi = hclpotisdozirpumpi;
    }

    public double getSirovavodaureaktor1() {
        return sirovavodaureaktor1;
    }

    public void setSirovavodaureaktor1(double sirovavodaureaktor1) {
        this.sirovavodaureaktor1 = sirovavodaureaktor1;
    }

    public double getSirovavodaureaktor2() {
        return sirovavodaureaktor2;
    }

    public void setSirovavodaureaktor2(double sirovavodaureaktor2) {
        this.sirovavodaureaktor2 = sirovavodaureaktor2;
    }

    public double getPf1() {
        return pf1;
    }

    public void setPf1(double pf1) {
        this.pf1 = pf1;
    }

    public double getPf2() {
        return pf2;
    }

    public void setPf2(double pf2) {
        this.pf2 = pf2;
    }

    public double getPf3() {
        return pf3;
    }

    public void setPf3(double pf3) {
        this.pf3 = pf3;
    }

    public double getPf4() {
        return pf4;
    }

    public void setPf4(double pf4) {
        this.pf4 = pf4;
    }

    public double getPf5() {
        return pf5;
    }

    public void setPf5(double pf5) {
        this.pf5 = pf5;
    }

    public double getPf6() {
        return pf6;
    }

    public void setPf6(double pf6) {
        this.pf6 = pf6;
    }

    public double getNi1() {
        return ni1;
    }

    public void setNi1(double ni1) {
        this.ni1 = ni1;
    }

    public double getNi2() {
        return ni2;
    }

    public void setNi2(double ni2) {
        this.ni2 = ni2;
    }

    public double getNi3() {
        return ni3;
    }

    public void setNi3(double ni3) {
        this.ni3 = ni3;
    }

    public double getKompenzacionirezervoar() {
        return kompenzacionirezervoar;
    }

    public void setKompenzacionirezervoar(double kompenzacionirezervoar) {
        this.kompenzacionirezervoar = kompenzacionirezervoar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Merenjeprotoka)) {
            return false;
        }
        Merenjeprotoka other = (Merenjeprotoka) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Merenjeprotoka[ id=" + id + " ]";
    }
    
}
