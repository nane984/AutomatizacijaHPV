/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elcM;

import constant.ConstReg;

/**
 *
 * @author branko.scekic
 */
public class ElcM {
    private final String tehnoloskaOznaka;
    private final int ukljucen;
    private final int pcUkljuci;
    private final int pcIskljuci;  
    private final int enableUkljuci;
    private final int enableIskljuci;
    private final int lokalno;
    private final int daljinski;
    private final String Opis;
    private final Extended vrednosti;
    
  
    
    public ElcM(String tehOznaka,int lokalno, int daljinski, int  ukljucen, int pcUkljuci, int pcIskljuci, int enableOn, int enableOff, String opis){
        this.tehnoloskaOznaka = tehOznaka;
        this.lokalno = lokalno + ConstReg.StartDigitalInput;
        this.daljinski = daljinski + ConstReg.StartDigitalInput;
        this.ukljucen = ukljucen + ConstReg.StartDigitalInput;
        this.pcUkljuci = pcUkljuci + ConstReg.StartMX;
        this.pcIskljuci = pcIskljuci + ConstReg.StartMX;
        this.enableUkljuci = enableOn + ConstReg.StartMX;
        this.enableIskljuci = enableOff + ConstReg.StartMX;
        this.Opis = opis;
        this.vrednosti = new Extended();
        
    }

    public String getTehnoloskaOznaka() {
        return tehnoloskaOznaka;
    }

    public int getUkljucen() {
        return ukljucen;
    }

    public int getPcUkljuci() {
        return pcUkljuci;
    }

    public int getPcIskljuci() {
        return pcIskljuci;
    }

    public int getEnableUkljuci() {
        return enableUkljuci;
    }

    public int getEnableIskljuci() {
        return enableIskljuci;
    }

    public int getLokalno() {
        return lokalno;
    }

    public int getDaljinski() {
        return daljinski;
    }

    public String getOpis() {
        return Opis;
    }

    public Extended getVrednosti() {
        return vrednosti;
    }
}
