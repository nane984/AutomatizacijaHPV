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
public class ProtociPretovarnaRampa {
     private final Protok protokLuzine;   
     private final Protok protokKiseline;
     
     public ProtociPretovarnaRampa(){
         this.protokLuzine = new Protok(198, 0, 180, 1, 440,441);
         this.protokKiseline = new Protok(199, 0, 180, 1, 442,443);
     }

    public Protok getProtokLuzine() {
        return protokLuzine;
    }

    public Protok getProtokKiseline() {
        return protokKiseline;
    }
     
     
}
