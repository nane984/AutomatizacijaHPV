/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.merenja.pescaniFilteri;

import constant.ConstReg;
import field.merenja.Merenja;

/**
 *
 * @author branko.scekic
 */
public class PescaniFilteriMerenja {
   
    private final Merenja pritisakInPF1;
    private final Merenja pritisakInPF2;
    private final Merenja pritisakInPF3;
    private final Merenja pritisakInPF4;
    private final Merenja pritisakInPF5;
    private final Merenja pritisakInPF6;
    
    private final Merenja pritisakOutPF1;
    private final Merenja pritisakOutPF2;
    private final Merenja pritisakOutPF3;
    private final Merenja pritisakOutPF4;
    private final Merenja pritisakOutPF5;
    private final Merenja pritisakOutPF6;
    
    
    
    public PescaniFilteriMerenja(int pritisakInPF1, int pritisakInPF1min, int pritisakInPF1max, int pritisakInPF1brDec,
                                int pritisakInPF2, int pritisakInPF2min, int pritisakInPF2max, int pritisakInPF2brDec, 
                                int pritisakInPF3, int pritisakInPF3min, int pritisakInPF3max, int pritisakInPF3brDec,
                                int pritisakInPF4, int pritisakInPF4min, int pritisakInPF4max, int pritisakInPF4brDec, 
                                int pritisakInPF5, int pritisakInPF5min, int pritisakInPF5max, int pritisakInPF5brDec, 
                                int pritisakInPF6, int pritisakInPF6min, int pritisakInPF6max, int pritisakInPF6brDec,
                                int pritisakOutPF1, int pritisakOutPF1min ,int pritisakOutPF1max, int pritisakOutPF1brDec, 
                                int pritisakOutPF2, int pritisakOutPF2min, int pritisakOutPF2max, int pritisakOutPF2brDec, 
                                int pritisakOutPF3, int pritisakOutPF3min, int pritisakOutPF3max, int pritisakOutPF3brDec, 
                                int pritisakOutPF4, int pritisakOutPF4min, int pritisakOutPF4max, int pritisakOutPF4brDec,
                                int pritisakOutPF5, int pritisakOutPF5min, int pritisakOutPF5max, int pritisakOutPF5brDec, 
                                int pritisakOutPF6, int pritisakOutPF6min, int pritisakOutPF6max, int pritisakOutPF6brDec){
        
        
        this.pritisakInPF1 = new Merenja(pritisakInPF1, pritisakInPF1min, pritisakInPF1max, pritisakInPF1brDec);
        this.pritisakInPF2 = new Merenja(pritisakInPF2, pritisakInPF2min, pritisakInPF2max, pritisakInPF2brDec);
        this.pritisakInPF3 = new Merenja(pritisakInPF3, pritisakInPF3min, pritisakInPF3max, pritisakInPF3brDec);
        this.pritisakInPF4 = new Merenja(pritisakInPF4, pritisakInPF4min, pritisakInPF4max, pritisakInPF4brDec);
        this.pritisakInPF5 = new Merenja(pritisakInPF5, pritisakInPF5min, pritisakInPF5max, pritisakInPF5brDec);
        this.pritisakInPF6 = new Merenja(pritisakInPF6, pritisakInPF6min, pritisakInPF6max, pritisakInPF6brDec);
        
        this.pritisakOutPF1 = new Merenja(pritisakOutPF1, pritisakOutPF1min, pritisakOutPF1max, pritisakOutPF1brDec);
        this.pritisakOutPF2 = new Merenja(pritisakOutPF2, pritisakOutPF2min, pritisakOutPF2max, pritisakOutPF2brDec);
        this.pritisakOutPF3 = new Merenja(pritisakOutPF3, pritisakOutPF3min, pritisakOutPF3max, pritisakOutPF3brDec);
        this.pritisakOutPF4 = new Merenja(pritisakOutPF4, pritisakOutPF4min, pritisakOutPF4max, pritisakOutPF4brDec);
        this.pritisakOutPF5 = new Merenja(pritisakOutPF5, pritisakOutPF5min, pritisakOutPF5max, pritisakOutPF5brDec);
        this.pritisakOutPF6 = new Merenja(pritisakOutPF6, pritisakOutPF6min, pritisakOutPF6max, pritisakOutPF6brDec);
        
    }


    public Merenja getPritisakInPF1() {
        return pritisakInPF1;
    }

    public Merenja getPritisakInPF2() {
        return pritisakInPF2;
    }

    public Merenja getPritisakInPF3() {
        return pritisakInPF3;
    }

    public Merenja getPritisakInPF4() {
        return pritisakInPF4;
    }

    public Merenja getPritisakInPF5() {
        return pritisakInPF5;
    }

    public Merenja getPritisakInPF6() {
        return pritisakInPF6;
    }

    public Merenja getPritisakOutPF1() {
        return pritisakOutPF1;
    }

    public Merenja getPritisakOutPF2() {
        return pritisakOutPF2;
    }

    public Merenja getPritisakOutPF3() {
        return pritisakOutPF3;
    }

    public Merenja getPritisakOutPF4() {
        return pritisakOutPF4;
    }

    public Merenja getPritisakOutPF5() {
        return pritisakOutPF5;
    }

    public Merenja getPritisakOutPF6() {
        return pritisakOutPF6;
    }

    

}
