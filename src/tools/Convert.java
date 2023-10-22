/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import tools.ShiftPoint;

/**
 *
 * @author branko.scekic
 */
public class Convert {
    public static String intToLong(int visi, int nizi) {
        int a = 0;
        try {
            a = visi << 16 | nizi & 0xFFFF;
            return ShiftPoint.shiftonePoint(a, 1) + " m3";
        } catch (Exception e) {

        }
        return "*";
    }
}
