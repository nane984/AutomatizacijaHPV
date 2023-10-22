/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.merenja.protoci;

import field.merenja.Protok;

/**
 *
 * @author branko.scekic
 */
public class ProtociPescaniFilteri {
    private final Protok protokPF1;
    private final Protok protokPF2;
    private final Protok protokPF3;
    private final Protok protokPF4;
    private final Protok protokPF5;
    private final Protok protokPF6;
    
    public ProtociPescaniFilteri(){
        protokPF1 = new Protok(234,0,250,0,
                                410, 411);
        
        protokPF2 = new Protok(235,0,250,0, 
                                412, 413);
        
        protokPF3 = new Protok(236,0,250,0, 
                                414, 415);
        
        protokPF4 = new Protok(237,0,250,0, 
                                416, 417);
        
        protokPF5 = new Protok(238,0,250,0, 
                                418, 419);
        
        protokPF6 = new Protok(239,0,250,0, 
                                420, 421);
    }

    public Protok getProtokPF1() {
        return protokPF1;
    }

    public Protok getProtokPF2() {
        return protokPF2;
    }

    public Protok getProtokPF3() {
        return protokPF3;
    }

    public Protok getProtokPF4() {
        return protokPF4;
    }

    public Protok getProtokPF5() {
        return protokPF5;
    }

    public Protok getProtokPF6() {
        return protokPF6;
    }
    
}
