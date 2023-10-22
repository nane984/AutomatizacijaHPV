/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valve.globe;

import java.io.Serializable;

/**
 *
 * @author branko.scekic
 */
public class Extend{
    private boolean otvoriSaPC = false;
    private boolean zatvoriSaPC = false;
    private boolean enableOtvori = false;
    private boolean enableZatvori = false;
    private boolean otvoren = false;
    private boolean zatvoren = false;
    private boolean polozajVirtualno=true;

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

    public boolean isPolozajVirtualno() {
        return polozajVirtualno;
    }

    public void setPolozajVirtualno(boolean polozajVirtualno) {
        this.polozajVirtualno = polozajVirtualno;
    }
}
