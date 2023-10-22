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
@Table(name = "merenjenivoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Merenjenivoa.findAll", query = "SELECT m FROM Merenjenivoa m")
    , @NamedQuery(name = "Merenjenivoa.findById", query = "SELECT m FROM Merenjenivoa m WHERE m.id = :id")
    , @NamedQuery(name = "Merenjenivoa.findByLuzinarezervoar1", query = "SELECT m FROM Merenjenivoa m WHERE m.luzinarezervoar1 = :luzinarezervoar1")
    , @NamedQuery(name = "Merenjenivoa.findByLuzinarezervoar2", query = "SELECT m FROM Merenjenivoa m WHERE m.luzinarezervoar2 = :luzinarezervoar2")
    , @NamedQuery(name = "Merenjenivoa.findByDemivodarezervoar1", query = "SELECT m FROM Merenjenivoa m WHERE m.demivodarezervoar1 = :demivodarezervoar1")
    , @NamedQuery(name = "Merenjenivoa.findByDemivodarezervoar2", query = "SELECT m FROM Merenjenivoa m WHERE m.demivodarezervoar2 = :demivodarezervoar2")
    , @NamedQuery(name = "Merenjenivoa.findByKompenzacionirezervoar", query = "SELECT m FROM Merenjenivoa m WHERE m.kompenzacionirezervoar = :kompenzacionirezervoar")
    , @NamedQuery(name = "Merenjenivoa.findByNeutralizacionibazen", query = "SELECT m FROM Merenjenivoa m WHERE m.neutralizacionibazen = :neutralizacionibazen")
    , @NamedQuery(name = "Merenjenivoa.findByDemivodarezervoar150", query = "SELECT m FROM Merenjenivoa m WHERE m.demivodarezervoar150 = :demivodarezervoar150")
    , @NamedQuery(name = "Merenjenivoa.findByDekanefiltriranavoda", query = "SELECT m FROM Merenjenivoa m WHERE m.dekanefiltriranavoda = :dekanefiltriranavoda")
    , @NamedQuery(name = "Merenjenivoa.findByDekafiltriranavoda", query = "SELECT m FROM Merenjenivoa m WHERE m.dekafiltriranavoda = :dekafiltriranavoda")
    , @NamedQuery(name = "Merenjenivoa.findByOdpranjapf", query = "SELECT m FROM Merenjenivoa m WHERE m.odpranjapf = :odpranjapf")
    , @NamedQuery(name = "Merenjenivoa.findByRezervoarfecl", query = "SELECT m FROM Merenjenivoa m WHERE m.rezervoarfecl = :rezervoarfecl")
    , @NamedQuery(name = "Merenjenivoa.findByDatum", query = "SELECT m FROM Merenjenivoa m WHERE m.datum = :datum")})
