/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili;

import field.ventili.demiLinija1.JBAF01;
import field.ventili.demiLinija1.JKKF01;
import field.ventili.demiLinija1.MF01;
import field.ventili.demiLinija1.SBAF01;
import field.ventili.demiLinija2.JBAF02;
import field.ventili.demiLinija2.JKKF02;
import field.ventili.demiLinija2.MF02;
import field.ventili.demiLinija2.SBAF02;
import field.ventili.demiLinija3.JBAF03;
import field.ventili.demiLinija3.JKKF03;
import field.ventili.demiLinija3.MF03;
import field.ventili.demiLinija3.SBAF03;

/**
 *
 * @author branko.scekic
 */
public class DemiLinije {
    private final JKKF01 jkkf01;
    private final SBAF01 sbaf01;
    private final JBAF01 jbaf01;
    private final MF01 mf01;
    
    private final JKKF02 jkkf02;
    private final SBAF02 sbaf02;
    private final JBAF02 jbaf02;
    private final MF02 mf02;
    
    private final JKKF03 jkkf03;
    private final SBAF03 sbaf03;
    private final JBAF03 jbaf03;
    private final MF03 mf03;
    
    public DemiLinije(){
        jkkf01 = new JKKF01();
        sbaf01 = new SBAF01();
        jbaf01 = new JBAF01();
        mf01 = new MF01();
        
        jkkf02 = new JKKF02();
        sbaf02 = new SBAF02();
        jbaf02 = new JBAF02();
        mf02 = new MF02();
        
        jkkf03 = new JKKF03();
        sbaf03 = new SBAF03();
        jbaf03 = new JBAF03();
        mf03 = new MF03();
    }

    public JKKF01 getJkkf01() {
        return jkkf01;
    }

    public SBAF01 getSbaf01() {
        return sbaf01;
    }

    public JBAF01 getJbaf01() {
        return jbaf01;
    }

    public MF01 getMf01() {
        return mf01;
    }

    public JKKF02 getJkkf02() {
        return jkkf02;
    }

    public SBAF02 getSbaf02() {
        return sbaf02;
    }

    public JBAF02 getJbaf02() {
        return jbaf02;
    }

    public MF02 getMf02() {
        return mf02;
    }

    public JKKF03 getJkkf03() {
        return jkkf03;
    }

    public SBAF03 getSbaf03() {
        return sbaf03;
    }

    public JBAF03 getJbaf03() {
        return jbaf03;
    }

    public MF03 getMf03() {
        return mf03;
    }
    
    
}
