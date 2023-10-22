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
public class JonskaIzmena01 {
    private final RegulacioniVentili regVent01;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    private final PregradniVentili vent07;
    private final PregradniVentili vent08;
    private final PregradniVentili vent09;
    private final PregradniVentili vent10;
    
    public JonskaIzmena01(){
        regVent01 = new RegulacioniVentili("14A0401", 330, 363 , 1, "Reg vent neutralna jonska");
        
        vent03 = new PregradniVentili("14A0403", MutantToDec.getValue("882"), MutantToDec.getValue("883"), MutantToDec.getValue("888"),
                MutantToDec.getValue("889"), MutantToDec.getValue("88A"), MutantToDec.getValue("88B"), "Ulaz u rezervoar");
        
        vent04 = new PregradniVentili("14A0404", MutantToDec.getValue("88C"), MutantToDec.getValue("88D"), MutantToDec.getValue("892"),
                MutantToDec.getValue("893"), MutantToDec.getValue("894"), MutantToDec.getValue("895"), "Izlaz iz linije");
        
        vent05 = new PregradniVentili("14A0405", MutantToDec.getValue("896"), MutantToDec.getValue("897"), MutantToDec.getValue("89C"),
                MutantToDec.getValue("89D"), MutantToDec.getValue("89E"), MutantToDec.getValue("89F"), "Dopuna rezervoara od dole prilikom rastresanja");
        
        vent06 = new PregradniVentili("14A0406", MutantToDec.getValue("900"), MutantToDec.getValue("901"), MutantToDec.getValue("906"),
                MutantToDec.getValue("907"), MutantToDec.getValue("908"), MutantToDec.getValue("909"), "Izlaz dopune prilikom rastresanja");
        
        vent07 = new PregradniVentili("14A0407", MutantToDec.getValue("90A"), MutantToDec.getValue("90B"), MutantToDec.getValue("910"),
                MutantToDec.getValue("911"), MutantToDec.getValue("912"), MutantToDec.getValue("913"), "Ulaz rastvora soli prilikom regeneracije");
        
        vent08 = new PregradniVentili("14A0408", MutantToDec.getValue("914"), MutantToDec.getValue("915"), MutantToDec.getValue("91A"),
                MutantToDec.getValue("91B"), MutantToDec.getValue("91C"), MutantToDec.getValue("91D"), "ispiranje posle regeneracije");
        
        vent09 = new PregradniVentili("14A0409", MutantToDec.getValue("91E"), MutantToDec.getValue("91F"), MutantToDec.getValue("924"),
                MutantToDec.getValue("925"), MutantToDec.getValue("926"), MutantToDec.getValue("927"), "izlaz tokom regeneracije");
        
        vent10 = new PregradniVentili("14A0410", MutantToDec.getValue("928"), MutantToDec.getValue("929"), MutantToDec.getValue("92E"),
                MutantToDec.getValue("92F"), MutantToDec.getValue("930"), MutantToDec.getValue("931"), "Ventil za odzraku");   
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
