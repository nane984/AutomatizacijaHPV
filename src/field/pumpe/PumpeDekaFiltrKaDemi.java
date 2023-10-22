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
public class PumpeDekaFiltrKaDemi {
    private final ElcM pumpaBr1;
    private final ElcM pumpaBr2;
    private final ElcM pumpaBr3;
    private final ElcM pumpaBr4;
    private final ElcM pumpaBr5;
    
    public PumpeDekaFiltrKaDemi(){
        this.pumpaBr1 = new ElcM("08A01", MutantToDec.getValue("57E"), MutantToDec.getValue("57F"), MutantToDec.getValue("580"), 
                                MutantToDec.getValue("2130"), MutantToDec.getValue("2131"), 
                                MutantToDec.getValue("2136"), MutantToDec.getValue("2137"), 
                                "Pumpa br 1 deka filtrirane vode na demineralizaciju");   //14m1
        
        this.pumpaBr2 = new ElcM("08A02", MutantToDec.getValue("581"), MutantToDec.getValue("582"), MutantToDec.getValue("583"), 
                                MutantToDec.getValue("2138"), MutantToDec.getValue("2139"), 
                                MutantToDec.getValue("213E"), MutantToDec.getValue("213F"), 
                                "Pumpa br 2 deka filtrirane vode na demineralizaciju");     //14m2
        
        this.pumpaBr3 = new ElcM("08A03", MutantToDec.getValue("584"), MutantToDec.getValue("585"), MutantToDec.getValue("586"), 
                                MutantToDec.getValue("2140"), MutantToDec.getValue("2141"), 
                                MutantToDec.getValue("2146"), MutantToDec.getValue("2147"), 
                                "Pumpa br 3 deka filtrirane vode na demineralizaciju");   //14m3
        
        this.pumpaBr4 = new ElcM("08A04", MutantToDec.getValue("647"), MutantToDec.getValue("648"), MutantToDec.getValue("649"), 
                                MutantToDec.getValue("2308"), MutantToDec.getValue("2309"), 
                                MutantToDec.getValue("230E"), MutantToDec.getValue("230F"), 
                                "Pumpa br 4 deka filtrirane vode na demineralizaciju");   //52m1
        
        this.pumpaBr5 = new ElcM("08A05", MutantToDec.getValue("64A"), MutantToDec.getValue("64B"), MutantToDec.getValue("64C"), 
                                MutantToDec.getValue("2310"), MutantToDec.getValue("2311"), 
                                MutantToDec.getValue("2316"), MutantToDec.getValue("2317"), 
                                "Pumpa br 5 deka filtrirane vode na demineralizaciju");   //52m2

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

    public ElcM getPumpaBr4() {
        return pumpaBr4;
    }

    public ElcM getPumpaBr5() {
        return pumpaBr5;
    }
    
}
