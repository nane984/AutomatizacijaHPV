/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valve.globe;

import constant.ConstReg;


/**
 *
 * @author branko.scekic
 */
public class PregradniVentili{
    //private final int id;  kad budem radio sa bazom
    private final String tehnoloskaOznaka;
    private final int pcOtvori;
    private final int pcZatvori;
    private final int otvoren;
    private final int zatvoren;
    private final int enableOtvori;
    private final int enableZatvori;
    private final String Opis;
    private final Extend vrednostiReg;
    
    /**
     *@param tehnoloskaOznaka 
     * @param pcOtvori 
     * @param pcZatvori
     * @param otvoren
     * @param enableOtvori
     * @param enableZatvori
     * @param zatvoren
     * @param opis
    */
    public PregradniVentili(String tehnoloskaOznaka, int pcOtvori, int pcZatvori,
             int enableOtvori, int enableZatvori, int otvoren ,int zatvoren, String opis)
    {   
        this.tehnoloskaOznaka=tehnoloskaOznaka;
        this.pcOtvori=pcOtvori + ConstReg.StartMX;
        this.pcZatvori=pcZatvori + ConstReg.StartMX;   
        this.enableOtvori=enableOtvori + ConstReg.StartMX;
        this.enableZatvori=enableZatvori + ConstReg.StartMX;
        this.otvoren=otvoren + ConstReg.StartMX;
        this.zatvoren=zatvoren + ConstReg.StartMX;
        this.Opis=opis;
        vrednostiReg = new Extend();
    }

    public String getTehnoloskaOznaka() {
        return tehnoloskaOznaka;
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
    
    public String getOpis() {
        return Opis;
    }

    public Extend getVrednostiReg() {
        return vrednostiReg;
    }
}
