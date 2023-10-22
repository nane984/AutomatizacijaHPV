/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili.demiLinija3;

import tools.MutantToDec;
import valve.globe.PregradniVentili;
import valve.reg.RegulacioniVentili;

/**
 *
 * @author branko.scekic
 */
public class JKKF03 {
    private final RegulacioniVentili regVent01;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    private final PregradniVentili vent07;
    private final PregradniVentili vent08;
    private final PregradniVentili vent09;
    private final PregradniVentili vent10;
    private final PregradniVentili vent11;
    private final PregradniVentili vent12;
    
    public JKKF03(){
        regVent01 = new RegulacioniVentili("08A0301", 322, 369 , 1, "Reg vent demi linija 3");
        
        vent03 = new PregradniVentili("08A0303", MutantToDec.getValue("148C"), MutantToDec.getValue("148D"), MutantToDec.getValue("1492"),
                MutantToDec.getValue("1493"), MutantToDec.getValue("1494"), MutantToDec.getValue("1495"), "Ventil na ulazu u izmenjivac");
        
        vent04 = new PregradniVentili("08A0304", MutantToDec.getValue("1496"), MutantToDec.getValue("1497"), MutantToDec.getValue("149C"),
                MutantToDec.getValue("149D"), MutantToDec.getValue("149E"), MutantToDec.getValue("149F"), "Ventil na izlazu iz izmenjivaca");
        
        vent05 = new PregradniVentili("08A0305", MutantToDec.getValue("1500"), MutantToDec.getValue("1501"), MutantToDec.getValue("1506"),
                MutantToDec.getValue("1507"), MutantToDec.getValue("1508"), MutantToDec.getValue("1509"), "Ventil za ulaz vode od dole prilikom pranja gornjeg sloja na krstak");
        
        vent06 = new PregradniVentili("08A0306", MutantToDec.getValue("150A"), MutantToDec.getValue("150B"), MutantToDec.getValue("1510"),
                MutantToDec.getValue("1511"), MutantToDec.getValue("1512"), MutantToDec.getValue("1513"), "Ventil za izlaz vode od gore prilikom rastresanja");
        
        vent07 = new PregradniVentili("08A0307", MutantToDec.getValue("1514"), MutantToDec.getValue("1515"), MutantToDec.getValue("151A"),
                MutantToDec.getValue("151B"), MutantToDec.getValue("151C"), MutantToDec.getValue("151D"), "Ventil na dovodu regenerata - kiseline");
        
        vent08 = new PregradniVentili("08A0308", MutantToDec.getValue("151E"), MutantToDec.getValue("151F"), MutantToDec.getValue("1524"),
                MutantToDec.getValue("1525"), MutantToDec.getValue("1526"), MutantToDec.getValue("1527"), "Ventil za ulaz vode prilikom regeneracije");
        
        vent09 = new PregradniVentili("08A0309", MutantToDec.getValue("1528"), MutantToDec.getValue("1529"), MutantToDec.getValue("152E"),
                MutantToDec.getValue("152F"), MutantToDec.getValue("1530"), MutantToDec.getValue("1531"), "Ventil za odvod prilikom regeneracije sa krstaka");
        
        vent10 = new PregradniVentili("08A0310", MutantToDec.getValue("1532"), MutantToDec.getValue("1533"), MutantToDec.getValue("1538"),
                MutantToDec.getValue("1539"), MutantToDec.getValue("153A"), MutantToDec.getValue("153B"), "Ventil za ulaz vode od dole prilikom rastresanja");
        
        vent11 = new PregradniVentili("08A0311", MutantToDec.getValue("153C"), MutantToDec.getValue("153D"), MutantToDec.getValue("1542"),
                MutantToDec.getValue("1543"), MutantToDec.getValue("1544"), MutantToDec.getValue("1545"), "Ventil za odvod prilikom ispiranja");
        
        vent12 = new PregradniVentili("08A0312", MutantToDec.getValue("1546"), MutantToDec.getValue("1547"), MutantToDec.getValue("154C"),
                MutantToDec.getValue("154D"), MutantToDec.getValue("154E"), MutantToDec.getValue("154F"), "Ventil za odzraku");
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

    public PregradniVentili getVent11() {
        return vent11;
    }

    public PregradniVentili getVent12() {
        return vent12;
    }
    
    
    
    
}
