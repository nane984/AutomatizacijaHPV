/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual.doziranje;

/**
 *
 * @author branko.scekic
 */
public class Extend {

    private boolean automatskoDoziranje = false;
    private boolean izabraniReaktorVrednost = false;
    private boolean izabraniSilosKrecaVrednost = false;
    private int izabranaPumpaFCLVrednost = 0;
    private int rezervnaPumpaFCLVrednost = 0;
    private int izabranaPumpaPEVrednost = 0;
    private int rezervnaPumpaPEVrednost = 0;
    private int produvavanjeRad = 0;
    private int produvavanjePauza = 0;
    private boolean napajanjeFeClPumbaBr1 = false;
    private boolean napajanjeFeClPumbaBr2 = false;
    private boolean napajanjeFeClPumbaBr3 = false;
    private boolean napajanjePEPumpe = false;
    private boolean silos1EMV = false;
    private boolean krecSilos1Rastresac = false;
    private boolean krecSilos1Mesalica = false;
    private boolean silos2EMV = false;
    private boolean krecSilos2Rastresac = false;
    private boolean krecSilos2Mesalica = false;
    private boolean suviKrecniDozatorBr1 = false;
    private boolean suviKrecniDozatorBr2 = false;
  

    public boolean getAutomatskoDoziranje() {
        return automatskoDoziranje;
    }

    public void setAutomatskoDoziranje(boolean automatskoDoziranje) {
        this.automatskoDoziranje = automatskoDoziranje;
    }

    public boolean getIzabraniReaktorVrednost() {
        return izabraniReaktorVrednost;
    }

    public void setIzabraniReaktorVrednost(boolean izabraniReaktorVrednost) {
        this.izabraniReaktorVrednost = izabraniReaktorVrednost;
    }

    public boolean getIzabraniSilosKrecaVrednost() {
        return izabraniSilosKrecaVrednost;
    }

    public void setIzabraniSilosKrecaVrednost(boolean izabraniSilosKrecaVrednost) {
        this.izabraniSilosKrecaVrednost = izabraniSilosKrecaVrednost;
    }

    public int getIzabranaPumpaFCLVrednost() {
        return izabranaPumpaFCLVrednost;
    }

    public void setIzabranaPumpaFCLVrednost(int izabranaPumpaFCLVrednost) {
        this.izabranaPumpaFCLVrednost = izabranaPumpaFCLVrednost;
    }

    public int getRezervnaPumpaFCLVrednost() {
        return rezervnaPumpaFCLVrednost;
    }

    public void setRezervnaPumpaFCLVrednost(int rezervnaPumpaFCLVrednost) {
        this.rezervnaPumpaFCLVrednost = rezervnaPumpaFCLVrednost;
    }

    public int getIzabranaPumpaPEVrednost() {
        return izabranaPumpaPEVrednost;
    }

    public void setIzabranaPumpaPEVrednost(int izabranaPumpaPEVrednost) {
        this.izabranaPumpaPEVrednost = izabranaPumpaPEVrednost;
    }

    public int getRezervnaPumpaPEVrednost() {
        return rezervnaPumpaPEVrednost;
    }

    public void setRezervnaPumpaPEVrednost(int rezervnaPumpaPEVrednost) {
        this.rezervnaPumpaPEVrednost = rezervnaPumpaPEVrednost;
    }

    public int getProduvavanjeRad() {
        return produvavanjeRad;
    }

    public void setProduvavanjeRad(int produvavanjeRad) {
        this.produvavanjeRad = produvavanjeRad;
    }

    public int getProduvavanjePauza() {
        return produvavanjePauza;
    }

    public void setProduvavanjePauza(int produvavanjePauza) {
        this.produvavanjePauza = produvavanjePauza;
    }

    public boolean getSilos1EMV() {
        return silos1EMV;
    }

    public void setSilos1EMV(boolean silos1EMV) {
        this.silos1EMV = silos1EMV;
    }

    public boolean getNapajanjeFeClPumbaBr1() {
        return napajanjeFeClPumbaBr1;
    }

    public void setNapajanjeFeClPumbaBr1(boolean napajabjeFeClPumbaBr1) {
        this.napajanjeFeClPumbaBr1 = napajabjeFeClPumbaBr1;
    }

    public boolean getNapajanjeFeClPumbaBr2() {
        return napajanjeFeClPumbaBr2;
    }

    public void setNapajanjeFeClPumbaBr2(boolean napajabjeFeClPumbaBr2) {
        this.napajanjeFeClPumbaBr2 = napajabjeFeClPumbaBr2;
    }

    public boolean getNapajanjeFeClPumbaBr3() {
        return napajanjeFeClPumbaBr3;
    }

    public void setNapajanjeFeClPumbaBr3(boolean napajabjeFeClPumbaBr3) {
        this.napajanjeFeClPumbaBr3 = napajabjeFeClPumbaBr3;
    }

    public boolean getKrecSilos1Rastresac() {
        return krecSilos1Rastresac;
    }

    public void setKrecSilos1Rastresac(boolean krecSilos1Rastresac) {
        this.krecSilos1Rastresac = krecSilos1Rastresac;
    }

    public boolean getKrecSilos1Mesalica() {
        return krecSilos1Mesalica;
    }

    public void setKrecSilos1Mesalica(boolean krecSilos1Mesalica) {
        this.krecSilos1Mesalica = krecSilos1Mesalica;
    }

    public boolean getSilos2EMV() {
        return silos2EMV;
    }

    public void setSilos2EMV(boolean silos2EMV) {
        this.silos2EMV = silos2EMV;
    }

    public boolean getKrecSilos2Rastresac() {
        return krecSilos2Rastresac;
    }

    public void setKrecSilos2Rastresac(boolean krecSilos2Rastresac) {
        this.krecSilos2Rastresac = krecSilos2Rastresac;
    }

    public boolean getKrecSilos2Mesalica() {
        return krecSilos2Mesalica;
    }

    public void setKrecSilos2Mesalica(boolean krecSilos2Mesalica) {
        this.krecSilos2Mesalica = krecSilos2Mesalica;
    }

    public boolean getNapajanjePEPumpe() {
        return napajanjePEPumpe;
    }

    public void setNapajanjePEPumpe(boolean napajanjePEPumpe) {
        this.napajanjePEPumpe = napajanjePEPumpe;
    }

    public boolean getSuviKrecniDozatorBr1() {
        return suviKrecniDozatorBr1;
    }

    public void setSuviKrecniDozatorBr1(boolean suviKrecniDozatorBr1) {
        this.suviKrecniDozatorBr1 = suviKrecniDozatorBr1;
    }

    public boolean getSuviKrecniDozatorBr2() {
        return suviKrecniDozatorBr2;
    }

    public void setSuviKrecniDozatorBr2(boolean suviKrecniDozatorBr2) {
        this.suviKrecniDozatorBr2 = suviKrecniDozatorBr2;
    }
    
    
}
