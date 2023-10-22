/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.merenja.neutralnaJonska;

import field.merenja.Merenja;

/**
 *
 * @author branko.scekic
 */
public class NeutralnaJonskaMerenja {
    
    private final Merenja pritisakInNJ;
    private final Merenja pritisakOutNJ;
   
    
    public NeutralnaJonskaMerenja(int pritisakInNJ1,int pritisakInNJ1min, int pritisakInNJ1max, int brDecpinnj1, 
                                int pritisakOutNJ1, int pritisakOutNJ1min, int pritisakOutNJ1max, int brDecpoutnj1){
        
        this.pritisakInNJ = new Merenja(pritisakInNJ1, pritisakInNJ1min, pritisakInNJ1max, brDecpinnj1);
        
        
        this.pritisakOutNJ = new Merenja(pritisakOutNJ1, pritisakInNJ1min, pritisakInNJ1max, brDecpoutnj1);
        
    }


    public Merenja getPritisakInNJ() {
        return pritisakInNJ;
    }

    public Merenja getPritisakOutNJ() {
        return pritisakOutNJ;
    }

    
      
}
