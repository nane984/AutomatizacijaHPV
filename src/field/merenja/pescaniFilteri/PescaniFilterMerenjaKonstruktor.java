/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.merenja.pescaniFilteri;

/**
 *
 * @author branko.scekic
 */
public class PescaniFilterMerenjaKonstruktor {
    
    private final PescaniFilteriMerenja pfMerenja;
    
    public PescaniFilterMerenjaKonstruktor(){
        pfMerenja = new PescaniFilteriMerenja(248,0,1000,2, 
                                              249,0,1000,2, 
                                              250,0,1000,2, 
                                              251,0,1000,2, 
                                              252,0,1000,2, 
                                              253,0,1000,2, 
                                              254,0,1000,2, 
                                              255,0,1000,2, 
                                              256,0,1000,2, 
                                              257,0,1000,2, 
                                              258,0,1000,2, 
                                              259,0,1000,2);
    }

    public PescaniFilteriMerenja getPfMerenja() {
        return pfMerenja;
    }
    
    
}
