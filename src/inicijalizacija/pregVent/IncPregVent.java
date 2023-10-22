/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicijalizacija.pregVent;

import dbService.PregVentService;
import field.ventili.DemiLinije;
import field.ventili.VentiliFerihlorid;
import field.ventili.VentiliGrupaPumpi;
import field.ventili.JonskaIzmena;
import field.ventili.PescaniFilteri;
import field.ventili.VentiliPolielektrolit;
import field.ventili.Reaktor;
import field.ventili.Regeneracija;
import field.ventili.VentiliKaPescanimFilterima;
import field.ventili.pescaniFilter.OtpadneVodeOdPescanihFiltera;
import field.ventili.pescaniFilter.PranjePescanihFiltera;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import valve.globe.PregradniVentili;

/**
 *
 * @author branko.scekic
 */
public class IncPregVent {

    public IncPregVent(
            DemiLinije demiLinije,
            VentiliFerihlorid ventiliFerihlorid,
            VentiliGrupaPumpi ventiliGrupaPumpi,
            JonskaIzmena jonskaIzmena,
            PescaniFilteri pescaniFilteri,
            VentiliPolielektrolit ventiliPolielektrolit,
            Reaktor reaktor,
            Regeneracija regeneracija,
            VentiliKaPescanimFilterima ventiliKaPescanimFilterima,
            OtpadneVodeOdPescanihFiltera otpadneVodeOdPescanihFiltera,
            PranjePescanihFiltera pranjePescanihFiltera,
            PregVentService pregVentService) 
    {

        this.demiLinije = demiLinije;
        this.ventiliFerihlorid = ventiliFerihlorid;
        this.ventiliGrupaPumpi = ventiliGrupaPumpi;
        this.jonskaIzmena = jonskaIzmena;
        this.pescaniFilteri = pescaniFilteri;
        this.ventiliPolielektrolit = ventiliPolielektrolit;
        this.reaktor = reaktor;
        this.regeneracija = regeneracija;
        this.ventiliKaPescanimFilterima = ventiliKaPescanimFilterima;
        this.otpadneVodeOdPescanihFiltera = otpadneVodeOdPescanihFiltera;
        this.pranjePescanihFiltera = pranjePescanihFiltera;
        this.pregVentService = pregVentService;
    }

    public void inicVentile() {     
            demiLinija1();
            demiLinija2();
            demiLinija3();

            ferihlorid();
            pescaniFilter1();
            pescaniFilter2();
            pescaniFilter3();
            pescaniFilter4();
            pescaniFilter5();
            pescaniFilter6();

            jonskaIzmena1();
            jonskaIzmena2();
            jonskaIzmena3();

            getRegeneracija();
            otpadneVodeOdPescanihFiltera();
            ventiliPumpe();
            polielektrolit();
    }

    private final DemiLinije demiLinije;
    private final VentiliFerihlorid ventiliFerihlorid;
    private final VentiliGrupaPumpi ventiliGrupaPumpi;
    private final JonskaIzmena jonskaIzmena;
    private final PescaniFilteri pescaniFilteri;
    private final VentiliPolielektrolit ventiliPolielektrolit;
    private final Reaktor reaktor;
    private final Regeneracija regeneracija;
    private final VentiliKaPescanimFilterima ventiliKaPescanimFilterima;
    private final OtpadneVodeOdPescanihFiltera otpadneVodeOdPescanihFiltera;
    private final PranjePescanihFiltera pranjePescanihFiltera;

    private final PregVentService pregVentService;
    private db.Pregvent vent;

