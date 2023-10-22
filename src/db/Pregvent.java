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
 * @author branko.scekic
 */
@Entity
@Table(name = "pregvent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregvent.findAll", query = "SELECT p FROM Pregvent p")
    , @NamedQuery(name = "Pregvent.findByTehozn", query = "SELECT p FROM Pregvent p WHERE p.tehozn = :tehozn")
    , @NamedQuery(name = "Pregvent.findByOpis", query = "SELECT p FROM Pregvent p WHERE p.opis = :opis")
    , @NamedQuery(name = "Pregvent.findByVirtualno", query = "SELECT p FROM Pregvent p WHERE p.virtualno = :virtualno")
    , @NamedQuery(name = "Pregvent.findByTitle", query = "SELECT p FROM Pregvent p WHERE p.title = :title")})
public class Pregvent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tehozn")
    private String tehozn;
    @Basic(optional = false)
    @Column(name = "opis")
    private String opis;
    @Basic(optional = false)
    @Column(name = "virtualno")
    private boolean virtualno;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;

    public Pregvent() {
    }

    public Pregvent(String tehozn) {
        this.tehozn = tehozn;
    }

    public Pregvent(String tehozn, String opis, boolean virtualno, String title) {
        this.tehozn = tehozn;
        this.opis = opis;
        this.virtualno = virtualno;
        this.title = title;
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

    public boolean getVirtualno() {
        return virtualno;
    }

    public void setVirtualno(boolean virtualno) {
        this.virtualno = virtualno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        if (!(object instanceof Pregvent)) {
            return false;
        }
        Pregvent other = (Pregvent) object;
        if ((this.tehozn == null && other.tehozn != null) || (this.tehozn != null && !this.tehozn.equals(other.tehozn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Pregvent[ tehozn=" + tehozn + " ]";
    }
    
}
