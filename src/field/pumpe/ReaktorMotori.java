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
public class ReaktorMotori {
    private final ElcM zgrtacReaktorBr1;
    private final ElcM impelerReaktorBr1;
    
    public ReaktorMotori(){
        impelerReaktorBr1 = new ElcM("01A0114", MutantToDec.getValue("530"), MutantToDec.getValue("531"), MutantToDec.getValue("532"), 
                                MutantToDec.getValue("2000"), MutantToDec.getValue("2001"), 
                                MutantToDec.getValue("2006"), MutantToDec.getValue("2007"), 
                                "Impeler na reaktoru br 1");   //1m1 
        
        zgrtacReaktorBr1 = new ElcM("01A0113", MutantToDec.getValue("533"), MutantToDec.getValue("534"), MutantToDec.getValue("535"), 
                                MutantToDec.getValue("2008"), MutantToDec.getValue("2009"), 
                                MutantToDec.getValue("200E"), MutantToDec.getValue("200F"), 
                                "Zgrtac mulja na reaktoru br 1");   //2m1 
    }

    public ElcM getZgrtacReaktorBr1() {
        return zgrtacReaktorBr1;
    }

    public ElcM getImpelerReaktorBr1() {
        return impelerReaktorBr1;
    }
    
}
