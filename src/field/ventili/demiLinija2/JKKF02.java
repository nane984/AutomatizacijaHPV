/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili.demiLinija2;

import tools.MutantToDec;
import valve.globe.PregradniVentili;
import valve.reg.RegulacioniVentili;

/**
 *
 * @author branko.scekic
 */
public class JKKF02 {
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
    
    public JKKF02(){
        regVent01 = new RegulacioniVentili("08A0201", 321, 368 , 1, "Reg vent demi linija 1");
        
        vent03 = new PregradniVentili("08A0203", MutantToDec.getValue("126E"), MutantToDec.getValue("126F"), MutantToDec.getValue("1274"),
                MutantToDec.getValue("1275"), MutantToDec.getValue("1276"), MutantToDec.getValue("1277"), "Ventil na ulazu u izmenjivac");
        
        vent04 = new PregradniVentili("08A0204", MutantToDec.getValue("1278"), MutantToDec.getValue("1279"), MutantToDec.getValue("127E"),
                MutantToDec.getValue("127F"), MutantToDec.getValue("1280"), MutantToDec.getValue("1281"), "Ventil na izlazu iz izmenjivaca");
        
        vent05 = new PregradniVentili("08A0205", MutantToDec.getValue("1282"), MutantToDec.getValue("1283"), MutantToDec.getValue("1288"),
                MutantToDec.getValue("1289"), MutantToDec.getValue("128A"), MutantToDec.getValue("128B"), "Ventil za ulaz vode od dole prilikom pranja gornjeg sloja na krstak");
        
        vent06 = new PregradniVentili("08A0206", MutantToDec.getValue("128C"), MutantToDec.getValue("128D"), MutantToDec.getValue("1292"),
                MutantToDec.getValue("1293"), MutantToDec.getValue("1294"), MutantToDec.getValue("1295"), "Ventil za izlaz vode od gore prilikom rastresanja");
        
        vent07 = new PregradniVentili("08A0207", MutantToDec.getValue("1296"), MutantToDec.getValue("1297"), MutantToDec.getValue("129C"),
                MutantToDec.getValue("129D"), MutantToDec.getValue("1295E"), MutantToDec.getValue("129F"), "Ventil na dovodu regenerata - kiseline");
        
        vent08 = new PregradniVentili("08A0208", MutantToDec.getValue("1300"), MutantToDec.getValue("1301"), MutantToDec.getValue("1306"),
                MutantToDec.getValue("1307"), MutantToDec.getValue("1308"), MutantToDec.getValue("1309"), "Ventil za ulaz vode prilikom regeneracije");
        
        vent09 = new PregradniVentili("08A0209", MutantToDec.getValue("130A"), MutantToDec.getValue("130B"), MutantToDec.getValue("1310"),
                MutantToDec.getValue("1311"), MutantToDec.getValue("1312"), MutantToDec.getValue("1313"), "Ventil za odvod prilikom regeneracije sa krstaka");
        
        vent10 = new PregradniVentili("08A0210", MutantToDec.getValue("1314"), MutantToDec.getValue("1315"), MutantToDec.getValue("131A"),
                MutantToDec.getValue("131B"), MutantToDec.getValue("131C"), MutantToDec.getValue("131D"), "Ventil za ulaz vode od dole prilikom rastresanja");
        
        vent11 = new PregradniVentili("08A0211", MutantToDec.getValue("131E"), MutantToDec.getValue("131F"), MutantToDec.getValue("1324"),
                MutantToDec.getValue("1325"), MutantToDec.getValue("1326"), MutantToDec.getValue("1327"), "Ventil za odvod prilikom ispiranja");
        
        vent12 = new PregradniVentili("08A0212", MutantToDec.getValue("1328"), MutantToDec.getValue("1329"), MutantToDec.getValue("132E"),
                MutantToDec.getValue("132F"), MutantToDec.getValue("1330"), MutantToDec.getValue("1331"), "Ventil za odzraku");
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
