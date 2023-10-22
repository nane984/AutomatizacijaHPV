/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili.pescaniFilter;

import tools.MutantToDec;
import valve.globe.PregradniVentili;
import valve.reg.RegulacioniVentili;

/**
 *
 * @author branko.scekic
 */
public class PescaniFilterPF2 {
    private final RegulacioniVentili regVent01;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    private final PregradniVentili vent07;
    private final PregradniVentili vent08;
    private final PregradniVentili vent09;
    private final PregradniVentili vent10;
    
    public PescaniFilterPF2(){
        regVent01 = new RegulacioniVentili("07A0901", 324, 358, 1, "Reg vent za dovod nefiltirane vode");
        
        vent03 = new PregradniVentili("07A0903", MutantToDec.getValue("400"), MutantToDec.getValue("401"), MutantToDec.getValue("406"),
                MutantToDec.getValue("407"), MutantToDec.getValue("408"), MutantToDec.getValue("409"), "Ventil za gornji deo pf 1");
        
        vent04 = new PregradniVentili("07A0904", MutantToDec.getValue("40A"), MutantToDec.getValue("40B"), MutantToDec.getValue("410"),
                MutantToDec.getValue("411"), MutantToDec.getValue("412"), MutantToDec.getValue("413"), "Ventil za donji deo pf 1");
        
        vent05 = new PregradniVentili("07A0905", MutantToDec.getValue("414"), MutantToDec.getValue("415"), MutantToDec.getValue("41A"),
                MutantToDec.getValue("41B"), MutantToDec.getValue("41C"), MutantToDec.getValue("41D"), "Ventil za izlaz iz pf br.1");
        
        vent06 = new PregradniVentili("07A0906", MutantToDec.getValue("41E"), MutantToDec.getValue("41F"), MutantToDec.getValue("424"),
                MutantToDec.getValue("425"), MutantToDec.getValue("426"), MutantToDec.getValue("427"), "Ventil za ulaz vode za pranje pf 1");
        
        vent07 = new PregradniVentili("07A0907", MutantToDec.getValue("428"), MutantToDec.getValue("429"), MutantToDec.getValue("42E"),
                MutantToDec.getValue("42F"), MutantToDec.getValue("430"), MutantToDec.getValue("431"), "Ventil za dovod vazduha za rastresanje pf 1");
        
        vent08 = new PregradniVentili("07A0908", MutantToDec.getValue("432"), MutantToDec.getValue("433"), MutantToDec.getValue("438"),
                MutantToDec.getValue("439"), MutantToDec.getValue("43A"), MutantToDec.getValue("43B"), "Ventil za pranje pf 1");
        
        vent09 = new PregradniVentili("07A0909", MutantToDec.getValue("43C"), MutantToDec.getValue("43D"), MutantToDec.getValue("442"),
                MutantToDec.getValue("443"), MutantToDec.getValue("444"), MutantToDec.getValue("445"), "Ventil za pranje pf 1");
        
        vent10 = new PregradniVentili("07A0910", MutantToDec.getValue("446"), MutantToDec.getValue("447"), MutantToDec.getValue("44C"),
                MutantToDec.getValue("44D"), MutantToDec.getValue("44E"), MutantToDec.getValue("44F"), "Ventil za izlaz vode posle pranja pf 1");
    }

    public RegulacioniVentili getRegVent01() {
        return regVent01;
    }

    public PregradniVentili getVent03() {
        return vent03;
    }

    public PregradniVentili getVent04() {
        return vent04;
    }

    public PregradniVentili getVent05() {
        return vent05;
    }

    public PregradniVentili getVent06() {
        return vent06;
    }

    public PregradniVentili getVent07() {
        return vent07;
    }

    public PregradniVentili getVent08() {
        return vent08;
    }

    public PregradniVentili getVent09() {
        return vent09;
    }

    public PregradniVentili getVent10() {
        return vent10;
    }
}
