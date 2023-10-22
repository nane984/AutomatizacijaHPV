/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.merenja.demiLinije;

import field.merenja.Merenja;

/**
 *
 * @author branko.scekic
 */
public class DemiLinijaMerenjaKonstruktor {
    private final DemiLinijaMerenja demiLinija01;
    private final DemiLinijaMerenja demiLinija02;
    private final DemiLinijaMerenja demiLinija03;
    private final Merenja vodljivostKolektor;
    
    public DemiLinijaMerenjaKonstruktor(){
        this.demiLinija01 = new DemiLinijaMerenja(200, 0, 1000, 2,
                                                  201, 0, 1000, 2,
                                                  202, 0, 1000, 2,
                                                  203, 0 ,1000, 2,
                                                  204, 0, 1000, 2,
                                                  205, 0, 1000, 2,
                                                  206, 0, 1000, 2,
                                                  207, 0, 1000, 2,
                                                  296, 0, 200, 0,
                                                  173, 0, 20, 1,
                                                  297, 0, 2, 2);
        
        
        this.demiLinija02 = new DemiLinijaMerenja(208, 0, 1000, 2,
                                                  209, 0, 1000, 2,
                                                  210, 0, 1000, 2,
                                                  211, 0 ,1000, 2,
                                                  212, 0, 1000, 2,
                                                  213, 0, 1000, 2,
                                                  214, 0, 1000, 2,
                                                  215, 0, 1000, 2,
                                                  298, 0, 200, 0,
                                                  174, 0, 20, 1,
                                                  299, 0, 2, 2);
        
        this.demiLinija03 = new DemiLinijaMerenja(216, 0, 1000, 2,
                                                  217, 0, 1000, 2,
                                                  218, 0, 1000, 2,
                                                  219, 0 ,1000, 2,
                                                  220, 0, 1000, 2,
                                                  221, 0, 1000, 2,
                                                  222, 0, 1000, 2,
                                                  223, 0, 1000, 2,
                                                  300, 0, 200, 0,
                                                  175, 0, 20, 1,
                                                  301, 0, 2, 2);
        
        this.vodljivostKolektor = new Merenja(176, 0, 1, 2);
        
    }

    public DemiLinijaMerenja getDemiLinija01() {
        return demiLinija01;
    }

    public DemiLinijaMerenja getDemiLinija02() {
        return demiLinija02;
    }

    public DemiLinijaMerenja getDemiLinija03() {
        return demiLinija03;
    }

    public Merenja getVodljivostKolektor() {
        return vodljivostKolektor;
    }
    
    
    
}
