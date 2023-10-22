/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili;

import field.ventili.pescaniFilter.PescaniFilterPF5;
import field.ventili.pescaniFilter.PescaniFilterPF2;
import field.ventili.pescaniFilter.PescaniFilterPF1;
import field.ventili.pescaniFilter.PescaniFilterPF4;
import field.ventili.pescaniFilter.PescaniFilterPF3;
import field.ventili.pescaniFilter.PescaniFilterPF6;
import tools.MutantToDec;
import valve.reg.RegulacioniElMotVentil;

/**
 *
 * @author branko.scekic
 */
public class PescaniFilteri {
    private final PescaniFilterPF1 pf1;
    private final PescaniFilterPF2 pf2;
    private final PescaniFilterPF3 pf3;
    private final PescaniFilterPF4 pf4;
    private final PescaniFilterPF5 pf5;
    private final PescaniFilterPF6 pf6;
    private final RegulacioniElMotVentil regVentIzlazIzPescanih;
    
    public PescaniFilteri(){
        pf1 = new PescaniFilterPF1();
        pf2 = new PescaniFilterPF2();
        pf3 = new PescaniFilterPF3();
        pf4 = new PescaniFilterPF4();
        pf5 = new PescaniFilterPF5();
        pf6 = new PescaniFilterPF6();
        regVentIzlazIzPescanih = new RegulacioniElMotVentil("07A0003", 465, 0, "Reg vent izlaz iz P.F.", MutantToDec.getValue("1815"), MutantToDec.getValue("1816"), 
                                                        MutantToDec.getValue("1817"), MutantToDec.getValue("1818"), 
                                                        MutantToDec.getValue("1819"), MutantToDec.getValue("181A"), 
                                                        464);
    }

    public PescaniFilterPF1 getPf1() {
        return pf1;
    }

    public PescaniFilterPF2 getPf2() {
        return pf2;
    }

    public PescaniFilterPF3 getPf3() {
        return pf3;
    }

    public PescaniFilterPF4 getPf4() {
        return pf4;
    }

    public PescaniFilterPF5 getPf5() {
        return pf5;
    }

    public PescaniFilterPF6 getPf6() {
        return pf6;
    }

    public RegulacioniElMotVentil getRegVentIzlazIzPescanih() {
        return regVentIzlazIzPescanih;
    }
}
