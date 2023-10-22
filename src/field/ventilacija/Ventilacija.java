/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventilacija;

/**
 *
 * @author branko.scekic
 */
public class Ventilacija {
    private final Vent ubacivanjeVazduha;
    private final Vent izbacivanjeVazduha;
    
    public Ventilacija(){
        this.ubacivanjeVazduha = new Vent("2407", "856", "857");
        this.izbacivanjeVazduha = new Vent("2408", "858", "859");
    }

    public Vent getUbacivanjeVazduha() {
        return ubacivanjeVazduha;
    }

    public Vent getIzbacivanjeVazduha() {
        return izbacivanjeVazduha;
    }
    
}
