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
@Table(name = "pumpeuptime")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pumpeuptime.findAll", query = "SELECT p FROM Pumpeuptime p")
    , @NamedQuery(name = "Pumpeuptime.findByHh", query = "SELECT p FROM Pumpeuptime p WHERE p.hh = :hh")
    , @NamedQuery(name = "Pumpeuptime.findByMm", query = "SELECT p FROM Pumpeuptime p WHERE p.mm = :mm")
    , @NamedQuery(name = "Pumpeuptime.findByDatum", query = "SELECT p FROM Pumpeuptime p WHERE p.datum = :datum")
    , @NamedQuery(name = "Pumpeuptime.findByTehozn", query = "SELECT p FROM Pumpeuptime p WHERE p.tehozn = :tehozn")})
public class Pumpeuptime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "hh")
    private int hh;
    @Basic(optional = false)
    @Column(name = "mm")
    private int mm;
    @Basic(optional = false)
    @Column(name = "datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Id
    @Basic(optional = false)
    @Column(name = "tehozn")
    private String tehozn;

    public Pumpeuptime() {
    }

    public Pumpeuptime(String tehozn) {
        this.tehozn = tehozn;
    }

    public Pumpeuptime(String tehozn, int hh, int mm, Date datum) {
        this.tehozn = tehozn;
        this.hh = hh;
        this.mm = mm;
        this.datum = datum;
    }

    public int getHh() {
        return hh;
    }

    public void setHh(int hh) {
        this.hh = hh;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
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
        hash += (tehozn != null ? tehozn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pumpeuptime)) {
            return false;
        }
        Pumpeuptime other = (Pumpeuptime) object;
        if ((this.tehozn == null && other.tehozn != null) || (this.tehozn != null && !this.tehozn.equals(other.tehozn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Pumpeuptime[ tehozn=" + tehozn + " ]";
    }
    
}
