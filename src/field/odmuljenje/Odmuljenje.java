/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.odmuljenje;

import buff.Buff;
import constant.ConstReg;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import tools.MutantToDec;

/**
 *
 * @author branko.scekic
 */
public class Odmuljenje{
    //adresa odmuljenja 1814
    private final int adresaKomandaOdmuljenje;
    
    TimerTask taskOdmuljenjePoVremenu;

    private int brojImpulsaPreOdmuljenja;
    private int brojImpulsaIzmedjuDvaOdmuljenja;

    //private final Timer vremeIzmedjuDvaOdmuljenja;
    
    public Odmuljenje() {
        int adresa = MutantToDec.getValue("1814");
        this.adresaKomandaOdmuljenje = adresa + ConstReg.StartMX;
        //this.vremeIzmedjuDvaOdmuljenja = new Timer();
        
    }

    public void odmuljenje(RezimRadaEnum rr, Buff mod, int brojImpulsaTrenutno, Timer vreme) {
        switch (rr) {
            case rucni:
                rucniRezim(mod);
                break;
            case vremenski:
                vremenskiRezim(mod, vreme);
                break;
            case automatski:
                automatskiRezim(mod, brojImpulsaTrenutno);
                break;
            case lokalno:
                break;
        }
    }

    private void rucniRezim(Buff mod) {
       write(mod);
    }

    public void vremenskiRezim(Buff mod, Timer vreme) {
        

    }

    private void automatskiRezim(Buff mod, int brojImpulsaTrenutno) {
        //gleda m3 koliko je proslo
        if(brojImpulsaTrenutno - brojImpulsaPreOdmuljenja >= brojImpulsaIzmedjuDvaOdmuljenja){
            write(mod);
            brojImpulsaPreOdmuljenja = brojImpulsaTrenutno;
        }
    }

    public void startVremeIzmedjuDvaOdmuljenja() {
        //vremeIzmedjuDvaOdmuljenja.
    }

    private void write(Buff mod){
        mod.offset = adresaKomandaOdmuljenje;
        mod.mxValue = true;
        mod.writeDigital = true;
    }
    
    
    
    /*
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task performed on: " + new Date() + "n"
                        + "Thread's name: " + Thread.currentThread().getName());
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 1000L;
        long periodToStart = 0L;
        timer.schedule(task,periodToStart, delay);
    }
    */
}