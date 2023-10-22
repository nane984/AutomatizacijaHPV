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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    , @NamedQuery(name = "Kumulativno.findById", query = "SELECT k FROM Kumulativno k WHERE k.id = :id")
    , @NamedQuery(name = "Kumulativno.findByTehozn", query = "SELECT k FROM Kumulativno k WHERE k.tehozn = :tehozn")
    , @NamedQuery(name = "Kumulativno.findByVrednost", query = "SELECT k FROM Kumulativno k WHERE k.vrednost = :vrednost")})
public class Kumulativno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "tehozn")
    private String tehozn;
    @Basic(optional = false)
    @Column(name = "vrednost")
    private double vrednost;

    public Kumulativno() {
    }

    public Kumulativno(Long id) {
        this.id = id;
    }

    public Kumulativno(Long id, String tehozn, double vrednost) {
        this.id = id;
        this.tehozn = tehozn;
        this.vrednost = vrednost;
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

    public double getVrednost() {
        return vrednost;
    }

    public void setVrednost(double vrednost) {
        this.vrednost = vrednost;
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
        if (!(object instanceof Kumulativno)) {
            return false;
        }
        Kumulativno other = (Kumulativno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Kumulativno[ id=" + id + " ]";
    }
    
}
