/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valve.reg;

import constant.ConstReg;

/**
 *
 * @author branko.scekic
 */
public class RegulacioniVentili {
    private final String tehnoloskaOznaka;
    private final int analogValue;
    private final int analogStep;
    private final int brDecimala;
    private final String opis;
    private final Extend vrednosti;
    
    public RegulacioniVentili(String tehnoloskaOznaka, int analogValue, int analogStep,int brDecimala, String opis){
        this.tehnoloskaOznaka = tehnoloskaOznaka;
        this.analogValue = analogValue + ConstReg.StartRegistri;     
        this.analogStep = analogStep + ConstReg.StartRegistri;
        this.brDecimala = brDecimala;
        this.opis = opis;
        vrednosti = new Extend();       
    }

    public String getTehnoloskaOznaka() {
        return tehnoloskaOznaka;
    }

    public Extend getVrednosti() {
        return vrednosti;
    }
    
    public int getBrDecimala(){
        return brDecimala;
    }

    public int getAnalogValue() {
        return analogValue;
    }

    public int getAnalogStep() {
        return analogStep;
    }

    public String getOpis() {
        return opis;
    }
    
}