public class Merenjenivoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "luzinarezervoar1")
    private int luzinarezervoar1;
    @Basic(optional = false)
    @Column(name = "luzinarezervoar2")
    private int luzinarezervoar2;
    @Basic(optional = false)
    @Column(name = "demivodarezervoar1")
    private int demivodarezervoar1;
    @Basic(optional = false)
    @Column(name = "demivodarezervoar2")
    private int demivodarezervoar2;
    @Basic(optional = false)
    @Column(name = "kompenzacionirezervoar")
    private int kompenzacionirezervoar;
    @Basic(optional = false)
    @Column(name = "neutralizacionibazen")
    private int neutralizacionibazen;
    @Basic(optional = false)
    @Column(name = "demivodarezervoar150")
    private int demivodarezervoar150;
    @Basic(optional = false)
    @Column(name = "dekanefiltriranavoda")
    private int dekanefiltriranavoda;
    @Basic(optional = false)
    @Column(name = "dekafiltriranavoda")
    private int dekafiltriranavoda;
    @Basic(optional = false)
    @Column(name = "odpranjapf")
    private int odpranjapf;
    @Basic(optional = false)
    @Column(name = "rezervoarfecl")
    private int rezervoarfecl;
    @Basic(optional = false)
    @Column(name = "datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;

    public Merenjenivoa() {
    }

    public Merenjenivoa(Long id) {
        this.id = id;
    }

    public Merenjenivoa(Long id, int luzinarezervoar1, int luzinarezervoar2, int demivodarezervoar1, int demivodarezervoar2, int kompenzacionirezervoar, int neutralizacionibazen, int demivodarezervoar150, int dekanefiltriranavoda, int dekafiltriranavoda, int odpranjapf, int rezervoarfecl, Date datum) {
        this.id = id;
        this.luzinarezervoar1 = luzinarezervoar1;
        this.luzinarezervoar2 = luzinarezervoar2;
        this.demivodarezervoar1 = demivodarezervoar1;
        this.demivodarezervoar2 = demivodarezervoar2;
        this.kompenzacionirezervoar = kompenzacionirezervoar;
        this.neutralizacionibazen = neutralizacionibazen;
        this.demivodarezervoar150 = demivodarezervoar150;
        this.dekanefiltriranavoda = dekanefiltriranavoda;
        this.dekafiltriranavoda = dekafiltriranavoda;
        this.odpranjapf = odpranjapf;
        this.rezervoarfecl = rezervoarfecl;
        this.datum = datum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLuzinarezervoar1() {
        return luzinarezervoar1;
    }

    public void setLuzinarezervoar1(int luzinarezervoar1) {
        this.luzinarezervoar1 = luzinarezervoar1;
    }

    public int getLuzinarezervoar2() {
        return luzinarezervoar2;
    }

    public void setLuzinarezervoar2(int luzinarezervoar2) {
        this.luzinarezervoar2 = luzinarezervoar2;
    }

    public int getDemivodarezervoar1() {
        return demivodarezervoar1;
    }

    public void setDemivodarezervoar1(int demivodarezervoar1) {
        this.demivodarezervoar1 = demivodarezervoar1;
    }

    public int getDemivodarezervoar2() {
        return demivodarezervoar2;
    }

    public void setDemivodarezervoar2(int demivodarezervoar2) {
        this.demivodarezervoar2 = demivodarezervoar2;
    }

    public int getKompenzacionirezervoar() {
        return kompenzacionirezervoar;
    }

    public void setKompenzacionirezervoar(int kompenzacionirezervoar) {
        this.kompenzacionirezervoar = kompenzacionirezervoar;
    }

    public int getNeutralizacionibazen() {
        return neutralizacionibazen;
    }

    public void setNeutralizacionibazen(int neutralizacionibazen) {
        this.neutralizacionibazen = neutralizacionibazen;
    }

    public int getDemivodarezervoar150() {
        return demivodarezervoar150;
    }

    public void setDemivodarezervoar150(int demivodarezervoar150) {
        this.demivodarezervoar150 = demivodarezervoar150;
    }

    public int getDekanefiltriranavoda() {
        return dekanefiltriranavoda;
    }

    public void setDekanefiltriranavoda(int dekanefiltriranavoda) {
        this.dekanefiltriranavoda = dekanefiltriranavoda;
    }

    public int getDekafiltriranavoda() {
        return dekafiltriranavoda;
    }

    public void setDekafiltriranavoda(int dekafiltriranavoda) {
        this.dekafiltriranavoda = dekafiltriranavoda;
    }

    public int getOdpranjapf() {
        return odpranjapf;
    }

    public void setOdpranjapf(int odpranjapf) {
        this.odpranjapf = odpranjapf;
    }

    public int getRezervoarfecl() {
        return rezervoarfecl;
    }

    public void setRezervoarfecl(int rezervoarfecl) {
        this.rezervoarfecl = rezervoarfecl;
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
        if (!(object instanceof Merenjenivoa)) {
            return false;
        }
        Merenjenivoa other = (Merenjenivoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Merenjenivoa[ id=" + id + " ]";
    }
    
}