    private void demiLinija1() {
        demiLinije.getJkkf01().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf01().getVent03())));

        demiLinije.getJkkf01().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf01().getVent04())));

        demiLinije.getJkkf01().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf01().getVent05())));

        demiLinije.getJkkf01().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf01().getVent06())));

        demiLinije.getJkkf01().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf01().getVent07())));

        demiLinije.getJkkf01().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf01().getVent08())));

        demiLinije.getJkkf01().getVent09().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf01().getVent09())));

        demiLinije.getJkkf01().getVent10().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf01().getVent10())));

        demiLinije.getJkkf01().getVent11().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf01().getVent11())));

        demiLinije.getJkkf01().getVent12().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf01().getVent12())));

        demiLinije.getSbaf01().getVent01().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf01().getVent01())));

        demiLinije.getSbaf01().getVent02().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf01().getVent02())));

        demiLinije.getSbaf01().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf01().getVent03())));

        demiLinije.getSbaf01().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf01().getVent04())));

        demiLinije.getSbaf01().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf01().getVent05())));

        demiLinije.getSbaf01().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf01().getVent06())));

        demiLinije.getJbaf01().getVent01().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf01().getVent01())));

        demiLinije.getJbaf01().getVent02().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf01().getVent02())));

        demiLinije.getJbaf01().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf01().getVent03())));

        demiLinije.getJbaf01().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf01().getVent04())));

        demiLinije.getJbaf01().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf01().getVent05())));

        demiLinije.getJbaf01().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf01().getVent06())));

        demiLinije.getJbaf01().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf01().getVent07())));

        demiLinije.getJbaf01().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf01().getVent08())));

        demiLinije.getMf01().getVent01().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf01().getVent01())));

        demiLinije.getMf01().getVent02().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf01().getVent02())));

        demiLinije.getMf01().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf01().getVent03())));

        demiLinije.getMf01().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf01().getVent04())));

        demiLinije.getMf01().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf01().getVent05())));

        demiLinije.getMf01().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf01().getVent06())));

        demiLinije.getMf01().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf01().getVent07())));

        demiLinije.getMf01().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf01().getVent08())));

        demiLinije.getMf01().getVent10().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf01().getVent10())));

        demiLinije.getMf01().getVent11().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf01().getVent11())));

    }

    private void demiLinija2() {
        demiLinije.getJkkf02().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf02().getVent03())));

        demiLinije.getJkkf02().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf02().getVent04())));

        demiLinije.getJkkf02().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf02().getVent05())));

        demiLinije.getJkkf02().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf02().getVent06())));

        demiLinije.getJkkf02().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf02().getVent07())));

        demiLinije.getJkkf02().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf02().getVent08())));

        demiLinije.getJkkf02().getVent09().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf02().getVent09())));

        demiLinije.getJkkf02().getVent10().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf02().getVent10())));

        demiLinije.getJkkf02().getVent11().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf02().getVent11())));

        demiLinije.getJkkf02().getVent12().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf02().getVent12())));

        demiLinije.getSbaf02().getVent01().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf02().getVent01())));

        demiLinije.getSbaf02().getVent02().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf02().getVent02())));

        demiLinije.getSbaf02().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf02().getVent03())));

        demiLinije.getSbaf02().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf02().getVent04())));

        demiLinije.getSbaf02().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf02().getVent05())));

        demiLinije.getSbaf02().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf02().getVent06())));

        demiLinije.getJbaf02().getVent01().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf02().getVent01())));

        demiLinije.getJbaf02().getVent02().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf02().getVent02())));

        demiLinije.getJbaf02().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf02().getVent03())));

        demiLinije.getJbaf02().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf02().getVent04())));

        demiLinije.getJbaf02().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf02().getVent05())));

        demiLinije.getJbaf02().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf02().getVent06())));

        demiLinije.getJbaf02().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf02().getVent07())));

        demiLinije.getJbaf02().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf02().getVent08())));

        demiLinije.getMf02().getVent01().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf02().getVent01())));

        demiLinije.getMf02().getVent02().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf02().getVent02())));

        demiLinije.getMf02().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf02().getVent03())));

        demiLinije.getMf02().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf02().getVent04())));

        demiLinije.getMf02().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf02().getVent05())));

        demiLinije.getMf02().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf02().getVent06())));

        demiLinije.getMf02().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf02().getVent07())));

        demiLinije.getMf02().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf02().getVent08())));

        demiLinije.getMf02().getVent10().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf02().getVent10())));

        demiLinije.getMf02().getVent11().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf02().getVent11())));

    }

    private void demiLinija3() {
        demiLinije.getJkkf03().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf03().getVent03())));
        demiLinije.getJkkf03().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf03().getVent04())));

        demiLinije.getJkkf03().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf03().getVent05())));

        demiLinije.getJkkf03().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf03().getVent06())));

        demiLinije.getJkkf03().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf03().getVent07())));

        demiLinije.getJkkf03().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf03().getVent08())));

        demiLinije.getJkkf03().getVent09().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf03().getVent09())));

        demiLinije.getJkkf03().getVent10().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf03().getVent10())));
        demiLinije.getJkkf03().getVent11().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf03().getVent11())));

        demiLinije.getJkkf03().getVent12().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJkkf03().getVent12())));

        demiLinije.getSbaf03().getVent01().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf03().getVent01())));

        demiLinije.getSbaf03().getVent02().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf03().getVent02())));

        demiLinije.getSbaf03().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf03().getVent03())));

        demiLinije.getSbaf03().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf03().getVent04())));

        demiLinije.getSbaf03().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf03().getVent05())));

        demiLinije.getSbaf03().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getSbaf03().getVent06())));

        demiLinije.getJbaf03().getVent01().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf03().getVent01())));

        demiLinije.getJbaf03().getVent02().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf03().getVent02())));

        demiLinije.getJbaf03().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf03().getVent03())));

        demiLinije.getJbaf03().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf03().getVent04())));

        demiLinije.getJbaf03().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf03().getVent05())));

        demiLinije.getJbaf03().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf03().getVent06())));

        demiLinije.getJbaf03().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf03().getVent07())));

        demiLinije.getJbaf03().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getJbaf03().getVent08())));

        demiLinije.getMf03().getVent01().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf03().getVent01())));

        demiLinije.getMf03().getVent02().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf03().getVent02())));

        demiLinije.getMf03().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf03().getVent03())));

        demiLinije.getMf03().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf03().getVent04())));

        demiLinije.getMf03().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf03().getVent05())));

        demiLinije.getMf03().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf03().getVent06())));

        demiLinije.getMf03().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf03().getVent07())));

        demiLinije.getMf03().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf03().getVent08())));

        demiLinije.getMf03().getVent10().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf03().getVent10())));

        demiLinije.getMf03().getVent11().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((demiLinije.getMf03().getVent11())));

    }

    private void ferihlorid() {

        ventiliFerihlorid.getFCl_kompenzaciona1().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((ventiliFerihlorid.getFCl_kompenzaciona1())));

        ventiliFerihlorid.getFCl_kompenzaciona2().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((ventiliFerihlorid.getFCl_kompenzaciona2())));

        ventiliFerihlorid.getFCl_posuda1().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((ventiliFerihlorid.getFCl_posuda1())));

        ventiliFerihlorid.getFCl_posuda2().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((ventiliFerihlorid.getFCl_posuda2())));

        ventiliFerihlorid.getFCl_ventil1().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((ventiliFerihlorid.getFCl_ventil1())));

        ventiliFerihlorid.getFCl_ventil2().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((ventiliFerihlorid.getFCl_ventil2())));

        ventiliFerihlorid.getFCl_ventil3().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((ventiliFerihlorid.getFCl_ventil3())));
    }

    private void pescaniFilter1() {

        pescaniFilteri.getPf1().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf1().getVent03())));

        pescaniFilteri.getPf1().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf1().getVent04())));

        pescaniFilteri.getPf1().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf1().getVent05())));

        pescaniFilteri.getPf1().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf1().getVent06())));

        pescaniFilteri.getPf1().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf1().getVent07())));

        pescaniFilteri.getPf1().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf1().getVent08())));

        pescaniFilteri.getPf1().getVent09().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf1().getVent09())));

        pescaniFilteri.getPf1().getVent10().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf1().getVent10())));
    }

    private void pescaniFilter2() {

        pescaniFilteri.getPf2().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf2().getVent03())));

        pescaniFilteri.getPf2().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf2().getVent04())));

        pescaniFilteri.getPf2().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf2().getVent05())));

        pescaniFilteri.getPf2().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf2().getVent06())));

        pescaniFilteri.getPf2().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf2().getVent07())));

        pescaniFilteri.getPf2().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf2().getVent08())));

        pescaniFilteri.getPf2().getVent09().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf2().getVent09())));

        pescaniFilteri.getPf2().getVent10().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf2().getVent10())));
    }

    private void pescaniFilter3() {

        pescaniFilteri.getPf3().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf3().getVent03())));

        pescaniFilteri.getPf3().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf3().getVent04())));

        pescaniFilteri.getPf3().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf3().getVent05())));

        pescaniFilteri.getPf3().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf3().getVent06())));

        pescaniFilteri.getPf3().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf3().getVent07())));

        pescaniFilteri.getPf3().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf3().getVent08())));

        pescaniFilteri.getPf3().getVent09().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf3().getVent09())));

        pescaniFilteri.getPf3().getVent10().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf3().getVent10())));
    }

    private void pescaniFilter4() {

        pescaniFilteri.getPf4().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf4().getVent03())));

        pescaniFilteri.getPf4().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf4().getVent04())));

        pescaniFilteri.getPf4().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf4().getVent05())));

        pescaniFilteri.getPf4().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf4().getVent06())));

        pescaniFilteri.getPf4().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf4().getVent07())));

        pescaniFilteri.getPf4().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf4().getVent08())));

        pescaniFilteri.getPf4().getVent09().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf4().getVent09())));

        pescaniFilteri.getPf4().getVent10().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf4().getVent10())));
    }

    private void pescaniFilter5() {

        pescaniFilteri.getPf5().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf5().getVent03())));

        pescaniFilteri.getPf5().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf5().getVent04())));

        pescaniFilteri.getPf5().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf5().getVent05())));

        pescaniFilteri.getPf5().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf5().getVent06())));

        pescaniFilteri.getPf5().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf5().getVent07())));

        pescaniFilteri.getPf5().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf5().getVent08())));

        pescaniFilteri.getPf5().getVent09().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf5().getVent09())));

        pescaniFilteri.getPf5().getVent10().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf5().getVent10())));
    }

    private void pescaniFilter6() {

        pescaniFilteri.getPf6().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf6().getVent03())));

        pescaniFilteri.getPf6().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf6().getVent04())));

        pescaniFilteri.getPf6().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf6().getVent05())));

        pescaniFilteri.getPf6().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf6().getVent06())));

        pescaniFilteri.getPf6().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf6().getVent07())));

        pescaniFilteri.getPf6().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf6().getVent08())));

        pescaniFilteri.getPf6().getVent09().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf6().getVent09())));

        pescaniFilteri.getPf6().getVent10().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((pescaniFilteri.getPf6().getVent10())));
    }

    private void otpadneVodeOdPescanihFiltera() {
        otpadneVodeOdPescanihFiltera.getVent01().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((otpadneVodeOdPescanihFiltera.getVent01())));

        otpadneVodeOdPescanihFiltera.getVent02().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((otpadneVodeOdPescanihFiltera.getVent02())));
    }

    private void jonskaIzmena1() {
        jonskaIzmena.getJonskaIzmena01().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena01().getVent03())));

        jonskaIzmena.getJonskaIzmena01().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena01().getVent04())));

        jonskaIzmena.getJonskaIzmena01().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena01().getVent05())));

        jonskaIzmena.getJonskaIzmena01().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena01().getVent06())));

        jonskaIzmena.getJonskaIzmena01().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena01().getVent07())));

        jonskaIzmena.getJonskaIzmena01().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena01().getVent08())));

        jonskaIzmena.getJonskaIzmena01().getVent09().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena01().getVent09())));

        jonskaIzmena.getJonskaIzmena01().getVent10().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena01().getVent10())));
    }

    private void jonskaIzmena2() {
        jonskaIzmena.getJonskaIzmena02().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena02().getVent03())));

        jonskaIzmena.getJonskaIzmena02().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena02().getVent04())));

        jonskaIzmena.getJonskaIzmena02().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena02().getVent05())));

        jonskaIzmena.getJonskaIzmena02().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena02().getVent06())));

        jonskaIzmena.getJonskaIzmena02().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena02().getVent07())));

        jonskaIzmena.getJonskaIzmena02().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena02().getVent08())));

        jonskaIzmena.getJonskaIzmena02().getVent09().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena02().getVent09())));

        jonskaIzmena.getJonskaIzmena02().getVent10().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena02().getVent10())));
    }

    private void jonskaIzmena3() {
        jonskaIzmena.getJonskaIzmena03().getVent03().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena03().getVent03())));

        jonskaIzmena.getJonskaIzmena03().getVent04().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena03().getVent04())));

        jonskaIzmena.getJonskaIzmena03().getVent05().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena03().getVent05())));

        jonskaIzmena.getJonskaIzmena03().getVent06().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena03().getVent06())));

        jonskaIzmena.getJonskaIzmena03().getVent07().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena03().getVent07())));

        jonskaIzmena.getJonskaIzmena03().getVent08().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena03().getVent08())));

        jonskaIzmena.getJonskaIzmena03().getVent09().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena03().getVent09())));

        jonskaIzmena.getJonskaIzmena03().getVent10().getVrednostiReg()
                .setPolozajVirtualno(fillDatabase((jonskaIzmena.getJonskaIzmena03().getVent10())));
    }

    private void getRegeneracija() {
        regeneracija.getVentHCLusisPumpeBr1().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((regeneracija.getVentHCLusisPumpeBr1())));

        regeneracija.getVentHCLpotisPumpeBr1().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((regeneracija.getVentHCLpotisPumpeBr1())));

        regeneracija.getVentHCLusisPumpeBr2().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((regeneracija.getVentHCLusisPumpeBr2())));

        regeneracija.getVentHCLpotisPumpeBr2().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((regeneracija.getVentHCLpotisPumpeBr2())));

        regeneracija.getVentHCLzajednickiUsis().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((regeneracija.getVentHCLzajednickiUsis())));

        regeneracija.getVentHCLzajednickiPotis().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((regeneracija.getVentHCLzajednickiPotis())));

        regeneracija.getVentNaOHusisPumpeBr1().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((regeneracija.getVentNaOHusisPumpeBr1())));

        regeneracija.getVentNaOHpotisPumpeBr1().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((regeneracija.getVentNaOHpotisPumpeBr1())));

        regeneracija.getVentNaOHusisPumpeBr2().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((regeneracija.getVentNaOHusisPumpeBr2())));

        regeneracija.getVentNaOHpotisPumpeBr2().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((regeneracija.getVentNaOHpotisPumpeBr2())));

        regeneracija.getVentNaOHzajednickiUsis().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((regeneracija.getVentNaOHzajednickiUsis())));

        regeneracija.getVentNaOHzajednickiPotis().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((regeneracija.getVentNaOHzajednickiPotis())));
    }

    private void ventiliPumpe() {
        ventiliGrupaPumpi.getGP01_potisDemi1().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliGrupaPumpi.getGP01_potisDemi1())));

        ventiliGrupaPumpi.getGP01_potisDemi2().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliGrupaPumpi.getGP01_potisDemi2())));

        ventiliGrupaPumpi.getGP01_potisDemi3().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliGrupaPumpi.getGP01_potisDemi3())));

        ventiliGrupaPumpi.getGP01_potisDemi4().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliGrupaPumpi.getGP01_potisDemi4())));

        ventiliGrupaPumpi.getGP01_potisDemi5().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliGrupaPumpi.getGP01_potisDemi5())));

        ventiliGrupaPumpi.getGP01_potisJonska1().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliGrupaPumpi.getGP01_potisJonska1())));

        ventiliGrupaPumpi.getGP01_potisJonska2().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliGrupaPumpi.getGP01_potisJonska2())));

        ventiliGrupaPumpi.getGP01_potisJonska3().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliGrupaPumpi.getGP01_potisJonska3())));

        pranjePescanihFiltera.getVent01().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((pranjePescanihFiltera.getVent01())));

        pranjePescanihFiltera.getVent02().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((pranjePescanihFiltera.getVent02())));

        ventiliKaPescanimFilterima.getAPKPF_PotisBr1().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliKaPescanimFilterima.getAPKPF_PotisBr1())));

        ventiliKaPescanimFilterima.getAPKPF_PotisBr2().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliKaPescanimFilterima.getAPKPF_PotisBr2())));

        ventiliKaPescanimFilterima.getAPKPF_PotisBr3().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliKaPescanimFilterima.getAPKPF_PotisBr3())));

        ventiliKaPescanimFilterima.getAPKPF_PotisBr4().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliKaPescanimFilterima.getAPKPF_PotisBr4())));

        ventiliKaPescanimFilterima.getAPKPF_PotisBr5().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliKaPescanimFilterima.getAPKPF_PotisBr5())));

        ventiliKaPescanimFilterima.getAPKPF_PotisBr6().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliKaPescanimFilterima.getAPKPF_PotisBr6())));

    }

    private void polielektrolit() {

        ventiliPolielektrolit.getPE_kompenzaciona1().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliPolielektrolit.getPE_kompenzaciona1())));

        ventiliPolielektrolit.getPE_kompenzaciona2().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliPolielektrolit.getPE_kompenzaciona2())));

        ventiliPolielektrolit.getPE_posuda1().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliPolielektrolit.getPE_posuda1())));

        ventiliPolielektrolit.getPE_posuda2().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliPolielektrolit.getPE_posuda2())));

        ventiliPolielektrolit.getPE_ventil1().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliPolielektrolit.getPE_ventil1())));

        ventiliPolielektrolit.getPE_ventil2().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliPolielektrolit.getPE_ventil2())));

        ventiliPolielektrolit.getPE_ventil3().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliPolielektrolit.getPE_ventil3())));

        ventiliPolielektrolit.getPE_vodaKaPosudi1().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliPolielektrolit.getPE_vodaKaPosudi1())));

        ventiliPolielektrolit.getPE_vodaKaPosudi2().getVrednostiReg().
                setPolozajVirtualno(fillDatabase((ventiliPolielektrolit.getPE_vodaKaPosudi2())));
    }

    private boolean fillDatabase(PregradniVentili ventil) {
        vent = pregVentService.getVentil(ventil.getTehnoloskaOznaka());
        if (vent.getTehozn() == null) {
            pregVentService.addNewVentil(ventil.getTehnoloskaOznaka(), "title", ventil.getOpis());
        }
        return vent.getVirtualno();
    }

}
