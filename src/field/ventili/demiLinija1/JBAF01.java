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
public class JBAF01 {
    private final PregradniVentili vent01;
    private final PregradniVentili vent02;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    private final PregradniVentili vent07;
    private final PregradniVentili vent08;
    
    public JBAF01(){
        vent01 = new PregradniVentili("10A0101", MutantToDec.getValue("1150"), MutantToDec.getValue("1151"), MutantToDec.getValue("1156"),
                MutantToDec.getValue("1157"), MutantToDec.getValue("1158"), MutantToDec.getValue("1159"), "Ulaz u izmenjivac");
        
        vent02 = new PregradniVentili("10A0102", MutantToDec.getValue("115A"), MutantToDec.getValue("115B"), MutantToDec.getValue("1160"),
                MutantToDec.getValue("1161"), MutantToDec.getValue("1162"), MutantToDec.getValue("1163"), "Ventil na izlazu iz izmenjivaca");
        
        vent03 = new PregradniVentili("10A0103", MutantToDec.getValue("1164"), MutantToDec.getValue("1165"), MutantToDec.getValue("116A"),
                MutantToDec.getValue("116B"), MutantToDec.getValue("116C"), MutantToDec.getValue("116D"), "Ventil ulaz vode od dole prilikom rastresanja");
        
        vent04 = new PregradniVentili("10A0104", MutantToDec.getValue("116E"), MutantToDec.getValue("116F"), MutantToDec.getValue("1174"),
                MutantToDec.getValue("1175"), MutantToDec.getValue("1176"), MutantToDec.getValue("1177"), "Ventil za odvod vode od gore prilikom rastresanja");
        
        vent05 = new PregradniVentili("10A0105", MutantToDec.getValue("1178"), MutantToDec.getValue("1179"), MutantToDec.getValue("117E"),
                MutantToDec.getValue("117F"), MutantToDec.getValue("1180"), MutantToDec.getValue("1181"), "Ventil za odvod regeneranta - baze");
        
        vent06 = new PregradniVentili("10A0106", MutantToDec.getValue("1182"), MutantToDec.getValue("1183"), MutantToDec.getValue("1188"),
                MutantToDec.getValue("1189"), MutantToDec.getValue("118A"), MutantToDec.getValue("118B"), "Ventil za odvod regenerata");
        
        vent07 = new PregradniVentili("10A0107", MutantToDec.getValue("118C"), MutantToDec.getValue("118D"), MutantToDec.getValue("1192"),
                MutantToDec.getValue("1193"), MutantToDec.getValue("1194"), MutantToDec.getValue("1195"), "Ventil za odvod prilikom ispiranja");
        
        vent08 = new PregradniVentili("10A0108", MutantToDec.getValue("1196"), MutantToDec.getValue("1197"), MutantToDec.getValue("119C"),
                MutantToDec.getValue("119D"), MutantToDec.getValue("119E"), MutantToDec.getValue("119F"), "Ventil za odzraku");
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
