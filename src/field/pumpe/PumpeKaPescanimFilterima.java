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
public class PumpeKaPescanimFilterima {
    private final ElcM pumpaBr1;
    private final ElcM pumpaBr2;
    private final ElcM pumpaBr3;
    private final ElcM pumpaBr4;
    private final ElcM pumpaBr5;
    private final ElcM pumpaBr6;
    
    public PumpeKaPescanimFilterima(){
        this.pumpaBr1 = new ElcM("07A01", MutantToDec.getValue("548"), MutantToDec.getValue("549"), MutantToDec.getValue("54A"), 
                                MutantToDec.getValue("2040"), MutantToDec.getValue("2041"), 
                                MutantToDec.getValue("2046"), MutantToDec.getValue("2047"), 
                                "Pumpa br 1 deka nefiltrirane vode ka pescanim");   //5m3
        
        this.pumpaBr2 = new ElcM("07A02", MutantToDec.getValue("545"), MutantToDec.getValue("546"), MutantToDec.getValue("547"), 
                                MutantToDec.getValue("2038"), MutantToDec.getValue("2039"), 
                                MutantToDec.getValue("203E"), MutantToDec.getValue("203F"), 
                                "Pumpa br 2 deka nefiltrirane vode ka pescanim");     //5m2
        
        this.pumpaBr3 = new ElcM("07A03", MutantToDec.getValue("542"), MutantToDec.getValue("543"), MutantToDec.getValue("544"), 
                                MutantToDec.getValue("2030"), MutantToDec.getValue("2031"), 
                                MutantToDec.getValue("2036"), MutantToDec.getValue("2037"), 
                                "Pumpa br 3 deka nefiltrirane vode ka pescanim");   //5m1
        
        this.pumpaBr4 = new ElcM("07A04", MutantToDec.getValue("63B"), MutantToDec.getValue("63C"), MutantToDec.getValue("63D"), 
                                MutantToDec.getValue("2288"), MutantToDec.getValue("2289"), 
                                MutantToDec.getValue("228E"), MutantToDec.getValue("2228F"), 
                                "Pumpa br 4 deka nefiltrirane vode ka pescanim");   //51m3
        
        this.pumpaBr5 = new ElcM("07A05", MutantToDec.getValue("63E"), MutantToDec.getValue("63F"), MutantToDec.getValue("640"), 
                                MutantToDec.getValue("2290"), MutantToDec.getValue("2291"), 
                                MutantToDec.getValue("2296"), MutantToDec.getValue("2297"), 
                                "Pumpa br 5 deka nefiltrirane vode ka pescanim");   //51m2
        
        this.pumpaBr6 = new ElcM("07A06", MutantToDec.getValue("641"), MutantToDec.getValue("642"), MutantToDec.getValue("643"), 
                                MutantToDec.getValue("2298"), MutantToDec.getValue("2299"), 
                                MutantToDec.getValue("229E"), MutantToDec.getValue("229F"), 
                                "Pumpa br 6 deka nefiltrirane vode ka pescanim");   //51m1
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

    public ElcM getPumpaBr6() {
        return pumpaBr6;
    }
    
    
}
