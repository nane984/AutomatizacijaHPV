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
public class PumpeFerihlorid {
    private final FrElcM pumpaBr1;
    private final FrElcM pumpaBr2;
    private final FrElcM pumpaBr3;
    
    public PumpeFerihlorid(){
        this.pumpaBr1 = new FrElcM("03A07", MutantToDec.getValue("55D"), MutantToDec.getValue("55E"), MutantToDec.getValue("55F"), 
                                MutantToDec.getValue("2078"), MutantToDec.getValue("2079"), 
                                MutantToDec.getValue("207E"), MutantToDec.getValue("207F"), 
                                "Pumpa br 1 doziranje ferihlorida", 315, 370);   //9m1
        
        this.pumpaBr2 = new FrElcM("03A08", MutantToDec.getValue("560"), MutantToDec.getValue("561"), MutantToDec.getValue("562"), 
                                MutantToDec.getValue("2080"), MutantToDec.getValue("2081"), 
                                MutantToDec.getValue("2086"), MutantToDec.getValue("2087"), 
                                "Pumpa br 2 doziranje ferihlorida", 316, 371);   //9m2
        
        this.pumpaBr3 = new FrElcM("03A09", MutantToDec.getValue("632"), MutantToDec.getValue("633"), MutantToDec.getValue("634"), 
                                MutantToDec.getValue("2270"), MutantToDec.getValue("2271"), 
                                MutantToDec.getValue("2276"), MutantToDec.getValue("2277"), 
                                "Pumpa br 3 doziranje ferihlorida", 318, 372);   //43m1
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
