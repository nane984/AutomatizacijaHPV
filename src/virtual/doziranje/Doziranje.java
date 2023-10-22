/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual.doziranje;

import constant.ConstReg;
import tools.MutantToDec;

/**
 *
 * @author branko.scekic
 */
public class Doziranje {
    private final int automatskoDoziranje;
    private final int izabraniReaktor;
    private final int izabraniSilosKreca;
    private final int izabranaPumpaFCL;
    private final int rezervnaPumpaFCL;
    private final int izabranaPumpaPE;
    private final int rezervnaPumpaPE;
    private final int produvavanjeRad;
    private final int produvavanjePauza;
    private final int napajanjeFeClPumbaBr1;
    private final int napajanjeFeClPumbaBr2;
    private final int napajanjeFeClPumbaBr3;
    private final int napajanjePEPumpe;
    private final int silos1EMV;
    private final int krecSilos1Rastresac;
    private final int krecSilos1Mesalica;
    private final int silos2EMV;
    private final int krecSilos2Rastresac;
    private final int krecSilos2Mesalica;
    private final int suviKrecniDozatorBr1;
    private final int suviKrecniDozatorBr2;
    
    
    
   
    
    private final Extend vrednostRegistra;
    
    public Doziranje(){
        this.automatskoDoziranje = MutantToDec.getValue("2406") + ConstReg.StartMX;
        this.izabraniReaktor = MutantToDec.getValue("2400") + ConstReg.StartMX;
        this.izabraniSilosKreca = MutantToDec.getValue("2403") + ConstReg.StartMX;;  
        this.izabranaPumpaFCL = 349 + ConstReg.StartRegistri;
        this.rezervnaPumpaFCL = 350 + ConstReg.StartRegistri;
        this.izabranaPumpaPE = 351 + ConstReg.StartRegistri;
        this.rezervnaPumpaPE = 352 + ConstReg.StartRegistri;
        this.produvavanjeRad = 380 + ConstReg.StartRegistri;
        this.produvavanjePauza = 381 + ConstReg.StartRegistri;
        this.napajanjeFeClPumbaBr1 = MutantToDec.getValue("81F") + ConstReg.StartDigitalInput;
        this.napajanjeFeClPumbaBr2 = MutantToDec.getValue("820") + ConstReg.StartDigitalInput;
        this.napajanjeFeClPumbaBr3 = MutantToDec.getValue("846") + ConstReg.StartDigitalInput;
        this.napajanjePEPumpe = MutantToDec.getValue("81B") + ConstReg.StartDigitalInput;
        this.silos1EMV = MutantToDec.getValue("850") + ConstReg.StartDigitalInput;
        this.krecSilos1Rastresac = MutantToDec.getValue("851") + ConstReg.StartDigitalInput;
        this.krecSilos1Mesalica = MutantToDec.getValue("852") + ConstReg.StartDigitalInput;
        this.silos2EMV = MutantToDec.getValue("853") + ConstReg.StartDigitalInput;
        this.krecSilos2Rastresac = MutantToDec.getValue("854") + ConstReg.StartDigitalInput;
        this.krecSilos2Mesalica = MutantToDec.getValue("855") + ConstReg.StartDigitalInput;
        this.suviKrecniDozatorBr1 = MutantToDec.getValue("824") + ConstReg.StartDigitalInput;
        this.suviKrecniDozatorBr2 = MutantToDec.getValue("825") + ConstReg.StartDigitalInput;
        
        this.vrednostRegistra = new Extend();
    }

    public Extend getVrednostRegistra() {
        return vrednostRegistra;
    }


    public int getAutomatskoDoziranje() {
        return automatskoDoziranje;
    }

    public int getIzabraniReaktor() {
        return izabraniReaktor;
    }

    public int getIzabranaPumpaFCL() {
        return izabranaPumpaFCL;
    }

    public int getRezervnaPumpaFCL() {
        return rezervnaPumpaFCL;
    }

    public int getIzabranaPumpaPE() {
        return izabranaPumpaPE;
    }

    public int getRezervnaPumpaPE() {
        return rezervnaPumpaPE;
    }

    public int getIzabraniSilosKreca() {
        return izabraniSilosKreca;
    }

    public int getProduvavanjeRad() {
        return produvavanjeRad;
    }

    public int getProduvavanjePauza() {
        return produvavanjePauza;
    }

    public int getSilos1EMV() {
        return silos1EMV;
    }

    public int getNapajanjeFeClPumbaBr1() {
        return napajanjeFeClPumbaBr1;
    }

    public int getNapajanjeFeClPumbaBr2() {
        return napajanjeFeClPumbaBr2;
    }

    public int getNapajanjeFeClPumbaBr3() {
        return napajanjeFeClPumbaBr3;
    }

    public int getKrecSilos1Rastresac() {
        return krecSilos1Rastresac;
    }

    public int getKrecSilos1Mesalica() {
        return krecSilos1Mesalica;
    }

    public int getSilos2EMV() {
        return silos2EMV;
    }

    public int getKrecSilos2Rastresac() {
        return krecSilos2Rastresac;
    }

    public int getKrecSilos2Mesalica() {
        return krecSilos2Mesalica;
    }

    public int getNapajanjePEPumpe() {
        return napajanjePEPumpe;
    }

    public int getSuviKrecniDozatorBr1() {
        return suviKrecniDozatorBr1;
    }

    public int getSuviKrecniDozatorBr2() {
        return suviKrecniDozatorBr2;
    }
    
    
}
