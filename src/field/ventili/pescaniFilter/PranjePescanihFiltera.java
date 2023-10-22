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
public class PranjePescanihFiltera {
    private final PregradniVentili vent01;
    private final PregradniVentili vent02;
    
    public PranjePescanihFiltera(){
         vent01 = new PregradniVentili("07A1705", MutantToDec.getValue("10A"), MutantToDec.getValue("10B"), MutantToDec.getValue("110"),
                MutantToDec.getValue("111"), MutantToDec.getValue("112"), MutantToDec.getValue("113"), "Ventil br 1 za pranje pescanih filtera");
         
         vent02 = new PregradniVentili("01A0505", MutantToDec.getValue("11E"), MutantToDec.getValue("11F"), MutantToDec.getValue("124"),
                MutantToDec.getValue("125"), MutantToDec.getValue("126"), MutantToDec.getValue("127"), "Ventil br 2 za pranje pescanih filtera");
    }

    public PregradniVentili getVent01() {
        return vent01;
    }

    public PregradniVentili getVent02() {
        return vent02;
    }
}
