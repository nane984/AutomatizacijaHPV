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
public class ProtociDemiLinije {
    private final Protok protokDL1in;   
    private final Protok protokDL1out;
    private final Protok protokDL2in;   
    private final Protok protokDL2out;
    private final Protok protokDL3in;   
    private final Protok protokDL3out;
    private final Protok protokDemiLinijeZbir;
    
    public ProtociDemiLinije(){
        this.protokDL1in = new Protok(168, 0, 200, 1, 422,423);
        this.protokDL1out = new Protok (171, 0, 200, 1, 432, 433);
        
        this.protokDL2in = new Protok(169, 0, 200, 1, 424,425);
        this.protokDL2out = new Protok (172, 0, 200, 1, 434, 435);
        
        this.protokDL3in = new Protok(170, 0, 200, 1, 426, 427);
        this.protokDL3out = new Protok (338, 0, 200, 1, 436, 437);
        
        this.protokDemiLinijeZbir = new Protok(339, 0, 200, 1, 438, 439);
    }

    public Protok getProtokDL1in() {
        return protokDL1in;
    }

    public Protok getProtokDL1out() {
        return protokDL1out;
    }

    public Protok getProtokDL2in() {
        return protokDL2in;
    }

    public Protok getProtokDL2out() {
        return protokDL2out;
    }

    public Protok getProtokDL3in() {
        return protokDL3in;
    }

    public Protok getProtokDL3out() {
        return protokDL3out;
    }

    public Protok getProtokMagistralniVod() {
        return protokDemiLinijeZbir;
    }
    
    
}
