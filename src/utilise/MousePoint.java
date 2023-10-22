/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilise;

import java.awt.MouseInfo;
import java.awt.Point;

/**
 *
 * @author branko.scekic
 */
public class MousePoint {
    public static Point GetMousePoint(Point p ) {
        //Point p = MouseInfo.getPointerInfo().getLocation();
        int x = p.x;
        int y;
        
        if (p.y > 712) {
            y = 712;
        } else {
            y = p.y;
        }
        
        p.x = x;
        p.y = y;
        
        return p;
        
    }
    
    public static Point GetMousePointCentarDisplay(Point p) {
        int x = 0;
        int y = 250;
        
        if (p.x > 0 && p.x < 1920) {
            x = 700;
        } else if(p.x < 0 && p.x > -1920){
            x = -1000;
        }else if(p.x < -1920 && p.x > -3840){
            x = -2500;
        }else if(p.x < -3840 && p.x > -5820){
            x = -4000;
        }else if(p.x > 1920 && p.x < 3840){
            x = 2500;
        }else if(p.x > 3840 && p.x < 5820){
            x = 4000;
        }
        
        p.x = x;
        p.y = y;
        
        return p;
        
    }
}
