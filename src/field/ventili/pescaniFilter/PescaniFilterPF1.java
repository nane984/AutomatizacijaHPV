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
public class PescaniFilterPF1 {
    private final RegulacioniVentili regVent01;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    private final PregradniVentili vent07;
    private final PregradniVentili vent08;
    private final PregradniVentili vent09;
    private final PregradniVentili vent10;
    
    public PescaniFilterPF1(){
        regVent01 = new RegulacioniVentili("07A1001", 323, 357 , 1, "Reg vent za dovod nefiltirane vode");
        
        vent03 = new PregradniVentili("07A1003", MutantToDec.getValue("346"), MutantToDec.getValue("347"), MutantToDec.getValue("34C"),
                MutantToDec.getValue("34D"), MutantToDec.getValue("34E"), MutantToDec.getValue("34F"), "Ventil za gornji deo pf");
        
        vent04 = new PregradniVentili("07A1004", MutantToDec.getValue("350"), MutantToDec.getValue("351"), MutantToDec.getValue("356"),
                MutantToDec.getValue("357"), MutantToDec.getValue("358"), MutantToDec.getValue("359"), "Ventil za donji deo pf");
        
        vent05 = new PregradniVentili("07A1005", MutantToDec.getValue("35A"), MutantToDec.getValue("35B"), MutantToDec.getValue("360"),
                MutantToDec.getValue("361"), MutantToDec.getValue("362"), MutantToDec.getValue("363"), "Ventil za izlaz iz pf");
        
        vent06 = new PregradniVentili("07A1006", MutantToDec.getValue("364"), MutantToDec.getValue("365"), MutantToDec.getValue("36A"),
                MutantToDec.getValue("36B"), MutantToDec.getValue("36C"), MutantToDec.getValue("36D"), "Ventil za ulaz vode za pranje pf");
        
        vent07 = new PregradniVentili("07A1007", MutantToDec.getValue("36E"), MutantToDec.getValue("36F"), MutantToDec.getValue("374"),
                MutantToDec.getValue("375"), MutantToDec.getValue("376"), MutantToDec.getValue("377"), "Ventil za dovod vazduha za rastresanje pf");
        
        vent08 = new PregradniVentili("07A1008", MutantToDec.getValue("378"), MutantToDec.getValue("379"), MutantToDec.getValue("37E"),
                MutantToDec.getValue("37F"), MutantToDec.getValue("380"), MutantToDec.getValue("381"), "Ventil za pranje pf");
        
        vent09 = new PregradniVentili("07A1009", MutantToDec.getValue("382"), MutantToDec.getValue("383"), MutantToDec.getValue("388"),
                MutantToDec.getValue("389"), MutantToDec.getValue("38A"), MutantToDec.getValue("38B"), "Ventil za pranje pf");
        
        vent10 = new PregradniVentili("07A1010", MutantToDec.getValue("38C"), MutantToDec.getValue("38D"), MutantToDec.getValue("392"),
                MutantToDec.getValue("393"), MutantToDec.getValue("394"), MutantToDec.getValue("395"), "Ventil za izlaz vode posle pranja pf");
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
