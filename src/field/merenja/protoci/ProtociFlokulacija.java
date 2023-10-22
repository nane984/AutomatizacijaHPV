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
public class ProtociFlokulacija {
    private final Protok protokSiroveVodeR1;
    private final Protok protokSiroveVodeR2;
    
    public ProtociFlokulacija(){
        this.protokSiroveVodeR1 = new Protok(232,0,800,0,406, 407);
        this.protokSiroveVodeR2 = new Protok(233,0,800,0,408, 409);
    }

    public Protok getProtokSiroveVodeR1() {
        return protokSiroveVodeR1;
    }

    public Protok getProtokSiroveVodeR2() {
        return protokSiroveVodeR2;
    }
}
