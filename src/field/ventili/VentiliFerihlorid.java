/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili;

import tools.MutantToDec;
import valve.globe.PregradniVentili;

/**
 *
 * @author branko.scekic
 */
public class VentiliFerihlorid {
    //ferihlorid
    private final PregradniVentili FCl_posuda1;
    private final PregradniVentili FCl_posuda2;
    private final PregradniVentili FCl_ventil1;
    private final PregradniVentili FCl_ventil2;
    private final PregradniVentili FCl_ventil3;
    private final PregradniVentili FCl_kompenzaciona1;
    private final PregradniVentili FCl_kompenzaciona2;
    
    public VentiliFerihlorid(){
        FCl_posuda1 = new PregradniVentili("03A0505", MutantToDec.getValue("278"), MutantToDec.getValue("279"), MutantToDec.getValue("27E"),
                MutantToDec.getValue("27F"), MutantToDec.getValue("280"), MutantToDec.getValue("281"), "Ventil na izlazu iz posude br 01 ferihlorid");
        FCl_posuda2 = new PregradniVentili("03A0605", MutantToDec.getValue("282"), MutantToDec.getValue("283"), MutantToDec.getValue("288"),
                MutantToDec.getValue("289"), MutantToDec.getValue("28A"), MutantToDec.getValue("28B"),"Ventil na izlazu iz posude br 02 ferihlorid");
        FCl_ventil1 = new PregradniVentili("03A0705", MutantToDec.getValue("296"), MutantToDec.getValue("297"), MutantToDec.getValue("29C"), 
                MutantToDec.getValue("29D"), MutantToDec.getValue("29E"), MutantToDec.getValue("29F"),"Ventil na potisu pumpe br 1");
        FCl_ventil2 = new PregradniVentili("03A0805", MutantToDec.getValue("30A"), MutantToDec.getValue("30B"), MutantToDec.getValue("310"),
                MutantToDec.getValue("311"), MutantToDec.getValue("312"), MutantToDec.getValue("313"),"Ventil na potisu pumpe br 2");
        FCl_ventil3 = new PregradniVentili("03A0905", MutantToDec.getValue("31E"), MutantToDec.getValue("31F"), MutantToDec.getValue("324"),
                MutantToDec.getValue("325"), MutantToDec.getValue("326"), MutantToDec.getValue("327"),"Ventil na potisu pumpe br 3");
        FCl_kompenzaciona1 = new PregradniVentili("03A0713", MutantToDec.getValue("328"), MutantToDec.getValue("329"), MutantToDec.getValue("32E"),
                MutantToDec.getValue("32F"), MutantToDec.getValue("330"), MutantToDec.getValue("331"),"Ventil na izlazu iz kompenzacione posude br 1");
        FCl_kompenzaciona2 = new PregradniVentili("03A0813", MutantToDec.getValue("332"), MutantToDec.getValue("333"), MutantToDec.getValue("338"),
                MutantToDec.getValue("339"), MutantToDec.getValue("33A"), MutantToDec.getValue("33B"),"Ventil na izlazu iz kompenzacione posude br 2");
    }

    public PregradniVentili getFCl_posuda1() {
        return FCl_posuda1;
    }

    public PregradniVentili getFCl_posuda2() {
        return FCl_posuda2;
    }

    public PregradniVentili getFCl_ventil1() {
        return FCl_ventil1;
    }

    public PregradniVentili getFCl_ventil2() {
        return FCl_ventil2;
    }

    public PregradniVentili getFCl_ventil3() {
        return FCl_ventil3;
    }

    public PregradniVentili getFCl_kompenzaciona1() {
        return FCl_kompenzaciona1;
    }

    public PregradniVentili getFCl_kompenzaciona2() {
        return FCl_kompenzaciona2;
    }
    
    
}
