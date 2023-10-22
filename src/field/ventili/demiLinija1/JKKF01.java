/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili.demiLinija1;

import tools.MutantToDec;
import valve.globe.PregradniVentili;
import valve.reg.RegulacioniVentili;

/**
 *
 * @author branko.scekic
 */
public class JKKF01 {
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
    
    public JKKF01(){
        regVent01 = new RegulacioniVentili("08A0101", 320, 367 , 1, "Reg vent demi linija 1");
        
        vent03 = new PregradniVentili("08A0103", MutantToDec.getValue("1050"), MutantToDec.getValue("1051"), MutantToDec.getValue("1056"),
                MutantToDec.getValue("1057"), MutantToDec.getValue("1058"), MutantToDec.getValue("1059"), "Ventil na ulazu u izmenjivac");
        
        vent04 = new PregradniVentili("08A0104", MutantToDec.getValue("105A"), MutantToDec.getValue("105B"), MutantToDec.getValue("1060"),
                MutantToDec.getValue("1061"), MutantToDec.getValue("1062"), MutantToDec.getValue("1063"), "Ventil na izlazu iz izmenjivaca");
        
        vent05 = new PregradniVentili("08A0105", MutantToDec.getValue("1064"), MutantToDec.getValue("1065"), MutantToDec.getValue("106A"),
                MutantToDec.getValue("106B"), MutantToDec.getValue("106C"), MutantToDec.getValue("106D"), "Ventil za ulaz vode od dole prilikom pranja gornjeg sloja na krstak");
        
        vent06 = new PregradniVentili("08A0106", MutantToDec.getValue("106E"), MutantToDec.getValue("106F"), MutantToDec.getValue("1074"),
                MutantToDec.getValue("1075"), MutantToDec.getValue("1076"), MutantToDec.getValue("1077"), "Ventil za izlaz vode od gore prilikom rastresanja");
        
        vent07 = new PregradniVentili("08A0107", MutantToDec.getValue("1078"), MutantToDec.getValue("1079"), MutantToDec.getValue("107E"),
                MutantToDec.getValue("107F"), MutantToDec.getValue("1080"), MutantToDec.getValue("1081"), "Ventil na dovodu regenerata - kiseline");
        
        vent08 = new PregradniVentili("08A0108", MutantToDec.getValue("1082"), MutantToDec.getValue("1083"), MutantToDec.getValue("1088"),
                MutantToDec.getValue("1089"), MutantToDec.getValue("108A"), MutantToDec.getValue("108B"), "Ventil za ulaz vode prilikom regeneracije");
        
        vent09 = new PregradniVentili("08A0109", MutantToDec.getValue("108C"), MutantToDec.getValue("108D"), MutantToDec.getValue("1092"),
                MutantToDec.getValue("1093"), MutantToDec.getValue("1094"), MutantToDec.getValue("1095"), "Ventil za odvod prilikom regeneracije sa krstaka");
        
        vent10 = new PregradniVentili("08A0110", MutantToDec.getValue("1096"), MutantToDec.getValue("1097"), MutantToDec.getValue("109C"),
                MutantToDec.getValue("109D"), MutantToDec.getValue("109E"), MutantToDec.getValue("109F"), "Ventil za ulaz vode od dole prilikom rastresanja");
        
        vent11 = new PregradniVentili("08A0111", MutantToDec.getValue("1100"), MutantToDec.getValue("1101"), MutantToDec.getValue("1106"),
                MutantToDec.getValue("1107"), MutantToDec.getValue("1108"), MutantToDec.getValue("1109"), "Ventil za odvod prilikom ispiranja");
        
        vent12 = new PregradniVentili("08A0112", MutantToDec.getValue("110A"), MutantToDec.getValue("110B"), MutantToDec.getValue("1110"),
                MutantToDec.getValue("1111"), MutantToDec.getValue("1112"), MutantToDec.getValue("1113"), "Ventil za odzraku");
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
