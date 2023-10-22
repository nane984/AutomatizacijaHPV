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
@Table(name = "pumpeodrzavanje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pumpeodrzavanje.findAll", query = "SELECT p FROM Pumpeodrzavanje p")
    , @NamedQuery(name = "Pumpeodrzavanje.findByOpis", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.opis = :opis")
    , @NamedQuery(name = "Pumpeodrzavanje.findByDatum", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.datum = :datum")
    , @NamedQuery(name = "Pumpeodrzavanje.findByRadhh", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.radhh = :radhh")
    , @NamedQuery(name = "Pumpeodrzavanje.findByRadmm", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.radmm = :radmm")
    , @NamedQuery(name = "Pumpeodrzavanje.findByV1", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.v1 = :v1")
    , @NamedQuery(name = "Pumpeodrzavanje.findByH1", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.h1 = :h1")
    , @NamedQuery(name = "Pumpeodrzavanje.findByA1", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.a1 = :a1")
    , @NamedQuery(name = "Pumpeodrzavanje.findByV2", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.v2 = :v2")
    , @NamedQuery(name = "Pumpeodrzavanje.findByH2", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.h2 = :h2")
    , @NamedQuery(name = "Pumpeodrzavanje.findByA2", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.a2 = :a2")
    , @NamedQuery(name = "Pumpeodrzavanje.findByV3", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.v3 = :v3")
    , @NamedQuery(name = "Pumpeodrzavanje.findByH3", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.h3 = :h3")
    , @NamedQuery(name = "Pumpeodrzavanje.findByA3", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.a3 = :a3")
    , @NamedQuery(name = "Pumpeodrzavanje.findByV4", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.v4 = :v4")
    , @NamedQuery(name = "Pumpeodrzavanje.findByH4", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.h4 = :h4")
    , @NamedQuery(name = "Pumpeodrzavanje.findByA4", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.a4 = :a4")
    , @NamedQuery(name = "Pumpeodrzavanje.findById", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.id = :id")
    , @NamedQuery(name = "Pumpeodrzavanje.findByTehozn", query = "SELECT p FROM Pumpeodrzavanje p WHERE p.tehozn = :tehozn ORDER BY p.datum DESC")})
public class Pumpeodrzavanje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "opis")
    private String opis;
    @Basic(optional = false)
    @Column(name = "datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Basic(optional = false)
    @Column(name = "radhh")
    private int radhh;
    @Basic(optional = false)
    @Column(name = "radmm")
    private int radmm;
    @Basic(optional = false)
    @Column(name = "v1")
    private double v1;
    @Basic(optional = false)
    @Column(name = "h1")
    private double h1;
    @Basic(optional = false)
    @Column(name = "a1")
    private double a1;
    @Basic(optional = false)
    @Column(name = "v2")
    private double v2;
    @Basic(optional = false)
    @Column(name = "h2")
    private double h2;
    @Basic(optional = false)
    @Column(name = "a2")
    private double a2;
    @Basic(optional = false)
    @Column(name = "v3")
    private double v3;
    @Basic(optional = false)
    @Column(name = "h3")
    private double h3;
    @Basic(optional = false)
    @Column(name = "a3")
    private double a3;
    @Basic(optional = false)
    @Column(name = "v4")
    private double v4;
    @Basic(optional = false)
    @Column(name = "h4")
    private double h4;
    @Basic(optional = false)
    @Column(name = "a4")
    private double a4;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "tehozn")
    private String tehozn;

    public Pumpeodrzavanje() {
    }

    public Pumpeodrzavanje(Long id) {
        this.id = id;
    }

    public Pumpeodrzavanje(Long id, String opis, Date datum, int radhh, int radmm, double v1, double h1, double a1, double v2, double h2, double a2, double v3, double h3, double a3, double v4, double h4, double a4, String tehozn) {
        this.id = id;
        this.opis = opis;
        this.datum = datum;
        this.radhh = radhh;
        this.radmm = radmm;
        this.v1 = v1;
        this.h1 = h1;
        this.a1 = a1;
        this.v2 = v2;
        this.h2 = h2;
        this.a2 = a2;
        this.v3 = v3;
        this.h3 = h3;
        this.a3 = a3;
        this.v4 = v4;
        this.h4 = h4;
        this.a4 = a4;
        this.tehozn = tehozn;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getRadhh() {
        return radhh;
    }

    public void setRadhh(int radhh) {
        this.radhh = radhh;
    }

    public int getRadmm() {
        return radmm;
    }

    public void setRadmm(int radmm) {
        this.radmm = radmm;
    }

    public double getV1() {
        return v1;
    }

    public void setV1(double v1) {
        this.v1 = v1;
    }

    public double getH1() {
        return h1;
    }

    public void setH1(double h1) {
        this.h1 = h1;
    }

    public double getA1() {
        return a1;
    }

    public void setA1(double a1) {
        this.a1 = a1;
    }

    public double getV2() {
        return v2;
    }

    public void setV2(double v2) {
        this.v2 = v2;
    }

    public double getH2() {
        return h2;
    }

    public void setH2(double h2) {
        this.h2 = h2;
    }

    public double getA2() {
        return a2;
    }

    public void setA2(double a2) {
        this.a2 = a2;
    }

    public double getV3() {
        return v3;
    }

    public void setV3(double v3) {
        this.v3 = v3;
    }

    public double getH3() {
        return h3;
    }

    public void setH3(double h3) {
        this.h3 = h3;
    }

    public double getA3() {
        return a3;
    }

    public void setA3(double a3) {
        this.a3 = a3;
    }

    public double getV4() {
        return v4;
    }

    public void setV4(double v4) {
        this.v4 = v4;
    }

    public double getH4() {
        return h4;
    }

    public void setH4(double h4) {
        this.h4 = h4;
    }

    public double getA4() {
        return a4;
    }

    public void setA4(double a4) {
        this.a4 = a4;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTehozn() {
        return tehozn;
    }

    public void setTehozn(String tehozn) {
        this.tehozn = tehozn;
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
        if (!(object instanceof Pumpeodrzavanje)) {
            return false;
        }
        Pumpeodrzavanje other = (Pumpeodrzavanje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Pumpeodrzavanje[ id=" + id + " ]";
    }
    
}
