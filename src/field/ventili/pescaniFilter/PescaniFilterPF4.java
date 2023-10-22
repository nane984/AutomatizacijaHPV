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
public class PescaniFilterPF4 {
    private final RegulacioniVentili regVent01;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    private final PregradniVentili vent07;
    private final PregradniVentili vent08;
    private final PregradniVentili vent09;
    private final PregradniVentili vent10;
    
    public PescaniFilterPF4(){
        regVent01 = new RegulacioniVentili("07A0701", 326, 360, 1, "Reg vent za dovod nefiltirane vode");
        
        vent03 = new PregradniVentili("07A0703", MutantToDec.getValue("514"), MutantToDec.getValue("515"), MutantToDec.getValue("51A"),
                MutantToDec.getValue("51B"), MutantToDec.getValue("51C"), MutantToDec.getValue("51D"), "Ventil za gornji deo pf 4");
        
        vent04 = new PregradniVentili("07A0704", MutantToDec.getValue("51E"), MutantToDec.getValue("51F"), MutantToDec.getValue("524"),
                MutantToDec.getValue("525"), MutantToDec.getValue("526"), MutantToDec.getValue("527"), "Ventil za donji deo pf 4");
        
        vent05 = new PregradniVentili("07A0705", MutantToDec.getValue("528"), MutantToDec.getValue("529"), MutantToDec.getValue("52E"),
                MutantToDec.getValue("52F"), MutantToDec.getValue("530"), MutantToDec.getValue("531"), "Ventil za izlaz iz pf 4");
        
        vent06 = new PregradniVentili("07A0706", MutantToDec.getValue("532"), MutantToDec.getValue("533"), MutantToDec.getValue("538"),
                MutantToDec.getValue("539"), MutantToDec.getValue("53A"), MutantToDec.getValue("53B"), "Ventil za ulaz vode za pranje pf 4");
        
        vent07 = new PregradniVentili("07A0707", MutantToDec.getValue("53C"), MutantToDec.getValue("53D"), MutantToDec.getValue("542"),
                MutantToDec.getValue("543"), MutantToDec.getValue("544"), MutantToDec.getValue("545"), "Ventil za dovod vazduha za rastresanje pf 4");
        
        vent08 = new PregradniVentili("07A0708", MutantToDec.getValue("546"), MutantToDec.getValue("547"), MutantToDec.getValue("54C"),
                MutantToDec.getValue("54D"), MutantToDec.getValue("54E"), MutantToDec.getValue("54F"), "Ventil za pranje pf 4");
        
        vent09 = new PregradniVentili("07A0709", MutantToDec.getValue("550"), MutantToDec.getValue("551"), MutantToDec.getValue("556"),
                MutantToDec.getValue("557"), MutantToDec.getValue("558"), MutantToDec.getValue("559"), "Ventil za pranje pf 4");
        
        vent10 = new PregradniVentili("07A0710", MutantToDec.getValue("55A"), MutantToDec.getValue("55B"), MutantToDec.getValue("560"),
                MutantToDec.getValue("561"), MutantToDec.getValue("562"), MutantToDec.getValue("563"), "Ventil za izlaz vode posle pranja pf4");
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
