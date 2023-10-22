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
public class ProtociRegeneracija {
    private final Protok protokDemiVodeRazblazivanjeHCL;   
    private final Protok protokDemiVodeRazblazivanjeNaOH;
    private final Protok protokNaOHRegeneracija;
    private final Protok protokHClPotisDozirPumpi;
    
    public ProtociRegeneracija(){
        protokDemiVodeRazblazivanjeHCL = new Protok(290, 0, 600, 1, 440,441);
        protokDemiVodeRazblazivanjeNaOH = new Protok(291, 0, 600, 1, 440,441);
        
        protokNaOHRegeneracija = new Protok(292, 0, 3500, 2, 440,441);
        protokHClPotisDozirPumpi = new Protok(189, 0, 50, 1, 440,441);
    }

    public Protok getProtokDemiVodeRazblazivanjeHCL() {
        return protokDemiVodeRazblazivanjeHCL;
    }

    public Protok getProtokDemiVodeRazblazivanjeNaOH() {
        return protokDemiVodeRazblazivanjeNaOH;
    }

    public Protok getProtokNaOHRegeneracija() {
        return protokNaOHRegeneracija;
    }

    public Protok getProtokHClPotisDozirPumpi() {
        return protokHClPotisDozirPumpi;
    }
    
    
}
