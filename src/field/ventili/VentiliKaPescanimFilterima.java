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
public class VentiliKaPescanimFilterima {
    //pumpe ka pescanim filterima
    private final PregradniVentili APKPF_PotisBr1;
    private final PregradniVentili APKPF_PotisBr2;
    private final PregradniVentili APKPF_PotisBr3;
    private final PregradniVentili APKPF_PotisBr4;
    private final PregradniVentili APKPF_PotisBr5;
    private final PregradniVentili APKPF_PotisBr6;
    
    public VentiliKaPescanimFilterima(){
        APKPF_PotisBr1 = new PregradniVentili("07A0105", MutantToDec.getValue("132"), MutantToDec.getValue("133"), MutantToDec.getValue("138"),
                MutantToDec.getValue("139"), MutantToDec.getValue("13A"), MutantToDec.getValue("13B"),"Ventil na potisu pumpe br 1 ka pescanim filterima");
        APKPF_PotisBr2 = new PregradniVentili("07A0205", MutantToDec.getValue("146"),MutantToDec.getValue("147"),MutantToDec.getValue("14C")
                ,MutantToDec.getValue("14D"),MutantToDec.getValue("14E"),MutantToDec.getValue("14F"),"Ventil na potisu pumpe br 2 ka pescanim filterima");
        APKPF_PotisBr3 = new PregradniVentili("07A0305", MutantToDec.getValue("15A"), MutantToDec.getValue("15B"), 
                MutantToDec.getValue("160"), MutantToDec.getValue("161"), MutantToDec.getValue("162"), 
                MutantToDec.getValue("163"),"Ventil na potisu pumpe br 3 ka pescanim filterima");
        APKPF_PotisBr4 = new PregradniVentili("07A0405", MutantToDec.getValue("16E"), MutantToDec.getValue("16F"), MutantToDec.getValue("174"), 
                MutantToDec.getValue("175"), MutantToDec.getValue("176"), MutantToDec.getValue("177"),"Ventil na potisu pumpe br 4 ka pescanim filterima");
        APKPF_PotisBr5 = new PregradniVentili("07A0505", MutantToDec.getValue("182"), MutantToDec.getValue("183"), MutantToDec.getValue("188"),
                MutantToDec.getValue("189"), MutantToDec.getValue("18A"), MutantToDec.getValue("18B"),
                "Ventil na potisu pumpe br 5 ka pescanim filterima");
        APKPF_PotisBr6 = new PregradniVentili("07A0605", MutantToDec.getValue("196"), MutantToDec.getValue("197"), 
                MutantToDec.getValue("19C"), MutantToDec.getValue("19D"), MutantToDec.getValue("19E") ,
                MutantToDec.getValue("19F"),"Ventil na potisu pumpe br 6 ka pescanim filterima");
    }

    public PregradniVentili getAPKPF_PotisBr1() {
        return APKPF_PotisBr1;
    }

    public PregradniVentili getAPKPF_PotisBr2() {
        return APKPF_PotisBr2;
    }

    public PregradniVentili getAPKPF_PotisBr3() {
        return APKPF_PotisBr3;
    }

    public PregradniVentili getAPKPF_PotisBr4() {
        return APKPF_PotisBr4;
    }

    public PregradniVentili getAPKPF_PotisBr5() {
        return APKPF_PotisBr5;
    }

    public PregradniVentili getAPKPF_PotisBr6() {
        return APKPF_PotisBr6;
    }
    
}
