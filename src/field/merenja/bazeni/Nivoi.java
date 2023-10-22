/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.merenja.bazeni;

import field.merenja.Merenja;

/**
 *
 * @author branko.scekic
 */
public class Nivoi {
    private final Merenja bazenNeutralizacioni;
    private final Merenja bazenDekaNefiltriraneVode;
    private final Merenja bazenOtpadneVodeOdPranjaPescanihFiltera;
    private final Merenja bazenDekaFiltriraneVode;
    
    public Nivoi(){
        this.bazenNeutralizacioni = new Merenja(228,0,200,0, 464);
        this.bazenDekaNefiltriraneVode = new Merenja(229,0,1000,0);
        this.bazenOtpadneVodeOdPranjaPescanihFiltera = new Merenja(230,0,200,0);
        this.bazenDekaFiltriraneVode = new Merenja(231,0,180,0);
        
    }

    public Merenja getBazenNeutralizacioni() {
        return bazenNeutralizacioni;
    }

    public Merenja getBazenDekaNefiltriraneVode() {
        return bazenDekaNefiltriraneVode;
    }

    public Merenja getBazenOtpadneVodeOdPranjaPescanihFiltera() {
        return bazenOtpadneVodeOdPranjaPescanihFiltera;
    }

    public Merenja getBazenDekaFiltriraneVode() {
        return bazenDekaFiltriraneVode;
    }

    
}
