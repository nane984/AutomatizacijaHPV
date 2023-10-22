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
public class JBAF02 {
    private final PregradniVentili vent01;
    private final PregradniVentili vent02;
    private final PregradniVentili vent03;
    private final PregradniVentili vent04;
    private final PregradniVentili vent05;
    private final PregradniVentili vent06;
    private final PregradniVentili vent07;
    private final PregradniVentili vent08;
    
    public JBAF02(){
        vent01 = new PregradniVentili("10A0201", MutantToDec.getValue("136E"), MutantToDec.getValue("136F"), MutantToDec.getValue("1374"),
                MutantToDec.getValue("1375"), MutantToDec.getValue("1376"), MutantToDec.getValue("1377"), "Ulaz u izmenjivac");
        
        vent02 = new PregradniVentili("10A0202", MutantToDec.getValue("1378"), MutantToDec.getValue("1379"), MutantToDec.getValue("137E"),
                MutantToDec.getValue("137F"), MutantToDec.getValue("1380"), MutantToDec.getValue("1381"), "Ventil na izlazu iz izmenjivaca");
        
        vent03 = new PregradniVentili("10A0203", MutantToDec.getValue("1382"), MutantToDec.getValue("1383"), MutantToDec.getValue("1388"),
                MutantToDec.getValue("1389"), MutantToDec.getValue("138A"), MutantToDec.getValue("138B"), "Ventil ulaz vode od dole prilikom rastresanja");
        
        vent04 = new PregradniVentili("10A0204", MutantToDec.getValue("138C"), MutantToDec.getValue("138D"), MutantToDec.getValue("1392"),
                MutantToDec.getValue("1393"), MutantToDec.getValue("1394"), MutantToDec.getValue("1395"), "Ventil za odvod vode od gore prilikom rastresanja");
        
        vent05 = new PregradniVentili("10A0205", MutantToDec.getValue("1396"), MutantToDec.getValue("1397"), MutantToDec.getValue("139C"),
                MutantToDec.getValue("139D"), MutantToDec.getValue("139E"), MutantToDec.getValue("139F"), "Ventil za odvod regeneranta - baze");
        
        vent06 = new PregradniVentili("10A0206", MutantToDec.getValue("1400"), MutantToDec.getValue("1401"), MutantToDec.getValue("1406"),
                MutantToDec.getValue("1407"), MutantToDec.getValue("1408"), MutantToDec.getValue("1409"), "Ventil za odvod regenerata");
        
        vent07 = new PregradniVentili("10A0207", MutantToDec.getValue("140A"), MutantToDec.getValue("140B"), MutantToDec.getValue("1410"),
                MutantToDec.getValue("1411"), MutantToDec.getValue("1412"), MutantToDec.getValue("1413"), "Ventil za odvod prilikom ispiranja");
        
        vent08 = new PregradniVentili("10A0208", MutantToDec.getValue("1414"), MutantToDec.getValue("1415"), MutantToDec.getValue("141A"),
                MutantToDec.getValue("141B"), MutantToDec.getValue("141C"), MutantToDec.getValue("141D"), "Ventil za odzraku");
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
