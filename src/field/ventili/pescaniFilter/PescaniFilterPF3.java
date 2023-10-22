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
public class PescaniFilterPF3 {
    private final RegulacioniVentili regVent01;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    private final PregradniVentili vent07;
    private final PregradniVentili vent08;
    private final PregradniVentili vent09;
    private final PregradniVentili vent10;
    
    public PescaniFilterPF3(){
        regVent01 = new RegulacioniVentili("07A0801", 325, 359, 1, "Reg vent za dovod nefiltirane vode");
        
        vent03 = new PregradniVentili("07A0803", MutantToDec.getValue("45A"), MutantToDec.getValue("45B"), MutantToDec.getValue("460"),
                MutantToDec.getValue("461"), MutantToDec.getValue("462"), MutantToDec.getValue("463"), "Ventil za gornji deo pf 3");
        
        vent04 = new PregradniVentili("07A0804", MutantToDec.getValue("464"), MutantToDec.getValue("465"), MutantToDec.getValue("46A"),
                MutantToDec.getValue("46B"), MutantToDec.getValue("46C"), MutantToDec.getValue("46D"), "Ventil za donji deo pf 1");
        
        vent05 = new PregradniVentili("07A0805", MutantToDec.getValue("46E"), MutantToDec.getValue("46F"), MutantToDec.getValue("474"),
                MutantToDec.getValue("475"), MutantToDec.getValue("476"), MutantToDec.getValue("477"), "Ventil za izlaz iz pf br.1");
        
        vent06 = new PregradniVentili("07A0806", MutantToDec.getValue("478"), MutantToDec.getValue("479"), MutantToDec.getValue("47E"),
                MutantToDec.getValue("47F"), MutantToDec.getValue("480"), MutantToDec.getValue("481"), "Ventil za ulaz vode za pranje pf 1");
        
        vent07 = new PregradniVentili("07A0807", MutantToDec.getValue("482"), MutantToDec.getValue("483"), MutantToDec.getValue("488"),
                MutantToDec.getValue("489"), MutantToDec.getValue("48A"), MutantToDec.getValue("48B"), "Ventil za dovod vazduha za rastresanje pf 1");
        
        vent08 = new PregradniVentili("07A0808", MutantToDec.getValue("48C"), MutantToDec.getValue("48D"), MutantToDec.getValue("492"),
                MutantToDec.getValue("493"), MutantToDec.getValue("494"), MutantToDec.getValue("495"), "Ventil za pranje pf 1");
        
        vent09 = new PregradniVentili("07A0809", MutantToDec.getValue("496"), MutantToDec.getValue("497"), MutantToDec.getValue("49C"),
                MutantToDec.getValue("49D"), MutantToDec.getValue("49E"), MutantToDec.getValue("49F"), "Ventil za pranje pf 1");
        
        vent10 = new PregradniVentili("07A0810", MutantToDec.getValue("500"), MutantToDec.getValue("501"), MutantToDec.getValue("506"),
                MutantToDec.getValue("507"), MutantToDec.getValue("508"), MutantToDec.getValue("509"), "Ventil za izlaz vode posle pranja pf 1");
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
