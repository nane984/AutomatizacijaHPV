/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili.demiLinija3;


import tools.MutantToDec;
import valve.globe.PregradniVentili;

/**
 *
 * @author branko.scekic
 */
public class SBAF03 {
    private final PregradniVentili vent01;
    private final PregradniVentili vent02;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    
    public SBAF03(){
        vent01 = new PregradniVentili("09A0301", MutantToDec.getValue("1550"), MutantToDec.getValue("1551"), MutantToDec.getValue("1556"),
                MutantToDec.getValue("1557"), MutantToDec.getValue("1558"), MutantToDec.getValue("1559"), "Ulaz u izmenjivac");
        
        vent02 = new PregradniVentili("09A0302", MutantToDec.getValue("155A"), MutantToDec.getValue("155B"), MutantToDec.getValue("1560"),
                MutantToDec.getValue("1561"), MutantToDec.getValue("1562"), MutantToDec.getValue("1563"), "Ventil za ulaz vode od dole prilikom rastresanja");
        
        vent03 = new PregradniVentili("09A0303", MutantToDec.getValue("1564"), MutantToDec.getValue("1565"), MutantToDec.getValue("156A"),
                MutantToDec.getValue("156B"), MutantToDec.getValue("1560C"), MutantToDec.getValue("156D"), "Ventil za odvod od gore prilikom rastresanja");
        
        vent04 = new PregradniVentili("09A0304", MutantToDec.getValue("156E"), MutantToDec.getValue("156F"), MutantToDec.getValue("1574"),
                MutantToDec.getValue("1575"), MutantToDec.getValue("1576"), MutantToDec.getValue("1577"), "Ventil za odvod prilikom regeneracije");
        
        vent05 = new PregradniVentili("09A0305", MutantToDec.getValue("1578"), MutantToDec.getValue("1579"), MutantToDec.getValue("157E"),
                MutantToDec.getValue("157F"), MutantToDec.getValue("1580"), MutantToDec.getValue("1581"), "Ventil za odvod prilikom ispiranja");
        
        vent06 = new PregradniVentili("09A0306", MutantToDec.getValue("1582"), MutantToDec.getValue("1583"), MutantToDec.getValue("1588"),
                MutantToDec.getValue("1589"), MutantToDec.getValue("158A"), MutantToDec.getValue("158B"), "Ventil za odzraku");
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
