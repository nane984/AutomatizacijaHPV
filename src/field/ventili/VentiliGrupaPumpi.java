/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili;

import java.io.Serializable;
import tools.MutantToDec;
import valve.globe.PregradniVentili;

/**
 *
 * @author branko.scekic
 */
public class VentiliGrupaPumpi implements Serializable{
    //grupne pumpe
    private final PregradniVentili GP01_potisDemi1;
    private final PregradniVentili GP01_potisDemi2;
    private final PregradniVentili GP01_potisDemi3;
    private final PregradniVentili GP01_potisDemi4;
    private final PregradniVentili GP01_potisDemi5;
    private final PregradniVentili GP01_potisJonska1;
    private final PregradniVentili GP01_potisJonska2;
    private final PregradniVentili GP01_potisJonska3;
   
    public VentiliGrupaPumpi(){
        GP01_potisDemi1 = new PregradniVentili("08A0105", MutantToDec.getValue("A"), MutantToDec.getValue("B"), 
                MutantToDec.getValue("10"), MutantToDec.getValue("11"), MutantToDec.getValue("12"), MutantToDec.getValue("13"),"Ventil na potisu pumpe br 1 za deminealizaciju");
        GP01_potisDemi2 = new PregradniVentili("08A0205", MutantToDec.getValue("1E"), MutantToDec.getValue("1F"), MutantToDec.getValue("24"),
                MutantToDec.getValue("25"), MutantToDec.getValue("26"), MutantToDec.getValue("27"),"Ventil na potisu pumpe br 2 za deminealizaciju");
        GP01_potisDemi3 = new PregradniVentili("08A0305", MutantToDec.getValue("32"), MutantToDec.getValue("33"), MutantToDec.getValue("38"),
                MutantToDec.getValue("39"), MutantToDec.getValue("3A"), MutantToDec.getValue("3B"),"Ventil na potisu pumpe br 3 za deminealizaciju");
        GP01_potisDemi4 = new PregradniVentili("08A0405", MutantToDec.getValue("46"), MutantToDec.getValue("47"), MutantToDec.getValue("4C"),
                MutantToDec.getValue("4D"), MutantToDec.getValue("4E"), MutantToDec.getValue("4F"),"Ventil na potisu pumpe br 4 za deminealizaciju");
        GP01_potisDemi5 = new PregradniVentili("08A0505", MutantToDec.getValue("5A"), MutantToDec.getValue("5B"), MutantToDec.getValue("60"),
                MutantToDec.getValue("61"), MutantToDec.getValue("62"), MutantToDec.getValue("63"),"Ventil na potisu pumpe br 5 za deminealizaciju");
        
        GP01_potisJonska1 = new PregradniVentili("14A0105", MutantToDec.getValue("6E"), MutantToDec.getValue("6F"), MutantToDec.getValue("74"),
                MutantToDec.getValue("75"), MutantToDec.getValue("76"), MutantToDec.getValue("77"),"Ventil na potisu pumpe br 1 za neutralnu jonsku izmenu");
        GP01_potisJonska2 = new PregradniVentili("14A0205", MutantToDec.getValue("82"), MutantToDec.getValue("83"), MutantToDec.getValue("88"), 
                MutantToDec.getValue("89"), MutantToDec.getValue("8A"), MutantToDec.getValue("8B"),"Ventil na potisu pumpe br 2 za neutralnu jonsku izmenu");
        GP01_potisJonska3 = new PregradniVentili("14A0305", MutantToDec.getValue("96"), MutantToDec.getValue("97"), MutantToDec.getValue("9C"),
                MutantToDec.getValue("9D"), MutantToDec.getValue("9E"), MutantToDec.getValue("9F"),"Ventil na potisu pumpe br 3 za neutralnu jonsku izmenu");
        
    }

    public PregradniVentili getGP01_potisDemi1() {
        return GP01_potisDemi1;
    }

    public PregradniVentili getGP01_potisDemi2() {
        return GP01_potisDemi2;
    }

    public PregradniVentili getGP01_potisDemi3() {
        return GP01_potisDemi3;
    }

    public PregradniVentili getGP01_potisDemi4() {
        return GP01_potisDemi4;
    }

    public PregradniVentili getGP01_potisDemi5() {
        return GP01_potisDemi5;
    }

    public PregradniVentili getGP01_potisJonska1() {
        return GP01_potisJonska1;
    }

    public PregradniVentili getGP01_potisJonska2() {
        return GP01_potisJonska2;
    }

    public PregradniVentili getGP01_potisJonska3() {
        return GP01_potisJonska3;
    }
}
