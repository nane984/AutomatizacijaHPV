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
public class PumpeNeutralizacionogBazena {
    private final ElcM pumpaBr1;
    private final ElcM pumpaBr2;
    
    public PumpeNeutralizacionogBazena(){
         this.pumpaBr1 = new ElcM("18A02", MutantToDec.getValue("536"), MutantToDec.getValue("537"), MutantToDec.getValue("538"), 
                                MutantToDec.getValue("2010"), MutantToDec.getValue("2011"), 
                                MutantToDec.getValue("2016"), MutantToDec.getValue("2017"), 
                                "Pumpa br 1 neutralizacionog bazena");   //3m1
        
        this.pumpaBr2 = new ElcM("18A03", MutantToDec.getValue("539"), MutantToDec.getValue("53A"), MutantToDec.getValue("53B"), 
                                MutantToDec.getValue("2018"), MutantToDec.getValue("2019"), 
                                MutantToDec.getValue("201E"), MutantToDec.getValue("201F"), 
                                "Pumpa br 2 neutralizacionog bazena");     //3m2
        
    }

    public ElcM getPumpaBr1() {
        return pumpaBr1;
    }

    public ElcM getPumpaBr2() {
        return pumpaBr2;
    }
    
    
}
