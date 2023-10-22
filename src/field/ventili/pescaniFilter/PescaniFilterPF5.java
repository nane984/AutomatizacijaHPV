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
public class PescaniFilterPF5 {
    private final RegulacioniVentili regVent01;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    private final PregradniVentili vent07;
    private final PregradniVentili vent08;
    private final PregradniVentili vent09;
    private final PregradniVentili vent10;
    
    public PescaniFilterPF5(){
        regVent01 = new RegulacioniVentili("07A1101", 327, 361, 1, "Reg vent za dovod nefiltirane vode");
        
        vent03 = new PregradniVentili("07A1103", MutantToDec.getValue("56E"), MutantToDec.getValue("56F"), MutantToDec.getValue("574"),
                MutantToDec.getValue("575"), MutantToDec.getValue("576"), MutantToDec.getValue("577"), "Ventil za gornji deo pf 5");
        
        vent04 = new PregradniVentili("07A1104", MutantToDec.getValue("578"), MutantToDec.getValue("579"), MutantToDec.getValue("57E"),
                MutantToDec.getValue("57F"), MutantToDec.getValue("580"), MutantToDec.getValue("581"), "Ventil za donji deo pf 5");
        
        vent05 = new PregradniVentili("07A1105", MutantToDec.getValue("582"), MutantToDec.getValue("583"), MutantToDec.getValue("588"),
                MutantToDec.getValue("589"), MutantToDec.getValue("58A"), MutantToDec.getValue("58B"), "Ventil za izlaz iz pf 5");
        
        vent06 = new PregradniVentili("07A1106", MutantToDec.getValue("58C"), MutantToDec.getValue("58D"), MutantToDec.getValue("592"),
                MutantToDec.getValue("593"), MutantToDec.getValue("594"), MutantToDec.getValue("595"), "Ventil za ulaz vode za pranje pf 5");
        
        vent07 = new PregradniVentili("07A1107", MutantToDec.getValue("596"), MutantToDec.getValue("597"), MutantToDec.getValue("59C"),
                MutantToDec.getValue("59D"), MutantToDec.getValue("59E"), MutantToDec.getValue("59F"), "Ventil za dovod vazduha za rastresanje pf 5");
        
        vent08 = new PregradniVentili("07A1108", MutantToDec.getValue("600"), MutantToDec.getValue("601"), MutantToDec.getValue("606"),
                MutantToDec.getValue("607"), MutantToDec.getValue("608"), MutantToDec.getValue("609"), "Ventil za pranje pf 5");
        
        vent09 = new PregradniVentili("07A1109", MutantToDec.getValue("60A"), MutantToDec.getValue("60B"), MutantToDec.getValue("610"),
                MutantToDec.getValue("611"), MutantToDec.getValue("612"), MutantToDec.getValue("613"), "Ventil za pranje pf 5");
        
        vent10 = new PregradniVentili("07A1110", MutantToDec.getValue("614"), MutantToDec.getValue("615"), MutantToDec.getValue("61A"),
                MutantToDec.getValue("61B"), MutantToDec.getValue("61C"), MutantToDec.getValue("61D"), "Ventil za izlaz vode posle pranja pf 5");
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
