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
public class PescaniFilterPF6 {
    private final RegulacioniVentili regVent01;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    private final PregradniVentili vent07;
    private final PregradniVentili vent08;
    private final PregradniVentili vent09;
    private final PregradniVentili vent10;
    
    public PescaniFilterPF6(){
        regVent01 = new RegulacioniVentili("07A1201", 328, 362, 1, "Reg vent za dovod nefiltirane vode");
        
        vent03 = new PregradniVentili("07A1203", MutantToDec.getValue("628"), MutantToDec.getValue("629"), MutantToDec.getValue("62E"),
                MutantToDec.getValue("62F"), MutantToDec.getValue("630"), MutantToDec.getValue("631"), "Ventil za gornji deo pf 6");
        
        vent04 = new PregradniVentili("07A1204", MutantToDec.getValue("632"), MutantToDec.getValue("633"), MutantToDec.getValue("638"),
                MutantToDec.getValue("639"), MutantToDec.getValue("63A"), MutantToDec.getValue("63B"), "Ventil za donji deo pf 6");
        
        vent05 = new PregradniVentili("07A1205", MutantToDec.getValue("63C"), MutantToDec.getValue("63D"), MutantToDec.getValue("642"),
                MutantToDec.getValue("643"), MutantToDec.getValue("644"), MutantToDec.getValue("645"), "Ventil za izlaz iz pf 6");
        
        vent06 = new PregradniVentili("07A1206", MutantToDec.getValue("646"), MutantToDec.getValue("647"), MutantToDec.getValue("64C"),
                MutantToDec.getValue("64D"), MutantToDec.getValue("64E"), MutantToDec.getValue("64F"), "Ventil za ulaz vode za pranje pf 6");
        
        vent07 = new PregradniVentili("07A1207", MutantToDec.getValue("650"), MutantToDec.getValue("651"), MutantToDec.getValue("656"),
                MutantToDec.getValue("657"), MutantToDec.getValue("658"), MutantToDec.getValue("659"), "Ventil za dovod vazduha za rastresanje pf 6");
        
        vent08 = new PregradniVentili("07A1208", MutantToDec.getValue("65A"), MutantToDec.getValue("65B"), MutantToDec.getValue("660"),
                MutantToDec.getValue("661"), MutantToDec.getValue("662"), MutantToDec.getValue("663"), "Ventil za pranje pf 6");
        
        vent09 = new PregradniVentili("07A1209", MutantToDec.getValue("664"), MutantToDec.getValue("665"), MutantToDec.getValue("66A"),
                MutantToDec.getValue("66B"), MutantToDec.getValue("66C"), MutantToDec.getValue("66D"), "Ventil za pranje pf 6");
        
        vent10 = new PregradniVentili("07A1210", MutantToDec.getValue("66E"), MutantToDec.getValue("66F"), MutantToDec.getValue("674"),
                MutantToDec.getValue("675"), MutantToDec.getValue("676"), MutantToDec.getValue("677"), "Ventil za izlaz vode posle pranja pf 6");
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
