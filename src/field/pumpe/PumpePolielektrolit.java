/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.pumpe;

import elcM.FrElcM;
import tools.MutantToDec;

/**
 *
 * @author branko.scekic
 */
public class PumpePolielektrolit {
    private final FrElcM pumpaBr1;
    private final FrElcM pumpaBr2;
    private final FrElcM pumpaBr3;
    
    public PumpePolielektrolit(){
        this.pumpaBr1 = new FrElcM("04A03", MutantToDec.getValue("551"), MutantToDec.getValue("552"), MutantToDec.getValue("553"), 
                                MutantToDec.getValue("2058"), MutantToDec.getValue("2059"), 
                                MutantToDec.getValue("205E"), MutantToDec.getValue("205F"), 
                                "Pumpa br 1 doziranje polielektrolit", 312, 373);   //7m1
        
        this.pumpaBr2 = new FrElcM("04A04", MutantToDec.getValue("554"), MutantToDec.getValue("555"), MutantToDec.getValue("556"), 
                                MutantToDec.getValue("2060"), MutantToDec.getValue("2061"), 
                                MutantToDec.getValue("2066"), MutantToDec.getValue("2067"), 
                                "Pumpa br 2 doziranje polielektrolit", 313, 375);   //7m2
        
        this.pumpaBr3 = new FrElcM("04A05", MutantToDec.getValue("62F"), MutantToDec.getValue("630"), MutantToDec.getValue("631"), 
                                MutantToDec.getValue("2268"), MutantToDec.getValue("2269"), 
                                MutantToDec.getValue("226E"), MutantToDec.getValue("226F"), 
                                "Pumpa br 3 doziranje polielektrolit", 314, 376);   //42m1
    }

    public FrElcM getPumpaBr1() {
        return pumpaBr1;
    }

    public FrElcM getPumpaBr2() {
        return pumpaBr2;
    }

    public FrElcM getPumpaBr3() {
        return pumpaBr3;
    }
}
