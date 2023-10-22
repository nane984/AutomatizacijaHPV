/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili;

import tools.MutantToDec;
import valve.reg.RegulacioniElMotVentil;

/**
 *
 * @author branko.scekic
 */
public class Reaktor {
    private final RegulacioniElMotVentil ulazSirVodeR1;
    
    public Reaktor(){
        this.ulazSirVodeR1 = new RegulacioniElMotVentil("01A0101", 310, 1, "Reg vent demi linija 1", MutantToDec.getValue("814"), MutantToDec.getValue("815"), 
                                                        MutantToDec.getValue("81C"), MutantToDec.getValue("81D"), MutantToDec.getValue("81A"), MutantToDec.getValue("81B"));
    }

    public RegulacioniElMotVentil getUlazSirVodeR1() {
        return ulazSirVodeR1;
    }
}