/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicijalizacija.pumpeUpTime;

import dbService.PumpeUpTimeService;
import elcM.ElcM;
import elcM.FrElcM;
import field.pumpe.PumpeDekaFiltrKaDemi;
import field.pumpe.PumpeDekaFiltriraneKaNeutralnojIzmeni;
import field.pumpe.PumpeFerihlorid;
import field.pumpe.PumpeKaPescanimFilterima;
import field.pumpe.PumpeNeutralizacionogBazena;
import field.pumpe.PumpeOdpadnihVodaOdPranjaPescanihFiltera;
import field.pumpe.PumpePolielektrolit;
import field.pumpe.PumpeZaPranjePescanihFiltera;

/**
 *
 * @author branko.scekic
 */
public class IncPumpeUpTime {

    private final PumpeDekaFiltrKaDemi pumpeDekaFiltriranaKaDemi;
    private final PumpeKaPescanimFilterima pumpeKaPescanimFilterima;
    private final PumpeDekaFiltriraneKaNeutralnojIzmeni pumpeDekaFiltriraneKaNeutralnojIzmeni;
    private final PumpeOdpadnihVodaOdPranjaPescanihFiltera pumpeOdpadnihVodaOdPranjaPescanihFiltera;
    private final PumpeFerihlorid pumpeFerihlorid;
    private final PumpePolielektrolit pumpePolielektrolit;
    private final PumpeZaPranjePescanihFiltera pumpeZaPranjePescanihFiltera;
    private final PumpeNeutralizacionogBazena pumpeNeutralizacionogBazena;

    private PumpeUpTimeService pumpeUpTimeService;
    private db.Pumpeuptime pumpaUpTime;

    public IncPumpeUpTime(
            PumpeDekaFiltrKaDemi pumpeDekaFiltriranaKaDemi,
            PumpeKaPescanimFilterima pumpeKaPescanimFilterima,
            PumpeDekaFiltriraneKaNeutralnojIzmeni pumpeDekaFiltriraneKaNeutralnojIzmeni,
            PumpeOdpadnihVodaOdPranjaPescanihFiltera pumpeOdpadnihVodaOdPranjaPescanihFiltera,
            PumpeFerihlorid pumpeFerihlorid,
            PumpePolielektrolit pumpePolielektrolit,
            PumpeZaPranjePescanihFiltera pumpeZaPranjePescanihFiltera,
            PumpeNeutralizacionogBazena pumpeNeutralizacionogBazena) {

        this.pumpeDekaFiltriranaKaDemi = pumpeDekaFiltriranaKaDemi;
        this.pumpeKaPescanimFilterima = pumpeKaPescanimFilterima;
        this.pumpeDekaFiltriraneKaNeutralnojIzmeni = pumpeDekaFiltriraneKaNeutralnojIzmeni;
        this.pumpeOdpadnihVodaOdPranjaPescanihFiltera = pumpeOdpadnihVodaOdPranjaPescanihFiltera;
        this.pumpeFerihlorid = pumpeFerihlorid;
        this.pumpePolielektrolit = pumpePolielektrolit;
        this.pumpeZaPranjePescanihFiltera = pumpeZaPranjePescanihFiltera;
        this.pumpeNeutralizacionogBazena = pumpeNeutralizacionogBazena;
    }

    public void inicPumpeVreme() {

        pumpeUpTimeService = new PumpeUpTimeService();

        pumpeDekaFiltriraneKaDemi();
        pumpeKaPescanimFilterima();
        pumpeDekaFiltriraneKaNeutralnojIzmeni();
        pumpeOdpadnihVodaOdPranjaPescanihFiltera();
        pumpeFerihlorid();
        pumpePolielektrolit();
        pumpeZaPranjePescanihFiltera();
        pumpeNeutralizacionogBazena();

    }

    private void pumpeDekaFiltriraneKaDemi() {
        fillDatabase(pumpeDekaFiltriranaKaDemi.getPumpaBr1());
        fillDatabase(pumpeDekaFiltriranaKaDemi.getPumpaBr2());
        fillDatabase(pumpeDekaFiltriranaKaDemi.getPumpaBr3());
        fillDatabase(pumpeDekaFiltriranaKaDemi.getPumpaBr4());
        fillDatabase(pumpeDekaFiltriranaKaDemi.getPumpaBr5());
    }

    private void pumpeKaPescanimFilterima() {
        fillDatabase(pumpeKaPescanimFilterima.getPumpaBr1());
        fillDatabase(pumpeKaPescanimFilterima.getPumpaBr2());
        fillDatabase(pumpeKaPescanimFilterima.getPumpaBr3());
        fillDatabase(pumpeKaPescanimFilterima.getPumpaBr4());
        fillDatabase(pumpeKaPescanimFilterima.getPumpaBr5());
    }

    private void pumpeDekaFiltriraneKaNeutralnojIzmeni() {
        fillDatabase(pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr1());
        fillDatabase(pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr2());
        fillDatabase(pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr3());
    }

    private void pumpeOdpadnihVodaOdPranjaPescanihFiltera() {
        fillDatabase(pumpeOdpadnihVodaOdPranjaPescanihFiltera.getPumpaBr1());
        fillDatabase(pumpeOdpadnihVodaOdPranjaPescanihFiltera.getPumpaBr2());
    }

    private void pumpeFerihlorid() {
        fillDatabase(pumpeFerihlorid.getPumpaBr1());
        fillDatabase(pumpeFerihlorid.getPumpaBr2());
        fillDatabase(pumpeFerihlorid.getPumpaBr3());
    }

    private void pumpePolielektrolit() {
        fillDatabase(pumpePolielektrolit.getPumpaBr1());
        fillDatabase(pumpePolielektrolit.getPumpaBr2());
        fillDatabase(pumpePolielektrolit.getPumpaBr3());
    }

    private void pumpeZaPranjePescanihFiltera() {
        fillDatabase(pumpeZaPranjePescanihFiltera.getPumpaBr1());
        fillDatabase(pumpeZaPranjePescanihFiltera.getPumpaBr2());
    }

    private void pumpeNeutralizacionogBazena() {
        fillDatabase(pumpeNeutralizacionogBazena.getPumpaBr1());
        fillDatabase(pumpeNeutralizacionogBazena.getPumpaBr2());
    }

    private void fillDatabase(ElcM pumpa) {
        pumpaUpTime = pumpeUpTimeService.getPumpaRadniSati(pumpa.getTehnoloskaOznaka());
        if (pumpaUpTime.getTehozn() == null) {
            pumpeUpTimeService.addPumpaRadniSati(pumpa.getTehnoloskaOznaka(), 0, 0);
        } 
    }

    private void fillDatabase(FrElcM pumpa) {
        pumpaUpTime = pumpeUpTimeService.getPumpaRadniSati(pumpa.getTehnoloskaOznaka());
        if (pumpaUpTime.getTehozn() == null) {
            pumpeUpTimeService.addPumpaRadniSati(pumpa.getTehnoloskaOznaka(), 0, 0);
            pumpa.getTimeWork().setHours(0);
            pumpa.getTimeWork().setMinutes(0);
        } else {
            pumpa.getTimeWork().setHours(pumpaUpTime.getHh());
            pumpa.getTimeWork().setMinutes(pumpaUpTime.getMm());
        }
        if (pumpa.getVrednosti().isRun()) {
            pumpa.getTimeWork().start();
        }
    }

}
