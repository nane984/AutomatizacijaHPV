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
public class MF03 {
    
    private final PregradniVentili vent01;
    private final PregradniVentili vent02;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    private final PregradniVentili vent07;
    private final PregradniVentili vent08;
    private final PregradniVentili vent10;
    private final PregradniVentili vent11;
    
    public MF03(){
        vent01 = new PregradniVentili("11A0301", MutantToDec.getValue("163C"), MutantToDec.getValue("163D"), MutantToDec.getValue("1642"),
                MutantToDec.getValue("1643"), MutantToDec.getValue("1644"), MutantToDec.getValue("1645"), "Ventil na ulazu u izmenjivac");
        
        vent02 = new PregradniVentili("11A0302", MutantToDec.getValue("1646"), MutantToDec.getValue("1647"), MutantToDec.getValue("164C"),
                MutantToDec.getValue("164D"), MutantToDec.getValue("164E"), MutantToDec.getValue("164F"), "Ventil na izlazu iz izmenjivaca");
        
        vent03 = new PregradniVentili("11A0303", MutantToDec.getValue("1650"), MutantToDec.getValue("1651"), MutantToDec.getValue("1656"),
                MutantToDec.getValue("1657"), MutantToDec.getValue("1658"), MutantToDec.getValue("1659"), "ulaz vode od dole prilikom rastresanja");
        
        vent04 = new PregradniVentili("11A0304", MutantToDec.getValue("165A"), MutantToDec.getValue("165B"), MutantToDec.getValue("1660"),
                MutantToDec.getValue("1661"), MutantToDec.getValue("1662"), MutantToDec.getValue("1663"), "izlaz dopune od gore prilikom rastresanja");
        
        vent05 = new PregradniVentili("11A0305", MutantToDec.getValue("1664"), MutantToDec.getValue("1665"), MutantToDec.getValue("166A"),
                MutantToDec.getValue("166B"), MutantToDec.getValue("166C"), MutantToDec.getValue("166D"), "Ventil na dovodu regeneranta - kiseline od dole");
        
        vent06 = new PregradniVentili("11A0306", MutantToDec.getValue("166E"), MutantToDec.getValue("166F"), MutantToDec.getValue("1674"),
                MutantToDec.getValue("1675"), MutantToDec.getValue("1676"), MutantToDec.getValue("1677"), "Ventil na dovodu regeneranta - baze");
        
        vent07 = new PregradniVentili("11A0307", MutantToDec.getValue("1678"), MutantToDec.getValue("1679"), MutantToDec.getValue("167E"),
                MutantToDec.getValue("167F"), MutantToDec.getValue("1680"), MutantToDec.getValue("1681"), "Ventil za odvod regeneranta");
        
        vent08 = new PregradniVentili("11A0308", MutantToDec.getValue("1682"), MutantToDec.getValue("1683"), MutantToDec.getValue("1688"),
                MutantToDec.getValue("1689"), MutantToDec.getValue("168A"), MutantToDec.getValue("168B"), "Ventil za dovod vazduha");
        
        vent10 = new PregradniVentili("11A0310", MutantToDec.getValue("168C"), MutantToDec.getValue("168D"), MutantToDec.getValue("1692"),
                MutantToDec.getValue("1693"), MutantToDec.getValue("1694"), MutantToDec.getValue("1695"), "Ventil za odvod prilikom ispiranja");
        
        vent11 = new PregradniVentili("11A0311", MutantToDec.getValue("1696"), MutantToDec.getValue("1697"), MutantToDec.getValue("169C"),
                MutantToDec.getValue("169D"), MutantToDec.getValue("169E"), MutantToDec.getValue("169F"), "Ventil za odzraku");
        
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

    public PregradniVentili getVent10() {
        return vent10;
    }

    public PregradniVentili getVent11() {
        return vent11;
    }
    
    
}
