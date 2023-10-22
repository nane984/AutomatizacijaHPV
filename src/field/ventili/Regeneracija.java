/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.ventili;

import tools.MutantToDec;
import valve.globe.PregradniVentili;
import valve.reg.RegulacioniVentili;

/**
 *
 * @author branko.scekic
 */
public class Regeneracija {
    private final RegulacioniVentili regVentHCl;
    private final PregradniVentili ventHCLusisPumpeBr1;
    private final PregradniVentili ventHCLpotisPumpeBr1;
    private final PregradniVentili ventHCLusisPumpeBr2;
    private final PregradniVentili ventHCLpotisPumpeBr2;
    private final PregradniVentili ventHCLzajednickiUsis;
    private final PregradniVentili ventHCLzajednickiPotis;
    
    private final RegulacioniVentili regVentNaOH;
    private final PregradniVentili ventNaOHusisPumpeBr1;
    private final PregradniVentili ventNaOHpotisPumpeBr1;
    private final PregradniVentili ventNaOHusisPumpeBr2;
    private final PregradniVentili ventNaOHpotisPumpeBr2;
    private final PregradniVentili ventNaOHzajednickiUsis;
    private final PregradniVentili ventNaOHzajednickiPotis;
    
    
/* 
HCL:
12A0801-usis pumpe br 1
12A0805-potis pumpe br 1
12A0901-usis pumpe br 2
12A0905-potis pumpe br 2
12A0001-zajednički usis za obe pumpe
12A0005-zajednički potis za obe pumpe
12A100-regulacioni ventil za regulaciju protoka vode za razblaživanje HCl
 
NaOH
13A0701-usis pumpe br 1
13A0705-potis pumpe br 1
13A0801-usis pumpe br 2
13A0805-potis pumpe br 2
13A0001-zajednički usis za obe pumpe
13A0005-zajednički potis za obe pumpe
13A100-regulacioni ventil za regulaciju protoka vode za razblaživanje NaOH
*/
    
