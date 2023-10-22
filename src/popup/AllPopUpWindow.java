/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popup;

import constant.Img;
import dbService.PregVentService;
import dbService.PumpeUpTimeService;
import elcM.ElcM;
import elcM.FrElcM;
import field.merenja.Merenja;
import field.merenja.Protok;
import field.merenja.protoci.ProtociDemiLinije;
import field.merenja.protoci.ProtociFlokulacija;
import field.merenja.protoci.ProtociNeutralna;
import field.merenja.protoci.ProtociPescaniFilteri;
import field.merenja.protoci.ProtociRegeneracija;
import field.pumpe.PumpeDekaFiltrKaDemi;
import field.pumpe.PumpeDekaFiltriraneKaNeutralnojIzmeni;
import field.pumpe.PumpeFerihlorid;
import field.pumpe.PumpeKaPescanimFilterima;
import field.pumpe.PumpeNeutralizacionogBazena;
import field.pumpe.PumpeOdpadnihVodaOdPranjaPescanihFiltera;
import field.pumpe.PumpePolielektrolit;
import field.pumpe.PumpeZaPranjePescanihFiltera;
import field.ventili.DemiLinije;
import field.ventili.JonskaIzmena;
import field.ventili.PescaniFilteri;
import field.ventili.Reaktor;
import field.ventili.Regeneracija;
import field.ventili.VentiliFerihlorid;
import field.ventili.VentiliGrupaPumpi;
import field.ventili.VentiliKaPescanimFilterima;
import field.ventili.VentiliPolielektrolit;
import field.ventili.pescaniFilter.OtpadneVodeOdPescanihFiltera;
import field.ventili.pescaniFilter.PranjePescanihFiltera;
import java.awt.MouseInfo;
import java.awt.Point;
import static utilise.MousePoint.GetMousePoint;
import valve.globe.PregradniVentili;
import valve.reg.RegulacioniElMotVentil;
import valve.reg.RegulacioniVentili;
import virtual.doziranje.Doziranje;

/**
 *
 * @author branko.scekic
 */
public class AllPopUpWindow {

    public AllPopUpWindow(
            VentiliFerihlorid FeCl, VentiliPolielektrolit PE,
            VentiliGrupaPumpi ventiliGP01,
            VentiliKaPescanimFilterima ventiliKaPescanimFilterima,
            PumpeFerihlorid pumpeFerihlorid,
            PumpePolielektrolit pumpePolielektrolit,
            PumpeDekaFiltrKaDemi pumpeDekaFiltriranaKaDemi,
            PumpeKaPescanimFilterima pumpeKaPescanimFilterima,
            PumpeDekaFiltriraneKaNeutralnojIzmeni pumpeDekaFiltriraneKaNeutralnojIzmeni,
            PumpeOdpadnihVodaOdPranjaPescanihFiltera pumpeOdpadnihVodaOdPranjaPescanihFiltera,
            PumpeZaPranjePescanihFiltera pumpeZaPranjePescanihFiltera,
            PumpeNeutralizacionogBazena pumpeNeutralizacionogBazena,
            ProtociFlokulacija protociFlokulacija,
            ProtociPescaniFilteri protociPescaniFilteri,
            ProtociNeutralna protociNeutralna,
            ProtociDemiLinije protociDemiLinije,
            ProtociRegeneracija protociRegeneracija,
            PescaniFilteri pescaniFilteri,
            JonskaIzmena jonskaIzmena,
            OtpadneVodeOdPescanihFiltera otpadneVodeOdPescanihFiltera,
            PranjePescanihFiltera pranjePescanihFiltera,
            DemiLinije demiLinije,
            Doziranje doziranje,
            Reaktor reaktor,
            Regeneracija regeneracija,
            Img img,
            Merenja merenja,
            PregVentService pregVentService,
            PumpeUpTimeService pumpeUpTimeService){
        
        this.ventiliFerihlorid = FeCl;
        this.ventiliPolielektrolit = PE;
        this.ventiliGP01 = ventiliGP01;
        this.ventiliKaPescanimFilterima = ventiliKaPescanimFilterima;
        this.pumpeDekaFiltriranaKaDemi = pumpeDekaFiltriranaKaDemi;
        this.pumpeFerihlorid = pumpeFerihlorid;
        this.pumpePolielektrolit = pumpePolielektrolit;
        this.pumpeKaPescanimFilterima = pumpeKaPescanimFilterima;
        this.pumpeDekaFiltriraneKaNeutralnojIzmeni = pumpeDekaFiltriraneKaNeutralnojIzmeni;
        this.pumpeOdpadnihVodaOdPranjaPescanihFiltera = pumpeOdpadnihVodaOdPranjaPescanihFiltera;
        this.protociFlokulacija = protociFlokulacija;
        this.protociNeutralna = protociNeutralna;
        this.protociRegeneracija = protociRegeneracija;
        this.pumpeZaPranjePescanihFiltera = pumpeZaPranjePescanihFiltera;
        this.pumpeNeutralizacionogBazena = pumpeNeutralizacionogBazena;
        this.otpadneVodeOdPescanihFiltera = otpadneVodeOdPescanihFiltera;
        this.protociPescaniFilteri = protociPescaniFilteri;
        this.protociDemiLinije = protociDemiLinije;
        this.pescaniFilteri = pescaniFilteri;
        this.jonskaIzmena = jonskaIzmena;
        this.demiLinije = demiLinije;
        this.pranjePescanihFiltera = pranjePescanihFiltera;
        this.reaktor = reaktor;
        this.regeneracija = regeneracija;
        this.doziranje = doziranje;
        this.img = img;
        this.merenja = merenja;
        this.pregVentService = pregVentService;
        
        inicijalizacijaVentili();
    }

    
    private final Img img;
    private final Merenja merenja;
    private final VentiliFerihlorid ventiliFerihlorid;
    private final VentiliPolielektrolit ventiliPolielektrolit;
    private final VentiliGrupaPumpi ventiliGP01;
    private final VentiliKaPescanimFilterima ventiliKaPescanimFilterima;
    private final PregVentService pregVentService;

    private final PumpeFerihlorid pumpeFerihlorid;
    private final PumpePolielektrolit pumpePolielektrolit;
    private final PumpeDekaFiltrKaDemi pumpeDekaFiltriranaKaDemi;
    private final PumpeKaPescanimFilterima pumpeKaPescanimFilterima;
    private final PumpeDekaFiltriraneKaNeutralnojIzmeni pumpeDekaFiltriraneKaNeutralnojIzmeni;
    private final PumpeOdpadnihVodaOdPranjaPescanihFiltera pumpeOdpadnihVodaOdPranjaPescanihFiltera;
    private final PumpeZaPranjePescanihFiltera pumpeZaPranjePescanihFiltera;
    private final PumpeNeutralizacionogBazena pumpeNeutralizacionogBazena;

    private final OtpadneVodeOdPescanihFiltera otpadneVodeOdPescanihFiltera;
    private final Doziranje doziranje;
    private final Reaktor reaktor;
    private final Regeneracija regeneracija;
    private final DemiLinije demiLinije;
    private final PescaniFilteri pescaniFilteri;
    private final JonskaIzmena jonskaIzmena;
    private final PranjePescanihFiltera pranjePescanihFiltera;
    private final ProtociFlokulacija protociFlokulacija;
    private final ProtociPescaniFilteri protociPescaniFilteri;
    private final ProtociNeutralna protociNeutralna;
    private final ProtociDemiLinije protociDemiLinije;
    private final ProtociRegeneracija protociRegeneracija;

    private PregradniVentilScreen ProzorGP01kaNeutralnojJonskoj01 = null;
    private PregradniVentilScreen ProzorGP01kaNeutralnojJonskoj02 = null;
    private PregradniVentilScreen ProzorGP01kaNeutralnojJonskoj03 = null;
    
    private PregradniVentilScreen ProzorPKPFbr1 = null;
    private PregradniVentilScreen ProzorPKPFbr2 = null;
    private PregradniVentilScreen ProzorPKPFbr3 = null;
    private PregradniVentilScreen ProzorPKPFbr4 = null;
    private PregradniVentilScreen ProzorPKPFbr5 = null;
    private PregradniVentilScreen ProzorPKPFbr6 = null;

    private PregradniVentilScreen ProzorOtpadneVodeOdPescanihFiltera1 = null;
    private PregradniVentilScreen ProzorOtpadneVodeOdPescanihFiltera2 = null;

    private PregradniVentilScreen ProzorPranjePescanihFiltera1 = null;
    private PregradniVentilScreen ProzorPranjePescanihFiltera2 = null;

    private RegulacioniVentilElMotorImagPolozajScreen ProzorIzlazIzPescanihFiltera  = null;
    
    private RegulacioniVentilElMotorScreen ProzorR1SV = null;
    
    private RegulacioniVentilScreen ProzorPF201 = null;
    private PregradniVentilScreen ProzorPF203 = null;
    private PregradniVentilScreen ProzorPF204 = null;
    private PregradniVentilScreen ProzorPF205 = null;
    private PregradniVentilScreen ProzorPF206 = null;
    private PregradniVentilScreen ProzorPF207 = null;
    private PregradniVentilScreen ProzorPF208 = null;
    private PregradniVentilScreen ProzorPF209 = null;
    private PregradniVentilScreen ProzorPF210 = null;

    private RegulacioniVentilScreen ProzorPF401 = null;
    private PregradniVentilScreen ProzorPF403 = null;
    private PregradniVentilScreen ProzorPF404 = null;
    private PregradniVentilScreen ProzorPF405 = null;
    private PregradniVentilScreen ProzorPF406 = null;
    private PregradniVentilScreen ProzorPF407 = null;
    private PregradniVentilScreen ProzorPF408 = null;
    private PregradniVentilScreen ProzorPF409 = null;
    private PregradniVentilScreen ProzorPF410 = null;

    private RegulacioniVentilScreen ProzorPF501 = null;
    private PregradniVentilScreen ProzorPF503 = null;
    private PregradniVentilScreen ProzorPF504 = null;
    private PregradniVentilScreen ProzorPF505 = null;
    private PregradniVentilScreen ProzorPF506 = null;
    private PregradniVentilScreen ProzorPF507 = null;
    private PregradniVentilScreen ProzorPF508 = null;
    private PregradniVentilScreen ProzorPF509 = null;
    private PregradniVentilScreen ProzorPF510 = null;

    private RegulacioniVentilScreen ProzorPF601 = null;
    private PregradniVentilScreen ProzorPF603 = null;
    private PregradniVentilScreen ProzorPF604 = null;
    private PregradniVentilScreen ProzorPF605 = null;
    private PregradniVentilScreen ProzorPF606 = null;
    private PregradniVentilScreen ProzorPF607 = null;
    private PregradniVentilScreen ProzorPF608 = null;
    private PregradniVentilScreen ProzorPF609 = null;
    private PregradniVentilScreen ProzorPF610 = null;
    
    private RegulacioniVentilScreen ProzorDL01JKKF01 = null;
    private PregradniVentilScreen ProzorDL01JKKF03 = null;
    private PregradniVentilScreen ProzorDL01JKKF04 = null;
    private PregradniVentilScreen ProzorDL01JKKF05 = null;
    private PregradniVentilScreen ProzorDL01JKKF06 = null;
    private PregradniVentilScreen ProzorDL01JKKF07 = null;
    private PregradniVentilScreen ProzorDL01JKKF08 = null;
    private PregradniVentilScreen ProzorDL01JKKF09 = null;
    private PregradniVentilScreen ProzorDL01JKKF10 = null;
    private PregradniVentilScreen ProzorDL01JKKF11 = null;
    private PregradniVentilScreen ProzorDL01JKKF12 = null;

    private PregradniVentilScreen ProzorDL01SBA01 = null;
    private PregradniVentilScreen ProzorDL01SBA02 = null;
    private PregradniVentilScreen ProzorDL01SBA03 = null;
    private PregradniVentilScreen ProzorDL01SBA04 = null;
    private PregradniVentilScreen ProzorDL01SBA05 = null;
    private PregradniVentilScreen ProzorDL01SBA06 = null;

    private PregradniVentilScreen ProzorDL01JBA01 = null;
    private PregradniVentilScreen ProzorDL01JBA02 = null;
    private PregradniVentilScreen ProzorDL01JBA03 = null;
    private PregradniVentilScreen ProzorDL01JBA04 = null;
    private PregradniVentilScreen ProzorDL01JBA05 = null;
    private PregradniVentilScreen ProzorDL01JBA06 = null;
    private PregradniVentilScreen ProzorDL01JBA07 = null;
    private PregradniVentilScreen ProzorDL01JBA08 = null;

