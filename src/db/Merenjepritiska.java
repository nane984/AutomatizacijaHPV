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
@Table(name = "merenjepritiska")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Merenjepritiska.findAll", query = "SELECT m FROM Merenjepritiska m")
    , @NamedQuery(name = "Merenjepritiska.findById", query = "SELECT m FROM Merenjepritiska m WHERE m.id = :id")
    , @NamedQuery(name = "Merenjepritiska.findByDatum", query = "SELECT m FROM Merenjepritiska m WHERE m.datum = :datum")
    , @NamedQuery(name = "Merenjepritiska.findByDl1ulazjkkf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl1ulazjkkf = :dl1ulazjkkf")
    , @NamedQuery(name = "Merenjepritiska.findByDl1izlazjkkf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl1izlazjkkf = :dl1izlazjkkf")
    , @NamedQuery(name = "Merenjepritiska.findByDl1ulazsbaf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl1ulazsbaf = :dl1ulazsbaf")
    , @NamedQuery(name = "Merenjepritiska.findByDl1izlazsbaf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl1izlazsbaf = :dl1izlazsbaf")
    , @NamedQuery(name = "Merenjepritiska.findByDl1ulazjbaf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl1ulazjbaf = :dl1ulazjbaf")
    , @NamedQuery(name = "Merenjepritiska.findByDl1izlazjbaf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl1izlazjbaf = :dl1izlazjbaf")
    , @NamedQuery(name = "Merenjepritiska.findByDl1ulazmf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl1ulazmf = :dl1ulazmf")
    , @NamedQuery(name = "Merenjepritiska.findByDl1izlazmf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl1izlazmf = :dl1izlazmf")
    , @NamedQuery(name = "Merenjepritiska.findByDl2ulazjkkf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl2ulazjkkf = :dl2ulazjkkf")
    , @NamedQuery(name = "Merenjepritiska.findByDl2izlazjkkf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl2izlazjkkf = :dl2izlazjkkf")
    , @NamedQuery(name = "Merenjepritiska.findByDl2ulazsbaf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl2ulazsbaf = :dl2ulazsbaf")
    , @NamedQuery(name = "Merenjepritiska.findByDl2izlazsbaf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl2izlazsbaf = :dl2izlazsbaf")
    , @NamedQuery(name = "Merenjepritiska.findByDl2ulazjbaf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl2ulazjbaf = :dl2ulazjbaf")
    , @NamedQuery(name = "Merenjepritiska.findByDl2izlazjbaf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl2izlazjbaf = :dl2izlazjbaf")
    , @NamedQuery(name = "Merenjepritiska.findByDl2ulazmf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl2ulazmf = :dl2ulazmf")
    , @NamedQuery(name = "Merenjepritiska.findByDl2izlazmf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl2izlazmf = :dl2izlazmf")
    , @NamedQuery(name = "Merenjepritiska.findByDl3ulazjkkf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl3ulazjkkf = :dl3ulazjkkf")
    , @NamedQuery(name = "Merenjepritiska.findByDl3izlazjkkf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl3izlazjkkf = :dl3izlazjkkf")
    , @NamedQuery(name = "Merenjepritiska.findByDl3ulazsbaf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl3ulazsbaf = :dl3ulazsbaf")
    , @NamedQuery(name = "Merenjepritiska.findByDl3izlazsbaf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl3izlazsbaf = :dl3izlazsbaf")
    , @NamedQuery(name = "Merenjepritiska.findByDl3ulazjbaf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl3ulazjbaf = :dl3ulazjbaf")
    , @NamedQuery(name = "Merenjepritiska.findByDl3izlazjbaf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl3izlazjbaf = :dl3izlazjbaf")
    , @NamedQuery(name = "Merenjepritiska.findByDl3ulazmf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl3ulazmf = :dl3ulazmf")
    , @NamedQuery(name = "Merenjepritiska.findByDl3izlazmf", query = "SELECT m FROM Merenjepritiska m WHERE m.dl3izlazmf = :dl3izlazmf")
    , @NamedQuery(name = "Merenjepritiska.findByPf1ulaz", query = "SELECT m FROM Merenjepritiska m WHERE m.pf1ulaz = :pf1ulaz")
    , @NamedQuery(name = "Merenjepritiska.findByPf2ulaz", query = "SELECT m FROM Merenjepritiska m WHERE m.pf2ulaz = :pf2ulaz")
    , @NamedQuery(name = "Merenjepritiska.findByPf3ulaz", query = "SELECT m FROM Merenjepritiska m WHERE m.pf3ulaz = :pf3ulaz")
    , @NamedQuery(name = "Merenjepritiska.findByPf4ulaz", query = "SELECT m FROM Merenjepritiska m WHERE m.pf4ulaz = :pf4ulaz")
    , @NamedQuery(name = "Merenjepritiska.findByPf5ulaz", query = "SELECT m FROM Merenjepritiska m WHERE m.pf5ulaz = :pf5ulaz")
    , @NamedQuery(name = "Merenjepritiska.findByPf6ulaz", query = "SELECT m FROM Merenjepritiska m WHERE m.pf6ulaz = :pf6ulaz")
    , @NamedQuery(name = "Merenjepritiska.findByPf1izlaz", query = "SELECT m FROM Merenjepritiska m WHERE m.pf1izlaz = :pf1izlaz")
    , @NamedQuery(name = "Merenjepritiska.findByPf2izlaz", query = "SELECT m FROM Merenjepritiska m WHERE m.pf2izlaz = :pf2izlaz")
    , @NamedQuery(name = "Merenjepritiska.findByPf3izlaz", query = "SELECT m FROM Merenjepritiska m WHERE m.pf3izlaz = :pf3izlaz")
    , @NamedQuery(name = "Merenjepritiska.findByPf4izlaz", query = "SELECT m FROM Merenjepritiska m WHERE m.pf4izlaz = :pf4izlaz")
    , @NamedQuery(name = "Merenjepritiska.findByPf5izlaz", query = "SELECT m FROM Merenjepritiska m WHERE m.pf5izlaz = :pf5izlaz")
    , @NamedQuery(name = "Merenjepritiska.findByPf6izlaz", query = "SELECT m FROM Merenjepritiska m WHERE m.pf6izlaz = :pf6izlaz")
    , @NamedQuery(name = "Merenjepritiska.findByNi1ulaz", query = "SELECT m FROM Merenjepritiska m WHERE m.ni1ulaz = :ni1ulaz")
    , @NamedQuery(name = "Merenjepritiska.findByNi2ulaz", query = "SELECT m FROM Merenjepritiska m WHERE m.ni2ulaz = :ni2ulaz")
    , @NamedQuery(name = "Merenjepritiska.findByNi3ulaz", query = "SELECT m FROM Merenjepritiska m WHERE m.ni3ulaz = :ni3ulaz")
    , @NamedQuery(name = "Merenjepritiska.findByNi1izlaz", query = "SELECT m FROM Merenjepritiska m WHERE m.ni1izlaz = :ni1izlaz")
    , @NamedQuery(name = "Merenjepritiska.findByNi2izlaz", query = "SELECT m FROM Merenjepritiska m WHERE m.ni2izlaz = :ni2izlaz")
    , @NamedQuery(name = "Merenjepritiska.findByNi3izlaz", query = "SELECT m FROM Merenjepritiska m WHERE m.ni3izlaz = :ni3izlaz")})
