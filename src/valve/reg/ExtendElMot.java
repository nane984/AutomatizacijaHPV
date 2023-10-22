/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valve.reg;

/**
 *
 * @author branko.scekic
 */
public class ExtendElMot {
    private int polozajVrednost;       //ide se na jednu decimalu
    private boolean otvoriSaPC = false;
    private boolean zatvoriSaPC = false;
    private boolean enableOtvori = false;
    private boolean enableZatvori = false;
    private boolean otvoren = false;
    private boolean zatvoren = false;

    public int getPolozajVrednost() {
        return polozajVrednost;
    }

    public void setPolozajVrednost(int analognaVrednost) {
        this.polozajVrednost = analognaVrednost;
    }

    public boolean getOtvoriSaPC() {
        return otvoriSaPC;
    }

    public void setOtvoriSaPC(boolean otvoriSaPC) {
        this.otvoriSaPC = otvoriSaPC;
    }

    public boolean getZatvoriSaPC() {
        return zatvoriSaPC;
    }

    public void setZatvoriSaPC(boolean zatvoriSaPC) {
        this.zatvoriSaPC = zatvoriSaPC;
    }

    public boolean getEnableOtvori() {
        return enableOtvori;
    }

    public void setEnableOtvori(boolean enableOtvori) {
        this.enableOtvori = enableOtvori;
    }

    public boolean getEnableZatvori() {
        return enableZatvori;
    }

    public void setEnableZatvori(boolean enableZatvori) {
        this.enableZatvori = enableZatvori;
    }

    public boolean getOtvoren() {
        return otvoren;
    }

    public void setOtvoren(boolean otvoren) {
        this.otvoren = otvoren;
    }

    public boolean getZatvoren() {
        return zatvoren;
    }

    public void setZatvoren(boolean zatvoren) {
        this.zatvoren = zatvoren;
    }   
}