    private PregradniVentilScreen ProzorDL01MF01 = null;
    private PregradniVentilScreen ProzorDL01MF02 = null;
    private PregradniVentilScreen ProzorDL01MF03 = null;
    private PregradniVentilScreen ProzorDL01MF04 = null;
    private PregradniVentilScreen ProzorDL01MF05 = null;
    private PregradniVentilScreen ProzorDL01MF06 = null;
    private PregradniVentilScreen ProzorDL01MF07 = null;
    private PregradniVentilScreen ProzorDL01MF08 = null;
    private PregradniVentilScreen ProzorDL01MF10 = null;
    private PregradniVentilScreen ProzorDL01MF11 = null;

    private RegulacioniVentilScreen ProzorDL02JKKF01 = null;
    private PregradniVentilScreen ProzorDL02JKKF03 = null;
    private PregradniVentilScreen ProzorDL02JKKF04 = null;
    private PregradniVentilScreen ProzorDL02JKKF05 = null;
    private PregradniVentilScreen ProzorDL02JKKF06 = null;
    private PregradniVentilScreen ProzorDL02JKKF07 = null;
    private PregradniVentilScreen ProzorDL02JKKF08 = null;
    private PregradniVentilScreen ProzorDL02JKKF09 = null;
    private PregradniVentilScreen ProzorDL02JKKF10 = null;
    private PregradniVentilScreen ProzorDL02JKKF11 = null;
    private PregradniVentilScreen ProzorDL02JKKF12 = null;

    private PregradniVentilScreen ProzorDL02SBA01 = null;
    private PregradniVentilScreen ProzorDL02SBA02 = null;
    private PregradniVentilScreen ProzorDL02SBA03 = null;
    private PregradniVentilScreen ProzorDL02SBA04 = null;
    private PregradniVentilScreen ProzorDL02SBA05 = null;
    private PregradniVentilScreen ProzorDL02SBA06 = null;

    private PregradniVentilScreen ProzorDL02JBA01 = null;
    private PregradniVentilScreen ProzorDL02JBA02 = null;
    private PregradniVentilScreen ProzorDL02JBA03 = null;
    private PregradniVentilScreen ProzorDL02JBA04 = null;
    private PregradniVentilScreen ProzorDL02JBA05 = null;
    private PregradniVentilScreen ProzorDL02JBA06 = null;
    private PregradniVentilScreen ProzorDL02JBA07 = null;
    private PregradniVentilScreen ProzorDL02JBA08 = null;

    private PregradniVentilScreen ProzorDL02MF01 = null;
    private PregradniVentilScreen ProzorDL02MF02 = null;
    private PregradniVentilScreen ProzorDL02MF03 = null;
    private PregradniVentilScreen ProzorDL02MF04 = null;
    private PregradniVentilScreen ProzorDL02MF05 = null;
    private PregradniVentilScreen ProzorDL02MF06 = null;
    private PregradniVentilScreen ProzorDL02MF07 = null;
    private PregradniVentilScreen ProzorDL02MF08 = null;
    private PregradniVentilScreen ProzorDL02MF10 = null;
    private PregradniVentilScreen ProzorDL02MF11 = null;

    private RegulacioniVentilScreen ProzorDL03JKKF01 = null;
    private PregradniVentilScreen ProzorDL03JKKF03 = null;
    private PregradniVentilScreen ProzorDL03JKKF04 = null;
    private PregradniVentilScreen ProzorDL03JKKF05 = null;
    private PregradniVentilScreen ProzorDL03JKKF06 = null;
    private PregradniVentilScreen ProzorDL03JKKF07 = null;
    private PregradniVentilScreen ProzorDL03JKKF08 = null;
    private PregradniVentilScreen ProzorDL03JKKF09 = null;
    private PregradniVentilScreen ProzorDL03JKKF10 = null;
    private PregradniVentilScreen ProzorDL03JKKF11 = null;
    private PregradniVentilScreen ProzorDL03JKKF12 = null;

    private PregradniVentilScreen ProzorDL03SBA01 = null;
    private PregradniVentilScreen ProzorDL03SBA02 = null;
    private PregradniVentilScreen ProzorDL03SBA03 = null;
    private PregradniVentilScreen ProzorDL03SBA04 = null;
    private PregradniVentilScreen ProzorDL03SBA05 = null;
    private PregradniVentilScreen ProzorDL03SBA06 = null;

    private PregradniVentilScreen ProzorDL03JBA01 = null;
    private PregradniVentilScreen ProzorDL03JBA02 = null;
    private PregradniVentilScreen ProzorDL03JBA03 = null;
    private PregradniVentilScreen ProzorDL03JBA04 = null;
    private PregradniVentilScreen ProzorDL03JBA05 = null;
    private PregradniVentilScreen ProzorDL03JBA06 = null;
    private PregradniVentilScreen ProzorDL03JBA07 = null;
    private PregradniVentilScreen ProzorDL03JBA08 = null;

    private PregradniVentilScreen ProzorDL03MF01 = null;
    private PregradniVentilScreen ProzorDL03MF02 = null;
    private PregradniVentilScreen ProzorDL03MF03 = null;
    private PregradniVentilScreen ProzorDL03MF04 = null;
    private PregradniVentilScreen ProzorDL03MF05 = null;
    private PregradniVentilScreen ProzorDL03MF06 = null;
    private PregradniVentilScreen ProzorDL03MF07 = null;
    private PregradniVentilScreen ProzorDL03MF08 = null;
    private PregradniVentilScreen ProzorDL03MF10 = null;
    private PregradniVentilScreen ProzorDL03MF11 = null;

    private RegulacioniVentilScreen ProzorNJ101 = null;
    private PregradniVentilScreen ProzorNJ103 = null;
    private PregradniVentilScreen ProzorNJ104 = null;
    private PregradniVentilScreen ProzorNJ105 = null;
    private PregradniVentilScreen ProzorNJ106 = null;
    private PregradniVentilScreen ProzorNJ107 = null;
    private PregradniVentilScreen ProzorNJ108 = null;
    private PregradniVentilScreen ProzorNJ109 = null;
    private PregradniVentilScreen ProzorNJ110 = null;
    
    private RegulacioniVentilScreen ProzorNJ201 = null;
    private PregradniVentilScreen ProzorNJ203 = null;
    private PregradniVentilScreen ProzorNJ204 = null;
    private PregradniVentilScreen ProzorNJ205 = null;
    private PregradniVentilScreen ProzorNJ206 = null;
    private PregradniVentilScreen ProzorNJ207 = null;
    private PregradniVentilScreen ProzorNJ208 = null;
    private PregradniVentilScreen ProzorNJ209 = null;
    private PregradniVentilScreen ProzorNJ210 = null;

    private RegulacioniVentilScreen ProzorNJ301 = null;
    private PregradniVentilScreen ProzorNJ303 = null;
    private PregradniVentilScreen ProzorNJ304 = null;
    private PregradniVentilScreen ProzorNJ305 = null;
    private PregradniVentilScreen ProzorNJ306 = null;
    private PregradniVentilScreen ProzorNJ307 = null;
    private PregradniVentilScreen ProzorNJ308 = null;
    private PregradniVentilScreen ProzorNJ309 = null;
    private PregradniVentilScreen ProzorNJ310 = null;
    
    private PregradniVentilScreen ProzorPKDemiLinijamaBr1 = null;
    private PregradniVentilScreen ProzorPKDemiLinijamaBr2 = null;
    private PregradniVentilScreen ProzorPKDemiLinijamaBr3 = null;
    private PregradniVentilScreen ProzorPKDemiLinijamaBr4 = null;
    private PregradniVentilScreen ProzorPKDemiLinijamaBr5 = null;
    
    private PregradniVentilScreen ProzorPEPosuda1 = null;
    private PregradniVentilScreen ProzorPEPosuda2 = null;
    private PregradniVentilScreen ProzorPEVentil1 = null;
    private PregradniVentilScreen ProzorPEVentil2 = null;
    private PregradniVentilScreen ProzorPEVentil3 = null;
    private PregradniVentilScreen ProzorPEKompenzaciona1 = null;
    private PregradniVentilScreen ProzorPEKompenzaciona2 = null;
    private PregradniVentilScreen ProzorPEZaRazblazivanje1 = null;
    private PregradniVentilScreen ProzorPEZaRazblazivanje2 = null;
    
    private PregradniVentilScreen ProzorFeClPosuda1 = null;
    private PregradniVentilScreen ProzorFeClPosuda2 = null;
    private PregradniVentilScreen ProzorFeClVentil1 = null;
    private PregradniVentilScreen ProzorFeClVentil2 = null;
    private PregradniVentilScreen ProzorFeClVentil3 = null;
    private PregradniVentilScreen ProzorFeClKompenzaciona1 = null;
    private PregradniVentilScreen ProzorFeClKompenzaciona2 = null;

    private RegulacioniVentilScreen ProzorHClvoda = null;
    private PregradniVentilScreen ProzorHClUsisPumpeBr1 = null;
    private PregradniVentilScreen ProzorHClUsisPumpeBr2 = null;
    private PregradniVentilScreen ProzorHClPotisPumpeBr1 = null;
    private PregradniVentilScreen ProzorHClPotisPumpeBr2 = null;
    private PregradniVentilScreen ProzorHClZajednickiPotis = null;
    private PregradniVentilScreen ProzorHClZajednickiUsisni = null;

    private RegulacioniVentilScreen ProzorNaOHvoda = null;
    private PregradniVentilScreen ProzorNaOHUsisPumpeBr1 = null;
    private PregradniVentilScreen ProzorNaOHUsisPumpeBr2 = null;
    private PregradniVentilScreen ProzorNaOHPotisPumpeBr1 = null;
    private PregradniVentilScreen ProzorNaOHPotisPumpeBr2 = null;
    private PregradniVentilScreen ProzorNaOHZajednickiPotis = null;
    private PregradniVentilScreen ProzorNaOHZajednickiUsisni = null;

    private PumpeScreen ProzorPumpaKaPF01 = null;
    private PumpeScreen ProzorPumpaKaPF02 = null;
    private PumpeScreen ProzorPumpaKaPF03 = null;
    private PumpeScreen ProzorPumpaKaPF04 = null;
    private PumpeScreen ProzorPumpaKaPF05 = null;
    private PumpeScreen ProzorPumpaKaPF06 = null;

    private PumpeScreen ProzorPumpaKaNI01 = null;
    private PumpeScreen ProzorPumpaKaNI02 = null;
    private PumpeScreen ProzorPumpaKaNI03 = null;


    private PumpeScreen ProzorPumpaKaDemiLinijama01 = null;
    private PumpeScreen ProzorPumpaKaDemiLinijama02 = null;
    private PumpeScreen ProzorPumpaKaDemiLinijama03 = null;
    private PumpeScreen ProzorPumpaKaDemiLinijama04 = null;
    private PumpeScreen ProzorPumpaKaDemiLinijama05 = null;

    private PumpeScreen ProzorPumpaOtpadneOdPranjaPescanihFilteraBr1 = null;
    private PumpeScreen ProzorPumpaOtpadneOdPranjaPescanihFilteraBr2 = null;

    private PumpeScreen ProzorPumpaZaPranjePescanihFilteraBr1 = null;
    private PumpeScreen ProzorPumpaZaPranjePescanihFilteraBr2 = null;

    //private PumpeScreen ProzorPumpaNeutralizacioniBazenBr1 = null;
    //private PumpeScreen ProzorPumpaNeutralizacioniBazenBr2 = null;
    private PumpeSaZastitomScreen ProzorPumpaNeutralizacioniBazenBr1SaZastitom = null;
    private PumpeSaZastitomScreen ProzorPumpaNeutralizacioniBazenBr2SaZastitom = null;

    private PumpeFrScreen ProzorPumpaFerihloridBr1 = null;
    private PumpeFrScreen ProzorPumpaFerihloridBr2 = null;
    private PumpeFrScreen ProzorPumpaFerihloridBr3 = null;

