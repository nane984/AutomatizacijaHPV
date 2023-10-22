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
public class MF02 {
    
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
    
    public MF02(){
        vent01 = new PregradniVentili("11A0201", MutantToDec.getValue("141E"), MutantToDec.getValue("141F"), MutantToDec.getValue("1424"),
                MutantToDec.getValue("1425"), MutantToDec.getValue("1426"), MutantToDec.getValue("1427"), "Ventil na ulazu u izmenjivac");
        
        vent02 = new PregradniVentili("11A0202", MutantToDec.getValue("1428"), MutantToDec.getValue("1429"), MutantToDec.getValue("142E"),
                MutantToDec.getValue("142F"), MutantToDec.getValue("1430"), MutantToDec.getValue("1431"), "Ventil na izlazu iz izmenjivaca");
        
        vent03 = new PregradniVentili("11A0203", MutantToDec.getValue("1432"), MutantToDec.getValue("1433"), MutantToDec.getValue("1438"),
                MutantToDec.getValue("1439"), MutantToDec.getValue("143A"), MutantToDec.getValue("143B"), "ulaz vode od dole prilikom rastresanja");
        
        vent04 = new PregradniVentili("11A0204", MutantToDec.getValue("143C"), MutantToDec.getValue("143D"), MutantToDec.getValue("1442"),
                MutantToDec.getValue("1443"), MutantToDec.getValue("1444"), MutantToDec.getValue("1445"), "izlaz dopune od gore prilikom rastresanja");
        
        vent05 = new PregradniVentili("11A0205", MutantToDec.getValue("1446"), MutantToDec.getValue("1447"), MutantToDec.getValue("144C"),
                MutantToDec.getValue("144D"), MutantToDec.getValue("144E"), MutantToDec.getValue("144F"), "Ventil na dovodu regeneranta - kiseline od dole");
        
        vent06 = new PregradniVentili("11A0206", MutantToDec.getValue("1450"), MutantToDec.getValue("1451"), MutantToDec.getValue("1456"),
                MutantToDec.getValue("1457"), MutantToDec.getValue("1458"), MutantToDec.getValue("1459"), "Ventil na dovodu regeneranta - baze");
        
        vent07 = new PregradniVentili("11A0207", MutantToDec.getValue("145A"), MutantToDec.getValue("145B"), MutantToDec.getValue("1460"),
                MutantToDec.getValue("1461"), MutantToDec.getValue("1462"), MutantToDec.getValue("1463"), "Ventil za odvod regeneranta");
        
        vent08 = new PregradniVentili("11A0208", MutantToDec.getValue("1464"), MutantToDec.getValue("1465"), MutantToDec.getValue("146A"),
                MutantToDec.getValue("146B"), MutantToDec.getValue("146C"), MutantToDec.getValue("146D"), "Ventil za dovod vazduha");
        
        vent10 = new PregradniVentili("11A0210", MutantToDec.getValue("146E"), MutantToDec.getValue("146F"), MutantToDec.getValue("1474"),
                MutantToDec.getValue("1475"), MutantToDec.getValue("1476"), MutantToDec.getValue("1477"), "Ventil za odvod prilikom ispiranja");
        
        vent11 = new PregradniVentili("11A0211", MutantToDec.getValue("1478"), MutantToDec.getValue("1479"), MutantToDec.getValue("147E"),
                MutantToDec.getValue("147F"), MutantToDec.getValue("1480"), MutantToDec.getValue("1481"), "Ventil za odzraku");
        
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
