/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.pumpe;

import elcM.ElcM;
import tools.MutantToDec;

/**
 *
 * @author branko.scekic
 */
public class PumpeDekaFiltriraneKaNeutralnojIzmeni {
    private final ElcM pumpaBr1;
    private final ElcM pumpaBr2;
    private final ElcM pumpaBr3;
    
    public PumpeDekaFiltriraneKaNeutralnojIzmeni(){
         this.pumpaBr1 = new ElcM("14A01", MutantToDec.getValue("605"), MutantToDec.getValue("606"), MutantToDec.getValue("607"), 
                                MutantToDec.getValue("2198"), MutantToDec.getValue("2199"), 
                                MutantToDec.getValue("219E"), MutantToDec.getValue("219F"), 
                                "Pumpa br 1 deka filtrirane vode ka neutralnoj izmeni");   //24m1
         
         this.pumpaBr2 = new ElcM("14A01", MutantToDec.getValue("608"), MutantToDec.getValue("609"), MutantToDec.getValue("60A"), 
                                MutantToDec.getValue("2200"), MutantToDec.getValue("2201"), 
                                MutantToDec.getValue("2206"), MutantToDec.getValue("2207"), 
                                "Pumpa br 2 deka filtrirane vode ka neutralnoj izmeni");   //24m2
         
         this.pumpaBr3 = new ElcM("14A01", MutantToDec.getValue("644"), MutantToDec.getValue("645"), MutantToDec.getValue("646"), 
                                MutantToDec.getValue("2300"), MutantToDec.getValue("2301"), 
                                MutantToDec.getValue("2306"), MutantToDec.getValue("2307"), 
                                "Pumpa br 3 deka filtrirane vode ka neutralnoj izmeni");   //53m1
    }

    public ElcM getPumpaBr1() {
        return pumpaBr1;
    }

    public ElcM getPumpaBr2() {
        return pumpaBr2;
    }

    public ElcM getPumpaBr3() {
        return pumpaBr3;
    }
}
