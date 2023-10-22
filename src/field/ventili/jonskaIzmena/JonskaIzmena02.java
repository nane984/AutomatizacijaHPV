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
public class JonskaIzmena02 {
    private final RegulacioniVentili regVent01;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    private final PregradniVentili vent07;
    private final PregradniVentili vent08;
    private final PregradniVentili vent09;
    private final PregradniVentili vent10;
    
    public JonskaIzmena02(){
        regVent01 = new RegulacioniVentili("14A0501", 331, 364 , 1, "Reg vent neutralna jonska");
        
        vent03 = new PregradniVentili("14A0503", MutantToDec.getValue("93C"), MutantToDec.getValue("93D"), MutantToDec.getValue("942"),
                MutantToDec.getValue("943"), MutantToDec.getValue("944"), MutantToDec.getValue("945"), "Ulaz u rezervoar");
        
        vent04 = new PregradniVentili("14A0504", MutantToDec.getValue("946"), MutantToDec.getValue("947"), MutantToDec.getValue("94C"),
                MutantToDec.getValue("94D"), MutantToDec.getValue("94E"), MutantToDec.getValue("94F"), "Izlaz iz linije");
        
        vent05 = new PregradniVentili("14A0505", MutantToDec.getValue("950"), MutantToDec.getValue("951"), MutantToDec.getValue("956"),
                MutantToDec.getValue("957"), MutantToDec.getValue("958"), MutantToDec.getValue("959"), "Dopuna rezervoara od dole prilikom rastresanja");
        
        vent06 = new PregradniVentili("14A0506", MutantToDec.getValue("95A"), MutantToDec.getValue("95B"), MutantToDec.getValue("960"),
                MutantToDec.getValue("961"), MutantToDec.getValue("962"), MutantToDec.getValue("963"), "Izlaz dopune prilikom rastresanja");
        
        vent07 = new PregradniVentili("14A0507", MutantToDec.getValue("964"), MutantToDec.getValue("965"), MutantToDec.getValue("96A"),
                MutantToDec.getValue("96B"), MutantToDec.getValue("96C"), MutantToDec.getValue("96D"), "Ulaz rastvora soli prilikom regeneracije");
        
        vent08 = new PregradniVentili("14A0508", MutantToDec.getValue("96E"), MutantToDec.getValue("96F"), MutantToDec.getValue("974"),
                MutantToDec.getValue("975"), MutantToDec.getValue("976"), MutantToDec.getValue("977"), "ispiranje posle regeneracije");
        
        vent09 = new PregradniVentili("14A0509", MutantToDec.getValue("978"), MutantToDec.getValue("979"), MutantToDec.getValue("97E"),
                MutantToDec.getValue("97F"), MutantToDec.getValue("980"), MutantToDec.getValue("981"), "izlaz tokom regeneracije");
        
        vent10 = new PregradniVentili("14A0510", MutantToDec.getValue("982"), MutantToDec.getValue("983"), MutantToDec.getValue("988"),
                MutantToDec.getValue("989"), MutantToDec.getValue("98A"), MutantToDec.getValue("98B"), "Ventil za odzraku");   
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
