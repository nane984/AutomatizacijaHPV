/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author branko.scekic
 */
public class AnalogToDigital {
    
    public static boolean isClose(int i){
        return i<10;
    }
    
    public static boolean isOpen(int i){
        return i>990;
    } 
}
