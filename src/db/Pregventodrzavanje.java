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
@Table(name = "pregventodrzavanje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregventodrzavanje.findAll", query = "SELECT p FROM Pregventodrzavanje p")
    , @NamedQuery(name = "Pregventodrzavanje.findById", query = "SELECT p FROM Pregventodrzavanje p WHERE p.id = :id")
    , @NamedQuery(name = "Pregventodrzavanje.findByTehozn", query = "SELECT p FROM Pregventodrzavanje p WHERE p.tehozn = :tehozn ORDER BY p.datum DESC")
    , @NamedQuery(name = "Pregventodrzavanje.findByOpis", query = "SELECT p FROM Pregventodrzavanje p WHERE p.opis = :opis")
    , @NamedQuery(name = "Pregventodrzavanje.findByDatum", query = "SELECT p FROM Pregventodrzavanje p WHERE p.datum = :datum")})
public class Pregventodrzavanje implements Serializable {

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
    @Column(name = "opis")
    private String opis;
    @Basic(optional = false)
    @Column(name = "datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;

    public Pregventodrzavanje() {
    }

    public Pregventodrzavanje(Long id) {
        this.id = id;
    }

    public Pregventodrzavanje(Long id, String tehozn, String opis, Date datum) {
        this.id = id;
        this.tehozn = tehozn;
        this.opis = opis;
        this.datum = datum;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregventodrzavanje)) {
            return false;
        }
        Pregventodrzavanje other = (Pregventodrzavanje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Pregventodrzavanje[ id=" + id + " ]";
    }
    
}
