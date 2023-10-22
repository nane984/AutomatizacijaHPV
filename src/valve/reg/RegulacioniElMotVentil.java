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
public class RegulacioniElMotVentil {

    private final String tehnoloskaOznaka;
    private final int polozajValue;
    private final int brDecimala;
    private final ExtendElMot vrednosti;
    private final String opis;
    
    
    private final int pcOtvori;
    private final int pcZatvori;
    private final int otvoren;
    private final int zatvoren;
    private final int enableOtvori;
    private final int enableZatvori;
    
    private final int vremePunogHodaVentilaAdresa;
    private int vremePunogHodaVentila = 0;
    
    public RegulacioniElMotVentil(String tehnoloskaOznaka, int polozajValue, int brDecimala, String opis,
            int pcOtvori, int pcZatvori, int otvoren, int zatvoren, int enableOtvori, int enableZatvori){
        
        this.tehnoloskaOznaka = tehnoloskaOznaka;
        this.polozajValue = polozajValue + ConstReg.StartRegistri;
        this.brDecimala = brDecimala;
        this.opis = opis;
        vrednosti = new ExtendElMot();  
        
        this.pcOtvori=pcOtvori + ConstReg.StartMX;
        this.pcZatvori=pcZatvori + ConstReg.StartMX;   
        this.enableOtvori=enableOtvori + ConstReg.StartMX;
        this.enableZatvori=enableZatvori + ConstReg.StartMX;
        this.otvoren=otvoren + ConstReg.StartMX;
        this.zatvoren=zatvoren + ConstReg.StartMX;
        this.vremePunogHodaVentilaAdresa=0;
    }
    
    public RegulacioniElMotVentil(String tehnoloskaOznaka, int analogValue, int brDecimala, String opis,
            int pcOtvori, int pcZatvori, int otvoren, int zatvoren, int enableOtvori, int enableZatvori,
            int vremePunogHodaVentilaAdresa){
        
        this.tehnoloskaOznaka = tehnoloskaOznaka;
        this.polozajValue = analogValue + ConstReg.StartRegistri;
        this.brDecimala = brDecimala;
        this.opis = opis;
        vrednosti = new ExtendElMot();  
        
        this.pcOtvori=pcOtvori + ConstReg.StartMX;
        this.pcZatvori=pcZatvori + ConstReg.StartMX;   
        this.enableOtvori=enableOtvori + ConstReg.StartMX;
        this.enableZatvori=enableZatvori + ConstReg.StartMX;
        this.otvoren=otvoren + ConstReg.StartMX;
        this.zatvoren=zatvoren + ConstReg.StartMX;
        
        this.vremePunogHodaVentilaAdresa = vremePunogHodaVentilaAdresa + ConstReg.StartRegistri;
    }
    

    public String getTehnoloskaOznaka() {
        return tehnoloskaOznaka;
    }

    public int getPolozajValue() {
        return polozajValue;
    }

    public int getBrDecimala() {
        return brDecimala;
    }

    public String getOpis() {
        return opis;
    }

    public ExtendElMot getVrednosti() {
        return vrednosti;
    }

    public int getPcOtvori() {
        return pcOtvori;
    }

    public int getPcZatvori() {
        return pcZatvori;
    }

    public int getOtvoren() {
        return otvoren;
    }

    public int getZatvoren() {
        return zatvoren;
    }

    public int getEnableOtvori() {
        return enableOtvori;
    }

    public int getEnableZatvori() {
        return enableZatvori;
    }
    
    public int getVremePunogHodaVentilaAdresa(){
        return vremePunogHodaVentilaAdresa;
    }

    public int getVremePunogHodaVentila() {
        return vremePunogHodaVentila;
    }

    public void setVremePunogHodaVentila(int vremePunogHodaVentila) {
        this.vremePunogHodaVentila = vremePunogHodaVentila;
    }
}