    private PumpeFrScreen ProzorPumpaPolielektrolitBr1 = null;
    private PumpeFrScreen ProzorPumpaPolielektrolitBr2 = null;
    private PumpeFrScreen ProzorPumpaPolielektrolitBr3 = null;

    
     private void inicijalizacijaVentili(){
              
        ProzorGP01kaNeutralnojJonskoj01();
        ProzorGP01kaNeutralnojJonskoj02();
        ProzorGP01kaNeutralnojJonskoj03();
        
        ProzorPKPFbr1();
        ProzorPKPFbr2();
        ProzorPKPFbr3();
        ProzorPKPFbr4();
        ProzorPKPFbr5();
        ProzorPKPFbr6();
         
        ProzorOtpadneVodeOdPescanihFiltera1();
        ProzorOtpadneVodeOdPescanihFiltera2();
        
        ProzorPranjePescanihFiltera1();
        ProzorPranjePescanihFiltera2();
        
        ProzorR1SV();
        ProzorIzlazPF();
        
        ProzorPF201();
        ProzorPF203();
        ProzorPF204();
        ProzorPF205();
        ProzorPF206();
        ProzorPF207();
        ProzorPF208();
        ProzorPF209();
        ProzorPF210();
              
        ProzorPF401();
        ProzorPF403();
        ProzorPF404();
        ProzorPF405();
        ProzorPF406();
        ProzorPF407();
        ProzorPF408();
        ProzorPF409();
        ProzorPF410();
        
        ProzorPF501();
        ProzorPF503();
        ProzorPF504();
        ProzorPF505();
        ProzorPF506();
        ProzorPF507();
        ProzorPF508();
        ProzorPF509();
        ProzorPF510();
       
        ProzorPF601();
        ProzorPF603();
        ProzorPF604();
        ProzorPF605();
        ProzorPF606();
        ProzorPF607();
        ProzorPF608();
        ProzorPF609();
        ProzorPF610();
        
        ProzorDL01JKKF01();
        ProzorDL01JKKF03();
        ProzorDL01JKKF04();
        ProzorDL01JKKF05();
        ProzorDL01JKKF06();
        ProzorDL01JKKF07();
        ProzorDL01JKKF08();
        ProzorDL01JKKF09();
        ProzorDL01JKKF10();
        ProzorDL01JKKF11();
        ProzorDL01JKKF12();
           
        ProzorDL01SBA01();
        ProzorDL01SBA02();
        ProzorDL01SBA03();
        ProzorDL01SBA04();
        ProzorDL01SBA05();
        ProzorDL01SBA06();
     
        
        ProzorDL01JBA01();
        ProzorDL01JBA02();
        ProzorDL01JBA03();
        ProzorDL01JBA04();
        ProzorDL01JBA05();
        ProzorDL01JBA06();
        ProzorDL01JBA07();
        ProzorDL01JBA08();
        
        ProzorDL01MF01();
        ProzorDL01MF02();
        ProzorDL01MF03();
        ProzorDL01MF04();
        ProzorDL01MF05();
        ProzorDL01MF06();
        ProzorDL01MF07();
        ProzorDL01MF08();
        ProzorDL01MF10();
        ProzorDL01MF11();
        
        ProzorDL02JKKF01();
        ProzorDL02JKKF03();
        ProzorDL02JKKF04();
        ProzorDL02JKKF05();
        ProzorDL02JKKF06();
        ProzorDL02JKKF07();
        ProzorDL02JKKF08();
        ProzorDL02JKKF09();
        ProzorDL02JKKF10();
        ProzorDL02JKKF11();
        ProzorDL02JKKF12();
              
        ProzorDL02SBA01();
        ProzorDL02SBA02();
        ProzorDL02SBA03();
        ProzorDL02SBA04();
        ProzorDL02SBA05();
        ProzorDL02SBA06();
        
        ProzorDL02JBA01();
        ProzorDL02JBA02();
        ProzorDL02JBA03();
        ProzorDL02JBA04();
        ProzorDL02JBA05();
        ProzorDL02JBA06();
        ProzorDL02JBA07();
        ProzorDL02JBA08();
     
        ProzorDL02MF01();
        ProzorDL02MF02();
        ProzorDL02MF03();
        ProzorDL02MF04();
        ProzorDL02MF05();
        ProzorDL02MF06();
        ProzorDL02MF07();
        ProzorDL02MF08();
        ProzorDL02MF10();
        ProzorDL02MF11();
    
        ProzorDL03JKKF01();
        ProzorDL03JKKF03();
        ProzorDL03JKKF04();
        ProzorDL03JKKF05();
        ProzorDL03JKKF06();
        ProzorDL03JKKF07();
        ProzorDL03JKKF08();
        ProzorDL03JKKF09();
        ProzorDL03JKKF10();
        ProzorDL03JKKF11();
        ProzorDL03JKKF12();
        
        ProzorDL03SBA01();
        ProzorDL03SBA02();
        ProzorDL03SBA03();
        ProzorDL03SBA04();
        ProzorDL03SBA05();
        ProzorDL03SBA06();
        
        ProzorDL03JBA01();
        ProzorDL03JBA02();
        ProzorDL03JBA03();
        ProzorDL03JBA04();
        ProzorDL03JBA05();
        ProzorDL03JBA06();
        ProzorDL03JBA07();
        ProzorDL03JBA08();
                
        ProzorDL03MF01();
        ProzorDL03MF02();
        ProzorDL03MF03();
        ProzorDL03MF04();
        ProzorDL03MF05();
        ProzorDL03MF06();
        ProzorDL03MF07();
        ProzorDL03MF08();
        ProzorDL03MF10();
        ProzorDL03MF11();
      
        ProzorNJ101();
        ProzorNJ103();
        ProzorNJ104();
        ProzorNJ105();
        ProzorNJ106();
        ProzorNJ107();
        ProzorNJ108();
        ProzorNJ109();
        ProzorNJ110();
     
        ProzorNJ201();
        ProzorNJ203();
        ProzorNJ204();
        ProzorNJ205();
        ProzorNJ206();
        ProzorNJ207();
        ProzorNJ208();
        ProzorNJ209();
        ProzorNJ210();
    
        ProzorNJ301();
        ProzorNJ303();
        ProzorNJ304();
        ProzorNJ305();
        ProzorNJ306();
        ProzorNJ307();
        ProzorNJ308();
        ProzorNJ309();
        ProzorNJ310();

        ProzorPKDemiLinijamaBr1();
        ProzorPKDemiLinijamaBr2();
        ProzorPKDemiLinijamaBr3();
        ProzorPKDemiLinijamaBr4();
        ProzorPKDemiLinijamaBr5();
 
        ProzorPEPosuda1();
        ProzorPEPosuda2();
        ProzorPEVentil1();
        ProzorPEVentil2();
        ProzorPEVentil3();
        ProzorPEKompenzaciona1();
        ProzorPEZaRazblazivanje1();
        
        ProzorFeClPosuda1();
        ProzorFeClPosuda2();
        ProzorFeClVentil1();
        ProzorFeClVentil2();
        ProzorFeClVentil3();
        ProzorFeClKompenzaciona1();
        ProzorFeClKompenzaciona2();
        
        ProzorHClvoda();
        ProzorHClUsisPumpeBr1();
        ProzorHClUsisPumpeBr2();
        ProzorHClPotisPumpeBr1();
        ProzorHClPotisPumpeBr2();
        ProzorHClZajednickiPotis();
        ProzorHClZajednickiUsisni();
    
        ProzorNaOHvoda();
        ProzorNaOHUsisPumpeBr1();
        ProzorNaOHUsisPumpeBr2();
        ProzorNaOHPotisPumpeBr1();
        ProzorNaOHPotisPumpeBr2();
        ProzorNaOHZajednickiPotis();
        ProzorNaOHZajednickiUsisni();
        
        ProzorPumpaKaPF01();
        ProzorPumpaKaPF02();
        ProzorPumpaKaPF03();
        ProzorPumpaKaPF04();
        ProzorPumpaKaPF05();
        ProzorPumpaKaPF06();
        
        ProzorPumpaKaNI01();
        ProzorPumpaKaNI02();
        ProzorPumpaKaNI03();
        
        ProzorPumpaKaDemiLinijama01();
        ProzorPumpaKaDemiLinijama02();
        ProzorPumpaKaDemiLinijama03();
        ProzorPumpaKaDemiLinijama04();
        ProzorPumpaKaDemiLinijama05();
        
        ProzorPumpaOtpadneOdPranjaPescanihFilteraBr1();
        ProzorPumpaOtpadneOdPranjaPescanihFilteraBr2();
        
        ProzorPumpaZaPranjePescanihFilteraBr1();
        ProzorPumpaZaPranjePescanihFilteraBr2();

        ProzorPumpaNeutralizacioniBazenBr1();
        ProzorPumpaNeutralizacioniBazenBr2();

        ProzorPumpaFerihloridBr1();
        ProzorPumpaFerihloridBr2();
        ProzorPumpaFerihloridBr3();
 
        ProzorPumpaPolielektrolitBr1();
        ProzorPumpaPolielektrolitBr2();
        ProzorPumpaPolielektrolitBr3();
    }
    
    
    //   P  U  M  P  E  //////////////////////////////////////////////////////////
    // Pumpe ka pescanim Filterima
    public void ProzorPumpaKaPF01() {
        ProzorPumpaKaPF01 = getPumpeProzor(ProzorPumpaKaPF01, "Pumpa ka pescanim", "Pumpa br 1", pumpeKaPescanimFilterima.getPumpaBr1(), img);
    }

    public void ProzorPumpaKaPF02() {
        ProzorPumpaKaPF02 = getPumpeProzor(ProzorPumpaKaPF02, "Pumpa ka pescanim", "Pumpa br 2", pumpeKaPescanimFilterima.getPumpaBr2(), img);
    }

    public void ProzorPumpaKaPF03() {
        ProzorPumpaKaPF03 = getPumpeProzor(ProzorPumpaKaPF03, "Pumpa ka pescanim", "Pumpa br 3", pumpeKaPescanimFilterima.getPumpaBr3(), img);
    }

    public void ProzorPumpaKaPF04() {
        ProzorPumpaKaPF04 = getPumpeProzor(ProzorPumpaKaPF04,  "Pumpa ka pescanim", "Pumpa br 4", pumpeKaPescanimFilterima.getPumpaBr4(), img);
    }

    public void ProzorPumpaKaPF05() {
        ProzorPumpaKaPF05 = getPumpeProzor(ProzorPumpaKaPF05,  "Pumpa ka pescanim", "Pumpa br 5", pumpeKaPescanimFilterima.getPumpaBr5(), img);
    }

    public void ProzorPumpaKaPF06() {
        ProzorPumpaKaPF06 = getPumpeProzor(ProzorPumpaKaPF06,  "Pumpa ka pescanim", "Pumpa br 6", pumpeKaPescanimFilterima.getPumpaBr6(), img);
    }

    //pumpe ka neutralnoj jonskoj izmeni
    public void ProzorPumpaKaNI01() {
        ProzorPumpaKaNI01 = getPumpeProzor(ProzorPumpaKaNI01,  "Pumpa ka neutralnoj izmeni", "Pumpa br 1", pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr1(), img);
    }

    public void ProzorPumpaKaNI02() {
        ProzorPumpaKaNI02 = getPumpeProzor(ProzorPumpaKaNI02,  "Pumpa ka neutralnoj izmeni", "Pumpa br 2", pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr2(), img);
    }

    public void ProzorPumpaKaNI03() {
        ProzorPumpaKaNI03 = getPumpeProzor(ProzorPumpaKaNI03, "Pumpa ka neutralnoj izmeni", "Pumpa br 3", pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr3(), img);
    }

    //pumpe ka demi liniji
    public void ProzorPumpaKaDemiLinijama01() {
        ProzorPumpaKaDemiLinijama01 = getPumpeProzor(ProzorPumpaKaDemiLinijama01, "Pumpa ka demi linijama", "Pumpa br 1", pumpeDekaFiltriranaKaDemi.getPumpaBr1(), img);
    }

    public void ProzorPumpaKaDemiLinijama02() {
        ProzorPumpaKaDemiLinijama02 = getPumpeProzor(ProzorPumpaKaDemiLinijama02,  "Pumpa ka demi linijama", "Pumpa br 2", pumpeDekaFiltriranaKaDemi.getPumpaBr2(), img);
    }

    public void ProzorPumpaKaDemiLinijama03() {
        ProzorPumpaKaDemiLinijama03 = getPumpeProzor(ProzorPumpaKaDemiLinijama03, "Pumpa ka demi linijama", "Pumpa br 3", pumpeDekaFiltriranaKaDemi.getPumpaBr3(), img);
    }

    public void ProzorPumpaKaDemiLinijama04() {
        ProzorPumpaKaDemiLinijama04 = getPumpeProzor(ProzorPumpaKaDemiLinijama04, "Pumpa ka demi linijama", "Pumpa br 4", pumpeDekaFiltriranaKaDemi.getPumpaBr4(), img);
    }

    public void ProzorPumpaKaDemiLinijama05() {
        ProzorPumpaKaDemiLinijama05 = getPumpeProzor(ProzorPumpaKaDemiLinijama05,  "Pumpa ka demi linijama", "Pumpa br 5", pumpeDekaFiltriranaKaDemi.getPumpaBr5(), img);
    }

    public void ProzorPumpaOtpadneOdPranjaPescanihFilteraBr1() {
        ProzorPumpaOtpadneOdPranjaPescanihFilteraBr1 = getPumpeProzor(ProzorPumpaOtpadneOdPranjaPescanihFilteraBr1, "Otpadne vode od pranja PF", "Pumpa br 1", pumpeOdpadnihVodaOdPranjaPescanihFiltera.getPumpaBr1(), img);
    }

