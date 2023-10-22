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
public class MF01 {
    
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
    
    public MF01(){
        vent01 = new PregradniVentili("11A0101", MutantToDec.getValue("1200"), MutantToDec.getValue("1201"), MutantToDec.getValue("1206"),
                MutantToDec.getValue("1207"), MutantToDec.getValue("1208"), MutantToDec.getValue("1209"), "Ventil na ulazu u izmenjivac");
        
        vent02 = new PregradniVentili("11A0102", MutantToDec.getValue("120A"), MutantToDec.getValue("120B"), MutantToDec.getValue("1210"),
                MutantToDec.getValue("1211"), MutantToDec.getValue("1212"), MutantToDec.getValue("1213"), "Ventil na izlazu iz izmenjivaca");
        
        vent03 = new PregradniVentili("11A0103", MutantToDec.getValue("1214"), MutantToDec.getValue("1215"), MutantToDec.getValue("121A"),
                MutantToDec.getValue("121B"), MutantToDec.getValue("121C"), MutantToDec.getValue("121D"), "ulaz vode od dole prilikom rastresanja");
        
        vent04 = new PregradniVentili("11A0104", MutantToDec.getValue("121E"), MutantToDec.getValue("121F"), MutantToDec.getValue("1224"),
                MutantToDec.getValue("1225"), MutantToDec.getValue("1226"), MutantToDec.getValue("1227"), "izlaz dopune od gore prilikom rastresanja");
        
        vent05 = new PregradniVentili("11A0105", MutantToDec.getValue("1228"), MutantToDec.getValue("1229"), MutantToDec.getValue("122E"),
                MutantToDec.getValue("122F"), MutantToDec.getValue("1230"), MutantToDec.getValue("1231"), "Ventil na dovodu regeneranta - kiseline od dole");
        
        vent06 = new PregradniVentili("11A0106", MutantToDec.getValue("1232"), MutantToDec.getValue("1233"), MutantToDec.getValue("1238"),
                MutantToDec.getValue("1239"), MutantToDec.getValue("123A"), MutantToDec.getValue("123B"), "Ventil na dovodu regeneranta - baze");
        
        vent07 = new PregradniVentili("11A0107", MutantToDec.getValue("123C"), MutantToDec.getValue("123D"), MutantToDec.getValue("1242"),
                MutantToDec.getValue("1243"), MutantToDec.getValue("1244"), MutantToDec.getValue("1245"), "Ventil za odvod regeneranta");
        
        vent08 = new PregradniVentili("11A0108", MutantToDec.getValue("1246"), MutantToDec.getValue("1247"), MutantToDec.getValue("124C"),
                MutantToDec.getValue("124D"), MutantToDec.getValue("124E"), MutantToDec.getValue("124F"), "Ventil za dovod vazduha");
        
        vent10 = new PregradniVentili("11A0110", MutantToDec.getValue("1250"), MutantToDec.getValue("1251"), MutantToDec.getValue("1256"),
                MutantToDec.getValue("1257"), MutantToDec.getValue("1258"), MutantToDec.getValue("1259"), "Ventil za odvod prilikom ispiranja");
        
        vent11 = new PregradniVentili("11A0111", MutantToDec.getValue("125A"), MutantToDec.getValue("125B"), MutantToDec.getValue("1260"),
                MutantToDec.getValue("1261"), MutantToDec.getValue("1262"), MutantToDec.getValue("1263"), "Ventil za odzraku");
        
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
