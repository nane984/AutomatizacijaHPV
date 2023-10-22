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
public class PumpeOdpadnihVodaOdPranjaPescanihFiltera {
    private final ElcM pumpaBr1;
    private final ElcM pumpaBr2;
    
     public PumpeOdpadnihVodaOdPranjaPescanihFiltera(){
        this.pumpaBr1 = new ElcM("01A04", MutantToDec.getValue("578"), MutantToDec.getValue("579"), MutantToDec.getValue("57A"), 
                                MutantToDec.getValue("2120"), MutantToDec.getValue("2121"), 
                                MutantToDec.getValue("2126"), MutantToDec.getValue("2127"), 
                                "Pumpa br 1 od pranja pescanih filtera");   //13m1
        
        this.pumpaBr2 = new ElcM("01A05", MutantToDec.getValue("57B"), MutantToDec.getValue("57C"), MutantToDec.getValue("57D"), 
                                MutantToDec.getValue("2128"), MutantToDec.getValue("2129"), 
                                MutantToDec.getValue("212E"), MutantToDec.getValue("212F"), 
                                "Pumpa br 2 od pranja pescanih filtera");     //13m2
     }

    public ElcM getPumpaBr1() {
        return pumpaBr1;
    }

    public ElcM getPumpaBr2() {
        return pumpaBr2;
    }
}