    public void ProzorPumpaOtpadneOdPranjaPescanihFilteraBr2() {
        ProzorPumpaOtpadneOdPranjaPescanihFilteraBr2 = getPumpeProzor(ProzorPumpaOtpadneOdPranjaPescanihFilteraBr2,  "Otpadne vode od pranja PF", "Pumpa br 2", pumpeOdpadnihVodaOdPranjaPescanihFiltera.getPumpaBr2(), img);
    }

    public void ProzorPumpaZaPranjePescanihFilteraBr1() {
        ProzorPumpaZaPranjePescanihFilteraBr1 = getPumpeProzor(ProzorPumpaZaPranjePescanihFilteraBr1, "Za pranja PF", "Pumpa br 1", pumpeZaPranjePescanihFiltera.getPumpaBr1(), img);
    }

    public void ProzorPumpaZaPranjePescanihFilteraBr2() {
        ProzorPumpaZaPranjePescanihFilteraBr2 = getPumpeProzor(ProzorPumpaZaPranjePescanihFilteraBr2, "Za pranja PF", "Pumpa br 2", pumpeZaPranjePescanihFiltera.getPumpaBr2(), img);
    }

    /*  zamenjeni prozori stavljeni sa zastitom pumpe
    public void ProzorPumpaNeutralizacioniBazenBr1() {
        ProzorPumpaNeutralizacioniBazenBr1 = getPumpeProzor(ProzorPumpaNeutralizacioniBazenBr1, "Neutralizacioni bazen", "Pumpa br 1", pumpeNeutralizacionogBazena.getPumpaBr1(), img);
    }

    public void ProzorPumpaNeutralizacioniBazenBr2() {
        ProzorPumpaNeutralizacioniBazenBr2 = getPumpeProzor(ProzorPumpaNeutralizacioniBazenBr2, "Neutralizacioni bazen", "Pumpa br 2", pumpeNeutralizacionogBazena.getPumpaBr2(), img);
    }*/
    public void ProzorPumpaNeutralizacioniBazenBr1() {
        ProzorPumpaNeutralizacioniBazenBr1SaZastitom = getPumpeProzorSaZastitom(ProzorPumpaNeutralizacioniBazenBr1SaZastitom, 
                                        "Neutralizacioni bazen", "Pumpa br 1", pumpeNeutralizacionogBazena.getPumpaBr1(), img, merenja);
    }

    public void ProzorPumpaNeutralizacioniBazenBr2() {
        ProzorPumpaNeutralizacioniBazenBr2SaZastitom = getPumpeProzorSaZastitom(ProzorPumpaNeutralizacioniBazenBr2SaZastitom, 
                "Neutralizacioni bazen", "Pumpa br 2", pumpeNeutralizacionogBazena.getPumpaBr2(), img, merenja);
    }

    ////V E N T I L I////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Reaktor br 1
    public void ProzorR1SV() {
        ProzorR1SV = getProzorRegEMVent(ProzorR1SV, "Reaktor br 1", "regulacioni ventil", reaktor.getUlazSirVodeR1(), protociFlokulacija.getProtokSiroveVodeR1());
    }
    
