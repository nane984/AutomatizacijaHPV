/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili.demiLinija2;


import tools.MutantToDec;
import valve.globe.PregradniVentili;

/**
 *
 * @author branko.scekic
 */
public class SBAF02 {
    private final PregradniVentili vent01;
    private final PregradniVentili vent02;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    
    public SBAF02(){
        vent01 = new PregradniVentili("09A0201", MutantToDec.getValue("1332"), MutantToDec.getValue("1333"), MutantToDec.getValue("1338"),
                MutantToDec.getValue("1339"), MutantToDec.getValue("133A"), MutantToDec.getValue("133B"), "Ulaz u izmenjivac");
        
        vent02 = new PregradniVentili("09A0202", MutantToDec.getValue("133C"), MutantToDec.getValue("133D"), MutantToDec.getValue("1342"),
                MutantToDec.getValue("1343"), MutantToDec.getValue("1344"), MutantToDec.getValue("1345"), "Ventil za ulaz vode od dole prilikom rastresanja");
        
        vent03 = new PregradniVentili("09A0203", MutantToDec.getValue("1346"), MutantToDec.getValue("1347"), MutantToDec.getValue("134C"),
                MutantToDec.getValue("134D"), MutantToDec.getValue("134E"), MutantToDec.getValue("134F"), "Ventil za odvod od gore prilikom rastresanja");
        
        vent04 = new PregradniVentili("09A0204", MutantToDec.getValue("1350"), MutantToDec.getValue("1351"), MutantToDec.getValue("1356"),
                MutantToDec.getValue("1357"), MutantToDec.getValue("1358"), MutantToDec.getValue("1359"), "Ventil za odvod prilikom regeneracije");
        
        vent05 = new PregradniVentili("09A0205", MutantToDec.getValue("135A"), MutantToDec.getValue("135B"), MutantToDec.getValue("1360"),
                MutantToDec.getValue("1361"), MutantToDec.getValue("1362"), MutantToDec.getValue("1363"), "Ventil za odvod prilikom ispiranja");
        
        vent06 = new PregradniVentili("09A0206", MutantToDec.getValue("1364"), MutantToDec.getValue("1365"), MutantToDec.getValue("136A"),
                MutantToDec.getValue("136B"), MutantToDec.getValue("136C"), MutantToDec.getValue("136D"), "Ventil za odzraku");
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
