/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili.pescaniFilter;

import tools.MutantToDec;
import valve.globe.PregradniVentili;

/**
 *
 * @author branko.scekic
 */
public class OtpadneVodeOdPescanihFiltera {
    private final PregradniVentili vent01;
    private final PregradniVentili vent02;
    
    public OtpadneVodeOdPescanihFiltera(){
         vent01 = new PregradniVentili("01A0405", MutantToDec.getValue("678"), MutantToDec.getValue("679"), MutantToDec.getValue("67E"),
                MutantToDec.getValue("67F"), MutantToDec.getValue("680"), MutantToDec.getValue("681"), "Ventil br 1 od pranja pescanih filtera");
         
         vent02 = new PregradniVentili("01A0505", MutantToDec.getValue("682"), MutantToDec.getValue("683"), MutantToDec.getValue("688"),
                MutantToDec.getValue("689"), MutantToDec.getValue("68A"), MutantToDec.getValue("68B"), "Ventil br 2 od pranja pescanih filtera");
    }

    public PregradniVentili getVent01() {
        return vent01;
    }

    public PregradniVentili getVent02() {
        return vent02;
    }
}
