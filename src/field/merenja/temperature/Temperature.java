/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.merenja.temperature;

import field.merenja.Merenja;

/**
 *
 * @author branko.scekic
 */
public class Temperature {
    private final Merenja tempLuzineRezervoar13a03;
    private final Merenja tempDemiVodeRezervoar150m3;
    
    public Temperature(){
        tempLuzineRezervoar13a03 = new Merenja(288, 0, 250, 0);
        tempDemiVodeRezervoar150m3 = new Merenja(289, 0, 250, 0);
    }

    public Merenja getTempLuzineRezervoar13a03() {
        return tempLuzineRezervoar13a03;
    }

    public Merenja getTempDemiVodeRezervoar150m3() {
        return tempDemiVodeRezervoar150m3;
    }
}
