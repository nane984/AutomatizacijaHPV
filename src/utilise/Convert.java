/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilise;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import tools.ShiftPoint;

/**
 *
 * @author Branko
 */
public class Convert {
    public static String convertDateToString(Date date) {
        String dateStr = new String();
        String format = "dd.MM.yyyy  HH:mm:ss";
        DateFormat df = new SimpleDateFormat(format);
        try {
            dateStr = df.format(date);
        } catch (Exception ex) {
            //System.out.println(ex);
        }
        return dateStr;
    }
    
     public static String convertDateToStringTime(Date date) {
        String dateStr = new String();
        String format = "HH:mm:ss";
        DateFormat df = new SimpleDateFormat(format);
        try {
            dateStr = df.format(date);
        } catch (Exception ex) {
            //System.out.println(ex);
        }
        return dateStr;
    }
     
      public static String convertDateToStringDate(Date date) {
        String dateStr = new String();
        String format = "dd.MM.yyyy";
        DateFormat df = new SimpleDateFormat(format);
        try {
            dateStr = df.format(date);
        } catch (Exception ex) {
            //System.out.println(ex);
        }
        return dateStr;
    }
    
    public static Date convertStringToDate(String dateStr) {
        Date date = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(dateStr.length()>7){
     
            String[] datum = dateStr.split("\\.");
            
            String day = datum[0];
            String month = datum[1];
            String year = datum[2];
            
            
            
    
            try {
                date = df.parse(year+"-"+month+"-"+day + " 00" + ":" + "00" + ":" + "00");
                //System.out.println("Datum je " + convertDateToString(date));
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }else{
            try {
                //date=df.parse("2001-01-01");
            }catch(Exception ex) {
                System.out.println(ex);
            }
        }
        return date;
    } 
    
     public static Date convertStringToDate(String dateStr, String vreme) {
        Date date = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        //System.out.println("Vreme je " + vreme);
        
        if(dateStr.length()>7){
     
            String[] datum = dateStr.split("\\.");
            
            String day = datum[0];
            String month = datum[1];
            String year = datum[2];
            
            String[] time = vreme.split("\\:");
            
            String hour = time[0];
            String min = time[1];
            
    
            try {
                date = df.parse(year+"-"+month+"-"+day +" " + hour + ":" + min + ":" + "59");
                //System.out.println("Datum je " + convertDateToString(date));
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }else{
            try {
                //date=df.parse("2001-01-01");
            }catch(Exception ex) {
                System.out.println(ex);
            }
        }
        return date;
    }
     
      public static String intToLong(int visi, int nizi) {
        int a = 0;
        try {
            a = visi << 16 | nizi & 0xFFFF;
            return ShiftPoint.shiftonePoint(a, 1) + " m3";
        } catch (Exception e) {

        }
        return "*";
    }
     
    public static String intToLongPrivremeno(int visi, int nizi) {
        int a = 0;
        try {
            a = visi << 16 | nizi & 0xFFFF;
            return ShiftPoint.shiftonePoint(a, 1);
        } catch (Exception e) {

        }
        return "*";
    }
    
    public static String getRoundDouble(Double db, int Format){
        BigDecimal bd = new BigDecimal(Double.toString(db));
        bd = bd.setScale(Format, RoundingMode.HALF_UP);
        return bd.toString();
    }
}
