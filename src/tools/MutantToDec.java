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
public class MutantToDec {
    
    
    public static int getValue(String str){
        int res = 0;
        //System.out.println("Ulaz pre konvertovanja " + str);
        if(str.length()>1){
            String resostatak = str.substring(str.length() - 1);
            String resStr = removeLastChar(str);
            res= Integer.parseInt(resStr);
            res = res * 16 + Integer.parseInt(resostatak,16);
            //System.out.println("Posle konvertovanja " + res);
            //System.out.println("______________________");
            return res;
        }else{
            
            //System.out.println("Ulaz posle konvertovanja " + Integer.parseInt(str,16));
            //System.out.println("_______________________ ");
         return    Integer.parseInt(str,16);
        }
    }
    
    private static String removeLastChar(String str) {
    return removeLastChars(str, 1);
}

    private static String removeLastChars(String str, int chars) {
        if(str.length()>1){
            return str.substring(0, str.length() - chars);
        }else{
            return str;
        }
    }
    
    
    public static void main(String[] abc){
        MutantToDec.getValue("F");
        MutantToDec.getValue("1F");
        MutantToDec.getValue("2F");
        MutantToDec.getValue("3F");
        MutantToDec.getValue("4F");
        MutantToDec.getValue("5F");
        
        MutantToDec.getValue("199E");
        MutantToDec.getValue("199F");
        MutantToDec.getValue("2000");
        
    }
}
