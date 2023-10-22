/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili.jonskaIzmena;

import tools.MutantToDec;
import valve.globe.PregradniVentili;
import valve.reg.RegulacioniVentili;

/**
 *
 * @author branko.scekic
 */
public class JonskaIzmena03 {
    private final RegulacioniVentili regVent01;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    private final PregradniVentili vent07;
    private final PregradniVentili vent08;
    private final PregradniVentili vent09;
    private final PregradniVentili vent10;
    
    public JonskaIzmena03(){
        regVent01 = new RegulacioniVentili("14A0601", 332, 365 , 1, "Reg vent neutralna jonska");
        
        vent03 = new PregradniVentili("14A0603", MutantToDec.getValue("996"), MutantToDec.getValue("997"), MutantToDec.getValue("99C"),
                MutantToDec.getValue("99D"), MutantToDec.getValue("99E"), MutantToDec.getValue("99F"), "Ulaz u rezervoar");
        
        vent04 = new PregradniVentili("14A0604", MutantToDec.getValue("1000"), MutantToDec.getValue("1001"), MutantToDec.getValue("1006"),
                MutantToDec.getValue("1007"), MutantToDec.getValue("1008"), MutantToDec.getValue("1009"), "Izlaz iz linije");
        
        vent05 = new PregradniVentili("14A0605", MutantToDec.getValue("100A"), MutantToDec.getValue("100B"), MutantToDec.getValue("1010"),
                MutantToDec.getValue("1011"), MutantToDec.getValue("1012"), MutantToDec.getValue("1013"), "Dopuna rezervoara od dole prilikom rastresanja");
        
        vent06 = new PregradniVentili("14A0606", MutantToDec.getValue("1014"), MutantToDec.getValue("1015"), MutantToDec.getValue("101A"),
                MutantToDec.getValue("101B"), MutantToDec.getValue("101C"), MutantToDec.getValue("101D"), "Izlaz dopune prilikom rastresanja");
        
        vent07 = new PregradniVentili("14A0607", MutantToDec.getValue("101E"), MutantToDec.getValue("101F"), MutantToDec.getValue("1024"),
                MutantToDec.getValue("1025"), MutantToDec.getValue("1026"), MutantToDec.getValue("1027"), "Ulaz rastvora soli prilikom regeneracije");
        
        vent08 = new PregradniVentili("14A0608", MutantToDec.getValue("1028"), MutantToDec.getValue("1029"), MutantToDec.getValue("102E"),
                MutantToDec.getValue("102F"), MutantToDec.getValue("1030"), MutantToDec.getValue("1031"), "ispiranje posle regeneracije");
        
        vent09 = new PregradniVentili("14A0609", MutantToDec.getValue("1032"), MutantToDec.getValue("1033"), MutantToDec.getValue("1038"),
                MutantToDec.getValue("1039"), MutantToDec.getValue("103A"), MutantToDec.getValue("103B"), "izlaz tokom regeneracije");
        
        vent10 = new PregradniVentili("14A0610", MutantToDec.getValue("103C"), MutantToDec.getValue("103D"), MutantToDec.getValue("1042"),
                MutantToDec.getValue("1043"), MutantToDec.getValue("1044"), MutantToDec.getValue("1045"), "Ventil za odzraku");   
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