public class Merenjepritiska implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Basic(optional = false)
    @Column(name = "dl1ulazjkkf")
    private double dl1ulazjkkf;
    @Basic(optional = false)
    @Column(name = "dl1izlazjkkf")
    private double dl1izlazjkkf;
    @Basic(optional = false)
    @Column(name = "dl1ulazsbaf")
    private double dl1ulazsbaf;
    @Basic(optional = false)
    @Column(name = "dl1izlazsbaf")
    private double dl1izlazsbaf;
    @Basic(optional = false)
    @Column(name = "dl1ulazjbaf")
    private double dl1ulazjbaf;
    @Basic(optional = false)
    @Column(name = "dl1izlazjbaf")
    private double dl1izlazjbaf;
    @Basic(optional = false)
    @Column(name = "dl1ulazmf")
    private double dl1ulazmf;
    @Basic(optional = false)
    @Column(name = "dl1izlazmf")
    private double dl1izlazmf;
    @Basic(optional = false)
    @Column(name = "dl2ulazjkkf")
    private double dl2ulazjkkf;
    @Basic(optional = false)
    @Column(name = "dl2izlazjkkf")
    private double dl2izlazjkkf;
    @Basic(optional = false)
    @Column(name = "dl2ulazsbaf")
    private double dl2ulazsbaf;
    @Basic(optional = false)
    @Column(name = "dl2izlazsbaf")
    private double dl2izlazsbaf;
    @Basic(optional = false)
    @Column(name = "dl2ulazjbaf")
    private double dl2ulazjbaf;
    @Basic(optional = false)
    @Column(name = "dl2izlazjbaf")
    private double dl2izlazjbaf;
    @Basic(optional = false)
    @Column(name = "dl2ulazmf")
    private double dl2ulazmf;
    @Basic(optional = false)
    @Column(name = "dl2izlazmf")
    private double dl2izlazmf;
    @Basic(optional = false)
    @Column(name = "dl3ulazjkkf")
    private double dl3ulazjkkf;
    @Basic(optional = false)
    @Column(name = "dl3izlazjkkf")
    private double dl3izlazjkkf;
    @Basic(optional = false)
    @Column(name = "dl3ulazsbaf")
    private double dl3ulazsbaf;
    @Basic(optional = false)
    @Column(name = "dl3izlazsbaf")
    private double dl3izlazsbaf;
    @Basic(optional = false)
    @Column(name = "dl3ulazjbaf")
    private double dl3ulazjbaf;
    @Basic(optional = false)
    @Column(name = "dl3izlazjbaf")
    private double dl3izlazjbaf;
    @Basic(optional = false)
    @Column(name = "dl3ulazmf")
    private double dl3ulazmf;
    @Basic(optional = false)
    @Column(name = "dl3izlazmf")
    private double dl3izlazmf;
    @Basic(optional = false)
    @Column(name = "pf1ulaz")
    private double pf1ulaz;
    @Basic(optional = false)
    @Column(name = "pf2ulaz")
    private double pf2ulaz;
    @Basic(optional = false)
    @Column(name = "pf3ulaz")
    private double pf3ulaz;
    @Basic(optional = false)
    @Column(name = "pf4ulaz")
    private double pf4ulaz;
    @Basic(optional = false)
    @Column(name = "pf5ulaz")
    private double pf5ulaz;
    @Basic(optional = false)
    @Column(name = "pf6ulaz")
    private double pf6ulaz;
    @Basic(optional = false)
    @Column(name = "pf1izlaz")
    private double pf1izlaz;
    @Basic(optional = false)
    @Column(name = "pf2izlaz")
    private double pf2izlaz;
    @Basic(optional = false)
    @Column(name = "pf3izlaz")
    private double pf3izlaz;
    @Basic(optional = false)
    @Column(name = "pf4izlaz")
    private double pf4izlaz;
    @Basic(optional = false)
    @Column(name = "pf5izlaz")
    private double pf5izlaz;
    @Basic(optional = false)
    @Column(name = "pf6izlaz")
    private double pf6izlaz;
    @Basic(optional = false)
    @Column(name = "ni1ulaz")
    private double ni1ulaz;
    @Basic(optional = false)
    @Column(name = "ni2ulaz")
    private double ni2ulaz;
    @Basic(optional = false)
    @Column(name = "ni3ulaz")
    private double ni3ulaz;
    @Basic(optional = false)
    @Column(name = "ni1izlaz")
    private double ni1izlaz;
    @Basic(optional = false)
    @Column(name = "ni2izlaz")
    private double ni2izlaz;
    @Basic(optional = false)
    @Column(name = "ni3izlaz")
    private double ni3izlaz;

    public Merenjepritiska() {
    }

    public Merenjepritiska(Long id) {
        this.id = id;
    }

    public Merenjepritiska(Long id, Date datum, double dl1ulazjkkf, double dl1izlazjkkf, double dl1ulazsbaf, double dl1izlazsbaf, double dl1ulazjbaf, double dl1izlazjbaf, double dl1ulazmf, double dl1izlazmf, double dl2ulazjkkf, double dl2izlazjkkf, double dl2ulazsbaf, double dl2izlazsbaf, double dl2ulazjbaf, double dl2izlazjbaf, double dl2ulazmf, double dl2izlazmf, double dl3ulazjkkf, double dl3izlazjkkf, double dl3ulazsbaf, double dl3izlazsbaf, double dl3ulazjbaf, double dl3izlazjbaf, double dl3ulazmf, double dl3izlazmf, double pf1ulaz, double pf2ulaz, double pf3ulaz, double pf4ulaz, double pf5ulaz, double pf6ulaz, double pf1izlaz, double pf2izlaz, double pf3izlaz, double pf4izlaz, double pf5izlaz, double pf6izlaz, double ni1ulaz, double ni2ulaz, double ni3ulaz, double ni1izlaz, double ni2izlaz, double ni3izlaz) {
        this.id = id;
        this.datum = datum;
        this.dl1ulazjkkf = dl1ulazjkkf;
        this.dl1izlazjkkf = dl1izlazjkkf;
        this.dl1ulazsbaf = dl1ulazsbaf;
        this.dl1izlazsbaf = dl1izlazsbaf;
        this.dl1ulazjbaf = dl1ulazjbaf;
        this.dl1izlazjbaf = dl1izlazjbaf;
        this.dl1ulazmf = dl1ulazmf;
        this.dl1izlazmf = dl1izlazmf;
        this.dl2ulazjkkf = dl2ulazjkkf;
        this.dl2izlazjkkf = dl2izlazjkkf;
        this.dl2ulazsbaf = dl2ulazsbaf;
        this.dl2izlazsbaf = dl2izlazsbaf;
        this.dl2ulazjbaf = dl2ulazjbaf;
        this.dl2izlazjbaf = dl2izlazjbaf;
        this.dl2ulazmf = dl2ulazmf;
        this.dl2izlazmf = dl2izlazmf;
        this.dl3ulazjkkf = dl3ulazjkkf;
        this.dl3izlazjkkf = dl3izlazjkkf;
        this.dl3ulazsbaf = dl3ulazsbaf;
        this.dl3izlazsbaf = dl3izlazsbaf;
        this.dl3ulazjbaf = dl3ulazjbaf;
        this.dl3izlazjbaf = dl3izlazjbaf;
        this.dl3ulazmf = dl3ulazmf;
        this.dl3izlazmf = dl3izlazmf;
        this.pf1ulaz = pf1ulaz;
        this.pf2ulaz = pf2ulaz;
        this.pf3ulaz = pf3ulaz;
        this.pf4ulaz = pf4ulaz;
        this.pf5ulaz = pf5ulaz;
        this.pf6ulaz = pf6ulaz;
        this.pf1izlaz = pf1izlaz;
        this.pf2izlaz = pf2izlaz;
        this.pf3izlaz = pf3izlaz;
        this.pf4izlaz = pf4izlaz;
        this.pf5izlaz = pf5izlaz;
        this.pf6izlaz = pf6izlaz;
        this.ni1ulaz = ni1ulaz;
        this.ni2ulaz = ni2ulaz;
        this.ni3ulaz = ni3ulaz;
        this.ni1izlaz = ni1izlaz;
        this.ni2izlaz = ni2izlaz;
        this.ni3izlaz = ni3izlaz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getDl1ulazjkkf() {
        return dl1ulazjkkf;
    }

    public void setDl1ulazjkkf(double dl1ulazjkkf) {
        this.dl1ulazjkkf = dl1ulazjkkf;
    }

    public double getDl1izlazjkkf() {
        return dl1izlazjkkf;
    }

    public void setDl1izlazjkkf(double dl1izlazjkkf) {
        this.dl1izlazjkkf = dl1izlazjkkf;
    }

    public double getDl1ulazsbaf() {
        return dl1ulazsbaf;
    }

    public void setDl1ulazsbaf(double dl1ulazsbaf) {
        this.dl1ulazsbaf = dl1ulazsbaf;
    }

    public double getDl1izlazsbaf() {
        return dl1izlazsbaf;
    }

    public void setDl1izlazsbaf(double dl1izlazsbaf) {
        this.dl1izlazsbaf = dl1izlazsbaf;
    }

    public double getDl1ulazjbaf() {
        return dl1ulazjbaf;
    }

    public void setDl1ulazjbaf(double dl1ulazjbaf) {
        this.dl1ulazjbaf = dl1ulazjbaf;
    }

    public double getDl1izlazjbaf() {
        return dl1izlazjbaf;
    }

    public void setDl1izlazjbaf(double dl1izlazjbaf) {
        this.dl1izlazjbaf = dl1izlazjbaf;
    }

    public double getDl1ulazmf() {
        return dl1ulazmf;
    }

    public void setDl1ulazmf(double dl1ulazmf) {
        this.dl1ulazmf = dl1ulazmf;
    }

    public double getDl1izlazmf() {
        return dl1izlazmf;
    }

    public void setDl1izlazmf(double dl1izlazmf) {
        this.dl1izlazmf = dl1izlazmf;
    }

    public double getDl2ulazjkkf() {
        return dl2ulazjkkf;
    }

    public void setDl2ulazjkkf(double dl2ulazjkkf) {
        this.dl2ulazjkkf = dl2ulazjkkf;
    }

    public double getDl2izlazjkkf() {
        return dl2izlazjkkf;
    }

    public void setDl2izlazjkkf(double dl2izlazjkkf) {
        this.dl2izlazjkkf = dl2izlazjkkf;
    }

    public double getDl2ulazsbaf() {
        return dl2ulazsbaf;
    }

    public void setDl2ulazsbaf(double dl2ulazsbaf) {
        this.dl2ulazsbaf = dl2ulazsbaf;
    }

    public double getDl2izlazsbaf() {
        return dl2izlazsbaf;
    }

    public void setDl2izlazsbaf(double dl2izlazsbaf) {
        this.dl2izlazsbaf = dl2izlazsbaf;
    }

    public double getDl2ulazjbaf() {
        return dl2ulazjbaf;
    }

    public void setDl2ulazjbaf(double dl2ulazjbaf) {
        this.dl2ulazjbaf = dl2ulazjbaf;
    }

    public double getDl2izlazjbaf() {
        return dl2izlazjbaf;
    }

    public void setDl2izlazjbaf(double dl2izlazjbaf) {
        this.dl2izlazjbaf = dl2izlazjbaf;
    }

    public double getDl2ulazmf() {
        return dl2ulazmf;
    }

    public void setDl2ulazmf(double dl2ulazmf) {
        this.dl2ulazmf = dl2ulazmf;
    }

    public double getDl2izlazmf() {
        return dl2izlazmf;
    }

    public void setDl2izlazmf(double dl2izlazmf) {
        this.dl2izlazmf = dl2izlazmf;
    }

    public double getDl3ulazjkkf() {
        return dl3ulazjkkf;
    }

    public void setDl3ulazjkkf(double dl3ulazjkkf) {
        this.dl3ulazjkkf = dl3ulazjkkf;
    }

    public double getDl3izlazjkkf() {
        return dl3izlazjkkf;
    }

    public void setDl3izlazjkkf(double dl3izlazjkkf) {
        this.dl3izlazjkkf = dl3izlazjkkf;
    }

    public double getDl3ulazsbaf() {
        return dl3ulazsbaf;
    }

    public void setDl3ulazsbaf(double dl3ulazsbaf) {
        this.dl3ulazsbaf = dl3ulazsbaf;
    }

    public double getDl3izlazsbaf() {
        return dl3izlazsbaf;
    }

    public void setDl3izlazsbaf(double dl3izlazsbaf) {
        this.dl3izlazsbaf = dl3izlazsbaf;
    }

    public double getDl3ulazjbaf() {
        return dl3ulazjbaf;
    }

    public void setDl3ulazjbaf(double dl3ulazjbaf) {
        this.dl3ulazjbaf = dl3ulazjbaf;
    }

    public double getDl3izlazjbaf() {
        return dl3izlazjbaf;
    }

    public void setDl3izlazjbaf(double dl3izlazjbaf) {
        this.dl3izlazjbaf = dl3izlazjbaf;
    }

    public double getDl3ulazmf() {
        return dl3ulazmf;
    }

    public void setDl3ulazmf(double dl3ulazmf) {
        this.dl3ulazmf = dl3ulazmf;
    }

    public double getDl3izlazmf() {
        return dl3izlazmf;
    }

    public void setDl3izlazmf(double dl3izlazmf) {
        this.dl3izlazmf = dl3izlazmf;
    }

    public double getPf1ulaz() {
        return pf1ulaz;
    }

    public void setPf1ulaz(double pf1ulaz) {
        this.pf1ulaz = pf1ulaz;
    }

    public double getPf2ulaz() {
        return pf2ulaz;
    }

    public void setPf2ulaz(double pf2ulaz) {
        this.pf2ulaz = pf2ulaz;
    }

    public double getPf3ulaz() {
        return pf3ulaz;
    }

    public void setPf3ulaz(double pf3ulaz) {
        this.pf3ulaz = pf3ulaz;
    }

    public double getPf4ulaz() {
        return pf4ulaz;
    }

    public void setPf4ulaz(double pf4ulaz) {
        this.pf4ulaz = pf4ulaz;
    }

    public double getPf5ulaz() {
        return pf5ulaz;
    }

    public void setPf5ulaz(double pf5ulaz) {
        this.pf5ulaz = pf5ulaz;
    }

    public double getPf6ulaz() {
        return pf6ulaz;
    }

    public void setPf6ulaz(double pf6ulaz) {
        this.pf6ulaz = pf6ulaz;
    }

    public double getPf1izlaz() {
        return pf1izlaz;
    }

    public void setPf1izlaz(double pf1izlaz) {
        this.pf1izlaz = pf1izlaz;
    }

    public double getPf2izlaz() {
        return pf2izlaz;
    }

    public void setPf2izlaz(double pf2izlaz) {
        this.pf2izlaz = pf2izlaz;
    }

    public double getPf3izlaz() {
        return pf3izlaz;
    }

    public void setPf3izlaz(double pf3izlaz) {
        this.pf3izlaz = pf3izlaz;
    }

    public double getPf4izlaz() {
        return pf4izlaz;
    }

    public void setPf4izlaz(double pf4izlaz) {
        this.pf4izlaz = pf4izlaz;
    }

    public double getPf5izlaz() {
        return pf5izlaz;
    }

    public void setPf5izlaz(double pf5izlaz) {
        this.pf5izlaz = pf5izlaz;
    }

    public double getPf6izlaz() {
        return pf6izlaz;
    }

    public void setPf6izlaz(double pf6izlaz) {
        this.pf6izlaz = pf6izlaz;
    }

    public double getNi1ulaz() {
        return ni1ulaz;
    }

    public void setNi1ulaz(double ni1ulaz) {
        this.ni1ulaz = ni1ulaz;
    }

    public double getNi2ulaz() {
        return ni2ulaz;
    }

    public void setNi2ulaz(double ni2ulaz) {
        this.ni2ulaz = ni2ulaz;
    }

    public double getNi3ulaz() {
        return ni3ulaz;
    }

    public void setNi3ulaz(double ni3ulaz) {
        this.ni3ulaz = ni3ulaz;
    }

    public double getNi1izlaz() {
        return ni1izlaz;
    }

    public void setNi1izlaz(double ni1izlaz) {
        this.ni1izlaz = ni1izlaz;
    }

    public double getNi2izlaz() {
        return ni2izlaz;
    }

    public void setNi2izlaz(double ni2izlaz) {
        this.ni2izlaz = ni2izlaz;
    }

    public double getNi3izlaz() {
        return ni3izlaz;
    }

    public void setNi3izlaz(double ni3izlaz) {
        this.ni3izlaz = ni3izlaz;
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
        if (!(object instanceof Merenjepritiska)) {
            return false;
        }
        Merenjepritiska other = (Merenjepritiska) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Merenjepritiska[ id=" + id + " ]";
    }
    
}