    public Regeneracija(){
        regVentHCl = new RegulacioniVentili("12A100", 333, 384 , 1, "Reg ventil na vodi za razblazivanje HCl");
        regVentNaOH = new RegulacioniVentili("13A100", 334, 385 , 1, "Reg ventil na vodi za razblazivanje NaOH");
        
        ventHCLusisPumpeBr1 = new PregradniVentili("12A0801", MutantToDec.getValue("173C"), MutantToDec.getValue("173D"), 
                MutantToDec.getValue("1742"), MutantToDec.getValue("1743"), MutantToDec.getValue("1744"),MutantToDec.getValue("1745"),"Ventil na usisu pumpe br 1 HCL");
        
        ventHCLpotisPumpeBr1 = new PregradniVentili("12A0805", MutantToDec.getValue("1746"), MutantToDec.getValue("1747"), 
                MutantToDec.getValue("174C"), MutantToDec.getValue("174D"), MutantToDec.getValue("174E"),MutantToDec.getValue("174F"),"Ventil na potisu pumpe br 1 HCL");
        
        ventHCLusisPumpeBr2 = new PregradniVentili("12A0901", MutantToDec.getValue("1750"), MutantToDec.getValue("1751"), 
                MutantToDec.getValue("1756"), MutantToDec.getValue("1757"), MutantToDec.getValue("1758"),MutantToDec.getValue("1759"),"Ventil na usisu pumpe br 2 HCL");
        
        ventHCLpotisPumpeBr2 = new PregradniVentili("12A0905", MutantToDec.getValue("175A"), MutantToDec.getValue("175B"), 
                MutantToDec.getValue("1760"), MutantToDec.getValue("1761"), MutantToDec.getValue("1762"),MutantToDec.getValue("1763"),"Ventil na potisu pumpe br 2 HCL");
        
        ventHCLzajednickiUsis = new PregradniVentili("12A0001", MutantToDec.getValue("1764"), MutantToDec.getValue("1765"), 
                MutantToDec.getValue("176A"), MutantToDec.getValue("176B"), MutantToDec.getValue("176C"),MutantToDec.getValue("176D"),"Ventil zajednički usis za obe pumpe HCL");
        
        ventHCLzajednickiPotis = new PregradniVentili("12A0005", MutantToDec.getValue("176E"), MutantToDec.getValue("176F"), 
                MutantToDec.getValue("1774"), MutantToDec.getValue("1775"), MutantToDec.getValue("1776"),MutantToDec.getValue("1777"),"Ventil zajednički potis za obe pumpe HCL");
        
        ventNaOHusisPumpeBr1 = new PregradniVentili("13A0701", MutantToDec.getValue("1778"), MutantToDec.getValue("1779"), 
                MutantToDec.getValue("177E"), MutantToDec.getValue("177F"), MutantToDec.getValue("1780"),MutantToDec.getValue("1781"),"Ventil na usisu pumpe br 1 NaOH");
    
        ventNaOHpotisPumpeBr1 = new PregradniVentili("13A0705", MutantToDec.getValue("1782"), MutantToDec.getValue("1783"), 
                MutantToDec.getValue("1788"), MutantToDec.getValue("1789"), MutantToDec.getValue("178A"),MutantToDec.getValue("178B"),"Ventil na potisu pumpe br 1 NaOH");
        
        ventNaOHusisPumpeBr2 = new PregradniVentili("13A0801", MutantToDec.getValue("178C"), MutantToDec.getValue("178D"), 
                MutantToDec.getValue("1792"), MutantToDec.getValue("1793"), MutantToDec.getValue("1794"),MutantToDec.getValue("1795"),"Ventil na usisu pumpe br 2 NaOH");
        
        ventNaOHpotisPumpeBr2 = new PregradniVentili("13A0805", MutantToDec.getValue("1796"), MutantToDec.getValue("1797"), 
                MutantToDec.getValue("179C"), MutantToDec.getValue("179D"), MutantToDec.getValue("179E"),MutantToDec.getValue("179F"),"Ventil na potisu pumpe br 2 NaOH");
        
        ventNaOHzajednickiUsis = new PregradniVentili("13A0001", MutantToDec.getValue("1800"), MutantToDec.getValue("1801"), 
                MutantToDec.getValue("1806"), MutantToDec.getValue("1807"), MutantToDec.getValue("1808"),MutantToDec.getValue("1809"),"Ventil zajednički usis za obe pumpe NaOH");
        
        ventNaOHzajednickiPotis = new PregradniVentili("13A0005", MutantToDec.getValue("180A"), MutantToDec.getValue("180B"), 
                MutantToDec.getValue("1810"), MutantToDec.getValue("1811"), MutantToDec.getValue("1812"),MutantToDec.getValue("1813"),"Ventil zajednički usis za obe pumpe NaOH");
    }

    public RegulacioniVentili getRegVentHCl() {
        return regVentHCl;
    }

    public RegulacioniVentili getRegVentNaOH() {
        return regVentNaOH;
    }

    public PregradniVentili getVentHCLusisPumpeBr1() {
        return ventHCLusisPumpeBr1;
    }

    public PregradniVentili getVentHCLpotisPumpeBr1() {
        return ventHCLpotisPumpeBr1;
    }

    public PregradniVentili getVentHCLusisPumpeBr2() {
        return ventHCLusisPumpeBr2;
    }

    public PregradniVentili getVentHCLpotisPumpeBr2() {
        return ventHCLpotisPumpeBr2;
    }

    public PregradniVentili getVentHCLzajednickiUsis() {
        return ventHCLzajednickiUsis;
    }

    public PregradniVentili getVentHCLzajednickiPotis() {
        return ventHCLzajednickiPotis;
    }

    public PregradniVentili getVentNaOHusisPumpeBr1() {
        return ventNaOHusisPumpeBr1;
    }

    public PregradniVentili getVentNaOHpotisPumpeBr1() {
        return ventNaOHpotisPumpeBr1;
    }

    public PregradniVentili getVentNaOHusisPumpeBr2() {
        return ventNaOHusisPumpeBr2;
    }

    public PregradniVentili getVentNaOHpotisPumpeBr2() {
        return ventNaOHpotisPumpeBr2;
    }

    public PregradniVentili getVentNaOHzajednickiUsis() {
        return ventNaOHzajednickiUsis;
    }

    public PregradniVentili getVentNaOHzajednickiPotis() {
        return ventNaOHzajednickiPotis;
    }
 
    
}
