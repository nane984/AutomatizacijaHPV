/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili.demiLinija1;

import tools.MutantToDec;
import valve.globe.PregradniVentili;

/**
 *
 * @author branko.scekic
 */
public class SBAF01 {
    private final PregradniVentili vent01;
    private final PregradniVentili vent02;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    
    public SBAF01(){
        vent01 = new PregradniVentili("09A0101", MutantToDec.getValue("1114"), MutantToDec.getValue("1115"), MutantToDec.getValue("111A"),
                MutantToDec.getValue("111B"), MutantToDec.getValue("111C"), MutantToDec.getValue("111D"), "Ulaz u izmenjivac");
        
        vent02 = new PregradniVentili("09A0102", MutantToDec.getValue("111E"), MutantToDec.getValue("111F"), MutantToDec.getValue("1124"),
                MutantToDec.getValue("1125"), MutantToDec.getValue("1126"), MutantToDec.getValue("1127"), "Ventil za ulaz vode od dole prilikom rastresanja");
        
        vent03 = new PregradniVentili("09A0103", MutantToDec.getValue("1128"), MutantToDec.getValue("1129"), MutantToDec.getValue("112E"),
                MutantToDec.getValue("112F"), MutantToDec.getValue("1130"), MutantToDec.getValue("1131"), "Ventil za odvod od gore prilikom rastresanja");
        
        vent04 = new PregradniVentili("09A0104", MutantToDec.getValue("1132"), MutantToDec.getValue("1133"), MutantToDec.getValue("1138"),
                MutantToDec.getValue("1139"), MutantToDec.getValue("113A"), MutantToDec.getValue("113B"), "Ventil za odvod prilikom regeneracije");
        
        vent05 = new PregradniVentili("09A0105", MutantToDec.getValue("113C"), MutantToDec.getValue("113D"), MutantToDec.getValue("1142"),
                MutantToDec.getValue("1143"), MutantToDec.getValue("1144"), MutantToDec.getValue("1145"), "Ventil za odvod prilikom ispiranja");
        
        vent06 = new PregradniVentili("09A0106", MutantToDec.getValue("1146"), MutantToDec.getValue("1147"), MutantToDec.getValue("114C"),
                MutantToDec.getValue("114D"), MutantToDec.getValue("114E"), MutantToDec.getValue("114F"), "Ventil za odzraku");
    }

    public PregradniVentili getVent01() {
        return vent01;
    }

    public PregradniVentili getVent02() {
        return vent02;
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
    
    
}
