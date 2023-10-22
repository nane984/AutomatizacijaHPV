/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.merenja.neutralnaJonska;

/**
 *
 * @author branko.scekic
 */
public class NeutralnaJonskaMerenjaKonstruktor {
    private final NeutralnaJonskaMerenja njMerenjaL1;
    private final NeutralnaJonskaMerenja njMerenjaL2;
    private final NeutralnaJonskaMerenja njMerenjaL3;
    
    public NeutralnaJonskaMerenjaKonstruktor(){
        this.njMerenjaL1 = new NeutralnaJonskaMerenja(282,0,1000,2, 
                                                      285,0,1000,2);
        
        this.njMerenjaL2 = new NeutralnaJonskaMerenja(283,0,1000,2,
                                                      286,0,1000,2);
        
        this.njMerenjaL3 = new NeutralnaJonskaMerenja(284,0,1000,2,
                                                      287,0,1000,2  );
    }

    public NeutralnaJonskaMerenja getNjMerenjaL1() {
        return njMerenjaL1;
    }

    public NeutralnaJonskaMerenja getNjMerenjaL2() {
        return njMerenjaL2;
    }

    public NeutralnaJonskaMerenja getNjMerenjaL3() {
        return njMerenjaL3;
    }
    
    
}
