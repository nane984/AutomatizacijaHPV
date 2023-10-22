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
public class JBAF03 {
    private final PregradniVentili vent01;
    private final PregradniVentili vent02;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    private final PregradniVentili vent07;
    private final PregradniVentili vent08;
    
    public JBAF03(){
        vent01 = new PregradniVentili("10A0301", MutantToDec.getValue("158C"), MutantToDec.getValue("158D"), MutantToDec.getValue("1592"),
                MutantToDec.getValue("1593"), MutantToDec.getValue("1594"), MutantToDec.getValue("1595"), "Ulaz u izmenjivac");
        
        vent02 = new PregradniVentili("10A0302", MutantToDec.getValue("1596"), MutantToDec.getValue("1597"), MutantToDec.getValue("159C"),
                MutantToDec.getValue("159D"), MutantToDec.getValue("159E"), MutantToDec.getValue("159F"), "Ventil na izlazu iz izmenjivaca");
        
        vent03 = new PregradniVentili("10A0303", MutantToDec.getValue("1600"), MutantToDec.getValue("1601"), MutantToDec.getValue("1606"),
                MutantToDec.getValue("1607"), MutantToDec.getValue("1608"), MutantToDec.getValue("1609"), "Ventil ulaz vode od dole prilikom rastresanja");
        
        vent04 = new PregradniVentili("10A0304", MutantToDec.getValue("160A"), MutantToDec.getValue("160B"), MutantToDec.getValue("1610"),
                MutantToDec.getValue("1611"), MutantToDec.getValue("1612"), MutantToDec.getValue("1613"), "Ventil za odvod vode od gore prilikom rastresanja");
        
        vent05 = new PregradniVentili("10A0305", MutantToDec.getValue("1614"), MutantToDec.getValue("1615"), MutantToDec.getValue("161A"),
                MutantToDec.getValue("161B"), MutantToDec.getValue("161C"), MutantToDec.getValue("161D"), "Ventil za odvod regeneranta - baze");
        
        vent06 = new PregradniVentili("10A0306", MutantToDec.getValue("161E"), MutantToDec.getValue("161F"), MutantToDec.getValue("1624"),
                MutantToDec.getValue("1625"), MutantToDec.getValue("1626"), MutantToDec.getValue("1627"), "Ventil za odvod regenerata");
        
        vent07 = new PregradniVentili("10A0307", MutantToDec.getValue("1628"), MutantToDec.getValue("1629"), MutantToDec.getValue("162E"),
                MutantToDec.getValue("162F"), MutantToDec.getValue("1630"), MutantToDec.getValue("1631"), "Ventil za odvod prilikom ispiranja");
        
        vent08 = new PregradniVentili("10A0308", MutantToDec.getValue("1632"), MutantToDec.getValue("1633"), MutantToDec.getValue("1638"),
                MutantToDec.getValue("1639"), MutantToDec.getValue("163A"), MutantToDec.getValue("163B"), "Ventil za odzraku");
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

    public PregradniVentili getVent07() {
        return vent07;
    }

    public PregradniVentili getVent08() {
        return vent08;
    }
}