    public void ProzorIzlazPF(){
        ProzorIzlazIzPescanihFiltera = getProzorRegEMVentSaEstimaciom(ProzorIzlazIzPescanihFiltera, "Izlaz iz pf", "regulacioni ventil", pescaniFilteri.getRegVentIzlazIzPescanih(), 
                protociPescaniFilteri.getProtokPF1());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    ///ka pescanim filterima
    public void ProzorPKPFbr1() {
        ProzorPKPFbr1 = getPregradniVentilProzor(ProzorPKPFbr1, "Ka pescanim filterima", "Pumpa br 1", ventiliKaPescanimFilterima.getAPKPF_PotisBr1(), img);
    }

    public void ProzorPKPFbr2() {
        ProzorPKPFbr2 = getPregradniVentilProzor(ProzorPKPFbr2,  "Ka pescanim filterima", "Pumpa br 2", ventiliKaPescanimFilterima.getAPKPF_PotisBr2(), img);
    }

    public void ProzorPKPFbr3() {
        ProzorPKPFbr3 = getPregradniVentilProzor(ProzorPKPFbr3,  "Ka pescanim filterima", "Pumpa br 3", ventiliKaPescanimFilterima.getAPKPF_PotisBr3(), img);
    }

    public void ProzorPKPFbr4() {
        ProzorPKPFbr4 = getPregradniVentilProzor(ProzorPKPFbr4,  "Ka pescanim filterima", "Pumpa br 4", ventiliKaPescanimFilterima.getAPKPF_PotisBr4(), img);
    }

    public void ProzorPKPFbr5() {
        ProzorPKPFbr5 = getPregradniVentilProzor(ProzorPKPFbr5, "Ka pescanim filterima", "Pumpa br 5", ventiliKaPescanimFilterima.getAPKPF_PotisBr5(), img);
    }

    public void ProzorPKPFbr6() {
        ProzorPKPFbr6 = getPregradniVentilProzor(ProzorPKPFbr6,  "Ka pescanim filterima", "Pumpa br 6", ventiliKaPescanimFilterima.getAPKPF_PotisBr6(), img);
    }

    public void ProzorPKDemiLinijamaBr1() {
        ProzorPKDemiLinijamaBr1 = getPregradniVentilProzor(ProzorPKDemiLinijamaBr1,  "Ka demi liniji", "Pumpa br 1", ventiliGP01.getGP01_potisDemi1(), img);
    }

    public void ProzorPKDemiLinijamaBr2() {
        ProzorPKDemiLinijamaBr2 = getPregradniVentilProzor(ProzorPKDemiLinijamaBr2, "Ka demi liniji", "Pumpa br 2", ventiliGP01.getGP01_potisDemi2(), img);
    }

    public void ProzorPKDemiLinijamaBr3() {
        ProzorPKDemiLinijamaBr3 = getPregradniVentilProzor(ProzorPKDemiLinijamaBr3,  "Ka demi liniji", "Pumpa br 3", ventiliGP01.getGP01_potisDemi3(), img);
    }

    public void ProzorPKDemiLinijamaBr4() {
        ProzorPKDemiLinijamaBr4 = getPregradniVentilProzor(ProzorPKDemiLinijamaBr4, "Ka demi liniji", "Pumpa br 4", ventiliGP01.getGP01_potisDemi4(), img);
    }

    public void ProzorPKDemiLinijamaBr5() {
        ProzorPKDemiLinijamaBr5 = getPregradniVentilProzor(ProzorPKDemiLinijamaBr5, "Ka demi liniji", "Pumpa br 5", ventiliGP01.getGP01_potisDemi5(), img);
    }

    //Polielektrolit
    public void ProzorPEPosuda1() {
        ProzorPEPosuda1 = getPregradniVentilProzor(ProzorPEPosuda1, "Polielektrolit posuda br 1", "Posuda br 1", ventiliPolielektrolit.getPE_posuda1(), img);
    }

    public void ProzorPEPosuda2() {
        ProzorPEPosuda2 = getPregradniVentilProzor(ProzorPEPosuda2,  "Polielektrolit posuda br 2", "Posuda br 2", ventiliPolielektrolit.getPE_posuda2(), img);
    }

    public void ProzorPEVentil1() {
        ProzorPEVentil1 = getPregradniVentilProzor(ProzorPEVentil1,"Polielektrolit pumpa br 1", "Ventil br 1", ventiliPolielektrolit.getPE_ventil1(), img);
    }

    public void ProzorPEVentil2() {
        ProzorPEVentil2 = getPregradniVentilProzor(ProzorPEVentil2, "Polielektrolit pumpa br 2", "Ventil br 2", ventiliPolielektrolit.getPE_ventil2(), img);
    }

    public void ProzorPEVentil3() {
        ProzorPEVentil3 = getPregradniVentilProzor(ProzorPEVentil3,  "Polielektrolit pumpa br 3", "Ventil br 3", ventiliPolielektrolit.getPE_ventil3(), img);
    }

    public void ProzorPEKompenzaciona1() {
        ProzorPEKompenzaciona1 = getPregradniVentilProzor(ProzorPEKompenzaciona1,  "Polielektrolit kompenzaciona br 1", "Ventil br 1", ventiliPolielektrolit.getPE_kompenzaciona1(), img);
    }

    public void ProzorPEKompenzaciona2() {
        ProzorPEKompenzaciona2 = getPregradniVentilProzor(ProzorPEKompenzaciona2,  "Polielektrolit kompenzaciona br 2", "Ventil br 2", ventiliPolielektrolit.getPE_kompenzaciona2(), img);
    }

    public void ProzorPEZaRazblazivanje1() {
        ProzorPEZaRazblazivanje1 = getPregradniVentilProzor(ProzorPEZaRazblazivanje1, "Polielektrolit razblazivanje br 1", "Ventil br 1", ventiliPolielektrolit.getPE_vodaKaPosudi1(), img);
    }

    public void ProzorPEZaRazblazivanje2() {
        ProzorPEZaRazblazivanje2 = getPregradniVentilProzor(ProzorPEZaRazblazivanje2,  "Polielektrolit razblazivanje br 2", "Ventil br 2", ventiliPolielektrolit.getPE_vodaKaPosudi2(), img);
    }

    //Ferihlorid
    public void ProzorFeClPosuda1() {
        ProzorFeClPosuda1 = getPregradniVentilProzor(ProzorFeClPosuda1,  "Ferihlorid posuda br 1", "Posuda br 1", ventiliFerihlorid.getFCl_posuda1(), img);
    }

    public void ProzorFeClPosuda2() {
        ProzorFeClPosuda2 = getPregradniVentilProzor(ProzorFeClPosuda2, "Ferihlorid posuda br 2", "Posuda br 2", ventiliFerihlorid.getFCl_posuda2(), img);
    }

    public void ProzorFeClVentil1() {
        ProzorFeClVentil1 = getPregradniVentilProzor(ProzorFeClVentil1, "Ferihlorid pumpa br 1", "Ventil br 1", ventiliFerihlorid.getFCl_ventil1(), img);
    }

    public void ProzorFeClVentil2() {
        ProzorFeClVentil2 = getPregradniVentilProzor(ProzorFeClVentil2,  "Ferihlorid pumpa br 2", "Ventil br 2", ventiliFerihlorid.getFCl_ventil2(), img);
    }

    public void ProzorFeClVentil3() {
        ProzorFeClVentil3 = getPregradniVentilProzor(ProzorFeClVentil3, "Ferihlorid pumpa br 3", "Ventil br 3", ventiliFerihlorid.getFCl_ventil3(), img);
    }

    public void ProzorFeClKompenzaciona1() {
        ProzorFeClKompenzaciona1 = getPregradniVentilProzor(ProzorFeClKompenzaciona1, "Ferihlorid kompenzaciona br 1", "Ventil br 1", ventiliFerihlorid.getFCl_kompenzaciona1(), img);
    }

    public void ProzorFeClKompenzaciona2() {
        ProzorFeClKompenzaciona2 = getPregradniVentilProzor(ProzorFeClKompenzaciona2, "Ferihlorid kompenzaciona br 2", "Ventil br 2", ventiliFerihlorid.getFCl_kompenzaciona2(), img);
    }

    //ka neutralnoj liniji
    public void ProzorGP01kaNeutralnojJonskoj03() {
        ProzorGP01kaNeutralnojJonskoj03 = getPregradniVentilProzor(ProzorGP01kaNeutralnojJonskoj03,  "Pumpe ka neutralnoj", "Ventil br 3", ventiliGP01.getGP01_potisJonska3(), img);
    }

    public void ProzorGP01kaNeutralnojJonskoj02() {
        ProzorGP01kaNeutralnojJonskoj02 = getPregradniVentilProzor(ProzorGP01kaNeutralnojJonskoj02, "Pumpe ka neutralnoj", "Ventil br 2", ventiliGP01.getGP01_potisJonska2(), img);
    }

    public void ProzorGP01kaNeutralnojJonskoj01() {
        ProzorGP01kaNeutralnojJonskoj01 = getPregradniVentilProzor(ProzorGP01kaNeutralnojJonskoj01, "Pumpe ka neutralnoj", "Ventil br 1", ventiliGP01.getGP01_potisJonska1(), img);
    }

    //demi linije - regulacioni ventili
    public void ProzorDL01JKKF01() {
        ProzorDL01JKKF01 = getRegulacioniVentilProzor(ProzorDL01JKKF01,  "Demi linija 1", "regulacioni ventil", demiLinije.getJkkf01().getRegVent01(), protociDemiLinije.getProtokDL1in());
    }

    public void ProzorDL02JKKF01() {
        ProzorDL02JKKF01 = getRegulacioniVentilProzor(ProzorDL02JKKF01,"Demi linija 2", "regulacioni ventil", demiLinije.getJkkf02().getRegVent01(), protociDemiLinije.getProtokDL2in());
    }

    public void ProzorDL03JKKF01() {
        ProzorDL03JKKF01 = getRegulacioniVentilProzor(ProzorDL03JKKF01, "Demi linija 3", "regulacioni ventil", demiLinije.getJkkf03().getRegVent01(), protociDemiLinije.getProtokDL3in());
    }

    //neutralna jonska - regulacioni ventili
    public void ProzorNJ101() {
        ProzorNJ101 = getRegulacioniVentilProzor(ProzorNJ101,  "Neutralna izmena 1", "regulacioni ventil", jonskaIzmena.getJonskaIzmena01().getRegVent01(), protociNeutralna.getProtokNJ1());
    }

    public void ProzorNJ201() {
        ProzorNJ201 = getRegulacioniVentilProzor(ProzorNJ201, "Neutralna izmena 2", "regulacioni ventil", jonskaIzmena.getJonskaIzmena02().getRegVent01(), protociNeutralna.getProtokNJ2());
    }

    public void ProzorNJ301() {
        ProzorNJ301 = getRegulacioniVentilProzor(ProzorNJ301, "Neutralna izmena 3", "regulacioni ventil", jonskaIzmena.getJonskaIzmena03().getRegVent01(), protociNeutralna.getProtokNJ3());
    }

    public void ProzorOtpadneVodeOdPescanihFiltera1() {
        ProzorOtpadneVodeOdPescanihFiltera1 = getPregradniVentilProzor(ProzorOtpadneVodeOdPescanihFiltera1, "Od pranja PF", "Ventil br 1", otpadneVodeOdPescanihFiltera.getVent01(), img);
    }

    public void ProzorOtpadneVodeOdPescanihFiltera2() {
        ProzorOtpadneVodeOdPescanihFiltera2 = getPregradniVentilProzor(ProzorOtpadneVodeOdPescanihFiltera2,  "Od pranja PF", "Ventil br 2", otpadneVodeOdPescanihFiltera.getVent02(), img);
    }

    public void ProzorPranjePescanihFiltera1() {
        ProzorPranjePescanihFiltera1 = getPregradniVentilProzor(ProzorPranjePescanihFiltera1, "Pranje PF", "Ventil br 1", pranjePescanihFiltera.getVent01(), img);
    }

    public void ProzorPranjePescanihFiltera2() {
        ProzorPranjePescanihFiltera2 = getPregradniVentilProzor(ProzorPranjePescanihFiltera2, "Pranje PF", "Ventil br 2", pranjePescanihFiltera.getVent02(), img);
    }

    //Regeneracija
    public void ProzorHClUsisPumpeBr1() {
        ProzorHClUsisPumpeBr1 = getPregradniVentilProzor(ProzorHClUsisPumpeBr1, "Regeneracija HCl", "Usisni ventil br 1", regeneracija.getVentHCLusisPumpeBr1(), img);
    }

    public void ProzorHClUsisPumpeBr2() {
        ProzorHClUsisPumpeBr2 = getPregradniVentilProzor(ProzorHClUsisPumpeBr2,  "Regeneracija HCl", "Usisni ventil br 2", regeneracija.getVentHCLusisPumpeBr2(), img);
    }

    public void ProzorHClPotisPumpeBr1() {
        ProzorHClPotisPumpeBr1 = getPregradniVentilProzor(ProzorHClPotisPumpeBr1, "Regeneracija HCl", "Potisni ventil br 1", regeneracija.getVentHCLpotisPumpeBr1(), img);
    }

    public void ProzorHClPotisPumpeBr2() {
        ProzorHClPotisPumpeBr2 = getPregradniVentilProzor(ProzorHClPotisPumpeBr2, "Regeneracija HCl", "Potisni ventil br 2", regeneracija.getVentHCLpotisPumpeBr2(), img);
    }

    public void ProzorNaOHUsisPumpeBr1() {
        ProzorNaOHUsisPumpeBr1 = getPregradniVentilProzor(ProzorNaOHUsisPumpeBr1,  "Regeneracija NaOH", "Usisni ventil br 1", regeneracija.getVentNaOHusisPumpeBr1(), img);
    }

    public void ProzorNaOHUsisPumpeBr2() {
        ProzorNaOHUsisPumpeBr2 = getPregradniVentilProzor(ProzorNaOHUsisPumpeBr2,  "Regeneracija NaOH", "Usisni ventil br 2", regeneracija.getVentNaOHusisPumpeBr2(), img);
    }

    public void ProzorNaOHPotisPumpeBr1() {
        ProzorNaOHPotisPumpeBr1 = getPregradniVentilProzor(ProzorNaOHPotisPumpeBr1,  "Regeneracija NaOH", "Potisni ventil br 1", regeneracija.getVentNaOHpotisPumpeBr1(), img);
    }

    public void ProzorNaOHPotisPumpeBr2() {
        ProzorNaOHPotisPumpeBr2 = getPregradniVentilProzor(ProzorNaOHPotisPumpeBr2,  "Regeneracija NaOH", "Potisni ventil br 2", regeneracija.getVentNaOHpotisPumpeBr2(), img);
    }

    public void ProzorHClZajednickiPotis() {
        ProzorHClZajednickiPotis = getPregradniVentilProzor(ProzorHClZajednickiPotis,  "Regeneracija HCl", " Zajednicki potisni ventil", regeneracija.getVentHCLzajednickiPotis(), img);
    }

    public void ProzorHClZajednickiUsisni() {
        ProzorHClZajednickiUsisni = getPregradniVentilProzor(ProzorHClZajednickiUsisni,  "Regeneracija HCl", " Zajednicki usisni ventil", regeneracija.getVentHCLzajednickiUsis(), img);
    }

    public void ProzorNaOHZajednickiPotis() {
        ProzorNaOHZajednickiPotis = getPregradniVentilProzor(ProzorNaOHZajednickiPotis, "Regeneracija NaOH", " Zajednicki potisni ventil", regeneracija.getVentNaOHzajednickiPotis(), img);
    }

    public void ProzorNaOHZajednickiUsisni() {
        ProzorNaOHZajednickiUsisni = getPregradniVentilProzor(ProzorNaOHZajednickiUsisni, "Regeneracija NaOH", " Zajednicki usisni ventil", regeneracija.getVentNaOHzajednickiUsis(), img);
    }

    public void ProzorPF601() {
        ProzorPF601 = getRegulacioniVentilProzor(ProzorPF601, "Pescani filter 6", "regulacioni ventil", pescaniFilteri.getPf6().getRegVent01(), protociPescaniFilteri.getProtokPF6());
    }

    public void ProzorPF501() {
        ProzorPF501 = getRegulacioniVentilProzor(ProzorPF501, "Pescani filter 5", "regulacioni ventil", pescaniFilteri.getPf5().getRegVent01(), protociPescaniFilteri.getProtokPF5());
    }

    public void ProzorPF401() {
        ProzorPF401 = getRegulacioniVentilProzor(ProzorPF401,"Pescani filter 4", "regulacioni ventil", pescaniFilteri.getPf4().getRegVent01(), protociPescaniFilteri.getProtokPF4());
    }

    public void ProzorPF201() {
        ProzorPF201 = getRegulacioniVentilProzor(ProzorPF201, "Pescani filter 2", "regulacioni ventil", pescaniFilteri.getPf2().getRegVent01(), protociPescaniFilteri.getProtokPF2());
    }

    public void ProzorPF203() {
        ProzorPF203 = getPregradniVentilProzor(ProzorPF203,  "Pescani filter 2", "Ventil br 3", pescaniFilteri.getPf2().getVent03(), img);
    }

    public void ProzorPF204() {
        ProzorPF204 = getPregradniVentilProzor(ProzorPF204,"Pescani filter 2", "Ventil br 4", pescaniFilteri.getPf2().getVent04(), img);
    }

    public void ProzorPF205() {
        ProzorPF205 = getPregradniVentilProzor(ProzorPF205,  "Pescani filter 2", "Ventil br 5", pescaniFilteri.getPf2().getVent05(), img);
    }

    public void ProzorPF206() {
        ProzorPF206 = getPregradniVentilProzor(ProzorPF206, "Pescani filter 2", "Ventil br 6", pescaniFilteri.getPf2().getVent06(), img);
    }

    public void ProzorPF207() {
        ProzorPF207 = getPregradniVentilProzor(ProzorPF207, "Pescani filter 2", "Ventil br 7", pescaniFilteri.getPf2().getVent07(), img);
    }

    public void ProzorPF208() {
        ProzorPF208 = getPregradniVentilProzor(ProzorPF208,  "Pescani filter 2", "Ventil br 8", pescaniFilteri.getPf2().getVent08(), img);
    }

    public void ProzorPF209() {
        ProzorPF209 = getPregradniVentilProzor(ProzorPF209,  "Pescani filter 2", "Ventil br 9", pescaniFilteri.getPf2().getVent09(), img);
    }

    public void ProzorPF210() {
        ProzorPF210 = getPregradniVentilProzor(ProzorPF210, "Pescani filter 2", "Ventil br 10", pescaniFilteri.getPf2().getVent10(), img);
    }

    public void ProzorPF403() {
        ProzorPF403 = getPregradniVentilProzor(ProzorPF403, "Pescani filter 4", "Ventil br 3", pescaniFilteri.getPf4().getVent03(), img);
    }

    public void ProzorPF404() {
        ProzorPF404 = getPregradniVentilProzor(ProzorPF404, "Pescani filter 4", "Ventil br 4", pescaniFilteri.getPf4().getVent04(), img);
    }

    public void ProzorPF405() {
        ProzorPF405 = getPregradniVentilProzor(ProzorPF405,  "Pescani filter 4", "Ventil br 5", pescaniFilteri.getPf4().getVent05(), img);
    }

    public void ProzorPF406() {
        ProzorPF406 = getPregradniVentilProzor(ProzorPF406, "Pescani filter 4", "Ventil br 6", pescaniFilteri.getPf4().getVent06(), img);
    }

    public void ProzorPF407() {
        ProzorPF407 = getPregradniVentilProzor(ProzorPF407, "Pescani filter 4", "Ventil br 7", pescaniFilteri.getPf4().getVent07(), img);
    }

    public void ProzorPF408() {
        ProzorPF408 = getPregradniVentilProzor(ProzorPF408, "Pescani filter 4", "Ventil br 8", pescaniFilteri.getPf4().getVent08(), img);
    }

    public void ProzorPF409() {
        ProzorPF409 = getPregradniVentilProzor(ProzorPF409, "Pescani filter 4", "Ventil br 9", pescaniFilteri.getPf4().getVent09(), img);
    }

    public void ProzorPF410() {
        ProzorPF410 = getPregradniVentilProzor(ProzorPF410, "Pescani filter 4", "Ventil br 10", pescaniFilteri.getPf4().getVent10(), img);
    }

    public void ProzorPF503() {
        ProzorPF503 = getPregradniVentilProzor(ProzorPF503,  "Pescani filter 5", "Ventil br 3", pescaniFilteri.getPf5().getVent03(), img);
    }

    public void ProzorPF504() {
        ProzorPF504 = getPregradniVentilProzor(ProzorPF504, "Pescani filter 5", "Ventil br 4", pescaniFilteri.getPf5().getVent04(), img);
    }

    public void ProzorPF505() {
        ProzorPF505 = getPregradniVentilProzor(ProzorPF505, "Pescani filter 5", "Ventil br 5", pescaniFilteri.getPf5().getVent05(), img);
    }

    public void ProzorPF506() {
        ProzorPF506 = getPregradniVentilProzor(ProzorPF506,  "Pescani filter 5", "Ventil br 6", pescaniFilteri.getPf5().getVent06(), img);
    }

    public void ProzorPF507() {
        ProzorPF507 = getPregradniVentilProzor(ProzorPF507, "Pescani filter 5", "Ventil br 7", pescaniFilteri.getPf5().getVent07(), img);
    }

    public void ProzorPF508() {
        ProzorPF508 = getPregradniVentilProzor(ProzorPF508,  "Pescani filter 5", "Ventil br 8", pescaniFilteri.getPf5().getVent08(), img);
    }

    public void ProzorPF509() {
        ProzorPF509 = getPregradniVentilProzor(ProzorPF509,  "Pescani filter 5", "Ventil br 9", pescaniFilteri.getPf5().getVent09(), img);
    }

    public void ProzorPF510() {
        ProzorPF510 = getPregradniVentilProzor(ProzorPF510, "Pescani filter 5", "Ventil br 10", pescaniFilteri.getPf5().getVent10(), img);
    }

    public void ProzorPF603() {
        ProzorPF603 = getPregradniVentilProzor(ProzorPF603,  "Pescani filter 6", "Ventil br 3", pescaniFilteri.getPf6().getVent03(), img);
    }

    public void ProzorPF604() {
        ProzorPF604 = getPregradniVentilProzor(ProzorPF604,  "Pescani filter 6", "Ventil br 4", pescaniFilteri.getPf6().getVent04(), img);
    }

    public void ProzorPF605() {
        ProzorPF605 = getPregradniVentilProzor(ProzorPF605, "Pescani filter 6", "Ventil br 5", pescaniFilteri.getPf6().getVent05(), img);
    }

    public void ProzorPF606() {
        ProzorPF606 = getPregradniVentilProzor(ProzorPF606,  "Pescani filter 6", "Ventil br 6", pescaniFilteri.getPf6().getVent06(), img);
    }

    public void ProzorPF607() {
        ProzorPF607 = getPregradniVentilProzor(ProzorPF607,  "Pescani filter 6", "Ventil br 7", pescaniFilteri.getPf6().getVent07(), img);
    }

    public void ProzorPF608() {
        ProzorPF608 = getPregradniVentilProzor(ProzorPF608, "Pescani filter 6", "Ventil br 8", pescaniFilteri.getPf6().getVent08(), img);
    }

    public void ProzorPF609() {
        ProzorPF609 = getPregradniVentilProzor(ProzorPF609, "Pescani filter 6", "Ventil br 9", pescaniFilteri.getPf6().getVent09(), img);
    }

    public void ProzorPF610() {
        ProzorPF610 = getPregradniVentilProzor(ProzorPF610, "Pescani filter 6", "Ventil br 10", pescaniFilteri.getPf6().getVent10(), img);
    }

    public void ProzorNJ307() {
        ProzorNJ307 = getPregradniVentilProzor(ProzorNJ307, "Neutralna izmena 3", "Ventil br 7", jonskaIzmena.getJonskaIzmena03().getVent07(), img);
    }

    public void ProzorNJ303() {
        ProzorNJ303 = getPregradniVentilProzor(ProzorNJ303, "Neutralna izmena 3", "Ventil br 3", jonskaIzmena.getJonskaIzmena03().getVent03(), img);
    }

    public void ProzorNJ305() {
        ProzorNJ305 = getPregradniVentilProzor(ProzorNJ305, "Neutralna izmena 3", "Ventil br 5", jonskaIzmena.getJonskaIzmena03().getVent05(), img);
    }

    public void ProzorNJ308() {
        ProzorNJ308 = getPregradniVentilProzor(ProzorNJ308, "Neutralna izmena 3", "Ventil br 8", jonskaIzmena.getJonskaIzmena03().getVent08(), img);
    }

    public void ProzorNJ304() {
        ProzorNJ304 = getPregradniVentilProzor(ProzorNJ304, "Neutralna izmena 3", "Ventil br 4", jonskaIzmena.getJonskaIzmena03().getVent04(), img);
    }

    public void ProzorNJ309() {
        ProzorNJ309 = getPregradniVentilProzor(ProzorNJ309, "Neutralna izmena 3", "Ventil br 9", jonskaIzmena.getJonskaIzmena03().getVent09(), img);
    }

    public void ProzorNJ306() {
        ProzorNJ306 = getPregradniVentilProzor(ProzorNJ306, "Neutralna izmena 3", "Ventil br 6", jonskaIzmena.getJonskaIzmena03().getVent06(), img);
    }

    public void ProzorNJ310() {
        ProzorNJ310 = getPregradniVentilProzor(ProzorNJ310, "Neutralna izmena 3", "Ventil br 10", jonskaIzmena.getJonskaIzmena03().getVent10(), img);
    }

    public void ProzorNJ207() {
        ProzorNJ207 = getPregradniVentilProzor(ProzorNJ207,"Neutralna izmena 2", "Ventil br 7", jonskaIzmena.getJonskaIzmena02().getVent07(), img);
    }

    public void ProzorNJ203() {
        ProzorNJ203 = getPregradniVentilProzor(ProzorNJ203, "Neutralna izmena 2", "Ventil br 3", jonskaIzmena.getJonskaIzmena02().getVent03(), img);
    }

    public void ProzorNJ205() {
        ProzorNJ205 = getPregradniVentilProzor(ProzorNJ205,  "Neutralna izmena 2", "Ventil br 5", jonskaIzmena.getJonskaIzmena02().getVent05(), img);
    }

    public void ProzorNJ208() {
        ProzorNJ208 = getPregradniVentilProzor(ProzorNJ208,  "Neutralna izmena 2", "Ventil br 8", jonskaIzmena.getJonskaIzmena02().getVent08(), img);
    }

    public void ProzorNJ204() {
        ProzorNJ204 = getPregradniVentilProzor(ProzorNJ204, "Neutralna izmena 2", "Ventil br 4", jonskaIzmena.getJonskaIzmena02().getVent04(), img);
    }

    public void ProzorNJ206() {
        ProzorNJ206 = getPregradniVentilProzor(ProzorNJ206, "Neutralna izmena 2", "Ventil br 6", jonskaIzmena.getJonskaIzmena02().getVent06(), img);
    }

    public void ProzorNJ209() {
        ProzorNJ209 = getPregradniVentilProzor(ProzorNJ209, "Neutralna izmena 2", "Ventil br 9", jonskaIzmena.getJonskaIzmena02().getVent09(), img);
    }

    public void ProzorNJ210() {
        ProzorNJ210 = getPregradniVentilProzor(ProzorNJ210,  "Neutralna izmena 2", "Ventil br 10", jonskaIzmena.getJonskaIzmena02().getVent10(), img);
    }

    public void ProzorNJ107() {
        ProzorNJ107 = getPregradniVentilProzor(ProzorNJ107, "Neutralna izmena 1", "Ventil br 7", jonskaIzmena.getJonskaIzmena01().getVent07(), img);
    }

    public void ProzorNJ103() {
        ProzorNJ103 = getPregradniVentilProzor(ProzorNJ103,  "Neutralna izmena 1", "Ventil br 3", jonskaIzmena.getJonskaIzmena01().getVent03(), img);
    }

    public void ProzorNJ105() {
        ProzorNJ105 = getPregradniVentilProzor(ProzorNJ105, "Neutralna izmena 1", "Ventil br 5", jonskaIzmena.getJonskaIzmena01().getVent05(), img);
    }

    public void ProzorNJ108() {
        ProzorNJ108 = getPregradniVentilProzor(ProzorNJ108,"Neutralna izmena 1", "Ventil br 8", jonskaIzmena.getJonskaIzmena01().getVent08(), img);
    }

    public void ProzorNJ109() {
        ProzorNJ109 = getPregradniVentilProzor(ProzorNJ109,  "Neutralna izmena 1", "Ventil br 9", jonskaIzmena.getJonskaIzmena01().getVent09(), img);
    }

    public void ProzorNJ104() {
        ProzorNJ104 = getPregradniVentilProzor(ProzorNJ104,  "Neutralna izmena 1", "Ventil br 4", jonskaIzmena.getJonskaIzmena01().getVent04(), img);
    }

    public void ProzorNJ106() {
        ProzorNJ106 = getPregradniVentilProzor(ProzorNJ106, "Neutralna izmena 1", "Ventil br 6", jonskaIzmena.getJonskaIzmena01().getVent06(), img);
    }

    public void ProzorNJ110() {
        ProzorNJ110 = getPregradniVentilProzor(ProzorNJ110,  "Neutralna izmena 1", "Ventil br 10", jonskaIzmena.getJonskaIzmena01().getVent10(), img);
    }

    public void ProzorDL01JKKF03() {
        ProzorDL01JKKF03 = getPregradniVentilProzor(ProzorDL01JKKF03, "Demi linija 1", "Ventil br 3", demiLinije.getJkkf01().getVent03(), img);
    }

    public void ProzorDL01JKKF04() {
        ProzorDL01JKKF04 = getPregradniVentilProzor(ProzorDL01JKKF04, "Demi linija 1", "Ventil br 4", demiLinije.getJkkf01().getVent04(), img);
    }

    public void ProzorDL01JKKF05() {
        ProzorDL01JKKF05 = getPregradniVentilProzor(ProzorDL01JKKF05, "Demi linija 1", "Ventil br 5", demiLinije.getJkkf01().getVent05(), img);
    }

    public void ProzorDL01JKKF06() {
        ProzorDL01JKKF06 = getPregradniVentilProzor(ProzorDL01JKKF06,"Demi linija 1", "Ventil br 6", demiLinije.getJkkf01().getVent06(), img);
    }

    public void ProzorDL01JKKF07() {
        ProzorDL01JKKF07 = getPregradniVentilProzor(ProzorDL01JKKF07, "Demi linija 1", "Ventil br 7", demiLinije.getJkkf01().getVent07(), img);
    }

    public void ProzorDL01JKKF08() {

        ProzorDL01JKKF08 = getPregradniVentilProzor(ProzorDL01JKKF08, "Demi linija 1", "Ventil br 8", demiLinije.getJkkf01().getVent08(), img);
    }

    public void ProzorDL01JKKF09() {
        ProzorDL01JKKF09 = getPregradniVentilProzor(ProzorDL01JKKF09,"Demi linija 1", "Ventil br 9", demiLinije.getJkkf01().getVent09(), img);
    }

    public void ProzorDL01JKKF10() {

        ProzorDL01JKKF10 = getPregradniVentilProzor(ProzorDL01JKKF10, "Demi linija 1", "Ventil br 10", demiLinije.getJkkf01().getVent10(), img);
    }

    public void ProzorDL01JKKF11() {
        ProzorDL01JKKF11 = getPregradniVentilProzor(ProzorDL01JKKF11,"Demi linija 1", "Ventil br 11", demiLinije.getJkkf01().getVent11(), img);
    }

    public void ProzorDL01JKKF12() {
        ProzorDL01JKKF12 = getPregradniVentilProzor(ProzorDL01JKKF12, "Demi linija 1", "Ventil br 12", demiLinije.getJkkf01().getVent12(), img);
    }

    public void ProzorDL01SBA01() {
        ProzorDL01SBA01 = getPregradniVentilProzor(ProzorDL01SBA01, "Demi linija 1", "Ventil br 01", demiLinije.getSbaf01().getVent01(), img);
    }

    public void ProzorDL01SBA02() {
        ProzorDL01SBA02 = getPregradniVentilProzor(ProzorDL01SBA02, "Demi linija 1", "Ventil br 02", demiLinije.getSbaf01().getVent02(), img);
    }

    public void ProzorDL01SBA03() {
        ProzorDL01SBA03 = getPregradniVentilProzor(ProzorDL01SBA03,"Demi linija 1", "Ventil br 03", demiLinije.getSbaf01().getVent03(), img);
    }

    public void ProzorDL01SBA04() {
        ProzorDL01SBA04 = getPregradniVentilProzor(ProzorDL01SBA04, "Demi linija 1", "Ventil br 04", demiLinije.getSbaf01().getVent04(), img);
    }

    public void ProzorDL01SBA05() {
        ProzorDL01SBA05 = getPregradniVentilProzor(ProzorDL01SBA05, "Demi linija 1", "Ventil br 05", demiLinije.getSbaf01().getVent05(), img);
    }

    public void ProzorDL01SBA06() {
        ProzorDL01SBA06 = getPregradniVentilProzor(ProzorDL01SBA06,"Demi linija 1", "Ventil br 06", demiLinije.getSbaf01().getVent06(), img);
    }

    public void ProzorDL01JBA01() {
        ProzorDL01JBA01 = getPregradniVentilProzor(ProzorDL01JBA01, "Demi linija 1", "Ventil br 01", demiLinije.getJbaf01().getVent01(), img);
    }

    public void ProzorDL01JBA02() {
        ProzorDL01JBA02 = getPregradniVentilProzor(ProzorDL01JBA02, "Demi linija 1", "Ventil br 02", demiLinije.getJbaf01().getVent02(), img);
    }

    public void ProzorDL01JBA03() {
        ProzorDL01JBA03 = getPregradniVentilProzor(ProzorDL01JBA03, "Demi linija 1", "Ventil br 03", demiLinije.getJbaf01().getVent03(), img);
    }

    public void ProzorDL01JBA04() {

        ProzorDL01JBA04 = getPregradniVentilProzor(ProzorDL01JBA04, "Demi linija 1", "Ventil br 04", demiLinije.getJbaf01().getVent04(), img);

    }

    public void ProzorDL01JBA05() {
        ProzorDL01JBA05 = getPregradniVentilProzor(ProzorDL01JBA05, "Demi linija 1", "Ventil br 05", demiLinije.getJbaf01().getVent05(), img);
    }

    public void ProzorDL01JBA06() {
        ProzorDL01JBA06 = getPregradniVentilProzor(ProzorDL01JBA06, "Demi linija 1", "Ventil br 06", demiLinije.getJbaf01().getVent06(), img);
    }

    public void ProzorDL01JBA07() {
        ProzorDL01JBA07 = getPregradniVentilProzor(ProzorDL01JBA07, "Demi linija 1", "Ventil br 07", demiLinije.getJbaf01().getVent07(), img);
    }

    public void ProzorDL01JBA08() {
        ProzorDL01JBA08 = getPregradniVentilProzor(ProzorDL01JBA08, "Demi linija 1", "Ventil br 08", demiLinije.getJbaf01().getVent08(), img);
    }

    public void ProzorDL01MF01() {
        ProzorDL01MF01 = getPregradniVentilProzor(ProzorDL01MF01, "Demi linija 1", "Ventil br 01", demiLinije.getMf01().getVent01(), img);
    }

    public void ProzorDL01MF02() {
        ProzorDL01MF02 = getPregradniVentilProzor(ProzorDL01MF02, "Demi linija 1", "Ventil br 02", demiLinije.getMf01().getVent02(), img);
    }

    public void ProzorDL01MF03() {
        ProzorDL01MF03 = getPregradniVentilProzor(ProzorDL01MF03, "Demi linija 1", "Ventil br 03", demiLinije.getMf01().getVent03(), img);
    }

    public void ProzorDL01MF04() {
        ProzorDL01MF04 = getPregradniVentilProzor(ProzorDL01MF04, "Demi linija 1", "Ventil br 04", demiLinije.getMf01().getVent04(), img);
    }

    public void ProzorDL01MF05() {
        ProzorDL01MF05 = getPregradniVentilProzor(ProzorDL01MF05,  "Demi linija 1", "Ventil br 05", demiLinije.getMf01().getVent05(), img);
    }

    public void ProzorDL01MF06() {
        ProzorDL01MF06 = getPregradniVentilProzor(ProzorDL01MF06, "Demi linija 1", "Ventil br 06", demiLinije.getMf01().getVent06(), img);
    }

    public void ProzorDL01MF07() {
        ProzorDL01MF07 = getPregradniVentilProzor(ProzorDL01MF07, "Demi linija 1", "Ventil br 07", demiLinije.getMf01().getVent07(), img);
    }

    public void ProzorDL01MF08() {
        ProzorDL01MF08 = getPregradniVentilProzor(ProzorDL01MF08,  "Demi linija 1", "Ventil br 08", demiLinije.getMf01().getVent08(), img);
    }

    public void ProzorDL01MF10() {
        ProzorDL01MF10 = getPregradniVentilProzor(ProzorDL01MF10,  "Demi linija 1", "Ventil br 10", demiLinije.getMf01().getVent10(), img);
    }

    public void ProzorDL01MF11() {
        ProzorDL01MF11 = getPregradniVentilProzor(ProzorDL01MF11, "Demi linija 1", "Ventil br 11", demiLinije.getMf01().getVent11(), img);
    }

    public void ProzorDL02JKKF03() {
        ProzorDL02JKKF03 = getPregradniVentilProzor(ProzorDL02JKKF03, "Demi linija 2", "Ventil br 3", demiLinije.getJkkf02().getVent03(), img);
    }

    public void ProzorDL02JKKF04() {
        ProzorDL02JKKF04 = getPregradniVentilProzor(ProzorDL02JKKF04, "Demi linija 2", "Ventil br 4", demiLinije.getJkkf02().getVent04(), img);
    }

    public void ProzorDL02JKKF05() {
        ProzorDL02JKKF05 = getPregradniVentilProzor(ProzorDL02JKKF05, "Demi linija 2", "Ventil br 5", demiLinije.getJkkf02().getVent05(), img);
    }

    public void ProzorDL02JKKF06() {
        ProzorDL02JKKF06 = getPregradniVentilProzor(ProzorDL02JKKF06, "Demi linija 2", "Ventil br 6", demiLinije.getJkkf02().getVent06(), img);
    }

    public void ProzorDL02JKKF07() {
        ProzorDL02JKKF07 = getPregradniVentilProzor(ProzorDL02JKKF07, "Demi linija 2", "Ventil br 7", demiLinije.getJkkf02().getVent07(), img);
    }

    public void ProzorDL02JKKF08() {
        ProzorDL02JKKF08 = getPregradniVentilProzor(ProzorDL02JKKF08, "Demi linija 2", "Ventil br 8", demiLinije.getJkkf02().getVent08(), img);
    }

    public void ProzorDL02JKKF09() {
        ProzorDL02JKKF09 = getPregradniVentilProzor(ProzorDL02JKKF09, "Demi linija 2", "Ventil br 9", demiLinije.getJkkf02().getVent09(), img);
    }

    public void ProzorDL02JKKF10() {
        ProzorDL02JKKF10 = getPregradniVentilProzor(ProzorDL02JKKF10, "Demi linija 2", "Ventil br 10", demiLinije.getJkkf02().getVent10(), img);
    }

    public void ProzorDL02JKKF11() {
        ProzorDL02JKKF11 = getPregradniVentilProzor(ProzorDL02JKKF11, "Demi linija 2", "Ventil br 11", demiLinije.getJkkf02().getVent11(), img);
    }

    public void ProzorDL02JKKF12() {
        ProzorDL02JKKF12 = getPregradniVentilProzor(ProzorDL02JKKF12, "Demi linija 2", "Ventil br 12", demiLinije.getJkkf02().getVent12(), img);
    }

    public void ProzorDL02SBA01() {
        ProzorDL02SBA01 = getPregradniVentilProzor(ProzorDL02SBA01, "Demi linija 2", "Ventil br 01", demiLinije.getSbaf02().getVent01(), img);
    }

    public void ProzorDL02SBA02() {

        ProzorDL02SBA02 = getPregradniVentilProzor(ProzorDL02SBA02, "Demi linija 2", "Ventil br 02", demiLinije.getSbaf02().getVent02(), img);

    }

    public void ProzorDL02SBA03() {
        ProzorDL02SBA03 = getPregradniVentilProzor(ProzorDL02SBA03, "Demi linija 2", "Ventil br 03", demiLinije.getSbaf02().getVent03(), img);
    }

    public void ProzorDL02SBA04() {
        ProzorDL02SBA04 = getPregradniVentilProzor(ProzorDL02SBA04, "Demi linija 2", "Ventil br 04", demiLinije.getSbaf02().getVent04(), img);
    }

    public void ProzorDL02SBA05() {
        ProzorDL02SBA05 = getPregradniVentilProzor(ProzorDL02SBA05, "Demi linija 2", "Ventil br 05", demiLinije.getSbaf02().getVent05(), img);
    }

    public void ProzorDL02SBA06() {
        ProzorDL02SBA06 = getPregradniVentilProzor(ProzorDL02SBA06, "Demi linija 2", "Ventil br 06", demiLinije.getSbaf02().getVent06(), img);
    }

    public void ProzorDL02JBA01() {
        ProzorDL02JBA01 = getPregradniVentilProzor(ProzorDL02JBA01, "Demi linija 2", "Ventil br 01", demiLinije.getJbaf02().getVent01(), img);
    }

    public void ProzorDL02JBA02() {
        ProzorDL02JBA02 = getPregradniVentilProzor(ProzorDL02JBA02, "Demi linija 2", "Ventil br 02", demiLinije.getJbaf02().getVent02(), img);
    }

    public void ProzorDL02JBA03() {
        ProzorDL02JBA03 = getPregradniVentilProzor(ProzorDL02JBA03, "Demi linija 2", "Ventil br 03", demiLinije.getJbaf02().getVent03(), img);
    }

    public void ProzorDL02JBA04() {
        ProzorDL02JBA04 = getPregradniVentilProzor(ProzorDL02JBA04, "Demi linija 2", "Ventil br 04", demiLinije.getJbaf02().getVent04(), img);
    }

    public void ProzorDL02JBA05() {
        ProzorDL02JBA05 = getPregradniVentilProzor(ProzorDL02JBA05, "Demi linija 2", "Ventil br 05", demiLinije.getJbaf02().getVent05(), img);
    }

    public void ProzorDL02JBA06() {
        ProzorDL02JBA06 = getPregradniVentilProzor(ProzorDL02JBA06, "Demi linija 2", "Ventil br 06", demiLinije.getJbaf02().getVent06(), img);
    }

    public void ProzorDL02JBA07() {
        ProzorDL02JBA07 = getPregradniVentilProzor(ProzorDL02JBA07, "Demi linija 2", "Ventil br 07", demiLinije.getJbaf02().getVent07(), img);
    }

    public void ProzorDL02JBA08() {
        ProzorDL02JBA08 = getPregradniVentilProzor(ProzorDL02JBA08, "Demi linija 2", "Ventil br 03", demiLinije.getJbaf02().getVent08(), img);
    }

    public void ProzorDL02MF01() {
        ProzorDL02MF01 = getPregradniVentilProzor(ProzorDL02MF01, "Demi linija 2", "Ventil br 01", demiLinije.getMf02().getVent01(), img);
    }

    public void ProzorDL02MF02() {
        ProzorDL02MF02 = getPregradniVentilProzor(ProzorDL02MF02, "Demi linija 2", "Ventil br 02", demiLinije.getMf02().getVent02(), img);
    }

    public void ProzorDL02MF03() {
        ProzorDL02MF03 = getPregradniVentilProzor(ProzorDL02MF03, "Demi linija 2", "Ventil br 03", demiLinije.getMf02().getVent03(), img);
    }

    public void ProzorDL02MF04() {
        ProzorDL02MF04 = getPregradniVentilProzor(ProzorDL02MF04, "Demi linija 2", "Ventil br 04", demiLinije.getMf02().getVent04(), img);
    }

    public void ProzorDL02MF05() {
        ProzorDL02MF05 = getPregradniVentilProzor(ProzorDL02MF05, "Demi linija 2", "Ventil br 05", demiLinije.getMf02().getVent05(), img);
    }

    public void ProzorDL02MF06() {
        ProzorDL02MF06 = getPregradniVentilProzor(ProzorDL02MF06, "Demi linija 2", "Ventil br 06", demiLinije.getMf02().getVent06(), img);
    }

    public void ProzorDL02MF07() {
        ProzorDL02MF07 = getPregradniVentilProzor(ProzorDL02MF07, "Demi linija 2", "Ventil br 07", demiLinije.getMf02().getVent07(), img);
    }

    public void ProzorDL02MF08() {
        ProzorDL02MF08 = getPregradniVentilProzor(ProzorDL02MF08, "Demi linija 2", "Ventil br 08", demiLinije.getMf02().getVent08(), img);
    }

    public void ProzorDL02MF10() {
        ProzorDL02MF10 = getPregradniVentilProzor(ProzorDL02MF10, "Demi linija 2", "Ventil br 10", demiLinije.getMf02().getVent10(), img);
    }

    public void ProzorDL02MF11() {
        ProzorDL02MF11 = getPregradniVentilProzor(ProzorDL02MF11, "Demi linija 2", "Ventil br 11", demiLinije.getMf02().getVent11(), img);
    }

    public void ProzorPumpaFerihloridBr1() {
        ProzorPumpaFerihloridBr1 = getProzorPumpaFrekfrentni(ProzorPumpaFerihloridBr1, "Ferihlorid", "Pumpa br 1", pumpeFerihlorid.getPumpaBr1(), img);
    }

    public void ProzorPumpaFerihloridBr2() {
        ProzorPumpaFerihloridBr2 = getProzorPumpaFrekfrentni(ProzorPumpaFerihloridBr2, "Ferihlorid", "Pumpa br 2", pumpeFerihlorid.getPumpaBr2(), img);
    }

    public void ProzorPumpaFerihloridBr3() {
        ProzorPumpaFerihloridBr3 = getProzorPumpaFrekfrentni(ProzorPumpaFerihloridBr3, "Ferihlorid", "Pumpa br 3", pumpeFerihlorid.getPumpaBr3(), img);
    }

    public void ProzorPumpaPolielektrolitBr1() {
        ProzorPumpaPolielektrolitBr1 = getProzorPumpaFrekfrentni(ProzorPumpaPolielektrolitBr1, "Polielektrolit", "Pumpa br 1", pumpePolielektrolit.getPumpaBr1(), img);
    }

    public void ProzorPumpaPolielektrolitBr2() {
        ProzorPumpaPolielektrolitBr2 = getProzorPumpaFrekfrentni(ProzorPumpaPolielektrolitBr2, "Polielektrolit", "Pumpa br 2", pumpePolielektrolit.getPumpaBr2(), img);
    }

    public void ProzorPumpaPolielektrolitBr3() {
        ProzorPumpaPolielektrolitBr3 = getProzorPumpaFrekfrentni(ProzorPumpaPolielektrolitBr3, "Polielektrolit", "Pumpa br 3", pumpePolielektrolit.getPumpaBr3(), img);
    }

    public void ProzorDL03JKKF03() {
        ProzorDL03JKKF03 = getPregradniVentilProzor(ProzorDL03JKKF03, "Demi linija 3", "Ventil br 3", demiLinije.getJkkf03().getVent03(), img);
    }

    public void ProzorDL03JKKF04() {
        ProzorDL03JKKF04 = getPregradniVentilProzor(ProzorDL03JKKF04, "Demi linija 3", "Ventil br 4", demiLinije.getJkkf03().getVent04(), img);
    }

    public void ProzorDL03JKKF05() {
        ProzorDL03JKKF05 = getPregradniVentilProzor(ProzorDL03JKKF05, "Demi linija 3", "Ventil br 5", demiLinije.getJkkf03().getVent05(), img);
    }

    public void ProzorDL03JKKF06() {
        ProzorDL03JKKF06 = getPregradniVentilProzor(ProzorDL03JKKF06, "Demi linija 3", "Ventil br 6", demiLinije.getJkkf03().getVent06(), img);
    }

    public void ProzorDL03JKKF07() {
        ProzorDL03JKKF07 = getPregradniVentilProzor(ProzorDL03JKKF07, "Demi linija 3", "Ventil br 7", demiLinije.getJkkf03().getVent07(), img);
    }

    public void ProzorDL03JKKF08() {
        ProzorDL03JKKF08 = getPregradniVentilProzor(ProzorDL03JKKF08, "Demi linija 3", "Ventil br 8", demiLinije.getJkkf03().getVent08(), img);
    }

    public void ProzorDL03JKKF09() {
        ProzorDL03JKKF09 = getPregradniVentilProzor(ProzorDL03JKKF09, "Demi linija 3", "Ventil br 9", demiLinije.getJkkf03().getVent09(), img);
    }

    public void ProzorDL03JKKF10() {
        ProzorDL03JKKF10 = getPregradniVentilProzor(ProzorDL03JKKF10, "Demi linija 3", "Ventil br 10", demiLinije.getJkkf03().getVent10(), img);
    }

    public void ProzorDL03JKKF11() {
        ProzorDL03JKKF11 = getPregradniVentilProzor(ProzorDL03JKKF11, "Demi linija 3", "Ventil br 11", demiLinije.getJkkf03().getVent11(), img);
    }

    public void ProzorDL03JKKF12() {
        ProzorDL03JKKF12 = getPregradniVentilProzor(ProzorDL03JKKF12, "Demi linija 3", "Ventil br 12", demiLinije.getJkkf03().getVent12(), img);
    }

    public void ProzorDL03SBA01() {
        ProzorDL03SBA01 = getPregradniVentilProzor(ProzorDL03SBA01, "Demi linija 3", "Ventil br 01", demiLinije.getSbaf03().getVent01(), img);
    }

    public void ProzorDL03SBA02() {
        ProzorDL03SBA02 = getPregradniVentilProzor(ProzorDL03SBA02, "Demi linija 3", "Ventil br 02", demiLinije.getSbaf03().getVent02(), img);
    }

    public void ProzorDL03SBA03() {
        ProzorDL03SBA03 = getPregradniVentilProzor(ProzorDL03SBA03, "Demi linija 3", "Ventil br 03", demiLinije.getSbaf03().getVent03(), img);
    }

    public void ProzorDL03SBA04() {
        ProzorDL03SBA04 = getPregradniVentilProzor(ProzorDL03SBA04, "Demi linija 3", "Ventil br 04", demiLinije.getSbaf03().getVent04(), img);
    }

    public void ProzorDL03SBA05() {
        ProzorDL03SBA05 = getPregradniVentilProzor(ProzorDL03SBA05, "Demi linija 3", "Ventil br 05", demiLinije.getSbaf03().getVent05(), img);
    }

    public void ProzorDL03SBA06() {
        ProzorDL03SBA06 = getPregradniVentilProzor(ProzorDL03SBA06, "Demi linija 3", "Ventil br 06", demiLinije.getSbaf03().getVent06(), img);
    }

    public void ProzorDL03JBA01() {
        ProzorDL03JBA01 = getPregradniVentilProzor(ProzorDL03JBA01, "Demi linija 3", "Ventil br 01", demiLinije.getJbaf03().getVent01(), img);
    }

    public void ProzorDL03JBA02() {
        ProzorDL03JBA02 = getPregradniVentilProzor(ProzorDL03JBA02, "Demi linija 3", "Ventil br 02", demiLinije.getJbaf03().getVent02(), img);
    }

    public void ProzorDL03JBA03() {
        ProzorDL03JBA03 = getPregradniVentilProzor(ProzorDL03JBA03, "Demi linija 3", "Ventil br 03", demiLinije.getJbaf03().getVent03(), img);
    }

    public void ProzorDL03JBA04() {
        ProzorDL03JBA04 = getPregradniVentilProzor(ProzorDL03JBA04, "Demi linija 3", "Ventil br 04", demiLinije.getJbaf03().getVent04(), img);
    }

    public void ProzorDL03JBA05() {
        ProzorDL03JBA05 = getPregradniVentilProzor(ProzorDL03JBA05, "Demi linija 3", "Ventil br 05", demiLinije.getJbaf03().getVent05(), img);
    }

    public void ProzorDL03JBA06() {
        ProzorDL03JBA06 = getPregradniVentilProzor(ProzorDL03JBA06, "Demi linija 3", "Ventil br 06", demiLinije.getJbaf03().getVent06(), img);
    }

    public void ProzorDL03JBA07() {
        ProzorDL03JBA07 = getPregradniVentilProzor(ProzorDL03JBA07, "Demi linija 3", "Ventil br 07", demiLinije.getJbaf03().getVent07(), img);
    }

    public void ProzorDL03JBA08() {
        ProzorDL03JBA08 = getPregradniVentilProzor(ProzorDL03JBA08, "Demi linija 3", "Ventil br 08", demiLinije.getJbaf03().getVent08(), img);
    }

    public void ProzorDL03MF01() {
        ProzorDL03MF01 = getPregradniVentilProzor(ProzorDL03MF01, "Demi linija 3", "Ventil br 01", demiLinije.getMf03().getVent01(), img);
    }

    public void ProzorDL03MF02() {
        ProzorDL03MF02 = getPregradniVentilProzor(ProzorDL03MF02, "Demi linija 3", "Ventil br 02", demiLinije.getMf03().getVent02(), img);
    }

    public void ProzorDL03MF03() {
        ProzorDL03MF03 = getPregradniVentilProzor(ProzorDL03MF03, "Demi linija 3", "Ventil br 03", demiLinije.getMf03().getVent03(), img);
    }

    public void ProzorDL03MF04() {
        ProzorDL03MF04 = getPregradniVentilProzor(ProzorDL03MF04, "Demi linija 3", "Ventil br 04", demiLinije.getMf03().getVent04(), img);
    }

    public void ProzorDL03MF05() {
        ProzorDL03MF05 = getPregradniVentilProzor(ProzorDL03MF05, "Demi linija 3", "Ventil br 05", demiLinije.getMf03().getVent05(), img);
    }

    public void ProzorDL03MF06() {
        ProzorDL03MF06 = getPregradniVentilProzor(ProzorDL03MF06, "Demi linija 3", "Ventil br 06", demiLinije.getMf03().getVent06(), img);
    }

    public void ProzorDL03MF07() {
        ProzorDL03MF07 = getPregradniVentilProzor(ProzorDL03MF07, "Demi linija 3", "Ventil br 07", demiLinije.getMf03().getVent07(), img);
    }

    public void ProzorDL03MF08() {
        ProzorDL03MF08 = getPregradniVentilProzor(ProzorDL03MF08, "Demi linija 3", "Ventil br 08", demiLinije.getMf03().getVent08(), img);
    }

    public void ProzorDL03MF10() {
        ProzorDL03MF10 = getPregradniVentilProzor(ProzorDL03MF10, "Demi linija 3", "Ventil br 10", demiLinije.getMf03().getVent10(), img);
    }

    public void ProzorDL03MF11() {
        ProzorDL03MF11 = getPregradniVentilProzor(ProzorDL03MF11, "Demi linija 3", "Ventil br 11", demiLinije.getMf03().getVent11(), img);
    }

    public void ProzorHClvoda() {
        ProzorHClvoda = getRegulacioniVentilProzor(ProzorHClvoda, "Razblazivanje HCl", "regulacioni ventil", regeneracija.getRegVentHCl(), protociRegeneracija.getProtokDemiVodeRazblazivanjeHCL());
    }

    public void ProzorNaOHvoda() {
        ProzorNaOHvoda = getRegulacioniVentilProzor(ProzorNaOHvoda, "Razblazivanje NaOH", "regulacioni ventil", regeneracija.getRegVentNaOH(), protociRegeneracija.getProtokDemiVodeRazblazivanjeNaOH());
    }

    private PregradniVentilScreen getPregradniVentilProzor(PregradniVentilScreen prozor, String grupa, String opis, PregradniVentili ventil, Img img) {
        Point p = GetMousePoint(MouseInfo.getPointerInfo().getLocation());
        boolean show = true;
        if (prozor == null) {
            prozor = new PregradniVentilScreen(p.x, p.y, grupa, opis, ventil, img, pregVentService);
            show = false;
        } 

        prozor.startTimer(show);
        prozor.setLocation(p);
        prozor.setVisible(show);
        return prozor;
    }

    private RegulacioniVentilScreen getRegulacioniVentilProzor(RegulacioniVentilScreen prozor, String grupa, String opis, RegulacioniVentili ventil, Protok protok) {
        Point p = GetMousePoint(MouseInfo.getPointerInfo().getLocation());
        boolean show = true;
        if (prozor == null) {
            prozor = new RegulacioniVentilScreen(p.x, p.y, grupa, opis, ventil, protok);
            show = false;
        } 

        prozor.startTimer(show);
        prozor.setLocation(p);
        prozor.setVisible(show);
        return prozor;
    }

    private PumpeScreen getPumpeProzor(PumpeScreen prozor, String grupa, String opis, ElcM pumpa, Img img) {
        Point p = GetMousePoint(MouseInfo.getPointerInfo().getLocation());
        boolean show = true;
        if (prozor == null) {
            prozor = new PumpeScreen(p.x, p.y, grupa, opis, pumpa, img);
            show = false;
        } 

        prozor.startTimer(show);
        prozor.setLocation(p);
        prozor.setVisible(show);
        return prozor;
    }
    
    private PumpeSaZastitomScreen getPumpeProzorSaZastitom(PumpeSaZastitomScreen prozor, String grupa, String opis, ElcM pumpa, Img img, Merenja merenja) {
        Point p = GetMousePoint(MouseInfo.getPointerInfo().getLocation());
        boolean show = true;
        if (prozor == null) {
            prozor = new PumpeSaZastitomScreen(p.x, p.y, grupa, opis, pumpa, img, merenja);
            show = false;
        } 

        prozor.startTimer(show);
        prozor.setLocation(p);
        prozor.setVisible(show);
        return prozor;
    }

    public PumpeFrScreen getProzorPumpaFrekfrentni(PumpeFrScreen prozor, String grupa, String opis, FrElcM pumpa, Img img) {
        Point p = GetMousePoint(MouseInfo.getPointerInfo().getLocation());
        boolean show = true;
        if (prozor == null) {
            prozor = new PumpeFrScreen(p.x, p.y, grupa, opis, pumpa, img);
            show = false;
        } 
   
        prozor.startTimer(show);
        prozor.setLocation(p);
        prozor.setVisible(show);
        return prozor;
    }

    //Reaktor br 1
    private RegulacioniVentilElMotorScreen getProzorRegEMVent(RegulacioniVentilElMotorScreen prozor, String grupa, String opis, RegulacioniElMotVentil ventil, Protok protok) {
        Point p = GetMousePoint(MouseInfo.getPointerInfo().getLocation());
        boolean show = true;
        if (prozor == null) {
            prozor = new RegulacioniVentilElMotorScreen(p.x, p.y, grupa, opis, ventil, protok);
            show = false;
        } 
    
        prozor.startTimer(show);
        prozor.setLocation(p);
        prozor.setVisible(show);
        return prozor;
    }
    
    private RegulacioniVentilElMotorImagPolozajScreen getProzorRegEMVentSaEstimaciom(RegulacioniVentilElMotorImagPolozajScreen prozor, String grupa, String opis, RegulacioniElMotVentil ventil, Protok protok) {
        Point p = GetMousePoint(MouseInfo.getPointerInfo().getLocation());
        boolean show = true;
        if (prozor == null) {
            prozor = new RegulacioniVentilElMotorImagPolozajScreen(p.x, p.y, grupa, opis, ventil, protok);
            show = false;
        } 
    
        prozor.startTimer(show);
        prozor.setLocation(p);
        prozor.setVisible(show);
        return prozor;
    }
    
}