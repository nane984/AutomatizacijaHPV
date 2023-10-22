/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventilacija;

import constant.ConstReg;
import tools.MutantToDec;

/**
 *
 * @author branko.scekic
 */
public class Vent {
    private final int adresaKomanda;
    private final int adresaPozicija1;
    private final int adresaPozicija2;
    private boolean pozicija1;
    private boolean pozicija2;
    
    public Vent(String adresaKomanda, String adresaPozicija1, String adresaPozicija2){
        this.adresaKomanda = MutantToDec.getValue(adresaKomanda) + ConstReg.StartMX;
        this.adresaPozicija1 =  MutantToDec.getValue(adresaPozicija1) + ConstReg.StartDigitalInput;
        this.adresaPozicija2 = MutantToDec.getValue(adresaPozicija2) + ConstReg.StartDigitalInput;
    }

    public int getAdresaKomanda() {
        return adresaKomanda;
    }

    public int getAdresaPozicija1() {
        return adresaPozicija1;
    }

    public int getAdresaPozicija2() {
        return adresaPozicija2;
    }

    public boolean getPozicija1() {
        return pozicija1;
    }

    public void setPozicija1(boolean pozicija1) {
        this.pozicija1 = pozicija1;
    }

    public boolean getPozicija2() {
        return pozicija2;
    }

    public void setPozicija2(boolean pozicija2) {
        this.pozicija2 = pozicija2;
    }
    
}
