/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili;

import field.ventili.jonskaIzmena.JonskaIzmena01;
import field.ventili.jonskaIzmena.JonskaIzmena02;
import field.ventili.jonskaIzmena.JonskaIzmena03;

/**
 *
 * @author branko.scekic
 */
public class JonskaIzmena {
    private final JonskaIzmena01 jonskaIzmena01;
    private final JonskaIzmena02 jonskaIzmena02;
    private final JonskaIzmena03 jonskaIzmena03;
    
    public JonskaIzmena(){
        jonskaIzmena01 = new JonskaIzmena01();
        jonskaIzmena02 = new JonskaIzmena02();
        jonskaIzmena03 = new JonskaIzmena03();
    }

    public JonskaIzmena01 getJonskaIzmena01() {
        return jonskaIzmena01;
    }

    public JonskaIzmena02 getJonskaIzmena02() {
        return jonskaIzmena02;
    }

    public JonskaIzmena03 getJonskaIzmena03() {
        return jonskaIzmena03;
    }
    
    
}
