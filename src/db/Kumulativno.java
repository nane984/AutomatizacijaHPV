/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Branko
 */
@Entity
@Table(name = "kumulativno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kumulativno.findAll", query = "SELECT k FROM Kumulativno k")
    , @NamedQuery(name = "Kumulativno.findByTehozn", query = "SELECT k FROM Kumulativno k WHERE k.tehozn = :tehozn")
    , @NamedQuery(name = "Kumulativno.findByVrednost", query = "SELECT k FROM Kumulativno k WHERE k.vrednost = :vrednost")})
public class Kumulativno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tehozn")
    private String tehozn;
    @Basic(optional = false)
    @Column(name = "vrednost")
    private double vrednost;

    public Kumulativno() {
    }

    public Kumulativno(String tehozn) {
        this.tehozn = tehozn;
    }

    public Kumulativno(String tehozn, double vrednost) {
        this.tehozn = tehozn;
        this.vrednost = vrednost;
    }

    public String getTehozn() {
        return tehozn;
    }

    public void setTehozn(String tehozn) {
        this.tehozn = tehozn;
    }

    public double getVrednost() {
        return vrednost;
    }

    public void setVrednost(double vrednost) {
        this.vrednost = vrednost;
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
        if (!(object instanceof Kumulativno)) {
            return false;
        }
        Kumulativno other = (Kumulativno) object;
        if ((this.tehozn == null && other.tehozn != null) || (this.tehozn != null && !this.tehozn.equals(other.tehozn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Kumulativno[ tehozn=" + tehozn + " ]";
    }
    
}
