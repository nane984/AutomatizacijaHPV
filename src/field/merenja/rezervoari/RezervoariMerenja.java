/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.merenja.rezervoari;

import field.merenja.Merenja;

/**
 *
 * @author branko.scekic
 */
public class RezervoariMerenja {
    //DEMINERALIZACIJA ()
    private final Merenja nivoRezervoarDEMIvode1000m3br1;
    private final Merenja nivoRezervoarDEMIvode1000m3br2;
    private final Merenja nivoRezervoarDEMIvode150m3;
    
    //neutralna jonska izmena (grejanje)
    private final Merenja nivoRezervoarKompenzacioni500m3;
    
    
    public RezervoariMerenja(){   
        this.nivoRezervoarDEMIvode1000m3br1 = new Merenja(192,0,785,0);
        this.nivoRezervoarDEMIvode1000m3br2 = new Merenja(193,0,785,0); 
        this.nivoRezervoarDEMIvode150m3 = new Merenja(227,0,500,0);
        this.nivoRezervoarKompenzacioni500m3 = new Merenja(194,0,785,0);
    }

    public Merenja getNivoRezervoarDEMIvode1000m3br1() {
        return nivoRezervoarDEMIvode1000m3br1;
    }

    public Merenja getNivoRezervoarDEMIvode1000m3br2() {
        return nivoRezervoarDEMIvode1000m3br2;
    }

    public Merenja getNivoRezervoarDEMIvode150m3() {
        return nivoRezervoarDEMIvode150m3;
    }

    public Merenja getNivoRezervoarKompenzacioni500m3() {
        return nivoRezervoarKompenzacioni500m3;
    }
}
