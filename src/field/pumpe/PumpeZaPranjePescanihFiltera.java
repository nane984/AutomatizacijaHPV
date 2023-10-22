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
public class PumpeZaPranjePescanihFiltera {
    private final ElcM pumpaBr1;
    private final ElcM pumpaBr2;
    
    public PumpeZaPranjePescanihFiltera(){
        
        this.pumpaBr1 = new ElcM("07A17", MutantToDec.getValue("54B"), MutantToDec.getValue("54C"), MutantToDec.getValue("54D"), 
                                MutantToDec.getValue("2048"), MutantToDec.getValue("2049"), 
                                MutantToDec.getValue("204E"), MutantToDec.getValue("204F"), 
                                "Pumpa br 1 za pranje pescanih filtera");     //6m1
        
        this.pumpaBr2 = new ElcM("07A18", MutantToDec.getValue("54E"), MutantToDec.getValue("54F"), MutantToDec.getValue("550"), 
                                MutantToDec.getValue("2050"), MutantToDec.getValue("2051"), 
                                MutantToDec.getValue("2056"), MutantToDec.getValue("2057"), 
                                "Pumpa br 2 za pranje pescanih filtera");     //6m2
    }

    public ElcM getPumpaBr1() {
        return pumpaBr1;
    }

    public ElcM getPumpaBr2() {
        return pumpaBr2;
    }
}
