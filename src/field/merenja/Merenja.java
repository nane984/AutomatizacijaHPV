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
public class Merenja {
    private final int adresaRegistra;
    private int vrednostRegistra;
    private final int min;
    private final int max;
    private final int brDec;
    private int vrednostProradeZastite;
    private final int vrednostProradeZastiteAdresa;
    
    public Merenja(int adresaRegistra, int min, int max, int brDec){
        
        this.adresaRegistra = adresaRegistra + ConstReg.StartRegistri;
        this.min = min;
        this.max = max;
        this.brDec = brDec;
        this.vrednostRegistra = 0;
        this.vrednostProradeZastite = 0;
        this.vrednostProradeZastiteAdresa = 0;
    }
    
    public Merenja(int adresaRegistra, int min, int max, int brDec, 
        int vrednostProradeZastiteAdresa){
        
        this.adresaRegistra = adresaRegistra + ConstReg.StartRegistri;
        this.min = min;
        this.max = max;
        this.brDec = brDec;
        this.vrednostRegistra = 0;
        this.vrednostProradeZastite = 0;
        this.vrednostProradeZastiteAdresa = vrednostProradeZastiteAdresa + ConstReg.StartRegistri;
    }
    
    public int getVrednostRegistra() {
        return vrednostRegistra;
    }

    public void setVrednostRegistra(int vrednostRegistra) {
        this.vrednostRegistra = vrednostRegistra ;
    }

    public int getAdresaRegistra() {
        return adresaRegistra;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getBrDec() {
        return brDec;
    }

    public int getVrednostProradeZastite() {
        return vrednostProradeZastite;
    }

    public void setVrednostProradeZastite(int vrednostProradeZastite) {
        this.vrednostProradeZastite = vrednostProradeZastite;
    }

    public int getVrednostProradeZastiteAdresa() {
        return vrednostProradeZastiteAdresa;
    }
}
