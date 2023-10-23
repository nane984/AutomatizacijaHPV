/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.merenja;

import constant.ConstReg;

/**
 *
 * @author branko.scekic
 */
public class Protok {
    private final Merenja protok;
    private final int kumulativnoNizi;
    private final int kumulativnoVisi;
    private int kumulativnoNiziVrednost;
    private int kumulativnoVisiVrednost;
    private double kumulativnoRucno;
    
    private int brCiklusaDo1Sec = 1;
    private int vreme = 1;
    
    private boolean promena = false; 

    public Protok(int protok, int protokmin, int protokmax, int brDecq,  
                  int kumulativnoNizi, int kumulativnoVisi){
        
        this.protok = new Merenja(protok, protokmin, protokmax, brDecq);
        this.kumulativnoNizi = kumulativnoNizi + ConstReg.StartRegistri;
        this.kumulativnoVisi = kumulativnoVisi + ConstReg.StartRegistri;
    }
    
    
    public double izracunajKumuativnoRucno(int trenutno){
        double result = 0;
        if(trenutno > 0 && vreme > brCiklusaDo1Sec-1){
            result = Double.valueOf(trenutno)/3600;
            vreme = 0;
            promena = true;
        }
        vreme++;
        kumulativnoRucno += result;
        return kumulativnoRucno;
    }
    
    public Merenja getProtok() {
        return protok;
    }

    public int getKumulativnoNizi() {
        return kumulativnoNizi;
    }

    public int getKumulativnoVisi() {
        return kumulativnoVisi;
    }

    public int getKumulativnoNiziVrednost() {
        return kumulativnoNiziVrednost;
    }

    public void setKumulativnoNiziVrednost(int kumulativnoNiziVrednost) {
        this.kumulativnoNiziVrednost = kumulativnoNiziVrednost;
    }

    public int getKumulativnoVisiVrednost() {
        return kumulativnoVisiVrednost;
    }

    public void setKumulativnoVisiVrednost(int kumulativnoVisiVrednost) {
        this.kumulativnoVisiVrednost = kumulativnoVisiVrednost;
    }

    public double getKumulativnoRucno() {
        return kumulativnoRucno;
    }

    public void setKumulativnoRucno(double kumulativnoRucno) {
        this.kumulativnoRucno = kumulativnoRucno;
    }


    public void setBrCiklusaDo1Sec(int brCiklusaDo1Sec) {
        this.brCiklusaDo1Sec = brCiklusaDo1Sec;
    }

    public boolean isPromena() {
        return promena;
    }

    public void setPromena(boolean promena) {
        this.promena = promena;
    }
    
    

}
