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
public class ProtociNeutralna {
    private final Protok protokNJ1;
    private final Protok protokNJ2;
    private final Protok protokNJ3;
    private final Protok magistralniVod;
    
    public ProtociNeutralna(){
        this.protokNJ1 = new Protok(244,0,800,1,400, 401);
        this.protokNJ2 = new Protok(245,0,800,1,402, 403);
        this.protokNJ3 = new Protok(246,0,800,1,404, 405);
        this.magistralniVod = new Protok(247,0,160,0,428, 429);
    }

    public Protok getProtokNJ1() {
        return protokNJ1;
    }

    public Protok getProtokNJ2() {
        return protokNJ2;
    }

    public Protok getProtokNJ3() {
        return protokNJ3;
    }

    public Protok getMagistralniVod() {
        return magistralniVod;
    }
    
    
}
