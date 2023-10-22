/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili;

import tools.MutantToDec;
import valve.globe.PregradniVentili;

/**
 *
 * @author branko.scekic
 */
public class VentiliPolielektrolit {
    //polielektrolit
    private final PregradniVentili PE_posuda1;
    private final PregradniVentili PE_posuda2;
    private final PregradniVentili PE_ventil1;
    private final PregradniVentili PE_ventil2;
    private final PregradniVentili PE_ventil3;
    private final PregradniVentili PE_kompenzaciona1;
    private final PregradniVentili PE_kompenzaciona2;
    private final PregradniVentili PE_vodaKaPosudi1;
    private final PregradniVentili PE_vodaKaPosudi2;
    
    public VentiliPolielektrolit(){
        PE_posuda1 = new PregradniVentili("04A0104", MutantToDec.getValue("200"), MutantToDec.getValue("201"), 
                MutantToDec.getValue("206"), MutantToDec.getValue("207"), MutantToDec.getValue("208"),MutantToDec.getValue("209"),"Ventil na izlazu iz posude PE01");
        PE_posuda2 = new PregradniVentili("04A0204", MutantToDec.getValue("20A"), MutantToDec.getValue("20B"), MutantToDec.getValue("210"),
                MutantToDec.getValue("211"), MutantToDec.getValue("212"), MutantToDec.getValue("213"),"Ventil na izlazu iz posude PE02");
        PE_ventil1 = new PregradniVentili("04A0305", MutantToDec.getValue("21E"), MutantToDec.getValue("21F"), MutantToDec.getValue("224"),
                MutantToDec.getValue("225"), MutantToDec.getValue("226"), MutantToDec.getValue("227"), "Ventil na potisu pumpe br 1");
        PE_ventil2 = new PregradniVentili("04A0405", MutantToDec.getValue("232"), MutantToDec.getValue("233"), MutantToDec.getValue("238"),
                MutantToDec.getValue("239"), MutantToDec.getValue("23A"), MutantToDec.getValue("23B"),"Ventil na potisu pumpe br 2");
        PE_ventil3 = new PregradniVentili("04A0505", MutantToDec.getValue("246"), MutantToDec.getValue("247"), MutantToDec.getValue("24C"),
                MutantToDec.getValue("22D"), MutantToDec.getValue("22E"), MutantToDec.getValue("22F"),"Ventil na potisu pumpe br 3");
        
        PE_kompenzaciona1 = new PregradniVentili("04A0313", MutantToDec.getValue("250"), MutantToDec.getValue("251"), MutantToDec.getValue("256"),
                MutantToDec.getValue("257"), MutantToDec.getValue("258"), MutantToDec.getValue("259"),"Ventil na izlazu iz kompenzacione posude br 1");
        PE_kompenzaciona2 = new PregradniVentili("04A0413", MutantToDec.getValue("25A"), MutantToDec.getValue("25B"), MutantToDec.getValue("260"),
                MutantToDec.getValue("261"), MutantToDec.getValue("262"), MutantToDec.getValue("263"),"Ventil na izlazu iz kompenzacione posude br 2");
        PE_vodaKaPosudi1 = new PregradniVentili("04A0315", MutantToDec.getValue("264"), MutantToDec.getValue("265"), MutantToDec.getValue("26A"),
                MutantToDec.getValue("26B"), MutantToDec.getValue("26C"), MutantToDec.getValue("26D"),"Ventil za vodu ka reaktoru br 1");
        PE_vodaKaPosudi2 = new PregradniVentili("04A0415", MutantToDec.getValue("26E"), MutantToDec.getValue("26F"), MutantToDec.getValue("274"),
                MutantToDec.getValue("275"), MutantToDec.getValue("276"), MutantToDec.getValue("277"),"Ventil za vodu ka reaktoru br 2");
    }

    public PregradniVentili getPE_posuda1() {
        return PE_posuda1;
    }

    public PregradniVentili getPE_posuda2() {
        return PE_posuda2;
    }

    public PregradniVentili getPE_ventil1() {
        return PE_ventil1;
    }

    public PregradniVentili getPE_ventil2() {
        return PE_ventil2;
    }

    public PregradniVentili getPE_ventil3() {
        return PE_ventil3;
    }

    public PregradniVentili getPE_kompenzaciona1() {
        return PE_kompenzaciona1;
    }

    public PregradniVentili getPE_kompenzaciona2() {
        return PE_kompenzaciona2;
    }

    public PregradniVentili getPE_vodaKaPosudi1() {
        return PE_vodaKaPosudi1;
    }

    public PregradniVentili getPE_vodaKaPosudi2() {
        return PE_vodaKaPosudi2;
    }
    
}
